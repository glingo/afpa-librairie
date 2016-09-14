
package fr.afpa.librairie.data.bean;

/**
 * Création d'un objet Commentaire contenant :
 * 
 * - l'id (correspond au séquentiel automatiquement généré par la BDD et typé long
 * - titre : correspond au titre de l'ouvrage commenté
 * - contenu : commentaire laissé par l'utilisateur sur l'ouvrage
 * - note : note donnée par l'utilisateur à l'ouvrage
 * 
 */
public class Commentaire {
    private long id;
    private String titre;
    private String contenu;
    private int note;

    public Commentaire() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getContenu() {
        return contenu;
    }

    public void setContenu(String contenu) {
        this.contenu = contenu;
    }

    public int getNote() {
        return note;
    }

    public void setNote(int note) {
        this.note = note;
    }

    @Override
    public String toString() {
        return "Commentaire{" + "id=" + id + ", titre=" + titre + ", contenu=" + contenu + ", note=" + note + '}';
    }
    
    
}
