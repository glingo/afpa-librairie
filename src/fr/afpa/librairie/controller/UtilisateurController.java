package fr.afpa.librairie.controller;

import fr.afpa.librairie.data.bean.Utilisateur;
import fr.afpa.librairie.model.list.ListAdapterListModel;
import fr.afpa.librairie.view.MainFrame;
import fr.afpa.librairie.view.admin.CreateUtilisateurPanel;
import fr.afpa.librairie.view.admin.UtilisateurAdminPanel;
import java.awt.event.ActionEvent;
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
        JTextField fieldMdp = this.createPanel.getForm().getField("Prenom");
        
        
        if(!fieldNom.getInputVerifier().verify(fieldNom)) {
            return;
        }
        
        fieldPrenom.requestFocus();
        
        String nom = fieldNom.getText();
        String prenom = fieldPrenom.getText();
        
        this.createPanel.getForm().reset();
        
        fieldNom.setText("");
        fieldPrenom.setText("");
        
        Utilisateur utilisateur = new Utilisateur();
        
        utilisateur.setNom(nom);
        utilisateur.setPrenom(prenom);
        
        getDaoFactory().getUtilisateurDAO().save(utilisateur);
    
        listAction();
    }
    
}
