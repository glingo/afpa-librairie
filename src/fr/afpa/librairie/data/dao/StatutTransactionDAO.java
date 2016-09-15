
package fr.afpa.librairie.data.dao;

import fr.afpa.librairie.data.bean.StatutTransaction;
import fr.afpa.librairie.data.exception.DAOException;
import java.util.List;

public interface StatutTransactionDAO extends DAOInterface<StatutTransaction> {
    
    static final String CODE_ENCOURS = "ec1";
    static final String CODE_ACCEPTE = "acp";
    static final String CODE_REFUSE = "ref"; 
    
    StatutTransaction findByCode(String code);
    
    List<StatutTransaction> findByTransaction(Long idTransaction) throws DAOException;
    
    
}
