package fr.afpa.librairie.view.utilisateur;

import fr.afpa.librairie.data.bean.Utilisateur;
import fr.afpa.librairie.model.verifier.StrictInputVerifier;
import fr.afpa.librairie.view.field.JDateField;
import fr.afpa.librairie.view.panel.EditorPanel;
import java.awt.event.ActionListener;
import javax.swing.GroupLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;

/**
 *
 * @author cdi305
 */
public class UtilisateurEditorPanel extends EditorPanel<Utilisateur> {
    
    private JLabel nomLabel;
    private JLabel prenomLabel;
    private JLabel mailLabel;
    private JLabel dateNaissanceLabel;
    private JLabel passwordLabel;
    
    private JTextField nom;
    private JTextField prenom;
    private JTextField mail;
    private JDateField dateNaissance;
    private JPasswordField password;

    public UtilisateurEditorPanel(ActionListener controller) {
        super(new Utilisateur(), controller);
    }
    
    public UtilisateurEditorPanel(Utilisateur bean, ActionListener controller) {
        super(bean, controller);
    }

    @Override
    protected void initBody(JPanel body) {
        nom = new JTextField(15);
        nom.setInputVerifier(new StrictInputVerifier());

        prenom = new JTextField(15);
        prenom.setInputVerifier(new StrictInputVerifier());

        mail = new JTextField(15);
        mail.setInputVerifier(new StrictInputVerifier());

        dateNaissance = new JDateField(true);

        password = new JPasswordField(15);

        nomLabel            = new JLabel("Nom :");
        prenomLabel         = new JLabel("Prenom :");
        mailLabel           = new JLabel("Mail :");
        dateNaissanceLabel  = new JLabel("Date de naissance :");
        passwordLabel       = new JLabel("Mot de passe :");

        nomLabel.setLabelFor(nom);
        prenomLabel.setLabelFor(prenom);
        mailLabel.setLabelFor(mail);
        dateNaissanceLabel.setLabelFor(dateNaissance);
        passwordLabel.setLabelFor(password);
        
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
                                    .addComponent(mailLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(dateNaissanceLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(passwordLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(13, 13, 13)
                                .addGroup(bodyPanelLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                    .addComponent(nom, GroupLayout.Alignment.LEADING)
                                    .addComponent(prenom, GroupLayout.Alignment.LEADING)
                                    .addComponent(mail, GroupLayout.Alignment.LEADING)
                                    .addComponent(dateNaissance, GroupLayout.Alignment.LEADING)
                                    .addComponent(password, GroupLayout.Alignment.LEADING))))
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
                    .addComponent(mail, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(mailLabel))
                .addGroup(bodyPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(dateNaissance, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(dateNaissanceLabel))
                .addGroup(bodyPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(password, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(passwordLabel))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED))
        );
    }

    @Override
    protected String getTitleText() {
        
        Utilisateur utilisateur = getBean();
        
        return utilisateur.getId() != null 
                ? "Utilisateur " + utilisateur.getNom()
                : "Nouvel Utilisateur";
    }

    @Override
    public void bindValues() {
        Utilisateur utilisateur = getBean();
        
        nom.setText(utilisateur.getNom());
        prenom.setText(utilisateur.getPrenom());
        mail.setText(utilisateur.getEmail());
        dateNaissance.setValue(utilisateur.getDateNaissance());
        password.setText(utilisateur.getMotDePasse());
        
    }

    @Override
    public Utilisateur constructBean() {
        Utilisateur utilisateur = getBean();
        
        utilisateur.setNom(nom.getText());
        utilisateur.setPrenom(prenom.getText());
        utilisateur.setEmail(mail.getText());
        // encode password !
        utilisateur.setMotDePasse(String.valueOf(password.getPassword()));
        
        if(dateNaissance.getValue() != null) {
            utilisateur.setDateNaissance(new java.sql.Date(dateNaissance.getValue().getTime()));
        }
        
        return utilisateur;
    }

    @Override
    public void reset() {
        nom.setText("");
        prenom.setText("");
        mail.setText("");
        dateNaissance.setValue(null);
        password.setText("");
    }
    
    
}
