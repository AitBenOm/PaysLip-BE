package com.payslip.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.*;
import java.util.Date;
import java.util.List;
@Entity
public class PaysLip {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    public int idPaysLip;


    @ManyToOne(fetch = FetchType.LAZY)
    public Employee employee;


    public Date startPeriod;
    public Date endPeriod;

    @JsonIgnore
    @OneToMany(mappedBy="paysLip",cascade =CascadeType.ALL, fetch=FetchType.LAZY)
    public List<Rubric> rubrics;

    public PaysLip(Employee employee, Date startPeriod, Date endPeriod,List<Rubric> rubrics) {
        this.employee = employee;
        this.startPeriod = startPeriod;
        this.endPeriod = endPeriod;
        this.rubrics = rubrics;
    }

    public PaysLip() {
    }

    public int getIdPyasLip() {
        return idPaysLip;
    }

    public void setIdPyasLip(int idPaysLip) {
        this.idPaysLip = idPaysLip;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public List<Rubric> getRubrics() {
        return rubrics;
    }

    public void setRubrics(List<Rubric> rubrics) {
        this.rubrics = rubrics;
    }
}
