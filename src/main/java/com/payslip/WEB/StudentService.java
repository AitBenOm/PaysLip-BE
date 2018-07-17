package com.payslip.WEB;


import com.payslip.DAO.StudentRepo;
import com.payslip.entities.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value ="Student")
@CrossOrigin("*")
public class StudentService {

    @Autowired
    private StudentRepo studentRepo;

    @RequestMapping(value = "/List", method = RequestMethod.GET)
    public List<Student> getListEmployee(){
        return this.studentRepo.findAll();
    }
    @RequestMapping(value = "/Add", method = RequestMethod.POST)
    public Student AddEmployee(@RequestBody Student student){

        return this.studentRepo.save(student);
    }
}
