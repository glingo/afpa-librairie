package fr.afpa.librairie.view.ouvrage;

import fr.afpa.librairie.data.bean.Ouvrage;
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
public class OuvrageEditorPanel extends EditorPanel<Ouvrage> {
    
    // TODO
    
    public OuvrageEditorPanel(ActionListener controller) {
        super(new Ouvrage(), controller);
    }
    
    public OuvrageEditorPanel(Ouvrage bean, ActionListener controller) {
        super(bean, controller);
    }

    @Override
    protected void initBody(JPanel body) {
        // TODO
    }

    @Override
    protected String getTitleText() {
        
        Ouvrage ouvrage = getBean();
        
        return ouvrage.getId() != null 
                ? "Ouvrage " + ouvrage.getTitre()
                : "Nouvel Ouvrage";
    }

    @Override
    public void bindValues() {
        Ouvrage ouvrage = getBean();
        
        // TODO
        
//        nom.setText(utilisateur.getNom());
//        prenom.setText(utilisateur.getPrenom());
//        mail.setText(utilisateur.getEmail());
//        dateNaissance.setValue(utilisateur.getDateNaissance());
//        password.setText(utilisateur.getMotDePasse());
        
    }

    @Override
    public Ouvrage constructBean() {
        
        Ouvrage ouvrage = getBean();
        
        // TODO
        
//        utilisateur.setNom(nom.getText());
//        utilisateur.setPrenom(prenom.getText());
//        utilisateur.setEmail(mail.getText());
//        // encode password !
//        utilisateur.setMotDePasse(String.valueOf(password.getPassword()));
//        
//        if(dateNaissance.getValue() != null) {
//            utilisateur.setDateNaissance(new java.sql.Date(dateNaissance.getValue().getTime()));
//        }
        
        return ouvrage;
    }

    @Override
    public void reset() {
        // TODO
//        nom.setText("");
//        prenom.setText("");
//        mail.setText("");
//        dateNaissance.setValue(null);
//        password.setText("");
    }
    
    
}
