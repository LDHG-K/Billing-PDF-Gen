package com.billing.pdfgenerator.domain.gateways;

import com.billing.pdfgenerator.domain.dto.Request;
import com.billing.pdfgenerator.domain.dto.Response;

import java.util.Base64;

public interface PDFGeneratorService {

    Response generatePDF(Request request);

}
