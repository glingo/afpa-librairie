package fr.afpa.librairie.data.dao.support.xml;

import fr.afpa.librairie.data.AbstractDAOFactory;
import fr.afpa.librairie.data.bean.Utilisateur;
import fr.afpa.librairie.data.dao.UtilisateurDAO;
import fr.afpa.librairie.data.exception.DAOException;
import java.util.List;

public class UtilisateurXmlDAO extends AbstractXmlDAO<Utilisateur> implements UtilisateurDAO {

    public UtilisateurXmlDAO(AbstractDAOFactory factory) {
        super(factory);
    }

    @Override
    public Utilisateur findByMail(String mail) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Utilisateur findByCommande(Long idCommande) throws DAOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Utilisateur> findByNom(String nom) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void activate(Utilisateur utilisateur) throws DAOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
