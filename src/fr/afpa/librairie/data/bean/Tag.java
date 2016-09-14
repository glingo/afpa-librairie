
package fr.afpa.librairie.data.bean;

public class Tag {
    
    private Long id;
    private String libelle;

    public Tag() {
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
