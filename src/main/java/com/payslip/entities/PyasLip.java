package com.payslip.entities;

import java.util.Date;
import java.util.List;

public class PyasLip {
    public int idPyasLip;
    public Employee employee;
    public Date[] period;
    public List<Rubric> rubrics;

    public PyasLip(Employee employee, Date[] period, List<Rubric> rubrics) {
        this.employee = employee;
        this.period = period;
        this.rubrics = rubrics;
    }

    public PyasLip() {
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
