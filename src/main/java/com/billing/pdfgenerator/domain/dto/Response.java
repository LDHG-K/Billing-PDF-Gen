package com.billing.pdfgenerator.domain.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class Response {

    private String status;
    private LocalDateTime creationDate;
    private byte[] pdf;

    public Response(String status, LocalDateTime creationDate, byte[] pdf) {
        this.status = status;
        this.creationDate = creationDate;
        this.pdf = pdf;
    }

    public Response() {

    }
}
