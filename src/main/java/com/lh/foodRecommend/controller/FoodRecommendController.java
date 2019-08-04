package com.lh.foodRecommend.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.lh.food.entity.Food;
import com.lh.foodRecommend.service.FoodRecommendService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by Administrator on 2019/5/11.
 */

@Controller
public class FoodRecommendController {

    @Resource
    FoodRecommendService foodRecommendService;

    @ResponseBody
    @RequestMapping("/foodRecommend")
    public JSONObject getFoodByReId(@RequestParam(required = true) String frId){
        Food food = foodRecommendService.getFoodByReId(frId);
        JSONObject jsonObject = (JSONObject)JSONObject.toJSON(food);
        return jsonObject;
    }

    @ResponseBody
    @RequestMapping("/foodRecommend/wxGetFoodRe")
    public JSONArray wxGetFoodRe(){
        List<Food> foods = foodRecommendService.getFoodRe();
        JSONArray jsonArray = (JSONArray) JSONArray.toJSON(foods);
        return jsonArray;
    }

    @RequestMapping("/foodRecommend/getFoodRe")
    public String getFoodRe(HttpServletRequest request){
        List<Food> foods = foodRecommendService.getFoodRe();
        request.setAttribute("foods",foods);
        return "/WEB-INF/jsp/index.jsp";
    }

}
