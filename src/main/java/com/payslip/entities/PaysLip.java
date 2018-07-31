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
    private int idPaysLip;


    @Temporal(TemporalType.DATE)
    private Date startPeriod;

    public Date getStartPeriod() {
        return startPeriod;
    }

    public void setStartPeriod(Date startPeriod) {
        this.startPeriod = startPeriod;
    }

    public Date getEndPeriod() {
        return endPeriod;
    }

    public void setEndPeriod(Date endPeriod) {
        this.endPeriod = endPeriod;
    }

    @Temporal(TemporalType.DATE)
    private Date endPeriod;


    @ManyToOne(fetch = FetchType.EAGER)
    private Employee employee;

    @JsonIgnore
    @OneToMany(mappedBy="paysLip",cascade =CascadeType.ALL, fetch=FetchType.EAGER)
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
