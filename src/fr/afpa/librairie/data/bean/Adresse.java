package fr.afpa.librairie.data.bean;

/**
 * Enregistre les différents éléments d'une adresse.
 *
 * @see Utilisateur
 */
public class Adresse {
    
    /**
     * Séquentiel de la table Adresse automatiquement généré par la BDD.
     */
    private Long id;
    
    /**
     * Numero de la rue , l'allee etc... (String car ne fera pas l'objet de
     * calculs).
     */
    private String numero;
    /**
     * Nom de la rue, alléee, voie etc... .
     */
    private String voie;
    /**
     * Code postal.
     */
    private String cp;
    /**
     * Nom de la ville.
     */
    private String ville;
    /**
     * Infos complémentaires optionnelles concernant l'adresse.
     */
    private String complement;

    /**
     * Constructeur de la classe; accès sans utiliser de paramètres.
     */
    public Adresse() {
    }

    /**
     * Retourne l'id (généré par la BDD).
     *
     * @return Id (généré par la BDD) sous la forme d'un entier (long).
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
     * Retourne le numéro de rue, allée etc.
     *
     * @return Numéro de rue (String).
     *
     */
    public String getNumero() {
        return numero;
    }

    /**
     * Met à jour le numéro de rue, allée etc.
     *
     * @param numero Nouveau numero de rue.
     */
    public void setNumero(String numero) {
        this.numero = numero;
    }

    /**
     * Retourne le nom de rue, allée.
     *
     * @return Nom de rue.
     */
    public String getVoie() {
        return voie;
    }

    /**
     * Met à jour le nom de rue, allée etc.
     *
     * @param nom Nouveau nom de rue.
     */
    public void setVoie(String voie) {
        this.voie = voie;
    }

    /**
     * Retourne le code postal.
     *
     * @return Code postal (String).
     */
    public String getCp() {
        return cp;
    }

    /**
     * Met à jour le code postal.
     *
     * @param cp Nouveau code postal.
     */
    public void setCp(String cp) {
        this.cp = cp;
    }

    /**
     * Retourne le nom de la ville.
     *
     * @param ville
     * @return Nom de la ville.
     */
    public String getVille() {
        return ville;
    }

    /**
     * Met à jour le nom de la ville.
     *
     * @param ville Nouveau nom de ville.
     */
    public void setVille(String ville) {
        this.ville = ville;
    }

    /**
     * Retourne le(s) complément(s) d'info relatif(s) à l'adresse.
     *
     * @return Ajout/modification du/des complément(s) d'info. de l'adresse.
     */
    public String getComplement() {
        return complement;
    }

    /**
     * Met à jour le(s) complément(s) d'info relatives à l'adresse.
     *
     * @param complement Complément(s) d'info de l'adresse ajouté(s)/mis à jour.
     */
    public void setComplement(String complement) {
        this.complement = complement;
    }

    @Override
    public String toString() {
        return "Adresse{" + "id=" + id + ", numero=" + numero + ", voie=" + voie + ", cp=" + cp + ", ville=" + ville + ", complement=" + complement + '}';
    }

}
