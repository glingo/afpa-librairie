package fr.afpa.librairie.controller;

import fr.afpa.librairie.data.AbstractDAOFactory;
import fr.afpa.librairie.data.DAOFactoryInterface;
import fr.afpa.librairie.data.FactoryType;
import fr.afpa.librairie.model.list.ListAdapterListModel;
import fr.afpa.librairie.view.MainFrame;
import fr.afpa.librairie.view.panel.AdminPanel;
import fr.afpa.librairie.view.panel.EditorPanel;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JOptionPane;

public abstract class CRUDController<T> implements ActionListener {
    
    public static final String LIST_ACTION      = "list";
    public static final String EDIT_ACTION      = "edit";
    public static final String CREATE_ACTION    = "create";
    public static final String SAVE_ACTION      = "save";
    public static final String DELETE_ACTION    = "delete";
    public static final String VIEW_ACTION      = "view";
    
//    public static final String CREATE_THEN_LIST_ACTION    = "create_then_list";
    
    // Utiliser les dao dans le controller n'est pas tres recommandé, 
    // mais en attendant les managers on fera avec.
    protected DAOFactoryInterface daoFactory;
    
    // Le controller connait la frame pour pouvoir influer sur elle.
    private MainFrame frame;
    
    private AdminPanel<T> adminPanel;
    private EditorPanel<T> editorPanel;
    
    public CRUDController() {
//        this.daoFactory = AbstractDAOFactory.getFactory(FactoryType.LIST_DAO_FACTORY);
//        this.daoFactory = AbstractDAOFactory.getFactory(FactoryType.XML_DAO_FACTORY);
        this.daoFactory = AbstractDAOFactory.getFactory(FactoryType.DAO_FACTORY);
    }

    public CRUDController(MainFrame frame) {
        this();
        this.frame = frame;
    }

    public CRUDController(MainFrame frame, AdminPanel<T> adminPanel, EditorPanel<T> editorPanel) {
        this();
        this.frame = frame;
        this.adminPanel = adminPanel;
        this.editorPanel = editorPanel;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        T selected = this.adminPanel.getList().getSelectedValue();
        
        switch(e.getActionCommand()) {
            
            case LIST_ACTION:
                listAction();
                break;
                
            case CREATE_ACTION:
            case SAVE_ACTION:
                editAction(newBean());
                break;
                
            case DELETE_ACTION:
                deleteAction(selected); 
                break;
                
            case VIEW_ACTION:
                viewAction(selected);
                break;
                
            case EDIT_ACTION:
                editAction(selected);
                break;

            default:
                if(this.frame.getContent() == null || !this.frame.getContent().equals(this.adminPanel)) {
                    listAction();
                }
        }
    }
    
    public abstract T newBean();
    
    protected abstract ListAdapterListModel<T> getAll();
    
    protected abstract void loadEditorPanel();
    
    public void listAction(){
        getAdminPanel().setList(getAll());
        setContent(getAdminPanel());
    };

    public abstract void create(T value);
    
    public void editAction(T value) {
        
        if(value == null) {
            danger("Veuillez selectionner une ligne à mettre a jour.");
            return;
        }
        
        if (!getEditorPanel().equals(getFrame().getContent())) {
            // load any model if needed.
            loadEditorPanel();
            // set bean in editor.
            getEditorPanel().setBean(value);
            // display editor in frame
            setContent(getEditorPanel());
            return;
        }
        
        // build bean from editor.
        value = getEditorPanel().constructBean();
        
        if(value == null) {
            danger("Impossible de sauvegarder cette entité."); 
            return;
        }
        
        // create or update value.
        create(value);
        
        // reset values in editor.
        getEditorPanel().reset();
    }

    public abstract void viewAction(T value);

    public abstract void deleteAction(T value);

    public void setFrame(MainFrame frame) {
        this.frame = frame;
    }

    public MainFrame getFrame() {
        return frame;
    }
    
    public void setAdminPanel(AdminPanel<T> adminPanel) {
        this.adminPanel = adminPanel;
    }

    public AdminPanel<T> getAdminPanel() {
        return adminPanel;
    }

    public void setEditorPanel(EditorPanel<T> editorPanel) {
        this.editorPanel = editorPanel;
    }

    public EditorPanel<T> getEditorPanel() {
        return editorPanel;
    }
    
    public DAOFactoryInterface getDaoFactory() {
        return daoFactory;
    }
    
    protected void setContent(Component component){
        this.frame.setContent(component);
    }
    
    protected void alert(String title, String message){
        JOptionPane.showMessageDialog(frame, message, title, JOptionPane.INFORMATION_MESSAGE);
    }
    
    protected void danger(String title, String message){
        JOptionPane.showMessageDialog(frame, message, title, JOptionPane.ERROR_MESSAGE);
    }
    
    protected void danger(String message){
        danger(null, message);
    }

}
