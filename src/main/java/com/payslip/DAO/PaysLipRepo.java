package com.payslip.DAO;

import com.payslip.entities.PaysLip;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PaysLipRepo extends JpaRepository<PaysLip, Integer>{


        @Query("select p from PaysLip p where p.employee.matricule =:x")
        List<PaysLip> getPaysLipByEmployee(@Param("x") int matricule);
    }


