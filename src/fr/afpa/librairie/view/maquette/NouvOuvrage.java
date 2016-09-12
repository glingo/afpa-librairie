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
        jLabel1.setHorizontalAlignment(SwingConstants.CENTER);
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
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jComboBox1 = new javax.swing.JComboBox();
        jLabel2 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea2 = new javax.swing.JTextArea();
        footerModel1 = new fr.afpa.librairie.view.maquette.FooterModel();
        jPanel5 = new javax.swing.JPanel();
        jComboBox2 = new javax.swing.JComboBox();
        jLabel7 = new javax.swing.JLabel();
        jComboBox3 = new javax.swing.JComboBox();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jComboBox4 = new javax.swing.JComboBox();
        jLabel10 = new javax.swing.JLabel();
        jComboBox5 = new javax.swing.JComboBox();
        jComboBox6 = new javax.swing.JComboBox();
        jLabel11 = new javax.swing.JLabel();
        jComboBox7 = new javax.swing.JComboBox();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jComboBox8 = new javax.swing.JComboBox();
        jComboBox9 = new javax.swing.JComboBox();
        jLabel14 = new javax.swing.JLabel();
        jComboBox10 = new javax.swing.JComboBox();
        jComboBox11 = new javax.swing.JComboBox();

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

        jPanel1.setBackground(java.awt.Color.darkGray);

        jPanel2.setBackground(java.awt.Color.darkGray);
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(java.awt.Color.lightGray));

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel1.setForeground(java.awt.Color.lightGray);
        jLabel1.setText("Nouvel Ouvrage");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(93, 93, 93)
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(85, 85, 85))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel1)
                .addContainerGap(15, Short.MAX_VALUE))
        );

        jPanel3.setBackground(java.awt.Color.darkGray);
        jPanel3.setForeground(java.awt.Color.lightGray);

        jComboBox1.setBackground(java.awt.Color.gray);
        jComboBox1.setForeground(java.awt.Color.lightGray);
        jComboBox1.setModel(initModelAuteur());
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboBox1ActionClicSouris(evt);
            }
        });

        jLabel2.setForeground(java.awt.Color.lightGray);
        jLabel2.setText("* Auteur ");

        jLabel15.setForeground(java.awt.Color.lightGray);
        jLabel15.setBorder(javax.swing.BorderFactory.createLineBorder(java.awt.Color.lightGray));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel15, javax.swing.GroupLayout.DEFAULT_SIZE, 153, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(20, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10))
        );

        jPanel4.setBackground(java.awt.Color.darkGray);
        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(java.awt.Color.lightGray));

        jLabel3.setForeground(java.awt.Color.lightGray);
        jLabel3.setText("* Titre");

        jTextField1.setBackground(java.awt.Color.lightGray);

        jLabel4.setFont(new java.awt.Font("Dialog", 0, 10)); // NOI18N
        jLabel4.setForeground(java.awt.Color.lightGray);
        jLabel4.setText("* Champ obligatoire");

        jLabel5.setForeground(java.awt.Color.lightGray);
        jLabel5.setText("Sous-titre");

        jTextField2.setBackground(java.awt.Color.lightGray);

        jLabel6.setBackground(java.awt.Color.darkGray);
        jLabel6.setForeground(java.awt.Color.lightGray);
        jLabel6.setText("* Résumé");

        jTextArea2.setBackground(java.awt.Color.lightGray);
        jTextArea2.setColumns(20);
        jTextArea2.setRows(5);
        jScrollPane2.setViewportView(jTextArea2);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 131, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(27, 27, 27)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextField1)
                    .addComponent(jTextField2)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 338, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel4))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 16, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addContainerGap())
        );

        jPanel5.setBackground(java.awt.Color.darkGray);
        jPanel5.setBorder(javax.swing.BorderFactory.createLineBorder(java.awt.Color.lightGray));

        jComboBox2.setBackground(java.awt.Color.gray);
        jComboBox2.setModel(initModelGenre());
        jComboBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox2ActionPerformed(evt);
            }
        });

        jLabel7.setForeground(java.awt.Color.lightGray);
        jLabel7.setText("Genre");

        jComboBox3.setBackground(java.awt.Color.gray);
        jComboBox3.setForeground(java.awt.Color.black);

        jLabel8.setBackground(java.awt.Color.lightGray);
        jLabel8.setForeground(java.awt.Color.lightGray);
        jLabel8.setBorder(javax.swing.BorderFactory.createLineBorder(java.awt.Color.lightGray));

        jLabel9.setForeground(java.awt.Color.lightGray);
        jLabel9.setText("Theme");

        jComboBox4.setBackground(java.awt.Color.gray);
        jComboBox4.setModel(initModelTheme());
        jComboBox4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox4ActionPerformed(evt);
            }
        });

        jLabel10.setForeground(java.awt.Color.lightGray);
        jLabel10.setText("Co-Auteur(s)");

        jComboBox5.setBackground(java.awt.Color.gray);
        jComboBox5.setModel(initModelAuteur());
        jComboBox5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox5ActionPerformed(evt);
            }
        });

        jComboBox6.setBackground(java.awt.Color.gray);
        jComboBox6.setForeground(java.awt.Color.black);

        jLabel11.setForeground(java.awt.Color.lightGray);
        jLabel11.setText("Langue");

        jComboBox7.setBackground(java.awt.Color.gray);
        jComboBox7.setModel(initModelLangue());
        jComboBox7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox7ActionPerformed(evt);
            }
        });

        jLabel12.setForeground(java.awt.Color.lightGray);
        jLabel12.setBorder(javax.swing.BorderFactory.createLineBorder(java.awt.Color.lightGray));

        jLabel13.setForeground(java.awt.Color.lightGray);
        jLabel13.setText("Tags");

        jComboBox8.setBackground(java.awt.Color.gray);
        jComboBox8.setModel(initModelTag());
        jComboBox8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox8ActionPerformed(evt);
            }
        });

        jComboBox9.setBackground(java.awt.Color.gray);
        jComboBox9.setForeground(java.awt.Color.black);

        jLabel14.setForeground(java.awt.Color.lightGray);
        jLabel14.setText("Rubriques");

        jComboBox10.setBackground(java.awt.Color.gray);
        jComboBox10.setModel(initModelRubrique());
        jComboBox10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox10ActionPerformed(evt);
            }
        });

        jComboBox11.setBackground(java.awt.Color.gray);
        jComboBox11.setForeground(java.awt.Color.black);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE)
                    .addComponent(jLabel13, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(32, 32, 32)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jComboBox2, 0, 169, Short.MAX_VALUE)
                    .addComponent(jComboBox4, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jComboBox5, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jComboBox7, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jComboBox8, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jComboBox10, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jComboBox9, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jComboBox3, 0, 169, Short.MAX_VALUE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jComboBox6, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jComboBox11, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(jComboBox5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel12, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jComboBox7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel11))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel7)
                        .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(jComboBox4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(jComboBox8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(jComboBox10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(18, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(footerModel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(34, 34, 34))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(footerModel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
            stmt.setString(2, jTextField1.getText());
            stmt.setString(3, jTextField2.getText());
            stmt.setString(4, jTextArea2.getText());

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

        jTextField1.setText("");
        jTextField2.setText("");
        jTextArea2.setText("");
        jLabel12.setText("");
        jLabel8.setText("");
        jComboBox6.removeAllItems();
        jComboBox3.removeAllItems();
        jComboBox9.removeAllItems();
        jComboBox11.removeAllItems();
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

    private void jComboBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox2ActionPerformed
        Genre g = new Genre();
        myGenreId = recupGalLabel(g, jComboBox2, jLabel8, myGenreId);
    }//GEN-LAST:event_jComboBox2ActionPerformed

    DefaultComboBoxModel dcmTheme = new DefaultComboBoxModel();
    private void jComboBox4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox4ActionPerformed
        Theme t = new Theme();
        myThemeId = recupGalCombo(t, jComboBox4, jComboBox3, myCoAuteurId, dcmTheme);
        myALTheme.add(myThemeId);
    }//GEN-LAST:event_jComboBox4ActionPerformed

    DefaultComboBoxModel dcmCoAuteur = new DefaultComboBoxModel();
    private void jComboBox5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox5ActionPerformed
        Auteur a = new Auteur();
        myCoAuteurId = recupGalCombo(a, jComboBox5, jComboBox6, myCoAuteurId, dcmCoAuteur);
        myALCoAuteur.add(myCoAuteurId);
    }//GEN-LAST:event_jComboBox5ActionPerformed

    DefaultComboBoxModel dcmTag = new DefaultComboBoxModel();
    private void jComboBox8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox8ActionPerformed
        Tag t = new Tag();
        myTagId = recupGalCombo(t, jComboBox8, jComboBox9, myTagId, dcmTag);
        myALTag.add(myTagId);
    }//GEN-LAST:event_jComboBox8ActionPerformed
    
    DefaultComboBoxModel dcmRubrique = new DefaultComboBoxModel();
    private void jComboBox10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox10ActionPerformed
        Rubrique r = new Rubrique();
        myRubriqueId = recupGalCombo(r, jComboBox10, jComboBox11, myRubriqueId, dcmRubrique);
        myALRubrique.add(myRubriqueId);
    }//GEN-LAST:event_jComboBox10ActionPerformed

    private void jComboBox7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox7ActionPerformed
        Langue l = new Langue();
        myLangueId = recupGalLabel(l, jComboBox7, jLabel12, myLangueId);
    }//GEN-LAST:event_jComboBox7ActionPerformed

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
        jPanel4.setVisible(true);
        jPanel5.setVisible(true);
        footerModel1.setVisible(true);

        ClasseConstructorPourVector ccpv = (ClasseConstructorPourVector) jComboBox1.getSelectedItem();
        myAuthorId = ccpv.getId();//recupere l'id de l'auteur
        System.out.println(ccpv.getClasse() + " " + ccpv.getId() + " " + ccpv.getColonne1() + " " + ccpv.getColonne2());

        jLabel15.setText("  "+ ccpv.getColonne1() + " " + ccpv.getColonne2());
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

        jTextField1.setText("");
        jTextField2.setText("");
        jTextArea2.setText("");
        jLabel12.setText("");
        jLabel8.setText("");
        jLabel15.setText("");

        jComboBox6.removeAllItems();
        jComboBox3.removeAllItems();
        jComboBox9.removeAllItems();
        jComboBox11.removeAllItems();

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
    private fr.afpa.librairie.view.maquette.FooterModel footerModel1;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JComboBox jComboBox10;
    private javax.swing.JComboBox jComboBox11;
    private javax.swing.JComboBox jComboBox2;
    private javax.swing.JComboBox jComboBox3;
    private javax.swing.JComboBox jComboBox4;
    private javax.swing.JComboBox jComboBox5;
    private javax.swing.JComboBox jComboBox6;
    private javax.swing.JComboBox jComboBox7;
    private javax.swing.JComboBox jComboBox8;
    private javax.swing.JComboBox jComboBox9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextArea jTextArea2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    // End of variables declaration//GEN-END:variables

}
