package com.payslip.WEB;


import com.payslip.DAO.EmployeeRepo;
import com.payslip.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value ="Employee")
@CrossOrigin("*")
public class EmployeeService {

        @Autowired
        private EmployeeRepo employeeRepo;

    @RequestMapping(value = "/List", method = RequestMethod.GET)
    public List<Employee> getListEmployee(){
        return this.employeeRepo.findAll();
    }

    @RequestMapping(value = "/List/{matricule}", method = RequestMethod.GET)
    public Employee getEmployee(@PathVariable int matricule){
        return this.employeeRepo.getOne(matricule);
    }

    @RequestMapping(value = "/print/{idPaysLips}", method = RequestMethod.GET)
    public Employee printEmployeePaysLip(@PathVariable int idPaysLips){
        System.out.println(idPaysLips);

        // this.pdfCreator.createPdf();
        return this.employeeRepo.getEmployee(idPaysLips);

    }

    @RequestMapping(value = "/List/{matricule}", method = RequestMethod.DELETE)
    public void deleteEmployee(@PathVariable int matricule){
         this.employeeRepo.deleteById(matricule);
    }
    @RequestMapping(value = "/Add", method = RequestMethod.POST)
    public Employee AddEmployee(@RequestBody Employee employee){

        return this.employeeRepo.save(employee);
    }
    @RequestMapping(value = "/Update", method = RequestMethod.PUT)
    public Employee updateEmployee(@RequestBody Employee employee){
        return this.employeeRepo.save(employee);
    }

}
