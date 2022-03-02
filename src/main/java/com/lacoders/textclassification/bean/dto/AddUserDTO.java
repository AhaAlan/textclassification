package com.lacoders.textclassification.bean.dto;

import lombok.Data;

@Data
public class AddUserDTO {
    private String userName;

    private String userPassword;

    private Integer deleted;
}
