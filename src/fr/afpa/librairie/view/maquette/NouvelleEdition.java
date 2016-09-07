
package fr.afpa.librairie.view.maquette;

public class NouvelleEdition extends javax.swing.JFrame {

    public NouvelleEdition() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLayeredPane1 = new javax.swing.JLayeredPane();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jTextField8 = new javax.swing.JTextField();
        jDesktopPane1 = new javax.swing.JDesktopPane();
        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox();
        jLabel3 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jTextField5 = new javax.swing.JTextField();
        jTextField6 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jLabel8.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel8.setText("Nouvelle Edition");
        jLayeredPane1.add(jLabel8);
        jLabel8.setBounds(70, 20, 190, 32);

        jLabel9.setText("Rechercher un ouvrage par son n°");
        jLayeredPane1.add(jLabel9);
        jLabel9.setBounds(10, 66, 210, 30);
        jLayeredPane1.add(jTextField8);
        jTextField8.setBounds(220, 70, 73, 24);

        getContentPane().add(jLayeredPane1);
        jLayeredPane1.setBounds(0, 0, 350, 110);

        jLabel1.setText("ISBN");
        jDesktopPane1.add(jLabel1);
        jLabel1.setBounds(40, 50, 27, 16);
        jDesktopPane1.add(jTextField1);
        jTextField1.setBounds(160, 50, 130, 24);

        jLabel2.setText("Langue");
        jDesktopPane1.add(jLabel2);
        jLabel2.setBounds(40, 90, 42, 16);

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jDesktopPane1.add(jComboBox1);
        jComboBox1.setBounds(160, 90, 130, 26);

        jLabel3.setText("Date de publication");
        jDesktopPane1.add(jLabel3);
        jLabel3.setBounds(37, 133, 108, 16);
        jDesktopPane1.add(jTextField2);
        jTextField2.setBounds(160, 130, 130, 24);

        jLabel4.setText("Prix HT");
        jDesktopPane1.add(jLabel4);
        jLabel4.setBounds(37, 177, 41, 16);
        jDesktopPane1.add(jTextField3);
        jTextField3.setBounds(160, 170, 130, 24);

        jLabel5.setText("Couverture");
        jDesktopPane1.add(jLabel5);
        jLabel5.setBounds(40, 210, 63, 16);
        jDesktopPane1.add(jTextField4);
        jTextField4.setBounds(160, 210, 130, 24);

        jLabel6.setText("Titre");
        jDesktopPane1.add(jLabel6);
        jLabel6.setBounds(40, 250, 26, 16);

        jLabel7.setText("Stock");
        jDesktopPane1.add(jLabel7);
        jLabel7.setBounds(40, 290, 33, 16);
        jDesktopPane1.add(jTextField5);
        jTextField5.setBounds(160, 250, 130, 24);
        jDesktopPane1.add(jTextField6);
        jTextField6.setBounds(160, 290, 130, 24);

        jButton1.setText("Valider");
        jDesktopPane1.add(jButton1);
        jButton1.setBounds(130, 330, 77, 32);

        getContentPane().add(jDesktopPane1);
        jDesktopPane1.setBounds(0, 110, 350, 370);

        setBounds(0, 0, 368, 519);
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
            java.util.logging.Logger.getLogger(NouvelleEdition.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NouvelleEdition.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NouvelleEdition.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NouvelleEdition.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new NouvelleEdition().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField8;
    // End of variables declaration//GEN-END:variables
}
