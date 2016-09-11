package fr.afpa.librairie.data.dao.support.list;

import fr.afpa.librairie.data.AbstractDAOFactory;
import fr.afpa.librairie.data.dao.AdresseDAO;
import fr.afpa.librairie.data.dao.AuteurDAO;
import fr.afpa.librairie.data.dao.CommandeDAO;
import fr.afpa.librairie.data.dao.EditeurDAO;
import fr.afpa.librairie.data.dao.EditionDAO;
import fr.afpa.librairie.data.dao.GenreDAO;
import fr.afpa.librairie.data.dao.LangueDAO;
import fr.afpa.librairie.data.dao.OuvrageDAO;
import fr.afpa.librairie.data.dao.PromotionDAO;
import fr.afpa.librairie.data.dao.RubriqueDAO;
import fr.afpa.librairie.data.dao.StatutCommandeDAO;
import fr.afpa.librairie.data.dao.StatutEditionDAO;
import fr.afpa.librairie.data.dao.TagDAO;
import fr.afpa.librairie.data.dao.ThemeDAO;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ListDAOFactory extends AbstractDAOFactory {
    
    private HashMap<String, List> tables;
    
    public ListDAOFactory() {
        super();
    }
    
    protected List getTable(String name) {
        
        if(!getTables().containsKey(name)) {
            getTables().put(name, new ArrayList());
        }
        
        return getTables().get(name);
    };
     
    protected HashMap<String, List> getTables() {
        if(this.tables == null) {
            this.tables = new HashMap<>();
        }
        return this.tables;
    };

    @Override
    public UtilisateurListDAO getUtilisateurDAO() {
        return new UtilisateurListDAO(this);
    }

    @Override
    public RoleListDAO getRoleDAO() {
        return new RoleListDAO(this);
    }

    @Override
    public StatutUtilisateurListDAO getStatutUtilisateurDAO() {
        return new StatutUtilisateurListDAO(this);
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

    @Override
    public OuvrageDAO getOuvrageDAO() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public CommandeDAO getCommandeDAO() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public EditeurDAO getEditeurDAO() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public PromotionDAO getPromotionDAO() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public EditionDAO getEditionDAO() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public AdresseDAO getAdresseDAO() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public LangueDAO getLangueDAO() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public StatutCommandeDAO getStatutCommandeDAO() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public StatutEditionDAO getStatutEditionDAO() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
