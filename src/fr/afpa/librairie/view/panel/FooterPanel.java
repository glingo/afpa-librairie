package fr.afpa.librairie.view.panel;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.AbstractButton;
import javax.swing.BorderFactory;
import javax.swing.JPanel;

public abstract class FooterPanel extends JPanel {
    
    private final ActionListener controller;
    
    public FooterPanel(ActionListener controller) {
        this.controller = controller;
        initComponents();
    }
    
    private void initComponents() {
        initButtons();
        setBorder(BorderFactory.createLineBorder(Color.lightGray));
        
        List<AbstractButton> buttons = getButtons();
        
        buttons.stream().forEach((button) -> {
            button.addActionListener(controller);
            add(button);
        });
    }
    
    protected abstract void initButtons();
    
    protected abstract List<AbstractButton> getButtons();

    public ActionListener getController() {
        return controller;
    }
    
}
