package com.billing.pdfgenerator.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;


@NoArgsConstructor
@Data

public class Response {

    private String status;
    private LocalDateTime creationDate;
    private byte[] pdf;

}
