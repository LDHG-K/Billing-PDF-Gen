package com.billing.pdfgenerator.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.service.annotation.GetExchange;

import java.time.LocalDate;
import java.util.List;

// TODO Create all the necessary fields to create a pdf

@Getter
@Setter
@AllArgsConstructor
public class PDFInformation {

    //CLUE... Header, body, footer... should investigate what usually makes a pdf of information

    private String header;
    private String title;
    private List<String> index;
    private List<String> content;
    private String footer;
    private String author;
    private LocalDate creationDate;


}
