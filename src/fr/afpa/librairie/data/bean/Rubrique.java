package fr.afpa.librairie.data.bean;

import java.sql.Date;

public class Rubrique {
    
    private Long id;
    private String libelle;
    
    private Date dateDebut;
    private Date dateFin;
    private String commentaire;

    public Rubrique() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public Date getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(Date dateDebut) {
        this.dateDebut = dateDebut;
    }

    public Date getDateFin() {
        return dateFin;
    }

    public void setDateFin(Date dateFin) {
        this.dateFin = dateFin;
    }
    
    public String getCommentaire(){
        return commentaire;
    }
    
    public void setCommentaire(String commentaire){
        this.commentaire = commentaire;
    }
    
}
