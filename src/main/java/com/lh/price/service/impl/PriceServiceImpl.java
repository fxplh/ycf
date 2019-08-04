package com.lh.price.service.impl;

import com.lh.food.dao.FoodMapper;
import com.lh.food.entity.Food;
import com.lh.price.dao.PriceMapper;
import com.lh.price.entity.Price;
import com.lh.price.service.PriceService;
import com.lh.util.PriceFood;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2019/5/29.
 */

@Service
public class PriceServiceImpl implements PriceService{

    @Resource
    PriceMapper priceMapper;

    @Resource
    FoodMapper foodMapper;
    @Override
    public List<Food> getFoodPriceByName(String name) {
        return  priceMapper.selectFoodPriceByClassName(name);
    }

    @Override
    public List<PriceFood> getPriceFood(int index,int num){
        List<Price> prices = priceMapper.selectAllLimit(index ,num);
        List<PriceFood> priceFoods = new ArrayList<>();
        if(prices!=null){
            for(Price price : prices){
                PriceFood priceFood = new PriceFood();
                Food food = foodMapper.selectByPrimaryKey(price.getFkFoodId());
                priceFood.setFoodId(food.getId());
                priceFood.setName(food.getName());
                priceFood.setPhoto(food.getPhoto());
                priceFood.setPrice(price.getPrice());
                priceFood.setInfo(food.getImtro());
                priceFoods.add(priceFood);
            }
        }
        return priceFoods;
    }

    @Override
    public int getPriceFoodCount(){
        return priceMapper.selectAllCount();
    }
}
