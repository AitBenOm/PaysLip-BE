package com.payslip.WEB;


import com.payslip.DAO.StudentRepo;
import com.payslip.entities.Student;
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
    public List<Student> getListStudent(){
        return this.studentRepo.findAll();
    }
    @RequestMapping(value = "/List/{matricule}", method = RequestMethod.GET)
    public Student getStudent(@PathVariable int matricule){
        return this.studentRepo.getOne(matricule);
    }

    @RequestMapping(value = "/List/{matricule}", method = RequestMethod.DELETE)
    public void deleteStudent(@PathVariable int matricule){
        this.studentRepo.deleteById(matricule);
    }
    @RequestMapping(value = "/Add", method = RequestMethod.POST)
    public Student AddStudent(@RequestBody Student Student){

        return this.studentRepo.save(Student);
    }
    @RequestMapping(value = "/Update", method = RequestMethod.PUT)
    public Student updateStudent(@RequestBody Student Student){
        return this.studentRepo.save(Student);
    }

}
