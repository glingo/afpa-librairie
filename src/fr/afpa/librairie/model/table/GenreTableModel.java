
package fr.afpa.librairie.model.table;

import fr.afpa.librairie.data.bean.Genre;
import fr.afpa.librairie.model.table.column.GenreColumn;
import java.util.HashMap;
import java.util.Map;
import javax.swing.ListModel;

public class GenreTableModel extends TableModel<Genre> {
    
    private Map<GenreColumn, String> columnDisplayNames;

    public Map<GenreColumn, String> getColumnDisplayNames() {
        if (this.columnDisplayNames == null) {
            this.columnDisplayNames = new HashMap<>();
            this.columnDisplayNames.put(GenreColumn.LIBELLE, "Libelle");

        }
        return this.columnDisplayNames;
    }

    @Override
    public int getColumnCount() {
        return GenreColumn.values().length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Object columnValue = null;

        ListModel<Genre> listModel = getListModelHolder().getModel();
        Genre genre = listModel.getElementAt(rowIndex);
        GenreColumn column = getColumn(columnIndex);

        switch (column) {
            case LIBELLE:
                columnValue = genre.getLibelle();
                break;
           
            default:
//                columnValue = getAddressObject(person, column);
                break;
        }

        return columnValue;
    }

    private GenreColumn getColumn(int columnIndex) {
        GenreColumn[] columns = GenreColumn.values();
        GenreColumn column = columns[columnIndex];
        return column;
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        return String.class;
    }

    @Override
    public String getColumnName(int column) {
        GenreColumn columnObj = getColumn(column);
        String displayName = getColumnDisplayNames().get(columnObj);
        return displayName;
    }
   
}
