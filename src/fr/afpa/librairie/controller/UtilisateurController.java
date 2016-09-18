package fr.afpa.librairie.controller;

import fr.afpa.librairie.data.bean.Utilisateur;
import fr.afpa.librairie.data.exception.DAOException;
import fr.afpa.librairie.model.list.ListAdapterListModel;
import fr.afpa.librairie.view.MainFrame;
import fr.afpa.librairie.view.utilisateur.UtilisateurAdminPanel;
import fr.afpa.librairie.view.utilisateur.UtilisateurEditorPanel;
import java.util.logging.Logger;

public class UtilisateurController extends ActivableCRUDController<Utilisateur> {

    private static final Logger LOG = Logger.getLogger(UtilisateurController.class.getName());

    public UtilisateurController(MainFrame frame) {
        super(frame);
        setAdminPanel(new UtilisateurAdminPanel(this));
        setEditorPanel(new UtilisateurEditorPanel(this));
    }

    @Override
    public Utilisateur newBean() {
        return new Utilisateur();
    }

    @Override
    protected ListAdapterListModel<Utilisateur> getAll() {
        ListAdapterListModel<Utilisateur> listModel = new ListAdapterListModel<>();
        listModel.addAll(getDaoFactory().getUtilisateurDAO().findAll());
        return listModel;
    }
    
    @Override
    protected void loadEditorPanel() {
        // load list of role.
    }
    
    @Override
    public boolean create(Utilisateur value) {

        try {
            getDaoFactory().getUtilisateurDAO().save(value);
            alert("Information", "L'utilisateur a bien été sauvegardé !");
            return true;
        } catch (DAOException ex) {
            LOG.severe(ex.getMessage());
            danger("Une erreur est survenue !",
                    "Impossible de sauvegarder cet utilisateur.");
        }

        return false;
//        listAction();
    }

    @Override
    public void deactivateAction(Utilisateur utilisateur) {

        if (utilisateur == null) {
            // impossible de supprimer si l'utilisateur n'a rien selectionné.
            return;
        }

        // supprimer les references de l'uitlisateur vers roles (Remplit)
        try {
            getDaoFactory().getUtilisateurDAO().delete(utilisateur);

        } catch (DAOException ex) {
            LOG.severe(ex.getMessage());
            danger("Une erreur est survenue !",
                    "Impossible de desactiver cet utilisateur.");
            return;
        }

        adminAction();
        // ajouter un message comme quoi la suppression s'est bien deroulée.
        alert("Information", "L'utilisateur a bien été désactivé !");
    }

    @Override
    public void activateAction(Utilisateur utilisateur) {

        if (utilisateur == null) {
            return;
        }

        try {
            getDaoFactory().getUtilisateurDAO().activate(utilisateur);
        } catch (DAOException ex) {
            LOG.severe(ex.getMessage());
            danger("Une erreur est survenue !",
                    "Impossible d'activer cet utilisateur.");
            return;
        }

        adminAction();
        alert("Information", "L'activation a été prise en compte !");
    }

    @Override
    public void viewAction(Utilisateur utilisateur) {
        // un panel de visualisation.
//        listAction();
    }

//    @Override
//    public void editAction(Utilisateur utilisateur) {
//        if (utilisateur == null) {
//            danger("", "Veuillez selectionner un utilisateur à mettre a jour.");
//            return;
//        }
//
//        getEditorPanel().setBean(utilisateur);
//        getFrame().setContent(getEditorPanel());
//    }

    @Override
    public void deleteAction(Utilisateur value) {
       
    }
}
