package com.lacoders.textclassification.service;

import com.lacoders.textclassification.dao.model.NewsPO;
import com.lacoders.textclassification.dao.model.UserPO;

public interface UserOperateService {

        Integer addUser(UserPO userPO);

        Integer updateUser(UserPO userPO);

        UserPO queryDetailById(Integer userId);
}

