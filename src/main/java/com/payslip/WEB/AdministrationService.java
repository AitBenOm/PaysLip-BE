package com.payslip.WEB;

import com.payslip.DAO.FonctionRepo;
import com.payslip.DAO.ServiceRepo;
import com.payslip.entities.Employee;
import com.payslip.entities.Fonction;
import com.payslip.entities.Level;
import com.payslip.entities.Service;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.payslip.DAO.LevelRepo;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@RestController
@RequestMapping(value ="Administration")
@CrossOrigin("*")
public class AdministrationService {

    @Autowired
    private LevelRepo levelRepo;
    private ServiceRepo serviceRepo;
    private FonctionRepo fonctionRepo;


    @RequestMapping(value = "/Fonctions", method = RequestMethod.GET)
    public List<Fonction> getListFonctions(){
        return this.fonctionRepo.findAll();
    }
    @RequestMapping(value = "/Services", method = RequestMethod.GET)
    public List<Service> getListServices(){
        return this.serviceRepo.findAll();
    }
    @RequestMapping(value = "/Levels", method = RequestMethod.GET)
    public List<Level> getListLevels(){
        return this.levelRepo.findAll();
    }
}
