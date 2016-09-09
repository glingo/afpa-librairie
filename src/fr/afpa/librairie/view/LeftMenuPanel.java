package fr.afpa.librairie.view;

import java.awt.Dimension;
import javax.swing.GroupLayout;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class LeftMenuPanel extends JPanel {

    private javax.swing.JList jList1;
    private javax.swing.JScrollPane jScrollPane2;   
    
    public LeftMenuPanel() {
        initComponents();
    }
                     
    private void initComponents() {

        jScrollPane2 = new JScrollPane();
        jList1 = new JList();

        setMinimumSize(new Dimension(100, 390));
        setPreferredSize(new Dimension(100, 380));

        jList1.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        
        jList1.setMaximumSize(null);
        jList1.setMinimumSize(new Dimension(40, 80));
        jList1.setPreferredSize(new Dimension(40, 80));
        jScrollPane2.setViewportView(jList1);

        GroupLayout layout = new GroupLayout(this);
        this.setLayout(layout);
        
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, GroupLayout.Alignment.TRAILING)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, GroupLayout.Alignment.TRAILING)
        );
    }                                
}
