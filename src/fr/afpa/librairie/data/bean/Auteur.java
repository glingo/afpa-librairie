package fr.afpa.librairie.data.bean;

import java.sql.Date;

public class Auteur {

    private Long id;
    private String nom;
    private String prenom;
    private Date dateNaissance;
    private Date dateDeces;
    
    public Auteur() { }

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
    
    @Override
    public String toString(){
        return prenom+" "+nom;
    }
            
}
