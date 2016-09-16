package fr.afpa.librairie.view.rubrique;

import fr.afpa.librairie.controller.CRUDController;
import fr.afpa.librairie.data.bean.Ouvrage;
import fr.afpa.librairie.data.bean.Rubrique;
import fr.afpa.librairie.model.list.ListAdapterListModel;
import fr.afpa.librairie.view.field.JDateField;
import fr.afpa.librairie.view.panel.EditorPanel;
import java.awt.Font;
import java.sql.Date;
import java.util.List;
import javax.swing.GroupLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;

public class RubriqueEditorPanel extends EditorPanel<Rubrique> {
    
    private JLabel champObligLB;
    private JLabel libelleLB;
    private JLabel dateDebutLB;
    private JLabel dateFinLB;
    private JLabel commentaireLB;
    
    private JScrollPane scrollPane;
    private JTextArea commentaireTF;
    private JTextField libelleTF;
    private JDateField dateDebutTF;
    private JDateField dateFinTF;
    
    public RubriqueEditorPanel(CRUDController<Rubrique> controller) {
        super(controller);
    }

    @Override
    protected String getTitleText() {
        Rubrique rubrique = getBean();
        
        return rubrique.getId() != null 
                ? "Rubrique " + rubrique.getLibelle() 
                : "Nouvelle Rubrique";
    }
    
    @Override
    protected void initBody(JPanel body) {
        
        scrollPane = new JScrollPane();
        
        libelleLB = new JLabel();
        dateDebutLB = new JLabel();
        dateFinLB = new JLabel();
        champObligLB = new JLabel();
        commentaireLB = new JLabel();
        
        libelleTF = new JTextField();
        dateDebutTF = new JDateField(true);
        dateFinTF = new JDateField(false);
        commentaireTF = new JTextArea();

        libelleLB.setText("* Libelle");

        dateDebutLB.setText("* Date de début");


        commentaireLB.setText("commentaire");

        champObligLB.setFont(new Font("Dialog", 0, 10));
        champObligLB.setText("* Champ obligagoire");
        dateFinLB.setText("Date de fin");

        commentaireTF.setColumns(20);
        commentaireTF.setRows(5);
        scrollPane.setViewportView(commentaireTF);
        
        GroupLayout bodyPanelLayout = new GroupLayout(body);
        body.setLayout(bodyPanelLayout);
        
        bodyPanelLayout.setHorizontalGroup(
            bodyPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(bodyPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(bodyPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(bodyPanelLayout.createSequentialGroup()
                        .addComponent(champObligLB)
                        .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(GroupLayout.Alignment.TRAILING, bodyPanelLayout.createSequentialGroup()
                        .addGroup(bodyPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addGroup(bodyPanelLayout.createSequentialGroup()
                                .addGroup(bodyPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                    .addGroup(bodyPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                        .addComponent(dateDebutLB, GroupLayout.DEFAULT_SIZE, 89, Short.MAX_VALUE)
                                        .addComponent(libelleLB, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addComponent(dateFinLB, GroupLayout.PREFERRED_SIZE, 106, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(commentaireLB))
                                .addGroup(bodyPanelLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                    .addComponent(dateFinTF, GroupLayout.Alignment.LEADING)
                                    .addComponent(dateDebutTF, GroupLayout.Alignment.LEADING)
                                    .addComponent(libelleTF, GroupLayout.Alignment.LEADING)
                                    .addComponent(scrollPane))))
                        .addGap(6, 6, 6))))
        );
        
        bodyPanelLayout.setVerticalGroup(
            bodyPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(bodyPanelLayout.createSequentialGroup()
                .addComponent(champObligLB)
                .addGap(3, 3, 3)
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
                .addGroup(bodyPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(bodyPanelLayout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addGroup(bodyPanelLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(commentaireLB)))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED))
        );
        
    }   
    
    @Override
    public void bindValues() {
        Rubrique rubrique = getBean();
        libelleTF.setText(rubrique.getLibelle());
        dateDebutTF.setValue(rubrique.getDateDebut());
        dateFinTF.setValue(rubrique.getDateFin());
        commentaireTF.setText(rubrique.getCommentaire());
    }

    @Override
    public void reset() {
        libelleTF.setText("");
        dateDebutTF.setValue(null);
        dateFinTF.setValue(null);
        commentaireTF.setText("");
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
        
        return rubrique;
    }
    
    
}
