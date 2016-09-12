//création du code generé par l'utilisation du bouton "Supprimer" par l'utilisateur. 
package fr.afpa.librairie.view.admin;

import fr.afpa.librairie.controller.UtilisateurController;
import fr.afpa.librairie.model.verifier.StrictInputVerifier;
import fr.afpa.librairie.view.form.FormPanel;
import java.awt.BorderLayout;
import java.text.SimpleDateFormat;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class DeleteUtilisateurPanel extends JPanel {

    private final UtilisateurController controller;

    private FormPanel form;
    private JPanel footer;

    public DeleteUtilisateurPanel(UtilisateurController controller) {
        this.controller = controller;
        init();
    }

    private void init() {
        setLayout((new BorderLayout()));

        add(getForm(), BorderLayout.CENTER);
        add(getFooter(), BorderLayout.NORTH);

        repaint();
        setVisible(true);
    }

    public FormPanel getForm() {
        if (this.form == null) {
            this.form = new FormPanel();

            JTextField nomField = new JTextField(15);
            nomField.setInputVerifier(new StrictInputVerifier());
            this.form.addField("Nom", nomField);

            JTextField prenomField = new JTextField(15);
            prenomField.setInputVerifier(new StrictInputVerifier());
            this.form.addField("Prenom", prenomField);

            JTextField mailField = new JTextField(15);
            mailField.setInputVerifier(new StrictInputVerifier());
            this.form.addField("mail", mailField);

            SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
            JFormattedTextField formatText = new JFormattedTextField(formatter);
            formatText.setColumns(20);
            this.form.addField("Date de naissance", formatText);

            JPasswordField passwordField = new JPasswordField(15);
            passwordField.setInputVerifier(new StrictInputVerifier());
            this.form.addField("Mot de passe", passwordField);

            this.form.createForm();
        }

        return this.form;
    }
    

    public JPanel getFooter() {
        if(this.footer == null){
            this.footer = new JPanel();
            
            JButton deleteButton = new JButton("Supprimer");
            JButton annulerButton = new JButton("Annuler");
            
            deleteButton.setActionCommand("delete");
            deleteButton.addActionListener(this.controller);
            
            this.footer.add(deleteButton);
            this.footer.add(annulerButton);
            this.footer.repaint();
        }
        
        return this.footer;
    }
    

}
