package com.lacoders.textclassification.converter;

import com.lacoders.textclassification.bean.dto.*;
import com.lacoders.textclassification.bean.vo.CommentDetailVO;
import com.lacoders.textclassification.bean.vo.NewsDetailVO;
import com.lacoders.textclassification.bean.vo.UserDetailVO;
import com.lacoders.textclassification.dao.model.CommentPO;
import com.lacoders.textclassification.dao.model.NewsPO;
import com.lacoders.textclassification.dao.model.UserPO;
import com.lacoders.textclassification.enums.NewsTypeEnum;

import java.text.ParseException;
import java.util.Date;
import java.util.Objects;

public class CommentConverter {
    public static CommentPO convertAddDTO2PO(AddCommentDTO dto) throws ParseException {
        Date date = new Date();
        CommentPO commentPO = new CommentPO();
        commentPO.setUserId(dto.getUserId());
        commentPO.setNewsId(dto.getNewsId());
        commentPO.setCommentTime(date);
        commentPO.setDeleted(dto.getDeleted());
        commentPO.setCommentContent(dto.getCommentContent());
        return commentPO;
    }

    public static CommentPO convertUpdateDTO2PO(UpdateCommentDTO dto) throws ParseException {
        Date date = new Date();
        CommentPO commentPO = new CommentPO();
        commentPO.setCommentId(dto.getCommentId());
        commentPO.setCommentContent(dto.getCommentContent());
        commentPO.setCommentTime(date);
        commentPO.setNewsId(dto.getNewsId());
        commentPO.setUserId(dto.getUserId());
        commentPO.setDeleted(dto.getDeleted());
        return commentPO;
    }

    public static CommentDetailVO convertPO2DetailVO(CommentPO commentPO) {
        if(Objects.isNull(commentPO)) {
            return null;
        }
        CommentDetailVO commentDetailVO = new CommentDetailVO();
        commentDetailVO.setCommentId(commentPO.getCommentId());
        commentDetailVO.setCommentTime(commentPO.getCommentTime());
        commentDetailVO.setNewsId(commentPO.getNewsId());
        commentDetailVO.setUserId(commentPO.getUserId());
        commentDetailVO.setCommentContent(commentPO.getCommentContent());
        commentDetailVO.setDeleted(commentDetailVO.getDeleted());
        return commentDetailVO;
    }
}



