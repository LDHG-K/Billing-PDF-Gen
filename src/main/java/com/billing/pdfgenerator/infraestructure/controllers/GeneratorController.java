package com.billing.pdfgenerator.infraestructure.controllers;

import com.billing.pdfgenerator.domain.dto.Request;
import com.billing.pdfgenerator.domain.dto.Response;
import com.billing.pdfgenerator.domain.gateways.PDFGeneratorService;
import com.billing.pdfgenerator.domain.services.PDFBillingGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pdf-generator")
public class GeneratorController {

    private final PDFGeneratorService pdfBillingGenerator;

    @Autowired
    public GeneratorController(PDFBillingGenerator pdfBillingGenerator) {
        this.pdfBillingGenerator = pdfBillingGenerator;
    }

    @PostMapping("/generate")
    public Response generatePDF(@RequestBody Request request) {
        return pdfBillingGenerator.generatePDF(request);
    }
}
