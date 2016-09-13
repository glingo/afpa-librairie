package fr.afpa.librairie.controller;

import fr.afpa.librairie.data.bean.Auteur;
import fr.afpa.librairie.data.exception.DAOException;
import fr.afpa.librairie.model.list.ListAdapterListModel;
import fr.afpa.librairie.view.MainFrame;
import fr.afpa.librairie.view.admin.AuteurAdminPanel;
import fr.afpa.librairie.view.auteur.CreateAuteurPanel;
//import fr.afpa.librairie.view.admin.CreateAuteurPanel;
import java.awt.event.ActionEvent;
import java.util.logging.Logger;
import javax.swing.JList;
import javax.swing.JOptionPane;

public class AuteurController extends Controller {
    private static final Logger LOG = Logger.getLogger(AuteurController.class.getName());
    
    private final AuteurAdminPanel adminPanel = new AuteurAdminPanel(this);
    private final CreateAuteurPanel createPanel = new CreateAuteurPanel(this);

    public AuteurController(MainFrame frame) {
        super(frame);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {

            case "list":
                listAction();
                break;

            case "create":
            case "save":
                createAction();
                break;
                
            case "delete":
                JList<Auteur> list = this.adminPanel.getAuteurList();
                deleteAction(list.getSelectedValue());
                break;

            default:
                if (this.frame.getContent() == null || !this.adminPanel.equals(this.frame.getContent())) {
                    listAction();
                }
        }
    }

    public void listAction() {
        ListAdapterListModel<Auteur> AuteurListModel = new ListAdapterListModel<>();
        AuteurListModel.addAll(getDaoFactory().getAuteurDAO().findAll());
        adminPanel.setAuteurList(AuteurListModel);
        this.frame.setContent(adminPanel);

    }

    public void createAction() {

        if (!this.createPanel.equals(this.frame.getContent())) {
            this.frame.setContent(createPanel);
            return;
        }
        
        Auteur auteur = this.createPanel.getAuteur();
        
        try {
            getDaoFactory().getAuteurDAO().save(auteur);
            
        } catch (DAOException ex) {
            LOG.severe(ex.getMessage());
            danger("Une erreur est survenue !", 
                    "Impossible de sauvegarder cet auteur.");
        }
        alert("Information", "L'auteur a bien été sauvegardé!");
        listAction();
        
    }

    private void deleteAction(Auteur auteur) {
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
            return;
        }
        
        // ajouter un message comme quoi la suppression s'est bien deroulée.
        alert("Information", "L'auteur a bien été supprimé !");
        listAction();
        
    }

}
