
package fr.afpa.librairie.data.dao;

import fr.afpa.librairie.data.bean.StatutEntreprise;
import fr.afpa.librairie.data.exception.DAOException;
import java.util.List;

public interface StatutEntrepriseDAO extends DAOInterface<StatutEntreprise> {
    
    static final String CODE_ACTIVE = "1";
    static final String CODE_DISSOUTE = "2";


    StatutEntreprise findByCode(String code) throws DAOException;
    
    List<StatutEntreprise> findByEntreprise(Long idEntreprise) throws DAOException;
}