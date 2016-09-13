package fr.afpa.librairie.view.rubrique;

import fr.afpa.librairie.controller.RubriqueController;
import fr.afpa.librairie.data.bean.Rubrique;
import fr.afpa.librairie.view.FooterCreatePanel;
import fr.afpa.librairie.view.field.JDateField;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class CreateRubriquePanel extends JPanel {
    
    private RubriqueController controller;
    
    private JPanel bodyPanel;
    private JPanel titlePanel;
    
    private JLabel titreLB;
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
    
    private FooterCreatePanel footer;
                
    public CreateRubriquePanel(RubriqueController controller) {
        this.controller = controller;
        initComponents();
    }
                      
    private void initComponents() {
        
        
        footer = new FooterCreatePanel(controller);
        
        scrollPane = new JScrollPane();
        titlePanel = new JPanel();
        bodyPanel = new JPanel();
        
        titreLB = new JLabel();
        libelleLB = new JLabel();
        dateDebutLB = new JLabel();
        dateFinLB = new JLabel();
        champObligLB = new JLabel();
        commentaireLB = new JLabel();
        
        libelleTF = new JTextField();
        dateDebutTF = new JDateField(true);
        dateFinTF = new JDateField(false);
        commentaireTF = new JTextArea();
        
        titlePanel.setBackground(Color.darkGray);
        titlePanel.setBorder(BorderFactory.createLineBorder(java.awt.Color.lightGray));

        titreLB.setFont(new Font("Dialog", 1, 24)); // NOI18N
        titreLB.setForeground(Color.lightGray);
        titreLB.setHorizontalAlignment(SwingConstants.CENTER);
        titreLB.setText("Nouvelle rubrique");

        GroupLayout titlePanelLayout = new GroupLayout(titlePanel);
        titlePanel.setLayout(titlePanelLayout);
        titlePanelLayout.setHorizontalGroup(
            titlePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(titlePanelLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(titreLB, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(20, 20, 20))
        );
        
        titlePanelLayout.setVerticalGroup(
            titlePanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(titlePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(titreLB)
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        bodyPanel.setBackground(Color.darkGray);

        libelleLB.setForeground(Color.lightGray);
        libelleLB.setText("* Libelle");

        libelleTF.setBackground(Color.lightGray);

        dateDebutLB.setForeground(Color.lightGray);
        dateDebutLB.setText("* Date de début");

        dateDebutTF.setBackground(Color.lightGray);

        commentaireLB.setForeground(java.awt.Color.lightGray);
        commentaireLB.setText("commentaire");

        champObligLB.setFont(new Font("Dialog", 0, 10)); // NOI18N
        champObligLB.setForeground(Color.lightGray);
        champObligLB.setText("* Champ obligagoire");

        dateFinLB.setForeground(Color.lightGray);
        dateFinLB.setText("Date de fin");

        dateFinTF.setBackground(Color.lightGray);

        commentaireTF.setColumns(20);
        commentaireTF.setRows(5);
        scrollPane.setViewportView(commentaireTF);

        javax.swing.GroupLayout bodyPanelLayout = new javax.swing.GroupLayout(bodyPanel);
        bodyPanel.setLayout(bodyPanelLayout);
        bodyPanelLayout.setHorizontalGroup(
            bodyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bodyPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(bodyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(bodyPanelLayout.createSequentialGroup()
                        .addComponent(champObligLB)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, bodyPanelLayout.createSequentialGroup()
                        .addGroup(bodyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(bodyPanelLayout.createSequentialGroup()
                                .addGroup(bodyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(bodyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(dateDebutLB, javax.swing.GroupLayout.DEFAULT_SIZE, 89, Short.MAX_VALUE)
                                        .addComponent(libelleLB, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addComponent(dateFinLB, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(commentaireLB))
                                .addGap(13, 13, 13)
                                .addGroup(bodyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(dateFinTF, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(dateDebutTF, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(libelleTF, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(scrollPane)))
                            .addGroup(bodyPanelLayout.createSequentialGroup()
                                .addGap(55, 55, 55)
                                .addComponent(footer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 59, Short.MAX_VALUE)))
                        .addGap(6, 6, 6))))
        );
        bodyPanelLayout.setVerticalGroup(
            bodyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bodyPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(champObligLB)
                .addGap(3, 3, 3)
                .addGroup(bodyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(libelleLB)
                    .addComponent(libelleTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(bodyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(dateDebutTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dateDebutLB))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(bodyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(dateFinTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dateFinLB))
                .addGroup(bodyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(bodyPanelLayout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addComponent(scrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(bodyPanelLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(commentaireLB)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(footer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(titlePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(bodyPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(titlePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(bodyPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }     
    
    
    public Rubrique getRubrique() {
        Rubrique rubrique = new Rubrique();
        
        rubrique.setLibelle(libelleTF.getText().trim());
        rubrique.setCommentaire(commentaireTF.getText().trim());
        
        if(dateDebutTF.getValue() != null) {
            Date debut = new Date(dateDebutTF.getValue().getTime());
            rubrique.setDateDebut(debut);
        }
        
        if(dateFinTF.getValue() != null) {
            Date fin = new Date(dateFinTF.getValue().getTime());
            rubrique.setDateFin(fin);
        }
        
        return rubrique;
    }

}
