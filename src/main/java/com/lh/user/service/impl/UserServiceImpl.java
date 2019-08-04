package com.lh.user.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.lh.user.dao.UserInfoMapper;
import com.lh.user.entity.User;
import com.lh.user.service.UserService;
import com.lh.util.Util;
import com.sun.org.apache.xerces.internal.impl.dv.util.Base64;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.security.AlgorithmParameters;
import java.security.Security;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by Administrator on 2019/5/8.
 */

@Service
public class UserServiceImpl implements UserService{
    private static String appid = "wx05919affe79e1381";
    private static String secret = "6d37ad04fcb70c11a5c584038c7b7fb9";
    @Autowired
    private UserInfoMapper userInfoMapper;


    @Override
    public User getUser(String id) {
        return userInfoMapper.selectByPrimaryKey(id);
    }

    @Override
    public User wxLogin(String code){
        String openId = "";
        String session_key = "";
        String uuid_key = "";
        String wxUrl = "https://api.weixin.qq.com/sns/jscode2session?appid="+appid+"&secret="+secret+"&js_code="+code+"&grant_type=authorization_code";
        HttpURLConnection connection = null;
        try {
            URL url = new URL(wxUrl);
            connection = (HttpURLConnection)url.openConnection();
            connection.setRequestMethod("GET");
            connection.setConnectTimeout(3000);
            // 超时时间
            connection.setConnectTimeout(3000);
             // 设置是否输出
             connection.setDoOutput(true);
             // 设置是否读入
            connection.setDoInput(true);
            // 设置是否使用缓存
            connection.setUseCaches(false);
            // 设置此 HttpURLConnection 实例是否应该自动执行 HTTP 重定向
            connection.setInstanceFollowRedirects(true);
            // 设置使用标准编码格式编码参数的名-值对
            connection.setRequestProperty("Content-Type","application/x-www-form-urlencoded");
            // 连接
            connection.connect();
            String msg = "";
            int requestCode = connection.getResponseCode();
            if (requestCode == 200) {
                BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                String line;
                while ((line = reader.readLine()) != null) {
                    msg += line + "\n";
                }
                reader.close();
                JSONObject jsonObject = (JSONObject)JSONObject.parse(msg);
                if(jsonObject.containsKey("session_key")){
                    System.out.println("微信调用成功");
                    System.out.println("json数据包==>"+jsonObject.toString());
                    openId = jsonObject.get("openid").toString();
                    session_key = jsonObject.get("session_key").toString();
                    User user = userInfoMapper.selectByOpenId(openId);
                    uuid_key = UUID.randomUUID().toString();
                    uuid_key = uuid_key.replaceAll("-","");
                    if(user == null ) {
                        user = new User();
                        user.setId(uuid_key);
                        user.setOpenid(openId);
                        user.setRdSession(uuid_key);
                        user.setSessionkey(session_key);
                        user.setLastlogintime(Util.getNowDate());
                        userInfoMapper.insert(user);
                    }else{
                        user.setSessionkey(session_key);
                        userInfoMapper.updateByPrimaryKey(user);
                    }
                    return user;
                }else {
                    System.out.println("微信调用失败");
                    String errcode = jsonObject.get("errcode").toString();
                    if(errcode != null){
                        if("-1".equals(errcode)){
                            System.out.println("系统繁忙，此时请开发者稍候再试");
                        }else if("0".equals(errcode)){
                            System.out.println("请求成功");
                        }else if("-1".equals(errcode)){
                            System.out.println("code 无效 ");
                        }else if("-1".equals(errcode)){
                            System.out.println("频率限制，每个用户每分钟100次");
                        }
                    }
                    return null;
                }
            }else{
                System.out.println("请求失败");
                return null;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }finally {
            connection.disconnect();
        }
    }

    @Override
    public JSONObject wxUserInfo(String encryptedData,String iv,String rdsession){
        JSONObject jsonObject = null;
        Map<String,String> map = new HashMap<>();
        User user = userInfoMapper.selectByRdSession(rdsession);
        String city = "";
        String avatarUrl = "";
        String nickName = "";
        if(user!=null){
            jsonObject = (JSONObject)getUserInfo(encryptedData,user.getSessionkey(),iv);
            System.out.println(jsonObject);
            city = jsonObject.get("country").toString()+"-->"+jsonObject.get("province").toString()+"-->"+jsonObject.get("city").toString();
            avatarUrl = jsonObject.get("avatarUrl").toString();
            nickName = jsonObject.get("nickName").toString();
            user.setCity(city);
            user.setAvatarurl(avatarUrl);
            user.setName(nickName);
            userInfoMapper.updateByPrimaryKey(user);
            map.put("info","success");
            if(user.getPhone()!=null){
                map.put("haveEmail","true");
                map.put("email",user.getPhone());
            }else{
                map.put("haveEmail","false");
            }
            if(user.getPassword()!=null){
                map.put("havePass","true");
            }else{
                map.put("havePass","false");
            }
        }else{
            map.put("info","fail");
        }
        JSONObject json = (JSONObject)JSONObject.toJSON(map);
        System.out.println(jsonObject.toString());
        return json;
    }

    @Override
    public JSONObject wxGetPhone(String encryptedData, String iv, String rdsession){
        JSONObject jsonObject = null;
        User user = userInfoMapper.selectByRdSession(rdsession);
        if(user!=null){
            jsonObject = (JSONObject)getUserInfo(encryptedData,user.getSessionkey(),iv);
        }
        System.out.println(jsonObject.toString());
        return jsonObject;
    }

    /**
     * email在数据库中存入phone中
     */
    @Override
    public String setUserInfo(String rdsession, String email, String password){
        User user = userInfoMapper.selectByRdSession(rdsession);
        if(user!=null){
            user.setPhone(email);
            user.setPassword(password);
            int i = userInfoMapper.updateByPrimaryKey(user);
            if(i>0){
                return "success";
            }
        }
        return "fail";
    }

    @Override
    public String updatePassword(String rdsession, String password){
        User user = userInfoMapper.selectByRdSession(rdsession);
        if(user!=null){
            user.setPassword(password);
            int i = userInfoMapper.updateByPrimaryKey(user);
            if(i>0){
                return "success";
            }
        }
        return "fail";
    }

    @Override
    public User getHistory(String rdsession){
        return userInfoMapper.selectByRdSession(rdsession);
    }

    @Override
    public String addHistory(String rdsession,String content){
        User user = userInfoMapper.selectByRdSession(rdsession);
        String history = "";
        if(user.getHistorylist()!=null && !"".equals(user.getHistorylist())){
            String list[] = user.getHistorylist().split(";");
            Boolean flag = false;
            for(String s : list){
                if(s.equals(content)){
                    flag = true;
                }
            }
            if(!flag){
                history = user.getHistorylist()+";"+content;
            }else {
                history = user.getHistorylist();
            }
        }else{
            history = content;
        }
        user.setHistorylist(history);
        int i = userInfoMapper.updateByPrimaryKey(user);
        if(i>0){
            return history;
        }
        return null;
    }

    @Override
    public String clearHistory(String rdsession){
        User user = userInfoMapper.selectByRdSession(rdsession);
        if(user!=null){
            user.setHistorylist("");
            int i = userInfoMapper.updateByPrimaryKey(user);
            if(i>0){
                return "success";
            }
        }
        return "fail";
    }

    @Override
    public Object getUserInfo(String encryptedData, String session_key, String iv) {
        // 被加密的数据
        byte[] dataByte = Base64.decode(encryptedData);
        // 加密秘钥
        byte[] keyByte = Base64.decode(session_key);
        // 偏移量
        byte[] ivByte = Base64.decode(iv);
        try {
            // 如果密钥不足16位，那么就补足.  这个if 中的内容很重要
            int base = 16;
            if (keyByte.length % base != 0) {
                int groups = keyByte.length / base + (keyByte.length % base != 0 ? 1 : 0);
                byte[] temp = new byte[groups * base];
                Arrays.fill(temp, (byte) 0);
                System.arraycopy(keyByte, 0, temp, 0, keyByte.length);
                keyByte = temp;
            }
            // 初始化
            Security.addProvider(new BouncyCastleProvider());
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            SecretKeySpec spec = new SecretKeySpec(keyByte, "AES");
            AlgorithmParameters parameters = AlgorithmParameters.getInstance("AES");
            parameters.init(new IvParameterSpec(ivByte));
            cipher.init(Cipher.DECRYPT_MODE, spec, parameters);// 初始化
            byte[] resultByte = cipher.doFinal(dataByte);
            if (null != resultByte && resultByte.length > 0) {
                String result = new String(resultByte, "UTF-8");
                return JSONObject.parseObject(result);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public User login(String name,String password){
        User user = userInfoMapper.selectByPhone(name);
        if(user!=null){
            if(password.equals(user.getPassword())){
                return user;
            }
        }
        return null;
    }

    @Override
    public User wyGetUserInfo(String rdSession){
        return userInfoMapper.selectByRdSession(rdSession);
    }
}
