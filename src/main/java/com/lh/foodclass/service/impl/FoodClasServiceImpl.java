package com.lh.foodclass.service.impl;

import com.lh.foodclass.dao.FoodclassInfoMapper;
import com.lh.foodclass.entity.Foodclass;
import com.lh.foodclass.entity.FoodclassCopy;
import com.lh.foodclass.service.FoodClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2019/5/10.
 */
@Service
public class FoodClasServiceImpl implements FoodClassService {

    @Autowired
    FoodclassInfoMapper foodclassInfoMapper;
    @Override
    public List<Foodclass> selectByclassNames(List<String> list){
        return foodclassInfoMapper.selectByclassNames(list);
    }

    @Override
    public List<FoodclassCopy> getMenu(){
        List<Foodclass> parentFoodClass = foodclassInfoMapper.selectByParentId(null);
        List<FoodclassCopy> foodclassCopyList = new ArrayList<>();
        if(parentFoodClass!=null && parentFoodClass.size()>0){
            for(int i=0;i<parentFoodClass.size();i++){
                List<Foodclass> childClass = new ArrayList<>();
                childClass = foodclassInfoMapper.selectByParentId(parentFoodClass.get(i).getId());
                FoodclassCopy foodclassCopy = new FoodclassCopy();
                if(childClass!=null){
                    foodclassCopy.setChildClass(childClass);
                }
                foodclassCopy.setId(parentFoodClass.get(i).getId());
                foodclassCopy.setIshot(parentFoodClass.get(i).getIshot());
                foodclassCopy.setName(parentFoodClass.get(i).getName());
                foodclassCopy.setPhoto(parentFoodClass.get(i).getPhoto());
                foodclassCopyList.add(foodclassCopy);
            }
        }
        return foodclassCopyList;
    }

    @Override
    public List<FoodclassCopy> getFoodClassList(String id){
        List<Foodclass> parentFoodClass = foodclassInfoMapper.selectByParentId(null);
        List<FoodclassCopy> foodclassCopyList = new ArrayList<>();
        if(parentFoodClass!=null && parentFoodClass.size()>0){
            for(int i=0;i<parentFoodClass.size();i++){
                FoodclassCopy foodclassCopy = new FoodclassCopy();
                if(id.equals(parentFoodClass.get(i).getId())){
                    List<Foodclass> childClass = new ArrayList<>();
                    childClass = foodclassInfoMapper.selectByParentId(parentFoodClass.get(i).getId());
                    if(childClass!=null){
                        foodclassCopy.setChildClass(childClass);
                    }
                }
                foodclassCopy.setId(parentFoodClass.get(i).getId());
                foodclassCopy.setIshot(parentFoodClass.get(i).getIshot());
                foodclassCopy.setName(parentFoodClass.get(i).getName());
                foodclassCopy.setPhoto(parentFoodClass.get(i).getPhoto());
                foodclassCopyList.add(foodclassCopy);
            }
        }
        return foodclassCopyList;
    }

    @Override
    public String isParentClass(String id){
        Foodclass foodclass = foodclassInfoMapper.selectByPrimaryKey(id);
        if(foodclass!=null && foodclass.getParentid()!=null && !"".equals(foodclass.getParentid())){
            return foodclass.getParentid();
        }
        return null;
    }
}
