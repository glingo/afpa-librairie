package fr.afpa.librairie.persistance;

public abstract class AbstractDAO<T> implements DAOInterface<T>{
    
    private final DAOFactory factory;

    public AbstractDAO(DAOFactory factory) {
        this.factory = factory;
    }
    
}
