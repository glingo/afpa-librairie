package fr.afpa.librairie.view.ouvrage;

import fr.afpa.librairie.controller.OuvrageController;
import fr.afpa.librairie.data.bean.Auteur;
import fr.afpa.librairie.data.bean.Ouvrage;
import fr.afpa.librairie.view.FooterCreatePanel;
import java.awt.Color;
import java.awt.Font;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;

public class CreateOuvragePanel extends JPanel {
    
    private final DefaultComboBoxModel<Auteur> auteurComboModel = new DefaultComboBoxModel();
    private final DefaultComboBoxModel<Auteur> coAuteurComboModel = new DefaultComboBoxModel();
//    private final DefaultComboBoxModel<Langue> langueComboModel = new DefaultComboBoxModel();
    
    private final OuvrageController controller;

    private JComboBox<Auteur> auteurCB;
    // ce sera surement un pop up (JCheckboxMenuItem) 
    // lescombos sont reservées a des valeurs unique.
    private JComboBox<Auteur> coAuteurCB1;
    
    // ce sera surement un pop up (JCheckboxMenuItem) 
    // lescombos sont reservées a des valeurs unique.
    private JComboBox rubriqueCB1;
    private JComboBox rubriqueCB2;
    
//    private JComboBox coAuteursCB2;
//    private JComboBox langueCB;
//    private JLabel langueLB;
//    private JLabel langueResLB;
    
    private JLabel auteurLB;
    private JPanel auteurPanel;
    private JLabel auteurResLB;
    private JPanel bodyPanel1;
    private JPanel bodyPanel2;
    private JLabel champObligLB;
    private JLabel coAuteursLB;
    private JComboBox genreCB;
    private JLabel genreLB;
    private JLabel genreResLB;
    private JPanel jPanel6;
    private JScrollPane jScrollPane1;
    private JScrollPane jScrollPane2;
    private JTextArea jTextArea1;
    private JTextField jTextField3;
    private JPanel mainPanel;
    private JLabel nouvelOuvrageLB;
    private JLabel resumeLB;
    private JTextArea resumeTP;
    private JLabel rubriquesLB;
    private JLabel sousTitreLB;
    private JTextField sousTitreTF;
    private JComboBox tagCB1;
    private JComboBox tagCB2;
    private JLabel tagLB;
    private JComboBox themeCB1;
    private JComboBox themeCB2;
    private JLabel themesLB;
    private JPanel titlePanel;
    private JLabel titreLB;
    private JTextField titreTF;
    private FooterCreatePanel footer;

    public CreateOuvragePanel(OuvrageController controller) {
        this.controller = controller;
        initComponents();
    }

    private void initComponents() {

        auteurCB = new JComboBox();
        coAuteurCB1 = new JComboBox();
//        coAuteursCB2 = new JComboBox();
//        langueLB = new JLabel();
//        langueCB = new JComboBox();
//        langueResLB = new JLabel();
        
        jScrollPane1 = new JScrollPane();
        jTextArea1 = new JTextArea();
        jPanel6 = new JPanel();
        jTextField3 = new JTextField();
        mainPanel = new JPanel();
        titlePanel = new JPanel();
        nouvelOuvrageLB = new JLabel();
        auteurPanel = new JPanel();
        auteurLB = new JLabel();
        auteurResLB = new JLabel();
        bodyPanel1 = new JPanel();
        titreLB = new JLabel();
        titreTF = new JTextField();
        champObligLB = new JLabel();
        sousTitreLB = new JLabel();
        sousTitreTF = new JTextField();
        resumeLB = new JLabel();
        jScrollPane2 = new JScrollPane();
        resumeTP = new JTextArea();
        bodyPanel2 = new JPanel();
        genreCB = new JComboBox();
        genreLB = new JLabel();
        themeCB2 = new JComboBox();
        genreResLB = new JLabel();
        themesLB = new JLabel();
        themeCB1 = new JComboBox();
        coAuteursLB = new JLabel();
        tagLB = new JLabel();
        tagCB1 = new JComboBox();
        tagCB2 = new JComboBox();
        rubriquesLB = new JLabel();
        rubriqueCB1 = new JComboBox();
        rubriqueCB2 = new JComboBox();
        footer = new FooterCreatePanel(controller);

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        GroupLayout jPanel6Layout = new GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
                jPanel6Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
                jPanel6Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGap(0, 100, Short.MAX_VALUE)
        );

        jTextField3.setText("jTextField3");

        mainPanel.setBackground(Color.darkGray);

        titlePanel.setBackground(Color.darkGray);
        titlePanel.setBorder(BorderFactory.createLineBorder(java.awt.Color.lightGray));

        nouvelOuvrageLB.setFont(new Font("Dialog", 1, 24)); // NOI18N
        nouvelOuvrageLB.setForeground(Color.lightGray);
        nouvelOuvrageLB.setText("Nouvel Ouvrage");

        GroupLayout titlePanelLayout = new GroupLayout(titlePanel);
        titlePanel.setLayout(titlePanelLayout);
        titlePanelLayout.setHorizontalGroup(
                titlePanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(GroupLayout.Alignment.TRAILING, titlePanelLayout.createSequentialGroup()
                        .addGap(93, 93, 93)
                        .addComponent(nouvelOuvrageLB, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(85, 85, 85))
        );
        titlePanelLayout.setVerticalGroup(
                titlePanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(titlePanelLayout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(nouvelOuvrageLB)
                        .addContainerGap(15, Short.MAX_VALUE))
        );

        auteurPanel.setBackground(Color.darkGray);
        auteurPanel.setForeground(Color.lightGray);

        auteurCB.setBackground(Color.gray);
        auteurCB.setForeground(Color.lightGray);

        auteurLB.setForeground(Color.lightGray);
        auteurLB.setText("* Auteur ");

        auteurResLB.setForeground(Color.lightGray);
        auteurResLB.setBorder(BorderFactory.createLineBorder(Color.lightGray));

        GroupLayout auteurPanelLayout = new GroupLayout(auteurPanel);
        auteurPanel.setLayout(auteurPanelLayout);
        auteurPanelLayout.setHorizontalGroup(
                auteurPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(auteurPanelLayout.createSequentialGroup()
                        .addComponent(auteurLB, GroupLayout.PREFERRED_SIZE, 138, GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32)
                        .addComponent(auteurCB, GroupLayout.PREFERRED_SIZE, 169, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(auteurResLB, GroupLayout.DEFAULT_SIZE, 153, Short.MAX_VALUE)
                        .addContainerGap())
        );
        auteurPanelLayout.setVerticalGroup(
                auteurPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(GroupLayout.Alignment.TRAILING, auteurPanelLayout.createSequentialGroup()
                        .addContainerGap(20, Short.MAX_VALUE)
                        .addGroup(auteurPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addComponent(auteurResLB, GroupLayout.Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
                                .addGroup(auteurPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(auteurCB, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(auteurLB)))
                        .addGap(10, 10, 10))
        );

        bodyPanel1.setBackground(Color.darkGray);
        bodyPanel1.setBorder(BorderFactory.createLineBorder(Color.lightGray));

        titreLB.setForeground(Color.lightGray);
        titreLB.setText("* Titre");

        titreTF.setBackground(Color.lightGray);

        champObligLB.setFont(new Font("Dialog", 0, 10)); // NOI18N
        champObligLB.setForeground(Color.lightGray);
        champObligLB.setText("* Champ obligatoire");

        sousTitreLB.setForeground(Color.lightGray);
        sousTitreLB.setText("Sous-titre");

        sousTitreTF.setBackground(Color.lightGray);

        resumeLB.setBackground(Color.darkGray);
        resumeLB.setForeground(Color.lightGray);
        resumeLB.setText("* Résumé");

        resumeTP.setBackground(Color.lightGray);
        resumeTP.setColumns(20);
        resumeTP.setRows(5);
        jScrollPane2.setViewportView(resumeTP);

        GroupLayout bodyPanel1Layout = new GroupLayout(bodyPanel1);
        bodyPanel1.setLayout(bodyPanel1Layout);
        bodyPanel1Layout.setHorizontalGroup(
                bodyPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(bodyPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(bodyPanel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                                .addComponent(resumeLB, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(sousTitreLB, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(champObligLB, GroupLayout.DEFAULT_SIZE, 131, Short.MAX_VALUE)
                                .addComponent(titreLB, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(27, 27, 27)
                        .addGroup(bodyPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addComponent(titreTF)
                                .addComponent(sousTitreTF)
                                .addComponent(jScrollPane2, GroupLayout.DEFAULT_SIZE, 338, Short.MAX_VALUE))
                        .addContainerGap())
        );
        bodyPanel1Layout.setVerticalGroup(
                bodyPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(bodyPanel1Layout.createSequentialGroup()
                        .addGroup(bodyPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addGroup(bodyPanel1Layout.createSequentialGroup()
                                        .addContainerGap()
                                        .addComponent(champObligLB))
                                .addGroup(bodyPanel1Layout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addGroup(bodyPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                .addComponent(titreTF, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(titreLB))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(bodyPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(sousTitreTF, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addComponent(sousTitreLB))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 16, Short.MAX_VALUE)
                        .addGroup(bodyPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addComponent(jScrollPane2, GroupLayout.PREFERRED_SIZE, 102, GroupLayout.PREFERRED_SIZE)
                                .addComponent(resumeLB))
                        .addContainerGap())
        );

        bodyPanel2.setBackground(java.awt.Color.darkGray);
        bodyPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(java.awt.Color.lightGray));

        genreCB.setBackground(java.awt.Color.gray);
//        genreCB.setModel(initModelGenre());
//        genreCB.addActionListener(new java.awt.event.ActionListener() {
//            public void actionPerformed(java.awt.event.ActionEvent evt) {
//                genreCBActionPerformed(evt);
//            }
//        });

        genreLB.setForeground(Color.lightGray);
        genreLB.setText("Genre");

        themeCB2.setBackground(Color.gray);
        themeCB2.setForeground(Color.black);

        genreResLB.setBackground(Color.lightGray);
        genreResLB.setForeground(Color.lightGray);
        genreResLB.setBorder(BorderFactory.createLineBorder(Color.lightGray));

        themesLB.setForeground(Color.lightGray);
        themesLB.setText("Themes");

        themeCB1.setBackground(Color.gray);
//        themeCB1.setModel(initModelTheme());
//        themeCB1.addActionListener(new java.awt.event.ActionListener() {
//            public void actionPerformed(java.awt.event.ActionEvent evt) {
//                themeCB1ActionPerformed(evt);
//            }
//        });

        coAuteursLB.setForeground(Color.lightGray);
        coAuteursLB.setText("Co-Auteur(s)");

        coAuteurCB1.setBackground(Color.gray);
        
//        coAuteursCB2.setBackground(Color.gray);
//        coAuteursCB2.setForeground(Color.black);

//        langueLB.setForeground(Color.lightGray);
//        langueLB.setText("Langue");
//
//        langueCB.setBackground(Color.gray);
//        langueCB.setModel(initModelLangue());
//        langueCB.addActionListener(new java.awt.event.ActionListener() {
//            public void actionPerformed(java.awt.event.ActionEvent evt) {
//                langueCBActionPerformed(evt);
//            }
//        });

//        langueResLB.setForeground(Color.lightGray);
//        langueResLB.setBorder(BorderFactory.createLineBorder(Color.lightGray));

        tagLB.setForeground(Color.lightGray);
        tagLB.setText("Tags");

        tagCB1.setBackground(Color.gray);
//        tagCB1.setModel(initModelTag());
//        tagCB1.addActionListener(new java.awt.event.ActionListener() {
//            public void actionPerformed(java.awt.event.ActionEvent evt) {
//                tagCB1ActionPerformed(evt);
//            }
//        });

        tagCB2.setBackground(Color.gray);
        tagCB2.setForeground(Color.black);

        rubriquesLB.setForeground(Color.lightGray);
        rubriquesLB.setText("Rubriques");

        rubriqueCB1.setBackground(Color.gray);
//        rubriqueCB1.setModel(initModelRubrique());
//        rubriqueCB1.addActionListener(new java.awt.event.ActionListener() {
//            public void actionPerformed(java.awt.event.ActionEvent evt) {
//                rubriqueCB1ActionPerformed(evt);
//            }
//        });

        rubriqueCB2.setBackground(Color.gray);
        rubriqueCB2.setForeground(Color.black);

        GroupLayout bodyPanel2Layout = new GroupLayout(bodyPanel2);
        bodyPanel2.setLayout(bodyPanel2Layout);
        bodyPanel2Layout.setHorizontalGroup(
                bodyPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(bodyPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(bodyPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                .addComponent(rubriquesLB, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
//                                .addComponent(langueLB, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(coAuteursLB, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(themesLB, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(genreLB, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE)
                                .addComponent(tagLB, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(32, 32, 32)
                        .addGroup(bodyPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addComponent(genreCB, 0, 169, Short.MAX_VALUE)
                                .addComponent(themeCB1, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(coAuteurCB1, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
//                                .addComponent(langueCB, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(tagCB1, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(rubriqueCB1, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(bodyPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addComponent(tagCB2, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(themeCB2, 0, 169, Short.MAX_VALUE)
                                .addComponent(genreResLB, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
//                                .addComponent(coAuteursCB2, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
//                                .addComponent(langueResLB, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(rubriqueCB2, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap())
        );
        bodyPanel2Layout.setVerticalGroup(
                bodyPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, bodyPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(bodyPanel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(coAuteursLB)
                                .addComponent(coAuteurCB1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
//                                .addComponent(coAuteursCB2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
//                        .addGroup(bodyPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
//                                .addGroup(bodyPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
//                                        .addComponent(langueResLB, GroupLayout.Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
//                                        .addComponent(langueCB, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
//                                .addComponent(langueLB))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(bodyPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addGroup(bodyPanel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(genreLB)
                                        .addComponent(genreCB, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addComponent(genreResLB, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(bodyPanel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(themesLB)
                                .addComponent(themeCB1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addComponent(themeCB2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(bodyPanel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(tagLB)
                                .addComponent(tagCB1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addComponent(tagCB2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(bodyPanel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(rubriquesLB)
                                .addComponent(rubriqueCB1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addComponent(rubriqueCB2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(18, Short.MAX_VALUE))
        );

        GroupLayout mainPanelLayout = new GroupLayout(mainPanel);
        mainPanel.setLayout(mainPanelLayout);
        mainPanelLayout.setHorizontalGroup(
                mainPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(GroupLayout.Alignment.TRAILING, mainPanelLayout.createSequentialGroup()
                        .addGroup(mainPanelLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                .addGroup(mainPanelLayout.createSequentialGroup()
                                        .addContainerGap(393, Short.MAX_VALUE)
                                        .addComponent(footer, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGroup(mainPanelLayout.createSequentialGroup()
                                        .addGap(27, 27, 27)
                                        .addGroup(mainPanelLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                                .addComponent(bodyPanel2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(bodyPanel1, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(auteurPanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(titlePanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addGap(34, 34, 34))
        );
        mainPanelLayout.setVerticalGroup(
                mainPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(mainPanelLayout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(titlePanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(auteurPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(bodyPanel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(bodyPanel2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(footer, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addGap(23, 23, 23))
        );

        GroupLayout layout = new GroupLayout(this);
        setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                        .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        setBounds(0, 0, 587, 803);
    }
    
    public void setAuteurList(List<Auteur> list) {
        auteurComboModel.removeAllElements();
        
        list.stream().forEach((auteur) -> {
            auteurComboModel.addElement(auteur);
        });
        
        auteurCB.setModel(auteurComboModel);
    }
    
//    public void setLangueList(List<Langue> list) {
//        langueComboModel.removeAllElements();
//        
//        list.stream().forEach((langue) -> {
//            langueComboModel.addElement(langue);
//        });
//        
//        langueCB.setModel(langueComboModel);
//    }
    
    public void setCoAuteurList(List<Auteur> list) {
        coAuteurComboModel.removeAllElements();
        coAuteurComboModel.addElement(null);
        
        list.stream().forEach((auteur) -> {
            coAuteurComboModel.addElement(auteur);
        });
        
        coAuteurCB1.setModel(coAuteurComboModel);
        coAuteurCB1.setSelectedItem(null);
    }
    
    public Ouvrage getOuvrage(){
        Ouvrage ouvrage = new Ouvrage();
        
        ouvrage.setTitre(titreTF.getText().trim());
        ouvrage.setSousTitre(sousTitreTF.getText().trim());
        
        ouvrage.setAuteur((Auteur) auteurCB.getSelectedItem());
        ouvrage.addCoAuteur((Auteur) coAuteurCB1.getSelectedItem());
//        ouvrage.setLangue((Langue) langueCB.getSelectedItem());
        ouvrage.setResume(resumeTP.getText().trim());
//        ouvrage.setCoAuteurs();
        ouvrage.setGenres(null);
        ouvrage.setTags(null);
        ouvrage.setRubriques(null);
        
        return ouvrage;
    }

}
