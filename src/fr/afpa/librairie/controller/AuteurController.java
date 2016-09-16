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
    public Auteur newBean() {
        return new Auteur();
    }

    @Override
    protected ListAdapterListModel<Auteur> getAll() {
        ListAdapterListModel<Auteur> listModel = new ListAdapterListModel<>();
        listModel.addAll(getDaoFactory().getAuteurDAO().findAll());
        return listModel;
    }
    
    @Override
    protected void loadEditorPanel() {
        // nothing to do ?
    }
    
    @Override
    public boolean create(Auteur value) {

        try {
            getDaoFactory().getAuteurDAO().save(value);
            alert("Information", "L'auteur a bien été sauvegardé !");
            return true;
        } catch (DAOException ex) {
            LOG.severe(ex.getMessage());
            danger("Une erreur est survenue !", 
                    "Impossible de sauvegarder cet auteur.");
        }
        
        return false;
        
//        listAction();
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
