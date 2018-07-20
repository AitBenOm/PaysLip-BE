package com.payslip.WEB;

import com.payslip.DAO.RubricRepo;
import com.payslip.entities.Rubric;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value ="Rubric")
@CrossOrigin("*")
public class RubricService {

    @Autowired
    private RubricRepo rubricRepo;

    @RequestMapping(value = "/List/{idPaysLip}", method = RequestMethod.GET)
    public List<Rubric> getRubricsByPaysLip(@PathVariable int idPaysLip){
        return this.rubricRepo.getRubricsByPaysLip(idPaysLip);
    }

    @RequestMapping(value = "/Add", method = RequestMethod.POST)
    public List<Rubric> AddRubrics(@RequestBody List<Rubric> rubrics){

        return this.rubricRepo.saveAll(rubrics);
    }
}
