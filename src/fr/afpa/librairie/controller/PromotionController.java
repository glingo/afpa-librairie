
package fr.afpa.librairie.controller;

import fr.afpa.librairie.data.bean.Promotion;
import fr.afpa.librairie.model.list.ListAdapterListModel;
import fr.afpa.librairie.view.MainFrame;
import java.awt.event.ActionEvent;
import java.sql.Date;
import javax.swing.JFormattedTextField;
import javax.swing.JTextField;

public class PromotionController extends Controller {
    
    private final CommandeAdminPanel adminPanel = new CommandeAdminPanel(this);
    private final CreateCommandePanel createPanel = new CreateCommandePanel(this);
    
    public PromotionController(MainFrame frame) {
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
        ListAdapterListModel<Promotion> promotionListModel = new ListAdapterListModel<>();
        promotionListModel.addAll(getDaoFactory().getPromotionDAO().findAll());
        adminPanel.setCommandeList(promotionListModel);
        this.frame.setContent(adminPanel);
    }
    
    public void createAction() {
        
        if(!this.createPanel.equals(this.frame.getContent())) {
            this.frame.setContent(createPanel);
            return;
        }
        
        this.createPanel.getForm().verify();
        
        JFormattedTextField fieldDateDebut = this.createPanel.getForm().getField("Date de début");
        JFormattedTextField fieldDateFin = this.createPanel.getForm().getField("Date de fin");
        JTextField fieldReduction = this.createPanel.getForm().getField("Réduction");
        JTextField fieldImage = this.createPanel.getForm().getField("Image");
        JTextField fieldDescription = this.createPanel.getForm().getField("Description");
        JTextField fieldCommentaire = this.createPanel.getForm().getField("Commentaire");
        
        
        
        Date dateDebut = (Date) fieldDateDebut.getValue();
        Date dateFin = (Date) fieldDateFin.getValue();
        String reduction = fieldReduction.getText();
        String image = fieldImage.getText();
        String description = fieldDescription.getText();
        String commentaire = fieldCommentaire.getText();
        
        
        Promotion promotion = new Promotion();
        //**********************************REPRISE ICI********************************

        commande.setNumero(numero);
        commande.setDateCommande(new java.sql.Date(dateCommande.getTime()));

        
        try{
            getDaoFactory().getCommandeDAO().save(commande);
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
        String value = CommandeController.encode("Bonjour");
        
        System.out.println(value);
    }
}
