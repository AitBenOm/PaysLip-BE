package com.payslip.Services;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.payslip.entities.PaysLip;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class PdfCreator {
     public static final String RESULT= "D:\\Dev\\Project\\Employee Exp\\PaysLip_Back\\rotation_colors.pdf";
    public void generatePdf(PaysLip paysLip) throws FileNotFoundException, DocumentException {
        // step 1
        Document document = new Document(PageSize.A4.rotate());
        // step 2
        PdfWriter.getInstance(document, new FileOutputStream(RESULT));
        // step 3
        document.open();
        // step 4
        PdfPTable table = new PdfPTable(4);
        table.setWidths(new int[]{ 1, 3, 3, 3 });
        table.setWidthPercentage(100);
        PdfPCell cell;

    }
}
