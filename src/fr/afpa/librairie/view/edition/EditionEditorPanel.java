package fr.afpa.librairie.view.edition;

import fr.afpa.librairie.controller.CRUDController;
import fr.afpa.librairie.data.bean.Auteur;
import fr.afpa.librairie.data.bean.Edition;
import fr.afpa.librairie.data.bean.Genre;
import fr.afpa.librairie.data.bean.Langue;
import fr.afpa.librairie.data.bean.Rubrique;
import fr.afpa.librairie.data.bean.Taxe;
import fr.afpa.librairie.data.bean.Theme;
import fr.afpa.librairie.model.list.ListAdapterListModel;
import fr.afpa.librairie.model.list.renderer.AuteurListCellRenderer;
import fr.afpa.librairie.model.list.renderer.LangueListCellRenderer;
import fr.afpa.librairie.model.list.renderer.GenreListCellRenderer;
import fr.afpa.librairie.model.list.renderer.ThemeListCellRenderer;
import fr.afpa.librairie.model.list.renderer.RubriqueListCellRenderer;
import fr.afpa.librairie.model.list.renderer.TaxeListCellRenderer;
import fr.afpa.librairie.model.verifier.StrictInputVerifier;
import fr.afpa.librairie.view.field.JDateField;
import fr.afpa.librairie.view.field.JFloatField;
import fr.afpa.librairie.view.field.JIntegerField;
import fr.afpa.librairie.view.panel.EditorPanel;
import java.awt.Dimension;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.ListSelectionModel;

public class EditionEditorPanel extends EditorPanel<Edition> {
    
    
    private DefaultComboBoxModel<Langue> langueComboModel;
    private DefaultComboBoxModel<Taxe> taxeComboModel;

 
    private JLabel isbnLB;
    private JLabel datePublicationLB;
    private JLabel langueLB;
    private JLabel prixHtLB;
    private JLabel imageLB;
    private JLabel titreLB;
    private JLabel taxeLB;
    private JLabel stockLB;
 
    
    private JTextField isbn;
    private JDateField datePublication;
    private JComboBox<Langue> langue;
    private JFloatField prixHt;
    private JTextField image;
    private JTextField titre;
    private JComboBox<Taxe> taxe;
    private JIntegerField stock;
    
    
    


    public EditionEditorPanel(CRUDController<Edition> controller) {
        super(controller);
    }

    @Override
    protected void initBody(JPanel body) {
        
     
        
        isbn = new JTextField(15);
        isbn.setInputVerifier(new StrictInputVerifier());
       

        datePublication = new JDateField(true);
        
        langue = new JComboBox<>();
        langue.setRenderer(new LangueListCellRenderer());
        
    
        prixHt = new JFloatField(true);

        image = new JTextField(15);
        image.setInputVerifier(new StrictInputVerifier());

        titre = new JTextField(15);
        titre.setInputVerifier(new StrictInputVerifier());
        
        taxe = new JComboBox<>();
        taxe.setRenderer(new TaxeListCellRenderer());
        
        stock = new JIntegerField(true);
        //pas besoin de mettre la ligne au dessous parce qu'elle est deja presente dans la methode JIntegerField.
        //stock.setInputVerifier(new StrictInputVerifier());
 


        isbnLB                      = new JLabel("Isbn :");
 
        datePublicationLB           = new JLabel("Date de publication :");
        
        langueLB                    = new JLabel("Langue :");
        
  
        prixHtLB                    = new JLabel("Prix HT :");
        
        imageLB                     = new JLabel("Couverture :");
        
        titreLB                     = new JLabel("Titre :");
        
        taxeLB                      = new JLabel("Taxe :");
        
        stockLB                     = new JLabel("Stock :");

  
        isbnLB.setLabelFor(isbn);

        datePublicationLB.setLabelFor(datePublication);
        langueLB.setLabelFor(langue);

        prixHtLB.setLabelFor(prixHt);
        imageLB.setLabelFor(image);
        titreLB.setLabelFor(titre);
        taxeLB.setLabelFor(taxe);
        stockLB.setLabelFor(stock);
   
        
        
       GroupLayout bodyPanelLayout = new GroupLayout(body);
        body.setLayout(bodyPanelLayout);

        bodyPanelLayout.setHorizontalGroup(
            bodyPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(bodyPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(bodyPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(GroupLayout.Alignment.TRAILING, bodyPanelLayout.createSequentialGroup()
                        .addGroup(bodyPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addGroup(bodyPanelLayout.createSequentialGroup()
                                .addGroup(bodyPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                    .addComponent(isbnLB, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)   
                                    .addComponent(datePublicationLB, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(langueLB, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(prixHtLB, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(imageLB, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(titreLB, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(taxeLB, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(stockLB, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(13, 13, 13)
                                .addGroup(bodyPanelLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                    .addComponent(isbn, GroupLayout.Alignment.LEADING)
                                    .addComponent(datePublication, GroupLayout.Alignment.LEADING)
                                    .addComponent(langue, GroupLayout.Alignment.LEADING)
                                    .addComponent(prixHt, GroupLayout.Alignment.LEADING)
                                    .addComponent(image, GroupLayout.Alignment.LEADING)
                                    .addComponent(titre, GroupLayout.Alignment.LEADING)
                                    .addComponent(taxe, GroupLayout.Alignment.LEADING)
                                    .addComponent(stock, GroupLayout.Alignment.LEADING))))
                        .addGap(6, 6, 6))))
        );

        bodyPanelLayout.setVerticalGroup(
            bodyPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(bodyPanelLayout.createSequentialGroup()
                .addGroup(bodyPanelLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                    .addComponent(isbnLB)
                    .addComponent(isbn, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(bodyPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(datePublication, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(datePublicationLB))
                .addGroup(bodyPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(langue, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(langueLB))
                .addGroup(bodyPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(prixHt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(prixHtLB))
                .addGroup(bodyPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(image, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(imageLB))
                .addGroup(bodyPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(titre, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(titreLB))
                .addGroup(bodyPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(taxe, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(taxeLB))
                .addGroup(bodyPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(stock, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(stockLB))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED))
        );
        
    }   
    
    
        @Override
    protected String getTitleText() {
        Edition edition = getBean();
        
        return edition.getIsbn() != null 
                ? "Edition (isbn) : " + edition.getIsbn() 
                : "Nouvelle Edition";
    }
    
    
    @Override
    public void bindValues() {
        Edition edition = getBean();

        
        isbn.setText(edition.getIsbn());
        datePublication.setValue(edition.getDatePublication());
        prixHt.setValue(edition.getPrixHt());
        image.setText(edition.getCouverture());
        titre.setText(edition.getTitre());
        stock.setValue(edition.getStock());
        
        if(edition.getLangue() != null){
            this.langue.setSelectedItem(edition.getLangue());
        }
        
        if(edition.getTaxes() != null){
            this.taxe.setSelectedItem(edition.getTaxes());
        }

  
    }


    @Override
    public Edition constructBean() {
        Edition edition = getBean();
        
        edition.setIsbn(isbn.getText());
        
        if(datePublication.getValue() != null) {
            edition.setDatePublication(new java.sql.Date(datePublication.getValue().getTime()));
        }

        
        edition.setPrixHt((Float) prixHt.getValue());
        edition.setCouverture(image.getText());
        edition.setTitre(titre.getText());
        edition.setStock((Integer) stock.getValue());
        edition.setLangue((Langue) langue.getSelectedItem());
        edition.setTaxes((List<Taxe>) (Taxe) taxe.getSelectedItem());
        
        
        
 
        return edition;
    }
    
    
     @Override
    public void reset() {
  
        isbn.setText("");

        datePublication.setValue(null);
        langue.setSelectedItem("");

        prixHt.setValue(null);
        image.setText("");
        titre.setText("");
        taxe.setSelectedItem("");
        stock.setValue(null);
    }
    
    
    public void setLangueModel(List<Langue> list){
        this.langueComboModel = new DefaultComboBoxModel(list.toArray());
        this.langueComboModel.setSelectedItem(null);
        this.langue.setModel(this.langueComboModel);
    }
    
    
    public void setTaxeModel(List<Taxe> list){
        this.taxeComboModel = new DefaultComboBoxModel(list.toArray());
        this.taxeComboModel.setSelectedItem(null);
        this.taxe.setModel(this.taxeComboModel);
    }

}
