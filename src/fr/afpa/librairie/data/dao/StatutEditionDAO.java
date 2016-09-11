
package fr.afpa.librairie.data.dao;

import fr.afpa.librairie.data.bean.StatutEdition;
import fr.afpa.librairie.data.exception.DAOException;
import java.util.List;

public interface StatutEditionDAO extends DAOInterface<StatutEdition>{
    StatutEdition findByCode(String code);
    
    List<StatutEdition> findByEdition(String isbn) throws DAOException;
}
