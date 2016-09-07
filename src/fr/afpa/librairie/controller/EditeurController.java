package fr.afpa.librairie.controller;

import fr.afpa.librairie.data.bean.Editeur;
import fr.afpa.librairie.data.exception.DAOException;
import fr.afpa.librairie.model.list.ListAdapterListModel;
import fr.afpa.librairie.view.MainFrame;
import fr.afpa.librairie.view.admin.CreateEditeurPanel;
import fr.afpa.librairie.view.admin.EditeurAdminPanel;
import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class EditeurController extends Controller {
    
    private final EditeurAdminPanel adminPanel = new EditeurAdminPanel(this);
    private final CreateEditeurPanel createPanel = new CreateEditeurPanel(this);
    
    
    public EditeurController(MainFrame frame){
        super(frame);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        super.actionPerformed(e);

        switch (e.getActionCommand()) {

            case "list":
                System.out.println("create");
                listAction();
                break;

            case "create":
            case "save":
                System.out.println("save");
                createAction();
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
            JOptionPane.showMessageDialog(this.frame, ex.getMessage(),
                    "Une erreur est survenue !", JOptionPane.ERROR_MESSAGE);
        }

        this.createPanel.getForm().reset();

        listAction();

    }
    
    
}
