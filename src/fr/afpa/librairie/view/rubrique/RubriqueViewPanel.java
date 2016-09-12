package fr.afpa.librairie.view.rubrique;

import fr.afpa.librairie.controller.RubriqueController;
import fr.afpa.librairie.data.bean.Ouvrage;
import fr.afpa.librairie.model.list.ListAdapterListModel;
import fr.afpa.librairie.model.list.OuvrageListCellRenderer;
import java.util.List;
import javax.swing.JPanel;

public class RubriqueViewPanel extends JPanel {
    
    private final ListAdapterListModel<Ouvrage> listModel = new ListAdapterListModel<>();

    public RubriqueViewPanel(RubriqueController controller) {
        initComponents();
        this.ouvrages.setCellRenderer(new OuvrageListCellRenderer());
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        ouvrages = new javax.swing.JList();

        jScrollPane1.setMaximumSize(null);
        jScrollPane1.setMinimumSize(new java.awt.Dimension(530, 370));
        jScrollPane1.setPreferredSize(new java.awt.Dimension(530, 370));

        ouvrages.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        ouvrages.setLayoutOrientation(javax.swing.JList.HORIZONTAL_WRAP);
        ouvrages.setMaximumSize(null);
        ouvrages.setMinimumSize(new java.awt.Dimension(530, 370));
        ouvrages.setPreferredSize(new java.awt.Dimension(530, 370));
        ouvrages.setValueIsAdjusting(true);
        jScrollPane1.setViewportView(ouvrages);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(127, 127, 127)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    
    public void setOuvrageList(List<Ouvrage> list) {
        listModel.setList(list);
        this.ouvrages.setModel(listModel);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JList ouvrages;
    // End of variables declaration//GEN-END:variables
}
