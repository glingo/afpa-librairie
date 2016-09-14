package fr.afpa.librairie.view.panel;

import fr.afpa.librairie.view.panel.footer.FooterAdminPanel;
import fr.afpa.librairie.controller.Controller;
import fr.afpa.librairie.model.list.ListAdapterListModel;
import fr.afpa.librairie.model.table.TableModel;
import java.awt.BorderLayout;
import javax.swing.JList;
import javax.swing.JPanel;

public abstract class AdminPanel<T> extends JPanel {
    
    private final Controller controller;
    private final TableModel<T> tableModel;
    
    private TitlePanel title;
    private ListPanel<T> listPanel;
    private FooterAdminPanel footer;

    public AdminPanel(TableModel<T> tableModel, Controller controller) {
        super();
        this.controller = controller;
        this.tableModel = tableModel;
        initComponents();
    }
    
    private void initComponents(){
        setLayout(new BorderLayout());
        
        this.title = new TitlePanel(getTitleText());
        this.listPanel = new ListPanel<>(this.tableModel);
        this.footer = new FooterAdminPanel(this.controller);
        
        add(this.title, BorderLayout.NORTH);
        add(this.listPanel, BorderLayout.CENTER);
        add(this.footer, BorderLayout.SOUTH);
    }
    
    protected abstract String getTitleText();
    
    public JList<T> getList(){
        return this.listPanel.getList();
    }

    public void setList(ListAdapterListModel<T> listModel) {
        this.listPanel.setList(listModel);
    }
}
