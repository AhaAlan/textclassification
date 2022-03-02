package com.lacoders.textclassification.bean.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AddOrUpdateUserVO {
    /**
     * 主键id
     */
    private Integer userId;
    /**
     * 成功标识
     */
    private Boolean whetherSuccess;
}

