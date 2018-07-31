package com.payslip.WEB;

import com.itextpdf.text.DocumentException;
import com.payslip.DAO.EmployeeRepo;
import com.payslip.DAO.PaysLipRepo;
import com.payslip.DAO.RubricRepo;
import com.payslip.Services.FileStorageService;
import com.payslip.Services.PdfCreator;
import com.payslip.entities.Employee;
import com.payslip.entities.PaysLip;
import com.payslip.entities.Rubric;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.io.*;
import java.net.URLConnection;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collection;
import java.util.Collections;
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
    @Autowired
    private FileStorageService fileStorageService;
    @Autowired
    private PdfCreator pdfCreator;




    @RequestMapping(value = "/List/{matricule}", method = RequestMethod.GET)
    public List<PaysLip> getListPaysLipByEmployee(@PathVariable int matricule){

        return this.paysLipRepo.getPaysLipByEmployee(matricule);
    }


    @RequestMapping(value = "/List/PaysLip/{idPaysLip}", method = RequestMethod.GET)
    public PaysLip getPaysLip(@PathVariable int idPaysLip){

        return this.paysLipRepo.getPaysLipById(idPaysLip);
    }


    @GetMapping("/print")
    public HttpServletResponse downloadPaysLip(@RequestParam int idPaysLip, @RequestParam int matricule,  HttpServletResponse response) throws IOException, DocumentException {

        List<Rubric> rubrics = this.rubricRepo.getRubricsByPaysLip(idPaysLip);
        PaysLip paysLip = this.getPaysLip(idPaysLip);
        Employee employee = this.employeeRepo.getEmployee(matricule);
        String paysLipName = (employee.getNom() + "-" + employee.getPrenom() + "-" + paysLip.getEndPeriod() + ".pdf").replace(" ", "-");
        //System.out.println(rubrics.size());
        if (!rubrics.get(0).label.equals("SDB")) {
            Collections.reverse(rubrics);
        }
        pdfCreator.createPdf(employee, rubrics, paysLip);

        // Load file as Resource
        Path path = Paths.get(System.getProperty("user.dir") + "\\PaysLips");
        Resource resource = fileStorageService.loadFileAsResource(paysLipName, path);

        // Try to determine file's content type
        String contentType = null;

        File file = new File(path.toString() + "\\" + paysLipName);

        contentType = URLConnection.guessContentTypeFromName(file.getName());
        /*contentType = request.getServletContext().getMimeType(resource.getFile().getAbsolutePath());*/

        System.out.println(contentType);


        // Fallback to the default content type if type could not be determined

            // contentType = "application/octet-stream";
            contentType = "application/pdf";

        response.setContentType(contentType);
        response.setHeader("Content-Disposition", String.format("attachment; filename=\"" + resource.getFilename() + "\""));
        response.setHeader("Employee",paysLipName);
        response.setContentLength((int) file.length());

        InputStream inputStream = new BufferedInputStream(new FileInputStream(file));

        FileCopyUtils.copy(inputStream, response.getOutputStream());


        System.out.println("Path PaysLipService " + path.toString());
        // File file = new File(path.toString()+"\\"+paysLipName);

        // System.out.println("File "+file.getName());
      /*  if(file.delete()){
            System.out.println(file.getName() + " is deleted!");
        }else{
            System.out.println("Delete operation is failed.");
        }*/
        return response;
    }


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

    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public void deleteFile(@RequestParam String fileName){
        Path path= Paths.get( System.getProperty("user.dir")+"\\PaysLips");
        File file = new File(path.toString()+"\\"+fileName);

        // System.out.println("File "+file.getName());
        if(file.delete()){
            System.out.println(file.getName() + " is deleted!");
        }else{
            System.out.println("Delete operation is failed.");
        }
    }


}
