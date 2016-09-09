
package fr.afpa.librairie.data.dao;

import fr.afpa.librairie.data.bean.Adresse;
import fr.afpa.librairie.data.bean.Utilisateur;
import fr.afpa.librairie.data.exception.DAOException;
import java.util.List;

public interface AdresseDAO extends DAOInterface<Adresse> {
    
    Adresse findByCp(String cp);
    Adresse findByVille(String ville);
    
    
}
