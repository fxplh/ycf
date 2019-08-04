package com.lh.user.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.lh.food.entity.Food;
import com.lh.user.entity.User;
import com.lh.user.service.UserService;
import com.lh.userCollection.service.UserCollectionService;
import org.apache.catalina.core.ApplicationContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2019/5/8.
 */

@Controller
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private UserCollectionService userCollectionService;
    /*@Autowired
    private RedisTemplate<String, Object> redisTemplate;*/

    @RequestMapping("/user")
    public JSONObject getUser(String id){
        User user = userService.getUser(id);
       // JSONObject jsonObject = (JSONObject)JSONObject.toJSON(user);
        JSONObject jsonObject = JSONObject.parseObject(JSON.toJSONString(user));
        return jsonObject;
    }

    @ResponseBody
    @RequestMapping("/login/wxLogin")
    public JSONObject wxLogin(@RequestParam(required = true) String code){
        User user = userService.wxLogin(code);
        Map<String,String> map = new HashMap<>();
        if(user!=null){
            map.put("info","success");
            map.put("rdsession",user.getRdSession());
        }else{
            map.put("info","error");
        }
        JSONObject jsonObject = (JSONObject)JSONObject.toJSON(map);
        return jsonObject;
    }

    @ResponseBody
    @RequestMapping("/user/wxUserInfo")
    public JSONObject wxUserInfo(@RequestParam(required = true) String encryptedData,String iv,String rdsession){
        JSONObject jsonObject = userService.wxUserInfo(encryptedData, iv, rdsession);
        return jsonObject;
    }

    @ResponseBody
    @RequestMapping("/user/setUserInfo")
    public JSONObject setUserInfo(@RequestParam(required = true) String rdsession ,String email ,String password){
        Map<String,String> map = new HashMap<>();
        String info = userService.setUserInfo(rdsession, email, password);
        map.put("info",info);
        JSONObject jsonObject = (JSONObject)JSONObject.toJSON(map);
        return jsonObject;
    }

    @ResponseBody
    @RequestMapping("/user/updatePassword")
    public JSONObject updatePassword(@RequestParam(required = true) String rdsession ,String password){
        Map<String,String> map = new HashMap<>();
        String info = userService.updatePassword(rdsession, password);
        map.put("info",info);
        JSONObject jsonObject = (JSONObject)JSONObject.toJSON(map);
        return jsonObject;
    }

    @ResponseBody
    @RequestMapping("/user/getHistory")
    public JSONObject getHistory(String rdsession){
        User user = userService.getHistory(rdsession);
        Map<String,String> map = new HashMap<>();
        if(user!=null){
            map.put("info","success");
            if(user.getHistorylist()!=null && !"".equals(user.getHistorylist().trim())){
                map.put("list",user.getHistorylist());
            }else{
                map.put("info","fail");
            }
        }else{
            map.put("info","fail");
        }
        JSONObject jsonObject = (JSONObject)JSONObject.toJSON(map);
        return jsonObject;
    }

    @ResponseBody
    @RequestMapping("/user/addHistory")
    public JSONObject addHistory(String rdsession,String content){
        String history = userService.addHistory(rdsession,content);
        Map<String,String> map = new HashMap<>();
        if(history != null){
            map.put("info","success");
            map.put("list",history);
        }else{
            map.put("info","fail");
            map.put("list","");
        }
        JSONObject jsonObject = (JSONObject)JSONObject.toJSON(map);
        return jsonObject;
    }

    @ResponseBody
    @RequestMapping("/user/clearHistory")
    public JSONObject clearHistory(String rdsession,String content){
        String info = userService.clearHistory(rdsession);
        Map<String,String> map = new HashMap<>();
        map.put("info",info);
        JSONObject jsonObject = (JSONObject)JSONObject.toJSON(map);
        return jsonObject;
    }

    @RequestMapping("/userLogin")
    public String userLogin(HttpServletRequest request){
        Cookie[] cookies = request.getCookies();
        String isLogin = "";
        System.out.println(cookies);
        for(Cookie cookie : cookies){
            if("isLogin".equals(cookie.getName())){
                isLogin = cookie.getValue();
            }
        }
        if("true".equals(isLogin)){
            return "/WEB-INF/jsp/userInfo.jsp";
        }
        return "/WEB-INF/jsp/userLogin.jsp";
    }

    @RequestMapping("/user/login")
    public String login(String name,String password,HttpServletRequest request, HttpServletResponse response){
        User user = userService.login(name, password);
        //登录成功
        if(user!=null){
            /*redisTemplate.setValueSerializer(new Jackson2JsonRedisSerializer<>(User.class));
            redisTemplate.opsForValue().set("user",user);*/
            //1.创建Cookie
            Cookie userNameCookie=new Cookie("userName",name);
            //Cookie passwordCookie=new Cookie("password",password);
            Cookie rdSessionCookie=new Cookie("rdSession",user.getRdSession());
            Cookie isLoginCookie=new Cookie("isLogin","true");
            //2.设置时间 时间的单位秒 10  默认的时间一次会话
            userNameCookie.setMaxAge(3*60);
            //passwordCookie.setMaxAge(10*24*60*60);
            rdSessionCookie.setMaxAge(3*60);
            isLoginCookie.setMaxAge(3*60);
            //将userNameCookie 和passwordCookie删除
            /*userNameCookie.setMaxAge(0);
            passwordCookie.setMaxAge(0);*/
            //3.设置范围  当前应用
            String path="/";
            System.out.println("path"+path);
            userNameCookie.setPath(path);
            //passwordCookie.setPath(path);
            rdSessionCookie.setPath(path);
            isLoginCookie.setPath(path);
            //4.添加cookie
            response.addCookie(userNameCookie);
            //response.addCookie(passwordCookie);
            response.addCookie(rdSessionCookie);
            response.addCookie(isLoginCookie);
            return "redirect:/userLogin";
        }
        request.setAttribute("info","name or pass is error");
        return "/WEB-INF/jsp/userLogin.jsp";
    }

    @RequestMapping("/user/back")
    public String back(HttpServletRequest request, HttpServletResponse response){
        Cookie[] cookies = request.getCookies();
        String isLogin = "";
        String rdSession = "";
        String userName = "";
        System.out.println(cookies);
        for(int i=0;i<cookies.length;i++){
            if("isLogin".equals(cookies[i].getName())){
                isLogin = cookies[i].getValue();
                Cookie cookieCopy = new Cookie("isLogin","false");
                cookieCopy.setMaxAge(0);
                cookieCopy.setPath("/");
                response.addCookie(cookieCopy);
            }
            if("userName".equals(cookies[i].getName())){
                Cookie cookieCopy = new Cookie("userName",null);
                cookieCopy.setMaxAge(0);
                cookieCopy.setPath("/");
                response.addCookie(cookieCopy);
            }
            if("rdSession".equals(cookies[i].getName())){
                Cookie cookieCopy = new Cookie("rdSession",null);
                cookieCopy.setMaxAge(0);
                cookieCopy.setPath("/");
                response.addCookie(cookieCopy);
            }
        }
        return "redirect:/userLogin";
    }

    @ResponseBody
    @RequestMapping("/user/wyGetUserInfo")
    public JSONObject wyGetUserInfo(HttpServletRequest request){
        Cookie[] cookies = request.getCookies();
        String rdSession = "";
        String isLogin = "";
        Map<String,Object> map = new HashMap<>();
        for(Cookie cookie : cookies){
            System.out.println(cookie.getName());
            if("rdSession".equals(cookie.getName())){
                rdSession = cookie.getValue();
            }
            if("isLogin".equals(cookie.getName())){
                isLogin = cookie.getValue();
            }
        }
        if(!"".equals(rdSession) && !"".equals(isLogin)){
            map.put("info","success");
            User user = userService.wyGetUserInfo(rdSession);
            List<Food> foods = userCollectionService.getUserCollection(rdSession);
            map.put("user",user);
            map.put("foods",foods);
        }else{
            map.put("info","fail");
        }
        JSONObject jsonObject = (JSONObject)JSONObject.toJSON(map);
        return jsonObject;
    }
}
