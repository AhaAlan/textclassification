package com.lacoders.textclassification.serviceImpl;

import com.lacoders.textclassification.dao.mapper.NewsMapper;
import com.lacoders.textclassification.dao.mapper.UserMapper;
import com.lacoders.textclassification.dao.model.NewsPO;
import com.lacoders.textclassification.dao.model.UserPO;
import com.lacoders.textclassification.service.UserOperateService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserOperateServiceImpl implements UserOperateService {
    @Resource
    private UserMapper userMapper;

    @Override
    public Integer addUser(UserPO userPO) {
        userMapper.insert(userPO);
        return userPO.getUserId();
    }

    @Override
    public Integer updateUser(UserPO userPO) {
        userMapper.updateByPrimaryKey(userPO);
        return userPO.getUserId();
    }

    @Override
    public UserPO queryDetailById(Integer userId) {
        return userMapper.selectByPrimaryKey(userId);
    }
}
