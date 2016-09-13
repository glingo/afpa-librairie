package fr.afpa.librairie.data.dao;

import fr.afpa.librairie.data.bean.Utilisateur;
import fr.afpa.librairie.data.exception.DAOException;
import java.util.List;

public interface UtilisateurDAO extends DAOInterface<Utilisateur> {

    Utilisateur findByMail(String mail) throws DAOException;
    
    Utilisateur findByCommande(Long idCommande) throws DAOException;
    
    List<Utilisateur> findByNom(String nom) throws DAOException;
    
    void activate(Utilisateur utilisateur) throws DAOException;
    
}
