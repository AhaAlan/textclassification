package com.lacoders.textclassification.bean.dto;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;


@Data
public class AddNewsDTO {

    private String newsSrc;

    private String newsTitle;

    private String newsType;

    private String newsWriter;

    private String newsTime;

    private Integer deleted;

    private String maintext;
}
