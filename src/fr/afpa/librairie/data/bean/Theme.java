
package fr.afpa.librairie.data.bean;

public class Theme {

    private Long id;
    private String libelle;

    public Theme() {
    }

    public Theme(Long id, String libelle) {
        this.id = id;
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
//        return "Theme{" + "id=" + id + ", libelle=" + libelle + '}';
        return libelle;
    }
}
