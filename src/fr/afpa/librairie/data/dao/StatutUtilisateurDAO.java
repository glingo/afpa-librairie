package fr.afpa.librairie.data.dao;

import fr.afpa.librairie.data.bean.StatutUtilisateur;
import fr.afpa.librairie.data.exception.DAOException;
import java.util.List;

public interface StatutUtilisateurDAO extends DAOInterface<StatutUtilisateur> {
    
    static final String CODE_ACTIVE = "OK";
    static final String CODE_DESACTIVE = "NOK";


    StatutUtilisateur findByCode(String code) throws DAOException;
    
    List<StatutUtilisateur> findByUtilisateur(Long idUtilisateur) throws DAOException;
}
