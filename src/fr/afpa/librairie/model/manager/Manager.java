package fr.afpa.librairie.model.manager;

import fr.afpa.librairie.data.AbstractDAOFactory;
import fr.afpa.librairie.data.DAOFactoryInterface;
import fr.afpa.librairie.data.FactoryType;

public abstract class Manager<T> {
    
    private DAOFactoryInterface factory = AbstractDAOFactory.getFactory(FactoryType.LIST_DAO_FACTORY);
    
    public abstract T create();
    
}
