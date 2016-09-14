package fr.afpa.librairie.view.panel.footer;

import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;

public class FooterAdminPanel extends JPanel {

    private final ActionListener controller;
    
    private JButton createButton;
    private JButton deleteButton;
    private JButton viewButton;
    private JButton updateButton;

    public FooterAdminPanel(ActionListener controller) {
        this.controller = controller;
        initComponents();
    }
    
    private void initComponents(){
        createButton = new JButton("Creer");
        deleteButton = new JButton("Supprimer");
        viewButton = new JButton("Voir");
        updateButton = new JButton("Mettre à jour");
        
        createButton.setActionCommand("create");
        createButton.addActionListener(controller);
        
        deleteButton.setActionCommand("delete");
        deleteButton.addActionListener(controller);
        
        viewButton.setActionCommand("view");
        viewButton.addActionListener(controller);
        
        updateButton.setActionCommand("edit");
        updateButton.addActionListener(controller);
        
        add(createButton);
        add(deleteButton);
        add(viewButton);
        add(updateButton);
    }

}
