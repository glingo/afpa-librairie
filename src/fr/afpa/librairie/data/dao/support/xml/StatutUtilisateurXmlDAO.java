package fr.afpa.librairie.data.dao.support.xml;

import fr.afpa.librairie.data.AbstractDAOFactory;
import fr.afpa.librairie.data.bean.Role;
import fr.afpa.librairie.data.dao.AbstractDAO;
import fr.afpa.librairie.data.exception.DAOException;

public class StatutUtilisateurXmlDAO extends AbstractXmlDAO<Role> {

    public StatutUtilisateurXmlDAO(AbstractDAOFactory factory) {
        super(factory);
    }

    @Override
    public void save(Role instance) throws DAOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(Role instance) throws DAOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Role findByExemple(Role instance) throws DAOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Role findById(Long id) throws DAOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
