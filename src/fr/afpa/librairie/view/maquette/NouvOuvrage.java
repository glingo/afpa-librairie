package fr.afpa.librairie.view.maquette;

import fr.afpa.librairie.data.bean.*;
import java.awt.*;
import java.sql.*;
import java.util.*;
import javax.swing.*;

public class NouvOuvrage extends javax.swing.JFrame {

    Long identifiantOuvrage = 0l;

    long myAuthorId = 0l;
    long myGenreId = 0l;
    long myThemeId = 0l;
    long myCoAuteurId = 0l;
    long myLangueId = 0l;
    long myTagId = 0l;
    long myRubriqueId = 0l;

    ArrayList<Long> myALTheme = new ArrayList<>();
    ArrayList<Long> myALCoAuteur = new ArrayList<>();
    ArrayList<Long> myALTag = new ArrayList<>();
    ArrayList<Long> myALRubrique = new ArrayList<>();

    public NouvOuvrage() {
        initComponents();
        setLocationRelativeTo(null);
        this.setMinimumSize(new Dimension(600, 800));
        this.setPreferredSize(new Dimension(600, 800));
        nouvelOuvrageLB.setHorizontalAlignment(SwingConstants.CENTER);
//        jPanel4.setVisible(false);
//        jPanel5.setVisible(false);
//        footerModel1.setVisible(false);
    }

    //comboBox Auteur
    private DefaultComboBoxModel initModelAuteur() {
        return new DefaultComboBoxModel(initVectorAuteur());
    }

    private Vector initVectorAuteur() {
        VectorGenerator vg = new VectorGenerator();
        return vg.genererVector("Auteur", "idAuteur", "nom", "prenom");//extrait les elements du vector depuis la bdd
    }

    //comboBox Genre
    private DefaultComboBoxModel initModelGenre() {
        return new DefaultComboBoxModel(initVectorGenre());
    }

    private Vector initVectorGenre() {
        VectorGenerator vg = new VectorGenerator();
        return vg.genererVector("Genre", "idGenre", "libelle");
    }

    //comboBox Theme
    private DefaultComboBoxModel initModelTheme() {
        return new DefaultComboBoxModel(initVectorTheme());
    }

    private Vector initVectorTheme() {
        VectorGenerator vg = new VectorGenerator();
        return vg.genererVector("Theme", "idTheme", "libelle");
    }

    //combobox "resultat" general: se remplit lorsqu'on clique sur les valeurs du combobox dont il depend
    private DefaultComboBoxModel initModelLangue() {
        return new DefaultComboBoxModel(initVectorLangue());
    }

    private Vector initVectorLangue() {
        VectorGenerator vg = new VectorGenerator();
        return vg.genererVector("Langue", "idLangue", "libelle");
    }

    //combobox "resultat" general: se remplit lorsqu'on clique sur les valeurs du combobox dont il depend
    private DefaultComboBoxModel initModelTag() {
        return new DefaultComboBoxModel(initVectorTag());
    }

    private Vector initVectorTag() {
        VectorGenerator vg = new VectorGenerator();
        return vg.genererVector("Tag", "idTag", "libelle");
    }

    //combobox "resultat" general: se remplit lorsqu'on clique sur les valeurs du combobox dont il depend
    private DefaultComboBoxModel initModelRubrique() {
        return new DefaultComboBoxModel(initVectorRubrique());
    }

    private Vector initVectorRubrique() {
        VectorGenerator vg = new VectorGenerator();
        return vg.genererVector("Rubrique", "idRubrique", "libelle");
    }

    //combobox "resultat" general: se remplit lorsqu'on clique sur les valeurs du combobox dont il depend
    private <T> void ajoutCB(T g, JComboBox jcb, DefaultComboBoxModel dcm) {
        dcm.addElement(g);
        jcb.setModel(dcm);
        dcm.setSelectedItem(g);
    }

//    private void delete(int index) {
//        dcm.removeElementAt(index);
//    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jPanel6 = new javax.swing.JPanel();
        jTextField3 = new javax.swing.JTextField();
        mainPanel = new javax.swing.JPanel();
        titlePanel = new javax.swing.JPanel();
        nouvelOuvrageLB = new javax.swing.JLabel();
        auteurPanel = new javax.swing.JPanel();
        auteurCB = new javax.swing.JComboBox();
        auteurLB = new javax.swing.JLabel();
        auteurResLB = new javax.swing.JLabel();
        bodyPanel1 = new javax.swing.JPanel();
        titreLB = new javax.swing.JLabel();
        titreTF = new javax.swing.JTextField();
        champObligLB = new javax.swing.JLabel();
        sousTitreLB = new javax.swing.JLabel();
        sousTitreTF = new javax.swing.JTextField();
        resumeLB = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        resumeTP = new javax.swing.JTextArea();
        footerModel1 = new fr.afpa.librairie.view.maquette.FooterModel();
        bodyPanel2 = new javax.swing.JPanel();
        genreCB = new javax.swing.JComboBox();
        genreLB = new javax.swing.JLabel();
        themeCB2 = new javax.swing.JComboBox();
        genreResLB = new javax.swing.JLabel();
        themesLB = new javax.swing.JLabel();
        themeCB1 = new javax.swing.JComboBox();
        coAuteursLB = new javax.swing.JLabel();
        coAuteurCB1 = new javax.swing.JComboBox();
        coAuteursCB2 = new javax.swing.JComboBox();
        langueLB = new javax.swing.JLabel();
        langueCB = new javax.swing.JComboBox();
        langueResLB = new javax.swing.JLabel();
        tagLB = new javax.swing.JLabel();
        tagCB1 = new javax.swing.JComboBox();
        tagCB2 = new javax.swing.JComboBox();
        rubriquesLB = new javax.swing.JLabel();
        rubriqueCB1 = new javax.swing.JComboBox();
        rubriqueCB2 = new javax.swing.JComboBox();

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        jTextField3.setText("jTextField3");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        mainPanel.setBackground(java.awt.Color.darkGray);

        titlePanel.setBackground(java.awt.Color.darkGray);
        titlePanel.setBorder(javax.swing.BorderFactory.createLineBorder(java.awt.Color.lightGray));

        nouvelOuvrageLB.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        nouvelOuvrageLB.setForeground(java.awt.Color.lightGray);
        nouvelOuvrageLB.setText("Nouvel Ouvrage");

        javax.swing.GroupLayout titlePanelLayout = new javax.swing.GroupLayout(titlePanel);
        titlePanel.setLayout(titlePanelLayout);
        titlePanelLayout.setHorizontalGroup(
            titlePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, titlePanelLayout.createSequentialGroup()
                .addGap(93, 93, 93)
                .addComponent(nouvelOuvrageLB, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(85, 85, 85))
        );
        titlePanelLayout.setVerticalGroup(
            titlePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(titlePanelLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(nouvelOuvrageLB)
                .addContainerGap(15, Short.MAX_VALUE))
        );

        auteurPanel.setBackground(java.awt.Color.darkGray);
        auteurPanel.setForeground(java.awt.Color.lightGray);

        auteurCB.setBackground(java.awt.Color.gray);
        auteurCB.setForeground(java.awt.Color.lightGray);
        auteurCB.setModel(initModelAuteur());
        auteurCB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboBox1ActionClicSouris(evt);
            }
        });

        auteurLB.setForeground(java.awt.Color.lightGray);
        auteurLB.setText("* Auteur ");

        auteurResLB.setForeground(java.awt.Color.lightGray);
        auteurResLB.setBorder(javax.swing.BorderFactory.createLineBorder(java.awt.Color.lightGray));

        javax.swing.GroupLayout auteurPanelLayout = new javax.swing.GroupLayout(auteurPanel);
        auteurPanel.setLayout(auteurPanelLayout);
        auteurPanelLayout.setHorizontalGroup(
            auteurPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(auteurPanelLayout.createSequentialGroup()
                .addComponent(auteurLB, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addComponent(auteurCB, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(auteurResLB, javax.swing.GroupLayout.DEFAULT_SIZE, 153, Short.MAX_VALUE)
                .addContainerGap())
        );
        auteurPanelLayout.setVerticalGroup(
            auteurPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, auteurPanelLayout.createSequentialGroup()
                .addContainerGap(20, Short.MAX_VALUE)
                .addGroup(auteurPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(auteurResLB, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(auteurPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(auteurCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(auteurLB)))
                .addGap(10, 10, 10))
        );

        bodyPanel1.setBackground(java.awt.Color.darkGray);
        bodyPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(java.awt.Color.lightGray));

        titreLB.setForeground(java.awt.Color.lightGray);
        titreLB.setText("* Titre");

        titreTF.setBackground(java.awt.Color.lightGray);

        champObligLB.setFont(new java.awt.Font("Dialog", 0, 10)); // NOI18N
        champObligLB.setForeground(java.awt.Color.lightGray);
        champObligLB.setText("* Champ obligatoire");

        sousTitreLB.setForeground(java.awt.Color.lightGray);
        sousTitreLB.setText("Sous-titre");

        sousTitreTF.setBackground(java.awt.Color.lightGray);

        resumeLB.setBackground(java.awt.Color.darkGray);
        resumeLB.setForeground(java.awt.Color.lightGray);
        resumeLB.setText("* Résumé");

        resumeTP.setBackground(java.awt.Color.lightGray);
        resumeTP.setColumns(20);
        resumeTP.setRows(5);
        jScrollPane2.setViewportView(resumeTP);

        javax.swing.GroupLayout bodyPanel1Layout = new javax.swing.GroupLayout(bodyPanel1);
        bodyPanel1.setLayout(bodyPanel1Layout);
        bodyPanel1Layout.setHorizontalGroup(
            bodyPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bodyPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(bodyPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(resumeLB, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(sousTitreLB, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(champObligLB, javax.swing.GroupLayout.DEFAULT_SIZE, 131, Short.MAX_VALUE)
                    .addComponent(titreLB, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(27, 27, 27)
                .addGroup(bodyPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(titreTF)
                    .addComponent(sousTitreTF)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 338, Short.MAX_VALUE))
                .addContainerGap())
        );
        bodyPanel1Layout.setVerticalGroup(
            bodyPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bodyPanel1Layout.createSequentialGroup()
                .addGroup(bodyPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(bodyPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(champObligLB))
                    .addGroup(bodyPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(bodyPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(titreTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(titreLB))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(bodyPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(sousTitreTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sousTitreLB))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 16, Short.MAX_VALUE)
                .addGroup(bodyPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(resumeLB))
                .addContainerGap())
        );

        bodyPanel2.setBackground(java.awt.Color.darkGray);
        bodyPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(java.awt.Color.lightGray));

        genreCB.setBackground(java.awt.Color.gray);
        genreCB.setModel(initModelGenre());
        genreCB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                genreCBActionPerformed(evt);
            }
        });

        genreLB.setForeground(java.awt.Color.lightGray);
        genreLB.setText("Genre");

        themeCB2.setBackground(java.awt.Color.gray);
        themeCB2.setForeground(java.awt.Color.black);

        genreResLB.setBackground(java.awt.Color.lightGray);
        genreResLB.setForeground(java.awt.Color.lightGray);
        genreResLB.setBorder(javax.swing.BorderFactory.createLineBorder(java.awt.Color.lightGray));

        themesLB.setForeground(java.awt.Color.lightGray);
        themesLB.setText("Themes");

        themeCB1.setBackground(java.awt.Color.gray);
        themeCB1.setModel(initModelTheme());
        themeCB1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                themeCB1ActionPerformed(evt);
            }
        });

        coAuteursLB.setForeground(java.awt.Color.lightGray);
        coAuteursLB.setText("Co-Auteur(s)");

        coAuteurCB1.setBackground(java.awt.Color.gray);
        coAuteurCB1.setModel(initModelAuteur());
        coAuteurCB1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                coAuteurCB1ActionPerformed(evt);
            }
        });

        coAuteursCB2.setBackground(java.awt.Color.gray);
        coAuteursCB2.setForeground(java.awt.Color.black);

        langueLB.setForeground(java.awt.Color.lightGray);
        langueLB.setText("Langue");

        langueCB.setBackground(java.awt.Color.gray);
        langueCB.setModel(initModelLangue());
        langueCB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                langueCBActionPerformed(evt);
            }
        });

        langueResLB.setForeground(java.awt.Color.lightGray);
        langueResLB.setBorder(javax.swing.BorderFactory.createLineBorder(java.awt.Color.lightGray));

        tagLB.setForeground(java.awt.Color.lightGray);
        tagLB.setText("Tags");

        tagCB1.setBackground(java.awt.Color.gray);
        tagCB1.setModel(initModelTag());
        tagCB1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tagCB1ActionPerformed(evt);
            }
        });

        tagCB2.setBackground(java.awt.Color.gray);
        tagCB2.setForeground(java.awt.Color.black);

        rubriquesLB.setForeground(java.awt.Color.lightGray);
        rubriquesLB.setText("Rubriques");

        rubriqueCB1.setBackground(java.awt.Color.gray);
        rubriqueCB1.setModel(initModelRubrique());
        rubriqueCB1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rubriqueCB1ActionPerformed(evt);
            }
        });

        rubriqueCB2.setBackground(java.awt.Color.gray);
        rubriqueCB2.setForeground(java.awt.Color.black);

        javax.swing.GroupLayout bodyPanel2Layout = new javax.swing.GroupLayout(bodyPanel2);
        bodyPanel2.setLayout(bodyPanel2Layout);
        bodyPanel2Layout.setHorizontalGroup(
            bodyPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bodyPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(bodyPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(rubriquesLB, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(langueLB, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(coAuteursLB, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(themesLB, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(genreLB, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE)
                    .addComponent(tagLB, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(32, 32, 32)
                .addGroup(bodyPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(genreCB, 0, 169, Short.MAX_VALUE)
                    .addComponent(themeCB1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(coAuteurCB1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(langueCB, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(tagCB1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(rubriqueCB1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(bodyPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tagCB2, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(themeCB2, 0, 169, Short.MAX_VALUE)
                    .addComponent(genreResLB, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(coAuteursCB2, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(langueResLB, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(rubriqueCB2, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        bodyPanel2Layout.setVerticalGroup(
            bodyPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, bodyPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(bodyPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(coAuteursLB)
                    .addComponent(coAuteurCB1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(coAuteursCB2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(bodyPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(bodyPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(langueResLB, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(langueCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(langueLB))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(bodyPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(bodyPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(genreLB)
                        .addComponent(genreCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(genreResLB, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(bodyPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(themesLB)
                    .addComponent(themeCB1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(themeCB2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(bodyPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tagLB)
                    .addComponent(tagCB1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tagCB2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(bodyPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rubriquesLB)
                    .addComponent(rubriqueCB1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rubriqueCB2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(18, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout mainPanelLayout = new javax.swing.GroupLayout(mainPanel);
        mainPanel.setLayout(mainPanelLayout);
        mainPanelLayout.setHorizontalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mainPanelLayout.createSequentialGroup()
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(mainPanelLayout.createSequentialGroup()
                        .addContainerGap(393, Short.MAX_VALUE)
                        .addComponent(footerModel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(mainPanelLayout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(bodyPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(bodyPanel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(auteurPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(titlePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(34, 34, 34))
        );
        mainPanelLayout.setVerticalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(titlePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(auteurPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(bodyPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(bodyPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(footerModel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
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
    }// </editor-fold>//GEN-END:initComponents

    public void fillDataBase() {

        MyConnection myConnect = new MyConnection();
        Connection c = null;
        c = myConnect.opening();

        //enregistre l'ouvrage ds la bdd
        try {//requete
            String query = "INSERT INTO Ouvrage VALUES ( ?, ?, ?, ?)";
            PreparedStatement stmt = c.prepareStatement(query);
            stmt.setLong(1, myAuthorId);
            stmt.setString(2, titreTF.getText());
            stmt.setString(3, sousTitreTF.getText());
            stmt.setString(4, resumeTP.getText());

            stmt.executeUpdate();

            stmt.close();

        } catch (SQLException ex) {
            System.err.println("Oops:SQL:" + ex.getErrorCode() + "/" + ex.getMessage());
        }

////////////////////////////////////////////////////////////////////////////////
        //recupere l'id de l'ouvrage
        try {//requete
            Statement stmt = c.createStatement();
            String query = "SELECT TOP 1 idOuvrage FROM Ouvrage ORDER BY idOuvrage DESC";
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {
                identifiantOuvrage = rs.getLong("idOuvrage");
            }

        } catch (SQLException exp) {
            System.err.println("Oops:SQL:" + exp.getErrorCode() + "/" + exp.getMessage());
        }

//////////////////////////////////////////////////////////////////////////////// 
        supprimeDoublons(myALTheme);
        supprimeDoublons(myALCoAuteur);
        supprimeDoublons(myALTag);
        supprimeDoublons(myALRubrique);

        remplitJointures(myALTheme, c, "Thematique");
        remplitJointures(myALCoAuteur, c, "CoAuteur");
        remplitJointures(myALTag, c, "Referencement");
        remplitJointures(myALRubrique, c, "MiseEnRubrique");

        System.out.println("Nouvel ouvrage ajoute a la bdd");

        titreTF.setText("");
        sousTitreTF.setText("");
        resumeTP.setText("");
        langueResLB.setText("");
        genreResLB.setText("");
        coAuteursCB2.removeAllItems();
        themeCB2.removeAllItems();
        tagCB2.removeAllItems();
        rubriqueCB2.removeAllItems();
//            jPanel4.setVisible(false);
//            jPanel5.setVisible(false);
//            footerModel1.setVisible(false);

        myConnect.closing();
    }

    public void quitter() {
        dispose();
    }

    public void remplitJointures(ArrayList myAL, Connection c, String table) {
        System.out.println("");
        if (myAL.size() > 0) {
            try {
                String query = "INSERT INTO " + table + " VALUES ( ?, ?)";
                PreparedStatement stmt = c.prepareStatement(query);
                for (int i = 0; i < myAL.size(); i++) {
                    stmt.setLong(1, (Long) myAL.get(i));
                    stmt.setLong(2, identifiantOuvrage);

                    stmt.executeUpdate();
                }
                stmt.close();

            } catch (SQLException ex) {
                System.err.println("Oops:SQL:" + ex.getErrorCode() + "/" + ex.getMessage());
            }
        }
    }

    private void comboBox1ActionClicSouris(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboBox1ActionClicSouris
        recupInfoAuteur();
    }//GEN-LAST:event_comboBox1ActionClicSouris

    private void genreCBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_genreCBActionPerformed
        Genre g = new Genre();
        myGenreId = recupGalLabel(g, genreCB, genreResLB, myGenreId);
    }//GEN-LAST:event_genreCBActionPerformed

    DefaultComboBoxModel dcmTheme = new DefaultComboBoxModel();
    private void themeCB1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_themeCB1ActionPerformed
        Theme t = new Theme();
        myThemeId = recupGalCombo(t, themeCB1, themeCB2, myCoAuteurId, dcmTheme);
        myALTheme.add(myThemeId);
    }//GEN-LAST:event_themeCB1ActionPerformed

    DefaultComboBoxModel dcmCoAuteur = new DefaultComboBoxModel();
    private void coAuteurCB1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_coAuteurCB1ActionPerformed
        Auteur a = new Auteur();
        myCoAuteurId = recupGalCombo(a, coAuteurCB1, coAuteursCB2, myCoAuteurId, dcmCoAuteur);
        myALCoAuteur.add(myCoAuteurId);
    }//GEN-LAST:event_coAuteurCB1ActionPerformed

    DefaultComboBoxModel dcmTag = new DefaultComboBoxModel();
    private void tagCB1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tagCB1ActionPerformed
        Tag t = new Tag();
        myTagId = recupGalCombo(t, tagCB1, tagCB2, myTagId, dcmTag);
        myALTag.add(myTagId);
    }//GEN-LAST:event_tagCB1ActionPerformed
    
    DefaultComboBoxModel dcmRubrique = new DefaultComboBoxModel();
    private void rubriqueCB1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rubriqueCB1ActionPerformed
        Rubrique r = new Rubrique();
        myRubriqueId = recupGalCombo(r, rubriqueCB1, rubriqueCB2, myRubriqueId, dcmRubrique);
        myALRubrique.add(myRubriqueId);
    }//GEN-LAST:event_rubriqueCB1ActionPerformed

    private void langueCBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_langueCBActionPerformed
        Langue l = new Langue();
        myLangueId = recupGalLabel(l, langueCB, langueResLB, myLangueId);
    }//GEN-LAST:event_langueCBActionPerformed

    public <T> Long recupGalCombo(T t, JComboBox jcb1, JComboBox jcb2, Long l, DefaultComboBoxModel dcm) {
        ClasseConstructorPourVector ccpv = (ClasseConstructorPourVector) jcb1.getSelectedItem();
        l = ccpv.getId();
        t = (T) ccpv;
        ajoutCB(t, jcb2, dcm);
        return l;
    }

    public <T> Long recupGalLabel(T t, JComboBox jcb1, JLabel jlb1, Long l) {
        ClasseConstructorPourVector ccpv = (ClasseConstructorPourVector) jcb1.getSelectedItem();
        l = ccpv.getId();
        jlb1.setText("  " + ccpv.getColonne1());
        return l;
    }

    //recupere l'objet Auteur sur lequel on a clique ds le combobox auteur
    public void recupInfoAuteur() {
        bodyPanel1.setVisible(true);
        bodyPanel2.setVisible(true);
        footerModel1.setVisible(true);

        ClasseConstructorPourVector ccpv = (ClasseConstructorPourVector) auteurCB.getSelectedItem();
        myAuthorId = ccpv.getId();//recupere l'id de l'auteur
        System.out.println(ccpv.getClasse() + " " + ccpv.getId() + " " + ccpv.getColonne1() + " " + ccpv.getColonne2());

        auteurResLB.setText("  "+ ccpv.getColonne1() + " " + ccpv.getColonne2());
    }

    //supprime les doublons d'une arraylist
    public void supprimeDoublons(ArrayList AL) {
        Set mySet = new HashSet<Long>();
        mySet.addAll(AL);
        AL.removeAll(AL);
        AL.addAll(mySet);
    }

    public void mesTests() {

        System.out.println("myAuteurId : " + myAuthorId);

        System.out.println("myLangueId : " + myLangueId);
        System.out.println("myGenreId : " + myGenreId);

        supprimeDoublons(myALTheme);
        supprimeDoublons(myALCoAuteur);
        supprimeDoublons(myALTag);
        supprimeDoublons(myALRubrique);

        System.out.println("myALTheme : " + myALTheme);
        System.out.println("myALCoAuteur : " + myALCoAuteur);
        System.out.println("myALTag : " + myALTag);
        System.out.println("myALRubrique : " + myALRubrique);

        System.out.println("Identifiant ouvrage : " + identifiantOuvrage);

        titreTF.setText("");
        sousTitreTF.setText("");
        resumeTP.setText("");
        langueResLB.setText("");
        genreResLB.setText("");
        auteurResLB.setText("");

        coAuteursCB2.removeAllItems();
        themeCB2.removeAllItems();
        tagCB2.removeAllItems();
        rubriqueCB2.removeAllItems();

    }

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;

                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(NouvOuvrage.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NouvOuvrage.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NouvOuvrage.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NouvOuvrage.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new NouvOuvrage().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox auteurCB;
    private javax.swing.JLabel auteurLB;
    private javax.swing.JPanel auteurPanel;
    private javax.swing.JLabel auteurResLB;
    private javax.swing.JPanel bodyPanel1;
    private javax.swing.JPanel bodyPanel2;
    private javax.swing.JLabel champObligLB;
    private javax.swing.JComboBox coAuteurCB1;
    private javax.swing.JComboBox coAuteursCB2;
    private javax.swing.JLabel coAuteursLB;
    private fr.afpa.librairie.view.maquette.FooterModel footerModel1;
    private javax.swing.JComboBox genreCB;
    private javax.swing.JLabel genreLB;
    private javax.swing.JLabel genreResLB;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JComboBox langueCB;
    private javax.swing.JLabel langueLB;
    private javax.swing.JLabel langueResLB;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JLabel nouvelOuvrageLB;
    private javax.swing.JLabel resumeLB;
    private javax.swing.JTextArea resumeTP;
    private javax.swing.JComboBox rubriqueCB1;
    private javax.swing.JComboBox rubriqueCB2;
    private javax.swing.JLabel rubriquesLB;
    private javax.swing.JLabel sousTitreLB;
    private javax.swing.JTextField sousTitreTF;
    private javax.swing.JComboBox tagCB1;
    private javax.swing.JComboBox tagCB2;
    private javax.swing.JLabel tagLB;
    private javax.swing.JComboBox themeCB1;
    private javax.swing.JComboBox themeCB2;
    private javax.swing.JLabel themesLB;
    private javax.swing.JPanel titlePanel;
    private javax.swing.JLabel titreLB;
    private javax.swing.JTextField titreTF;
    // End of variables declaration//GEN-END:variables

}
