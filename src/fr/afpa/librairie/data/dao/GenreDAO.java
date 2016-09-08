
package fr.afpa.librairie.data.dao;

import fr.afpa.librairie.data.bean.Genre;
import fr.afpa.librairie.data.exception.DAOException;
import java.util.List;

public interface GenreDAO extends DAOInterface<Genre> {
    
    Genre findByLibelle(String libelle);
    
    List<Genre> findByOuvrage(Long idOuvrage) throws DAOException;
    
}

