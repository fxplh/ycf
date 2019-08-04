package com.lh.foodstep.service;

import com.lh.foodstep.entity.Foodstep;

import java.util.List;

/**
 * Created by Administrator on 2019/5/30.
 */
public interface FoodstepService {

    public List<Foodstep> getFoodStep(String foodId);
}
