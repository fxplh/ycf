package com.lh.hotfood.controller;

import com.alibaba.fastjson.JSONObject;
import com.lh.food.entity.Food;
import com.lh.hotfood.service.HotfoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2019/5/29.
 */
@Controller
public class HotfoodController {
    @Autowired
    HotfoodService hotfoodService;

    @ResponseBody
    @RequestMapping("/hotfood/getHotFood")
    public JSONObject getHotFood(){
        List<Food> foods = hotfoodService.getHotfood();
        Map<String,Object> map = new HashMap<>();
        if(foods!=null && foods.size()>0){
            map.put("info","success");
            map.put("foods",foods);
        }else{
            map.put("info","fail");
            map.put("foods","");
        }
        JSONObject jsonObject = (JSONObject)JSONObject.toJSON(map);
        return jsonObject;
    }
}
