package fr.afpa.librairie.data.dao;

import fr.afpa.librairie.data.exception.DAOException;
import java.util.List;

public interface DAOInterface<T> {
    
    void save(T instance) throws DAOException;
    
    void delete(T instance) throws DAOException;
    
    List<T> findAll() throws DAOException;
    
    T findById(Long id) throws DAOException;
    
    void create(T instance) throws DAOException;
   
    void update(T instance) throws DAOException;
    

}
