package com.lh.userCollection.service;

import com.lh.food.entity.Food;

import java.util.List;

/**
 * Created by Administrator on 2019/5/26.
 */
public interface UserCollectionService {

    public String isCollect(String rdSession,String foodId);

    public String addCollect(String rdSession,String foodId);

    public List<Food> getUserCollection(String rdSession);
}
