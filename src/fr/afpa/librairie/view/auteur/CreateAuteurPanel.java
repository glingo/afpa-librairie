package fr.afpa.librairie.view.auteur;

import fr.afpa.librairie.controller.AuteurController;
import fr.afpa.librairie.data.bean.Auteur;
import fr.afpa.librairie.model.verifier.StrictInputVerifier;
import fr.afpa.librairie.view.FooterCreatePanel;
import fr.afpa.librairie.view.field.JDateField;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.sql.Date;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.SwingConstants;

public class CreateAuteurPanel extends JPanel{
    private final AuteurController controller;
    
    private JPanel bodyPanel;
    private JLabel champObligLB;
    private JLabel dateDecesLB;
    private JDateField dateDecesTF;
    private JLabel dateNaissLB;
    private JDateField dateNaissTF;
    private JPanel jPanel1;
    private JLabel nomLB;
    private JTextField nomTF;
    private JLabel nouvelAuteurLB;
    private JLabel prenomLB;
    private JTextField prenomTF;
    private JPanel titlePanel;
    private FooterCreatePanel footer;             

    public CreateAuteurPanel(AuteurController controller) {
        this.controller = controller;
        initComponents();
        setMinimumSize(new Dimension(400, 435));
        setPreferredSize(new Dimension(400, 435));
    }

    private void initComponents() {

        jPanel1 = new JPanel();
        titlePanel = new JPanel();
        nouvelAuteurLB = new JLabel();
        bodyPanel = new JPanel();
        nomLB = new JLabel();
        nomTF = new JTextField();
        prenomLB = new JLabel();
        prenomTF = new JTextField();
        dateNaissLB = new JLabel();
        dateDecesLB = new JLabel();
        dateNaissTF = new JDateField(false);
        champObligLB = new JLabel();
        dateDecesTF = new JDateField(false);
        
        footer = new FooterCreatePanel(this.controller);
        
        nouvelAuteurLB.setHorizontalAlignment(SwingConstants.CENTER);

        GroupLayout jPanel1Layout = new GroupLayout(jPanel1);
        
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        this.setBackground(Color.darkGray);

        titlePanel.setBackground(Color.darkGray);
        titlePanel.setBorder(BorderFactory.createLineBorder(Color.lightGray));

        nouvelAuteurLB.setFont(new Font("Dialog", 1, 24)); // NOI18N
        nouvelAuteurLB.setForeground(Color.lightGray);
        nouvelAuteurLB.setText("Nouvel Auteur");

        javax.swing.GroupLayout titlePanelLayout = new GroupLayout(titlePanel);
        titlePanel.setLayout(titlePanelLayout);
        titlePanelLayout.setHorizontalGroup(
            titlePanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(titlePanelLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(nouvelAuteurLB, GroupLayout.DEFAULT_SIZE, 305, Short.MAX_VALUE)
                .addGap(20, 20, 20))
        );
        titlePanelLayout.setVerticalGroup(
            titlePanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(titlePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(nouvelAuteurLB)
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        bodyPanel.setBackground(Color.darkGray);

        nomLB.setForeground(Color.lightGray);
        nomLB.setText("* Nom");
        nomTF.setInputVerifier(new StrictInputVerifier());

        nomTF.setBackground(Color.lightGray);

        prenomLB.setForeground(Color.lightGray);
        prenomLB.setText("Prénom");

        prenomTF.setBackground(Color.lightGray);

        dateNaissLB.setForeground(Color.lightGray);
        dateNaissLB.setText("Date de Naissance");

        dateDecesLB.setForeground(Color.lightGray);
        dateDecesLB.setText("Date de décès");

        dateNaissTF.setBackground(Color.lightGray);

        champObligLB.setFont(new Font("Dialog", 0, 10)); // NOI18N
        champObligLB.setForeground(Color.lightGray);
        champObligLB.setText("* Champ obligagoire");

        dateDecesTF.setBackground(Color.lightGray);

        GroupLayout bodyPanelLayout = new GroupLayout(bodyPanel);
        bodyPanel.setLayout(bodyPanelLayout);
        bodyPanelLayout.setHorizontalGroup(
            bodyPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(bodyPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(bodyPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(bodyPanelLayout.createSequentialGroup()
                        .addGroup(bodyPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addGroup(GroupLayout.Alignment.TRAILING, bodyPanelLayout.createSequentialGroup()
                                .addGroup(bodyPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                    .addComponent(prenomLB, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(nomLB, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(bodyPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                    .addComponent(prenomTF)
                                    .addComponent(nomTF)))
                            .addGroup(bodyPanelLayout.createSequentialGroup()
                                .addGroup(bodyPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                    .addComponent(dateNaissLB)
                                    .addComponent(dateDecesLB, GroupLayout.PREFERRED_SIZE, 106, GroupLayout.PREFERRED_SIZE))
                                .addGap(42, 42, 42)
                                .addGroup(bodyPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                    .addComponent(dateDecesTF)
                                    .addComponent(dateNaissTF))))
                        .addGap(6, 6, 6))
                    .addGroup(bodyPanelLayout.createSequentialGroup()
                        .addComponent(champObligLB)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        bodyPanelLayout.setVerticalGroup(
            bodyPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(bodyPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(champObligLB)
                .addGap(3, 3, 3)
                .addGroup(bodyPanelLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                    .addComponent(nomLB)
                    .addComponent(nomTF, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(bodyPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(prenomTF, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(prenomLB))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 42, Short.MAX_VALUE)
                .addGroup(bodyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(dateNaissLB)
                    .addComponent(dateNaissTF, GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(bodyPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(dateDecesLB)
                    .addComponent(dateDecesTF, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15))
        );

        GroupLayout mainPanelLayout = new GroupLayout(this);
        this.setLayout(mainPanelLayout);
        mainPanelLayout.setHorizontalGroup(
            mainPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(GroupLayout.Alignment.TRAILING, mainPanelLayout.createSequentialGroup()
                .addGroup(mainPanelLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                    .addComponent(bodyPanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(mainPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(mainPanelLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                            .addComponent(titlePanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(footer, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
                .addGap(19, 19, 19))
        );
        
        mainPanelLayout.setVerticalGroup(
            mainPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(titlePanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(bodyPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(footer, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addContainerGap(15, Short.MAX_VALUE))
        );

        setBounds(0, 0, 388, 439);
    }   
    
    public Auteur getAuteur(){
        Auteur auteur = new Auteur();
        
        auteur.setNom(this.nomTF.getText().trim());
        auteur.setPrenom(this.prenomTF.getText().trim());
        
        if(this.dateDecesTF.getValue() != null) {
            Date deces = new Date(this.dateDecesTF.getValue().getTime());
            auteur.setDateDeces(deces);
        }
        
        if(this.dateNaissTF.getValue() != null) {
            Date naiss = new Date(this.dateNaissTF.getValue().getTime());
            auteur.setDateNaissance(naiss);
        }
        
        return auteur;
    }
}
