package fr.afpa.librairie.data.bean;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

/**
 * Création d'un objet Edition (c'est à dire une des potentiellement multiples éditions d'un même ouvrage)contenant :
 * 
 * - l'isbn : numero unique identifiant l'édition d'un ouvrage. 
 * (chaque édition différente d'un même ouvrage aura un isbn différent)
 * l'isbn est composé de 10 chiffres (13 avec les tirets) jusqu'en 2006 
 * et de 13 (17 avec les tirets) chiffres à partir du 1er janvier 2007
 * - numero : de commande (String car ne fera pas l'objet de calculs)
 * - date de publication
 * - prix : hors taxes
 * - titre : éventuellement le titre modifié d'un ouvrage (par exp : titre français d'un ouvrage original en anglais)
 * - stock : quantité de livres physiquement disponible
 * - Statut de l'édition (StatutEdition statut) : Classe contenant toutes les infos relatives à l'état de la commande
 * (voir StatutEditionDAO)
 * - Ouvrage : Classe contenant toutes les infos relatives à l'ouvrage auquel se réfère l'édition
 * - Langue: Classe contenant toutes les infos relatives à la langue dans laquelle est rédigée l'édition
 * - Taxe : List enregistrant toutes les taxes (au cas où il y en aurait plusieurs) appliquées à l'edition
 */

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
