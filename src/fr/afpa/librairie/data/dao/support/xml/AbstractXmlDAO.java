package fr.afpa.librairie.data.dao.support.xml;

import fr.afpa.librairie.data.DAOFactoryInterface;
import fr.afpa.librairie.data.dao.AbstractDAO;
import fr.afpa.librairie.data.exception.DAOException;
import java.util.List;

public class AbstractXmlDAO<T> extends AbstractDAO<T> {

    public AbstractXmlDAO(DAOFactoryInterface factory) {
        super(factory);
    }

    @Override
    public void save(T instance) throws DAOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(T instance) throws DAOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public T findByExemple(T instance) throws DAOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public T findById(Long id) throws DAOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<T> findAll() throws DAOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
