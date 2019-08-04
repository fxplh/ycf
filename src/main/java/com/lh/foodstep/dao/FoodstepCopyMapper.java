package com.lh.foodstep.dao;

import com.lh.foodstep.entity.Foodstep;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * Created by Administrator on 2019/6/1.
 */
public interface FoodstepCopyMapper {

    List<Foodstep> selectByFoodId(String foodId);
}
