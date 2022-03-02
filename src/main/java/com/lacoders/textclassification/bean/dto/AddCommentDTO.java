package com.lacoders.textclassification.bean.dto;

import lombok.Data;

import java.util.Date;

@Data
public class AddCommentDTO {

        private Integer userId;

        private Integer newsId;

        private Integer deleted;

        private String commentContent;

}
