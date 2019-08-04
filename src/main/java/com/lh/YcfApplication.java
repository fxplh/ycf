package com.lh;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.lh.user.dao.*,com.lh.foodclass.dao.*,com.lh.food.dao.*,com.lh.foodRecommend.dao.*,com.lh.userCollection.dao.*,com.lh.userCollection.dao.*,com.lh.price.dao.*,com.lh.hotfood.dao.*,com.lh.foodstep.dao.*")
public class YcfApplication {

	public static void main(String[] args) {
		SpringApplication.run(YcfApplication.class, args);
	}
}
