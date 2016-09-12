package fr.afpa.librairie.view.maquette;

import fr.afpa.librairie.data.bean.*;
import java.awt.*;
import javax.swing.*;
import java.sql.*;
import java.util.*;

public class NouvEdition extends javax.swing.JFrame {

    private long idOuvrage = 0l;

    public NouvEdition() {
        initComponents();
        setLocationRelativeTo(null);
        this.setMinimumSize(new Dimension(600, 700));
        this.setPreferredSize(new Dimension(600, 700));
        nouvelleEditionLB.setHorizontalAlignment(SwingConstants.CENTER);
    }

    private DefaultComboBoxModel initModelAuteur() {
        return new DefaultComboBoxModel(initVectorOuvrage());
    }

    private Vector initVectorOuvrage() {
        VectorGenerator vg = new VectorGenerator();
        return vg.genererVector("Ouvrage", "idOuvrage", "titre", "sous_titre");//extrait les elements du vector depuis la bdd
    }
    
        private DefaultComboBoxModel initModelLangue() {
        return new DefaultComboBoxModel(initVectorLangue());
    }

    private Vector initVectorLangue() {
        VectorGenerator vg = new VectorGenerator();
        return vg.genererVector("Langue", "idLangue", "libelle");//extrait les elements du vector depuis la bdd
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mainPanel = new javax.swing.JPanel();
        titlePanel = new javax.swing.JPanel();
        nouvelleEditionLB = new javax.swing.JLabel();
        bodyPanel = new javax.swing.JPanel();
        ouvrageLB = new javax.swing.JLabel();
        ouvrageCB = new javax.swing.JComboBox();
        ouvrageResLB = new javax.swing.JLabel();
        langueResLB = new javax.swing.JLabel();
        langueCB = new javax.swing.JComboBox();
        langueLB = new javax.swing.JLabel();
        isbnLB = new javax.swing.JLabel();
        isbnTF = new javax.swing.JTextField();
        titreLB = new javax.swing.JLabel();
        titreTF = new javax.swing.JTextField();
        dateLB = new javax.swing.JLabel();
        dateTF = new javax.swing.JTextField();
        prixLB = new javax.swing.JLabel();
        prixTF = new javax.swing.JTextField();
        stockLB = new javax.swing.JLabel();
        stockTF = new javax.swing.JTextField();
        couvertureLB = new javax.swing.JLabel();
        couvertureTF = new javax.swing.JTextField();
        footerModel1 = new fr.afpa.librairie.view.maquette.FooterModel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        mainPanel.setBackground(java.awt.Color.darkGray);

        titlePanel.setBackground(java.awt.Color.darkGray);
        titlePanel.setBorder(javax.swing.BorderFactory.createLineBorder(java.awt.Color.lightGray));

        nouvelleEditionLB.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        nouvelleEditionLB.setForeground(java.awt.Color.lightGray);
        nouvelleEditionLB.setText("Nouvelle Edition");

        javax.swing.GroupLayout titlePanelLayout = new javax.swing.GroupLayout(titlePanel);
        titlePanel.setLayout(titlePanelLayout);
        titlePanelLayout.setHorizontalGroup(
            titlePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(titlePanelLayout.createSequentialGroup()
                .addGap(100, 100, 100)
                .addComponent(nouvelleEditionLB, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(96, 96, 96))
        );
        titlePanelLayout.setVerticalGroup(
            titlePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(titlePanelLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(nouvelleEditionLB)
                .addContainerGap(14, Short.MAX_VALUE))
        );

        bodyPanel.setBackground(java.awt.Color.darkGray);
        bodyPanel.setBorder(javax.swing.BorderFactory.createLineBorder(java.awt.Color.lightGray));

        ouvrageLB.setForeground(java.awt.Color.lightGray);
        ouvrageLB.setText("Ouvrage");

        ouvrageCB.setBackground(java.awt.Color.gray);
        ouvrageCB.setModel(initModelAuteur());
        ouvrageCB.setPreferredSize(new java.awt.Dimension(150, 26));
        ouvrageCB.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ouvrageCBClic(evt);
            }
        });
        ouvrageCB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ouvrageCBActionPerformed(evt);
            }
        });

        ouvrageResLB.setForeground(java.awt.Color.lightGray);
        ouvrageResLB.setBorder(javax.swing.BorderFactory.createLineBorder(java.awt.Color.lightGray));
        ouvrageResLB.setPreferredSize(new java.awt.Dimension(150, 20));

        langueResLB.setForeground(java.awt.Color.lightGray);
        langueResLB.setBorder(javax.swing.BorderFactory.createLineBorder(java.awt.Color.lightGray));
        langueResLB.setPreferredSize(new java.awt.Dimension(150, 20));

        langueCB.setBackground(java.awt.Color.gray);
        langueCB.setModel(initModelLangue());
        langueCB.setPreferredSize(new java.awt.Dimension(150, 26));
        langueCB.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                langueCBClic(evt);
            }
        });
        langueCB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                langueCBActionPerformed(evt);
            }
        });

        langueLB.setForeground(java.awt.Color.lightGray);
        langueLB.setText("Langue");

        isbnLB.setForeground(java.awt.Color.lightGray);
        isbnLB.setText("ISBN");

        isbnTF.setBackground(java.awt.Color.lightGray);

        titreLB.setForeground(java.awt.Color.lightGray);
        titreLB.setText("Titre");

        titreTF.setBackground(java.awt.Color.lightGray);

        dateLB.setForeground(java.awt.Color.lightGray);
        dateLB.setText("Date de publication");
        dateLB.setPreferredSize(new java.awt.Dimension(150, 16));

        dateTF.setBackground(java.awt.Color.lightGray);

        prixLB.setForeground(java.awt.Color.lightGray);
        prixLB.setText("Prix HT");

        prixTF.setBackground(java.awt.Color.lightGray);

        stockLB.setForeground(java.awt.Color.lightGray);
        stockLB.setText("Sotck");

        stockTF.setBackground(java.awt.Color.lightGray);

        couvertureLB.setForeground(java.awt.Color.lightGray);
        couvertureLB.setText("Couverture");

        couvertureTF.setBackground(java.awt.Color.lightGray);

        javax.swing.GroupLayout bodyPanelLayout = new javax.swing.GroupLayout(bodyPanel);
        bodyPanel.setLayout(bodyPanelLayout);
        bodyPanelLayout.setHorizontalGroup(
            bodyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bodyPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(bodyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(couvertureLB, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(prixLB, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(langueLB, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(titreLB, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(isbnLB, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ouvrageLB, javax.swing.GroupLayout.DEFAULT_SIZE, 114, Short.MAX_VALUE)
                    .addComponent(dateLB, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE)
                    .addComponent(stockLB, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(bodyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(bodyPanelLayout.createSequentialGroup()
                        .addComponent(langueCB, 0, 1, Short.MAX_VALUE)
                        .addGap(21, 21, 21)
                        .addComponent(langueResLB, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                    .addGroup(bodyPanelLayout.createSequentialGroup()
                        .addComponent(ouvrageCB, 0, 1, Short.MAX_VALUE)
                        .addGap(27, 27, 27)
                        .addComponent(ouvrageResLB, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                    .addComponent(isbnTF)
                    .addComponent(titreTF)
                    .addGroup(bodyPanelLayout.createSequentialGroup()
                        .addGroup(bodyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(prixTF, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
                            .addComponent(dateTF, javax.swing.GroupLayout.Alignment.LEADING))
                        .addGap(0, 155, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, bodyPanelLayout.createSequentialGroup()
                        .addComponent(stockTF)
                        .addGap(161, 161, 161))
                    .addComponent(couvertureTF))
                .addContainerGap())
        );
        bodyPanelLayout.setVerticalGroup(
            bodyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bodyPanelLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(bodyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ouvrageResLB, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(bodyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(ouvrageLB)
                        .addComponent(ouvrageCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(bodyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(titreLB)
                    .addComponent(titreTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(bodyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(isbnLB)
                    .addComponent(isbnTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(bodyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(langueResLB, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(bodyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(langueLB)
                        .addComponent(langueCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(bodyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(dateLB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dateTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(bodyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(prixLB)
                    .addComponent(prixTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(bodyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(stockLB)
                    .addComponent(stockTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(bodyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(couvertureLB)
                    .addComponent(couvertureTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(15, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout mainPanelLayout = new javax.swing.GroupLayout(mainPanel);
        mainPanel.setLayout(mainPanelLayout);
        mainPanelLayout.setHorizontalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mainPanelLayout.createSequentialGroup()
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(mainPanelLayout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(footerModel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(mainPanelLayout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(bodyPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(titlePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(63, 63, 63))
        );
        mainPanelLayout.setVerticalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(titlePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addComponent(bodyPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                .addComponent(footerModel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ouvrageCBClic(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ouvrageCBClic
        Auteur a = new Auteur();
        recupGalLabel(a, ouvrageCB, ouvrageResLB, idOuvrage);
    }//GEN-LAST:event_ouvrageCBClic

    private void ouvrageCBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ouvrageCBActionPerformed
        Auteur a = new Auteur();
        recupGalLabel(a, ouvrageCB, ouvrageResLB, idOuvrage);
    }//GEN-LAST:event_ouvrageCBActionPerformed

    private void langueCBClic(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_langueCBClic
        Langue l = new Langue();
        recupGalLabel(l, langueCB, langueResLB, idOuvrage);
    }//GEN-LAST:event_langueCBClic

    private void langueCBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_langueCBActionPerformed
        Langue l = new Langue();
        recupGalLabel(l, langueCB, langueResLB, idOuvrage);
    }//GEN-LAST:event_langueCBActionPerformed
   
    public <T> Long recupGalLabel(T t, JComboBox jcb1, JLabel jlb1, Long l) {
        ClasseConstructorPourVector ccpv = (ClasseConstructorPourVector) jcb1.getSelectedItem();
        l = ccpv.getId();
        jlb1.setText("  " + ccpv);

        System.out.println("-------------");
        System.out.println(ccpv.getClasse());
        System.out.println(ccpv.getId());
        System.out.println(ccpv.getColonne1());
        System.out.println(ccpv.getColonne2());

        return l;
    }
    
    
    public void fillDataBase(){
        
        
       
    }
    
    public void mesTests(){
        
        
        
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
            java.util.logging.Logger.getLogger(NouvEdition.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NouvEdition.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NouvEdition.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NouvEdition.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new NouvEdition().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel bodyPanel;
    private javax.swing.JLabel couvertureLB;
    private javax.swing.JTextField couvertureTF;
    private javax.swing.JLabel dateLB;
    private javax.swing.JTextField dateTF;
    private fr.afpa.librairie.view.maquette.FooterModel footerModel1;
    private javax.swing.JLabel isbnLB;
    private javax.swing.JTextField isbnTF;
    private javax.swing.JComboBox langueCB;
    private javax.swing.JLabel langueLB;
    private javax.swing.JLabel langueResLB;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JLabel nouvelleEditionLB;
    private javax.swing.JComboBox ouvrageCB;
    private javax.swing.JLabel ouvrageLB;
    private javax.swing.JLabel ouvrageResLB;
    private javax.swing.JLabel prixLB;
    private javax.swing.JTextField prixTF;
    private javax.swing.JLabel stockLB;
    private javax.swing.JTextField stockTF;
    private javax.swing.JPanel titlePanel;
    private javax.swing.JLabel titreLB;
    private javax.swing.JTextField titreTF;
    // End of variables declaration//GEN-END:variables
}
