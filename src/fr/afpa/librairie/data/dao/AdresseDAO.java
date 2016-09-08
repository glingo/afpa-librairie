
package fr.afpa.librairie.data.dao;

import fr.afpa.librairie.data.bean.Adresse;
import fr.afpa.librairie.data.bean.Utilisateur;

public interface AdresseDAO extends DAOInterface<Adresse> {
    
    Adresse findByCp(String cp);
    Adresse findByVille(String ville);
    Adresse findByUtilisateur(Utilisateur utilisateur);
}
