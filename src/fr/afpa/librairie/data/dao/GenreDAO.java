
package fr.afpa.librairie.data.dao;

import fr.afpa.librairie.data.bean.Genre;

public interface GenreDAO extends DAOInterface<Genre> {
    
    Genre findByLibelle(String libelle);
    
}

