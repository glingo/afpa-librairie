package fr.afpa.librairie.controller;

import fr.afpa.librairie.data.bean.Editeur;
import fr.afpa.librairie.data.exception.DAOException;
import fr.afpa.librairie.model.list.ListAdapterListModel;
import fr.afpa.librairie.view.MainFrame;
import fr.afpa.librairie.view.admin.CreateEditeurPanel;
import fr.afpa.librairie.view.admin.EditeurAdminPanel;
import java.awt.event.ActionEvent;
import java.util.logging.Logger;
import javax.swing.JTextField;

public class EditeurController extends Controller {
    
    private static final Logger LOG = Logger.getLogger(EditeurController.class.getName());
    
    private final EditeurAdminPanel adminPanel = new EditeurAdminPanel(this);
    private final CreateEditeurPanel createPanel = new CreateEditeurPanel(this);
    
    public EditeurController(MainFrame frame){
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
                deleteAction(this.adminPanel.getEditeurList().getSelectedValue());
                break;

            default:
                if (this.frame.getContent() == null || !this.adminPanel.equals(this.frame.getContent())) {
                    listAction();
                }
        }
    }

    public void listAction() {
        ListAdapterListModel<Editeur> EditeurListModel = new ListAdapterListModel<>();
        EditeurListModel.addAll(getDaoFactory().getEditeurDAO().findAll());
        adminPanel.setAuteurList(EditeurListModel);
        this.frame.setContent(adminPanel);

    }

    public void createAction() {

        if (!this.createPanel.equals(this.frame.getContent())) {
            this.frame.setContent(createPanel);
            return;
        }

        this.createPanel.getForm().verify();

        JTextField fieldLibelle = this.createPanel.getForm().getField("Libelle");


        String libelle = fieldLibelle.getText();

        Editeur editeur = new Editeur();
        
        editeur.setLibelle(libelle);

        try {
            getDaoFactory().getEditeurDAO().save(editeur);
        } catch (DAOException ex) {
            LOG.severe(ex.getMessage());
            danger("Une erreur est survenue !", 
                    "Impossible de réaliser la sauvegarde de l'éditeur.");
        }

        this.createPanel.getForm().reset();

        listAction();

    }

    private void deleteAction(Editeur editeur) {
    
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
        }
         
        listAction();
        
    }
    
    
}
