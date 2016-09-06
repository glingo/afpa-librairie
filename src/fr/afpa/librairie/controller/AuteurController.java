package fr.afpa.librairie.controller;

import fr.afpa.librairie.data.bean.Auteur;
import fr.afpa.librairie.data.exception.DAOException;
import fr.afpa.librairie.model.list.ListAdapterListModel;
import fr.afpa.librairie.view.MainFrame;
import fr.afpa.librairie.view.admin.AuteurAdminPanel;
import fr.afpa.librairie.view.admin.CreateAuteurPanel;
import java.awt.event.ActionEvent;
import java.util.Date;
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class AuteurController extends Controller {

    private final AuteurAdminPanel adminPanel = new AuteurAdminPanel(this);
    private final CreateAuteurPanel createPanel = new CreateAuteurPanel(this);
    //creation auteruadmin

    public AuteurController(MainFrame frame) {
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

        this.createPanel.getForm().verify();

        JTextField fieldNom = this.createPanel.getForm().getField("Nom");
        JTextField fieldPrenom = this.createPanel.getForm().getField("Prenom");
        JFormattedTextField fieldDateNaissance = this.createPanel.getForm().getField("Date de naissance");
        JFormattedTextField fieldDateDeces = this.createPanel.getForm().getField("Date de décès");

        String nom = fieldNom.getText();
        String prenom = fieldPrenom.getText();
        Date dateNaissance = (Date) fieldDateNaissance.getValue();
        Date dateDeces = (Date) fieldDateDeces.getValue();

        Auteur auteur = new Auteur();

        auteur.setNom(nom);
        auteur.setPrenom(prenom);
        auteur.setDateNaissance(new java.sql.Date(dateNaissance.getTime()));
        auteur.setDateDeces(new java.sql.Date(dateDeces.getTime()));

        try {
            getDaoFactory().getAuteurDAO().save(auteur);
        } catch (DAOException ex) {
            JOptionPane.showMessageDialog(this.frame, ex.getMessage(),
                    "Une erreur est survenue !", JOptionPane.ERROR_MESSAGE);
        }

        this.createPanel.getForm().reset();

        listAction();

    }

}