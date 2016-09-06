package fr.afpa.librairie.data.dao.support.xml;

import fr.afpa.librairie.data.AbstractDAOFactory;
import fr.afpa.librairie.data.bean.Role;
import fr.afpa.librairie.data.dao.RoleDAO;
import fr.afpa.librairie.data.exception.DAOException;
import java.util.List;

public class RoleXmlDAO extends AbstractXmlDAO<Role> implements RoleDAO {

    public RoleXmlDAO(AbstractDAOFactory factory) {
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

    @Override
    public List<Role> findAll() throws DAOException {
        return super.findAll(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Role findByCode(String code) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Role> findByUtilisateur(Long idUtilisateur) throws DAOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
