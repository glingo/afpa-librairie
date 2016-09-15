package fr.afpa.librairie.data.bean;

/**
 * Enregistre les différentes info. relatives à un pays.
 *
 */
public class Pays {

    /**
     * Séquentiel de la table Pays généré automatiquement par la BDD.
     */
    private Long id;
    /**
     * Nom du pays
     */
    private String libelle;
    /**
     * Code du pays.
     */
    private String code;

    /**
     * Constructeur de la classe; accès sans utiliser de paramètres.
     */
    public Pays() {
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

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return "Pays{" + "id=" + id + ", libelle=" + libelle + ", code=" + code + '}';
    }

}
