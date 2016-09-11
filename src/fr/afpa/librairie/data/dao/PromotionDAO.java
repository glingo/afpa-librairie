
package fr.afpa.librairie.data.dao;

import fr.afpa.librairie.data.bean.Edition;
import fr.afpa.librairie.data.bean.Promotion;
import java.sql.Date;
import java.util.List;

public interface PromotionDAO extends DAOInterface<Promotion> {
    
    Promotion findByDateDebut(Date dateDebut);
    Promotion findById(Long idPromo);
    Promotion findByReduction (Float reduction);

}
