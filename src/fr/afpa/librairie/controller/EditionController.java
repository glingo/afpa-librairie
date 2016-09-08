
package fr.afpa.librairie.controller;

import fr.afpa.librairie.data.bean.Edition;
import fr.afpa.librairie.data.exception.DAOException;
import fr.afpa.librairie.model.list.ListAdapterListModel;
import fr.afpa.librairie.view.MainFrame;
import fr.afpa.librairie.view.admin.CreateEditionPanel;
import fr.afpa.librairie.view.admin.EditionAdminPanel;
import java.awt.event.ActionEvent;
import java.sql.Date;
import java.text.NumberFormat;
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class EditionController extends Controller {
    
    
    private final EditionAdminPanel adminPanel = new EditionAdminPanel(this);
    private final CreateEditionPanel createPanel = new CreateEditionPanel(this);
    //appel methode EditionAdminPanel et CreateEditionPanel present dans librairie/view/admin
    
    
    //contructeur du controller
    private EditionController(MainFrame frame){
        super(frame);
    }
    
    
    //methode actionPerformed : en fonction de ce que fait l'utilisateur ==> le controller effectuera une action particuliere.
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
    //quand User = list ==> controller = listAction
    public void listAction() {
        ListAdapterListModel<Edition> editionListModel = new ListAdapterListModel<>();
        //appel la listModel de edition
        editionListModel.addAll(getDaoFactory().getEditionDAO().findAll());
        //appel DAO Edition ( requetes SQL ) chemin : librairie/data/DAO
        adminPanel.setEditionList(editionListModel);
        //appel du panel que l'on a crée pour Edition. ( pannel principal)
        this.frame.setContent(adminPanel);
        //rajoute a la frame le panelAdmin 
        
        //donc = quand on utilise "list" le controller utilise la methode listAction qui demande
        // à la vue de se rafraichir et d'afficher le EditionAdminPanel. 
    }
    //Si User = "save" alors EditionController ==> createAction
    public void createAction() {
        
        if(!this.createPanel.equals(this.frame.getContent())) {
            this.frame.setContent(createPanel);
            return;
            //si le panel de création d'une edition n'existe pas = on le crée. 
        }
        
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
 
        try{
            getDaoFactory().getEditionDAO().save(edition);
            //appel de la methode EditionDAO. mais surtout appel de la requete SQL save contenu dans EditionDAO.afin de créer une nouvelle edition. 
        } catch(DAOException ex){
            JOptionPane.showMessageDialog(this.frame, ex.getMessage(),
                    "Une erreur est survenue !", JOptionPane.ERROR_MESSAGE);
        }
        
        this.createPanel.getForm().reset();
    
        listAction();
        //retour au EditionAdminPanel
    }
    
    
}
