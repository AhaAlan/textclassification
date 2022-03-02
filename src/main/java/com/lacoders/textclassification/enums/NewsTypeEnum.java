package com.lacoders.textclassification.enums;

import lombok.Getter;

import java.util.Objects;

/**
 * 新闻类别枚举类
 */
@Getter
public enum NewsTypeEnum {
    FINANCE("FINANCE", "财经"),
    LOTTERY("LOTTERY", "彩票"),
    PROPERTY("PROPERTY", "房产"),
    STOCK("STOCK", "股票"),
    HOUSEHOLD("HOUSEHOLD", "家居"),
    EDUCATION("EDUCATION", "教育"),
    TECHNOLOGY("TECHNOLOGY", "科技"),
    SOCIETY("SOCIETY", "社会"),
    FASHION("FASHION", "时尚"),
    CURRENT_AFFAIRS("CURRENT_AFFAIRS", "时政"),
    SPORTS("SPORTS", "体育"),
    HOROSCOPE("HOROSCOPE", "星座"),
    GAME("GAME", "游戏"),
    ENTERTAINMENT("ENTERTAINMENT", "娱乐")
    ;


    private String code;
    private String desc;

    NewsTypeEnum(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public static String getDescByCode(String code) {
        for (NewsTypeEnum newsTypeEnum : NewsTypeEnum.values()) {
            if (Objects.equals(code, newsTypeEnum.getCode())) {
                return newsTypeEnum.getDesc();
            }
        }
        return "";
    }
}