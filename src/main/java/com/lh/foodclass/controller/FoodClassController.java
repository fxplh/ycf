package com.lh.foodclass.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.lh.food.entity.Food;
import com.lh.food.service.FoodService;
import com.lh.foodclass.entity.Foodclass;
import com.lh.foodclass.entity.FoodclassCopy;
import com.lh.foodclass.service.FoodClassService;
import com.lh.util.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2019/5/10.
 */
@Controller
public class FoodClassController {

    @Resource
    FoodClassService foodClassService;
    @Resource
    FoodService foodService;

    @ResponseBody
    @RequestMapping("/foodClass")
    public JSONArray getZaoCan(@RequestParam(required = true) String names){
        String[] nameArr = names.split(",");
        List<String> nameList = new ArrayList<String>();
        for(String name : nameArr){
            nameList.add(name);
        }
        List<Foodclass> foodClass = new ArrayList<Foodclass>();
        foodClass = foodClassService.selectByclassNames(nameList);
        JSONArray json = (JSONArray)JSONArray.toJSON(foodClass);
        return json;
    }

    @ResponseBody
    @RequestMapping("/foodClass/getMenu")
    public JSONArray getMen(){
        List<FoodclassCopy> menuList = foodClassService.getMenu();
        JSONArray json = (JSONArray)JSONArray.toJSON(menuList);
        return json;
    }

    @RequestMapping("/foodClass/foodList")
    public String foodList(String id, HttpServletRequest request,@RequestParam(defaultValue = "1" ) int currPage){
        String parentId = foodClassService.isParentClass(id);
        List<FoodclassCopy> foodClassList = new ArrayList<>();
        List<Food> foodList = new ArrayList<>();
        String childId = "";
        Page page = new Page();
        int count = 0;
        page.setCurrPage(currPage);
        //如果为父类id
        if(parentId == null){
            foodClassList = foodClassService.getFoodClassList(id);
            foodList = foodService.getByParentId(id, (page.getCurrPage()-1)*page.getSize(), page.getSize());
            count = foodService.getByParentIdCount(id);
        }else{
            foodClassList = foodClassService.getFoodClassList(parentId);
            foodList = foodService.getByClasssId(id, (page.getCurrPage()-1)*page.getSize(), page.getSize());
            count = foodService.getByClasssIdCount(id);
            childId = id;
        }
        page.setCount(count);
        request.setAttribute("foodClassList",foodClassList);
        request.setAttribute("foodList",foodList);
        request.setAttribute("childId",childId);
        request.setAttribute("page",page);
        request.setAttribute("id",id);
        return "/WEB-INF/jsp/foodList.jsp";
    }
}
