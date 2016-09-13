package fr.afpa.librairie.controller;

import fr.afpa.librairie.data.AbstractDAOFactory;
import fr.afpa.librairie.data.DAOFactoryInterface;
import fr.afpa.librairie.data.FactoryType;
import fr.afpa.librairie.view.MainFrame;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

public abstract class Controller implements ActionListener {
    
    // Utiliser les dao dans le controller n'est pas tres recommandé, 
    // mais en attendant les managers on fera avec.
    protected DAOFactoryInterface daoFactory;
    
    // Le controller connait la frame pour pouvoir influer sur elle.
    protected MainFrame frame;
    
    public Controller() {
//        this.daoFactory = AbstractDAOFactory.getFactory(FactoryType.LIST_DAO_FACTORY);
//        this.daoFactory = AbstractDAOFactory.getFactory(FactoryType.XML_DAO_FACTORY);
        this.daoFactory = AbstractDAOFactory.getFactory(FactoryType.DAO_FACTORY);
    }

    public Controller(MainFrame frame) {
        this();
        this.frame = frame;
    }

    public DAOFactoryInterface getDaoFactory() {
        return daoFactory;
    }
    
    protected void alert(String title, String message){
        JOptionPane.showMessageDialog(frame, message, title, JOptionPane.INFORMATION_MESSAGE);
    }
    
    protected void danger(String title, String message){
        JOptionPane.showMessageDialog(frame, message, title, JOptionPane.ERROR_MESSAGE);
    }
}
