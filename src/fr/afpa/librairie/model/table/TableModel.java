package fr.afpa.librairie.model.table;

import fr.afpa.librairie.model.list.ListModelChangeListener;
import fr.afpa.librairie.model.list.ListModelHolder;
import javax.swing.ListModel;
import javax.swing.table.AbstractTableModel;

public abstract class TableModel<T> extends AbstractTableModel {
    
    private final ListModelHolder<T> listModelHolder = new ListModelHolder<>();
    private final ListModelChangeListener listModelChangeListener = new ListModelChangeListener(this);
    
    public TableModel() {
        listModelHolder.addListDataListeners(listModelChangeListener);
    }

    public final void setListModel(ListModel<T> listModel) {
        listModelHolder.setModel(listModel);
    }

    public ListModelHolder<T> getListModelHolder() {
        return listModelHolder;
    }
    
    @Override
    public int getRowCount() {
        ListModel<T> listModel = listModelHolder.getModel();
        return listModel.getSize();
    }
    
    @Override
    public Class<?> getColumnClass(int columnIndex) {
        return String.class;
    }
    
}
