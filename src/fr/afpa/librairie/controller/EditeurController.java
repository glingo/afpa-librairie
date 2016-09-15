package fr.afpa.librairie.controller;

import fr.afpa.librairie.data.bean.Adresse;
import fr.afpa.librairie.data.bean.Editeur;
import fr.afpa.librairie.data.exception.DAOException;
import fr.afpa.librairie.model.list.ListAdapterListModel;
import fr.afpa.librairie.view.MainFrame;
import fr.afpa.librairie.view.editeur.EditeurAdminPanel;
import fr.afpa.librairie.view.editeur.EditeurEditorPanel;
import java.util.logging.Logger;

public class EditeurController extends CRUDController<Editeur> {
    
    private static final Logger LOG = Logger.getLogger(EditeurController.class.getName());
    
    public EditeurController(MainFrame frame) {
        super(frame);
        setAdminPanel(new EditeurAdminPanel(this));
        setEditorPanel(new EditeurEditorPanel(this));
    }

    @Override
    public Editeur newBean() {
        return new Editeur();
    }

    @Override
    protected void loadEditorPanel() {
        getEditorPanel().setAdresses(getDaoFactory().getAdresseDAO().findAll());
        getEditorPanel().getNewAdresse().addActionListener(getFrame().getAdresseController());
        
//        getModal().onDispose(()-> {
//            getEditorPanel().setAdresses(getDaoFactory().getAdresseDAO().findAll());
//        });
    }

    @Override
    protected ListAdapterListModel<Editeur> getAll() {
        ListAdapterListModel<Editeur> listModel = new ListAdapterListModel<>();
        listModel.addAll(getDaoFactory().getEditeurDAO().findAll());
        return listModel;
    }
    
    @Override
    public EditeurEditorPanel getEditorPanel() {
        return (EditeurEditorPanel) super.getEditorPanel();
    }
    
    @Override
    public void create(Editeur value) {
        
        try {
            getDaoFactory().getEditeurDAO().save(value);
            alert("Information", "L'éditeur a bien été sauvegardé !");
        } catch (DAOException ex) {
            LOG.severe(ex.getMessage());
            danger("Une erreur est survenue !", 
                    "Impossible de réaliser la sauvegarde de l'éditeur.");
        }

//        listAction();
    }

    @Override
    public void deleteAction(Editeur editeur) {
    
        if(editeur == null) {
            // impossible de supprimer si l'utilisateur n'a rien selectionné.
            return;
        }
        
        // les editeurs sont liés a des editions.
        
        try {
            getDaoFactory().getEditeurDAO().delete(editeur);
        } catch (DAOException ex) {
            LOG.severe(ex.getMessage());
            danger("Une erreur est survenue !", 
                    "Impossible de réaliser la suppression de l'éditeur.");
            
            return;
        }
        
        listAction();
        alert("Information", "L'éditeur a bien été supprimé !");
    }

    @Override
    public void viewAction(Editeur value) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

//    @Override
//    public void editAction(Editeur value) {
//        getEditorPanel().setAdresses(getDaoFactory().getAdresseDAO().findAll());
//        super.editAction(value);
//    }
    
}
