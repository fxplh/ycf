package com.lh.hotfood.service.impl;

import com.lh.food.entity.Food;
import com.lh.hotfood.dao.HotfoodMapper;
import com.lh.hotfood.service.HotfoodService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Administrator on 2019/5/29.
 */
@Service
public class HotfoodServiceImpl implements HotfoodService{

    @Resource
    HotfoodMapper hotfoodMapper;
    @Override
    public List<Food> getHotfood(){
        return hotfoodMapper.selectHotFood();
    }
}
