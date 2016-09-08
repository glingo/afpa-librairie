
package fr.afpa.librairie.controller;

import fr.afpa.librairie.data.bean.Rubrique;
import fr.afpa.librairie.data.exception.DAOException;
import fr.afpa.librairie.model.list.ListAdapterListModel;
import fr.afpa.librairie.view.MainFrame;
import fr.afpa.librairie.view.admin.CreateRubriquePanel;
import fr.afpa.librairie.view.admin.RubriqueAdminPanel;
import java.awt.event.ActionEvent;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Date;
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class RubriqueController extends Controller {
    
    
    private final RubriqueAdminPanel adminPanel = new RubriqueAdminPanel(this);
    private final CreateRubriquePanel createPanel = new CreateRubriquePanel(this);
    
    public RubriqueController(MainFrame frame) {
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
        
        this.createPanel.getForm().verify();
        
        JTextField fieldLibelle = this.createPanel.getForm().getField("Libelle");
        JFormattedTextField fieldDateDebut = this.createPanel.getForm().getField("Date de début");
        JFormattedTextField fieldDateFin = this.createPanel.getForm().getField("Date de fin");
        JTextField fieldCommentaire = this.createPanel.getForm().getField("Commentaire");
        
        
        String libelle= fieldLibelle.getText();
        Date dateDebut = (Date) fieldDateDebut.getValue();
        Date dateFin = (Date) fieldDateFin.getValue();
        String commentaire = fieldCommentaire.getText();
        
        Rubrique rubrique = new Rubrique();
        
        rubrique.setLibelle(libelle);
        rubrique.setDateDebut(new java.sql.Date(dateDebut.getTime()));
        rubrique.setDateFin(new java.sql.Date(dateFin.getTime()));
        rubrique.setCommentaire(commentaire);

        try{
            getDaoFactory().getRubriqueDAO().save(rubrique);
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
