package com.lh.food.dao;

import com.lh.food.entity.Food;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


@Mapper
public interface FoodMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table food
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table food
     *
     * @mbg.generated
     */
    int insert(Food record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table food
     *
     * @mbg.generated
     */
    Food selectByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table food
     *
     * @mbg.generated
     */
    List<Food> selectAll();

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table food
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(Food record);

    List<Food> selectByClassId(String fcId,int index,int num);

    int selectByClassIdCount(String fcId);

    List<Food> selectByParentId(String parentId,int index,int num);

    int selectByParentIdCount(String parentId);

    List<Food> selectBySearch(String content,int index,int num);

    int selectBySearchCount(String content);

    List<Food> selectRandFood();

}