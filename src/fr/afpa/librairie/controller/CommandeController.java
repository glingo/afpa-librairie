
package fr.afpa.librairie.controller;

import fr.afpa.librairie.data.bean.Commande;
import fr.afpa.librairie.data.exception.DAOException;
import fr.afpa.librairie.model.list.ListAdapterListModel;
import fr.afpa.librairie.view.MainFrame;
import fr.afpa.librairie.view.commande.CommandeAdminPanel;
import fr.afpa.librairie.view.commande.CommandeEditorPanel;
import java.util.logging.Logger;


public class CommandeController extends CRUDController<Commande> {
    
    
    private static final Logger LOG = Logger.getLogger(CommandeController.class.getName());
     
    public CommandeController(MainFrame frame) {
        super(frame);
        setAdminPanel(new CommandeAdminPanel(this));
        setEditorPanel(new CommandeEditorPanel(this));
    }
    
    @Override
    public void listAction() {
        ListAdapterListModel<Commande> commandeListModel = new ListAdapterListModel<>();
        commandeListModel.addAll(getDaoFactory().getCommandeDAO().findAll());
        getAdminPanel().setList(commandeListModel);
        getFrame().setContent(getAdminPanel());
    }
    
    @Override
    public void createAction() {
        
        if(!getEditorPanel().equals(getFrame().getContent())) {
            getEditorPanel().setBean(new Commande());
            getFrame().setContent(getEditorPanel());
            return;
        }
        /*
        this.createPanel.getForm().verify();
        
        JTextField fieldNumero = this.createPanel.getForm().getField("Numero");
        JFormattedTextField fieldDateCommande = this.createPanel.getForm().getField("Date de commande");
        
        String numero = fieldNumero.getText();
        Date dateCommande = (Date) fieldDateCommande.getValue();
        
        Commande commande = new Commande();

        commande.setNumero(numero);
        commande.setDateCommande(new java.sql.Date(dateCommande.getTime()));
        */
        
        Commande commande = getEditorPanel().constructBean();
        
        try{
            getDaoFactory().getCommandeDAO().save(commande);
        } catch(DAOException ex){
            LOG.severe(ex.getMessage());
            danger("Une erreur est survenue !", " Impossible de sauvegarder cette commande");
            
            return;
        }
        
//        this.createPanel.getForm().reset();
        
        listAction();
        getEditorPanel().reset();
        alert("Information", "La commande a bien été sauvegardée !");
        
    }
    
    public void deactivateAction(Commande commande){
        
         if(commande == null) {
            return;
        }

        try{
            getDaoFactory().getCommandeDAO().delete(commande);
            
        } catch(DAOException ex){
            LOG.severe(ex.getMessage());
            danger("Une erreur est survenue !", "Impossible de désactiver cette commande");
            
            return;
        }
        
        alert("Information", "La commande a bien été désactivée !");
        listAction();
        
    
    }

    @Override
    public void viewAction(Commande value) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deleteAction(Commande value) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
