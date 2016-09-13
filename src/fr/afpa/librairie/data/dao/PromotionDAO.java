
package fr.afpa.librairie.data.dao;

import fr.afpa.librairie.data.bean.Promotion;
import java.sql.Date;

public interface PromotionDAO extends DAOInterface<Promotion> {
    
    Promotion findByDateDebut(Date dateDebut);
    Promotion findByReduction (Float reduction);

}
