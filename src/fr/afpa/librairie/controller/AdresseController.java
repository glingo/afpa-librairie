package fr.afpa.librairie.controller;

import fr.afpa.librairie.data.bean.Adresse;
import fr.afpa.librairie.data.exception.DAOException;
import fr.afpa.librairie.model.list.ListAdapterListModel;
import fr.afpa.librairie.view.MainFrame;
import fr.afpa.librairie.view.adresse.AdresseAdminPanel;
import fr.afpa.librairie.view.adresse.AdresseEditorPanel;
import java.util.logging.Logger;

public class AdresseController extends CRUDController<Adresse> {
    private static final Logger LOG = Logger.getLogger(AdresseController.class.getName());

    public AdresseController(MainFrame frame) {
        super(frame);
        setAdminPanel(new AdresseAdminPanel(this));
        setEditorPanel(new AdresseEditorPanel(this));
    }
    
    @Override
    public void listAction() {
        ListAdapterListModel<Adresse> listModel = new ListAdapterListModel<>();
        listModel.addAll(getDaoFactory().getAdresseDAO().findAll());
        getAdminPanel().setList(listModel);
        getFrame().setContent(getAdminPanel());
    }

    @Override
    public void createAction() {
        if (!getEditorPanel().equals(getFrame().getContent())) {
            getEditorPanel().setBean(new Adresse());
            getFrame().setContent(getEditorPanel());
            return;
        }
        
        Adresse adresse = getEditorPanel().constructBean();
        
        try {
            getDaoFactory().getAdresseDAO().save(adresse);
            
        } catch (DAOException ex) {
            LOG.severe(ex.getMessage());
            danger("Une erreur est survenue !", 
                    "Impossible de sauvegarder cette adresse.");
        }
        
        listAction();
        getEditorPanel().reset();
        alert("Information", "L'adresse a bien été sauvegardée !");
        
    }

    @Override
    public void viewAction(Adresse value) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deleteAction(Adresse value) {
        if(value == null) {
            // impossible de supprimer si l'utilisateur n'a rien selectionné.
            return;
        }
        
        try{
            
            getDaoFactory().getAdresseDAO().delete(value);
            
        } catch(DAOException ex){
            LOG.severe(ex.getMessage());
            danger("Une erreur est survenue !", 
                    "Impossible de supprimer cette adresse.");
            return;
        }
        
        listAction();
        alert("Information", "L'adresse a bien été supprimée !");
    }
    
}
