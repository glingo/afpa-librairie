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
public class Editeur {
    private long id;
    private String libelle;

    public Editeur() {
    }

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

    @Override
    public String toString() {
        return "Editeur{" + "id=" + id + ", libelle=" + libelle + '}';
    }
    
    
}
