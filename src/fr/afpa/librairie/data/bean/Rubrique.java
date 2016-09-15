package fr.afpa.librairie.data.bean;

import java.sql.Date;

/**
 * Enregistre les différentes info. relatives à une rubrique.
 */
public class Rubrique {

    /**
     * Séquentiel de la table Rubrique généré automatiquement par la BDD.
     */
    private Long id;
    /**
     * Nom de la rubrique.
     */
    private String libelle;
    /**
     * Date d'entrée en vigueur de la rubrique.
     */
    private Date dateDebut;
    /**
     * Date de fin de la rubrique.
     */
    private Date dateFin;
    /**
     * Info. relatives à la rubrique.
     */
    private String commentaire;

    /**
     * Constructeur de la classe; accès sans utiliser de paramètres.
     */
    public Rubrique() {
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

    public String getCommentaire() {
        return commentaire;
    }

    public void setCommentaire(String commentaire) {
        this.commentaire = commentaire;
    }

    public String toString() {
        return libelle;
    }

}
