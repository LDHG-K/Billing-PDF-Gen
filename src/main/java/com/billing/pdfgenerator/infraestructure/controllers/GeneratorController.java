package com.billing.pdfgenerator.infraestructure.controllers;

import com.billing.pdfgenerator.domain.dto.Request;
import com.billing.pdfgenerator.domain.dto.Response;
import com.billing.pdfgenerator.domain.services.PDFBillingGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pdf-generator")
public class GeneratorController {

    private final PDFBillingGenerator pdfBillingGenerator;

    @Autowired
    public GeneratorController(PDFBillingGenerator pdfBillingGenerator) {
        this.pdfBillingGenerator = pdfBillingGenerator;
    }

    @PostMapping("/generate")
    public ResponseEntity<byte[]> generatePDF(@RequestBody Request request) {
        Response response = pdfBillingGenerator.generatePDF(request);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_PDF);
        headers.setContentDispositionFormData("filename", "invoice.pdf");
        headers.setContentLength(response.getPdf().length);

        return new ResponseEntity<>(response.getPdf(), headers, HttpStatus.OK);
    }
}
