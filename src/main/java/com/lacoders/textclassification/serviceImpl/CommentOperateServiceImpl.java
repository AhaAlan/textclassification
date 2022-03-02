package com.lacoders.textclassification.serviceImpl;

import com.lacoders.textclassification.dao.mapper.CommentMapper;
import com.lacoders.textclassification.dao.model.CommentPO;
import com.lacoders.textclassification.service.CommentOperateService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class CommentOperateServiceImpl implements CommentOperateService {

    @Resource
    private CommentMapper commentMapper;
    @Override
    public Integer addComment(CommentPO commentPO) {
        commentMapper.insert(commentPO);
        return commentPO.getCommentId();
    }

    @Override
    public Integer updateComment(CommentPO commentPO) {
        commentMapper.updateByPrimaryKey(commentPO);
        return commentPO.getCommentId();
    }

    @Override
    public CommentPO queryDetailById(Integer commentId) {
        return commentMapper.selectByPrimaryKey(commentId);
    }
}
