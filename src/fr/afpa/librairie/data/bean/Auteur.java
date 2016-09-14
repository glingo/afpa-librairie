package fr.afpa.librairie.data.bean;

import java.sql.Date;

/**
 * Enregistre les différetes info. relatives à l'auteur d'un ouvrage.
 *
 * @see Ouvrage
 */
public class Auteur {

    /**
     * Séquentiel de la table Auteur automatiquement généré par la BDD.
     */
    private Long id;
    /**
     * Nom de l'auteur.
     */
    private String nom;
    /**
     * Prénom, s'il y a, lieu.
     */
    private String prenom;
    /**
     * Date de naissance : permettra par la suite, au besoin, de catégoriser un
     * auteur selon son époque
     */
    private Date dateNaissance;
    /**
     * Date de décès, s'il y a, lieu.
     */
    private Date dateDeces;

    /**
     * Constructeur de la classe; accès sans utiliser de paramètres.
     */
    public Auteur() {
    }

    /**
     * Constructeur de la classe avec paramètres;
     * permet l'appel au constructeur en spécifiant les paramètres.
     *
     * @param id
     * @param nom
     * @param dateNaissance
     * @param dateDeces
     */
    public Auteur(Long id, String nom, Date dateNaissance, Date dateDeces) {
        this.id = id;
        this.nom = nom;
        this.dateNaissance = dateNaissance;
        this.dateDeces = dateDeces;
    }

    /**
     * Retourne l'id (généré par la BDD).
     *
     * @param id
     * @return L'id (généré par la BDD) sous la forme d'un entier (typé long).
     */
    public Long getId() {
        return id;
    }

     /**
     * Met à jour l'id (généré par la BDD).
     *
     * @param id Nouvel id de l'adresse.
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Retourne le nom de l'auteur.
     *
     * @param nom
     * @return Le nom de l'auteur.
     */
    public String getNom() {
        return nom;
    }

    /**
     * Met à jour le nom de l'auteur.
     *
     * @param nom 
     * Nouveau nom de l'auteur.
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

    /**
     * Retourne le prénom de l'auteur.
     *
     * @param prenom
     * @return Le prénom de l'auteur.
     */
    public String getPrenom() {
        return prenom;
    }

    /**
     * Met à jour le prenom de l'auteur.
     *
     * @param prenom 
     * Nouveau prénom de l'auteur.
     */
    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    /**
     * Retourne la date de naissance de l'auteur.
     *
     * @param dateNaissance
     * @return La date de naissance (typée Date) de l'auteur.
     */
    public Date getDateNaissance() {
        return dateNaissance;
    }

    /**
     * Met à jour la date de naissance de l'auteur.
     *
     * @param dateNaissance 
     * Nouvelle date de naissance de l'auteur.
     */
    public void setDateNaissance(Date dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    /**
     * Retourne la date de décès de l'auteur, si elle existe.
     *
     * @param dateDeces
     * @return La date de décès ( typée Date) de l'auteur, si elle existe.
     */
    public Date getDateDeces() {
        return dateDeces;
    }

    /**
     * Met à jour la date de décès de l'auteur.
     *
     * @param dateDeces 
     * Nouvelle date de décès de l'auteur.
     */
    public void setDateDeces(Date dateDeces) {
        this.dateDeces = dateDeces;
    }

    @Override
    public String toString() {
        return prenom + " " + nom;
    }

}
