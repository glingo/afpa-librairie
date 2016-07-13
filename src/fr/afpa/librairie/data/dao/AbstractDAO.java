package fr.afpa.librairie.data.dao;

import fr.afpa.librairie.data.AbstractDAOFactory;
import fr.afpa.librairie.data.DAOFactoryInterface;
import fr.afpa.librairie.data.exception.DAOException;
import java.util.List;

public abstract class AbstractDAO<T> implements DAOInterface<T> {

    public final DAOFactoryInterface factory;

    public AbstractDAO(DAOFactoryInterface factory) {
        this.factory = factory;
    }

    public <F extends AbstractDAOFactory> F getFactory() {
        return (F) factory;
    }

    @Override
    public abstract List<T> findAll() throws DAOException;
    
}
