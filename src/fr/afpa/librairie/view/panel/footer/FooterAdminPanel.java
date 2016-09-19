package fr.afpa.librairie.view.panel.footer;

import fr.afpa.librairie.controller.CRUDController;
import fr.afpa.librairie.view.panel.FooterPanel;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.AbstractButton;
import javax.swing.JButton;

public class FooterAdminPanel extends FooterPanel {

    private JButton createButton;
    private JButton deleteButton;
    private JButton viewButton;
    private JButton updateButton;

    public FooterAdminPanel(ActionListener controller) {
        super(controller);
    }
    
    @Override
    protected List<AbstractButton> getButtons() {
        List<AbstractButton> buttons = new ArrayList<>();
        
        buttons.add(createButton);
        buttons.add(deleteButton);
        buttons.add(viewButton);
        buttons.add(updateButton);
       
        return buttons;
    }
    
    @Override
    protected void initButtons() {
        createButton = new JButton("Creer");
        deleteButton = new JButton("Supprimer");
        viewButton   = new JButton("Voir");
        updateButton = new JButton("Mettre à jour");
        
        createButton.setActionCommand(CRUDController.CREATE_ACTION);
        deleteButton.setActionCommand(CRUDController.DELETE_ACTION);
        viewButton.setActionCommand(CRUDController.VIEW_ACTION);
        updateButton.setActionCommand(CRUDController.EDIT_ACTION);
    }

}
