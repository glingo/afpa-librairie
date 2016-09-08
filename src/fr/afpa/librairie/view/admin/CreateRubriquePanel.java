
package fr.afpa.librairie.view.admin;

import fr.afpa.librairie.controller.RubriqueController;
import fr.afpa.librairie.model.verifier.StrictInputVerifier;
import fr.afpa.librairie.view.form.FormPanel;
import java.awt.BorderLayout;
import java.awt.Component;
import java.text.SimpleDateFormat;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class CreateRubriquePanel extends JPanel {
    
    private final RubriqueController controller;
    
    private FormPanel form;
    private JPanel footer;

    public CreateRubriquePanel(RubriqueController controller) {
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
            
            JTextField libelleField = new JTextField(15);
            libelleField.setInputVerifier(new StrictInputVerifier());
            this.form.addField("Libelle", libelleField);

            
            SimpleDateFormat formatter01 = new SimpleDateFormat("dd-MM-yyyy");
            JFormattedTextField formatText01 = new JFormattedTextField(formatter01);
            formatText01.setColumns(20);
            this.form.addField("Date de début", formatText01);
            
            SimpleDateFormat formatter02 = new SimpleDateFormat("dd-MM-yyyy");
            JFormattedTextField formatText02 = new JFormattedTextField(formatter02);
            formatText02.setColumns(20);
            this.form.addField("Date de fin", formatText02);
            
 
            JTextField commentaireField = new JTextField(15);
            commentaireField.setInputVerifier(new StrictInputVerifier());
            this.form.addField("Commentaire", commentaireField);

            
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