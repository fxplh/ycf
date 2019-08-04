package com.lh.foodstep.service.impl;

import com.lh.foodstep.dao.FoodstepCopyMapper;
import com.lh.foodstep.dao.FoodstepMapper;
import com.lh.foodstep.entity.Foodstep;
import com.lh.foodstep.service.FoodstepService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Administrator on 2019/5/30.
 */
@Service
public class FoodstepServiceImpl implements FoodstepService{

    @Resource
    FoodstepMapper foodstepMapper;
    @Override
    public List<Foodstep> getFoodStep(String foodId){
        return foodstepMapper.selectByFoodId(foodId);
    }
}
