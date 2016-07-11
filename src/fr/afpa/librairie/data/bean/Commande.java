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
public class Commande {
    private long id;
    private String numero;
    private Date dateCommande;

    public Commande() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public Date getDateCommande() {
        return dateCommande;
    }

    public void setDateCommande(Date dateCommande) {
        this.dateCommande = dateCommande;
    }

    @Override
    public String toString() {
        return "Commande{" + "id=" + id + ", numero=" + numero + ", dateCommande=" + dateCommande + '}';
    }
    
    
}
