package fr.afpa.librairie.persistance.dao;

import fr.afpa.librairie.model.Utilisateur;
import fr.afpa.librairie.persistance.AbstractDAO;
import fr.afpa.librairie.persistance.DAOFactory;
import fr.afpa.librairie.persistance.exception.DAOException;

public class UtilisateurDAO extends AbstractDAO<Utilisateur> {

    public UtilisateurDAO(DAOFactory factory) {
        super(factory);
    }

    @Override
    public void creer(Utilisateur instance) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void supprimer(Utilisateur instance) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void trouver(Utilisateur instance) throws DAOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
