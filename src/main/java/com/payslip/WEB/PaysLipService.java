package com.payslip.WEB;

import com.payslip.DAO.PaysLipRepo;
import com.payslip.entities.PaysLip;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.awt.*;
import java.util.List;

@RestController
@RequestMapping(value ="PaysLip")
@CrossOrigin("*")
public class PaysLipService {

    @Autowired
    private PaysLipRepo paysLipRepo;
    private  RubricService rubricService;

    @RequestMapping(value = "/List/{matricule}", method = RequestMethod.GET)
    public List<PaysLip> getListPaysLipByEmployee(@PathVariable int matricule){

        return this.paysLipRepo.getPaysLipByEmployee(matricule);
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
