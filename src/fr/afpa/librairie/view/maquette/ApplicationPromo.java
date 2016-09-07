
package fr.afpa.librairie.view.maquette;

public class ApplicationPromo extends javax.swing.JFrame {

    public ApplicationPromo() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDesktopPane1 = new javax.swing.JDesktopPane();
        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jDesktopPane2 = new javax.swing.JDesktopPane();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jComboBox1 = new javax.swing.JComboBox();
        jTextField4 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jLabel1.setText("N° de Rubrique");
        jDesktopPane1.add(jLabel1);
        jLabel1.setBounds(24, 57, 120, 16);

        jTextField1.setText("jTextField1");
        jDesktopPane1.add(jTextField1);
        jTextField1.setBounds(140, 50, 73, 24);

        getContentPane().add(jDesktopPane1);
        jDesktopPane1.setBounds(0, 0, 280, 0);

        jLabel2.setText("Ajouter ISBN");
        jDesktopPane2.add(jLabel2);
        jLabel2.setBounds(20, 30, 80, 16);

        jLabel3.setText("Retirer ISBN");
        jDesktopPane2.add(jLabel3);
        jLabel3.setBounds(20, 90, 80, 16);
        jDesktopPane2.add(jTextField2);
        jTextField2.setBounds(120, 30, 270, 24);
        jDesktopPane2.add(jTextField3);
        jTextField3.setBounds(120, 90, 270, 24);

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jDesktopPane2.add(jComboBox1);
        jComboBox1.setBounds(10, 150, 380, 26);

        getContentPane().add(jDesktopPane2);
        jDesktopPane2.setBounds(0, 110, 440, 230);
        getContentPane().add(jTextField4);
        jTextField4.setBounds(120, 70, 70, 24);

        jLabel4.setText("N° de Rubrique");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(20, 70, 90, 16);

        jLabel5.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel5.setText("Ajouter un ISBN à une Rubrique");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(20, 10, 380, 32);

        setBounds(0, 0, 458, 378);
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(ApplicationPromo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ApplicationPromo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ApplicationPromo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ApplicationPromo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ApplicationPromo().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JDesktopPane jDesktopPane2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    // End of variables declaration//GEN-END:variables
}
