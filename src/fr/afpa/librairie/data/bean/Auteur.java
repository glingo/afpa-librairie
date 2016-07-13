/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.afpa.librairie.data.bean;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author cdi305
 */
public class Auteur {

    private Long id;
    private String nom;
    private String prenom;
    private Date dateNaissance;
    private Date dateDeces;
    
    private Ouvrage ouvrage;
    
    public Auteur() {
    }

    public Auteur(Long id, String nom, Date dateNaissance, Date dateDeces) {
        this.id = id;
        this.nom = nom;
        this.dateNaissance = dateNaissance;
        this.dateDeces = dateDeces;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Date getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(Date dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    public Date getDateDeces() {
        return dateDeces;
    }

    public void setDateDeces(Date dateDeces) {
        this.dateDeces = dateDeces;
    }
    
    public Ouvrage getOuvrage() {
        return ouvrage;
    }
    
    public void setOuvrage(Ouvrage ouvrage){
        this.ouvrage = ouvrage;
    }
//
//    public List<Ouvrage> getOuvrages(){
//        return ouvrages;
//    }
//    
//    public void setOuvrages(List<Ouvrage> ouvrages){
//        this.ouvrages = ouvrages;
//    }
//    
//    public void addOuvrage(Ouvrage ouvrage){
//        if(this.ouvrages == null){
//            this.ouvrages = new ArrayList<>();
//        }
//        this.ouvrages.add(ouvrage);
//    }
//    

    @Override
    public String toString(){
        return prenom+" "+nom;
    }
            
}
