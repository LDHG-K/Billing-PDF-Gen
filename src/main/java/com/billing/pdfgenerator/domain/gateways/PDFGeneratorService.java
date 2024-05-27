package com.billing.pdfgenerator.domain.gateways;

import com.billing.pdfgenerator.domain.dto.Request;
import com.billing.pdfgenerator.domain.dto.Response;

public interface PDFGeneratorService {

    Response generatePDF(Request request);

}
