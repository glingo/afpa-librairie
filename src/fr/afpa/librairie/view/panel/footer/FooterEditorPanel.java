package fr.afpa.librairie.view.panel.footer;

import fr.afpa.librairie.view.panel.FooterPanel;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.AbstractButton;
import javax.swing.JButton;

public class FooterEditorPanel extends FooterPanel {
                    
    private JButton annulerBT;
    private JButton validerBT;
    
    public FooterEditorPanel(ActionListener controller) {
        super(controller);
    }                        

    @Override
    protected List<AbstractButton> getButtons() {
        List<AbstractButton> buttons = new ArrayList<>();
        
        buttons.add(validerBT);
        buttons.add(annulerBT);
       
        return buttons;
    }
    
    @Override
    protected void initButtons() {
        annulerBT = new JButton("Annuler");
        validerBT = new JButton("Valider");
        
        annulerBT.setActionCommand("annuler");
        validerBT.setActionCommand("save");
    }
}
