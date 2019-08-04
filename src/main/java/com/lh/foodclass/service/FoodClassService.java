package com.lh.foodclass.service;

import com.lh.foodclass.entity.Foodclass;
import com.lh.foodclass.entity.FoodclassCopy;

import java.util.List;

/**
 * Created by Administrator on 2019/5/10.
 */
public interface FoodClassService {

    public List<Foodclass> selectByclassNames(List<String> list);

    public List<FoodclassCopy> getMenu();

    public List<FoodclassCopy> getFoodClassList(String id);

    public String isParentClass(String id);
}
