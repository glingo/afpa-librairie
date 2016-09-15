package fr.afpa.librairie.data.dao.support.xml;

import fr.afpa.librairie.data.AbstractDAOFactory;
import fr.afpa.librairie.data.bean.StatutAdresse;
import fr.afpa.librairie.data.dao.StatutAdresseDAO;
import fr.afpa.librairie.data.exception.DAOException;
import java.util.List;

public class StatutAdresseXmlDAO extends AbstractXmlDAO<StatutAdresse> implements StatutAdresseDAO {

    public StatutAdresseXmlDAO(AbstractDAOFactory factory) {
        super(factory);
    }

    @Override
    public StatutAdresse findByCode(String code) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<StatutAdresse> findByAdresse(Long idAdresse) throws DAOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
