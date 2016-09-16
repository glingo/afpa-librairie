
package fr.afpa.librairie.view.rubrique;

import fr.afpa.librairie.controller.CRUDController;
import fr.afpa.librairie.data.bean.Ouvrage;
import fr.afpa.librairie.data.bean.Rubrique;
import fr.afpa.librairie.model.list.ListAdapterListModel;
import fr.afpa.librairie.model.list.renderer.OuvrageListCellRenderer;
import fr.afpa.librairie.model.verifier.StrictInputVerifier;
import fr.afpa.librairie.view.field.JDateField;
import fr.afpa.librairie.view.panel.EditorPanel;
import java.awt.Dimension;
import java.util.List;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.ListSelectionModel;

public class RubriqueViewPanel extends EditorPanel<Rubrique> {
    
     //propriete de la classe Rubrique View Panel  = les elements que l'on souhaite voir apparaitre sur le panel
    // un titre
    private final static String TITLE = "Gestion de la rubrique";
    
    //une liste
    private ListAdapterListModel<Ouvrage> ouvrageModel;
    
    //differents label
    private JLabel libelleLB;
    private JLabel dateDebutLB;
    private JLabel dateFinLB;
    private JLabel ouvrageLB;
    
    
    // champs correspondant aux labels : ils peuvent etre de type différents.
    private JTextField libelle;
    private JDateField dateDebut;
    private JDateField dateFin;
    
    //une JList
    private JList<Ouvrage> ouvrages;
    
    // un scroll Pane
    
    private JScrollPane ouvrageSP;
    
    //un bouton "+"
    private JButton ajoutOuvrage;
    
    
    //Le constructeur 

    public RubriqueViewPanel(CRUDController<Rubrique> controller) {
        super(controller);
    }
    
    protected void initBody(JPanel body){
        //instanciation
        ouvrageSP = new JScrollPane();
        
        libelle = new JTextField();
        dateDebut = new JDateField(false);
        dateFin = new JDateField(false);
        
        ouvrages = new JList<>();
        
        //association du JButton à l'action CreateModalAaction
        ajoutOuvrage = new JButton("+");
        ajoutOuvrage.setActionCommand(CRUDController.CREATE_MODAL_ACTION);
        

        int cellHeight = 20;
        ouvrages.setFixedCellHeight(cellHeight);
        ouvrages.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        
        Dimension spDimension = new Dimension(250, 80);
        ouvrageSP.setViewportView(ouvrages);
        ouvrageSP.setPreferredSize(spDimension);
        
        ouvrages.setCellRenderer(new OuvrageListCellRenderer());
        
        
        libelleLB = new JLabel("Libelle :");
        dateDebutLB = new JLabel("Date de début :");
        dateFinLB = new JLabel("Date de fin :");
        ouvrageLB = new JLabel("Ouvrages de la rubrique :");
        
        libelle.setInputVerifier(new StrictInputVerifier());
        dateDebut.setInputVerifier(new StrictInputVerifier());
        dateFin.setInputVerifier(new StrictInputVerifier());
        
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
                                    .addComponent(libelleLB, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(dateDebutLB, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(dateFinLB, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(ouvrageLB, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(13, 13, 13)
                                .addGroup(bodyPanelLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                    .addComponent(libelle, GroupLayout.Alignment.LEADING)
                                    .addComponent(dateDebut, GroupLayout.Alignment.LEADING)
                                    .addComponent(dateFin, GroupLayout.Alignment.LEADING)
                                    .addComponent(ouvrages, GroupLayout.Alignment.LEADING))
                                .addGroup(bodyPanelLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                    .addComponent(ajoutOuvrage, GroupLayout.Alignment.TRAILING))))
                        .addGap(6, 6, 6))))
        );

        bodyPanelLayout.setVerticalGroup(
            bodyPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(bodyPanelLayout.createSequentialGroup()
                .addGroup(bodyPanelLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                    .addComponent(libelleLB)
                    .addComponent(libelle, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(bodyPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(dateDebut, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(dateDebutLB))
                .addGroup(bodyPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(dateFin, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(dateFinLB))
                .addGroup(bodyPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(ouvrages, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(ouvrageLB)
                    .addComponent(ajoutOuvrage))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED))
        );
    }
    
    
    
    @Override
    protected String getTitleText() {
        
        Rubrique rubrique = getBean();
        
        return rubrique.getId() != null 
                ? "Rubrique n°" + rubrique.getId()
                : "Nouvelle Adresse";
        
        // a revoir 
    }

    @Override
    public void bindValues() {
        Rubrique rubrique = getBean();
        
        libelle.setText(rubrique.getLibelle());
        dateDebut.setValue(rubrique.getDateDebut());
        dateFin.setValue(rubrique.getDateFin());
        
        int i = 0;
        int[] ou = new int[rubrique.getOuvrage().size()];
        //rajouter une liste ouvrages au bean rubrique
        for(Ouvrage ouvrage  : rubrique.getOuvrage()){
            ou[i]= this.ouvrageModel.indexOf(ouvrage);
        }
        
        this.ouvrages.setSelectedIndices(ou);
        
    }

    @Override
    public Rubrique constructBean() {
        Rubrique rubrique = getBean();
        
        rubrique.setLibelle(libelle.getText());
        
        if(dateDebut.getValue() != null){
            rubrique.setDateDebut(new java.sql.Date(dateDebut.getValue().getTime()));
        }
        
        if(dateFin.getValue() != null){
            rubrique.setDateFin(new java.sql.Date(dateFin.getValue().getTime()));
        }
        
        rubrique.setOuvrage((Ouvrage) ouvrages.getSelectedValuesList());
        
        
        
        return rubrique;
    }

    @Override
    public void reset() {
        libelle.setText("");
        dateDebut.setValue(null);
        dateFin.setValue(null);
        ouvrages.setSelectedValue(null, true);

    }

    public void setOuvrageModel(List<Ouvrage> ouvrages) {
        this.ouvrageModel = new ListAdapterListModel();
        this.ouvrageModel.addAll(ouvrages);
        this.ouvrages.setModel(this.ouvrageModel);
    }
    
    public JButton getNewPays() {
        return ajoutOuvrage;
    }
    
    
    
     
     
     
}
