package com.lh.foodstep.controller;

import com.alibaba.fastjson.JSONObject;
import com.lh.food.entity.Food;
import com.lh.food.service.FoodService;
import com.lh.foodstep.entity.Foodstep;
import com.lh.foodstep.service.FoodstepService;
import com.lh.userCollection.service.UserCollectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2019/5/30.
 */

@Controller
public class FoodstepController {

    @Autowired
    FoodstepService foodstepService;
    @Autowired
    FoodService foodService;
    @Autowired
    UserCollectionService userCollectionService;

    @RequestMapping("/foodstep/getFoodInfo")
    public String getFoodInfo(String id ,String rand ,HttpServletRequest request){
        Food food = foodService.getById(id);
        List<Foodstep> foodStepList = new ArrayList<>();
        List<String> tags = new ArrayList<>();
        Map<String,String> ingredients = new HashMap<>();
        Map<String,String> burden = new HashMap<>();
        String isCollect = "fail";
        if(food!=null){
            foodStepList = foodstepService.getFoodStep(food.getId());
            if(food.getIngredients()!=null && !"".equals(food.getIngredients())){
                String[] split = food.getIngredients().split(";");
                for(String s : split){
                    String[] split1 = s.split(",");
                    if(split1.length>1){
                        ingredients.put(split1[0],split1[1]);
                    }
                    ingredients.put(split1[0],"");
                }
            }
            if(food.getBurden()!=null && !"".equals(food.getBurden())){
                String[] split2 = food.getBurden().split(";");
                for(String s : split2){
                    String[] split3 = s.split(",");
                    if(split3.length>1){
                        burden.put(split3[0],split3[1]);
                    }
                    burden.put(split3[0],"");
                }
            }
            if(food.getTags()!=null && !"".equals(food.getTags())){
                for(String s1 : food.getTags().split(";")){
                    tags.add(s1);
                }
            }
            Cookie[] cookies = request.getCookies();
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
                isCollect = userCollectionService.isCollect(rdSession, food.getId());
            }
        }
        request.setAttribute("isCollect",isCollect);
        request.setAttribute("rand",rand);
        request.setAttribute("foodStepList",foodStepList);
        request.setAttribute("ingredients",ingredients);
        request.setAttribute("burden",burden);
        request.setAttribute("foodInfo",food);
        request.setAttribute("tags",tags);
        return "/WEB-INF/jsp/food.jsp";
    }

    @ResponseBody
    @RequestMapping("/foodStep/wxGetStep")
    public JSONObject wxGetStep(String foodId){
        List<Foodstep> foodStep = foodstepService.getFoodStep(foodId);
        System.out.println(foodStep.toString());
        Map<String,Object> map = new HashMap<>();
        if(foodStep!=null && foodStep.size()>0){
            map.put("info","success");
            map.put("foodStep",foodStep);
        }else{
            map.put("info","fail");
            map.put("foodStep","");
        }
        JSONObject jsonObject = (JSONObject)JSONObject.toJSON(map);
        return jsonObject;
    }
}
