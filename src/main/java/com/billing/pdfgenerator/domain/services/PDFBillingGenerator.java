package com.billing.pdfgenerator.domain.services;

import com.billing.pdfgenerator.domain.dto.Request;
import com.billing.pdfgenerator.domain.dto.Response;
import com.billing.pdfgenerator.domain.gateways.PDFGeneratorService;
import com.billing.pdfgenerator.infraestructure.pdf.PDFGenerator;
import com.billing.pdfgenerator.infraestructure.pdf.adapters.IPDFGenerator;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

// TODO Add a tag to tell that this is a service for example @Repository is to say that a class is used for repository transactions
@Service
@AllArgsConstructor
public class PDFBillingGenerator implements PDFGeneratorService {

    // TODO Inject a class that allows to create a pdf


    private final IPDFGenerator pdfGenerator;

    // TODO Implement a logic that validate and creates a pdf
    @Override
    public Response generatePDF(Request request) {

        // Your logic here

        Response response = new Response();
        response.setPdf(pdfGenerator.generatePDF(null));
        response.setCreationDate(LocalDateTime.now());
        response.setStatus("OK");
        return response;
    }

}
