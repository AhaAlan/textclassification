package com.lacoders.textclassification.bean.dto;

import lombok.Data;

@Data
public class UpdateCommentDTO {

    private Integer commentId;

    private String commentContent;

    private Integer userId;

    private Integer newsId;

    private Integer deleted;

}
