
package fr.afpa.librairie.view.maquette;

public class NouvelAuteur extends javax.swing.JFrame {

    public NouvelAuteur() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDesktopPane1 = new javax.swing.JDesktopPane();
        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jLabel1.setText("Nom");
        jDesktopPane1.add(jLabel1);
        jLabel1.setBounds(27, 87, 26, 16);
        jDesktopPane1.add(jTextField1);
        jTextField1.setBounds(175, 87, 130, 24);
        jDesktopPane1.add(jTextField2);
        jTextField2.setBounds(175, 117, 130, 24);
        jDesktopPane1.add(jTextField3);
        jTextField3.setBounds(175, 147, 130, 24);
        jDesktopPane1.add(jTextField4);
        jTextField4.setBounds(175, 177, 130, 24);

        jLabel2.setText("Prénom");
        jDesktopPane1.add(jLabel2);
        jLabel2.setBounds(27, 117, 45, 16);

        jLabel3.setText("Date de naissance");
        jDesktopPane1.add(jLabel3);
        jLabel3.setBounds(27, 147, 114, 16);

        jLabel4.setText("Date de décès");
        jDesktopPane1.add(jLabel4);
        jLabel4.setBounds(27, 181, 81, 16);

        jLabel5.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel5.setText("Nouvel Auteur");
        jDesktopPane1.add(jLabel5);
        jLabel5.setBounds(76, 23, 164, 32);

        jButton1.setText("Valider");
        jDesktopPane1.add(jButton1);
        jButton1.setBounds(30, 240, 70, 32);

        getContentPane().add(jDesktopPane1);
        jDesktopPane1.setBounds(0, 0, 320, 290);

        setBounds(0, 0, 334, 329);
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
            java.util.logging.Logger.getLogger(NouvelAuteur.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NouvelAuteur.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NouvelAuteur.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NouvelAuteur.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new NouvelAuteur().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JDesktopPane jDesktopPane1;
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
