package com.lh.food.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.lh.food.entity.Food;
import com.lh.food.service.FoodService;
import com.lh.util.Page;
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
public class FoodController {

    @Resource
    FoodService foodService;

    @ResponseBody
    @RequestMapping("/food")
    public JSONObject getById(@RequestParam (required = true) String id){
        Food food = foodService.getById(id);
        JSONObject jsonObject = (JSONObject)JSONObject.toJSON(food);
        return jsonObject;
    }

    @ResponseBody
    @RequestMapping("/food/getByClassId")
    public JSONArray getByClassId(@RequestParam (required = true) String fcId ,int index ,int num){
        List<Food> list = foodService.getByClasssId(fcId,index,num);
        JSONArray jsonArray = (JSONArray) JSONArray.toJSON(list);
        return jsonArray;
    }

    @ResponseBody
    @RequestMapping("/food/getBySearch")
    public JSONArray getBySearch(@RequestParam (required = true) String content ,int index ,int num){
        List<Food> list = foodService.getBySearch(content,index,num);
        JSONArray jsonArray = (JSONArray) JSONArray.toJSON(list);
        return jsonArray;
    }

    @RequestMapping("/food/wyGetBySearch")
    public String wyGetBySearch(HttpServletRequest request, String q,@RequestParam(defaultValue = "1" ) int currPage){
        Page page = new Page();
        int count = 0;
        page.setCurrPage(currPage);
        List<Food> foodList = foodService.getBySearch(q,(page.getCurrPage()-1)*page.getSize(), page.getSize());
        count = foodService.getBySearchCount(q);
        page.setCount(count);
        request.setAttribute("foodList",foodList);
        request.setAttribute("page",page);
        request.setAttribute("q",q);
        return "/WEB-INF/jsp/search.jsp";
    }

    @ResponseBody
    @RequestMapping("/food/randFood")
    public JSONArray randFood(){
        List<Food> list = foodService.randFood();
        JSONArray jsonArray = (JSONArray) JSONArray.toJSON(list);
        return jsonArray;
    }

    @RequestMapping("/food/wyRandFood")
    public String wyRandFood(HttpServletRequest request){
        List<Food> list = foodService.randFood();
        if(list.size()>0){
            return "redirect:/foodstep/getFoodInfo?id="+list.get(0).getId()+"&rand=yes";
        }
        request.setAttribute("noFood","true");
        return  "/WEB-INF/jsp/food.jsp";
    }
}
