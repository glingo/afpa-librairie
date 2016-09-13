package fr.afpa.librairie.view.panel;

import fr.afpa.librairie.view.panel.footer.FooterAdminPanel;
import fr.afpa.librairie.controller.Controller;
import fr.afpa.librairie.model.list.ListAdapterListModel;
import fr.afpa.librairie.model.list.ListModelSelection;
import fr.afpa.librairie.model.table.TableModel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.DefaultListSelectionModel;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;

public abstract class AdminPanel<T> extends JPanel {
    
    private final Controller controller;
    private final TableModel<T> tableModel;
    private final ListAdapterListModel<T> listModel;
    private final ListSelectionModel selectionModel;
    private final ListModelSelection<T> listModelSelection;
    
    private JTable table;
    private JList<T> list;
    
    private JScrollPane scrollPane;
    private JPanel titlePanel;
    private JLabel title;
    private FooterAdminPanel footer;

    public AdminPanel(TableModel<T> tableModel, Controller controller) {
        super();
        
        this.controller = controller;
        this.tableModel = tableModel;
        this.listModel = new ListAdapterListModel<>();
        this.selectionModel = new DefaultListSelectionModel();
        this.listModelSelection = new ListModelSelection<>();
        
        initComponents();
    }
    
    private void initComponents(){
        setLayout(new BorderLayout());
        
        this.table = new JTable(this.tableModel);
        this.list = new JList(this.listModel);
        
        this.footer = new FooterAdminPanel(this.controller);
        
        this.table.setSelectionModel(this.selectionModel);
        this.table.setSelectionModel(this.list.getSelectionModel());
        
        this.titlePanel = new JPanel();
        this.title = new JLabel();
        
        this.titlePanel.setBorder(BorderFactory.createLineBorder(Color.lightGray));

        this.title.setFont(new Font("Dialog", 1, 24));
        this.title.setHorizontalAlignment(SwingConstants.CENTER);
        this.title.setText(getTitleText());
        
        this.scrollPane = new JScrollPane();
        this.scrollPane.setViewportView(table);
        
        add(this.titlePanel, BorderLayout.NORTH);
        add(this.scrollPane, BorderLayout.CENTER);
        add(this.footer, BorderLayout.SOUTH);
    }
    
    public JList<T> getList(){
        return this.list;
    }
    
    public void setList(ListAdapterListModel<T> listModel) {
        this.list.setModel(listModel);
        this.tableModel.setListModel(listModel);
        this.listModelSelection.setListModels(listModel, this.selectionModel);
    }
    
    protected abstract String getTitleText();
}
