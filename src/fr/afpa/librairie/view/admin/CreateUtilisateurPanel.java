package fr.afpa.librairie.view.admin;

import fr.afpa.librairie.controller.UtilisateurController;
import fr.afpa.librairie.model.verifier.StrictInputVerifier;
import fr.afpa.librairie.view.form.FormPanel;
import java.awt.BorderLayout;
import java.awt.Component;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class CreateUtilisateurPanel extends JPanel {

    private final UtilisateurController controller;
    
    private FormPanel form;
    private JPanel footer;

    public CreateUtilisateurPanel(UtilisateurController controller) {
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
            
            JTextField nomField = new JTextField(15);
            nomField.setInputVerifier(new StrictInputVerifier());
            this.form.addField("Nom", nomField);
            
            JTextField prenomField = new JTextField(15);
            prenomField.setInputVerifier(new StrictInputVerifier());
            this.form.addField("Prenom", prenomField);
            
            this.form.addField("Mot de passe", new JPasswordField(15));
            
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
