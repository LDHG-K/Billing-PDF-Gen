package com.billing.pdfgenerator.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;
@Getter
@Setter
@AllArgsConstructor
public class PDFInformation {


    private String header;
    private String title;
    private List<String> content;
    private LocalDate creationDate;


}
