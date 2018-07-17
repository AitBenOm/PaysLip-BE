package com.payslip.DAO;

import com.payslip.entities.Fonction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FonctionRepo extends JpaRepository<Fonction, Integer> {
}
