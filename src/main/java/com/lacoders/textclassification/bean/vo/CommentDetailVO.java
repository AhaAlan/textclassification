package com.lacoders.textclassification.bean.vo;

import lombok.Data;

import java.util.Date;

@Data
public class CommentDetailVO {
    private Integer commentId;

    private Integer userId;

    private Integer newsId;

    private Date commentTime;

    private Integer deleted;

    private String commentContent;
}
