package fr.afpa.librairie.view.edition;

import fr.afpa.librairie.controller.CRUDController;
import fr.afpa.librairie.data.bean.Edition;
import fr.afpa.librairie.data.bean.Langue;
import fr.afpa.librairie.data.bean.Taxe;
import fr.afpa.librairie.model.list.ListAdapterListModel;
import fr.afpa.librairie.model.list.renderer.LangueListCellRenderer;
import fr.afpa.librairie.model.list.renderer.TaxeListCellRenderer;
import fr.afpa.librairie.model.verifier.StrictInputVerifier;
import fr.afpa.librairie.view.field.JDateField;
import fr.afpa.librairie.view.field.JFloatField;
import fr.afpa.librairie.view.field.JIntegerField;
import fr.afpa.librairie.view.panel.EditorPanel;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;

public class EditionEditorPanel extends EditorPanel<Edition> {

//    private JFileChooser chooseFile;
//    private String chooseTitle;
    private DefaultComboBoxModel<Langue> langueComboModel;
    private ListAdapterListModel<Taxe> taxeModel;

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
    private JList<Taxe> taxe;
    private JIntegerField stock;
    private JButton modifierImage;

    public EditionEditorPanel(CRUDController<Edition> controller) {
        super(controller);
    }

    @Override
    protected void initBody(JPanel body) {

        modifierImage = new JButton("Modifier image");

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

        taxe = new JList<>();
        int cellHeight = 20;
        taxe.setFixedCellHeight(cellHeight);

        taxe.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);

        taxe.setCellRenderer(new TaxeListCellRenderer());

        stock = new JIntegerField(true);
        //pas besoin de mettre la ligne au dessous parce qu'elle est deja presente dans la methode JIntegerField.
        //stock.setInputVerifier(new StrictInputVerifier());

        isbnLB = new JLabel("Isbn :");

        datePublicationLB = new JLabel("Date de publication :");

        langueLB = new JLabel("Langue :");

        prixHtLB = new JLabel("Prix HT :");

        imageLB = new JLabel(new ImageIcon("C:\\Users\\Marÿn\\Documents\\imageTest\\toad.jpg"));

        titreLB = new JLabel("Titre :");

        taxeLB = new JLabel("Taxe :");

        stockLB = new JLabel("Stock :");

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
                                        .addGroup(bodyPanelLayout.createSequentialGroup()
                                            .addGroup(bodyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addComponent(imageLB, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(modifierImage, javax.swing.GroupLayout.DEFAULT_SIZE, 306, Short.MAX_VALUE)
                                            )
                                            .addGroup(bodyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(isbnLB)
                                                .addComponent(datePublicationLB, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(titreLB, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(langueLB, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(prixHtLB, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(taxeLB, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(stockLB, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            )
                                            .addGroup(bodyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addComponent(isbn)
                                                .addComponent(titre, javax.swing.GroupLayout.DEFAULT_SIZE, 305, Short.MAX_VALUE)
                                                .addGroup(bodyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                    .addComponent(prixHt, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 94, Short.MAX_VALUE)
                                                    .addComponent(stock, javax.swing.GroupLayout.Alignment.LEADING))
                                                .addComponent(datePublication, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGroup(bodyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                    .addComponent(taxe, javax.swing.GroupLayout.Alignment.LEADING, 0, 130, Short.MAX_VALUE)
                                                    .addComponent(langue, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                )
                                            )
                                        )
                                    )
                                )
                                .addContainerGap(26, Short.MAX_VALUE))
                            )
                        )
                    )
                )
            )
        );
        bodyPanelLayout.setVerticalGroup(
            bodyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bodyPanelLayout.createSequentialGroup()
                .addGroup(bodyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(bodyPanelLayout.createSequentialGroup()
                        .addComponent(imageLB, javax.swing.GroupLayout.PREFERRED_SIZE, 296, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(bodyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(taxeLB, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(taxe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(modifierImage, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                            )
                    )
                    .addGroup(bodyPanelLayout.createSequentialGroup()
                        .addGroup(bodyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(isbnLB, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(isbn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(bodyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(datePublicationLB, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(datePublication, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(bodyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(titreLB, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(titre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(bodyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(langueLB, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(langue, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(bodyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(prixHtLB, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(prixHt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    )
                )
                .addGroup(bodyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(stockLB, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(stock, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                )
            )
        );

    }

    protected void initFileChooser(JFileChooser chooseFile) {

        chooseFile = new JFileChooser();

        GroupLayout bodyPanelLayout01 = new GroupLayout(chooseFile);
        chooseFile.setLayout(bodyPanelLayout01);

        bodyPanelLayout01.setHorizontalGroup(
                bodyPanelLayout01.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(bodyPanelLayout01.createSequentialGroup()
                        .addGap(124, 124, 124)
                        .addComponent(chooseFile, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(127, Short.MAX_VALUE))
        );
        bodyPanelLayout01.setVerticalGroup(
                bodyPanelLayout01.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(bodyPanelLayout01.createSequentialGroup()
                        .addGap(66, 66, 66)
                        .addComponent(chooseFile, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(165, Short.MAX_VALUE))
        );
    }
    
//    private void modifierImageActionPerformed(ActionEvent e) {
//        
//       
//        int result;
//
//        chooseFile = new JFileChooser();
//        chooseFile.setCurrentDirectory(new java.io.File("."));
//        chooseFile.setDialogTitle(chooseTitle);
//        chooseFile.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
//        // Permet d'afficher les fichiers et les répertoires
//        chooseFile.setAcceptAllFileFilterUsed(false);
//        //   
//        if (chooseFile.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
//
//            System.out.println("getSelectedFile() : "
//                    + chooseFile.getSelectedFile());
//
//        } else {
//            System.out.println("Pas de fichier séléctioné ");
//        }
//    }

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

        if (edition.getLangue() != null) {
            this.langue.setSelectedItem(edition.getLangue());
        }

        if (edition.getTaxes() != null) {
            this.taxe.setSelectedValue(taxe, true);
        }

    }

    @Override
    public Edition constructBean() {
        Edition edition = getBean();

        edition.setIsbn(isbn.getText());

        if (datePublication.getValue() != null) {
            edition.setDatePublication(new java.sql.Date(datePublication.getValue().getTime()));
        }

        edition.setPrixHt(prixHt.getValue());
        edition.setCouverture(image.getText());
        edition.setTitre(titre.getText());
        edition.setStock(stock.getValue());
        edition.setLangue((Langue) langue.getSelectedItem());

        edition.setTaxes(taxe.getSelectedValuesList());

        return edition;
    }

    @Override
    public void reset() {

        this.isbn.setText("");

        this.datePublication.setValue(null);
        this.langue.setSelectedItem("");
        
        this.prixHt.setValue(null);
        this.image.setText("");
        this.titre.setText("");
        this.taxe.setSelectedValue(null, true);
        this.stock.setValue(null);
    }

    public void setLangueModel(List<Langue> list) {
        this.langueComboModel = new DefaultComboBoxModel(list.toArray());
        this.langueComboModel.setSelectedItem(null);
        this.langue.setModel(this.langueComboModel);
    }

    public void setTaxeModel(List<Taxe> taxes) {
        this.taxeModel = new ListAdapterListModel();
        this.taxeModel.addAll(taxes);
        this.taxe.setModel(this.taxeModel);
    }

}
