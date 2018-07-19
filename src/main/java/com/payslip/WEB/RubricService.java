package com.payslip.WEB;

import com.payslip.DAO.RubricRepo;
import com.payslip.entities.Rubric;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value ="Rubrics")
@CrossOrigin("*")
public class RubricService {

    @Autowired
    private RubricRepo rubricRepo;

    @RequestMapping(value = "/List/{idPaysLip}", method = RequestMethod.GET)
    public List<Rubric> getRubricsByPaysLip(@PathVariable int idPaysLip){
        return this.rubricRepo.getRubricsByPaysLip(idPaysLip);
    }

}
