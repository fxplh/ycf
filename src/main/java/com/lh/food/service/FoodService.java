package com.lh.food.service;

import com.lh.food.entity.Food;

import java.util.List;

/**
 * Created by Administrator on 2019/5/11.
 */
public interface FoodService {

    public Food getById(String id);

    public List<Food> getByClasssId(String fcId,int index,int num);

    public int getByClasssIdCount(String fcId);

    public List<Food> getByParentId(String parentId,int index,int num);

    public int getByParentIdCount(String parentId);

    public List<Food> getBySearch(String content,int index,int num);

    public int getBySearchCount(String content);

    public List<Food> randFood();

}
