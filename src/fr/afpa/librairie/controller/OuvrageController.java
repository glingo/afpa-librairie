
package fr.afpa.librairie.controller;

import fr.afpa.librairie.data.bean.Auteur;
import fr.afpa.librairie.data.bean.Genre;
import fr.afpa.librairie.data.bean.Ouvrage;
import fr.afpa.librairie.data.bean.Rubrique;
import fr.afpa.librairie.data.bean.Theme;
import fr.afpa.librairie.data.exception.DAOException;
import fr.afpa.librairie.model.list.ListAdapterListModel;
import fr.afpa.librairie.view.MainFrame;
import fr.afpa.librairie.view.ouvrage.OuvrageAdminPanel;
import fr.afpa.librairie.view.ouvrage.OuvrageEditorPanel;
import java.util.List;
import java.util.logging.Logger;

public class OuvrageController extends CRUDController<Ouvrage> {
    
    private static final Logger LOG = Logger.getLogger(OuvrageController.class.getName());

    public OuvrageController(MainFrame frame) {
        super(frame);
        setAdminPanel(new OuvrageAdminPanel(this));
        setEditorPanel(new OuvrageEditorPanel(this));
    }

    @Override
    public Ouvrage newBean() {
        return new Ouvrage();
    }

    @Override
    protected ListAdapterListModel<Ouvrage> getAll() {
        ListAdapterListModel<Ouvrage> listModel = new ListAdapterListModel<>();
        listModel.addAll(getDaoFactory().getOuvrageDAO().findAll());
        return listModel;
    }

    @Override
    public OuvrageEditorPanel getEditorPanel() {
        return (OuvrageEditorPanel) super.getEditorPanel(); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    protected void loadEditorPanel() {
        List<Auteur> auteurs = getDaoFactory().getAuteurDAO().findAll();
        
        // load auteurs
        getEditorPanel().setAuteurModel(auteurs);
        // load coauteurs
        getEditorPanel().setCoAuteurModel(auteurs);
        
        // load genres
        List<Genre> genres = getDaoFactory().getGenreDAO().findAll();
        getEditorPanel().setGenresModel(genres);
        
        // load themes
        List<Theme> themes = getDaoFactory().getThemeDAO().findAll();
        getEditorPanel().setThemesModel(themes);
        
        // load rubriques
        List<Rubrique> rubriques = getDaoFactory().getRubriqueDAO().findAll();
        getEditorPanel().setRubriquesModel(rubriques);
    }
    
    @Override
    public boolean create(Ouvrage value) {
        
        try{
            getDaoFactory().getOuvrageDAO().save(value);
            alert("Information", "L'ouvrage a bien été sauvegardé !");
            return true;
        } catch(DAOException ex){
            LOG.severe(ex.getMessage());
            danger("Une erreur est survenue !", "Impossible de sauvegarder cet ouvrage");
        }
        
        return false;
//        listAction();
    }
    
    @Override
    public void deleteAction(Ouvrage ouvrage){
       if(ouvrage == null) {
            // impossible de supprimer si l'utilisateur n'a rien selectionné.
            return;
        }
        
        // supprimer les references de l'uitlisateur vers roles (Remplit)
        
        try {
            getDaoFactory().getOuvrageDAO().delete(ouvrage);
        } catch(DAOException ex){
            LOG.severe(ex.getMessage());
            danger("Une erreur est survenue !", "Impossible de supprimer cet ouvrage");
            return;
        }
        
        
        adminAction();
        alert("Information", "L'ouvrage a bien été supprimé !");
    }

    @Override
    public void viewAction(Ouvrage value) {
         if(value == null){
            return;
        }
        try{
            getDaoFactory().getOuvrageDAO().viewRubrique(value);
        }catch (DAOException ex){
            LOG.severe(ex.getMessage());
            danger("Une erreur est survenue !",
                    "Impossible de voir quelque chose.");
            return;
        }
        adminAction();
        alert("Information", "La rubrique a bien été supprimée !");
    }
}