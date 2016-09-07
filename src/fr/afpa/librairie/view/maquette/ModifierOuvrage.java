
package fr.afpa.librairie.view.maquette;

public class ModifierOuvrage extends javax.swing.JFrame {

    public ModifierOuvrage() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDesktopPane1 = new javax.swing.JDesktopPane();
        jComboBox1 = new javax.swing.JComboBox();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
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
        jButton1 = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jDesktopPane1.add(jComboBox1);
        jComboBox1.setBounds(182, 130, 200, 26);

        jLabel2.setText("Auteur");
        jDesktopPane1.add(jLabel2);
        jLabel2.setBounds(6, 135, 143, 16);

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel1.setText("Modifier un Ouvrage");
        jDesktopPane1.add(jLabel1);
        jLabel1.setBounds(294, 27, 235, 32);

        jLabel3.setText("Titre");
        jDesktopPane1.add(jLabel3);
        jLabel3.setBounds(6, 189, 26, 16);

        jLabel4.setText("Sous-titre");
        jDesktopPane1.add(jLabel4);
        jLabel4.setBounds(6, 244, 56, 16);

        jLabel5.setText("Résumé");
        jDesktopPane1.add(jLabel5);
        jLabel5.setBounds(6, 468, 47, 16);
        jDesktopPane1.add(jTextField1);
        jTextField1.setBounds(182, 185, 460, 24);
        jDesktopPane1.add(jTextField2);
        jTextField2.setBounds(182, 240, 460, 24);

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        jDesktopPane1.add(jScrollPane1);
        jScrollPane1.setBounds(182, 468, 223, 83);

        jLabel6.setText("Genre littéraire");
        jDesktopPane1.add(jLabel6);
        jLabel6.setBounds(6, 300, 85, 16);

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jDesktopPane1.add(jComboBox2);
        jComboBox2.setBounds(182, 295, 200, 26);

        jLabel7.setText("Thème");
        jDesktopPane1.add(jLabel7);
        jLabel7.setBounds(6, 377, 39, 16);

        jComboBox3.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jDesktopPane1.add(jComboBox3);
        jComboBox3.setBounds(182, 377, 200, 26);

        jComboBox4.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jDesktopPane1.add(jComboBox4);
        jComboBox4.setBounds(640, 369, 175, 26);

        jLabel8.setText("Thèmes sélectionnés");
        jDesktopPane1.add(jLabel8);
        jLabel8.setBounds(484, 374, 122, 16);

        jButton1.setText("Créer un nouvel auteur");
        jDesktopPane1.add(jButton1);
        jButton1.setBounds(484, 127, 159, 32);

        jLabel9.setText("n° de l'ouvrage");
        jDesktopPane1.add(jLabel9);
        jLabel9.setBounds(6, 93, 86, 16);

        jLabel10.setText("jLabel10");
        jDesktopPane1.add(jLabel10);
        jLabel10.setBounds(182, 93, 70, 16);

        jButton2.setText("Ajouter");
        jDesktopPane1.add(jButton2);
        jButton2.setBounds(182, 415, 71, 32);

        jButton3.setText("Retirer");
        jDesktopPane1.add(jButton3);
        jButton3.setBounds(271, 415, 69, 32);

        jButton4.setText("Valider");
        jDesktopPane1.add(jButton4);
        jButton4.setBounds(484, 519, 70, 32);

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
            java.util.logging.Logger.getLogger(ModifierOuvrage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ModifierOuvrage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ModifierOuvrage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ModifierOuvrage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ModifierOuvrage().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JComboBox jComboBox2;
    private javax.swing.JComboBox jComboBox3;
    private javax.swing.JComboBox jComboBox4;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
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
