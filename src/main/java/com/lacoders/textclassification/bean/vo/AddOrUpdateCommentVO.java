package com.lacoders.textclassification.bean.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AddOrUpdateCommentVO {
        /**
         * 主键id
         */
        private Integer commentId;
        /**
         * 成功标识
         */
        private Boolean whetherSuccess;
}
