package fr.afpa.librairie.data.dao.support.xml;

import fr.afpa.librairie.data.dao.support.xml.RoleXmlDAO;
import fr.afpa.librairie.data.dao.support.xml.UtilisateurXmlDAO;
import fr.afpa.librairie.data.dao.support.xml.StatutUtilisateurXmlDAO;
import fr.afpa.librairie.data.AbstractDAOFactory;
import fr.afpa.librairie.data.dao.AuteurDAO;
import fr.afpa.librairie.data.dao.GenreDAO;
import fr.afpa.librairie.data.dao.RubriqueDAO;
import fr.afpa.librairie.data.dao.TagDAO;
import fr.afpa.librairie.data.dao.ThemeDAO;

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

    @Override
    public ThemeDAO getThemeDAO() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public RubriqueDAO getRubriqueDAO() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public TagDAO getTagDAO() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public GenreDAO getGenreDAO() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
