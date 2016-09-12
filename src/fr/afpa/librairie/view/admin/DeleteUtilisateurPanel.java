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
        add(getFooter(), BorderLayout.SOUTH);

        repaint();
        setVisible(true);
    }

    public FormPanel getForm() {
        if (this.form == null) {
            this.form = new FormPanel();
            
            JTextField idUserField = new JTextField(15);
            idUserField.setInputVerifier(new StrictInputVerifier());
            this.form.addField("IdUtilisateur", idUserField);

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
            
            annulerButton.setActionCommand("annuler");
            annulerButton.addActionListener(this.controller);
            
            this.footer.add(deleteButton);
            this.footer.add(annulerButton);
            this.footer.repaint();
        }
        
        return this.footer;
    }
    

}
