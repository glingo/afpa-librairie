
package fr.afpa.librairie.controller;

import fr.afpa.librairie.data.bean.Ouvrage;
import fr.afpa.librairie.data.bean.Rubrique;
import fr.afpa.librairie.data.exception.DAOException;
import fr.afpa.librairie.model.list.ListAdapterListModel;
import fr.afpa.librairie.view.MainFrame;
import fr.afpa.librairie.view.admin.RubriqueAdminPanel;
import fr.afpa.librairie.view.rubrique.CreateRubriquePanel;
import fr.afpa.librairie.view.rubrique.RubriqueViewPanel;
import java.awt.event.ActionEvent;
import java.util.List;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class RubriqueController extends Controller implements ListSelectionListener {
    
    private final RubriqueAdminPanel adminPanel = new RubriqueAdminPanel(this);
//    private final CreateRubriquePanel createPanel = new CreateRubriquePanel(this);
    private final CreateRubriquePanel createPanel = new CreateRubriquePanel(this);
    private final RubriqueViewPanel viewPanel = new RubriqueViewPanel(this);
    
    public RubriqueController(MainFrame frame) {
        super(frame);
    }
    
    @Override
    public void valueChanged(ListSelectionEvent e) {
        if(!e.getValueIsAdjusting()) {
            JList list = (JList) e.getSource();
            Rubrique rubrique = (Rubrique)list.getSelectedValue();
            System.out.println("rubrique : " + rubrique);
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
                
            case"delete":
                deleteAction(this.adminPanel.getRubriqueList().getSelectedValue());

            default:
                if(this.frame.getContent() == null || !this.adminPanel.equals(this.frame.getContent())) {
                    listAction();
                }
        }
    }

    public void listAction() {
        ListAdapterListModel<Rubrique> rubriqueListModel = new ListAdapterListModel<>();
        rubriqueListModel.addAll(getDaoFactory().getRubriqueDAO().findAll());
        adminPanel.setRubriqueList(rubriqueListModel);
        this.frame.setContent(adminPanel);
    }
    
    public void createAction() {
        
        if(!this.createPanel.equals(this.frame.getContent())) {
            this.frame.setContent(createPanel);
            return;
        }
        
        Rubrique rubrique = this.createPanel.getRubrique();
        
        try{
            getDaoFactory().getRubriqueDAO().save(rubrique);
           
        } catch(DAOException ex){
            JOptionPane.showMessageDialog(this.frame, ex.getMessage(),
                    "Une erreur est survenue !", JOptionPane.ERROR_MESSAGE);
        }
    
        listAction();
    }
    
    public void deleteAction(Rubrique rubrique){
        if(rubrique == null) {

            return;
        }

        try {
            getDaoFactory().getRubriqueDAO().delete(rubrique);
            JOptionPane deleteRub = new JOptionPane();
            deleteRub.showMessageDialog(null, "La suppression a bien été effectué !", "Information", JOptionPane.INFORMATION_MESSAGE);

            
        } catch(DAOException ex){
            JOptionPane.showMessageDialog(this.frame, ex.getMessage(),
                    "Une erreur est survenue !", JOptionPane.ERROR_MESSAGE);
        }
        
        // ajouter un message comme quoi la suppression s'est bien deroulée.
    
        listAction();
    }
    
    
    public void viewAction(Rubrique rubrique) {
        List<Ouvrage> ouvrages = getDaoFactory().getOuvrageDAO().findByRubrique(rubrique.getId());
        this.viewPanel.setOuvrageList(ouvrages);
        this.frame.setContent(this.viewPanel);
    }
}
