package com.lacoders.textclassification.bean.dto;

import lombok.Data;

@Data
public class UpdateUserDTO {
    private Integer userId;

    private String userName;

    private String userPassword;

    private Integer deleted;
}
