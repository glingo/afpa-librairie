package fr.afpa.librairie.data.dao.support.list;

import fr.afpa.librairie.data.AbstractDAOFactory;
import fr.afpa.librairie.data.bean.Utilisateur;
import fr.afpa.librairie.data.dao.UtilisateurDAO;
import fr.afpa.librairie.data.exception.DAOException;
import java.util.List;

public class UtilisateurListDAO extends AbstractListDAO<Utilisateur> implements UtilisateurDAO {

    public UtilisateurListDAO(AbstractDAOFactory factory) {
        super(factory);
    }

    @Override
    public Utilisateur findById(Long id) throws DAOException {
        return getTable().stream().filter((Utilisateur utilisateur) -> {
            return utilisateur.getId().equals(id);
        }).findFirst().orElse(null);
    }

    @Override
    public Utilisateur findByMail(String mail) {
        return getTable().stream().filter((Utilisateur utilisateur) -> {
            return utilisateur.getEmail().equals(mail);
        }).findFirst().orElse(null);
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

    @Override
    public void create(Utilisateur instance) throws DAOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(Utilisateur instance) throws DAOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
