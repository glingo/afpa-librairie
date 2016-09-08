package fr.afpa.librairie.data.bean;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class Utilisateur {
    
    private Long id;
    private String nom;
    private String prenom;
    private String motDePasse;
    private String email;
    private String telephone;
    private Date dateNaissance;
    
    private List<Role> roles;
    private StatutUtilisateur statut;
    private List<Adresse> dernieresLivraisons;
    private List<Adresse> dernieresFacturations;

    public Utilisateur() {}

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

    public String getMotDePasse() {
        return motDePasse;
    }

    public void setMotDePasse(String motDePasse) {
        this.motDePasse = motDePasse;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(Date dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    public StatutUtilisateur getStatut() {
        return statut;
    }

    public void setStatut(StatutUtilisateur statut) {
        this.statut = statut;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }
    
    public void addRole(Role role) {
        if(this.roles == null) {
            this.roles = new ArrayList<>();
        }
        
        this.roles.add(role);
    }
    
    public List<Adresse> getDernieresLivraisons(){
        return dernieresLivraisons;
    }
    
    public void setDernieresLivraisons(List<Adresse> adresses){
        this.dernieresLivraisons = adresses;
    }
    
    public void addDerniereLivraison(Adresse adresse){
        if(this.dernieresLivraisons == null){
            this.dernieresLivraisons = new ArrayList<>();
        }
        
        this.dernieresLivraisons.add(adresse);
    }
    
    public List<Adresse> getDernieresFacturations(){
        return dernieresFacturations;
    }
    
    public void setDernieresFacturations(List<Adresse> adresses){
        this.dernieresFacturations = adresses;
    }
    
    public void addDerniereFacturation(Adresse adresse){
        if(this.dernieresFacturations == null){
            this.dernieresFacturations = new ArrayList<>();
        }
        
        this.dernieresFacturations.add(adresse);
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }
    
}
