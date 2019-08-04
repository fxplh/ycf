package com.lh.userCollection.controller;

import com.alibaba.fastjson.JSONObject;
import com.lh.food.entity.Food;
import com.lh.user.entity.User;
import com.lh.userCollection.service.UserCollectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2019/5/26.
 */

@RestController
public class UserCollectionController {
    @Autowired
    UserCollectionService userCollectionService;

    @RequestMapping("/userCollection/isCollect")
    public JSONObject isCollect( String rdsession, String foodId){
        Map<String,String> map = new HashMap<>();
        String info = userCollectionService.isCollect(rdsession, foodId);
        map.put("info",info);
        if("success".equals(info)){
            map.put("isCollect","true");
        }else {
            map.put("isCollect", "false");
        }
        JSONObject jsonObject = (JSONObject)JSONObject.toJSON(map);
        return jsonObject;
    }

    @RequestMapping("/userCollection/addCollect")
    public JSONObject addCollect(String rdsession, String foodId){
        Map<String,String> map = new HashMap<>();
        String info = userCollectionService.addCollect(rdsession, foodId);
        map.put("info",info);
        if("success".equals(info)){
            map.put("flag","true");
        }else {
            map.put("flag", "false");
        }
        JSONObject jsonObject = (JSONObject)JSONObject.toJSON(map);
        return jsonObject;
    }

    @RequestMapping("/userCollection/wyAddCollect")
    public JSONObject wyAddCollect(String foodId,HttpServletRequest request){
        System.out.println(foodId);
        Map<String,String> map = new HashMap<>();
        Cookie[] cookies = request.getCookies();
        String info = "";
        String isLogin = "";
        String rdSession = "";
        for(Cookie cookie : cookies){
            if("isLogin".equals(cookie.getName())){
                isLogin = cookie.getValue();
            }
            if("rdSession".equals(cookie.getName())){
                rdSession = cookie.getValue();
            }
        }
        if("true".equals(isLogin)){
            info = userCollectionService.addCollect(rdSession, foodId);
            map.put("info",info);
        }else{
            map.put("info","notLogin");
        }
        JSONObject jsonObject = (JSONObject)JSONObject.toJSON(map);
        return jsonObject;
    }

    @RequestMapping("/userCollection/getUserCollection")
    public JSONObject getUserCollection(String rdsession){
        Map<String,Object> map = new HashMap<>();
        List<Food> foods = userCollectionService.getUserCollection(rdsession);
        System.out.println(rdsession);
        if(foods !=null && foods.size()>0){
            map.put("info","success");
            map.put("foods",foods);
        }else {
            map.put("info","success");
            map.put("foods","null");
        }
        JSONObject jsonObject = (JSONObject)JSONObject.toJSON(map);
        return jsonObject;
    }
}
