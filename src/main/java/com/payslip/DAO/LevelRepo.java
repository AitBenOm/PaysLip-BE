package com.payslip.DAO;

import com.payslip.entities.Level;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LevelRepo extends JpaRepository<Level,Integer> {
}
