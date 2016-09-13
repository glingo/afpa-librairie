package fr.afpa.librairie.controller;

import fr.afpa.librairie.data.bean.Utilisateur;
import fr.afpa.librairie.data.exception.DAOException;
import fr.afpa.librairie.model.list.ListAdapterListModel;
import fr.afpa.librairie.view.MainFrame;
import fr.afpa.librairie.view.admin.CreateUtilisateurPanel;
import fr.afpa.librairie.view.admin.UtilisateurAdminPanel;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JFormattedTextField;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class UtilisateurController extends Controller {
    
    private final UtilisateurAdminPanel adminPanel = new UtilisateurAdminPanel(this);
    private final CreateUtilisateurPanel createPanel = new CreateUtilisateurPanel(this);


    
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
                
            case "deactivate":
                deactivateAction(this.adminPanel.getUtilisateurList().getSelectedValue());
                break;
                
//            case "activate":
//                activateAction(this.adminPanel.getUtilisateurList().getSelectedValue());
//                break;
//                
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
        
        if(date != null) {
            utilisateur.setDateNaissance(new java.sql.Date(date.getTime()));
        }
        
        try{
            getDaoFactory().getUtilisateurDAO().save(utilisateur);
        } catch (DAOException ex) {
            JOptionPane.showMessageDialog(this.frame, ex.getMessage(),
                    "Une erreur est survenue !", JOptionPane.ERROR_MESSAGE);
        }

        this.createPanel.getForm().reset();

        listAction();
    }
    
    public void deactivateAction(Utilisateur utilisateur){
        
        if(utilisateur == null) {
            // impossible de supprimer si l'utilisateur n'a rien selectionné.
            return;
        }
        
        // supprimer les references de l'uitlisateur vers roles (Remplit)
        
        try {
            getDaoFactory().getUtilisateurDAO().delete(utilisateur);
            JOptionPane deactiUser = new JOptionPane();
            deactiUser.showMessageDialog(null, "La désactivation a bien été effectué !", "Information", JOptionPane.INFORMATION_MESSAGE);

            
        } catch(DAOException ex){
            JOptionPane.showMessageDialog(this.frame, ex.getMessage(),
                    "Une erreur est survenue !", JOptionPane.ERROR_MESSAGE);
        }
        
        // ajouter un message comme quoi la suppression s'est bien deroulée.
    
        listAction();
    }
    
//    public void activateAction(Utilisateur utilisateur){
//        
//        if(utilisateur == null){
//            return;
//        }
//        try{
//            getDaoFactory().getUtilisateurDAO().activate(utilisateur);
//            JOptionPane actiUser = new JOptionPane();
//            actiUser.showMessageDialog(null, "L'activation a été pris en compte !", "Information", JOptionPane.INFORMATION_MESSAGE);
//            
//        }catch(DAOException ex){
//            JOptionPane.showMessageDialog(this.frame, ex.getMessage(),
//                    "Une erreur est survenue !TATAAA", JOptionPane.ERROR_MESSAGE);
//        }
//        
//        listAction();
//    }
    public void viewAction(Utilisateur utilisateur){
        // un panel de visualisation.
//        listAction();
    }
}
