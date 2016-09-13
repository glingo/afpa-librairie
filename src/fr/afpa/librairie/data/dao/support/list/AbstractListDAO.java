package fr.afpa.librairie.data.dao.support.list;

import fr.afpa.librairie.data.AbstractDAOFactory;
import fr.afpa.librairie.data.dao.AbstractDAO;
import fr.afpa.librairie.data.exception.DAOException;
import java.util.List;

public abstract class AbstractListDAO<T> extends AbstractDAO<T> {
    
//    private static final List<T> table = new ArrayList<>();

    public AbstractListDAO(AbstractDAOFactory factory) {
        super(factory);
    }
    
    protected final List<T> getTable(){
        ListDAOFactory factory = getFactory();
        return factory.getTable(this.getClass().getSimpleName());
    }
    
    @Override
    public List<T> findAll() throws DAOException {
        return getTable();
    }

    @Override
    public void save(T instance) throws DAOException {
        getTable().add(instance);
    }

    @Override
    public void delete(T instance) throws DAOException {
        getTable().remove(instance);
    }
    

    @Override
    public abstract T findByExemple(T instance) throws DAOException;

    @Override
    public abstract T findById(Long id) throws DAOException;
    
}
