package com.payslip.DAO;

import com.payslip.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface EmployeeRepo extends JpaRepository<Employee, Integer> {


    @Query("select e from Employee e where e.matricule=:x")
  Employee getEmployee(@Param("x") int matricule);
}
