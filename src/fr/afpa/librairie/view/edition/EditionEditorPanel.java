package fr.afpa.librairie.view.edition;

import fr.afpa.librairie.data.bean.Edition;
import fr.afpa.librairie.view.rubrique.*;
import fr.afpa.librairie.data.bean.Rubrique;
import fr.afpa.librairie.view.field.JDateField;
import fr.afpa.librairie.view.panel.EditorPanel;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.sql.Date;
import javax.swing.GroupLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;

public class EditionEditorPanel extends EditorPanel<Edition> {
    
    
    public EditionEditorPanel(ActionListener controller) {
        super(new Edition(), controller);
    }

    public EditionEditorPanel(Edition bean, ActionListener controller) {
        super(bean, controller);
    }

    @Override
    public Edition getBean() {
        Edition edition = super.getBean();
        
        if(edition == null){
            edition = new Edition();
            setBean(edition);
        }
        
        return edition;
    }
    
    @Override
    protected String getTitleText() {
        Edition edition = getBean();
        
        return edition.getIsbn() != null 
                ? "Rubrique " + edition.getIsbn() 
                : "Nouvelle Edition";
    }
    
    @Override
    protected void initBody(JPanel body) {
        
        
    }   
    
    @Override
    public void bindValues() {
        Edition edition = getBean();
//        libelleTF.setText(rubrique.getLibelle());
//        dateDebutTF.setValue(rubrique.getDateDebut());
//        dateFinTF.setValue(rubrique.getDateFin());
//        commentaireTF.setText(rubrique.getCommentaire());
    }

    @Override
    public void reset() {
//        libelleTF.setText("");
//        dateDebutTF.setValue(null);
//        dateFinTF.setValue(null);
//        commentaireTF.setText("");
    }

    @Override
    public Edition constructBean() {
        Edition edition = getBean();
        
//        rubrique.setLibelle(libelleTF.getText().trim());
//        
//        if(dateDebutTF.getValue() != null) {
//            Date debut = new Date(dateDebutTF.getValue().getTime());
//            rubrique.setDateDebut(debut);
//        }
//        
//        if(dateFinTF.getValue() != null) {
//            Date fin = new Date(dateFinTF.getValue().getTime());
//            rubrique.setDateFin(fin);
//        }
//        
//        rubrique.setCommentaire(commentaireTF.getText().trim());
        
        return edition;
    }

}
