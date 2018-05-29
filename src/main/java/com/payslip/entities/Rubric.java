package com.payslip.entities;

public class Rubric {
    private int idRubric;
    public String label;
    public  int rate ;
    public boolean Property;
    public float value ;
    public int base ;

    public Rubric(String label, int rate, boolean property, float value, int base) {
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

    public int getRate() {
        return rate;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }

    public boolean isProperty() {
        return Property;
    }

    public void setProperty(boolean property) {
        Property = property;
    }

    public float getValue() {
        return value;
    }

    public void setValue(float value) {
        this.value = value;
    }

    public int getBase() {
        return base;
    }

    public void setBase(int base) {
        this.base = base;
    }
}
