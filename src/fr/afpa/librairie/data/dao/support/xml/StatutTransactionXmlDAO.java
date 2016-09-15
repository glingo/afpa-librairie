package fr.afpa.librairie.data.dao.support.xml;

import fr.afpa.librairie.data.AbstractDAOFactory;
import fr.afpa.librairie.data.bean.StatutTransaction;
import fr.afpa.librairie.data.dao.StatutTransactionDAO;
import fr.afpa.librairie.data.exception.DAOException;
import java.util.List;

public class StatutTransactionXmlDAO extends AbstractXmlDAO<StatutTransaction> implements StatutTransactionDAO {

    public StatutTransactionXmlDAO(AbstractDAOFactory factory) {
        super(factory);
    }

    @Override
    public StatutTransaction findByCode(String code) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<StatutTransaction> findByTransaction(Long idTransaction) throws DAOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
