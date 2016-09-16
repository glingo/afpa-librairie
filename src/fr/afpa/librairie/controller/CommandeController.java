
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
    public Commande newBean() {
        return new Commande();
    }

    @Override
    protected ListAdapterListModel<Commande> getAll() {
        ListAdapterListModel<Commande> listModel = new ListAdapterListModel<>();
        listModel.addAll(getDaoFactory().getCommandeDAO().findAll());
        return listModel;
    }

    @Override
    protected void loadEditorPanel() {
        // nothing to do.
    }
    
    @Override
    public boolean create(Commande value) {
       
        try{
            getDaoFactory().getCommandeDAO().save(value);
            alert("Information", "La commande a bien été sauvegardée !");
            return true;
        } catch(DAOException ex){
            LOG.severe(ex.getMessage());
            danger("Une erreur est survenue !", " Impossible de sauvegarder cette commande");
        }
        return false;
        
//        listAction();
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
