
package fr.afpa.librairie.data.dao;

import fr.afpa.librairie.data.bean.Tag;
import fr.afpa.librairie.data.exception.DAOException;
import java.util.List;

public interface TagDAO extends DAOInterface<Tag> {
    
    Tag findByLibelle(String libelle);
    
    List<Tag> findByOuvrage(Long idOuvrage) throws DAOException;
}
