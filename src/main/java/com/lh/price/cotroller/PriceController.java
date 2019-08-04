package com.lh.price.cotroller;

import com.alibaba.fastjson.JSONObject;
import com.lh.food.entity.Food;
import com.lh.price.service.PriceService;
import com.lh.util.Page;
import com.lh.util.PriceFood;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2019/5/29.
 */

@Controller
public class PriceController {

    @Autowired
    PriceService priceService;

    @ResponseBody
    @RequestMapping("/price/getPriceFood")
    public JSONObject getPriceFood(String name){
        List<Food> foodPrice = priceService.getFoodPriceByName(name);
        Map<String,Object> map = new HashMap<>();
        if(foodPrice!=null && foodPrice.size()>0){
            map.put("info","success");
            map.put("foodPrice",foodPrice);
        }else{
            map.put("info","fail");
            map.put("foodPrice","");
        }
        JSONObject jsonObject = (JSONObject)JSONObject.toJSON(map);
        return jsonObject;
    }

    @ResponseBody
    @RequestMapping("/foodShicai/wxGetShicai")
    public JSONObject wxGetShicai(int index,int num){
        List<PriceFood> priceFoods = priceService.getPriceFood(index,num);
        Map<String,Object> map = new HashMap<>();
        if(priceFoods!=null && priceFoods.size()>0){
            map.put("info","success");
            map.put("priceFoods",priceFoods);
        }else{
            map.put("info","fail");
            map.put("priceFoods","");
        }
        JSONObject jsonObject = (JSONObject)JSONObject.toJSON(map);
        return jsonObject;
    }

    @RequestMapping("/foodShicai/wyGetShicai")
    public String wyGetShicai(@RequestParam(defaultValue = "1" )int currPage, HttpServletRequest request){
        Page page = new Page();
        int count = 0;
        page.setCurrPage(currPage);
        List<PriceFood> priceFoods = priceService.getPriceFood((page.getCurrPage()-1)*page.getSize(), page.getSize());
        count = priceService.getPriceFoodCount();
        page.setCount(count);
        request.setAttribute("priceFoods",priceFoods);
        request.setAttribute("page",page);
        return "/WEB-INF/jsp/shicai.jsp";
    }
}
