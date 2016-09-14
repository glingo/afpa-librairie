package fr.afpa.librairie.view.auteur;

import fr.afpa.librairie.data.bean.Auteur;
import fr.afpa.librairie.model.verifier.StrictInputVerifier;
import fr.afpa.librairie.view.field.JDateField;
import fr.afpa.librairie.view.panel.EditorPanel;
import java.awt.event.ActionListener;
import javax.swing.GroupLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;

/**
 *
 * @author cdi305
 */
public class AuteurEditorPanel extends EditorPanel<Auteur> {
    
    private JLabel nomLabel;
    private JLabel prenomLabel;
    private JLabel dateDecesLabel;
    private JLabel dateNaissLabel;
    
    private JTextField nom;
    private JTextField prenom;
    private JDateField dateNaiss;
    private JDateField dateDeces;
    
    public AuteurEditorPanel(ActionListener controller) {
        super(new Auteur(), controller);
    }
    
    public AuteurEditorPanel(Auteur bean, ActionListener controller) {
        super(bean, controller);
    }

    @Override
    protected void initBody(JPanel body) {
        
        nom = new JTextField();
        prenom = new JTextField();
        dateNaiss = new JDateField(false);
        dateDeces = new JDateField(false);
        
        nomLabel = new JLabel("Nom :");
        prenomLabel = new JLabel("Prenom :");
        dateNaissLabel = new JLabel("Date de naissance :");
        dateDecesLabel = new JLabel("Date de décès :");
        
        nom.setInputVerifier(new StrictInputVerifier());
        
        GroupLayout bodyPanelLayout = new GroupLayout(body);
        body.setLayout(bodyPanelLayout);

        bodyPanelLayout.setHorizontalGroup(
            bodyPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(bodyPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(bodyPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(GroupLayout.Alignment.TRAILING, bodyPanelLayout.createSequentialGroup()
                        .addGroup(bodyPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addGroup(bodyPanelLayout.createSequentialGroup()
                                .addGroup(bodyPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                    .addComponent(nomLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(prenomLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(dateNaissLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(dateDecesLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(13, 13, 13)
                                .addGroup(bodyPanelLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                    .addComponent(nom, GroupLayout.Alignment.LEADING)
                                    .addComponent(prenom, GroupLayout.Alignment.LEADING)
                                    .addComponent(dateNaiss, GroupLayout.Alignment.LEADING)
                                    .addComponent(dateDeces, GroupLayout.Alignment.LEADING))))
                        .addGap(6, 6, 6))))
        );

        bodyPanelLayout.setVerticalGroup(
            bodyPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(bodyPanelLayout.createSequentialGroup()
                .addGroup(bodyPanelLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                    .addComponent(nomLabel)
                    .addComponent(nom, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(bodyPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(prenom, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(prenomLabel))
                .addGroup(bodyPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(dateNaiss, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(dateNaissLabel))
                .addGroup(bodyPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(dateDeces, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(dateDecesLabel))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED))
        );
    }

    @Override
    protected String getTitleText() {
        
        Auteur auteur = getBean();
        
        return auteur.getId() != null 
                ? "Auteur " + auteur.getNom()
                : "Nouvel Auteur";
    }

    @Override
    public void bindValues() {
        Auteur auteur = getBean();
        
        nom.setText(auteur.getNom());
        prenom.setText(auteur.getPrenom());
        dateNaiss.setValue(auteur.getDateNaissance());
        dateDeces.setValue(auteur.getDateDeces());
        
    }

    @Override
    public Auteur constructBean() {
        Auteur auteur = getBean();
        
        auteur.setNom(nom.getText());
        auteur.setPrenom(prenom.getText());
        
        if(dateNaiss.getValue() != null) {
            auteur.setDateNaissance(new java.sql.Date(dateNaiss.getValue().getTime()));
        }
        
        if(dateDeces.getValue() != null) {
            auteur.setDateDeces(new java.sql.Date(dateDeces.getValue().getTime()));
        }
        
        return auteur;
    }

    @Override
    public void reset() {
        nom.setText("");
        prenom.setText("");
        dateNaiss.setValue(null);
        dateDeces.setValue(null);
    }
    
    
}
