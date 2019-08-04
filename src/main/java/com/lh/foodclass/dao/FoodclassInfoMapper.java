package com.lh.foodclass.dao;

import com.lh.foodclass.entity.Foodclass;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by Administrator on 2019/5/10.
 */

@Mapper
public interface FoodclassInfoMapper {


    int deleteByPrimaryKey(String id);


    int insert(Foodclass record);


    Foodclass selectByPrimaryKey(String id);


    List<Foodclass> selectAll();


    int updateByPrimaryKey(Foodclass record);

    List<Foodclass> selectByclassNames(List<String> list);

    List<Foodclass> selectByParentId(@Param(value = "parentId") String parentId);
}
