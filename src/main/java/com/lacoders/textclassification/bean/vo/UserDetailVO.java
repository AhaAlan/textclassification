package com.lacoders.textclassification.bean.vo;

import lombok.Data;

@Data
public class UserDetailVO {

    private Integer userId;
    private String userName;
    private String userPassword;
    private Integer deleted;
}
