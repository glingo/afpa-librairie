package fr.afpa.librairie.view.commande;

import fr.afpa.librairie.data.bean.Commande;
import fr.afpa.librairie.model.table.CommandeTableModel;
import fr.afpa.librairie.view.panel.AdminPanel;
import fr.afpa.librairie.view.panel.ListPanel;
import fr.afpa.librairie.view.panel.TitlePanel;
import fr.afpa.librairie.view.panel.footer.FooterAdminPanel;
import java.awt.Component;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;

public class CommandeAdminPanel extends AdminPanel<Commande>{
    
    private final static String TITLE = "Administration des commandes.";

    public CommandeAdminPanel(ActionListener controller) {
        super(new TitlePanel(TITLE), 
            new ListPanel<>(new CommandeTableModel()), 
            new FooterAdminPanel(controller));
    }
    
    private Component getFooter() {
        JPanel footer = new JPanel();
        
        JButton createButton = new JButton("Creer");
        JButton deactivateButton = new JButton("Désactiver");
        JButton viewButton = new JButton("Voir");
        JButton updateButton = new JButton("Mettre à jour");
        
        createButton.setActionCommand("create");
//        createButton.addActionListener(controller);
        
        deactivateButton.setActionCommand("deactivate");
//        deactivateButton.addActionListener(controller);
       
        
        footer.add(createButton);
        footer.add(deactivateButton);
        footer.add(viewButton);
        footer.add(updateButton);
        footer.repaint();
        return footer;
    }
}
