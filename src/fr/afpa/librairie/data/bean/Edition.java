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
    private Ouvrage ouvrage;
    private Langue langue;
    private List<Taxe> taxes;

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

    public StatutEdition getStatut() {
        return statut;
    }

    public void setStatut(StatutEdition statut) {
        this.statut = statut;
    }

    public Ouvrage getOuvrage() {
        return ouvrage;
    }

    public void setOuvrage(Ouvrage ouvrage) {
        this.ouvrage = ouvrage;

    }

    public Langue getLangue() {
        return langue;
    }

    public void setLangue(Langue langue) {
        this.langue = langue;
    }

    public List<Taxe> getTaxes() {
        return taxes;
    }

    public void setTaxes(List<Taxe> taxes) {
        this.taxes = taxes;
    }

    @Override
    public String toString() {
        return "Edition{"
                + "isbn=" + isbn
                + ", datePublication=" + datePublication
                + ", prixHt=" + prixHt
                + ", couverture=" + couverture
                + ", titre=" + titre
                + ", stock=" + stock
                + ", statut=" + statut
                + ", ouvrage=" + ouvrage
                + ", langue=" + langue
                + ", taxes=" + taxes + '}';
    }

}
