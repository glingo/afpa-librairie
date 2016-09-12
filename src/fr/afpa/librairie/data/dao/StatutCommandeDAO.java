
package fr.afpa.librairie.data.dao;

import fr.afpa.librairie.data.bean.StatutCommande;
import fr.afpa.librairie.data.exception.DAOException;
import java.util.List;

public interface StatutCommandeDAO extends DAOInterface<StatutCommande> {
    StatutCommande findByLibelle(String libelle);
    StatutCommande findByCode(String code);
    List<StatutCommande> findByCommande(String libelle) throws DAOException;
}
