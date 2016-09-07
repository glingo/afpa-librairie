
package fr.afpa.librairie.view.maquette;

public class MenuGeneral extends javax.swing.JFrame {

    public MenuGeneral() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDesktopPane1 = new javax.swing.JDesktopPane();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel1.setText("Menu Général");
        jDesktopPane1.add(jLabel1);
        jLabel1.setBounds(120, 40, 170, 32);

        jButton1.setText("Créer une fiche Auteur");
        jDesktopPane1.add(jButton1);
        jButton1.setBounds(100, 120, 200, 32);

        jButton2.setText("Ajouter un ouvrage à la librairie");
        jDesktopPane1.add(jButton2);
        jButton2.setBounds(50, 170, 290, 32);

        jButton3.setText("Modifier les informations d'un ouvrage");
        jDesktopPane1.add(jButton3);
        jButton3.setBounds(50, 200, 290, 32);

        jButton4.setText("Ajouter une Edition d'un ouvrrage");
        jDesktopPane1.add(jButton4);
        jButton4.setBounds(50, 230, 290, 32);

        jButton5.setText("Accéder à la fiche d'un Client");
        jDesktopPane1.add(jButton5);
        jButton5.setBounds(60, 370, 270, 32);

        jButton6.setText("Création d'une nouvelle Rubrique");
        jDesktopPane1.add(jButton6);
        jButton6.setBounds(80, 280, 220, 32);

        jButton7.setText("Remplir une Rubrique");
        jDesktopPane1.add(jButton7);
        jButton7.setBounds(80, 310, 220, 32);

        jButton8.setText("Quitter");
        jDesktopPane1.add(jButton8);
        jButton8.setBounds(321, 443, 69, 32);

        getContentPane().add(jDesktopPane1);
        jDesktopPane1.setBounds(0, 0, 420, 490);

        setBounds(0, 0, 434, 530);
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
            java.util.logging.Logger.getLogger(MenuGeneral.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MenuGeneral.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MenuGeneral.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MenuGeneral.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MenuGeneral().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
