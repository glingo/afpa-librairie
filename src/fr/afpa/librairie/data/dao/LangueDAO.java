
package fr.afpa.librairie.data.dao;

import fr.afpa.librairie.data.bean.Langue;
import fr.afpa.librairie.data.exception.DAOException;
import java.util.List;

public interface LangueDAO extends DAOInterface<Langue> {
    
    Langue findByLibelle(String libelle);
    Langue findByCode(String code);
    
    List<Langue> findByEdition(String isbn) throws DAOException;
    
}
