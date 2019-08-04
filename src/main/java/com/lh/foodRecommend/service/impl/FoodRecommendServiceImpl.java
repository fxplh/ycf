package com.lh.foodRecommend.service.impl;

import com.lh.food.entity.Food;
import com.lh.foodRecommend.dao.FoodRecommendMapper;
import com.lh.foodRecommend.service.FoodRecommendService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Administrator on 2019/5/11.
 */
@Service
public class FoodRecommendServiceImpl implements FoodRecommendService{

    @Resource
    FoodRecommendMapper foodrecommendMapper;

    @Override
    public Food getFoodByReId(String frId){
      return  foodrecommendMapper.selectFoodByReId(frId);
    }

    @Override
    public List<Food> getFoodRe(){
        return foodrecommendMapper.selectFoodReAll();
    }
}
