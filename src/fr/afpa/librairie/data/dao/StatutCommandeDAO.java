
package fr.afpa.librairie.data.dao;

import fr.afpa.librairie.data.bean.StatutCommande;

public interface StatutCommandeDAO extends DAOInterface<StatutCommande> {
    StatutCommande findByLibelle(String libelle);
    StatutCommande findByCode(String code);
}
