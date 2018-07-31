package com.payslip.entities;

import javax.persistence.*;

@Entity
public class Rubric {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idRubric;
    public String label;
    public  String rate ;
    public  String rateType ;
    public boolean Property;
    public String value ;
    public String base ;


    @ManyToOne(fetch = FetchType.LAZY)
    public PaysLip paysLip ;



    public Rubric() {
    }

    public Rubric(String label, String rate, String rateType, boolean property, String value, String base, PaysLip paysLip) {
        this.label = label;
        this.rate = rate;
        this.rateType = rateType;
        Property = property;
        this.value = value;
        this.base = base;
        this.paysLip = paysLip;
    }

}
