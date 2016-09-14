package fr.afpa.librairie.data.dao.support.xml;

import fr.afpa.librairie.data.AbstractDAOFactory;
import fr.afpa.librairie.data.bean.StatutEntreprise;
import fr.afpa.librairie.data.dao.StatutEntrepriseDAO;
import fr.afpa.librairie.data.exception.DAOException;
import java.util.List;

public class StatutEntrepriseXmlDAO extends AbstractXmlDAO<StatutEntreprise> implements StatutEntrepriseDAO {

    public StatutEntrepriseXmlDAO(AbstractDAOFactory factory) {
        super(factory);
    }

    @Override
    public StatutEntreprise findByCode(String code) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<StatutEntreprise> findByEntreprise(Long idEntreprise) throws DAOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
