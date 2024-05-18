package com.billing.pdfgenerator.infraestructure.pdf;

import com.billing.pdfgenerator.domain.dto.PDFInformation;
import com.billing.pdfgenerator.infraestructure.pdf.adapters.IPDFGenerator;
import org.springframework.stereotype.Service;

import java.util.Base64;
//TODO import the necessary classes to use the library (should investigate)

@Service
public class PDFGenerator implements IPDFGenerator {

    @Override
    public Base64 generatePDF(PDFInformation pdfInformation) {
        // Your logic to use the library here! don't forget to use the exceptions and of course handle it if is possible
        return null;
    }
}
