
package fr.afpa.librairie.view.admin;

import fr.afpa.librairie.controller.OuvrageController;
import fr.afpa.librairie.model.verifier.StrictInputVerifier;
import fr.afpa.librairie.view.form.FormPanel;
import java.awt.BorderLayout;
import java.awt.Component;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class CreateOuvragePanel extends JPanel{
    
    private final OuvrageController controller;
    
    private FormPanel form;
    private JPanel footer;

    public CreateOuvragePanel(OuvrageController controller) {
        this.controller = controller;
        init();
    }

    private void init() {
        setLayout(new BorderLayout());
        
        
        add(getForm(), BorderLayout.CENTER);
        add(getFooter(), BorderLayout.SOUTH);

        repaint();
        setVisible(true);
    }
    
    public FormPanel getForm(){
        
        if(this.form == null) {
            
            this.form = new FormPanel();
            
            JTextField titreField = new JTextField(15);
            titreField.setInputVerifier(new StrictInputVerifier());
            this.form.addField("Titre", titreField);
            
            JTextField sousTitreField = new JTextField(15);
            sousTitreField.setInputVerifier(new StrictInputVerifier());
            this.form.addField("Sous-titre", sousTitreField);
            
            JTextField resumeField = new JTextField(15);
            resumeField.setInputVerifier(new StrictInputVerifier());
            this.form.addField("Resume", resumeField);
            
            
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
