
package fr.afpa.librairie.model.table;

import fr.afpa.librairie.data.bean.Tag;
import fr.afpa.librairie.model.list.ListModelChangeListener;
import fr.afpa.librairie.model.list.ListModelHolder;
import fr.afpa.librairie.model.table.column.TagColumn;
import java.util.HashMap;
import java.util.Map;
import javax.swing.ListModel;

public class TagTableModel extends TableModel<Tag> {
    
    private Map<TagColumn, String> columnDisplayNames;

    public Map<TagColumn, String> getColumnDisplayNames() {
        if (this.columnDisplayNames == null) {
            this.columnDisplayNames = new HashMap<>();
            this.columnDisplayNames.put(TagColumn.LIBELLE, "Libelle");

        }
        return this.columnDisplayNames;
    }
    
    @Override
    public int getColumnCount() {
        return TagColumn.values().length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Object columnValue = null;

        ListModel<Tag> listModel = getListModelHolder().getModel();
        Tag tag = listModel.getElementAt(rowIndex);
        TagColumn column = getColumn(columnIndex);

        switch (column) {
            case LIBELLE:
                columnValue = tag.getLibelle();
                break;
           
            default:
//                columnValue = getAddressObject(person, column);
                break;
        }

        return columnValue;
    }

    private TagColumn getColumn(int columnIndex) {
        TagColumn[] columns = TagColumn.values();
        TagColumn column = columns[columnIndex];
        return column;
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        return String.class;
    }

    @Override
    public String getColumnName(int column) {
        TagColumn columnObj = getColumn(column);
        String displayName = getColumnDisplayNames().get(columnObj);
        return displayName;
    }
   
}
