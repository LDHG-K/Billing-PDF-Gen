package com.billing.pdfgenerator.infraestructure.pdf.adapters;

import com.billing.pdfgenerator.domain.dto.PDFInformation;
public interface IPDFGenerator {

    byte[] generatePDF (PDFInformation pdfInformation);

}
