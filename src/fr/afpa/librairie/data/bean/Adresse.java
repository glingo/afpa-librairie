
package fr.afpa.librairie.data.bean;

/**
 * Création d'un objet Adresse contenant :
 * 
 * - l'id (correspond au séquentiel automatiquement généré par la BDD et typé long
 * - numero : de rue , allee etc... (String car ne fera pas l'objet de calculs)
 * - voie : nom de la rue, alléee, voie etc...
 * - cp : code postal
 * - ville : nom de la ville
 * - complement : infos complémentaires optionnelles concernant l'adresse
 * 
 *  nb : le pays est un objet à part
 */
public class Adresse {
    
    private Long id;
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
