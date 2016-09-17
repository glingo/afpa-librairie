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
import javax.swing.ImageIcon;
import javax.swing.JButton;
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
    private JButton modifierImage;
    
    
    


    public EditionEditorPanel(CRUDController<Edition> controller) {
        super(controller);
    }

    @Override
    protected void initBody(JPanel body) {
        
        modifierImage     = new JButton("Modifier image");
        
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
        
        imageLB                     = new JLabel(new ImageIcon("C:\\Users\\Marÿn\\Documents\\imageTest\\toad.jpg"));

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
            .addGroup(bodyPanelLayout.createSequentialGroup()
                .addGroup(bodyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(bodyPanelLayout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        
                            .addGroup(bodyPanelLayout.createSequentialGroup()
                                .addGroup(bodyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(imageLB, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(modifierImage, javax.swing.GroupLayout.DEFAULT_SIZE, 306, Short.MAX_VALUE))
                                .addGap(53, 53, 53)
                                .addGroup(bodyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(isbnLB)
                                    .addComponent(datePublicationLB, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(titreLB, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(langueLB, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(prixHtLB, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(taxeLB, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(stockLB, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(127, 127, 127)
                                .addGroup(bodyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(isbn)
                                    .addComponent(titre, javax.swing.GroupLayout.DEFAULT_SIZE, 305, Short.MAX_VALUE)
                                    .addGroup(bodyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(prixHt, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 94, Short.MAX_VALUE)
                                        .addComponent(stock, javax.swing.GroupLayout.Alignment.LEADING))
                                    .addComponent(datePublication, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(bodyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(taxe, javax.swing.GroupLayout.Alignment.LEADING, 0, 130, Short.MAX_VALUE)
                                        .addComponent(langue, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))))
                    
                .addContainerGap(26, Short.MAX_VALUE))
      ))))));
        bodyPanelLayout.setVerticalGroup(
            bodyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bodyPanelLayout.createSequentialGroup()
                
                .addGap(33, 33, 33)
                .addGroup(bodyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(bodyPanelLayout.createSequentialGroup()
                        .addComponent(imageLB, javax.swing.GroupLayout.PREFERRED_SIZE, 296, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(bodyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(taxeLB, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(taxe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(modifierImage, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(38, 38, 38))
                    .addGroup(bodyPanelLayout.createSequentialGroup()
                        .addGroup(bodyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(isbnLB, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(isbn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(bodyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(datePublicationLB, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(datePublication, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(bodyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(titreLB, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(titre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(bodyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(langueLB, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(langue, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(26, 26, 26)
                        .addGroup(bodyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(prixHtLB, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(prixHt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(109, 109, 109)))
                .addGroup(bodyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(stockLB, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(stock, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 50, Short.MAX_VALUE)
                
                .addGap(34, 34, 34))
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
