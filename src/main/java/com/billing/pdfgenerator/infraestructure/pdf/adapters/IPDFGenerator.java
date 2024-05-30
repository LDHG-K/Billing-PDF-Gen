package com.billing.pdfgenerator.infraestructure.pdf.adapters;

public interface IPDFGenerator {
        byte[] generatePDF(String htmlContent);
}
