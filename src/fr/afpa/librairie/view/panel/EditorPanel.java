package fr.afpa.librairie.view.panel;

import fr.afpa.librairie.controller.CRUDController;
import fr.afpa.librairie.view.panel.footer.FooterEditorPanel;
import java.awt.BorderLayout;
import javax.swing.JPanel;

public abstract class EditorPanel<T> extends JPanel {
    
    private CRUDController<T> controller;
    private T bean;
    
    private final TitlePanel title = new TitlePanel();
    private JPanel body;
    private FooterEditorPanel footer;
    
    public EditorPanel(CRUDController<T> controller) {
        this.controller = controller;
        initComponents();
    }
    
    private void initComponents(){
        
        body = new JPanel();
        initBody(body);
        
        title.setText(getTitleText());
        
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
        if(this.bean == null){
            this.bean = getController().newBean();
        }
        return this.bean;
    };

    public void setBean(T bean) {
        this.bean = bean;
        this.title.setText(getTitleText());
        bindValues();
    }

    public CRUDController<T> getController() {
        return controller;
    }

    public void setController(CRUDController<T> controller) {
        this.controller = controller;
    }

    public FooterEditorPanel getFooter() {
        return (FooterEditorPanel) footer;
    }
}
