package fr.afpa.librairie.view.panel.footer;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.AbstractButton;
import javax.swing.JButton;

public class ActivableFooterAdminPanel extends FooterAdminPanel {
    
    private JButton desactivate;
    private JButton activate;

    public ActivableFooterAdminPanel(ActionListener controller) {
        super(controller);
    }
    
    @Override
    protected List<AbstractButton> getButtons() {
        List<AbstractButton> buttons = super.getButtons();
        
        buttons.add(desactivate);
        buttons.add(activate);
       
        return buttons;
    }
    
    @Override
    protected void initButtons() {
        super.initButtons();
        
        desactivate = new JButton("Désactiver");
        activate = new JButton("Activer");
        
        desactivate.setActionCommand("desactivate");
        activate.setActionCommand("activate");
    }

}
