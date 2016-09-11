
package fr.afpa.librairie.data.bean;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class Edition {
    private String isbn;
    private Date datePublication;
    private float prixHt;
    private String couverture;
    private String titre;
    private int stock;
    
    
    private StatutEdition statut;
    private Ouvrage titreOuvrage;
    private Langue langue;
    private Taxe taxe;

    
    public Edition() {
    }
    

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public Date getDatePublication() {
        return datePublication;
    }

    public void setDatePublication(Date datePublication) {
        this.datePublication = datePublication;
    }

    public float getPrixHt() {
        return prixHt;
    }

    public void setPrixHt(float prixHt) {
        this.prixHt = prixHt;
    }

    public String getCouverture() {
        return couverture;
    }

    public void setCouverture(String couverture) {
        this.couverture = couverture;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
    
    public StatutEdition getStatut(){
        return statut;
    }
    
    public void setStatut(StatutEdition statut){
        this.statut = statut;
    }
    
    public Ouvrage getTitreOuvrage(){
        return titreOuvrage;
    }
    
    public void setTitreOuvrage(Ouvrage titreOuvrage){
        this.titreOuvrage = titreOuvrage;
        
    }
    
    public Langue getLangue(){
        return langue;
    }
    
    public void setLangue(Langue langue){
        this.langue = langue;
    }
    
    
    public Taxe getTaxe(){
        return taxe;
    }
    
    public void setTaxe(Taxe taxe){
        this.taxe = taxe;
    }

    @Override
    public String toString() {
        return "Edition{" + "isbn=" + isbn + ", datePublication=" + datePublication + ", prixHt=" + prixHt + ", couverture=" + couverture + ", titre=" + titre + ", stock=" + stock + ", statut=" + statut + ", titreOuvrage=" + titreOuvrage + ", langue=" + langue + ", taxe=" + taxe + '}';
    }

}
