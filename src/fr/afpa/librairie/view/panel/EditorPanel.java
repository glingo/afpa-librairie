package fr.afpa.librairie.view.panel;

import fr.afpa.librairie.controller.Controller;
import fr.afpa.librairie.view.panel.footer.FooterEditorPanel;
import java.awt.BorderLayout;
import javax.swing.JPanel;

public abstract class EditorPanel<T> extends JPanel {
    
    private Controller controller;
    private T bean;
    
//    private JPanel titlePanel;
//    private JLabel title;
    
    private TitlePanel title;
    
    private JPanel body;
    
    private FooterEditorPanel footer;
    
    public EditorPanel(T bean, Controller controller) {
        this.bean = bean;
        this.controller = controller;
        initComponents();
    }
    
    private void initComponents(){
        
        body = new JPanel();
        initBody(body);
        
        title = new TitlePanel(getTitleText());
        footer = new FooterEditorPanel(getController());
        
        setLayout(new BorderLayout());
        
        add(title, BorderLayout.NORTH);
        add(body, BorderLayout.CENTER);
        add(footer, BorderLayout.SOUTH);
        
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
    
}
