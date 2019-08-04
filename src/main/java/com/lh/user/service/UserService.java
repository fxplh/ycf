package com.lh.user.service;

import com.alibaba.fastjson.JSONObject;
import com.lh.user.entity.User;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Administrator on 2019/5/8.
 */
public interface UserService {
    public User getUser(String id);

    public User wxLogin(String code);

    public JSONObject wxUserInfo(String encryptedData, String iv, String rdsession);

    public JSONObject wxGetPhone(String encryptedData, String iv, String rdsession);

    public String setUserInfo(String rdsession, String email, String password);

    public String updatePassword(String rdsession, String password);

    public Object getUserInfo(String encryptedData, String session_key, String iv);

    public User getHistory(String rdsession);

    public String addHistory(String rdsession,String content);

    public String clearHistory(String rdsession);

    public User login(String name,String password);

    public User wyGetUserInfo(String rdSession);
}
