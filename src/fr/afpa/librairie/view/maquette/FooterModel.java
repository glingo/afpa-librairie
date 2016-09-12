package fr.afpa.librairie.view.maquette;

import javax.swing.*;

public class FooterModel extends javax.swing.JPanel {

    public FooterModel() {
        initComponents();

    }

    public void checkParent() {
        try {
            NouvAuteur m = (NouvAuteur) this.getParent().getParent().getParent().getParent().getParent();
            if (this.getParent().getParent().getParent().getParent().getParent() instanceof NouvAuteur) {
                m.fillDataBase();
            }
        } catch (ClassCastException ex) {
        }

        try {
            NouvOuvrage o = (NouvOuvrage) this.getParent().getParent().getParent().getParent().getParent();
            if (this.getParent().getParent().getParent().getParent().getParent() instanceof NouvOuvrage) {
                o.fillDataBase();
            }
        } catch (ClassCastException ex) {
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jToggleButton1 = new javax.swing.JToggleButton();
        jButton2 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        jToggleButton1.setText("jToggleButton1");

        setBackground(java.awt.Color.darkGray);
        setBorder(javax.swing.BorderFactory.createLineBorder(java.awt.Color.lightGray));

        jButton2.setText("Annuler");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton1.setText("Valider");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(18, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton2)
                .addContainerGap(12, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        System.out.println("Valider");
        checkParent();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        try {
            NouvAuteur m = (NouvAuteur) this.getParent().getParent().getParent().getParent().getParent();
            System.out.println("Annuler");
            int reply = JOptionPane.showConfirmDialog(null, "Souhaitez-vous vraiment fermer la fenêtre en cours ?", "Attn !", JOptionPane.YES_NO_OPTION);
            if (reply == JOptionPane.YES_OPTION) {
                m.dispose();
            }
        }catch (ClassCastException exp) {
        }
        
        try {
            NouvOuvrage o = (NouvOuvrage) this.getParent().getParent().getParent().getParent().getParent();
            System.out.println("Annuler");
            int reply = JOptionPane.showConfirmDialog(null, "Souhaitez-vous vraiment fermer la fenêtre en cours ?", "Attn !", JOptionPane.YES_NO_OPTION);
            if (reply == JOptionPane.YES_OPTION) {
                o.dispose();
            }else{
                o.mesTests();
            }
        }catch (ClassCastException exp) {
        }
    }//GEN-LAST:event_jButton2ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JToggleButton jToggleButton1;
    // End of variables declaration//GEN-END:variables
}
