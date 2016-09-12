package fr.afpa.librairie;

import fr.afpa.librairie.controller.Controller;
import fr.afpa.librairie.controller.HomeController;

public class Launcher {
    
    public static void main(String[] args) {
        
        Controller controller = new HomeController();
        
        javax.swing.SwingUtilities.invokeLater(() -> {
            controller.actionPerformed(null);
        });
        
    }
}
