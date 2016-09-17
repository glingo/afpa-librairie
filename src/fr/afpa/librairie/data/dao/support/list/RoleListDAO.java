package fr.afpa.librairie.data.dao.support.list;

import fr.afpa.librairie.data.AbstractDAOFactory;
import fr.afpa.librairie.data.bean.Role;
import fr.afpa.librairie.data.dao.RoleDAO;
import fr.afpa.librairie.data.exception.DAOException;
import java.util.List;

public class RoleListDAO extends AbstractListDAO<Role> implements RoleDAO {

    public RoleListDAO(AbstractDAOFactory factory) {
        super(factory);
    }
    
    @Override
    public Role findById(Long id) throws DAOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Role findByCode(String code) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Role> findByUtilisateur(Long idUtilisateur) throws DAOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void create(Role instance) throws DAOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(Role instance) throws DAOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void view(Role instance) throws DAOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
