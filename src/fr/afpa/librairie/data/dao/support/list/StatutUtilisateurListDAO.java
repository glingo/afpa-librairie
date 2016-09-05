package fr.afpa.librairie.data.dao.support.list;

import fr.afpa.librairie.data.AbstractDAOFactory;
import fr.afpa.librairie.data.bean.StatutUtilisateur;
import fr.afpa.librairie.data.dao.StatutUtilisateurDAO;
import fr.afpa.librairie.data.exception.DAOException;

public class StatutUtilisateurListDAO extends AbstractListDAO<StatutUtilisateur> implements StatutUtilisateurDAO {

    public StatutUtilisateurListDAO(AbstractDAOFactory factory) {
        super(factory);
    }

    @Override
    public StatutUtilisateur findByExemple(StatutUtilisateur instance) throws DAOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public StatutUtilisateur findById(Long id) throws DAOException {
         return getTable().stream().filter((StatutUtilisateur statut) -> {
            return statut.getId().equals(id);
        }).findFirst().orElse(null);
    }

}
