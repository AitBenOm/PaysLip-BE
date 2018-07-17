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
    @GeneratedValue
    public int idPyasLip;


    @ManyToOne(fetch = FetchType.EAGER)
    public Employee employee;

    @Temporal(TemporalType.DATE)
    public Date[] period;

    @JsonIgnore
    @OneToMany(mappedBy="paysLip",cascade =CascadeType.ALL, fetch=FetchType.EAGER)
    public List<Rubric> rubrics;

    public PaysLip(Employee employee, Date[] period, List<Rubric> rubrics) {
        this.employee = employee;
        this.period = period;
        this.rubrics = rubrics;
    }

    public PaysLip() {
    }

    public int getIdPyasLip() {
        return idPyasLip;
    }

    public void setIdPyasLip(int idPyasLip) {
        this.idPyasLip = idPyasLip;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Date[] getPeriod() {
        return period;
    }

    public void setPeriod(Date[] period) {
        this.period = period;
    }

    public List<Rubric> getRubrics() {
        return rubrics;
    }

    public void setRubrics(List<Rubric> rubrics) {
        this.rubrics = rubrics;
    }
}
