
package fr.afpa.librairie.controller;

import fr.afpa.librairie.data.bean.Rubrique;
import fr.afpa.librairie.data.exception.DAOException;
import fr.afpa.librairie.model.list.ListAdapterListModel;
import fr.afpa.librairie.model.table.RubriqueTableModel;
import fr.afpa.librairie.model.table.TableModel;
import fr.afpa.librairie.view.MainFrame;
import fr.afpa.librairie.view.admin.RubriqueAdminPanel;
import fr.afpa.librairie.view.rubrique.RubriqueEditorPanel;
import java.awt.event.ActionEvent;
import java.util.logging.Logger;
import javax.swing.JList;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class RubriqueController extends Controller implements ListSelectionListener {
    
    private static final Logger LOG = Logger.getLogger(RubriqueController.class.getName());
    
    private final RubriqueAdminPanel adminPanel;
    private final RubriqueEditorPanel editorPanel = new RubriqueEditorPanel(this);
    
    public RubriqueController(MainFrame frame) {
        super(frame);
        this.adminPanel = new RubriqueAdminPanel(new RubriqueTableModel(), this);
    }
    
    @Override
    public void valueChanged(ListSelectionEvent e) {
        if(!e.getValueIsAdjusting()) {
            JList list = (JList) e.getSource();
            Rubrique rubrique = (Rubrique)list.getSelectedValue();
            viewAction(rubrique);
        }
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        switch(e.getActionCommand()) {
            
            case "list":
                listAction();
                break;
                
            case "create":
            case "save":
                createAction();
                break;
                
            case "delete":
                deleteAction(this.adminPanel.getList().getSelectedValue()); 
                break;
                
            case "view":
                viewAction(this.adminPanel.getList().getSelectedValue());
                break;
                
            case "edit":
                editAction(this.adminPanel.getList().getSelectedValue());
                break;

            default:
                if(this.frame.getContent() == null || !this.adminPanel.equals(this.frame.getContent())) {
                    listAction();
                }
        }
    }

    public void listAction() {
        ListAdapterListModel<Rubrique> rubriqueListModel = new ListAdapterListModel<>();
        rubriqueListModel.addAll(getDaoFactory().getRubriqueDAO().findAll());
        this.adminPanel.setList(rubriqueListModel);
        this.frame.setContent(adminPanel);
    }
    
    public void createAction() {
                
        if(!this.editorPanel.equals(this.frame.getContent())) {
            this.editorPanel.setBean(new Rubrique());
            this.frame.setContent(this.editorPanel);
            return;
        }
        
        Rubrique rubrique = editorPanel.contructBean();
        
        try{
            getDaoFactory().getRubriqueDAO().save(rubrique);
        } catch(DAOException ex){
            LOG.severe(ex.getMessage());
            danger("Une erreur est survenue !", 
                    "Impossible de sauvegarder cette rubrique.");
            
            // on souhaite rester sur l'ecran de creation et ne pas retourner vers la liste.
            return;
        }
        
        listAction();
        this.editorPanel.reset();
        alert("Information", "La sauvegarde a bien été effectué !");
    }
    
    public void deleteAction(Rubrique rubrique){
        if(rubrique == null) {

            return;
        }

        try {
            getDaoFactory().getRubriqueDAO().delete(rubrique);
        } catch(DAOException ex){
            LOG.severe(ex.getMessage());
            danger("Une erreur est survenue !", 
                    "Impossible de supprimer cette rubrique.");
            
            return;
        }
        
        // ajouter un message comme quoi la suppression s'est bien deroulée.
        listAction();
        alert("Information", "La suppression a bien été effectuée !");
    }
    
    public void viewAction(Rubrique rubrique) {
//        this.editorPanel.setBean(rubrique);
//        this.editorPanel.bindValues();
//        this.frame.setContent(this.editorPanel);
//        List<Ouvrage> ouvrages = getDaoFactory().getOuvrageDAO().findByRubrique(rubrique.getId());
//        this.viewPanel.setOuvrageList(ouvrages);
//        this.frame.setContent(this.viewPanel);
    }
    
    public void editAction(Rubrique rubrique) {
        if(rubrique == null) {
            danger("", "Veuillez selectionner une rubrique à mettre a jour.");
            return;
        }
        
        this.editorPanel.setBean(rubrique);
        this.frame.setContent(this.editorPanel);
    }
}
