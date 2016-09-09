package fr.afpa.librairie.view;

import java.awt.Canvas;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.LayoutStyle;
import javax.swing.SwingConstants;

public class HeaderPanel extends JPanel {
                
    private JButton jButton1;
    private JLabel jLabel1;
    private JProgressBar jProgressBar1;
    private Canvas logoCanvas;
    
    public HeaderPanel() {
        initComponents();
    }
                   
    private void initComponents() {

        logoCanvas = new Canvas();
        jLabel1 = new JLabel();
        jButton1 = new JButton();
        jProgressBar1 = new JProgressBar();
        Dimension dim = new Dimension(650, 60);

        setMinimumSize(dim);
        setPreferredSize(dim);

        logoCanvas.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
        logoCanvas.setMaximumSize(new Dimension(50, 50));
        logoCanvas.setMinimumSize(new Dimension(50, 50));
        logoCanvas.setName(""); // NOI18N

        jLabel1.setFont(new Font("Perpetua Titling MT", 0, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(SwingConstants.CENTER);
        jLabel1.setText("Le hibou qui lit");
        jLabel1.setMaximumSize(null);
        jLabel1.setMinimumSize(new Dimension(210, 40));
        jLabel1.setPreferredSize(new Dimension(210, 40));

        jButton1.setText("Se connecter");

        GroupLayout layout = new GroupLayout(this);
        this.setLayout(layout);
        
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(logoCanvas, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addComponent(jLabel1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1))
            .addComponent(jProgressBar1, GroupLayout.DEFAULT_SIZE, 650, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(logoCanvas, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton1)
                        .addComponent(jLabel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jProgressBar1, GroupLayout.PREFERRED_SIZE, 10, GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>                        
            
}
