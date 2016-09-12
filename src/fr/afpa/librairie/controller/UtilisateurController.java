package fr.afpa.librairie.controller;

import fr.afpa.librairie.data.bean.Utilisateur;
import fr.afpa.librairie.data.exception.DAOException;
import fr.afpa.librairie.model.list.ListAdapterListModel;
import fr.afpa.librairie.view.MainFrame;
import fr.afpa.librairie.view.admin.CreateUtilisateurPanel;
import fr.afpa.librairie.view.admin.DeleteUtilisateurPanel;
import fr.afpa.librairie.view.admin.UtilisateurAdminPanel;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class UtilisateurController extends Controller {

//    private final ListAdapterListModel<Utilisateur> utilisateurListModel = new ListAdapterListModel<>();
    private final UtilisateurAdminPanel adminPanel = new UtilisateurAdminPanel(this);
    private final CreateUtilisateurPanel createPanel = new CreateUtilisateurPanel(this);
    private final DeleteUtilisateurPanel deletePanel = new DeleteUtilisateurPanel(this);

    public UtilisateurController(MainFrame frame) {
        super(frame);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
//        super.actionPerformed(e);

        switch (e.getActionCommand()) {

            case "list":
                listAction();
                break;

            case "create":
            case "save":
                createAction();
                break;
            case "delete":
                deleteAction();
                break;

            default:
                if (this.frame.getContent() == null || !this.adminPanel.equals(this.frame.getContent())) {
                    listAction();
                }
        }
    }

    public void listAction() {
        ListAdapterListModel<Utilisateur> utilisateurListModel = new ListAdapterListModel<>();
        utilisateurListModel.addAll(getDaoFactory().getUtilisateurDAO().findAll());
        adminPanel.setUtilisateurList(utilisateurListModel);
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
        JTextField fieldMail = this.createPanel.getForm().getField("mail");
        JTextField fieldMdp = this.createPanel.getForm().getField("Mot de passe");
        JFormattedTextField fieldDate = this.createPanel.getForm().getField("Date de naissance");

        String nom = fieldNom.getText();
        String prenom = fieldPrenom.getText();
        String mail = fieldMail.getText();
        String mdp = fieldMdp.getText();
        Date date = (Date) fieldDate.getValue();

        Utilisateur utilisateur = new Utilisateur();

        utilisateur.setNom(nom);
        utilisateur.setPrenom(prenom);
        utilisateur.setEmail(mail);
        utilisateur.setMotDePasse(mdp);
        utilisateur.setDateNaissance(new java.sql.Date(date.getTime()));

        try {
            getDaoFactory().getUtilisateurDAO().save(utilisateur);
        } catch (DAOException ex) {
            JOptionPane.showMessageDialog(this.frame, ex.getMessage(),
                    "Une erreur est survenue !", JOptionPane.ERROR_MESSAGE);
        }

        this.createPanel.getForm().reset();

        listAction();
    }

    public void deleteAction() {
        if (!this.deletePanel.equals(this.frame.getContent())) {
            this.frame.setContent(deletePanel);
            return;
        }

        this.deletePanel.getForm().verify();
        
//        JFormattedTextField fieldPrixHt = new JFormattedTextField(NumberFormat.getIntegerInstance());
//        //controle du format du champs PrixHt
//        fieldPrixHt = this.createPanel.getForm().getField("PrixHt");
        
        JFormattedTextField fieldIdUser = new JFormattedTextField();
        fieldIdUser = this.deletePanel.getForm().getField("IdUtilisateur");

//        JFormattedTextField fieldIdUser = this.deletePanel.getForm().getField("IdUtilisateur");
        
        Long idUtilisateur = (Long) fieldIdUser.getValue();

        Utilisateur user = new Utilisateur();
        user.setId(idUtilisateur);

        List<Utilisateur> users = new ArrayList<>();
        
        int len = users.size();
        
        for (int i = 0; i < len; i++) {
            if (idUtilisateur.equals(i)) {

                try {
                    getDaoFactory().getUtilisateurDAO().delete(user);
                } catch (DAOException ex) {
                    JOptionPane.showMessageDialog(this.frame, ex.getMessage(),
                            "Une erreur est survenue !", JOptionPane.ERROR_MESSAGE);
                }
            }

        }

//        try {
//            getDaoFactory().getUtilisateurDAO().delete(user);
//        } catch (DAOException ex) {
//            JOptionPane.showMessageDialog(this.frame, ex.getMessage(),
//                    "Une erreur est survenue !", JOptionPane.ERROR_MESSAGE);
//        }

        this.deletePanel.getForm().reset();

        listAction();
    }
}
