package fr.afpa.librairie.data.bean;

import java.sql.Date;

/**
 * Enregistre les différetes info. relatives à la commande d'un ouvrage.
 *
 * @see Ouvrage
 */
public class Commande {
    
    /**
     * Séquentiel de la table Commande automatiquement généré par la BDD.
     */
    private Long id;
    /**
     * Numero de commande(String car ne fera pas l'objet de calculs).
     */
    private String numero;
    /**
     * Date de commande
     */
    private Date dateCommande;
    /**
     * Informations relatives au client effectuant la commande.
     *
     * @see Utilisateur
     */
    private Utilisateur user;
    /**
     * Informations relatives au statut d'une commande.
     *
     * @see StatutCommande
     * @see StatutCommandeDAO
     */
    private StatutCommande orderStat;

    /**
     * Constructeur de la classe; accès sans utiliser de paramètres.
     */
    public Commande() {
    }

    /**
     * Retourne l'id (généré par la BDD) de la commande.
     *
     * @return Id (généré par la BDD) de la commande sous la forme de nombre
     * d'un entier (long).
     */
    public Long getId() {
        return id;
    }

    /**
     * Met à jour l'id (généré par la BDD).
     *
     * @param id Nouvel id de la commande.
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Retourne le numéro de commande.
     *
     * @return Numero de commande (String).
     */
    public String getNumero() {
        return numero;
    }

    /**
     * Met à jour le numéro de commande.
     *
     * @param numero Nouveau numéro de commande.
     */
    public void setNumero(String numero) {
        this.numero = numero;
    }

    /**
     * Retourne la date de commande.
     *
     * @return Date de commande (Date).
     */
    public Date getDateCommande() {
        return dateCommande;
    }

    /**
     * Met à jour la date de commande.
     *
     * @param dateCommande Nouvelle date de commande.
     */
    public void setDateCommande(Date dateCommande) {
        this.dateCommande = dateCommande;
    }

    /**
     * Retourne les infos relatives au client.
     *
     * @see Utilisateur
     * @return Paramètres client (Utilisateur).
     */
    public Utilisateur getUser() {
        return user;
    }

    /**
     * Met à jour les paramètres du client.
     *
     * @param user Nouveaux paramètres client (Utilisateur).
     */
    public void setUser(Utilisateur user) {
        this.user = user;
    }

    /**
     * Retourne l'état de la commande.
     *
     * @see StatutCommande
     * @StatutCommandeDAO
     * @return L'état de la commande (StatutCommande).
     */
    public StatutCommande getOrderStat() {
        return orderStat;
    }

        /**
     * Met à jour l'état de la commande.
     *
     * @param orderStat
     * @see StatutCommande
     * @StatutCommandeDAO
     */
    public void setOrderStat(StatutCommande orderStat) {
        this.orderStat = orderStat;
    }

    @Override
    public String toString() {
        return "Commande{" + "id=" + id + ", numero=" + numero + ", dateCommande=" + dateCommande + '}';
    }

}
