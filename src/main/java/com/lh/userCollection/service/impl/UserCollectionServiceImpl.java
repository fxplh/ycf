package com.lh.userCollection.service.impl;

import com.lh.food.entity.Food;
import com.lh.user.dao.UserInfoMapper;
import com.lh.user.entity.User;
import com.lh.userCollection.dao.UserCollectionMapper;
import com.lh.userCollection.entity.UserCollection;
import com.lh.userCollection.service.UserCollectionService;
import com.lh.util.Util;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.UUID;

/**
 * Created by Administrator on 2019/5/26.
 */

@Service
public class UserCollectionServiceImpl implements UserCollectionService {

    @Resource
    UserCollectionMapper userCollectionMapper;
    @Resource
    UserInfoMapper userInfoMapper;
    @Override
    public String isCollect(String rdSession,String foodId){
        User user = userInfoMapper.selectByRdSession(rdSession);
        System.out.println(rdSession);
        if(user != null){
            UserCollection userCollection = userCollectionMapper.selectByUserIdAndFoodId(user.getId(),foodId);
            if (userCollection != null ) {
                return "success";
            }
        }else{
            return "notLogin";
        }
        return "fail";
    }

    @Override
    public String addCollect(String rdSession,String foodId){
        User user = userInfoMapper.selectByRdSession(rdSession);
        if(user != null){
            UserCollection userCollection = null;
            userCollection = userCollectionMapper.selectByUserIdAndFoodId(user.getId(),foodId);
            if(userCollection != null){
                int i = userCollectionMapper.deleteByPrimaryKey(userCollection.getId());
                if(i>0){
                    return "fail";
                }
                return "error";
            }
            userCollection = new UserCollection();
            String uuid_key = UUID.randomUUID().toString();
            uuid_key = uuid_key.replaceAll("-","");
            userCollection.setId(uuid_key);
            userCollection.setFkUserId(user.getId());
            userCollection.setFkFoodId(foodId);
            userCollection.setCollectiondate(Util.getNowDate());
            int insert = userCollectionMapper.insert(userCollection);
            System.out.println(insert);
            if(insert>0){
                return "success";
            }
            return "error";
        }else{
            return "notLogin";
        }
    }

    @Override
    public List<Food> getUserCollection(String rdSession){
        User user = userInfoMapper.selectByRdSession(rdSession);
        if(user != null) {
            return userCollectionMapper.selectByUserId(user.getId());
        }
        return null;
    }
}
