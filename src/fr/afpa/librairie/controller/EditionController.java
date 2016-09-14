package fr.afpa.librairie.controller;

import fr.afpa.librairie.data.bean.Edition;
import fr.afpa.librairie.data.exception.DAOException;
import fr.afpa.librairie.model.list.ListAdapterListModel;
import fr.afpa.librairie.view.MainFrame;
import fr.afpa.librairie.view.edition.EditionAdminPanel;
import fr.afpa.librairie.view.editeur.EditeurAdminPanel;
import fr.afpa.librairie.view.editeur.EditeurEditorPanel;
import fr.afpa.librairie.view.edition.EditionEditorPanel;
import java.util.logging.Logger;

public class EditionController extends ActivableCRUDController<Edition> {

    private static final Logger LOG = Logger.getLogger(EditionController.class.getName());

    //contructeur du controller
    public EditionController(MainFrame frame) {
        super(frame);
        setAdminPanel(new EditionAdminPanel(this));
        setEditorPanel(new EditionEditorPanel(this));
    }

    //quand User = list ==> controller = listAction
    public void listAction() {
        ListAdapterListModel<Edition> editionListModel = new ListAdapterListModel<>();
        //appel la listModel de edition
        editionListModel.addAll(getDaoFactory().getEditionDAO().findAll());
        //appel DAO Edition ( requetes SQL ) chemin : librairie/data/DAO
        getAdminPanel().setList(editionListModel);
        //appel du panel que l'on a crée pour Edition. ( pannel principal)
        getFrame().setContent(getAdminPanel());
        //rajoute a la frame le panelAdmin 

        //donc = quand on utilise "list" le controller utilise la methode listAction qui demande
        // à la vue de se rafraichir et d'afficher le EditionAdminPanel. 
    }

    //Si User = "save" alors EditionController ==> createAction
    public void createAction() {

        if (!getEditorPanel().equals(getFrame().getContent())) {
            getEditorPanel().setBean(new Edition());
            getFrame().setContent(getEditorPanel());
            return;
            //si le panel de création d'une edition n'existe pas = on le crée. 
        }
/*
        this.createPanel.getForm().verify();
        //
        JTextField fieldIsbn = this.createPanel.getForm().getField("Isbn");
        JFormattedTextField fieldDatePubli = this.createPanel.getForm().getField("Date de publication");
        JFormattedTextField fieldPrixHt = new JFormattedTextField(NumberFormat.getIntegerInstance());
        //controle du format du champs PrixHt
        fieldPrixHt = this.createPanel.getForm().getField("PrixHt");
        JTextField fieldCouverture = this.createPanel.getForm().getField("Image de couverture");
        JTextField fieldTitre = this.createPanel.getForm().getField("Titre");
        JFormattedTextField fieldStock = new JFormattedTextField(NumberFormat.getIntegerInstance());
        fieldStock = this.createPanel.getForm().getField("Stock");

        //recuperation des données que l'utilisateur a mis dans les champs. 
        String isbn = fieldIsbn.getText();
        Date datePubli = (Date) fieldDatePubli.getValue();
        Float prixHt = (Float) fieldPrixHt.getValue();
        String couverture = fieldCouverture.getText();
        String titre = fieldTitre.getText();
        Integer stock = (Integer) fieldStock.getValue();

        Edition edition = new Edition();
        //modification des champs edition.
        edition.setIsbn(isbn);
        edition.setDatePublication(datePubli);
        edition.setPrixHt(prixHt);
        edition.setCouverture(couverture);
        edition.setTitre(titre);
        edition.setStock(stock);
*/
        Edition edition = getEditorPanel().constructBean();
        
        try {
            getDaoFactory().getEditionDAO().save(edition);
            //appel de la methode EditionDAO. mais surtout appel de la requete SQL save contenu dans EditionDAO.afin de créer une nouvelle edition.

        } catch (DAOException ex) {
            LOG.severe(ex.getMessage());
            danger("Une erreur est survenue !", "Impossible de sauvegarder l'édition");

            return;

        }

//        this.createPanel.getForm().reset();

        listAction();
        getEditorPanel().reset();
        alert("Information", "L'édition a bien été sauvegardée !");
        //retour au EditionAdminPanel

    }

    @Override
    public void deactivateAction(Edition edition) {

        if (edition == null) {
            return;
        }
        // on verifier si edition = null. Si l'édition est nulle ( donc pas selectionnée ) alors impossible de supprimer.

        try {
            getDaoFactory().getEditionDAO().delete(edition);

        } catch (DAOException ex) {
            LOG.severe(ex.getMessage());
            danger("Une erreur est survenue !", "Impossible de désactiver l'édition");

            return;

        }

        alert("Information", "L'édition a bien été désactivée !");
        // ajouter un message comme quoi la suppression s'est bien deroulée.
        listAction();

    }
    
    @Override
    public void activateAction(Edition edition){
        
        if(edition == null){
            return;
        }
        
        try{
            getDaoFactory().getEditionDAO().activate(edition);
            
        }catch(DAOException ex){
            LOG.severe(ex.getMessage());
            danger("Une erreur est survenue !", 
                    "Impossible d'activer cette édition.");
            return;
        }
        
        listAction();
        alert("Information", "L'activation a été pris en compte !");
    }

    @Override
    public void viewAction(Edition value) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deleteAction(Edition value) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
