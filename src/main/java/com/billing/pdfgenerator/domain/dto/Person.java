package com.billing.pdfgenerator.domain.dto;


import lombok.AllArgsConstructor;
import lombok.Data;

@Data


public class Person {

    private String name;
    private String nickname;
    private int age;

    public Person(String name, String nickname, int age) {
        this.name = name;
        this.nickname = nickname;
        this.age = age;
    }
}
