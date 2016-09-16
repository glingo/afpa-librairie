package fr.afpa.librairie.controller;

import fr.afpa.librairie.data.bean.Adresse;
import fr.afpa.librairie.data.bean.Pays;
import fr.afpa.librairie.data.exception.DAOException;
import fr.afpa.librairie.model.list.ListAdapterListModel;
import fr.afpa.librairie.view.MainFrame;
import fr.afpa.librairie.view.adresse.AdresseAdminPanel;
import fr.afpa.librairie.view.adresse.AdresseEditorPanel;
import java.util.List;
import java.util.logging.Logger;

public class AdresseController extends CRUDController<Adresse> {
    
    private static final Logger LOG = Logger.getLogger(AdresseController.class.getName());

    public AdresseController(MainFrame frame) {
        super(frame);
        setAdminPanel(new AdresseAdminPanel(this));
        setEditorPanel(new AdresseEditorPanel(this));
    }

    @Override
    public Adresse newBean() {
        return new Adresse();
    }

    @Override
    protected ListAdapterListModel<Adresse> getAll() {
        ListAdapterListModel<Adresse> listModel = new ListAdapterListModel<>();
        listModel.addAll(getDaoFactory().getAdresseDAO().findAll());
        return listModel;
    }

    @Override
    public AdresseEditorPanel getEditorPanel() {
        return (AdresseEditorPanel) super.getEditorPanel();
    }
    
    @Override
    protected void loadEditorPanel() {
        // set la list de statut.
        
        // set la list des pays.
        List<Pays> pays = getDaoFactory().getPaysDAO().findAll();
        getEditorPanel().setPays(pays);
    }

    @Override
    public void create(Adresse value) {
        
        try {
            getDaoFactory().getAdresseDAO().save(value);
            alert("Information", "L'adresse a bien été sauvegardée !");
        } catch (DAOException ex) {
            LOG.severe(ex.getMessage());
            danger("Une erreur est survenue !", 
                    "Impossible de sauvegarder cette adresse.");
        }
        
//        listAction();
    }

    @Override
    public void viewAction(Adresse value) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deleteAction(Adresse value) {
        if(value == null) {
            // impossible de supprimer si l'utilisateur n'a rien selectionné.
            return;
        }
        
        try{
            
            getDaoFactory().getAdresseDAO().delete(value);
            
        } catch(DAOException ex){
            LOG.severe(ex.getMessage());
            danger("Une erreur est survenue !", 
                    "Impossible de supprimer cette adresse.");
            return;
        }
        
        listAction();
        alert("Information", "L'adresse a bien été supprimée !");
    }
    
}
