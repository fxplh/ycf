package com.lh.food.service.impl;

import com.lh.food.dao.FoodMapper;
import com.lh.food.entity.Food;
import com.lh.food.service.FoodService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Administrator on 2019/5/11.
 */
@Service
public class FoodServiceimpl implements FoodService {

    @Resource
    FoodMapper foodMapper;
    @Override
    public Food getById(String id){
        return foodMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<Food> getByClasssId(String fcId ,int index,int num){
        return foodMapper.selectByClassId(fcId,index,num);
    }
    @Override
    public List<Food> getByParentId(String parentId ,int index,int num){
        return foodMapper.selectByParentId(parentId,index,num);
    }

    @Override
    public List<Food> getBySearch(String content,int index,int num){
        return foodMapper.selectBySearch(content, index, num);
    }

    @Override
    public List<Food> randFood(){
        return  foodMapper.selectRandFood();
    }

    @Override
    public int getByClasssIdCount(String fcId){
        return foodMapper.selectByClassIdCount(fcId);
    }

    @Override
    public int getByParentIdCount(String parentId){
        return foodMapper.selectByParentIdCount(parentId);
    }

    @Override
    public int getBySearchCount(String content){
        return foodMapper.selectBySearchCount(content);
    }
}
