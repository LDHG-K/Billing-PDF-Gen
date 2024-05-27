package com.billing.pdfgenerator.infraestructure.pdf;

import com.billing.pdfgenerator.domain.dto.PDFInformation;
import com.billing.pdfgenerator.infraestructure.pdf.adapters.IPDFGenerator;
import com.itextpdf.kernel.color.Color;
import com.itextpdf.kernel.geom.PageSize;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.border.Border;
import com.itextpdf.layout.border.DashedBorder;
import com.itextpdf.layout.border.SolidBorder;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.property.TextAlignment;
import org.springframework.stereotype.Service;
import com.itextpdf.layout.Document;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class PDFGenerator implements IPDFGenerator {


    public static Cell getHeaderTextCell(String textValue) {

        return new Cell().add(textValue).setBold().setBorder(Border.NO_BORDER).setTextAlignment(TextAlignment.RIGHT);

    }

    public static Cell getHeaderTextCellValue(String textValue) {

        return new Cell().add(textValue).setBorder(Border.NO_BORDER).setTextAlignment(TextAlignment.LEFT);

    }

    public static Cell getBillingandShippingCell(String textValue) {

        return new Cell().add(textValue).setFontSize(12f).setBold().setBorder(Border.NO_BORDER).setTextAlignment(TextAlignment.LEFT);

    }

    public static Cell getCell10fLeft(String textValue, Boolean isBold) {

        Cell myCell = new Cell().add(textValue).setFontSize(10f).setBorder(Border.NO_BORDER).setTextAlignment(TextAlignment.LEFT);
        return isBold ? myCell.setBold() : myCell;

    }

    public static byte[] encodeFileToBase64(File file) throws IOException {

        byte[] fileContent = new byte[(int) file.length()];


        FileInputStream fileInputStream = new FileInputStream(file);
        fileInputStream.read(fileContent);
        return fileContent;


    }


    @Override
    public byte[] generatePDF(PDFInformation pdfInformation) {

        try {
            LocalDate today = LocalDate.now();


            String path = "invoice.pdf";
            PdfWriter pdfWriter = new PdfWriter(path);
            PdfDocument pdfDocument = new PdfDocument(pdfWriter);
            pdfDocument.setDefaultPageSize(PageSize.A4);
            Document document = new Document(pdfDocument);

            float threecol = 190f;
            float twocol = 285f;
            float twocol150 = twocol + 150f;
            float twocolumnWidth[] = {twocol150, twocol};
            float fullwidth[] = {threecol * 3};
            float oneColumnwidth[] = {twocol150};
            float threeColumnWidth[] = {threecol, threecol, threecol};
            Paragraph onesp = new Paragraph("\n");

            Table table = new Table(twocolumnWidth);
            table.addCell(new Cell().add("Invoice").setFontSize(20f).setBorder(Border.NO_BORDER).setBold());

            Table nestedtabe = new Table(new float[]{twocol / 2, twocol / 2});
            nestedtabe.addCell(getHeaderTextCell("Invoice No."));
            nestedtabe.addCell(getHeaderTextCellValue("213123123."));
            nestedtabe.addCell(getHeaderTextCell("Invoice Date."));
            nestedtabe.addCell(getHeaderTextCellValue(today.toString()));


            table.addCell(new Cell().add(nestedtabe).setBorder(Border.NO_BORDER));

            Border gb = new SolidBorder(Color.GRAY, 2f);
            Table divider = new Table(fullwidth);
            divider.setBorder(gb);


            Table twoColTable = new Table(twocolumnWidth);
            twoColTable.addCell(getBillingandShippingCell("Billing Information"));
            twoColTable.addCell(getBillingandShippingCell("Shippgin Information"));

            Table twoColTable2 = new Table(twocolumnWidth);
            twoColTable2.addCell(getCell10fLeft("Company", true));
            twoColTable2.addCell(getCell10fLeft("Name", true));
            twoColTable2.addCell(getCell10fLeft("Stiwar SAS", false));
            twoColTable2.addCell(getCell10fLeft("Stiwar", false));
            twoColTable2.addCell(getCell10fLeft("Name", true));
            twoColTable2.addCell(getCell10fLeft("Adress", true));
            twoColTable2.addCell(getCell10fLeft("Stiwar Vendedor", false));
            twoColTable2.addCell(getCell10fLeft("Ibagué Lokas", false));

            Table oneColTable = new Table(oneColumnwidth);
            oneColTable.addCell(getCell10fLeft("Address", true));
            oneColTable.addCell(getCell10fLeft("Cll 54 7B-31, PiedraPintada", false));
            oneColTable.addCell(getCell10fLeft("Email", true));
            oneColTable.addCell(getCell10fLeft("2520181044@estu......edu.co", false));


            Table tableDivider2 = new Table(fullwidth);
            Border divider2 = new DashedBorder(Color.GRAY, 1f);
            tableDivider2.setBorder(divider2);

            Paragraph productPara = new Paragraph("Products");

            Table threeColTable1 = new Table(threeColumnWidth);
            threeColTable1.setBackgroundColor(Color.BLACK, 0.7f);
            threeColTable1.addCell(new Cell().add("Drescription").setBold().setFontColor(Color.WHITE).setBorder(Border.NO_BORDER));
            threeColTable1.addCell(new Cell().add("Quantity").setBold().setFontColor(Color.WHITE).setTextAlignment(TextAlignment.CENTER).setBorder(Border.NO_BORDER));
            threeColTable1.addCell(new Cell().add("Price").setBold().setFontColor(Color.WHITE).setTextAlignment(TextAlignment.RIGHT).setBorder(Border.NO_BORDER).setMarginRight(15f));


            List<Product> productList = new ArrayList<>();
            productList.add(new Product("apple", 2, 159));
            productList.add(new Product("mango", 4, 205));
            productList.add(new Product("banana", 2, 90));
            productList.add(new Product("grapes", 3, 10));
            productList.add(new Product("coconut", 2, 61));
            productList.add(new Product("cherry", 1, 1000));
            productList.add(new Product("kiwi", 3, 30));


            Table threeColTable2 = new Table(threeColumnWidth);

            float totalSum = 0;
            for (Product product : productList) {

                float total = product.getQuantity() * product.getPriceperpeice();
                totalSum += total;
                threeColTable2.addCell(new Cell().add(product.getName()).setBorder(Border.NO_BORDER).setMarginLeft(10f));
                threeColTable2.addCell(new Cell().add(String.valueOf(product.getQuantity())).setBorder(Border.NO_BORDER).setTextAlignment(TextAlignment.CENTER));
                threeColTable2.addCell(new Cell().add(String.valueOf(product.getPriceperpeice())).setBorder(Border.NO_BORDER).setTextAlignment(TextAlignment.RIGHT)).setMarginRight(15f);

            }

            float onetwo[] = {threecol + 125f, threecol * 2};
            Table threeColTable4 = new Table(onetwo);
            threeColTable4.addCell(new Cell().add("").setBorder(Border.NO_BORDER));
            threeColTable4.addCell(new Cell().add(tableDivider2).setBorder(Border.NO_BORDER)).setBorder(Border.NO_BORDER);

            Table threeColTable3 = new Table(threeColumnWidth);
            threeColTable3.addCell(new Cell().add("").setBorder(Border.NO_BORDER).setMarginLeft(10f));
            threeColTable3.addCell(new Cell().add("Total").setTextAlignment(TextAlignment.CENTER).setBorder(Border.NO_BORDER));
            threeColTable3.addCell(new Cell().add(String.valueOf(totalSum)).setTextAlignment(TextAlignment.RIGHT).setBorder(Border.NO_BORDER).setMarginRight(15f));

            Table tb = new Table(fullwidth);
            tb.addCell(new Cell().add("TERMS AND CONDITIONS\n").setBold().setBorder(Border.NO_BORDER));
            List<String> TncList = new ArrayList<>();
            TncList.add("1. Stiwar no se hace responsable for fallos en el software");
            TncList.add("2. Una vez vendido el producto, no tiene derecho a reclamos");
            for (String tnc : TncList) {
                tb.addCell(new Cell().add(tnc).setBorder(Border.NO_BORDER));

            }


            document.add(table);
            document.add(onesp);
            document.add(divider);
            document.add(onesp);
            document.add(twoColTable.setMarginBottom(12f));
            document.add(twoColTable2);
            document.add(oneColTable.setMarginBottom(12f));
            document.add(tableDivider2);
            document.add(productPara.setBold());
            document.add(threeColTable1);
            document.add(threeColTable2.setMarginBottom(20f));
            document.add(threeColTable4);
            document.add(threeColTable3);
            document.add(tableDivider2);
            document.add(new Paragraph("\n"));
            document.add(divider.setBorder(new SolidBorder(Color.GRAY, 1)).setMarginBottom(15f));
            document.add(tb);


            document.close();
            File file = new File(path);
            return encodeFileToBase64(file);


        } catch (IOException exception) {
            throw new RuntimeException("ERROR EN GENERAR PDF");
        }


    }


}

