
package fr.afpa.librairie.model.table;

import fr.afpa.librairie.data.bean.Ouvrage;
import fr.afpa.librairie.model.list.ListModelChangeListener;
import fr.afpa.librairie.model.list.ListModelHolder;
import fr.afpa.librairie.model.table.column.OuvrageColumn;
import java.util.HashMap;
import java.util.Map;
import javax.swing.ListModel;
import javax.swing.table.AbstractTableModel;

public class OuvrageTableModel extends AbstractTableModel {
    
    private final ListModelHolder<Ouvrage> ouvrageListModelHolder = new ListModelHolder<>();
    private final ListModelChangeListener listModelChangeListener = new ListModelChangeListener(this);

    private Map<OuvrageColumn, String> columnDisplayNames;

    public Map<OuvrageColumn, String> getColumnDisplayNames() {
        if(this.columnDisplayNames == null) {
            this.columnDisplayNames = new HashMap<>();
            this.columnDisplayNames.put(OuvrageColumn.TITRE, "Titre");
            this.columnDisplayNames.put(OuvrageColumn.SOUSTITRE, "Sous-titre");
            this.columnDisplayNames.put(OuvrageColumn.RESUME, "Resume");
          
        }
        return this.columnDisplayNames;
    }
    
    public OuvrageTableModel() {
        ouvrageListModelHolder.addListDataListeners(listModelChangeListener);
    }
    
    public final void setListModel(ListModel<Ouvrage> listModel) {
        ouvrageListModelHolder.setModel(listModel);
    }
    
    @Override
    public int getRowCount() {
        ListModel<Ouvrage> listModel = ouvrageListModelHolder.getModel();
        return listModel.getSize();
    }
    
    @Override
    public int getColumnCount() {
        return OuvrageColumn.values().length;
    }
    
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Object columnValue = null;

        ListModel<Ouvrage> listModel = ouvrageListModelHolder.getModel();
        Ouvrage ouvrage = listModel.getElementAt(rowIndex);
        OuvrageColumn column = getColumn(columnIndex);

        switch (column) {
            case TITRE:
                columnValue = ouvrage.getTitre();
                break;
            case SOUSTITRE:
                columnValue = ouvrage.getSousTitre();
                break;
            case RESUME:
                columnValue = ouvrage.getResume();
                break;
            default:
//                columnValue = getAddressObject(person, column);
                break;
        }

        return columnValue;
    }
    
    private OuvrageColumn getColumn(int columnIndex) {
        OuvrageColumn[] columns = OuvrageColumn.values();
        OuvrageColumn column = columns[columnIndex];
        return column;
    }
    
    @Override
    public Class<?> getColumnClass(int columnIndex) {
        return String.class;
    }

    @Override
    public String getColumnName(int column) {
        OuvrageColumn columnObj = getColumn(column);
        String displayName = getColumnDisplayNames().get(columnObj);
        return displayName;
    }
    
    
}
