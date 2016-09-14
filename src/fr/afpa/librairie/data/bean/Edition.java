package fr.afpa.librairie.data.bean;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

/**
 * Enregistre les différetes info. relatives à l'édition d'un ouvrage.
 *
 * @see Ouvrage
 */
public class Edition {

    /**
     * Isbn : numero unique identifiant l'édition d'un ouvrage. (chaque édition
     * différente d'un même ouvrage aura un isbn différent) l'isbn est composé
     * de 10 chiffres (13 avec les tirets) jusqu'en 2006 et de 13 (17 avec les
     * tirets) chiffres à partir du 1er janvier 2007. (propriété typée String
     * car ne fera pas l'objet de calculs).
     */
    private String isbn;
    /**
     * Date de parution (typée Date).
     */
    private Date datePublication;
    /**
     * Prix hors taxes (typé float).
     */
    private float prixHt;
    /**
     * String spécifiant le chemin d'accès à l'image de couverture.
     */
    private String couverture;
    /**
     * Titre de l'édition(au cas où il serait différent de celui de l'ouvrage).
     */
    private String titre;
    /**
     * Quantité physique disponible.
     */
    private int stock;

    /**
     * Statut de l'édition.
     *
     * @see StatutEdition
     * @see StatutEditionDAO
     */
    private StatutEdition statut;
    /**
     * Ouvrage auquel se réfère l'édition.
     *
     * @see Ouvrage
     */
    private Ouvrage ouvrage;
    /**
     * Langue dans laquelle est publiée l'ouvrage
     *
     * @see Langue
     */
    private Langue langue;
    /**
     * Liste (s'il venait à y avoir plus d'une taxe) des taxes applicables à
     * l'édition. Utilisation d'une collection liste pour enregistrer l'ensemble
     * des taxes applicables.
     *
     * @see Taxe
     */
    private List<Taxe> taxes;

    /**
     * Constructeur de la classe; accès sans utiliser de paramètres.
     */
    public Edition() {
    }

    /**
     * Retourne l'ISBN de l'édition.
     *
     * @param isbn
     * @return Numéro d'ISBN.
     */
    public String getIsbn() {
        return isbn;
    }

    /**
     * Met à jour l'ISBN.
     *
     * @param isbn Nouveau numéro d'ISBN.
     */
    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    /**
     * Retourne la date de publication.
     *
     * @param datePublication
     * @return La date de publication (typée Date) de l'auteur.
     */
    public Date getDatePublication() {
        return datePublication;
    }

    /**
     * Met à jour la date de publication.
     *
     * @param datePublication Nouvelle date de publication (typée Date).
     */
    public void setDatePublication(Date datePublication) {
        this.datePublication = datePublication;
    }

    /**
     * Retourne le pirx hors taxes.
     *
     * @param prixHt
     * @return Prix hors taxes.
     */
    public float getPrixHt() {
        return prixHt;
    }

    /**
     * Met à jour le prix hors taxes.
     *
     * @param prixHt Nouveau prix hors taxes (typé float).
     */
    public void setPrixHt(float prixHt) {
        this.prixHt = prixHt;
    }

    /**
     * Retourne le chemin d'accès à l'image de couverture.
     *
     * @param isbn
     * @return Chemin d'accès à l'image de couverture.
     */
    public String getCouverture() {
        return couverture;
    }

    /**
     * Met à jour le chemin spécifiant le chemin d'accès à l'image de
     * couverture.
     *
     * @param couverture Nouveau chemin d'accès à l'image de couverture (typé
     * String).
     */
    public void setCouverture(String couverture) {
        this.couverture = couverture;
    }

    /**
     * Retourne le titre.
     *
     * @param titre
     * @return Titre de l'édition.
     */
    public String getTitre() {
        return titre;
    }

    /**
     * Met à jour le titre.
     *
     * @param titre Nouveau Titre.
     */
    public void setTitre(String titre) {
        this.titre = titre;
    }

    /**
     * Retourne le stock disponible.
     *
     * @param stock
     * @return Stock disponible.
     */
    public int getStock() {
        return stock;
    }

    /**
     * Met à jour le stock.
     *
     * @param stock Nouveau stock.
     */
    public void setStock(int stock) {
        this.stock = stock;
    }

    /**
     * Retourne le statut de l'édition.
     *
     * @return Statut de l'édition.
     * 
     * @param statut
     * 
     * @see StatutEdition
     * @see StatutEditionDAO
     * 
     */
    public StatutEdition getStatut() {
        return statut;
    }

    /**
     * Met à jour le statut de l'édition.
     *
     * @param statut Nouveau Statut d'édition.
     *
     * @see StatutEdition
     * @see StatutEditionDAO
     * 
     * @return Statut de l'édition.
     *
     */
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
