package com.payslip.entities;

public class Service {
    private int idService;
    private String  description;

    public Service(String description) {
        this.description = description;
    }

    public int getIdService() {
        return idService;
    }

    public void setIdService(int idService) {
        this.idService = idService;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
