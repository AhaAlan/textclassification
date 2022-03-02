package com.lacoders.textclassification.bean.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AddOrUpdateNewsVO {
    /**
     * 主键id
     */
    private Integer newsId;
    /**
     * 成功标识
     */
    private Boolean whetherSuccess;
}
