
package fr.afpa.librairie.data.dao;

import fr.afpa.librairie.data.bean.Adresse;

public interface AdresseDAO extends DAOInterface<Adresse> {
    
    Adresse findByCp(String cp);
    Adresse findByVille(String ville);
    
}
