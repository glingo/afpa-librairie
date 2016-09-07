
package fr.afpa.librairie.controller;

import fr.afpa.librairie.data.bean.Ouvrage;
import fr.afpa.librairie.data.exception.DAOException;
import fr.afpa.librairie.model.list.ListAdapterListModel;
import fr.afpa.librairie.view.MainFrame;
import fr.afpa.librairie.view.admin.CreateOuvragePanel;
import fr.afpa.librairie.view.admin.OuvrageAdminPanel;
import java.awt.event.ActionEvent;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class OuvrageController extends Controller {
    
    private final OuvrageAdminPanel adminPanel = new OuvrageAdminPanel(this);
    private final CreateOuvragePanel createPanel = new CreateOuvragePanel(this);
    
    public OuvrageController(MainFrame frame) {
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
        ListAdapterListModel<Ouvrage> ouvrageListModel = new ListAdapterListModel<>();
        ouvrageListModel.addAll(getDaoFactory().getOuvrageDAO().findAll());
        adminPanel.setOuvrageList(ouvrageListModel);
        this.frame.setContent(adminPanel);
    }
    
    public void createAction() {
        
        if(!this.createPanel.equals(this.frame.getContent())) {
            this.frame.setContent(createPanel);
            return;
        }
        
        this.createPanel.getForm().verify();
        
        JTextField fieldTitre = this.createPanel.getForm().getField("Titre");
        JTextField fieldSousTitre = this.createPanel.getForm().getField("Sous-Titre");
        JTextField fieldResume = this.createPanel.getForm().getField("Résumé");
 
        
        String titre = fieldTitre.getText();
        String sousTitre = fieldSousTitre.getText();
        String resume = fieldResume.getText();

        
        Ouvrage ouvrage = new Ouvrage();
        
        
        ouvrage.setTitre(titre);
        ouvrage.setSousTitre(sousTitre);
        ouvrage.setResume(resume);

        
        try{
            getDaoFactory().getOuvrageDAO().save(ouvrage);
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
        String value = OuvrageController.encode("Bonjour");
        
        System.out.println(value);
    }
    
}