package fr.afpa.librairie.data.bean;

/**
 * Enregistre les différetes info. relatives à l'Editeur d'une Edition.
 */
public class Editeur {

    /**
     * Séquentiel de la table Editeur automatiquement généré par la BDD.
     */
    private long id;
    /**
     * Nom de l'éditeur.
     */
    private String libelle;

    /**
     * Constructeur de la classe; accès sans utiliser de paramètres.
     */
    public Editeur() {
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
     * @param id Nouvel id de l'éditeur.
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Retourne le nom de l'éditeur.
     *
     * @param libelle
     * @return Nom de l'éditeur.
     */
    public String getLibelle() {
        return libelle;
    }

    /**
     * Met à jour le nom de l'éditeur.
     *
     * @param libelle Nouveau nom de l'éditeur.
     */
    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    @Override
    public String toString() {
        return "Editeur{" + "id=" + id + ", libelle=" + libelle + '}';
    }

}
