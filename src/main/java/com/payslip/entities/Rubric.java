package com.payslip.entities;

import javax.persistence.*;

@Entity
public class Rubric {
    @Id
    @GeneratedValue
    private int idRubric;
    public String label;
    public  String rate ;
    public boolean Property;
    public String value ;
    public String base ;


    @ManyToOne(fetch = FetchType.EAGER)
    public PaysLip paysLip ;

    public Rubric(String label, String rate, boolean property, String value, String base) {
        this.label = label;
        this.rate = rate;
        Property = property;
        this.value = value;
        this.base = base;
    }

    public Rubric() {
    }

    public int getIdRubric() {
        return idRubric;
    }

    public void setIdRubric(int idRubric) {
        this.idRubric = idRubric;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getRate() {
        return rate;
    }

    public void setRate(String rate) {
        this.rate = rate;
    }

    public boolean isProperty() {
        return Property;
    }

    public void setProperty(boolean property) {
        Property = property;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getBase() {
        return base;
    }

    public void setBase(String base) {
        this.base = base;
    }
}
