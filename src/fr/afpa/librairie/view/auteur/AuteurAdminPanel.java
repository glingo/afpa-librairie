package fr.afpa.librairie.view.auteur;

import fr.afpa.librairie.data.bean.Auteur;
import fr.afpa.librairie.model.table.AuteurTableModel;
import fr.afpa.librairie.view.panel.AdminPanel;
import fr.afpa.librairie.view.panel.ListPanel;
import fr.afpa.librairie.view.panel.TitlePanel;
import fr.afpa.librairie.view.panel.footer.FooterAdminPanel;
import java.awt.Component;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;

public class AuteurAdminPanel extends AdminPanel<Auteur> {
    
    private static final String TITLE = "Administration des auteurs.";

    public AuteurAdminPanel(ActionListener controller) {
        super(new TitlePanel(TITLE), 
            new ListPanel<>(new AuteurTableModel()), 
            new FooterAdminPanel(controller));
    }
   
    private Component getFooter() {
        JPanel footer = new JPanel();
        
        JButton createButton = new JButton("Creer");
        JButton deleteButton = new JButton("Supprimer");
        JButton viewButton = new JButton("Voir");
        JButton updateButton = new JButton("Mettre à jour");
        
        createButton.setActionCommand("create");
//        createButton.addActionListener(controller);
        
        deleteButton.setActionCommand("delete");
//        deleteButton.addActionListener(controller);
        
        footer.add(createButton);
        footer.add(deleteButton);
        footer.add(viewButton);
        footer.add(updateButton);
        footer.repaint();
        return footer;
    }
}
