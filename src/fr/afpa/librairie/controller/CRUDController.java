package fr.afpa.librairie.controller;

import fr.afpa.librairie.data.AbstractDAOFactory;
import fr.afpa.librairie.data.DAOFactoryInterface;
import fr.afpa.librairie.data.FactoryType;

import fr.afpa.librairie.model.list.ListAdapterListModel;
import fr.afpa.librairie.view.MainFrame;
import fr.afpa.librairie.view.Modal;
import fr.afpa.librairie.view.panel.AdminPanel;
import fr.afpa.librairie.view.panel.EditorPanel;
import fr.afpa.librairie.view.panel.ListPanel;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

public abstract class CRUDController<T> implements ActionListener {

    
    public static final String ADMIN_ACTION = "admin";
    public static final String LIST_ACTION = "list";
    public static final String EDIT_ACTION = "edit";
    public static final String CREATE_ACTION = "create";
    public static final String SAVE_ACTION = "save";
    public static final String DELETE_ACTION = "delete";
    public static final String VIEW_ACTION = "view";

    public static final String CREATE_MODAL_ACTION = "create_modal";
    public static final String DISPOSE_MODAL_ACTION = "dispose_modal";

//    public static final String CREATE_THEN_LIST_ACTION    = "create_then_list";
    // Utiliser les dao dans le controller n'est pas tres recommandé, 
    // mais en attendant les managers on fera avec.
    protected DAOFactoryInterface daoFactory;

    // Le controller connait la frame pour pouvoir influer sur elle.
    private MainFrame frame;
    private Modal modal;

    private AdminPanel<T> adminPanel;
    private EditorPanel<T> editorPanel;
    private ListPanel<T> listPanel;

    public CRUDController() {
//        this.daoFactory = AbstractDAOFactory.getFactory(FactoryType.LIST_DAO_FACTORY);
//        this.daoFactory = AbstractDAOFactory.getFactory(FactoryType.XML_DAO_FACTORY);
        this.daoFactory = AbstractDAOFactory.getFactory(FactoryType.DAO_FACTORY);
    }

    public CRUDController(MainFrame frame) {
        this();
        this.frame = frame;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        T selected = this.adminPanel.getList().getSelectedValue();

        switch (e.getActionCommand()) {

            case ADMIN_ACTION:
                adminAction();
                break;

            case LIST_ACTION:
                listAction();
                break;

            case CREATE_ACTION:
            case SAVE_ACTION:
                editAction(newBean(), false);
                break;

            case DELETE_ACTION:
                deleteAction(selected);
                break;

            case VIEW_ACTION:
                viewAction(selected);
                break;

            case EDIT_ACTION:
                editAction(selected, false);
                break;

            case CREATE_MODAL_ACTION:
                editAction(newBean(), true);
                break;

            case DISPOSE_MODAL_ACTION:
                disposeModal();
                break;

            default:
                if (this.frame.getContent() == null || !this.frame.getContent().equals(this.adminPanel)) {
                    listAction();
                }
        }
    }

    public abstract T newBean();

    protected abstract ListAdapterListModel<T> getAll();

    protected abstract void loadEditorPanel();

    public void adminAction() {
        getAdminPanel().setList(getAll());
        setContent(getAdminPanel());
    }

    ;
    
    public void listAction() {
        getListPanel().setList(getAll());
//        null pour le moment
//        setContent(getListPanel());
    }

    ;

    public abstract boolean create(T value);

    public void editAction(T value, boolean isModal) {

        if (value == null) {
            danger("Veuillez selectionner une ligne à mettre a jour.");
            return;
        }
        
            Component current;

            if (!isModal) {
                current = getFrame().getContent();
            } else {
                current = getModal().getContent();

            // on doit modifier les actions commands pour ne pas avoir
                // le comportement dédié a la mainframe.
                getEditorPanel().getFooter().getValiderBT().setActionCommand(CREATE_MODAL_ACTION);
                getEditorPanel().getFooter().getAnnulerBT().setActionCommand(DISPOSE_MODAL_ACTION);
            }

            if (!getEditorPanel().equals(current)) {
                // load any model if needed.
                loadEditorPanel();
                // set bean in editor.
                getEditorPanel().setBean(value);
                // display editor in frame
                if (isModal) {
                    setModalContent(getEditorPanel());
                } else {
                    setFrameContent(getEditorPanel());
                }
                return;
            }

            // build bean from editor.
            value = getEditorPanel().constructBean();

            if (value == null) {
                danger("Impossible de sauvegarder cette entité.");
                return;
            }

            // create or update value.
            boolean created = create(value);

            if (created) {
                // reset values in editor.
                getEditorPanel().reset();

                if (isModal) {
                    disposeModal();
                } else {
                    adminAction();
                }
            }
        
    }

    public abstract void viewAction(T value);

    public abstract void deleteAction(T value);

    public void setFrame(MainFrame frame) {
        this.frame = frame;
    }

    public MainFrame getFrame() {
        return frame;
    }

    public Modal getModal() {
        if (modal == null) {
            this.modal = new Modal(getFrame());
        }
        return modal;
    }

    public void setAdminPanel(AdminPanel<T> adminPanel) {
        this.adminPanel = adminPanel;
    }

    public AdminPanel<T> getAdminPanel() {
        return adminPanel;
    }

    public void setListPanel(ListPanel<T> listPanel) {
        this.listPanel = listPanel;
    }

    public ListPanel<T> getListPanel() {
        return listPanel;
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

    protected void setContent(Component component) {
        getFrame().setContent(component);
    }

    protected void setFrameContent(Component component) {
        getFrame().setContent(component);
    }

    protected void setModalContent(Component component) {
        getModal().setContent(component);
        getModal().pack();
        getModal().setVisible(true);
    }

    protected void disposeModal() {
        if (modal != null) {
            modal.dispose();
            modal.setContent(null);
        }
    }

    protected void alert(String title, String message) {
        JOptionPane.showMessageDialog(frame, message, title, JOptionPane.INFORMATION_MESSAGE);
    }

    protected void danger(String title, String message) {
        JOptionPane.showMessageDialog(frame, message, title, JOptionPane.ERROR_MESSAGE);
    }

    protected void danger(String message) {
        danger(null, message);
    }

}
