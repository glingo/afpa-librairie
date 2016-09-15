
package fr.afpa.librairie.data.dao;

import fr.afpa.librairie.data.bean.StatutAdresse;
import fr.afpa.librairie.data.exception.DAOException;
import java.util.List;

public interface StatutAdresseDAO extends DAOInterface<StatutAdresse> {
    
    static final String CODE_ACTIVE = "1";
    static final String CODE_DESACTIVE = "2";


    StatutAdresse findByCode(String code) throws DAOException;
    
    List<StatutAdresse> findByAdresse(Long idAdresse) throws DAOException;
}