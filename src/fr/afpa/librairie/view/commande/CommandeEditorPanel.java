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
    
        private JLabel adrLivLabel;
        private JLabel adrFacLabel;
        private JLabel utilisLabel;
        private JLabel numeroLabel;
        private JLabel datComLabel;
        
        private JTextField adresseLivraison;
        private JTextField adresseFacturation;
        private JTextField utilisateur;
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
        
//                    instance.getAdresseLivraison().getId(), 
//                    instance.getAdresseFacturation().getId(),
//                    instance.getUser().getId(),
//                    instance.getNumero(), 
//                    instance.getDateCommande());
        adresseLivraison    = new JTextField();
        adresseFacturation  = new JTextField();
        utilisateur         = new JTextField();
        numero              = new JTextField();
        dateCommande        = new JDateField(false);
        
        adrLivLabel = new JLabel("Adresse de livraison : ");
        adrFacLabel = new JLabel("Adresse de facturation : ");
        utilisLabel = new JLabel("Nom du client : ");
        numeroLabel = new JLabel("Numero : ");
        datComLabel = new JLabel("Date de commande : ");
        
        adresseLivraison.setInputVerifier(new StrictInputVerifier());
        adresseFacturation.setInputVerifier(new StrictInputVerifier());
        utilisateur.setInputVerifier(new StrictInputVerifier());
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
                                    .addComponent(adrLivLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(adrFacLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(utilisLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(numeroLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(datComLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(13, 13, 13)
                                .addGroup(bodyPanelLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                    .addComponent(adresseLivraison, GroupLayout.Alignment.LEADING)
                                    .addComponent(adresseFacturation, GroupLayout.Alignment.LEADING)
                                    .addComponent(utilisateur, GroupLayout.Alignment.LEADING)
                                    .addComponent(numero, GroupLayout.Alignment.LEADING)
                                    .addComponent(dateCommande, GroupLayout.Alignment.LEADING))))
                        .addGap(6, 6, 6))))
        );

        bodyPanelLayout.setVerticalGroup(
            bodyPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(bodyPanelLayout.createSequentialGroup()
                .addGroup(bodyPanelLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                    .addComponent(adrLivLabel)
                    .addComponent(adresseLivraison, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addGroup(bodyPanelLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                    .addComponent(adrFacLabel)
                    .addComponent(adresseFacturation, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addGroup(bodyPanelLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                    .addComponent(utilisLabel)
                    .addComponent(utilisateur, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addGroup(bodyPanelLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                    .addComponent(numeroLabel)
                    .addComponent(numero, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addGroup(bodyPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(datComLabel)
                    .addComponent(dateCommande, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED))
        );
    }   
    
    @Override
    public void bindValues() {
        Commande commande = getBean();
        //adresseLivraison.setText(commande.getAdresseLivraison());
        //adresseFacturation.setText(commande.getAdresseFacturation());
        //utilisateur.setText(commande.getUser());
        numero.setText(commande.getNumero());
        dateCommande.setValue(commande.getDateCommande());
    }

    @Override
    public void reset() {
        adresseLivraison.setText("");
        adresseFacturation.setText("");
        utilisateur.setText("");
        numero.setText("");
        dateCommande.setValue(null);
    }

    @Override
    public Commande constructBean() {
        Commande commande = getBean();
        
        //commande.setAdresseLivraison(adresseLivraison.getText());
        //commande.setAdresseFacturation(adresseFacturation.getText());
        //commande.setUser(utilisateur.getText());
        commande.setNumero(numero.getText());
        
        if(dateCommande.getValue() != null) {
            commande.setDateCommande(new java.sql.Date(dateCommande.getValue().getTime()));
        }
        
        return commande;
    }

}
