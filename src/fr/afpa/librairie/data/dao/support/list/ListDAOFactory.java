package fr.afpa.librairie.data.dao.support.list;

import fr.afpa.librairie.data.AbstractDAOFactory;
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
    
}
