/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.afpa.librairie.data.bean;

import java.sql.Date;

/**
 *
 * @author cdi309
 */
public class HistoriqueStatutCommande {
    private long id;
    private Date datePassage;
    private String commentaire;
    
    

    public HistoriqueStatutCommande() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getDatePassage() {
        return datePassage;
    }

    public void setDatePassage(Date datePassage) {
        this.datePassage = datePassage;
    }

    public String getCommentaire() {
        return commentaire;
    }

    public void setCommentaire(String commentaire) {
        this.commentaire = commentaire;
    }

    @Override
    public String toString() {
        return "HistoriqueStatutCommande{" + "id=" + id + ", datePassage=" + datePassage + ", commentaire=" + commentaire + '}';
    }
    
    
}
