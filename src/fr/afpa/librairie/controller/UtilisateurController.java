package fr.afpa.librairie.controller;

import fr.afpa.librairie.data.bean.Utilisateur;
import fr.afpa.librairie.data.exception.DAOException;
import fr.afpa.librairie.model.list.ListAdapterListModel;
import fr.afpa.librairie.view.MainFrame;
import fr.afpa.librairie.view.admin.CreateUtilisateurPanel;
import fr.afpa.librairie.view.admin.UtilisateurAdminPanel;
import java.awt.event.ActionEvent;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Date;
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class UtilisateurController extends Controller {
    
//    private final ListAdapterListModel<Utilisateur> utilisateurListModel = new ListAdapterListModel<>();
    
    private final UtilisateurAdminPanel adminPanel = new UtilisateurAdminPanel(this);
    private final CreateUtilisateurPanel createPanel = new CreateUtilisateurPanel(this);
    
    public UtilisateurController(MainFrame frame) {
        super(frame);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        super.actionPerformed(e);
        
        switch(e.getActionCommand()) {
            
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
                if(this.frame.getContent() == null || !this.adminPanel.equals(this.frame.getContent())) {
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
        
        if(!this.createPanel.equals(this.frame.getContent())) {
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
        
        try{
            getDaoFactory().getUtilisateurDAO().save(utilisateur);
        } catch(DAOException ex){
            JOptionPane.showMessageDialog(this.frame, ex.getMessage(),
                    "Une erreur est survenue !", JOptionPane.ERROR_MESSAGE);
        }
        
        this.createPanel.getForm().reset();
    
        listAction();
    }
    
    public static String encode(String password) {
        byte[] uniqueKey = password.getBytes();
        byte[] hash      = null;

        try {
            hash = MessageDigest.getInstance("MD5").digest(uniqueKey);
        } catch (NoSuchAlgorithmException e) {
            throw new Error("No MD5 support in this VM.");
        }

        StringBuilder hashString = new StringBuilder();
        for (int i = 0; i < hash.length; i++) {
            String hex = Integer.toHexString(hash[i]);
            if (hex.length() == 1) {
                hashString.append('0');
                hashString.append(hex.charAt(hex.length() - 1));
            } else {
                hashString.append(hex.substring(hex.length() - 2));
            }
        }
        return hashString.toString();
    }
    
    
    public static void main(String[] args) {
        String value = UtilisateurController.encode("Bonjour");
        
        System.out.println(value);
    }
    
}
