package com.lacoders.textclassification.bean.dto;

import lombok.Data;

import java.util.Date;


@Data
public class UpdateNewsDTO {

    private Integer newsId;

    private String newsSrc;

    private String newsTitle;

    private String newsType;

    private String newsWriter;

    private String newsTime;

    private Integer deleted;

    private String maintext;
}
