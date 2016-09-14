package fr.afpa.librairie.view.commande;

import fr.afpa.librairie.data.bean.Commande;
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

public class CommandeEditorPanel extends EditorPanel<Commande> {
    
    public CommandeEditorPanel(ActionListener controller) {
        super(new Commande(), controller);
    }

    public CommandeEditorPanel(Commande bean, ActionListener controller) {
        super(bean, controller);
    }

    @Override
    public Commande getBean() {
        Commande commande = super.getBean();
        
        if(commande == null){
            commande = new Commande();
            setBean(commande);
        }
        
        return commande;
    }
    
    @Override
    protected String getTitleText() {
        Commande commande = super.getBean();
        
        return commande.getId() != null 
                ? "Commande " + commande.getNumero()
                : "Nouvelle Commande";
    }
    
    @Override
    protected void initBody(JPanel body) {
        
    }   
    
    @Override
    public void bindValues() {
        Commande commande = getBean();
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
    public Commande constructBean() {
        Commande commande = getBean();
        
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
        
        return commande;
    }

}
