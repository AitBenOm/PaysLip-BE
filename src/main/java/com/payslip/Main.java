package com.payslip;


import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;
import com.payslip.DAO.EmployeeRepo;
import com.payslip.Services.PdfCreator;
import com.payslip.WEB.RubricService;
import com.payslip.entities.Employee;
import com.payslip.entities.Rubric;
import javafx.scene.layout.Border;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Component
public class Main {
    @Autowired
    EmployeeRepo employeeRepo;

    public static void main(String[] args) throws IOException, DocumentException {

        PdfCreator pdfCreator = new PdfCreator();

        Employee employee= new Main().employeeRepo.getOne(1);



    }

}
