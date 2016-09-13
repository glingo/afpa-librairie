package fr.afpa.librairie.controller;

import fr.afpa.librairie.data.AbstractDAOFactory;
import fr.afpa.librairie.data.DAOFactoryInterface;
import fr.afpa.librairie.data.FactoryType;
import fr.afpa.librairie.view.MainFrame;
import java.awt.event.ActionListener;

public abstract class Controller implements ActionListener {
    
    // Utilisaer les dao dans le controller n'est pas tres recommandé, 
    // mais en attendant les managers on fera avec.
    protected DAOFactoryInterface daoFactory;
    
    // Le controller connait la frame pour pouvoir influer sur elle.
    protected MainFrame frame;
    
    public Controller() {
//        this.daoFactory = AbstractDAOFactory.getFactory(FactoryType.LIST_DAO_FACTORY);
        this.daoFactory = AbstractDAOFactory.getFactory(FactoryType.DAO_FACTORY);
    }

    public Controller(MainFrame frame) {
        this();
        this.frame = frame;
    }

    public DAOFactoryInterface getDaoFactory() {
        return daoFactory;
    }
    
}
