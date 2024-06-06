package com.billing.pdfgenerator.domain.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
public class Response {

    private String status;
    private LocalDateTime creationDate;
    private byte[] pdfBytes;
    
}
