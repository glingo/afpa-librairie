
package fr.afpa.librairie.data.bean;

/**
 * Création d'un objet Editeur contenant :
 * 
 * - l'id (correspond au séquentiel automatiquement généré par la BDD et typé long
 * - libelle : nom de l'éditeur
 */
public class Editeur {
    private long id;
    private String libelle;

    public Editeur() {
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
        return "Editeur{" + "id=" + id + ", libelle=" + libelle + '}';
    }
    
    
}
