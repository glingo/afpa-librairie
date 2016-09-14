package fr.afpa.librairie.controller;

import fr.afpa.librairie.data.bean.Promotion;
import fr.afpa.librairie.data.exception.DAOException;
import fr.afpa.librairie.model.list.ListAdapterListModel;
import fr.afpa.librairie.view.MainFrame;
import fr.afpa.librairie.view.promotion.PromotionAdminPanel;
import fr.afpa.librairie.view.promotion.PromotionEditorPanel;
import java.util.logging.Logger;

public class PromotionController extends CRUDController<Promotion> {
    
    private static final Logger LOG = Logger.getLogger(PromotionController.class.getName());

    public PromotionController(MainFrame frame) {
        super(frame);
        setAdminPanel(new PromotionAdminPanel(this));
        setEditorPanel(new PromotionEditorPanel(this));
    }

    @Override
    public void listAction() {
        ListAdapterListModel<Promotion> promotionListModel = new ListAdapterListModel<>();
        promotionListModel.addAll(getDaoFactory().getPromotionDAO().findAll());
        getAdminPanel().setList(promotionListModel);
        getFrame().setContent(getAdminPanel());
    }

    @Override
    public void createAction() {

        if (!getEditorPanel().equals(getFrame().getContent())) {
            getEditorPanel().setBean(new Promotion());
            getFrame().setContent(getEditorPanel());
            return;
        }
        
/*
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
*/
        Promotion promotion = getEditorPanel().constructBean();
        
        try {
            getDaoFactory().getPromotionDAO().save(promotion);
        } catch (DAOException ex) {
            LOG.severe(ex.getMessage());
            danger("Une erreur est survenue !", "Impossible de sauvegarder cette promotion. ");
            
            return;
        }

//        this.createPanel.getForm().reset();
        
        listAction();
        alert("Information", "La promotion a bien été sauvegardée !");
        getEditorPanel().reset();
        
    }

    @Override
    public void deleteAction(Promotion promotion) {
        if (promotion == null) {

            return;
        }

        try {
            getDaoFactory().getPromotionDAO().delete(promotion);
            

        } catch (DAOException ex) {
            LOG.severe(ex.getMessage());
            danger("Une erreur est survenue !", "Impossible de supprimer cette promotion. ");
            
            return;
        }

        alert("Information", "La promotion a bien été supprimée !");
        listAction();
        
    }

//    @Override
//    public void editAction(Promotion value) {
//        if(value == null) {
//            danger("", "Veuillez selectionner une promotion à mettre a jour.");
//            return;
//        }
//        
//        getEditorPanel().setBean(value);
//        getFrame().setContent(getEditorPanel());
//    }

    @Override
    public void viewAction(Promotion value) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
