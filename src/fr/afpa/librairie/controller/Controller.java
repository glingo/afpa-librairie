package fr.afpa.librairie.controller;

import fr.afpa.librairie.data.AbstractDAOFactory;
import fr.afpa.librairie.data.DAOFactoryInterface;
import fr.afpa.librairie.data.FactoryType;
import fr.afpa.librairie.view.MainFrame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controller implements ActionListener {
    
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

    @Override
    public void actionPerformed(ActionEvent e) {
        
        if(frame == null) {
            this.frame = new MainFrame();
            this.frame.setVisible(true);
        }
        
    }
    
//    protected void setContent(Component component) {
//        
//        if(this.frame == null) {
//            throw new RuntimeException("La frame est null, pensez a appeler le controller via actionPerformed !");
//        }
//        
//        Container contentPane = this.frame.getContentPane();
//        
//        if(contentPane.contains(component)) {
//            
//        }
//        
//        if (currentContent != null) {
//            contentPane.remove(currentContent);
//        }
//        
////        contentPane.add(component);
//        contentPane.add(component, BorderLayout.CENTER);
//        currentContent = component;
////        contentPane.requestFocus();
////        contentPane.doLayout();
////        contentPane.repaint();
//        pack();
////        currentContent.doLayout();
////        currentContent.repaint();
////        pack();
//        repaint();
//    }

    public DAOFactoryInterface getDaoFactory() {
        return daoFactory;
    }
    
}
