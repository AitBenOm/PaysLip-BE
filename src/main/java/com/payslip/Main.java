package com.payslip;


import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;
import com.payslip.WEB.RubricService;
import com.payslip.entities.Rubric;
import javafx.scene.layout.Border;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static final String RESULT =System.getProperty("user.dir")+"\\PaysLips\\test.pdf";
    public static final String IMAGE = System.getProperty("user.dir")+"\\PaysLips\\LogoGSCA.PNG";
          //  = "D:\\Dev\\Project\\Employee Exp\\PaysLip_Back\\rotation_colors.pdf";

    public static void main(String[] args) throws IOException, DocumentException {
      //  System.out.println(System.getProperty("user.dir")+"\\PaysLips\\test.pdf");
        File file = new File(RESULT);
        file.getParentFile().mkdirs();
        new Main().createPdf(RESULT);
    }

    public void createPdf(String dest) throws IOException, DocumentException {
        RubricService rubricService = new RubricService();
        List<Rubric> ListRubric = new ArrayList<>();
        for (int i = 0; i < 15; i++) {
            Rubric rub = new Rubric("SDB", "1", true, "6500", "6500");
            ListRubric.add(rub);
        }

        // step 1
        Document document = new Document(PageSize.A4);
        // step 2
        PdfWriter writer =PdfWriter.getInstance(document, new FileOutputStream(RESULT));
        // step 3
        document.open();
        PdfContentByte canvas = writer.getDirectContentUnder();
        Image image = Image.getInstance(IMAGE);

        image.scaleAbsolute(PageSize.A5);


        image.setAbsolutePosition(90, 150);

        canvas.saveState();
        PdfGState state = new PdfGState();
        state.setFillOpacity(0.1f);
        canvas.setGState(state);
        canvas.addImage(image);

        canvas.restoreState();
         PdfPTable paysLipsHead = new PdfPTable(3);
        paysLipsHead.setWidthPercentage(105);

        paysLipsHead.setWidths(new float[]{2, 4, 4});


        PdfPCell cell = new PdfPCell();

        Font f = new Font(Font.FontFamily.TIMES_ROMAN, 8, Font.BOLD, BaseColor.BLACK);


        cell = new PdfPCell(new Paragraph(16, "STE TANOUT PRIVEE SARL", f));
   cell.setFixedHeight(20);
cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);


        paysLipsHead.addCell(cell);


        cell = new PdfPCell(new Paragraph(16, "AFF. CNSS 8880157", f));
   cell.setFixedHeight(20);
cell.setHorizontalAlignment(Element.ALIGN_CENTER);

        paysLipsHead.addCell(cell);

        cell = new PdfPCell(new Paragraph(16, "QUARTIER TANOUT AZILAL", f));
   cell.setFixedHeight(20);
cell.setHorizontalAlignment(Element.ALIGN_CENTER);


        paysLipsHead.addCell(cell);

        PdfPTable infoEmp1 = new PdfPTable(1);

        cell = new PdfPCell(new Paragraph(16, "Matricule", f));
   cell.setFixedHeight(20);
cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        infoEmp1.addCell(cell);
        cell = new PdfPCell(new Paragraph(16, "1", f));
   cell.setFixedHeight(20);
cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        infoEmp1.addCell(cell);
        cell = new PdfPCell(new Paragraph(16, "Date Embauche", f));
   cell.setFixedHeight(20);
cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        infoEmp1.addCell(cell);
        cell = new PdfPCell(new Paragraph(16, "29/08/2016", f));
   cell.setFixedHeight(20);
cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        infoEmp1.addCell(cell);
        cell = new PdfPCell(new Paragraph(16, "N° CNSS", f));
   cell.setFixedHeight(20);
cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        infoEmp1.addCell(cell);
        cell = new PdfPCell(new Paragraph(16, "123456", f));
   cell.setFixedHeight(20);
cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        infoEmp1.addCell(cell);

        paysLipsHead.addCell(infoEmp1);

        PdfPTable infoEmp2 = new PdfPTable(3);
        cell = new PdfPCell(new Paragraph(16, "Nom & Prenom", f));
   cell.setFixedHeight(20);
cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        cell.setColspan(3);
        infoEmp2.addCell(cell);

        cell = new PdfPCell(new Paragraph(16, "Ait Benaissa Omar", f));
   cell.setFixedHeight(20);
cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        cell.setColspan(3);
        infoEmp2.addCell(cell);
        cell = new PdfPCell(new Paragraph(16, "N° CIN", f));
   cell.setFixedHeight(20);
cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        infoEmp2.addCell(cell);
        cell = new PdfPCell(new Paragraph(16, "Date De Naissance", f));
   cell.setFixedHeight(20);
cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        infoEmp2.addCell(cell);
        cell = new PdfPCell(new Paragraph(16, "SF-NE-ND", f));
   cell.setFixedHeight(20);
cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        infoEmp2.addCell(cell);

        cell = new PdfPCell(new Paragraph(16, "IC60973", f));
   cell.setFixedHeight(20);
cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        infoEmp2.addCell(cell);
        cell = new PdfPCell(new Paragraph(16, "13/04/1991", f));
   cell.setFixedHeight(20);
cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        infoEmp2.addCell(cell);
        cell = new PdfPCell(new Paragraph(16, "C - 0 - Mr.", f));
   cell.setFixedHeight(20);
cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        infoEmp2.addCell(cell);

        cell = new PdfPCell(new Paragraph(16, "N° CIMR", f));
   cell.setFixedHeight(20);
cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        infoEmp2.addCell(cell);
        cell = new PdfPCell(new Paragraph(16, "Service", f));
   cell.setFixedHeight(20);
cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        infoEmp2.addCell(cell);
        cell = new PdfPCell(new Paragraph(16, "Paiement", f));
   cell.setFixedHeight(20);
cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        infoEmp2.addCell(cell);

        cell = new PdfPCell(new Paragraph(16, "N° CIMR", f));
   cell.setFixedHeight(20);
cell.setHorizontalAlignment(Element.ALIGN_CENTER);

        infoEmp2.addCell(cell);
        cell = new PdfPCell(new Paragraph(16, "Service", f));
   cell.setFixedHeight(20);
cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        infoEmp2.addCell(cell);
        cell = new PdfPCell(new Paragraph(16, "Paiement", f));
   cell.setFixedHeight(20);
cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        infoEmp2.addCell(cell);
        paysLipsHead.addCell(infoEmp2);

       /* cell = new PdfPCell(new Phrase("Nom et Prenom"));
        cell.setColspan(2);*/

        PdfPTable infoEmp3 = new PdfPTable(1);
        cell = new PdfPCell(new Paragraph(16, "Periode De Paie", f));
   cell.setFixedHeight(20);
cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        infoEmp3.addCell(cell);
        cell = new PdfPCell(new Paragraph(16, "01/07/2018 AU 31/07/2018", f));
   cell.setFixedHeight(20);
cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        infoEmp3.addCell(cell);
        cell = new PdfPCell(new Paragraph(16, "Adresse du salarié", f));
   cell.setFixedHeight(20);
cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        infoEmp3.addCell(cell);
        cell = new PdfPCell(new Paragraph(16, "5 rue MAurice Couderchet 94200 ivry-sur-seine", f));
   cell.setFixedHeight(20);
cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        infoEmp3.addCell(cell);
        cell = new PdfPCell(new Paragraph(16, "Fonction", f));
   cell.setFixedHeight(20);
cell.setHorizontalAlignment(Element.ALIGN_CENTER);
   cell.setFixedHeight(20);
cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        infoEmp3.addCell(cell);
        cell = new PdfPCell(new Paragraph(16, "Surveillant Générale", f));
   cell.setFixedHeight(20);
cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        infoEmp3.addCell(cell);
        paysLipsHead.addCell(infoEmp3);

       /* cell = new PdfPCell(new Phrase("Periode de paie"));
        cell.setColspan(2);*/

        paysLipsHead.addCell(cell);
        document.add(paysLipsHead);
        Paragraph sep = new Paragraph(16, "----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------", f);
        document.add(sep);
        PdfPTable rubrics = new PdfPTable(5);
        rubrics.setSpacingBefore(10);
        rubrics.setWidthPercentage(105);
        rubrics.setWidths(new int[]{6, 1, 1, 1, 1});

        cell = new PdfPCell(new Paragraph(16, "Rubrics", f));
   cell.setFixedHeight(20);
cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        rubrics.addCell(cell);
        cell = new PdfPCell(new Paragraph(16, "Base", f));
   cell.setFixedHeight(20);
cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        rubrics.addCell(cell);
        cell = new PdfPCell(new Paragraph(16, "Taux", f));
   cell.setFixedHeight(20);
cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        rubrics.addCell(cell);
        cell = new PdfPCell(new Paragraph(16, "Gain", f));
   cell.setFixedHeight(20);
cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        rubrics.addCell(cell);
        cell = new PdfPCell(new Paragraph(16, "Retenu", f));
   cell.setFixedHeight(20);
cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        rubrics.addCell(cell);


        for (Rubric rubric : ListRubric) {
            cell = new PdfPCell(new Paragraph(16, rubric.label, f));
       cell.setFixedHeight(20);
cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            rubrics.addCell(cell);
            cell = new PdfPCell(new Paragraph(16, rubric.base, f));
       cell.setFixedHeight(20);
cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            rubrics.addCell(cell);
            cell = new PdfPCell(new Paragraph(16, rubric.rate, f));
       cell.setFixedHeight(20);
cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            rubrics.addCell(cell);
            if (rubric.Property) {
                cell = new PdfPCell(new Paragraph(16, rubric.value, f));
           cell.setFixedHeight(20);
cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                rubrics.addCell(cell);
                cell = new PdfPCell(new Paragraph(16, "-----", f));
           cell.setFixedHeight(20);
cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                rubrics.addCell(cell);
            } else {
                cell = new PdfPCell(new Paragraph(16, "-----", f));
           cell.setFixedHeight(20);
cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                rubrics.addCell(cell);
                cell = new PdfPCell(new Paragraph(16, rubric.value, f));
           cell.setFixedHeight(20);
cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                rubrics.addCell(cell);
            }


        }

        document.add(rubrics);
        document.add(new Paragraph(16, "----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------", f));

        PdfPTable totals = (new PdfPTable(2));
        totals.setSpacingBefore(10);
        totals.setWidthPercentage(105);
        totals.setWidths(new int[]{6, 4});

        cell = new PdfPCell(new Paragraph(16, "Total", f));
        cell.setFixedHeight(20);
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        totals.addCell(cell);
        PdfPTable Valeurs = (new PdfPTable(4));
        cell = new PdfPCell(new Paragraph(16, "gfjhgdh", f));
        cell.setFixedHeight(20);
        cell.setBorder(PdfPCell.NO_BORDER);
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        Valeurs.addCell(cell);
        cell = new PdfPCell(new Paragraph(16, "Total", f));
        cell.setFixedHeight(20);
        cell.setBorder(PdfPCell.NO_BORDER);
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        Valeurs.addCell(cell);
        cell = new PdfPCell(new Paragraph(16, "Total", f));
        cell.setFixedHeight(20);
        cell.setBorder(PdfPCell.NO_BORDER);
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        Valeurs.addCell(cell);
        cell = new PdfPCell(new Paragraph(16, "Total", f));
        cell.setFixedHeight(20);
        cell.setBorder(PdfPCell.NO_BORDER);
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        Valeurs.addCell(cell);
        totals.addCell(Valeurs);
        document.add(totals);

        document.close();
    }
}
