
package fr.afpa.librairie.data.dao;

import fr.afpa.librairie.data.bean.Ouvrage;
import fr.afpa.librairie.data.exception.DAOException;
import java.util.List;

public interface OuvrageDAO extends DAOInterface<Ouvrage> {
    
    Ouvrage findByTitre(String titre);
    Ouvrage findBySousTitre(String sousTitre);
    
   // List<Ouvrage> findByAuteur(String nom)throws DAOException;
    List<Ouvrage> findByEdition(String isbn) throws DAOException;

    List<Ouvrage> findByRubrique(Long id);
    
    void viewRubrique(Ouvrage instance) throws DAOException;
    
}
