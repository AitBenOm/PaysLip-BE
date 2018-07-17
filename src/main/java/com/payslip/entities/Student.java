package com.payslip.entities;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
public class Student {

    @Id
    @GeneratedValue
    public int  numEtudiant;
    public String nom;
    public String prenom;
    @Temporal(TemporalType.DATE)
    public Date date_de_naissance;
    public String adresse;
    public String contacts;
    public String email;
    public String sex;
    public String level;

    public Student(String nom, String prenom, Date date_de_naissance, String adresse, String contacts, String email, String sex, String level) {
        this.nom = nom;
        this.prenom = prenom;
        this.date_de_naissance = date_de_naissance;
        this.adresse = adresse;
        this.contacts = contacts;
        this.email = email;
        this.sex = sex;
        this.level = level;
    }

    public Student() {
    }

    public int getNumEtudiant() {
        return numEtudiant;
    }

    public void setNumEtudiant(int numEtudiant) {
        this.numEtudiant = numEtudiant;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public Date getDate_de_naissance() {
        return date_de_naissance;
    }

    public void setDate_de_naissance(Date date_de_naissance) {
        this.date_de_naissance = date_de_naissance;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getContacts() {
        return contacts;
    }

    public void setContacts(String contacts) {
        this.contacts = contacts;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }
}
