package fr.afpa.librairie.data.dao.support.list;

import fr.afpa.librairie.data.AbstractDAOFactory;
import fr.afpa.librairie.data.bean.Utilisateur;
import fr.afpa.librairie.data.dao.UtilisateurDAO;
import fr.afpa.librairie.data.exception.DAOException;

public class UtilisateurListDAO extends AbstractListDAO<Utilisateur> implements UtilisateurDAO {

    public UtilisateurListDAO(AbstractDAOFactory factory) {
        super(factory);
    }

    @Override
    public Utilisateur findByExemple(Utilisateur instance) throws DAOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
}
