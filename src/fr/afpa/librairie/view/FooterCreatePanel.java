package fr.afpa.librairie.view;

import java.awt.Color;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.LayoutStyle;

public class FooterCreatePanel extends JPanel {
    
    private final ActionListener controller;                    
    private JButton annulerBT;
    private JButton validerBT;
    
    public FooterCreatePanel(ActionListener controller) {
        this.controller = controller;
        initComponents();
    }

    private void initComponents() {
        
        annulerBT = new JButton();
        validerBT = new JButton();

        setBackground(Color.darkGray);
        setBorder(BorderFactory.createLineBorder(Color.lightGray));

        annulerBT.setText("Annuler");
        annulerBT.setActionCommand("annuler");
        annulerBT.addActionListener(this.controller);

        validerBT.setText("Valider");
        validerBT.setActionCommand("save");
        validerBT.addActionListener(this.controller);

        GroupLayout layout = new GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(annulerBT, GroupLayout.PREFERRED_SIZE, 103, GroupLayout.PREFERRED_SIZE)
                    .addComponent(validerBT, GroupLayout.PREFERRED_SIZE, 103, GroupLayout.PREFERRED_SIZE))
                .addContainerGap(18, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addComponent(validerBT)
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(annulerBT)
                .addContainerGap(12, Short.MAX_VALUE))
        );
    }                     
                                    
}
