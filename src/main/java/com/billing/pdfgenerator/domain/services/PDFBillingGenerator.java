package com.billing.pdfgenerator.domain.services;

import com.billing.pdfgenerator.domain.dto.Request;
import com.billing.pdfgenerator.domain.dto.Response;
import com.billing.pdfgenerator.domain.gateways.PDFGeneratorService;
import com.billing.pdfgenerator.infraestructure.pdf.adapters.IPDFGenerator;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@AllArgsConstructor
public class PDFBillingGenerator implements PDFGeneratorService {


    private final IPDFGenerator pdfGenerator;

    @Override
    public Response generatePDF(Request request) {

        Response response = new Response();
        response.setPdf(pdfGenerator.generatePDF(null));
        response.setCreationDate(LocalDateTime.now());
        response.setStatus("OK");
        return response;
    }

}
