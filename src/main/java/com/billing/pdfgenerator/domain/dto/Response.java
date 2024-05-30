package com.billing.pdfgenerator.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Getter
@Setter
public class Response {

    private String status;
    private LocalDateTime creationDate;
    private byte[] pdf;

    public Response(){

    }

    public Response(String status, LocalDateTime creationDate, byte[] pdf) {
        this.status = status;
        this.creationDate = creationDate;
        this.pdf = pdf;
    }

    //TODO Add a status attribute that allows to know the status of the created pdf
    //TODO Add a date attribute to know when the pdf was created (dd/mm/yyyy)
    //TODO Add a Base64 attribute for the generated pdf

}
