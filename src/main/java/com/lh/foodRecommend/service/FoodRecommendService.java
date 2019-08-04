package com.lh.foodRecommend.service;

import com.lh.food.entity.Food;

import java.util.List;

/**
 * Created by Administrator on 2019/5/11.
 */

public interface FoodRecommendService {

    public Food getFoodByReId(String frId);

    public List<Food> getFoodRe();
}
