package fr.afpa.librairie.data.dao;

import fr.afpa.librairie.data.bean.Utilisateur;

public interface UtilisateurDAO extends DAOInterface<Utilisateur> {

    Utilisateur findByMail(String mail);
    
}
