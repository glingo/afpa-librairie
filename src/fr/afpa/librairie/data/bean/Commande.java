
package fr.afpa.librairie.data.bean;

import java.sql.Date;

/**
 * Création d'un objet Commande contenant :
 * 
 * - l'id (correspond au séquentiel automatiquement généré par la BDD et typé long
 * - numero : de commande (String car ne fera pas l'objet de calculs)
 * - date 
 * - Client (Utilisateur user) : Classe contenant toutes les infos relatives au client 
 * - Statut de la Commande (StatutCommande orderStat) : Classe contenant toutes les infos relatives à l'état de la commande
 * (StatutCommandeDAO)
 * - complement : infos complémentaires optionnelles concernant l'adresse
 * 
 *  nb : le pays est un objet à part
 */
public class Commande {
    
    private Long id;
    private String numero;
    private Date dateCommande;
    
    private Utilisateur user;
    private StatutCommande orderStat;
    
    public Commande() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public Date getDateCommande() {
        return dateCommande;
    }

    public void setDateCommande(Date dateCommande) {
        this.dateCommande = dateCommande;
    }
    

    public Utilisateur getUser(){
        return user;
    }
    
    public void setUser(Utilisateur user){
        this.user = user;
    }
    
    public StatutCommande getOrderStat(){
        return orderStat;
    }
    
    public void setOrderStat(StatutCommande orderStat){
        this.orderStat = orderStat;
    }
    
    @Override
    public String toString() {
        return "Commande{" + "id=" + id + ", numero=" + numero + ", dateCommande=" + dateCommande + '}';
    }
    
    
}
