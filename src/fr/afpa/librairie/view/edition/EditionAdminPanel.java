package fr.afpa.librairie.view.edition;

import fr.afpa.librairie.data.bean.Edition;
import fr.afpa.librairie.model.table.EditionTableModel;
import fr.afpa.librairie.view.panel.AdminPanel;
import fr.afpa.librairie.view.panel.ListPanel;
import fr.afpa.librairie.view.panel.TitlePanel;
import fr.afpa.librairie.view.panel.footer.FooterAdminPanel;
import java.awt.Component;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JPanel;

public class EditionAdminPanel extends AdminPanel<Edition> {
    
    private final static String TITLE = "Administration des rubriques.";

    public EditionAdminPanel(ActionListener controller) {
        super(new TitlePanel(TITLE), 
            new ListPanel<>(new EditionTableModel()), 
            new FooterAdminPanel(controller));
    }
    
    //methode pour dire ce que va comporter le footer/ 
    private Component getFooter() {
        JPanel footer = new JPanel();
        
        JButton createButton = new JButton("Creer");
        JButton deactivateButton = new JButton("Désactiver");
        JButton activateButton = new JButton("Activer");
        JButton viewButton = new JButton("Voir");
        JButton updateButton = new JButton("Mettre à jour");
        
        createButton.setActionCommand("create");
//        createButton.addActionListener(controller);
        
        deactivateButton.setActionCommand("deactivate");
//        deactivateButton.addActionListener(controller);
        
        activateButton.setActionCommand("activate");
//        activateButton.addActionListener(controller);
        

        
        footer.add(createButton);
        footer.add(deactivateButton);
        footer.add(activateButton);
        footer.add(viewButton);
        footer.add(updateButton);
        footer.repaint();
        return footer;
    }
 
    
}
