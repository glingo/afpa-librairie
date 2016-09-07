package fr.afpa.librairie.view.maquette;

import fr.afpa.librairie.data.bean.Genre;

// c  variable de connexion
// s variable de statement
import java.sql.*;
import java.util.*;
import javax.swing.DefaultComboBoxModel;

public class NouvelOuvrage extends javax.swing.JFrame {

    Connection c = null;
    MyConnection myConnect = new MyConnection();

    public NouvelOuvrage() {
        initComponents();
        //initVectorGenre();

    }

    private DefaultComboBoxModel initModelAuteur() {//configurer le Model - clic droit - proprietes - Model - Custom code et coller initModelCD()
        return new DefaultComboBoxModel(initVectorAuteur());//c'est le toString de new Album qui sera affiche dans le ComboBox
    }

    private Vector initVectorAuteur() {

        VectorGenerator vg = new VectorGenerator();
        return vg.genererVector("Auteur", "idAuteur", "nom", "prenom");

    }

    private DefaultComboBoxModel initModelGenre() {//configurer le Model - clic droit - proprietes - Model - Custom code et coller initModelCD()
        return new DefaultComboBoxModel(initVectorGenre());//c'est le toString de new Album qui sera affiche dans le ComboBox
    }

    private Vector initVectorGenre() {

        VectorGenerator vg = new VectorGenerator();
        return vg.genererVector("Genre", "idGenre", "libelle");

    }

    private DefaultComboBoxModel initModelTheme() {//configurer le Model - clic droit - proprietes - Model - Custom code et coller initModelCD()
        return new DefaultComboBoxModel(initVectorTheme());//c'est le toString de new Album qui sera affiche dans le ComboBox
    }

    private Vector initVectorTheme() {

        VectorGenerator vg = new VectorGenerator();
        return vg.genererVector("Theme", "idTheme", "libelle");

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDesktopPane1 = new javax.swing.JDesktopPane();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jLabel6 = new javax.swing.JLabel();
        jComboBox2 = new javax.swing.JComboBox();
        jLabel7 = new javax.swing.JLabel();
        jComboBox3 = new javax.swing.JComboBox();
        jComboBox4 = new javax.swing.JComboBox();
        jLabel8 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jDesktopPane2 = new javax.swing.JDesktopPane();
        jButton1 = new javax.swing.JButton();
        jComboBox1 = new javax.swing.JComboBox();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jButton5 = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jComboBox5 = new javax.swing.JComboBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jLabel3.setText("Titre de l'ouvrage");
        jDesktopPane1.add(jLabel3);
        jLabel3.setBounds(36, 136, 98, 16);

        jLabel4.setText("Sous-titre");
        jDesktopPane1.add(jLabel4);
        jLabel4.setBounds(36, 191, 56, 16);

        jLabel5.setText("Résumé");
        jDesktopPane1.add(jLabel5);
        jLabel5.setBounds(36, 415, 47, 16);
        jDesktopPane1.add(jTextField1);
        jTextField1.setBounds(212, 132, 420, 24);
        jDesktopPane1.add(jTextField2);
        jTextField2.setBounds(212, 187, 420, 24);

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        jDesktopPane1.add(jScrollPane1);
        jScrollPane1.setBounds(212, 415, 223, 83);

        jLabel6.setText("Genre littéraire");
        jDesktopPane1.add(jLabel6);
        jLabel6.setBounds(36, 247, 85, 16);

        jComboBox2.setModel(initModelGenre());
        jDesktopPane1.add(jComboBox2);
        jComboBox2.setBounds(212, 242, 200, 26);

        jLabel7.setText("Ajouter un thème");
        jDesktopPane1.add(jLabel7);
        jLabel7.setBounds(36, 324, 97, 16);

        jComboBox3.setModel(initModelTheme());
        jDesktopPane1.add(jComboBox3);
        jComboBox3.setBounds(212, 324, 200, 26);

        jComboBox4.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jDesktopPane1.add(jComboBox4);
        jComboBox4.setBounds(638, 316, 175, 26);

        jLabel8.setText("Thèmes sélectionnés");
        jDesktopPane1.add(jLabel8);
        jLabel8.setBounds(482, 321, 122, 16);

        jButton2.setText("Ajouter");
        jDesktopPane1.add(jButton2);
        jButton2.setBounds(212, 356, 71, 32);

        jButton3.setText("Retirer");
        jDesktopPane1.add(jButton3);
        jButton3.setBounds(310, 356, 69, 32);

        jButton4.setText("Valider");
        jDesktopPane1.add(jButton4);
        jButton4.setBounds(638, 466, 70, 32);

        jButton1.setText("Créer un nouvel auteur");
        jDesktopPane2.add(jButton1);
        jButton1.setBounds(470, 60, 159, 32);

        jComboBox1.setModel(initModelAuteur());
        jDesktopPane2.add(jComboBox1);
        jComboBox1.setBounds(210, 70, 200, 26);

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel1.setText("Nouvel Ouvrage");
        jDesktopPane2.add(jLabel1);
        jLabel1.setBounds(320, 10, 183, 32);

        jLabel2.setText("Rechercher un auteur");
        jDesktopPane2.add(jLabel2);
        jLabel2.setBounds(40, 70, 143, 16);

        jDesktopPane1.add(jDesktopPane2);
        jDesktopPane2.setBounds(0, 0, 830, 120);

        jButton5.setText("Valider et saisir une édition");
        jDesktopPane1.add(jButton5);
        jButton5.setBounds(580, 510, 190, 32);

        jLabel9.setText("Ajouter un Co Auteur");
        jDesktopPane1.add(jLabel9);
        jLabel9.setBounds(480, 250, 130, 16);

        jComboBox5.setModel(initModelAuteur());
        jDesktopPane1.add(jComboBox5);
        jComboBox5.setBounds(630, 250, 180, 26);

        getContentPane().add(jDesktopPane1);
        jDesktopPane1.setBounds(0, 0, 830, 600);

        setBounds(0, 0, 846, 638);
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(NouvelOuvrage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NouvelOuvrage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NouvelOuvrage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NouvelOuvrage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new NouvelOuvrage().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JComboBox jComboBox2;
    private javax.swing.JComboBox jComboBox3;
    private javax.swing.JComboBox jComboBox4;
    private javax.swing.JComboBox jComboBox5;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JDesktopPane jDesktopPane2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    // End of variables declaration//GEN-END:variables
}
