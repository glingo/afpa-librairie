
package fr.afpa.librairie.data.dao;

import fr.afpa.librairie.data.bean.Auteur;
import fr.afpa.librairie.data.exception.DAOException;
import java.sql.Date;
import java.util.List;

public interface AuteurDAO extends DAOInterface<Auteur> {
    
    Auteur findByName (String nom);
    Auteur findByDateNaissance (Date dateNaissance);
    Auteur findByDateDeces (Date dateDeces);
    
//    List<Auteur> findByOuvrage(Long idOuvrage) throws DAOException;
    
    List<Auteur> findCoAuteursByOuvrage(Long idOuvrage) throws DAOException;
}
