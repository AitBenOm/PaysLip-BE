package com.payslip.Services;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;
import com.payslip.entities.Employee;
import com.payslip.entities.PaysLip;
import com.payslip.entities.Rubric;
import org.json.simple.JSONObject;
import org.springframework.stereotype.Service;

import javax.validation.constraints.Null;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

@Service
public class PdfCreator {

    public  String RESULT = System.getProperty("user.dir") + "\\PaysLips\\";
    public static final String IMAGE = System.getProperty("user.dir") + "\\PaysLips\\LogoGSCA.PNG";

    public void createPdf(Employee emp, List<Rubric> ListRubric,PaysLip paysLip) throws IOException, DocumentException {
        JSONObject rubricsTitle = new JSONObject();

        rubricsTitle.put("SDB", "Salaire de Base");
        rubricsTitle.put("ANT", "Ancienté");
        rubricsTitle.put("CNSS", "C.N.S.S");
        rubricsTitle.put("AMO", "A.M.O");
        rubricsTitle.put("IGR", "I.G.R");
        rubricsTitle.put("ARR", "Arrondie");
        rubricsTitle.put("PRCHG", "Pérsonnes à Charge");
        rubricsTitle.put("INDTR", "Indem.Deplacement");
        rubricsTitle.put("PRITR", "  Prime de Transport");
        rubricsTitle.put("PRIPAN", "Prime de Panier");
        rubricsTitle.put("INDRE", "Indem . Rpresentation");
        rubricsTitle.put("TXPRO", "Taxe . Professionelle");
        rubricsTitle.put("totalGain", "Total Des Gains");
        rubricsTitle.put("totalRet", "Totle des Retenus");
        rubricsTitle.put("netApaye", "NET A Payé");
        rubricsTitle.put("netImpo", "NET Imposable");


        //  System.out.println(rubricsTitle.get("SDB"));

        Document document = new Document(PageSize.A4);
        // step 2
        RESULT=RESULT+(emp.getNom()+"-"+emp.getPrenom()+"-"+paysLip.getEndPeriod()+".pdf").replace(" ","-");
       System.out.println("PdfCreator Service "+RESULT);
        PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(RESULT));
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
        PdfPCell cell;
        Font f = new Font(Font.FontFamily.TIMES_ROMAN, 8, Font.BOLD, BaseColor.BLACK);
        Font head = new Font(Font.FontFamily.TIMES_ROMAN, 20, Font.BOLD, BaseColor.BLACK);
        PdfPTable header = new PdfPTable(3);
        header.setWidths(new int[]{2, 4, 4});
        header.setWidthPercentage(105);

        Image img = Image.getInstance(IMAGE, true);
        img.scaleAbsolute(50, 50);

        img.setAbsolutePosition(50, 0);
        cell = new PdfPCell(img);
        cell.setBorder(Rectangle.NO_BORDER);
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        header.addCell(cell);
        header.getSpacingAfter();


        cell = new PdfPCell(new Paragraph(16, "Groupe Scolaire Charif Al Idrissi", head));
        cell.setFixedHeight(20);
        cell.setBorder(Rectangle.NO_BORDER);
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        header.addCell(cell);

        cell = new PdfPCell(new Paragraph(16, "STE TANOUT PRIVEE SARL", f));
        cell.setFixedHeight(20);
        cell.setBorder(Rectangle.NO_BORDER);
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        header.addCell(cell);
        header.setSpacingAfter(30);
        document.add(header);


        PdfPTable paysLipsHead = new PdfPTable(3);
        paysLipsHead.setWidthPercentage(105);

        paysLipsHead.setWidths(new float[]{2, 4, 4});


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
        cell = new PdfPCell(new Paragraph(16, Integer.toString(emp.getMatricule()), f));
        cell.setFixedHeight(20);
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        infoEmp1.addCell(cell);
        DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd");

        //to convert Date to String, use format method of SimpleDateFormat class.
        String dateEmb = dateFormat.format(emp.getDate_emb());
        cell = new PdfPCell(new Paragraph(16, "Date Embauche", f));
        cell.setFixedHeight(20);
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        infoEmp1.addCell(cell);
        cell = new PdfPCell(new Paragraph(16, dateEmb, f));
        cell.setFixedHeight(20);
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        infoEmp1.addCell(cell);
        cell = new PdfPCell(new Paragraph(16, "N° CNSS", f));
        cell.setFixedHeight(20);
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        infoEmp1.addCell(cell);
        cell = new PdfPCell(new Paragraph(16, emp.getNumCNSS(), f));
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

        cell = new PdfPCell(new Paragraph(16, emp.getNom() + " " + emp.getPrenom(), f));
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

        cell = new PdfPCell(new Paragraph(16, emp.getNumCin(), f));
        cell.setFixedHeight(20);
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        infoEmp2.addCell(cell);
        String dateNaissace = dateFormat.format(emp.getDate_de_naissance());
        cell = new PdfPCell(new Paragraph(16, dateNaissace, f));
        cell.setFixedHeight(20);
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        infoEmp2.addCell(cell);
        cell = new PdfPCell(new Paragraph(16, emp.getSituationFamiliale() + "-" + emp.getNbEnfant() + "-" + emp.getSex(), f));
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

        cell = new PdfPCell(new Paragraph(16, "N° CIMR-V", f));
        cell.setFixedHeight(20);
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        infoEmp2.addCell(cell);
        cell = new PdfPCell(new Paragraph(16, "Service-V", f));
        cell.setFixedHeight(20);
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        infoEmp2.addCell(cell);
        cell = new PdfPCell(new Paragraph(16, "Paiement-V", f));
        cell.setFixedHeight(20);
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        infoEmp2.addCell(cell);
        paysLipsHead.addCell(infoEmp2);


        PdfPTable infoEmp3 = new PdfPTable(1);
        cell = new PdfPCell(new Paragraph(16, "Periode De Paie", f));
        cell.setFixedHeight(20);
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        infoEmp3.addCell(cell);
        cell = new PdfPCell(new Paragraph(16, paysLip.getStartPeriod().toString()+" AU "+paysLip.getEndPeriod().toString(), f));
        cell.setFixedHeight(20);
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        infoEmp3.addCell(cell);
        cell = new PdfPCell(new Paragraph(16, "Adresse du salarié", f));
        cell.setFixedHeight(20);
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        infoEmp3.addCell(cell);
        cell = new PdfPCell(new Paragraph(16, emp.getAdresse(), f));
        cell.setFixedHeight(20);
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        infoEmp3.addCell(cell);
        cell = new PdfPCell(new Paragraph(16, "Fonction", f));
        cell.setFixedHeight(20);
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        infoEmp3.addCell(cell);
        cell = new PdfPCell(new Paragraph(16, emp.getFonction(), f));
        cell.setFixedHeight(20);
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        infoEmp3.addCell(cell);
        paysLipsHead.addCell(infoEmp3);

       /* cell = new PdfPCell(new Phrase("Periode de paie"));
        cell.setColspan(2);*/

        paysLipsHead.addCell(cell);
        paysLipsHead.setSpacingAfter(10);
        document.add(paysLipsHead);

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
        DecimalFormat df = new DecimalFormat();
        df.setMaximumFractionDigits(1);

        for (Rubric rubric : ListRubric) {
            // System.out.println(rubric.value);
            //    System.out.println(rubric.value!=(null));
            if (!rubric.base.equals("999") && rubric.value != (null) && !rubric.value.equals("0")) {
                //System.out.println(rubric.label);
              //  System.out.println(rubricsTitle.get(rubric.label).toString());
                cell = new PdfPCell(new Paragraph(16, rubricsTitle.get(rubric.label).toString(), f));
                cell.setFixedHeight(20);
                cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                rubrics.addCell(cell);
                cell = new PdfPCell(new Paragraph(16, String.valueOf((df.format(Double.parseDouble(rubric.base)))), f));
                cell.setFixedHeight(20);
                cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                rubrics.addCell(cell);
                cell = new PdfPCell(new Paragraph(16, rubric.rate + (rubric.rateType.equals("tx") ? " %" : ""), f));
                cell.setFixedHeight(20);
                cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                rubrics.addCell(cell);
                if (rubric.Property) {
                  /*  System.out.println(Double.parseDouble(rubric.value));
                    System.out.println((df.format(Double.parseDouble(rubric.value))));
                    System.out.println((String.valueOf(df.format(Double.parseDouble(rubric.value)))));*/
                    cell = new PdfPCell(new Paragraph(16, String.valueOf((df.format(Double.parseDouble(rubric.value)))), f));
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
                    cell = new PdfPCell(new Paragraph(16, String.valueOf((df.format(Double.parseDouble(rubric.value)))), f));
                    cell.setFixedHeight(20);
                    cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                    rubrics.addCell(cell);
                }
            }
        }
        rubrics.setSpacingAfter(10);
        document.add(rubrics);


        PdfPTable footer = (new PdfPTable(2));
        footer.setSpacingBefore(10);
        footer.setWidthPercentage(105);
        footer.setWidths(new int[]{6, 4});


        int n = ListRubric.size();

        cell = new PdfPCell(new Paragraph(16, "NET Imposable", f));
        cell.setFixedHeight(20);
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        footer.addCell(cell);
        PdfPTable NetImpo = (new PdfPTable(4));
        cell = new PdfPCell(new Paragraph(16, "", f));
        cell.setFixedHeight(20);
        cell.setBorder(PdfPCell.NO_BORDER);
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        NetImpo.addCell(cell);

        cell = new PdfPCell(new Paragraph(16, "", f));
        cell.setFixedHeight(20);
        cell.setBorder(PdfPCell.NO_BORDER);
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        NetImpo.addCell(cell);


        cell = new PdfPCell(new Paragraph(16, String.valueOf((df.format(Double.parseDouble(ListRubric.get(n - 1).value)))), f));
        cell.setFixedHeight(20);
        cell.setBorder(PdfPCell.NO_BORDER);
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        NetImpo.addCell(cell);
        cell = new PdfPCell(new Paragraph(16, "", f));
        cell.setFixedHeight(20);
        cell.setBorder(PdfPCell.NO_BORDER);
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        NetImpo.addCell(cell);
        footer.addCell(NetImpo);



        cell = new PdfPCell(new Paragraph(16, "Total", f));
        cell.setFixedHeight(20);
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        footer.addCell(cell);
        PdfPTable Total = (new PdfPTable(4));
        cell = new PdfPCell(new Paragraph(16, "", f));
        cell.setFixedHeight(20);
        cell.setBorder(PdfPCell.NO_BORDER);
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        Total.addCell(cell);

        cell = new PdfPCell(new Paragraph(16, "", f));
        cell.setFixedHeight(20);
        cell.setBorder(PdfPCell.NO_BORDER);
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        Total.addCell(cell);


        cell = new PdfPCell(new Paragraph(16, String.valueOf((df.format(Double.parseDouble(ListRubric.get(n - 4).value)))), f));
        cell.setFixedHeight(20);
        cell.setBorder(PdfPCell.NO_BORDER);
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        Total.addCell(cell);
        cell = new PdfPCell(new Paragraph(16, String.valueOf((df.format(Double.parseDouble(ListRubric.get(n - 3).value)))), f));
        cell.setFixedHeight(20);
        cell.setBorder(PdfPCell.NO_BORDER);
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        Total.addCell(cell);


        footer.addCell(Total);

        cell = new PdfPCell(new Paragraph(16, "NET A Payé", f));
        cell.setFixedHeight(20);
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        footer.addCell(cell);
        PdfPTable NetPaye = (new PdfPTable(4));
        cell = new PdfPCell(new Paragraph(16, "", f));
        cell.setFixedHeight(20);
        cell.setBorder(PdfPCell.NO_BORDER);
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        NetPaye.addCell(cell);

        cell = new PdfPCell(new Paragraph(16, "", f));
        cell.setFixedHeight(20);
        cell.setBorder(PdfPCell.NO_BORDER);
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        NetPaye.addCell(cell);


        cell = new PdfPCell(new Paragraph(16, String.valueOf((df.format(Double.parseDouble(ListRubric.get(n - 2).value)))), f));
        cell.setFixedHeight(20);
        cell.setBorder(PdfPCell.NO_BORDER);
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        NetPaye.addCell(cell);
        cell = new PdfPCell(new Paragraph(16, "", f));
        cell.setFixedHeight(20);
        cell.setBorder(PdfPCell.NO_BORDER);
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        NetPaye.addCell(cell);


        footer.addCell(NetPaye);

        document.add(footer);

        document.close();
    }
}

