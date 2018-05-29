package com.payslip.entities;

public class Level {
    private int idLevel;
    private String  description;

    public Level(String description) {
        this.description = description;
    }

    public int getIdLevel() {
        return idLevel;
    }

    public void setIdLevel(int idLevel) {
        this.idLevel = idLevel;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
