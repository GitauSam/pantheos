package com.phosphor.jumiaex.entities;

import lombok.Getter;

@Getter
public enum Country {

    CAMEROON("Cameroon","237","\\(237\\)\\ ?[2368]\\d{7,8}$"),
    ETHIOPIA("Ethiopia","251","\\(251\\)\\ ?[1-59]\\d{8}$"),
    MOROCCO("Morocco","212","\\(212\\)\\ ?[5-9]\\d{8}$"),
    MOZAMBIQUE("Mozambique","258","\\(258\\)\\ ?[28]\\d{7,8}$"),
    UGANDA("Uganda","256","\\(256\\)\\ ?\\d{9}$");

    private final String name;
    private final String code;
    private final String regex;

    Country(String name,String code,String regex){
        this.name= name;
        this.code=code;
        this.regex=regex;
    }
}
