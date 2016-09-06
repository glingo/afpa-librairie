
package fr.afpa.librairie.data.dao;

import fr.afpa.librairie.data.bean.Ouvrage;

public interface OuvrageDAO extends DAOInterface<Ouvrage> {
    
    Ouvrage findByTitre(String titre);
    Ouvrage findBySousTitre(String sousTitre);
}
