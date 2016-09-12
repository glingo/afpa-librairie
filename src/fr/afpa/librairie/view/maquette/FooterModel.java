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
        
        try {
            NouvEdition e = (NouvEdition) this.getParent().getParent().getParent().getParent().getParent();
            if (this.getParent().getParent().getParent().getParent().getParent() instanceof NouvOuvrage) {
                e.fillDataBase();
            }
        } catch (ClassCastException ex) {
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jToggleButton1 = new javax.swing.JToggleButton();
        annulerBT = new javax.swing.JButton();
        validerBT = new javax.swing.JButton();

        jToggleButton1.setText("jToggleButton1");

        setBackground(java.awt.Color.darkGray);
        setBorder(javax.swing.BorderFactory.createLineBorder(java.awt.Color.lightGray));

        annulerBT.setText("Annuler");
        annulerBT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                annulerBTActionPerformed(evt);
            }
        });

        validerBT.setText("Valider");
        validerBT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                validerBTActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(annulerBT, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(validerBT, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(18, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addComponent(validerBT)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(annulerBT)
                .addContainerGap(12, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void validerBTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_validerBTActionPerformed
        System.out.println("Valider");
        checkParent();
    }//GEN-LAST:event_validerBTActionPerformed

    private void annulerBTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_annulerBTActionPerformed
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
        
        try {
            NouvEdition e = (NouvEdition) this.getParent().getParent().getParent().getParent().getParent();
            System.out.println("Annuler");
            int reply = JOptionPane.showConfirmDialog(null, "Souhaitez-vous vraiment fermer la fenêtre en cours ?", "Attn !", JOptionPane.YES_NO_OPTION);
            if (reply == JOptionPane.YES_OPTION) {
                e.dispose();
            }else{
                e.mesTests();
            }
        }catch (ClassCastException exp) {
        }        
    }//GEN-LAST:event_annulerBTActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton annulerBT;
    private javax.swing.JToggleButton jToggleButton1;
    private javax.swing.JButton validerBT;
    // End of variables declaration//GEN-END:variables
}
