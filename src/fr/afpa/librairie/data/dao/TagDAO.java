
package fr.afpa.librairie.data.dao;

import fr.afpa.librairie.data.bean.Tag;

public interface TagDAO extends DAOInterface<Tag> {
    
    Tag findByLibelle(String libelle);
}
