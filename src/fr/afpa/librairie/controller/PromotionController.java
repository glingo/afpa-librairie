
package fr.afpa.librairie.controller;

import fr.afpa.librairie.data.bean.Promotion;
import fr.afpa.librairie.model.list.ListAdapterListModel;
import fr.afpa.librairie.view.MainFrame;
import fr.afpa.librairie.view.admin.CreatePromotionPanel;
import fr.afpa.librairie.view.admin.PromotionAdminPanel;
import java.awt.event.ActionEvent;
import java.sql.Date;
import javax.swing.JFormattedTextField;
import javax.swing.JTextField;

public class PromotionController extends Controller {
    
    private final PromotionAdminPanel adminPanel = new PromotionAdminPanel(this);
    private final CreatePromotionPanel createPanel = new CreatePromotionPanel(this);
    
    public PromotionController(MainFrame frame) {
        super(frame);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        super.actionPerformed(e);
        
        switch(e.getActionCommand()) {
            
            case "list":
                listAction();
                break;
                
            case "create":
            case "save":
                createAction();
                break;

            default:
                if(this.frame.getContent() == null || !this.adminPanel.equals(this.frame.getContent())) {
                    listAction();
                }
        }
    }

    public void listAction() {
        ListAdapterListModel<Promotion> promotionListModel = new ListAdapterListModel<>();
        promotionListModel.addAll(getDaoFactory().getPromotionDAO().findAll());
        adminPanel.setCommandeList(promotionListModel);
        this.frame.setContent(adminPanel);
    }
    
    public void createAction() {
        
        if(!this.createPanel.equals(this.frame.getContent())) {
            this.frame.setContent(createPanel);
            return;
        }
        
        this.createPanel.getForm().verify();
        
        JFormattedTextField fieldDateDebut = this.createPanel.getForm().getField("Date de début");
        JFormattedTextField fieldDateFin = this.createPanel.getForm().getField("Date de fin");
        JTextField fieldReduction = this.createPanel.getForm().getField("Réduction");
        JTextField fieldImage = this.createPanel.getForm().getField("Image");
        JTextField fieldDescription = this.createPanel.getForm().getField("Description");
        JTextField fieldCommentaire = this.createPanel.getForm().getField("Commentaire");
        
        
        
        Date dateDebut = (Date) fieldDateDebut.getValue();
        Date dateFin = (Date) fieldDateFin.getValue();
        String reduction = fieldReduction.getText();
        String image = fieldImage.getText();
        String description = fieldDescription.getText();
        String commentaire = fieldCommentaire.getText();
        
        
        Promotion promotion = new Promotion();
        //**********************************REPRISE ICI********************************

//        promotion.setNumero(numero);
//        commande.setDateCommande(new java.sql.Date(dateCommande.getTime()));

        
//        try{
//            getDaoFactory().getCommandeDAO().save(commande);
//        } catch(DAOException ex){
//            JOptionPane.showMessageDialog(this.frame, ex.getMessage(),
//                    "Une erreur est survenue !", JOptionPane.ERROR_MESSAGE);
//        }
//        
        this.createPanel.getForm().reset();
    
        listAction();
    }
    
}
