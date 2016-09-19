
package fr.afpa.librairie.data.dao;

import fr.afpa.librairie.data.bean.Editeur;
import fr.afpa.librairie.data.exception.DAOException;
import java.util.List;

public interface EditeurDAO extends DAOInterface<Editeur>{
    
    Editeur findByLibelle(String libelle);
    
    List<Editeur> findByEdition(Long idEdition) throws DAOException;
}
