
package fr.afpa.librairie.data.dao;

import fr.afpa.librairie.data.bean.Pays;
import fr.afpa.librairie.data.exception.DAOException;

public interface PaysDAO extends DAOInterface<Pays> {
    
    Pays findByLibelle(String libelle);
    
    Pays findByCode(String code) throws DAOException;
}
