package com.payslip.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int matricule;
    private String nom;
    private String prenom;
    @Temporal(TemporalType.DATE)
    private Date date_de_naissance;
    @Temporal(TemporalType.DATE)
    private Date date_emb;
    private String fonction;
    private String adresse;
    private String telephone;
    private String email;
    private String numCNSS;
    private String numCin;
    private String sex;
    private String situationFamiliale;
    private int nbEnfant;
    private  float salaireDeBase;

    @JsonIgnore
    @OneToMany(mappedBy="employee",cascade =CascadeType.ALL, fetch=FetchType.EAGER)
    private List<PaysLip> paysLip;

    public Employee(String nom, String prenom, Date date_de_naissance, Date date_emb, String fonction, String adresse, String telephone, String email, String numCNSS, String numCin, String sex, String situationFamiliale, int nbEnfant, float salaireDeBase) {
        this.nom = nom;
        this.prenom = prenom;
        this.date_de_naissance = date_de_naissance;
        this.date_emb = date_emb;
        this.fonction = fonction;
        this.adresse = adresse;
        this.telephone = telephone;
        this.email = email;
        this.numCNSS = numCNSS;
        this.numCin = numCin;
        this.sex = sex;
        this.situationFamiliale = situationFamiliale;
        this.nbEnfant = nbEnfant;
        this.salaireDeBase = salaireDeBase;
    }

    public Employee() {
    }

    public int getMatricule() {
        return matricule;
    }

    public void setMatricule(int matricule) {
        this.matricule = matricule;
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

    public Date getDate_emb() {
        return date_emb;
    }

    public void setDate_emb(Date date_emb) {
        this.date_emb = date_emb;
    }

    public String getFonction() {
        return fonction;
    }

    public void setFonction(String fonction) {
        this.fonction = fonction;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNumCNSS() {
        return numCNSS;
    }

    public void setNumCNSS(String numCNSS) {
        this.numCNSS = numCNSS;
    }

    public String getNumCin() {
        return numCin;
    }

    public void setNumCin(String numCin) {
        this.numCin = numCin;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getSituationFamiliale() {
        return situationFamiliale;
    }

    public void setSituationFamiliale(String situationFamiliale) {
        this.situationFamiliale = situationFamiliale;
    }

    public int getNbEnfant() {
        return nbEnfant;
    }

    public void setNbEnfant(int nbEnfant) {
        this.nbEnfant = nbEnfant;
    }

    public float getSalaireDeBase() {
        return salaireDeBase;
    }

    public void setSalaireDeBase(float salaireDeBase) {
        this.salaireDeBase = salaireDeBase;
    }
}
