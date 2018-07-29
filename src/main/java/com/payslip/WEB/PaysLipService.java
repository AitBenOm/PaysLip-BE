package com.payslip.WEB;

import com.itextpdf.text.DocumentException;
import com.payslip.DAO.EmployeeRepo;
import com.payslip.DAO.PaysLipRepo;
import com.payslip.DAO.RubricRepo;
import com.payslip.Services.PdfCreator;
import com.payslip.entities.Employee;
import com.payslip.entities.PaysLip;
import com.payslip.entities.Rubric;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.awt.*;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping(value ="PaysLip")
@CrossOrigin("*")
public class PaysLipService {

    @Autowired
    private PaysLipRepo paysLipRepo;
    @Autowired
    private EmployeeRepo employeeRepo;
    @Autowired
    private RubricRepo rubricRepo;




    @RequestMapping(value = "/List/{matricule}", method = RequestMethod.GET)
    public List<PaysLip> getListPaysLipByEmployee(@PathVariable int matricule){

        return this.paysLipRepo.getPaysLipByEmployee(matricule);
    }
    @RequestMapping(value = "/print/{idPaysLips}", method = RequestMethod.GET)
    public void printEmployeePaysLip(@PathVariable int idPaysLips) throws IOException, DocumentException {
        System.out.println(idPaysLips);
        System.out.println(this.rubricRepo.getRubricsByPaysLip(1));
        PdfCreator pdfCreator = new PdfCreator();
         pdfCreator.createPdf(this.employeeRepo.getEmployee(idPaysLips),this.rubricRepo.getRubricsByPaysLip(1));


    }

//    @RequestMapping(value = "/List/{idPaysLip}", method = RequestMethod.GET)
//    public PaysLip getPaysLip(@PathVariable int idPaysLip){
//        return this.paysLipRepo.getOne(idPaysLip);
//    }

    @RequestMapping(value = "/List/{idPaysLip}", method = RequestMethod.DELETE)
    public void deletePaysLip(@PathVariable int idPaysLip){
        this.paysLipRepo.deleteById(idPaysLip);
    }
    @RequestMapping(value = "/Add", method = RequestMethod.POST)
    public PaysLip AddPaysLip(@RequestBody PaysLip paysLip){

        return this.paysLipRepo.save(paysLip);
    }
    @RequestMapping(value = "/List", method = RequestMethod.GET)
    public List<PaysLip> getPaysLipsByEmployee(@RequestParam int matricule){
        return  this.paysLipRepo.getPaysLipByEmployee(matricule);
    }
}
