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
    public Promotion newBean() {
        return new Promotion();
    }

    @Override
    protected ListAdapterListModel<Promotion> getAll() {
        ListAdapterListModel<Promotion> listModel = new ListAdapterListModel<>();
        listModel.addAll(getDaoFactory().getPromotionDAO().findAll());
        return listModel;
    }
    
    @Override
    protected void loadEditorPanel() {
        // nothing to do
    }

    @Override
    public void create(Promotion value) {

        try {
            getDaoFactory().getPromotionDAO().save(value);
            alert("Information", "La promotion a bien été sauvegardée !");
        } catch (DAOException ex) {
            LOG.severe(ex.getMessage());
            danger("Une erreur est survenue !", "Impossible de sauvegarder cette promotion. ");
        }

//        listAction();
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

    @Override
    public void viewAction(Promotion value) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
