/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.afpa.librairie.data.bean;

/**
 *
 * @author cdi309
 */
public class Adresse {
    private long id;
    private String numero;
    private String voie;
    private String cp;
    private String ville;
    private String complement;

    public Adresse() {
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

    public String getVoie() {
        return voie;
    }

    public void setVoie(String voie) {
        this.voie = voie;
    }

    public String getCp() {
        return cp;
    }

    public void setCp(String cp) {
        this.cp = cp;
    }
    
    public String getVille(){
        return ville;
    }
    
    public void setVille(String ville){
        this.ville = ville;
    }

    public String getComplement() {
        return complement;
    }

    public void setComplement(String complement) {
        this.complement = complement;
    }

    @Override
    public String toString() {
        return "Adresse{" + "id=" + id + ", numero=" + numero + ", voie=" + voie + ", cp=" + cp + ", ville="+ ville +", complement=" + complement + '}';
    }
    
    
}
