
package fr.afpa.librairie.data.dao;

import fr.afpa.librairie.data.bean.Rubrique;
import fr.afpa.librairie.data.exception.DAOException;
import java.sql.Date;
import java.util.List;

public interface RubriqueDAO extends DAOInterface<Rubrique> {
    
    Rubrique findByLibelle(String libelle);
    Rubrique findByDateDebut(Date dateDebut);
    
    List<Rubrique> findByOuvrage(Long idOuvrage) throws DAOException;
}

