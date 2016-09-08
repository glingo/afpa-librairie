
package fr.afpa.librairie.controller;

import fr.afpa.librairie.data.bean.Commande;
import fr.afpa.librairie.data.exception.DAOException;
import fr.afpa.librairie.model.list.ListAdapterListModel;
import fr.afpa.librairie.view.MainFrame;
import fr.afpa.librairie.view.admin.CommandeAdminPanel;
import fr.afpa.librairie.view.admin.CreateCommandePanel;
import java.awt.event.ActionEvent;
import java.sql.Date;
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import javax.swing.JTextField;


public class CommandeController extends Controller {
     
    private final CommandeAdminPanel adminPanel = new CommandeAdminPanel(this);
    private final CreateCommandePanel createPanel = new CreateCommandePanel(this);
    
    public CommandeController(MainFrame frame) {
        super(frame);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        super.actionPerformed(e);
        
        switch(e.getActionCommand()) {
            
            case "list":
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
        ListAdapterListModel<Commande> commandeListModel = new ListAdapterListModel<>();
        commandeListModel.addAll(getDaoFactory().getCommandeDAO().findAll());
        adminPanel.setCommandeList(commandeListModel);
        this.frame.setContent(adminPanel);
    }
    
    public void createAction() {
        
        if(!this.createPanel.equals(this.frame.getContent())) {
            this.frame.setContent(createPanel);
            return;
        }
        
        this.createPanel.getForm().verify();
        
        JTextField fieldNumero = this.createPanel.getForm().getField("Numero");
        JFormattedTextField fieldDateCommande = this.createPanel.getForm().getField("Date de commande");
        
        String numero = fieldNumero.getText();
        Date dateCommande = (Date) fieldDateCommande.getValue();
        
        Commande commande = new Commande();

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
}
