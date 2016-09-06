package fr.afpa.librairie.data;

import fr.afpa.librairie.data.dao.AuteurDAO;
import fr.afpa.librairie.data.dao.RoleDAO;
import fr.afpa.librairie.data.dao.StatutUtilisateurDAO;
import fr.afpa.librairie.data.dao.UtilisateurDAO;

public interface DAOFactoryInterface {
    
    public UtilisateurDAO getUtilisateurDAO();
    public RoleDAO getRoleDAO();
    public StatutUtilisateurDAO getStatutUtilisateurDAO();
    public AuteurDAO getAuteurDAO();
}
