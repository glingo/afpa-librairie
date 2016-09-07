
package fr.afpa.librairie.data.dao;

import fr.afpa.librairie.data.bean.Theme;
import fr.afpa.librairie.data.exception.DAOException;
import java.util.List;

public interface ThemeDAO extends DAOInterface<Theme>{
    
     Theme findByLibelle(String libelle);
     
     List<Theme> findByOuvrage(Long idOuvrage) throws DAOException;
}
