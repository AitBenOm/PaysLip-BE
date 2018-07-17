package com.payslip.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Fonction {
    @Id
    @GeneratedValue
    private  int  fonction_Id;
   private String  description;

    public Fonction(String description) {
        this.description = description;
    }

    public int getFonction_Id() {
        return fonction_Id;
    }

    public void setFonction_Id(int fonction_Id) {
        this.fonction_Id = fonction_Id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
