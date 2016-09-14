package fr.afpa.librairie.view.panel;

import fr.afpa.librairie.model.list.ListAdapterListModel;
import fr.afpa.librairie.model.list.ListModelSelection;
import fr.afpa.librairie.model.table.TableModel;

import javax.swing.DefaultListSelectionModel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;

public class ListPanel<T> extends JScrollPane {
    
    private final TableModel<T> tableModel;
    private final ListAdapterListModel<T> listModel;
    private final ListSelectionModel selectionModel;
    private final ListModelSelection<T> listModelSelection;
    
    private JTable table;
    private JList<T> list;
    
    public ListPanel(TableModel<T> tableModel) {
        super();
        
        this.tableModel = tableModel;
        this.listModel = new ListAdapterListModel<>();
        this.selectionModel = new DefaultListSelectionModel();
        this.listModelSelection = new ListModelSelection<>();
        
        initComponents();
    }
    
    private void initComponents(){
        
        this.table = new JTable(this.tableModel);
        this.list = new JList(this.listModel);
        
        this.table.setSelectionModel(this.selectionModel);
        this.table.setSelectionModel(this.list.getSelectionModel());
        
        setViewportView(table);
    }
    
    public JList<T> getList(){
        return this.list;
    }
    
    public void setList(ListAdapterListModel<T> listModel) {
        this.list.setModel(listModel);
        this.tableModel.setListModel(listModel);
        this.listModelSelection.setListModels(listModel, this.selectionModel);
    }
    
}
