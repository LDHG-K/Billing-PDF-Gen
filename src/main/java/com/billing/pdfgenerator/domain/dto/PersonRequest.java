package com.billing.pdfgenerator.domain.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PersonRequest {

    private String name;
    private String nickname;
    private int age;

    public PersonRequest(String name, String nickname, int age) {
        this.name = name;
        this.nickname = nickname;
        this.age = age;
    }


}
