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
 * @author cdi309
 */
public class Promotion {
    private long id;
    private Date dateDebut;
    private Date dateFin;
    private float reduction;
    private String image;
    private String description;
    private String commentaire;
 

    public Promotion() {
    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Float getReduction() {
        return reduction;
    }

    public void setReduction(Float reduction) {
        this.reduction = reduction;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCommentaire() {
        return commentaire;
    }

    public void setCommentaire(String commentaire) {
        this.commentaire = commentaire;
    }

    @Override
    public String toString() {
        return "Promotion{" + "id=" + id + ", dateDebut=" + dateDebut + ", dateFin=" + dateFin + ", reduction=" + reduction + ", image=" + image + ", description=" + description + ", commentaire=" + commentaire + '}';
    }

    
    
    
    
}
