package fr.afpa.librairie.view.panel;

import java.awt.Color;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class TitlePanel extends JPanel {
    
    private String titleText;
    private JLabel title;
    
    public TitlePanel() {
        super();
        initComponents();
    }

    public TitlePanel(String titleText) {
        this.titleText = titleText;
        initComponents();
    }
    
    private void initComponents(){
        this.title = new JLabel();
        
        setBorder(BorderFactory.createLineBorder(Color.lightGray));

        this.title.setFont(new Font("Dialog", 1, 24));
        this.title.setHorizontalAlignment(SwingConstants.CENTER);
        this.title.setText(this.titleText);
        
        add(title);
    }
    
    public void setText(String text){
        this.title.setText(text);
    }
}
