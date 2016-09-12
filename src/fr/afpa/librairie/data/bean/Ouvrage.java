package fr.afpa.librairie.data.bean;

import java.util.ArrayList;
import java.util.List;

public class Ouvrage {
    
    private Long id;
    
    private String titre;
    
    private String sousTitre;
    
    private String resume;
    
    private Auteur auteur;
    
    private List<Auteur> coAuteurs;
    
//    private Langue langue;
    private List<Theme> themes;
    private List<Rubrique> rubriques;
    private List<Genre> genres;
    private List<Tag> tags;
    
    public Ouvrage() {}

    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getSousTitre() {
        return sousTitre;
    }

    public void setSousTitre(String sousTitre) {
        this.sousTitre = sousTitre;
    }

    public String getResume() {
        return resume;
    }

    public void setResume(String resume) {
        this.resume = resume;
    }

    public Auteur getAuteur() {
        return auteur;
    }

    public void setAuteur(Auteur auteur) {
        this.auteur = auteur;
    }

    public List<Auteur> getCoAuteurs() {
        return coAuteurs;
    }

    public void setCoAuteurs(List<Auteur> coAuteurs) {
        this.coAuteurs = coAuteurs;
    }
    
    public void addCoAuteur(Auteur coAuteur) {
        if(this.coAuteurs == null) {
            this.coAuteurs = new ArrayList<>();
        }
        
        this.coAuteurs.add(coAuteur);
    }
    
 
    
    public List<Theme> getThemes() {
        return themes;
    }

    public void setThemes(List<Theme> themes) {
        this.themes = themes;
    }
    
    public void addTheme(Theme theme) {
        if(this.themes == null) {
            this.themes = new ArrayList<>();
        }
        
        this.themes.add(theme);
    }
    
//    public Langue getLangue(){
//        return langue;
//    }
//    
//    public void setLangue(Langue langue){
//        this.langue = langue;
//    }
    
    public List<Rubrique> getRubriques() {
        return rubriques;
    }

    public void setRubriques(List<Rubrique> rubriques) {
        this.rubriques = rubriques;
    }
    
    public void addRubrique(Rubrique rubrique) {
        if(this.rubriques == null) {
            this.rubriques = new ArrayList<>();
        }
        
        this.rubriques.add(rubrique);
    }

    public List<Genre> getGenres() {
        return genres;
    }

    public void setGenres(List<Genre> genres) {
        this.genres = genres;
    }
    
    public void addGenre(Genre genre) {
        if(this.genres == null) {
            this.genres = new ArrayList<>();
        }
        
        this.genres.add(genre);
    }

    public List<Tag> getTags() {
        return tags;
    }

    public void setTags(List<Tag> tags) {
        this.tags = tags;
    }
    
    public void addTag(Tag tag) {
        if(this.tags == null) {
            this.tags = new ArrayList<>();
        }
        
        this.tags.add(tag);
    }

    @Override
    public String toString() {
        return "Ouvrage{" + "id=" + id + ", titre=" + titre + ", sousTitre=" + sousTitre + ", resume=" + resume + ", auteur=" + auteur + ", coAuteurs=" + coAuteurs + ", themes=" + themes + ", rubriques=" + rubriques + ", genres=" + genres + ", tags=" + tags + '}';
    }
    
    
    
}
