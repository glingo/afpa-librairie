package fr.afpa.librairie.data.dao.support.list;

import fr.afpa.librairie.data.AbstractDAOFactory;
import fr.afpa.librairie.data.bean.StatutTransaction;
import fr.afpa.librairie.data.dao.StatutTransactionDAO;
import fr.afpa.librairie.data.exception.DAOException;
import java.util.List;

public class StatutTransactionListDAO extends AbstractListDAO<StatutTransaction> implements StatutTransactionDAO {

    public StatutTransactionListDAO(AbstractDAOFactory factory) {
        super(factory);
    }

    @Override
    public StatutTransaction findById(Long id) throws DAOException {
        return getTable().stream().filter((StatutTransaction statut) -> {
            return statut.getId().equals(id);
        }).findFirst().orElse(null);
    }

    
    @Override
    public StatutTransaction findByCode(String code) {
        return getTable().stream().filter((StatutTransaction statut) -> {
            return statut.getCode().equals(code);
        }).findFirst().orElse(null);
    }

    @Override
    public List<StatutTransaction> findByTransaction(Long idTransaction) throws DAOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void create(StatutTransaction instance) throws DAOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(StatutTransaction instance) throws DAOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
