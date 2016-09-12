
package fr.afpa.librairie.data.dao;

import fr.afpa.librairie.data.bean.StatutEdition;
import fr.afpa.librairie.data.exception.DAOException;
import java.util.List;

public interface StatutEditionDAO extends DAOInterface<StatutEdition>{
    
    static final String CODE_DISPONIBLE = "1";
    static final String CODE_NON_DISPONIBLE = "2";
    
    
    StatutEdition findByCode(String code);
    
    List<StatutEdition> findByEdition(String isbn) throws DAOException;
}
