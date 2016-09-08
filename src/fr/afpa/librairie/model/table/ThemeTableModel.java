
package fr.afpa.librairie.model.table;

import fr.afpa.librairie.data.bean.Theme;
import fr.afpa.librairie.model.list.ListModelChangeListener;
import fr.afpa.librairie.model.list.ListModelHolder;
import fr.afpa.librairie.model.table.column.ThemeColumn;
import java.util.HashMap;
import java.util.Map;
import javax.swing.ListModel;
import javax.swing.table.AbstractTableModel;

public class ThemeTableModel extends AbstractTableModel {
    
    private final ListModelHolder<Theme> themeListModelHolder = new ListModelHolder<>();
    private final ListModelChangeListener listModelChangeListener = new ListModelChangeListener(this);

    private Map<ThemeColumn, String> columnDisplayNames;

    public Map<ThemeColumn, String> getColumnDisplayNames() {
        if (this.columnDisplayNames == null) {
            this.columnDisplayNames = new HashMap<>();
            this.columnDisplayNames.put(ThemeColumn.LIBELLE, "Libelle");

        }
        return this.columnDisplayNames;
    }

    public ThemeTableModel() {
        themeListModelHolder.addListDataListeners(listModelChangeListener);
    }
    
    public final void setListModel(ListModel<Theme> listModel) {
        themeListModelHolder.setModel(listModel);
    }

    @Override
    public int getRowCount() {
        ListModel<Theme> listModel = themeListModelHolder.getModel();
        return listModel.getSize();
    }

    @Override
    public int getColumnCount() {
        return ThemeColumn.values().length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Object columnValue = null;

        ListModel<Theme> listModel = themeListModelHolder.getModel();
        Theme theme = listModel.getElementAt(rowIndex);
        ThemeColumn column = getColumn(columnIndex);

        switch (column) {
            case LIBELLE:
                columnValue = theme.getLibelle();
                break;

            default:
//                columnValue = getAddressObject(person, column);
                break;
        }

        return columnValue;
    }

    private ThemeColumn getColumn(int columnIndex) {
        ThemeColumn[] columns = ThemeColumn.values();
        ThemeColumn column = columns[columnIndex];
        return column;
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        return String.class;
    }

    @Override
    public String getColumnName(int column) {
        ThemeColumn columnObj = getColumn(column);
        String displayName = getColumnDisplayNames().get(columnObj);
        return displayName;
    }


    
    
    
}
