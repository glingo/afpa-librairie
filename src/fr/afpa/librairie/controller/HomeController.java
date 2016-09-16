package fr.afpa.librairie.controller;

import fr.afpa.librairie.data.DAOFactoryInterface;
import fr.afpa.librairie.view.MainFrame;

public class HomeController{
    
    private final MainFrame frame;
    private final DAOFactoryInterface daoFactory;

    public HomeController(MainFrame frame, DAOFactoryInterface daoFactory) {
        this.frame = frame;
        this.daoFactory = daoFactory;
    }
    
    public void load(){
        
        this.frame.setVisible(true);
            
//        try {
//            List<Rubrique> rubriques = this.getDaoFactory().getRubriqueDAO().findAll();
//            this.frame.getLeftMenuPanel().setRubriqueList(rubriques);
//            this.frame.setVisible(true);
//        } catch(DAOException ex) {
//            this.frame.dispose();
//            JOptionPane.showMessageDialog(this.frame, "Impossible de joindre la base de données !");
//            System.exit(0);
//        }
    }

    public MainFrame getFrame() {
        return frame;
    }

    public DAOFactoryInterface getDaoFactory() {
        return daoFactory;
    }
    
}
