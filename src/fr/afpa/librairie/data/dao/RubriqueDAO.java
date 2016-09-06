
package fr.afpa.librairie.data.dao;

import fr.afpa.librairie.data.bean.Rubrique;

public interface RubriqueDAO extends DAOInterface<Rubrique> {
    Rubrique findByLibelle(String libelle);
}

