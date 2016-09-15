package fr.afpa.librairie.view.panel;

import fr.afpa.librairie.view.panel.footer.FooterEditorPanel;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import javax.swing.JPanel;

public abstract class EditorPanel<T> extends JPanel {
    
    private ActionListener controller;
    private T bean;
    
    private TitlePanel title;
    private JPanel body;
    private FooterEditorPanel footer;
    
    public EditorPanel(T bean, ActionListener controller) {
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
    
    public abstract T constructBean();
    
    public abstract void reset();
    
    public T getBean(){
        return bean;
    };

    public void setBean(T bean) {
        this.bean = bean;
        this.title.setText(getTitleText());
        bindValues();
    }

    public ActionListener getController() {
        return controller;
    }

    public void setController(ActionListener controller) {
        this.controller = controller;
    }

    public FooterEditorPanel getFooter() {
        return (FooterEditorPanel) footer;
    }
}
