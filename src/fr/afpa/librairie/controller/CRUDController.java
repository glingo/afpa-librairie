package fr.afpa.librairie.controller;

import fr.afpa.librairie.data.AbstractDAOFactory;
import fr.afpa.librairie.data.DAOFactoryInterface;
import fr.afpa.librairie.data.FactoryType;
import fr.afpa.librairie.view.MainFrame;
import fr.afpa.librairie.view.panel.AdminPanel;
import fr.afpa.librairie.view.panel.EditorPanel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

public abstract class CRUDController<T> implements ActionListener {
    
    public static final String LIST_ACTION      = "list";
    public static final String EDIT_ACTION      = "edit";
    public static final String CREATE_ACTION    = "create";
    public static final String SAVE_ACTION      = "save";
    public static final String DELETE_ACTION    = "delete";
    public static final String VIEW_ACTION      = "view";
    
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
        
        switch(e.getActionCommand()) {
            
            case LIST_ACTION:
                listAction();
                break;
                
            case CREATE_ACTION:
            case SAVE_ACTION:
                createAction();
                break;
                
            case DELETE_ACTION:
                deleteAction(this.adminPanel.getList().getSelectedValue()); 
                break;
                
            case VIEW_ACTION:
                viewAction(this.adminPanel.getList().getSelectedValue());
                break;
                
            case EDIT_ACTION:
                editAction(this.adminPanel.getList().getSelectedValue());
                break;

            default:
                if(this.frame.getContent() == null || !this.frame.getContent().equals(this.adminPanel)) {
                    listAction();
                }
        }
    }
    
    public abstract void listAction();

    public abstract void createAction();
    
    public void editAction(T value) {
        
        if(value == null) {
            danger("", "Veuillez selectionner une ligne à mettre a jour.");
            return;
        }
        
        getEditorPanel().setBean(value);
        getFrame().setContent(getEditorPanel());
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
    
    
    protected void alert(String title, String message){
        JOptionPane.showMessageDialog(frame, message, title, JOptionPane.INFORMATION_MESSAGE);
    }
    
    protected void danger(String title, String message){
        JOptionPane.showMessageDialog(frame, message, title, JOptionPane.ERROR_MESSAGE);
    }

}
