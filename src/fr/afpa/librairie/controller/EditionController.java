package fr.afpa.librairie.controller;

import fr.afpa.librairie.data.bean.Edition;
import fr.afpa.librairie.data.bean.Langue;
import fr.afpa.librairie.data.bean.Taxe;
import fr.afpa.librairie.data.exception.DAOException;
import fr.afpa.librairie.model.list.ListAdapterListModel;
import fr.afpa.librairie.view.MainFrame;
import fr.afpa.librairie.view.edition.EditionAdminPanel;
import fr.afpa.librairie.view.edition.EditionEditorPanel;
import java.awt.event.ActionEvent;
import java.util.List;
import java.util.logging.Logger;
import javax.swing.JFileChooser;

public class EditionController extends ActivableCRUDController<Edition> {
    


    private static final Logger LOG = Logger.getLogger(EditionController.class.getName());

    //contructeur du controller
    public EditionController(MainFrame frame) {
        super(frame);
        setAdminPanel(new EditionAdminPanel(this));
        setEditorPanel(new EditionEditorPanel(this));
    }

    @Override
    public Edition newBean() {
        return new Edition();
    }

    @Override
    protected ListAdapterListModel<Edition> getAll() {
        ListAdapterListModel<Edition> listModel = new ListAdapterListModel<>();
        //appel la listModel de edition
        listModel.addAll(getDaoFactory().getEditionDAO().findAll());
        return listModel;
    }
    
    
    @Override
    public EditionEditorPanel getEditorPanel() {
        return (EditionEditorPanel) super.getEditorPanel(); 
    }
    
    
    @Override
    protected void loadEditorPanel() {
        List<Langue> langues = getDaoFactory().getLangueDAO().findAll();
        
        // load langue
        getEditorPanel().setLangueModel(langues);
        
        
        List<Taxe> taxes = getDaoFactory().getTaxeDao().findAll();
        
        getEditorPanel().setTaxeModel(taxes);
        
        


    }

    

    //Si User = "save" alors EditionController ==> createAction
    @Override
    public boolean create(Edition value) {

        try {
            getDaoFactory().getEditionDAO().save(value);
            //appel de la methode EditionDAO. mais surtout appel de la requete SQL save contenu dans EditionDAO.afin de créer une nouvelle edition.

            alert("Information", "L'édition a bien été sauvegardée !");
            return true;
        } catch (DAOException ex) {
            LOG.severe(ex.getMessage());
            danger("Une erreur est survenue !", "Impossible de sauvegarder l'édition");
        }
        
        return false;

//        listAction();
    }


    @Override
    public void deactivateAction(Edition edition) {

        if (edition == null) {
            return;
        }
        // on verifier si edition = null. Si l'édition est nulle ( donc pas selectionnée ) alors impossible de supprimer.

        try {
            getDaoFactory().getEditionDAO().delete(edition);
        } catch (DAOException ex) {
            LOG.severe(ex.getMessage());
            danger("Une erreur est survenue !", "Impossible de désactiver l'édition");

            return;

        }

        alert("Information", "L'édition a bien été désactivée !");
        // ajouter un message comme quoi la suppression s'est bien deroulée.
        listAction();

    }
    
    @Override
    public void activateAction(Edition edition){
        
        if(edition == null){
            return;
        }
        
        try{
            getDaoFactory().getEditionDAO().activate(edition);
            
        }catch(DAOException ex){
            LOG.severe(ex.getMessage());
            danger("Une erreur est survenue !", 
                    "Impossible d'activer cette édition.");
            return;
        }
        
        listAction();
        alert("Information", "L'activation a été pris en compte !");
    }

    @Override
    public void viewAction(Edition edition) {
       
    }

    @Override
    public void deleteAction(Edition value) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
