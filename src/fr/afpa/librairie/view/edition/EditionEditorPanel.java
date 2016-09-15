package fr.afpa.librairie.view.edition;

import fr.afpa.librairie.data.bean.Edition;
import fr.afpa.librairie.view.rubrique.*;
import fr.afpa.librairie.data.bean.Rubrique;
import fr.afpa.librairie.model.verifier.StrictInputVerifier;
import fr.afpa.librairie.view.field.JDateField;
import fr.afpa.librairie.view.field.JPercentField;
import fr.afpa.librairie.view.panel.EditorPanel;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.sql.Date;
import javax.swing.GroupLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;

public class EditionEditorPanel extends EditorPanel<Edition> {
    private JLabel isbnLB;
    private JLabel datePublicationLB;
    private JLabel prixHtLB;
    private JLabel imageLB;
    private JLabel titreLB;
    private JLabel stockLB;
 
    
    private JTextField isbn;
    private JDateField datePublication;
    private JTextField prixHt;
    private JTextField image;
    private JTextField titre;
    private JPercentField stock;
 
    
    
    
    public EditionEditorPanel(ActionListener controller) {
        super(new Edition(), controller);
    }

    public EditionEditorPanel(Edition bean, ActionListener controller) {
        super(bean, controller);
    }

    @Override
    public Edition getBean() {
        Edition edition = super.getBean();
        
        if(edition == null){
            edition = new Edition();
            setBean(edition);
        }
        
        return edition;
    }
    
    @Override
    protected String getTitleText() {
        Edition edition = getBean();
        
        return edition.getIsbn() != null 
                ? "Edition (isbn) : " + edition.getIsbn() 
                : "Nouvelle Edition";
    }
    
    @Override
    protected void initBody(JPanel body) {
        
        isbn = new JTextField(15);
        isbn.setInputVerifier(new StrictInputVerifier());

        datePublication = new JDateField(true);
        
        prixHt = new JTextField(15);
        prixHt.setInputVerifier(new StrictInputVerifier());
        
        image = new JTextField(15);
        image.setInputVerifier(new StrictInputVerifier());

        titre = new JTextField(15);
        titre.setInputVerifier(new StrictInputVerifier());
        
        /*stock = new JTextField(15);
        stock.setInputVerifier(new StrictInputVerifier());*/
 


        isbnLB                      = new JLabel("Isbn :");
 
        datePublicationLB           = new JLabel("Date de publication :");
  
        prixHtLB                    = new JLabel("Prix HT :");
        imageLB                     = new JLabel("Couverture :");
        titreLB                     = new JLabel("Titre :");
        stockLB                     = new JLabel("Stock :");

  
        isbnLB.setLabelFor(isbn);

        datePublicationLB.setLabelFor(datePublication);
  
        prixHtLB.setLabelFor(prixHt);
        imageLB.setLabelFor(image);
        titreLB.setLabelFor(titre);
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
                                    
                                    .addComponent(prixHtLB, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(imageLB, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(titreLB, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(stockLB, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    
                                .addGap(13, 13, 13)
                                .addGroup(bodyPanelLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                    .addComponent(isbn, GroupLayout.Alignment.LEADING)
                                    
                                    .addComponent(datePublication, GroupLayout.Alignment.LEADING)

                                    .addComponent(prixHt, GroupLayout.Alignment.LEADING)
                                    .addComponent(image, GroupLayout.Alignment.LEADING)    
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
                    .addComponent(prixHt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(prixHtLB))
                .addGroup(bodyPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(image, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(imageLB))
                .addGroup(bodyPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(titre, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(titreLB))
                .addGroup(bodyPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(stock, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(stockLB))
                
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED))
        );
        
    }   
    
    @Override
    public void bindValues() {
        Edition edition = getBean();

        
        isbn.setText(edition.getIsbn());
        datePublication.setValue(edition.getDatePublication());
        //prixHt.setText(edition.getPrixHt());
        image.setText(edition.getCouverture());
        titre.setText(edition.getTitre());
        //stock.setText(edition.getStock());
        
        
        
    }

    @Override
    public void reset() {
//        libelleTF.setText("");
//        dateDebutTF.setValue(null);
//        dateFinTF.setValue(null);
//        commentaireTF.setText("");
    }

    @Override
    public Edition constructBean() {
        Edition edition = getBean();
        
//        rubrique.setLibelle(libelleTF.getText().trim());
//        
//        if(dateDebutTF.getValue() != null) {
//            Date debut = new Date(dateDebutTF.getValue().getTime());
//            rubrique.setDateDebut(debut);
//        }
//        
//        if(dateFinTF.getValue() != null) {
//            Date fin = new Date(dateFinTF.getValue().getTime());
//            rubrique.setDateFin(fin);
//        }
//        
//        rubrique.setCommentaire(commentaireTF.getText().trim());
        
        return edition;
    }

}
