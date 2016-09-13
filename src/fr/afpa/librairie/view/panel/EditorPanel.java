package fr.afpa.librairie.view.panel;

import fr.afpa.librairie.controller.Controller;
import fr.afpa.librairie.view.panel.footer.FooterEditorPanel;
import java.awt.Color;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.LayoutStyle;
import javax.swing.SwingConstants;

public abstract class EditorPanel<T> extends JPanel {
    
    private Controller controller;
    private T bean;
    
    private JPanel titlePanel;
    private JLabel title;
    
    private JPanel body;
    
    private FooterEditorPanel footer;

    public EditorPanel(T bean, Controller controller) {
        this.controller = controller;
        this.bean = bean;
        initComponents();
    }
    
    private void initComponents(){
        
        body = new JPanel();
        initBody(body);
        body.setBackground(Color.darkGray);
        
        titlePanel = new JPanel();
        title = new JLabel();
        
        titlePanel.setBackground(Color.darkGray);
        titlePanel.setBorder(BorderFactory.createLineBorder(java.awt.Color.lightGray));

        title.setFont(new Font("Dialog", 1, 24));
        title.setForeground(Color.lightGray);
        title.setHorizontalAlignment(SwingConstants.CENTER);
        title.setText(getTitleText());
        
        footer = new FooterEditorPanel(getController());
        
        GroupLayout titlePanelLayout = new GroupLayout(titlePanel);
        titlePanel.setLayout(titlePanelLayout);
        titlePanelLayout.setHorizontalGroup(
            titlePanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(titlePanelLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(title, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(20, 20, 20))
        );
        
        titlePanelLayout.setVerticalGroup(
            titlePanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(titlePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(title)
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        
        initLayout();
    }
    
    private void initLayout(){
        
        GroupLayout layout = new GroupLayout(this);
        setLayout(layout);
        
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(titlePanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(body, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(footer, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(titlePanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(body, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(footer, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }
    
    protected abstract void initBody(JPanel body);
    
    protected abstract String getTitleText();
    
    public abstract void bindValues();
    
    public abstract T contructBean();
    
    public abstract void reset();
    
    public T getBean(){
        return bean;
    };

    public void setBean(T bean) {
        this.bean = bean;
        bindValues();
        this.title.setText(getTitleText());
    }

    public Controller getController() {
        return controller;
    }

    public void setController(Controller controller) {
        this.controller = controller;
    }

    public JLabel getTitle() {
        return title;
    }

    public void setTitle(JLabel title) {
        this.title = title;
    }
    
}
