
package fr.afpa.librairie.view.admin;

import fr.afpa.librairie.controller.PromotionController;
import fr.afpa.librairie.model.verifier.StrictInputVerifier;
import fr.afpa.librairie.view.form.FormPanel;
import java.awt.BorderLayout;
import java.awt.Component;
import java.text.SimpleDateFormat;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class CreatePromotionPanel extends JPanel{
     private final PromotionController controller;
    
    private FormPanel form;
    private JPanel footer;

    public CreatePromotionPanel(PromotionController controller) {
        this.controller = controller;
        init();
    }
    
    private void init(){
        setLayout(new BorderLayout());
        
        
        add(getForm(), BorderLayout.CENTER);
        add(getFooter(), BorderLayout.SOUTH);

        repaint();
        setVisible(true);
    }
    
    public FormPanel getForm(){
        
        if(this.form == null) {
            
            this.form = new FormPanel();
            
            JTextField numeroField = new JTextField(15);
            numeroField.setInputVerifier(new StrictInputVerifier());
            this.form.addField("Numéro", numeroField);

            SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
            JFormattedTextField formatText = new JFormattedTextField(formatter);
            formatText.setColumns(20);
            this.form.addField("Date de commande", formatText);

            this.form.createForm();
        }

        return this.form;
    }
    
    public Component getFooter() {
        if(this.footer == null) {
            
            this.footer = new JPanel();

            JButton saveButton = new JButton("Sauvegarder");
            JButton abordButton = new JButton("Annuler");

            saveButton.setActionCommand("save");
            saveButton.addActionListener(this.controller);

            this.footer.add(saveButton);
            this.footer.add(abordButton);
            this.footer.repaint();
        }
        
        return this.footer;
    }
    
}
