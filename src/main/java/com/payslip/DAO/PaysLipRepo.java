package com.payslip.DAO;

import com.payslip.entities.PaysLip;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaysLipRepo extends JpaRepository<PaysLip, Integer>{
}
