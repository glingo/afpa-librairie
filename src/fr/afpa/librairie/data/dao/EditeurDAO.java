
package fr.afpa.librairie.data.dao;

import fr.afpa.librairie.data.bean.Editeur;

public interface EditeurDAO extends DAOInterface<Editeur>{
    
    Editeur findByLibelle(String libelle);
}
