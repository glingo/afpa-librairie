package fr.afpa.librairie;

import fr.afpa.librairie.controller.HomeController;
import fr.afpa.librairie.data.AbstractDAOFactory;
import fr.afpa.librairie.data.DAOFactoryInterface;
import fr.afpa.librairie.data.FactoryType;
import fr.afpa.librairie.view.MainFrame;

public class Launcher {
    
    public static void main(String[] args) {
        
        MainFrame frame = new MainFrame();
        DAOFactoryInterface factory = AbstractDAOFactory.getFactory(FactoryType.DAO_FACTORY);
        HomeController controller = new HomeController(frame, factory);
        
        javax.swing.SwingUtilities.invokeLater(() -> {
            controller.load();
        });
        
    }
}
