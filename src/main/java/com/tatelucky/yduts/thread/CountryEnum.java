package com.tatelucky.yduts.thread;

import lombok.Getter;

/**
 * @author tangsheng
 * @since 2019-10-28
 */
public enum CountryEnum {
    ONE(1, "1"),
    TWO(2, "2"),
    THREE(3, "3"),
    FOUR(4, "4"),
    FIVE(5, "5"),
    SIX(6, "6");

    @Getter
    private int key;
    @Getter
    private String val;

    CountryEnum(int key, String val) {
        this.key = key;
        this.val = val;
    }

    public static CountryEnum foreachCountryEnum(int key) {
        CountryEnum[] countryEnums = CountryEnum.values();
        for (CountryEnum countryEnum : countryEnums) {
            if (key == countryEnum.key) {
                return countryEnum;
            }
        }
        return null;
    }
}
