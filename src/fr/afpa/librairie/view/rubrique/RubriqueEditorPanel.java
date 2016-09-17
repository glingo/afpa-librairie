package fr.afpa.librairie.view.rubrique;

import fr.afpa.librairie.controller.CRUDController;
import fr.afpa.librairie.data.bean.Ouvrage;
import fr.afpa.librairie.data.bean.Rubrique;
import fr.afpa.librairie.model.list.ListAdapterListModel;
import fr.afpa.librairie.model.list.renderer.OuvrageListCellRenderer;
import fr.afpa.librairie.view.field.JDateField;
import fr.afpa.librairie.view.panel.EditorPanel;
import java.awt.Dimension;
import java.awt.Font;
import java.sql.Date;
import java.util.List;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.ListSelectionModel;

public class RubriqueEditorPanel extends EditorPanel<Rubrique> {
    
    private ListAdapterListModel<Ouvrage> ouvrageModel;
    
    private JLabel champObligLB;
    private JLabel libelleLB;
    private JLabel dateDebutLB;
    private JLabel dateFinLB;
    private JLabel commentaireLB;
    private JLabel ouvrageLB;
    
    
    private JTextArea commentaireTF;
    private JTextField libelleTF;
    private JDateField dateDebutTF;
    private JDateField dateFinTF;
    
    
    private JList<Ouvrage> ouvrages;
    
    private JButton ajoutOuvrage;
    
    private JScrollPane ouvrageSP;
    private JScrollPane commentaireSP;
    
    
    public RubriqueEditorPanel(CRUDController<Rubrique> controller) {
        super(controller);
    }

   
    
    @Override
    protected void initBody(JPanel body) {
        
        ouvrageSP = new JScrollPane();
        commentaireSP = new JScrollPane();
        
        libelleLB        = new JLabel();
        dateDebutLB      = new JLabel();
        dateFinLB        = new JLabel();
        champObligLB     = new JLabel();
        commentaireLB    = new JLabel();
        ouvrageLB        = new JLabel("Ouvrage :");
        
        libelleTF        = new JTextField();
        dateDebutTF      = new JDateField(true);
        dateFinTF        = new JDateField(false);
        commentaireTF    = new JTextArea(10, 10);
        ouvrages         = new JList<>();
        ajoutOuvrage     = new JButton("+");
        ajoutOuvrage.setActionCommand(CRUDController.CREATE_MODAL_ACTION);
        
        commentaireTF.setLineWrap(true);
        
        
        
        int cellHeight = 20;
        ouvrages.setFixedCellHeight(cellHeight);
        ouvrages.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        
        Dimension spDimension = new Dimension(250, 80);
        ouvrageSP.setViewportView(ouvrages);
        ouvrageSP.setPreferredSize(spDimension);
        ouvrages.setCellRenderer(new OuvrageListCellRenderer());
        
        

        libelleLB.setText("* Libelle");

        dateDebutLB.setText("* Date de début");


        commentaireLB.setText("commentaire");

        champObligLB.setFont(new Font("Dialog", 0, 10));
        champObligLB.setText("* Champ obligagoire");
        dateFinLB.setText("Date de fin");

        commentaireTF.setColumns(20);
        commentaireTF.setRows(5);
        commentaireSP.setViewportView(commentaireTF);
        
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
                                    .addComponent(commentaireLB, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(ouvrageLB, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(13, 13, 13)
                                .addGroup(bodyPanelLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                    .addComponent(libelleTF, GroupLayout.Alignment.LEADING)
                                    .addComponent(dateDebutTF, GroupLayout.Alignment.LEADING)
                                    .addComponent(dateFinTF, GroupLayout.Alignment.LEADING)
                                    .addComponent(commentaireTF, GroupLayout.Alignment.LEADING)
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
                    .addComponent(libelleTF, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(bodyPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(dateDebutTF, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(dateDebutLB))
                .addGroup(bodyPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(dateFinTF, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(dateFinLB))
                .addGroup(bodyPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(commentaireTF, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(commentaireLB))
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
                ? "Rubrique " + rubrique.getLibelle() 
                : "Nouvelle Rubrique";
    }
    
    @Override
    public void bindValues() {
        Rubrique rubrique = getBean();
        libelleTF.setText(rubrique.getLibelle());
        dateDebutTF.setValue(rubrique.getDateDebut());
        dateFinTF.setValue(rubrique.getDateFin());
        commentaireTF.setText(rubrique.getCommentaire());
        
        int i = 0;
        int[] ou = new int[rubrique.getOuvrage().size()];
        for (Ouvrage ouvrage : rubrique.getOuvrage()) {
            ou[i] = this.ouvrageModel.indexOf(ouvrage);
        }
        this.ouvrages.setSelectedIndices(ou);
    }

    @Override
    public void reset() {
        libelleTF.setText("");
        dateDebutTF.setValue(null);
        dateFinTF.setValue(null);
        commentaireTF.setText("");
        this.ouvrages.setSelectedValue(null, true);
    }

    @Override
    public Rubrique constructBean() {
        Rubrique rubrique = getBean();
        
        rubrique.setLibelle(libelleTF.getText().trim());
        
        if(dateDebutTF.getValue() != null) {
            Date debut = new Date(dateDebutTF.getValue().getTime());
            rubrique.setDateDebut(debut);
        }
        
        if(dateFinTF.getValue() != null) {
            Date fin = new Date(dateFinTF.getValue().getTime());
            rubrique.setDateFin(fin);
        }
        
        rubrique.setCommentaire(commentaireTF.getText().trim());
        
        rubrique.setOuvrage((Ouvrage) ouvrages.getSelectedValuesList());
        
        
        return rubrique;
    }
    
    
   public void setOuvrageModel(List<Ouvrage> ouvrages) {
        this.ouvrageModel = new ListAdapterListModel();
        this.ouvrageModel.addAll(ouvrages);
        this.ouvrages.setModel(this.ouvrageModel);
    }

    public JButton getAjoutOuvrage() {
        return ajoutOuvrage;
    }
    
}
