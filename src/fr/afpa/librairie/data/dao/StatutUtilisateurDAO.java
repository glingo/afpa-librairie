package fr.afpa.librairie.data.dao;

import fr.afpa.librairie.data.bean.StatutUtilisateur;
import fr.afpa.librairie.data.exception.DAOException;
import java.util.List;

public interface StatutUtilisateurDAO extends DAOInterface<StatutUtilisateur> {

    StatutUtilisateur findByCode(String code);
    
    List<StatutUtilisateur> findByUtilisateur(Long idUtilisateur) throws DAOException;
}
