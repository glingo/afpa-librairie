package fr.afpa.librairie;

import fr.afpa.librairie.controller.Controller;

public class Launcher {
    
    public static void main(String[] args) {
        
        Controller controller = new Controller();
        
        javax.swing.SwingUtilities.invokeLater(() -> {
            controller.actionPerformed(null);
        });
        
    }
}
