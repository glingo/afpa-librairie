
package fr.afpa.librairie.data;

import fr.afpa.librairie.data.dao.DAOInterface;

public interface DAOFactoryInterface {
    
    public <T extends DAOInterface> T getUtilisateurDAO();
    public <T extends DAOInterface> T getRoleDAO();
    public <T extends DAOInterface> T getStatutUtilisateurDAO();
    
}
