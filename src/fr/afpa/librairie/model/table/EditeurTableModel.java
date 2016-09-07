
package fr.afpa.librairie.model.table;

import fr.afpa.librairie.data.bean.Editeur;
import fr.afpa.librairie.model.list.ListModelChangeListener;
import fr.afpa.librairie.model.list.ListModelHolder;
import fr.afpa.librairie.model.table.column.EditeurColumn;
import java.util.HashMap;
import java.util.Map;
import javax.swing.ListModel;
import javax.swing.table.AbstractTableModel;

public class EditeurTableModel extends AbstractTableModel {
     private final ListModelHolder<Editeur> genreListModelHolder = new ListModelHolder<>();
    private final ListModelChangeListener listModelChangeListener = new ListModelChangeListener(this);

    private Map<EditeurColumn, String> columnDisplayNames;

    public Map<EditeurColumn, String> getColumnDisplayNames() {
        if (this.columnDisplayNames == null) {
            this.columnDisplayNames = new HashMap<>();
            this.columnDisplayNames.put(EditeurColumn.LIBELLE, "Libelle");

        }
        return this.columnDisplayNames;
    }

    public EditeurTableModel() {
        genreListModelHolder.addListDataListeners(listModelChangeListener);
    }

    public final void setListModel(ListModel<Editeur> listModel) {
        genreListModelHolder.setModel(listModel);
    }

    @Override
    public int getRowCount() {
        ListModel<Editeur> listModel = genreListModelHolder.getModel();
        return listModel.getSize();
    }

    @Override
    public int getColumnCount() {
        return EditeurColumn.values().length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Object columnValue = null;

        ListModel<Editeur> listModel = genreListModelHolder.getModel();
        Editeur editeur = listModel.getElementAt(rowIndex);
        EditeurColumn column = getColumn(columnIndex);

        switch (column) {
            case LIBELLE:
                columnValue = editeur.getLibelle();
                break;
           
            default:
//                columnValue = getAddressObject(person, column);
                break;
        }

        return columnValue;
    }

    private EditeurColumn getColumn(int columnIndex) {
        EditeurColumn[] columns = EditeurColumn.values();
        EditeurColumn column = columns[columnIndex];
        return column;
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        return String.class;
    }

    @Override
    public String getColumnName(int column) {
        EditeurColumn columnObj = getColumn(column);
        String displayName = getColumnDisplayNames().get(columnObj);
        return displayName;
    }
}
