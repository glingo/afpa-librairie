package fr.afpa.librairie.controller;

import fr.afpa.librairie.data.bean.Ouvrage;
import fr.afpa.librairie.data.bean.Rubrique;
import fr.afpa.librairie.data.exception.DAOException;
import fr.afpa.librairie.model.list.ListAdapterListModel;
import fr.afpa.librairie.view.MainFrame;
import fr.afpa.librairie.view.rubrique.RubriqueAdminPanel;
import fr.afpa.librairie.view.rubrique.RubriqueEditorPanel;

import java.awt.Component;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class RubriqueController extends CRUDController<Rubrique> {

    //implements ListSelectionListener
    private static final Logger LOG = Logger.getLogger(RubriqueController.class.getName());

//    private final RubriqueAdminPanel adminPanel;
//    private final RubriqueEditorPanel editorPanel = new RubriqueEditorPanel(this);
    public RubriqueController(MainFrame frame) {
        super(frame);
        setAdminPanel(new RubriqueAdminPanel(this));
        setEditorPanel(new RubriqueEditorPanel(this));
       

    }

    @Override
    public Rubrique newBean() {
        return new Rubrique();
    }

    @Override
    protected ListAdapterListModel<Rubrique> getAll() {
        ListAdapterListModel<Rubrique> listModel = new ListAdapterListModel<>();
        listModel.addAll(getDaoFactory().getRubriqueDAO().findAll());
        return listModel;
    }

    @Override
    public RubriqueEditorPanel getEditorPanel() {
        return (RubriqueEditorPanel) super.getEditorPanel();
    }

 

    @Override
    protected void loadEditorPanel() {
       
    }



    @Override
    public boolean create(Rubrique value) {

        if (value.getDateDebut() == null) {
            danger("Vous devez renseigner une de debut pour cette rubrique.");
            return false;
        }

        try {
            getDaoFactory().getRubriqueDAO().save(value);
            alert("Information", "La rubrique a bien été sauvegardée !");
            return true;
        } catch (DAOException ex) {
            LOG.severe(ex.getMessage());
            danger("Impossible de sauvegarder cette rubrique.");
        }

        return false;
    }

    

    @Override
    public void deleteAction(Rubrique value) {
        if (value == null) {
            // impossible de supprimer si l'utilisateur n'a rien selectionné.
            return;
        }

        try {

            getDaoFactory().getRubriqueDAO().delete(value);

        } catch (DAOException ex) {
            LOG.severe(ex.getMessage());
            danger("Une erreur est survenue !",
                    "Impossible de supprimer cette rubrique.");
            return;
        }

        listAction();
        alert("Information", "La rubrique a bien été supprimée !");
    }

//    public void valueChanged(ListSelectionEvent e) {
//        if (!e.getValueIsAdjusting()) {
//            JList list = (JList) e.getSource();
//            Rubrique rubrique = (Rubrique) list.getSelectedValue();
//            viewAction(rubrique);
//        }
//    }
//
//    @Override
//    public boolean create(Rubrique value) {
//        try {
//            getDaoFactory().getRubriqueDAO().save(value);
//            alert("Information", "La sauvegarde a bien été effectué !");
//            return true;
//        } catch (DAOException ex) {
//            LOG.severe(ex.getMessage());
//            danger("Une erreur est survenue !",
//                    "Impossible de sauvegarder cette rubrique.");
//        }
//        return false;
////        listAction();
//    }
//
//    @Override
//    public void deleteAction(Rubrique rubrique) {
//        if (rubrique == null) {
//
//            return;
//        }
//
//        try {
//            getDaoFactory().getRubriqueDAO().delete(rubrique);
//        } catch (DAOException ex) {
//            LOG.severe(ex.getMessage());
//            danger("Une erreur est survenue !",
//                    "Impossible de supprimer cette rubrique.");
//
//            return;
//        }
//
//        // ajouter un message comme quoi la suppression s'est bien deroulée.
//        listAction();
//        alert("Information", "La suppression a bien été effectuée !");
//    }
//
//    @Override
//    public void viewAction(Rubrique rubrique) {
////        this.editorPanel.setBean(rubrique);
////        this.editorPanel.bindValues();
////        this.frame.setContent(this.editorPanel);
////        List<Ouvrage> ouvrages = getDaoFactory().getOuvrageDAO().findByRubrique(rubrique.getId());
////        this.viewPanel.setOuvrageList(ouvrages);
////        this.frame.setContent(this.viewPanel);
//    }
//
////    @Override
////    public void editAction(Rubrique rubrique) {
////        if(rubrique == null) {
////            danger("", "Veuillez selectionner une rubrique à mettre a jour.");
////            return;
////        }
////        
////        getEditorPanel().setBean(rubrique);
////        getFrame().setContent(getEditorPanel());
////    }
    @Override
    public void viewAction(Rubrique value) {
    }

}
