
package fr.afpa.librairie.view.admin;

import fr.afpa.librairie.controller.EditionController;
import fr.afpa.librairie.model.verifier.StrictInputVerifier;
import fr.afpa.librairie.view.form.FormPanel;
import java.awt.BorderLayout;
import java.awt.Component;
import java.text.SimpleDateFormat;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class CreateEditionPanel extends JPanel {
    //correspon au bouton "create" du panel EditionAdminPanel
    
    //appel du contructeur ( = ecoute)
    private final EditionController controller;
    
    private FormPanel form;
    private JPanel footer;
    //element de la page form( = corps), footer (= bas de page)
    
    public CreateEditionPanel(EditionController controller) {
        this.controller = controller;
        init();
    }
    
    private void init() {
        setLayout(new BorderLayout());
        
        
        add(getForm(), BorderLayout.CENTER);
        //le getter correspondant à la Form arrive juste apres.
        add(getFooter(), BorderLayout.SOUTH);
        //idem que pour form

        repaint();
        setVisible(true);
    }
    
    public FormPanel getForm(){
        //etabli les différents elements presents dans le corps du panel. Elements = correspondent à la création d'une edition
        //controle que tous les elements necessaires à la création d'une edition sont bien presents/ 
        if(this.form == null) {
            
            this.form = new FormPanel();
            
            //1 element : isbn
            JTextField isbnField = new JTextField(15);
            isbnField.setInputVerifier(new StrictInputVerifier());
            this.form.addField("Isbn", isbnField);
            
            // 2 = date de publication ( date donc besoin de formatter, champs particulier)
            SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
            JFormattedTextField formatText = new JFormattedTextField(formatter);
            formatText.setColumns(20);
            this.form.addField("Date de publication", formatText);
            
            //3 = prixHT
            JTextField prixHTField = new JTextField(15);
            prixHTField.setInputVerifier(new StrictInputVerifier());
            this.form.addField("PrixHT", prixHTField);
            
            
            //4 = image de couverture
            JTextField couvertureField = new JTextField(15);
            couvertureField.setInputVerifier(new StrictInputVerifier());
            this.form.addField("Image de couverture", couvertureField);
            
            
            //5 = titre
            JTextField titreField = new JTextField(15);
            titreField.setInputVerifier(new StrictInputVerifier());
            this.form.addField("Titre", titreField);
            
            //6 = stock
            JTextField stockField = new JTextField(15);
            stockField.setInputVerifier(new StrictInputVerifier());
            this.form.addField("Stock", stockField);

            
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
