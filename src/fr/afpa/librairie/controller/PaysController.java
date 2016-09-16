package fr.afpa.librairie.controller;

import fr.afpa.librairie.data.bean.Pays;
import fr.afpa.librairie.data.exception.DAOException;
import fr.afpa.librairie.model.list.ListAdapterListModel;
import fr.afpa.librairie.view.MainFrame;
import fr.afpa.librairie.view.pays.PaysAdminPanel;
import fr.afpa.librairie.view.pays.PaysEditorPanel;
import java.util.logging.Logger;

public class PaysController extends CRUDController<Pays> {
    
    private static final Logger LOG = Logger.getLogger(PaysController.class.getName());

    public PaysController(MainFrame frame) {
        super(frame);
        setAdminPanel(new PaysAdminPanel(this));
        setEditorPanel(new PaysEditorPanel(this));
    }

    @Override
    public Pays newBean() {
        return new Pays();
    }

    @Override
    protected ListAdapterListModel<Pays> getAll() {
        ListAdapterListModel<Pays> listModel = new ListAdapterListModel<>();
        listModel.addAll(getDaoFactory().getPaysDAO().findAll());
        return listModel;
    }

    @Override
    public PaysEditorPanel getEditorPanel() {
        return (PaysEditorPanel) super.getEditorPanel();
    }
    
    @Override
    protected void loadEditorPanel() {
        // nothing to do.
    }

    @Override
    public boolean create(Pays value) {
          
        try {
            getDaoFactory().getPaysDAO().save(value);
            alert("Information", "Le pays a bien été sauvegardée !");
            return true;
        } catch (DAOException ex) {
            LOG.severe(ex.getMessage());
            danger("Impossible de sauvegarder ce pays.");
        }
        
        return false;
    }

    @Override
    public void viewAction(Pays value) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deleteAction(Pays value) {
        if(value == null) {
            // impossible de supprimer si l'utilisateur n'a rien selectionné.
            return;
        }
        
        try{
            
            getDaoFactory().getPaysDAO().delete(value);
            
        } catch(DAOException ex){
            LOG.severe(ex.getMessage());
            danger("Impossible de supprimer ce pays.");
            return;
        }
        
        listAction();
        alert("Information", "Le pays a bien été supprimée !");
    }
    
}
