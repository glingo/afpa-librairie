
package fr.afpa.librairie.controller;

import fr.afpa.librairie.data.bean.Auteur;
import fr.afpa.librairie.data.bean.Ouvrage;
import fr.afpa.librairie.data.exception.DAOException;
import fr.afpa.librairie.model.list.ListAdapterListModel;
import fr.afpa.librairie.view.MainFrame;
import fr.afpa.librairie.view.admin.OuvrageAdminPanel;
import fr.afpa.librairie.view.ouvrage.CreateOuvragePanel;
import java.awt.event.ActionEvent;
import java.util.List;
import javax.swing.JOptionPane;

public class OuvrageController extends Controller {
    
    private final OuvrageAdminPanel adminPanel = new OuvrageAdminPanel(this);
//    private final CreateOuvragePanel createPanel = new CreateOuvragePanel(this);
    private final CreateOuvragePanel createPanel = new CreateOuvragePanel(this);
    
    public OuvrageController(MainFrame frame) {
        super(frame);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
//        super.actionPerformed(e);
        
        switch(e.getActionCommand()) {
            
            case "list":
                listAction();
                break;
                
            case "create":
            case "save":
                createAction();
                break;
            case "delete":
                deleteAction(this.adminPanel.getOuvrageList().getSelectedValue());
                break;
            default:
                if(this.frame.getContent() == null || !this.adminPanel.equals(this.frame.getContent())) {
                    listAction();
                }
        }
    }

    public void listAction() {
        ListAdapterListModel<Ouvrage> ouvrageListModel = new ListAdapterListModel<>();
        ouvrageListModel.addAll(getDaoFactory().getOuvrageDAO().findAll());
        adminPanel.setOuvrageList(ouvrageListModel);
        this.frame.setContent(adminPanel);
    }
    
    public void createAction() {
        
        if(!this.createPanel.equals(this.frame.getContent())) {
            List<Auteur> auteurs = getDaoFactory().getAuteurDAO().findAll();
            createPanel.setAuteurList(auteurs);
            createPanel.setCoAuteurList(auteurs);
//            createPanel.setLangueList(getDaoFactory().getLangueDAO().findAll());
            
            // to be continued ...
            
            this.frame.setContent(createPanel);
            return;
        }
        
        Ouvrage ouvrage = this.createPanel.getOuvrage();
        
        try{
            getDaoFactory().getOuvrageDAO().save(ouvrage);
            
        } catch(DAOException ex){
            JOptionPane.showMessageDialog(this.frame, ex.getMessage(),
                    "Une erreur est survenue !", JOptionPane.ERROR_MESSAGE);
        }
        
        alert("Information", "L'ouvrage a bien été sauvegardé !");
        listAction();
        
    }
    
    public void deleteAction(Ouvrage ouvrage){
       if(ouvrage == null) {
            // impossible de supprimer si l'utilisateur n'a rien selectionné.
            return;
        }
        
        // supprimer les references de l'uitlisateur vers roles (Remplit)
        
        try {
            getDaoFactory().getOuvrageDAO().delete(ouvrage);
            

            
        } catch(DAOException ex){
            JOptionPane.showMessageDialog(this.frame, ex.getMessage(),
                    "Une erreur est survenue !", JOptionPane.ERROR_MESSAGE);
        }
        
        alert("Information", "L'ouvrage a bien été supprimé !");
        listAction();
        
    }
}