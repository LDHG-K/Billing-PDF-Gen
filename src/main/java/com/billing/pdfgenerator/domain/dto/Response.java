package com.billing.pdfgenerator.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Getter
@Setter
public class Response {

    private String status;
    private String creationDate;
    private String pdfBase64;

    public Response(){

    }

    public Response(String status, LocalDate creationDate, String pdfBase64) {
        this.status = status;
        this.creationDate = creationDate.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        this.pdfBase64 = pdfBase64;
    }

    //TODO Add a status attribute that allows to know the status of the created pdf
    //TODO Add a date attribute to know when the pdf was created (dd/mm/yyyy)
    //TODO Add a Base64 attribute for the generated pdf

}
