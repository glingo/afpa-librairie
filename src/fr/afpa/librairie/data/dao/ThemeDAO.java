
package fr.afpa.librairie.data.dao;

import fr.afpa.librairie.data.bean.Theme;

public interface ThemeDAO extends DAOInterface<Theme>{
    
     Theme findByLibelle(String libelle);
}
