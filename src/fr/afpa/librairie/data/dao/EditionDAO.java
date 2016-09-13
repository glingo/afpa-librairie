
package fr.afpa.librairie.data.dao;

import fr.afpa.librairie.data.bean.Edition;
import fr.afpa.librairie.data.exception.DAOException;
import java.sql.Date;
import java.util.List;

public interface EditionDAO extends DAOInterface<Edition> {
    
    Edition findByIsbn(String isbn);
    Edition findByDatePubli(Date datePubli);
    Edition findByTitre(String titre);
    Edition findByStock(int stock);
    
   
}
