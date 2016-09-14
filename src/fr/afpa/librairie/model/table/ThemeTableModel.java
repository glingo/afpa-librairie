
package fr.afpa.librairie.model.table;

import fr.afpa.librairie.data.bean.Theme;
import fr.afpa.librairie.model.table.column.ThemeColumn;
import java.util.HashMap;
import java.util.Map;
import javax.swing.ListModel;

public class ThemeTableModel extends TableModel<Theme> {
    
    private Map<ThemeColumn, String> columnDisplayNames;

    public Map<ThemeColumn, String> getColumnDisplayNames() {
        if (this.columnDisplayNames == null) {
            this.columnDisplayNames = new HashMap<>();
            this.columnDisplayNames.put(ThemeColumn.LIBELLE, "Libelle");
        }
        return this.columnDisplayNames;
    }

    @Override
    public int getColumnCount() {
        return ThemeColumn.values().length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Object columnValue = null;

        ListModel<Theme> listModel = getListModelHolder().getModel();
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
