package com.lh.foodAndfoodclass.dao;

import com.lh.foodAndfoodclass.entity.FoodFoodclass;
import java.util.List;

public interface FoodFoodclassMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table food_foodclass
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table food_foodclass
     *
     * @mbg.generated
     */
    int insert(FoodFoodclass record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table food_foodclass
     *
     * @mbg.generated
     */
    FoodFoodclass selectByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table food_foodclass
     *
     * @mbg.generated
     */
    List<FoodFoodclass> selectAll();

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table food_foodclass
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(FoodFoodclass record);
}