package fr.afpa.librairie.data.dao;

import fr.afpa.librairie.data.exception.DAOException;

public interface DAOInterface<T> {
    
    void save(T instance) throws DAOException;
    
    void delete(T instance) throws DAOException;
    
    T findByExemple(T instance) throws DAOException;
    
    T findById(Long id) throws DAOException;
    
}
