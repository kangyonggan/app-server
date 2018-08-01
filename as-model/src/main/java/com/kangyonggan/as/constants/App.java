package com.kangyonggan.as.constants;

import lombok.Getter;

/**
 * APP枚举
 *
 * @author kangyonggan
 * @since 8/1/18
 */
public enum App {

    /**
     * 文章平台
     */
    ARTICLE("ARTICLE-PLATFORM", "文章平台"),

    /**
     * 小说平台
     */
    NOVEL("NOVEL-PLATFORM", "小说平台"),

    /**
     * 成语平台
     */
    PHRASAL("PHRASAL-PLATFORM", "成语平台");

    /**
     * APP代码
     */
    @Getter
    private final String code;

    /**
     * APP名称
     */
    @Getter
    private final String name;

    private App(String code, String name) {
        this.code = code;
        this.name = name;
    }


}
