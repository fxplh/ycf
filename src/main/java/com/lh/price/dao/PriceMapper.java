package com.lh.price.dao;

import com.lh.food.entity.Food;
import com.lh.price.entity.Price;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PriceMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table price
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table price
     *
     * @mbg.generated
     */
    int insert(Price record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table price
     *
     * @mbg.generated
     */
    Price selectByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table price
     *
     * @mbg.generated
     */
    List<Price> selectAll();

    int selectAllCount();

    List<Price> selectAllLimit(int index,int num);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table price
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(Price record);

    List<Food> selectFoodPriceByClassName(String name);
}