
package fr.afpa.librairie.data.dao;

import fr.afpa.librairie.data.bean.Rubrique;
import java.sql.Date;

public interface RubriqueDAO extends DAOInterface<Rubrique> {
    
    Rubrique findByLibelle(String libelle);
    Rubrique findByDateDebut(Date dateDebut);
}

