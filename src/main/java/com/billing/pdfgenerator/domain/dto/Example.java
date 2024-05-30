package com.billing.pdfgenerator.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalTime;

@Getter
@Setter
public class Example {
    public Example(String value, LocalDate createdDate) {
        this.value = value;
        this.createdDate = createdDate;
    }

    private String value;
    private LocalDate createdDate;
}
