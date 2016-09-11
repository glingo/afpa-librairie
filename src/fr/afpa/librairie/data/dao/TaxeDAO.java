/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.afpa.librairie.data.dao;

import fr.afpa.librairie.data.bean.Taxe;
import fr.afpa.librairie.data.exception.DAOException;
import java.util.List;

/**
 *
 * @author Marÿn
 */
public interface TaxeDAO extends DAOInterface<Taxe> {
    Taxe findByLibelle (String libelle);
    Taxe findByValeur (Float valeur);
    
    List<Taxe> findByEdition(String isbn) throws DAOException;
    
}
