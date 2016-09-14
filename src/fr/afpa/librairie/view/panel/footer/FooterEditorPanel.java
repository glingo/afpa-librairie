package fr.afpa.librairie.view.panel.footer;

import java.awt.Color;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JPanel;

public class FooterEditorPanel extends JPanel {
    
    private final ActionListener controller;                    
    private JButton annulerBT;
    private JButton validerBT;
    
    public FooterEditorPanel(ActionListener controller) {
        this.controller = controller;
        initComponents();
    }

    private void initComponents() {
        annulerBT = new JButton();
        validerBT = new JButton();
        
        annulerBT.setText("Annuler");
        annulerBT.setActionCommand("annuler");
        annulerBT.addActionListener(this.controller);

        validerBT.setText("Valider");
        validerBT.setActionCommand("save");
        validerBT.addActionListener(this.controller);
        
        ButtonGroup buttons = new ButtonGroup();
        
        buttons.add(validerBT);
        buttons.add(annulerBT);

        setBorder(BorderFactory.createLineBorder(Color.lightGray));

        add(validerBT);
        add(annulerBT);
    }                           
}
