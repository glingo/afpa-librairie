package fr.afpa.librairie.controller;

import fr.afpa.librairie.data.bean.Auteur;
import fr.afpa.librairie.data.exception.DAOException;
import fr.afpa.librairie.model.list.ListAdapterListModel;
import fr.afpa.librairie.view.MainFrame;
import fr.afpa.librairie.view.auteur.AuteurAdminPanel;
import fr.afpa.librairie.view.auteur.AuteurEditorPanel;
//import fr.afpa.librairie.view.admin.CreateAuteurPanel;
import java.util.logging.Logger;

public class AuteurController extends CRUDController<Auteur> {
    
    private static final Logger LOG = Logger.getLogger(AuteurController.class.getName());
    
    public AuteurController(MainFrame frame) {
        super(frame);
        setAdminPanel(new AuteurAdminPanel(this));
        setEditorPanel(new AuteurEditorPanel(this));
    }

    @Override
    public void listAction() {
        ListAdapterListModel<Auteur> auteurListModel = new ListAdapterListModel<>();
        auteurListModel.addAll(getDaoFactory().getAuteurDAO().findAll());
        getAdminPanel().setList(auteurListModel);
        getFrame().setContent(getAdminPanel());
    }

    @Override
    public void createAction() {

        if (!getEditorPanel().equals(getFrame().getContent())) {
            getEditorPanel().setBean(new Auteur());
            getFrame().setContent(getEditorPanel());
            return;
        }
        
        Auteur auteur = getEditorPanel().constructBean();
        
        try {
            getDaoFactory().getAuteurDAO().save(auteur);
            
        } catch (DAOException ex) {
            LOG.severe(ex.getMessage());
            danger("Une erreur est survenue !", 
                    "Impossible de sauvegarder cet auteur.");
        }
        
        listAction();
        getEditorPanel().reset();
        alert("Information", "L'auteur a bien été sauvegardé !");
    }

    @Override
    public void deleteAction(Auteur auteur) {
        if(auteur == null) {
            // impossible de supprimer si l'utilisateur n'a rien selectionné.
            return;
        }
        
        // impossible de supprimer un auteur si des ouvrages sont encore relié a lui.
        
        try{
            
            // on regarde si l'auteur est encore relié a des ouvrages 
            // si oui on demande a l'utilisateur si il veut tous les supprimer.
            // on recup la liste des  ouvrages
            // on les supprime
            
            // on continue la suppression de l'auteur.
            
            getDaoFactory().getAuteurDAO().delete(auteur);
            
        } catch(DAOException ex){
            LOG.severe(ex.getMessage());
            danger("Une erreur est survenue !", 
                    "Impossible de supprimer cet auteur.");
            //ici on met l'instruction permettant de supprimé l'auteur. 
            return;
        }
        
        listAction();
        // ajouter un message comme quoi la suppression s'est bien deroulée.
        alert("Information", "L'auteur a bien été supprimée !");
        
    }

    @Override
    public void viewAction(Auteur value) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
