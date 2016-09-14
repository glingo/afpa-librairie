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
                
    private JButton seConnecterButton;
    private JLabel titre;
    private JProgressBar progressBar;
    private Canvas logoCanvas;
    
    public HeaderPanel() {
        initComponents();
    }
                   
    private void initComponents() {

        logoCanvas = new Canvas();
        titre = new JLabel();
        seConnecterButton = new JButton();
        progressBar = new JProgressBar();
        Dimension dim = new Dimension(650, 60);

        setMinimumSize(dim);
        setPreferredSize(dim);

        logoCanvas.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
        logoCanvas.setMaximumSize(new Dimension(50, 50));
        logoCanvas.setMinimumSize(new Dimension(50, 50));
        logoCanvas.setName(""); // NOI18N

        titre.setFont(new Font("Perpetua Titling MT", 0, 24)); // NOI18N
        titre.setHorizontalAlignment(SwingConstants.CENTER);
        titre.setText("Le hibou qui lit");
        titre.setMaximumSize(null);
        titre.setMinimumSize(new Dimension(210, 40));
        titre.setPreferredSize(new Dimension(210, 40));

        seConnecterButton.setText("Se connecter");

        GroupLayout layout = new GroupLayout(this);
        setLayout(layout);
        
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(logoCanvas, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addComponent(titre, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(seConnecterButton))
            .addComponent(progressBar, GroupLayout.DEFAULT_SIZE, 650, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(logoCanvas, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(seConnecterButton)
                        .addComponent(titre, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(progressBar, GroupLayout.PREFERRED_SIZE, 10, GroupLayout.PREFERRED_SIZE))
        );
    }                     
            
}
