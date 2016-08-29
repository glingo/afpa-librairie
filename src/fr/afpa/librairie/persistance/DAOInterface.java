package fr.afpa.librairie.persistance;

import fr.afpa.librairie.persistance.exception.DAOException;

public interface DAOInterface<T> {
    
    void creer(T instance) throws DAOException;
    
    void supprimer(T instance) throws DAOException;
    
    void trouver(T instance) throws DAOException;
    
}
