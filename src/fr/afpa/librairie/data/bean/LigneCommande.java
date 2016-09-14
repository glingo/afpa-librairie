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
public class LigneCommande {
    
    private Long id;
    private int quantite;
    private float prixUnit;
    private float taxe;
    private float promo;

    public LigneCommande() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    public float getPrixUnit() {
        return prixUnit;
    }

    public void setPrixUnit(float prixUnit) {
        this.prixUnit = prixUnit;
    }

    public float getTaxe() {
        return taxe;
    }

    public void setTaxe(float taxe) {
        this.taxe = taxe;
    }

    public float getPromo() {
        return promo;
    }

    public void setPromo(float promo) {
        this.promo = promo;
    }

    @Override
    public String toString() {
        return "LigneCommande{" + "id=" + id + ", quantite=" + quantite + ", prixUnit=" + prixUnit + ", taxe=" + taxe + ", promo=" + promo + '}';
    }
    
    
}
