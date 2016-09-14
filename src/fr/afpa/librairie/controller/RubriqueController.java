
package fr.afpa.librairie.controller;

import fr.afpa.librairie.data.bean.Rubrique;
import fr.afpa.librairie.data.exception.DAOException;
import fr.afpa.librairie.model.list.ListAdapterListModel;
import fr.afpa.librairie.view.MainFrame;
import fr.afpa.librairie.view.rubrique.RubriqueAdminPanel;
import fr.afpa.librairie.view.rubrique.RubriqueEditorPanel;
import java.util.logging.Logger;
import javax.swing.JList;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class RubriqueController extends CRUDController<Rubrique> implements ListSelectionListener {
    
    private static final Logger LOG = Logger.getLogger(RubriqueController.class.getName());
    
//    private final RubriqueAdminPanel adminPanel;
//    private final RubriqueEditorPanel editorPanel = new RubriqueEditorPanel(this);
    
    public RubriqueController(MainFrame frame) {
        super(frame);
        setAdminPanel(new RubriqueAdminPanel(this));
        setEditorPanel(new RubriqueEditorPanel(this));
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
    public void listAction() {
        ListAdapterListModel<Rubrique> rubriqueListModel = new ListAdapterListModel<>();
        rubriqueListModel.addAll(getDaoFactory().getRubriqueDAO().findAll());
        getAdminPanel().setList(rubriqueListModel);
        getFrame().setContent(getAdminPanel());
    }
    
    @Override
    public void createAction() {
                
        if(!getEditorPanel().equals(getFrame().getContent())) {
            getEditorPanel().setBean(new Rubrique());
            getFrame().setContent(getEditorPanel());
            return;
        }
        
        Rubrique rubrique = getEditorPanel().constructBean();
        
        try{
            getDaoFactory().getRubriqueDAO().save(rubrique);
        } catch(DAOException ex){
            LOG.severe(ex.getMessage());
            danger("Une erreur est survenue !", 
                    "Impossible de sauvegarder cette rubrique.");
            
            // on souhaite rester sur l'ecran de creation et ne pas retourner vers la liste.
            return;
        }
        
        getEditorPanel().reset();
        listAction();
        alert("Information", "La sauvegarde a bien été effectué !");
    }
    
    @Override
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
    
    @Override
    public void viewAction(Rubrique rubrique) {
//        this.editorPanel.setBean(rubrique);
//        this.editorPanel.bindValues();
//        this.frame.setContent(this.editorPanel);
//        List<Ouvrage> ouvrages = getDaoFactory().getOuvrageDAO().findByRubrique(rubrique.getId());
//        this.viewPanel.setOuvrageList(ouvrages);
//        this.frame.setContent(this.viewPanel);
    }
    
//    @Override
//    public void editAction(Rubrique rubrique) {
//        if(rubrique == null) {
//            danger("", "Veuillez selectionner une rubrique à mettre a jour.");
//            return;
//        }
//        
//        getEditorPanel().setBean(rubrique);
//        getFrame().setContent(getEditorPanel());
//    }

}
