package com.payslip.Services;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;
import com.payslip.entities.Employee;
import com.payslip.entities.PaysLip;
import com.payslip.entities.Rubric;
import org.json.simple.JSONObject;

import javax.validation.constraints.Null;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class PdfCreator {

    public static final String RESULT = System.getProperty("user.dir") + "\\PaysLips\\paysLip.pdf";
    public static final String IMAGE = System.getProperty("user.dir") + "\\PaysLips\\LogoGSCA.PNG";

    public void createPdf(Employee emp, List<Rubric> ListRubric) throws IOException, DocumentException {
        JSONObject rubricsTitle = new JSONObject();

        rubricsTitle.put("SDB", "Salaire de Base_nb");
        rubricsTitle.put("ANT", "Ancienté_tx");
        rubricsTitle.put("CNSS", "C.N.S.S_tx");
        rubricsTitle.put("AMO", "A.M.O_tx");
        rubricsTitle.put("IGR", "I.G.R_tx");
        rubricsTitle.put("ARR", "Arrondie_nb");
        rubricsTitle.put("INDTR", "Indem.Deplacement_nb");
        rubricsTitle.put("PRITR", "  Prime de Transport_nb");
        rubricsTitle.put("PRIPAN", "Prime de Panier_nb");
        rubricsTitle.put("INDRE", "Indem . Rpresentation_nb");
        rubricsTitle.put("TXPRO", "Taxe . Professionelle_tx");
        rubricsTitle.put("totalGain", "Total Des Gains_nb");
        rubricsTitle.put("totalRet", "Totle des Retenus_nb");
        rubricsTitle.put("netApaye", "NET A Payé_nb");
        rubricsTitle.put("netImpo", "NET Imposable_nb");


        System.out.println(rubricsTitle.get("SDB"));

        Document document = new Document(PageSize.A4);
        // step 2
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

        cell = new PdfPCell(new Paragraph(16, emp.getNom()+" "+emp.getPrenom(), f));
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
        cell = new PdfPCell(new Paragraph(16, emp.getSituationFamiliale()+"-"+emp.getNbEnfant()+"-"+emp.getSex(), f));
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
        cell = new PdfPCell(new Paragraph(16, "01/07/2018 AU 31/07/2018", f));
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
        DecimalFormat df = new DecimalFormat ( ) ;
        df.setMaximumFractionDigits(2);

        for (Rubric rubric : ListRubric) {
           // System.out.println(rubric.value);
            System.out.println(rubric.value!=(null));
            if (!rubric.base.equals("999") && rubric.value!=(null) && !rubric.value.equals("0")) {
                //System.out.println(rubric.label);
                //System.out.println(rubricsTitle.get(rubric.label).toString());
                cell = new PdfPCell(new Paragraph(16, rubricsTitle.get(rubric.label.split("_")[0]).toString(), f));
                cell.setFixedHeight(20);
                cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                rubrics.addCell(cell);
                cell = new PdfPCell(new Paragraph(16, rubric.base, f));
                cell.setFixedHeight(20);
                cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                rubrics.addCell(cell);
                cell = new PdfPCell(new Paragraph(16, rubric.rate+((rubricsTitle.get(rubric.label.split("_")[1]).equals("tx")) ? "%" : ""), f));
                cell.setFixedHeight(20);
                cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                rubrics.addCell(cell);
                if (rubric.Property) {
                    System.out.println(Double.parseDouble(rubric.value));
                    System.out.println((df.format(Double.parseDouble(rubric.value))));
                    System.out.println((String.valueOf(df.format(Double.parseDouble(rubric.value)))));
                    cell = new PdfPCell(new Paragraph(16,     String.valueOf((df.format(Double.parseDouble(rubric.value)))), f));
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
                    cell = new PdfPCell(new Paragraph(16,      String.valueOf((df.format(Double.parseDouble(rubric.value)))), f));
                    cell.setFixedHeight(20);
                    cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                    rubrics.addCell(cell);
                }
            }
        }
        document.add(rubrics);


        PdfPTable totals = (new PdfPTable(2));
        totals.setSpacingBefore(10);
        totals.setWidthPercentage(105);
        totals.setWidths(new int[]{6, 4});


        for (Rubric rubric : ListRubric) {

            if (rubric.base.equals("999")) {
                cell = new PdfPCell(new Paragraph(16, rubricsTitle.get(rubric.label.split("_")[0]).toString(), f));
                cell.setFixedHeight(20);
                cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                totals.addCell(cell);
                PdfPTable Valeurs = (new PdfPTable(4));
                cell = new PdfPCell(new Paragraph(16, "", f));
                cell.setFixedHeight(20);
                cell.setBorder(PdfPCell.NO_BORDER);
                cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                Valeurs.addCell(cell);

                cell = new PdfPCell(new Paragraph(16, "", f));
                cell.setFixedHeight(20);
                cell.setBorder(PdfPCell.NO_BORDER);
                cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                Valeurs.addCell(cell);

                cell = new PdfPCell(new Paragraph(16,      String.valueOf((df.format(Double.parseDouble(rubric.value)))), f));
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
            }
        }


        document.add(totals);

        document.close();
    }
}

