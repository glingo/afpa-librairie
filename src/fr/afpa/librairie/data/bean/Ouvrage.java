package fr.afpa.librairie.data.bean;

import java.util.List;

public class Ouvrage {
    
    private Long id;
    
    private String titre;
    
    private String sousTitre;
    
    private String resume;
    
    private Auteur auteur;
    private List<Auteur> coAuteurs;
    
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

    public List<Theme> getThemes() {
        return themes;
    }

    public void setThemes(List<Theme> themes) {
        this.themes = themes;
    }

    public List<Rubrique> getRubriques() {
        return rubriques;
    }

    public void setRubriques(List<Rubrique> rubriques) {
        this.rubriques = rubriques;
    }

    public List<Genre> getGenres() {
        return genres;
    }

    public void setGenres(List<Genre> genres) {
        this.genres = genres;
    }

    public List<Tag> getTags() {
        return tags;
    }

    public void setTags(List<Tag> tags) {
        this.tags = tags;
    }
    
    public void addTag(Tag tag) {
        this.tags.add(tag);
    }
    
    public void addRubrique(Rubrique ru) {
        this.rubriques.add(ru);
    }
    
    public void addGenre(Genre ge) {
        this.genres.add(ge);
    }
    
    public void addTheme(Theme th) {
        this.themes.add(th);
    }
}
