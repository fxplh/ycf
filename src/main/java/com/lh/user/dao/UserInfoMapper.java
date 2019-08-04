package com.lh.user.dao;

import com.lh.user.entity.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * Created by Administrator on 2019/5/8.
 */

@Mapper
public interface UserInfoMapper {

    User selectByPrimaryKey(String id);

    User selectByOpenId(String openId);

    User selectByRdSession(String rdsession);

    int insert(User record);

    int updateByPrimaryKey(User record);

    User selectByPhone(String phone);
}
