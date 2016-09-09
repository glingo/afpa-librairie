
package fr.afpa.librairie.data.bean;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class Edition {
    private String isbn;
    private Date datePublication;
    private float prixHt;
    private String couverture;
    private String titre;
    private int stock;
    
    
    private List<Auteur> coAuteurs;
    private List<Langue> langues;
    private List<Genre> genres;
    private List<Theme> themes; 
    private List<Rubrique> rubriques;
    
    public Edition() {
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public Date getDatePublication() {
        return datePublication;
    }

    public void setDatePublication(Date datePublication) {
        this.datePublication = datePublication;
    }

    public float getPrixHt() {
        return prixHt;
    }

    public void setPrixHt(float prixHt) {
        this.prixHt = prixHt;
    }

    public String getCouverture() {
        return couverture;
    }

    public void setCouverture(String couverture) {
        this.couverture = couverture;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
    
    
    public List<Auteur> getCoAuteurs() {
        return coAuteurs;
    }

    public void setCoAuteurs(List<Auteur> coAuteurs) {
        this.coAuteurs = coAuteurs;
    }
    
    public void addAuteur(Auteur auteur) {
        if(this.coAuteurs == null) {
            this.coAuteurs = new ArrayList();
        }
        
        this.coAuteurs.add(auteur);
    }
    
    public List<Langue> getLangues(){
        return langues;
    }
    
    public void setLangues(List<Langue> langues){
        this.langues = langues;
    }
    
    public void addLangue(Langue langue){
        if(this.langues == null){
            this.langues = new ArrayList();
        }
        
        this.langues.add(langue);
    }
    
    public List<Genre> getGenres(){
        return genres;
    }
    
    public void setGenres(List<Genre> genres){
        this.genres = genres;
    }
    
    public void addGenre(Genre genre){
        if(this.genres == null){
            this.genres = new ArrayList();
        }
        
        this.genres.add(genre);
    }
    
    public List<Theme> getThemes(){
        return themes;
    }
    
    public void setThemes(List<Theme> themes){
        this.themes = themes;
    }
    
    public void addTheme(Theme theme){
        if(this.themes == null){
            this.themes = new ArrayList();
        }
        this.themes.add(theme);
    }
    
    public List<Rubrique> getRubriques(){
        return rubriques;
    }
    
    public void setRubriques(List<Rubrique> rubriques){
        this.rubriques = rubriques;
    }
    
    public void addRubriques(Rubrique rubrique){
        if(this.rubriques == null){
            this.rubriques = new ArrayList();
        }
        
        this.rubriques.add(rubrique);
    }

    @Override
    public String toString() {
        return "Edition{" + "isbn=" + isbn + ", datePublication=" + datePublication + ", prixHt=" + prixHt + ", couverture=" + couverture + ", titre=" + titre + ", stock=" + stock + ", coAuteurs=" + coAuteurs + ", langues=" + langues + ", genres=" + genres + ", themes=" + themes + ", rubriques=" + rubriques + '}';
    }
    
    
    
    
}
