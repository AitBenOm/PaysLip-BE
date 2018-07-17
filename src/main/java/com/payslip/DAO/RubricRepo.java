package com.payslip.DAO;

import com.payslip.entities.Rubric;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RubricRepo extends JpaRepository<Rubric, Integer> {
}
