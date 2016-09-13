package fr.afpa.librairie.controller;

import fr.afpa.librairie.data.bean.Promotion;
import fr.afpa.librairie.data.exception.DAOException;
import fr.afpa.librairie.model.list.ListAdapterListModel;
import fr.afpa.librairie.view.MainFrame;
import fr.afpa.librairie.view.admin.CreatePromotionPanel;
import fr.afpa.librairie.view.admin.PromotionAdminPanel;
import java.awt.event.ActionEvent;
import java.sql.Date;
import java.text.NumberFormat;
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class PromotionController extends Controller {

    private final PromotionAdminPanel adminPanel = new PromotionAdminPanel(this);
    private final CreatePromotionPanel createPanel = new CreatePromotionPanel(this);

    public PromotionController(MainFrame frame) {
        super(frame);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
//        super.actionPerformed(e);

        switch (e.getActionCommand()) {

            case "list":
                listAction();
                break;

            case "create":
            case "save":
                createAction();
                break;
            case "delete":
                deleteAction(this.adminPanel.getPromoList().getSelectedValue());
                break;
            default:
                if (this.frame.getContent() == null || !this.adminPanel.equals(this.frame.getContent())) {
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

        if (!this.createPanel.equals(this.frame.getContent())) {
            this.frame.setContent(createPanel);
            return;
        }

        this.createPanel.getForm().verify();

        JFormattedTextField fieldDateDebut = this.createPanel.getForm().getField("Date de début");
        JFormattedTextField fieldDateFin = this.createPanel.getForm().getField("Date de fin");
        JFormattedTextField fieldReduction = new JFormattedTextField(NumberFormat.getPercentInstance());
        //formatter le champs texte pour acceuillir un float et l'afficher en pourcentage.
        fieldReduction = this.createPanel.getForm().getField("Reduction");
        JTextField fieldImage = this.createPanel.getForm().getField("Image");
        JTextField fieldDescription = this.createPanel.getForm().getField("Description");
        JTextField fieldCommentaire = this.createPanel.getForm().getField("Commentaire");

        Date dateDebut = (Date) fieldDateDebut.getValue();
        Date dateFin = (Date) fieldDateFin.getValue();
        Float reduction = (Float) fieldReduction.getValue();
        String image = fieldImage.getText();
        String description = fieldDescription.getText();
        String commentaire = fieldCommentaire.getText();

        Promotion promotion = new Promotion();

        promotion.setDateDebut(new java.sql.Date(dateDebut.getTime()));
        promotion.setDateFin(new java.sql.Date(dateFin.getTime()));
        promotion.setReduction(reduction);
        promotion.setImage(image);
        promotion.setDescription(description);
        promotion.setCommentaire(commentaire);

        try {
            getDaoFactory().getPromotionDAO().save(promotion);
           
        } catch (DAOException ex) {
            JOptionPane.showMessageDialog(this.frame, ex.getMessage(),
                    "Une erreur est survenue !", JOptionPane.ERROR_MESSAGE);
        }

        this.createPanel.getForm().reset();
        
        alert("Information", "La promotion a bien été sauvegardé !");
        listAction();
        
    }

    public void deleteAction(Promotion promotion) {
        if (promotion == null) {

            return;
        }

        try {
            getDaoFactory().getPromotionDAO().delete(promotion);
            

        } catch (DAOException ex) {
            JOptionPane.showMessageDialog(this.frame, ex.getMessage(),
                    "Une erreur est survenue !", JOptionPane.ERROR_MESSAGE);
        }

        alert("Information", "La promotion a bien été supprimé !");
        listAction();
        
    }

}
