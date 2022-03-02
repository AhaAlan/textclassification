package com.lacoders.textclassification.service;

import com.lacoders.textclassification.dao.model.CommentPO;
import com.lacoders.textclassification.dao.model.UserPO;

public interface CommentOperateService {

    Integer addComment(CommentPO commentPO);

    Integer updateComment(CommentPO commentPO);

    CommentPO queryDetailById(Integer commentId);
}
