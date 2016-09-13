
package fr.afpa.librairie.data.dao;

import fr.afpa.librairie.data.bean.StatutCommande;
import fr.afpa.librairie.data.exception.DAOException;
import java.util.List;

public interface StatutCommandeDAO extends DAOInterface<StatutCommande> {
    
    static final String CODE_PAIEMENT_ACCEPTE = "ac1";
    static final String CODE_COMMANDE_EN_PREPARATION = "cp1";
    static final String CODE_REMIS_A_LA_POSTE = "rp1";
    static final String CODE_EN_COURS_DE_LIVRAISON = "cl1";
    static final String CODE_LIVREE = "lv1";
    static final String CODE_PAIEMENT_REFUSE = "pa1";
    
    
    
    StatutCommande findByLibelle(String libelle);
    StatutCommande findByCode(String code);
    
    List<StatutCommande> findByCommande(Long idCommande) throws DAOException;
}
