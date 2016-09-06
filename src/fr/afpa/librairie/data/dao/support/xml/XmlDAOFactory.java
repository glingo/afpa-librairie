package fr.afpa.librairie.data.dao.support.xml;

import fr.afpa.librairie.data.dao.support.xml.RoleXmlDAO;
import fr.afpa.librairie.data.dao.support.xml.UtilisateurXmlDAO;
import fr.afpa.librairie.data.dao.support.xml.StatutUtilisateurXmlDAO;
import fr.afpa.librairie.data.AbstractDAOFactory;
import fr.afpa.librairie.data.dao.AuteurDAO;

public class XmlDAOFactory extends AbstractDAOFactory {
    
    public XmlDAOFactory() {
        super();
    }
    
    @Override
    public UtilisateurXmlDAO getUtilisateurDAO(){
        return new UtilisateurXmlDAO(this);
    }
    
    @Override
    public StatutUtilisateurXmlDAO getStatutUtilisateurDAO(){
        return new StatutUtilisateurXmlDAO(this);
    }
    
    @Override
    public RoleXmlDAO getRoleDAO(){
        return new RoleXmlDAO(this);
    }

    @Override
    public AuteurDAO getAuteurDAO() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
