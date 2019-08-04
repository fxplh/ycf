package com.lh.price.service;

import com.lh.food.entity.Food;
import com.lh.util.PriceFood;

import java.util.List;

/**
 * Created by Administrator on 2019/5/29.
 */
public interface PriceService {

    public List<Food> getFoodPriceByName(String name);

    public List<PriceFood> getPriceFood(int index,int num);

    public int getPriceFoodCount();
}
