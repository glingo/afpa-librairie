
package fr.afpa.librairie.data.dao;

import fr.afpa.librairie.data.bean.Langue;

public interface LangueDAO extends DAOInterface<Langue> {
    
    Langue findByLibelle(String libelle);
    Langue findByCode(String code);
}
