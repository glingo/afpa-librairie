package fr.afpa.librairie.data.dao.support.xml;

import fr.afpa.librairie.data.AbstractDAOFactory;
import fr.afpa.librairie.data.bean.StatutUtilisateur;
import fr.afpa.librairie.data.dao.StatutUtilisateurDAO;
import fr.afpa.librairie.data.exception.DAOException;
import java.util.List;

public class StatutUtilisateurXmlDAO extends AbstractXmlDAO<StatutUtilisateur> implements StatutUtilisateurDAO {

    public StatutUtilisateurXmlDAO(AbstractDAOFactory factory) {
        super(factory);
    }

    @Override
    public StatutUtilisateur findByCode(String code) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<StatutUtilisateur> findByUtilisateur(Long idUtilisateur) throws DAOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
