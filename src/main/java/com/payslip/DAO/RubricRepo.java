package com.payslip.DAO;

import com.payslip.entities.Rubric;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface RubricRepo extends JpaRepository<Rubric, Integer> {
    @Query("select r from Rubric r where r.paysLip.idPaysLip =:x")
    List<Rubric> getRubricsByPaysLip(@Param("x") int idPaysLip);
}
