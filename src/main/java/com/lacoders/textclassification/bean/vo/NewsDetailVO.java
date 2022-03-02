package com.lacoders.textclassification.bean.vo;

import lombok.Data;

import java.util.Date;


@Data
public class NewsDetailVO {
    private Integer newsId;

    private String newsSrc;

    private String newsTitle;

    private String newsTypeDesc;

    private String newsType;

    private String newsWriter;

    private Date newsTime;

    private Integer deleted;

    private String maintext;
}
