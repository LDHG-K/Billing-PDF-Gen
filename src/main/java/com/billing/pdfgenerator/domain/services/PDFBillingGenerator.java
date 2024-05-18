package com.billing.pdfgenerator.domain.services;

import com.billing.pdfgenerator.domain.dto.Response;
import com.billing.pdfgenerator.domain.gateways.PDFGeneratorService;

// TODO Add a tag to tell that this is a service for example @Repository is to say that a class is used for repository transactions

public class PDFBillingGenerator implements PDFGeneratorService {

    // TODO Inject a class that allows to create a pdf

    // TODO Implement a logic that validate and creates a pdf
    @Override
    public Response generatePDF() {

        // Your logic here

        return null;
    }

}
