package fr.afpa.librairie.data.bean;

/**
 * Enregistre les différentes info. relatives aux mots-clefs utilisés pour
 * résumer un ouvrage.
 *
 */
public class Tag {

        /**
     * Séquentiel de la table Tag généré automatiquement par la
     * BDD.
     */
    private Long id;
        /**
     * Libellé du mot-clef.
     *
     */
    private String libelle;

        /**
     * Constructeur de la classe; accès sans utiliser de paramètres.
     */
    public Tag() {}
    
    public Tag(String libelle) {
        this.libelle = libelle;
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
//        return "Tag{" + "id=" + id + ", libelle=" + libelle + '}';
        return libelle;
    }

}
