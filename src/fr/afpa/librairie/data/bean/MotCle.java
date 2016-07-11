/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.afpa.librairie.data.bean;

/**
 *
 * @author cdi309
 */
public class MotCle {
    private long id;
    private String libelle;

    public MotCle() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    @Override
    public String toString() {
        return "MotCle{" + "id=" + id + ", libelle=" + libelle + '}';
    }
    
    
}
