
package fr.afpa.librairie.data.dao;

import fr.afpa.librairie.data.bean.Commande;
import java.sql.Date;

public interface CommandeDAO extends DAOInterface<Commande> {
    
    Commande findByNumero(String numero);
    Commande findByDate(Date dateCommande);
}
