package fr.afpa.librairie.view.commande;

import fr.afpa.librairie.data.bean.Commande;
import fr.afpa.librairie.model.verifier.StrictInputVerifier;
import fr.afpa.librairie.view.field.JDateField;
import fr.afpa.librairie.view.panel.EditorPanel;
import java.awt.event.ActionListener;
import java.sql.Date;
import javax.swing.GroupLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;

public class CommandeEditorPanel extends EditorPanel<Commande> {
    
        private JLabel numeroLabel;
        private JLabel dateCommandeLabel;
        
        private JTextField numero;
        private JDateField dateCommande;
    
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
        numero = new JTextField();
        dateCommande = new JDateField(false);
        
        numeroLabel = new JLabel("Numero :");
        dateCommandeLabel = new JLabel("Date de commande :");
        
        numero.setInputVerifier(new StrictInputVerifier());
        
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
                                    .addComponent(numeroLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(dateCommandeLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(13, 13, 13)
                                .addGroup(bodyPanelLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                    .addComponent(numero, GroupLayout.Alignment.LEADING)
                                    .addComponent(dateCommande, GroupLayout.Alignment.LEADING))))
                        .addGap(6, 6, 6))))
        );

        bodyPanelLayout.setVerticalGroup(
            bodyPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(bodyPanelLayout.createSequentialGroup()
                .addGroup(bodyPanelLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                    .addComponent(numeroLabel)
                    .addComponent(numero, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addGroup(bodyPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(dateCommandeLabel)
                    .addComponent(dateCommande, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED))
        );
    }   
    
    @Override
    public void bindValues() {
        Commande commande = getBean();
        numero.setText(commande.getNumero());
        dateCommande.setValue(commande.getDateCommande());
    }

    @Override
    public void reset() {
        numero.setText("");
        dateCommande.setValue(null);
    }

    @Override
    public Commande constructBean() {
        Commande commande = getBean();
        
        
        commande.setNumero(numero.getText());
        
        if(dateCommande.getValue() != null) {
            commande.setDateCommande(new java.sql.Date(dateCommande.getValue().getTime()));
        }
        
        return commande;
    }

}
