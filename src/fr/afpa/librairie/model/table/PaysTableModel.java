
package fr.afpa.librairie.model.table;

import fr.afpa.librairie.data.bean.Pays;
import fr.afpa.librairie.model.table.column.PaysColumn;
import java.util.HashMap;
import java.util.Map;
import javax.swing.ListModel;

public class PaysTableModel extends TableModel<Pays> {
    
    private Map<PaysColumn, String> columnDisplayNames;

    public Map<PaysColumn, String> getColumnDisplayNames() {
        if (this.columnDisplayNames == null) {
            this.columnDisplayNames = new HashMap<>();
            this.columnDisplayNames.put(PaysColumn.LIBELLE, "Libelle");
            this.columnDisplayNames.put(PaysColumn.CODE, "Code");

        }
        return this.columnDisplayNames;
    }

    @Override
    public int getColumnCount() {
        return PaysColumn.values().length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Object columnValue = null;

        ListModel<Pays> listModel = getListModelHolder().getModel();
        Pays pays = listModel.getElementAt(rowIndex);
        PaysColumn column = getColumn(columnIndex);

        switch (column) {
            case LIBELLE:
                columnValue = pays.getLibelle();
                break;
                
            case CODE:
                columnValue = pays.getCode();
                break;
           
            default:
//                columnValue = getAddressObject(person, column);
                break;
        }

        return columnValue;
    }

    private PaysColumn getColumn(int columnIndex) {
        PaysColumn[] columns = PaysColumn.values();
        PaysColumn column = columns[columnIndex];
        return column;
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        return String.class;
    }

    @Override
    public String getColumnName(int column) {
        PaysColumn columnObj = getColumn(column);
        String displayName = getColumnDisplayNames().get(columnObj);
        return displayName;
    }
   
}
