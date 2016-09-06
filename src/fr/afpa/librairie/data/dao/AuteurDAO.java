
package fr.afpa.librairie.data.dao;

import fr.afpa.librairie.data.bean.Auteur;
import java.sql.Date;

public interface AuteurDAO extends DAOInterface<Auteur> {
    
    Auteur findByName (String nom);
    Auteur findByDateNaissance (Date dateNaissance);
    Auteur findByDateDeces (Date dateDeces);
}
