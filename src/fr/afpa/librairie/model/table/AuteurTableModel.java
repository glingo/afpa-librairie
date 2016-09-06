package fr.afpa.librairie.model.table;

import fr.afpa.librairie.data.bean.Auteur;
import fr.afpa.librairie.model.list.ListModelChangeListener;
import fr.afpa.librairie.model.list.ListModelHolder;
import fr.afpa.librairie.model.table.column.AuteurColumn;
import java.util.HashMap;
import java.util.Map;
import javax.swing.ListModel;
import javax.swing.table.AbstractTableModel;

public class AuteurTableModel extends AbstractTableModel {

    private static final long serialVersionUID = 1547542546403627396L;

    private final ListModelHolder<Auteur> auteurListModelHolder = new ListModelHolder<>();
    private final ListModelChangeListener listModelChangeListener = new ListModelChangeListener(this);

    private Map<AuteurColumn, String> columnDisplayNames;

    public Map<AuteurColumn, String> getColumnDisplayNames() {
        if (this.columnDisplayNames == null) {
            this.columnDisplayNames = new HashMap<>();
            this.columnDisplayNames.put(AuteurColumn.NOM, "Nom");
            this.columnDisplayNames.put(AuteurColumn.PRENOM, "Prenom");
            this.columnDisplayNames.put(AuteurColumn.DATE_NAISSANCE, "Date de naissance");
            this.columnDisplayNames.put(AuteurColumn.DATE_DECES, "Date de décès");
        }
        return this.columnDisplayNames;
    }

    public AuteurTableModel() {
        auteurListModelHolder.addListDataListeners(listModelChangeListener);
    }

    public final void setListModel(ListModel<Auteur> listModel) {
        auteurListModelHolder.setModel(listModel);
    }

    @Override
    public int getRowCount() {
        ListModel<Auteur> listModel = auteurListModelHolder.getModel();
        return listModel.getSize();
    }

    @Override
    public int getColumnCount() {
        return AuteurColumn.values().length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Object columnValue = null;

        ListModel<Auteur> listModel = auteurListModelHolder.getModel();
        Auteur auteur = listModel.getElementAt(rowIndex);
        AuteurColumn column = getColumn(columnIndex);

        switch (column) {
            case NOM:
                columnValue = auteur.getNom();
                break;
            case PRENOM:
                columnValue = auteur.getPrenom();
                break;
            case DATE_NAISSANCE:
                columnValue = auteur.getDateNaissance();
                break;
            case DATE_DECES:
                columnValue = auteur.getDateDeces();
                break;

            default:
//                columnValue = getAddressObject(person, column);
                break;
        }

        return columnValue;
    }

    private AuteurColumn getColumn(int columnIndex) {
        AuteurColumn[] columns = AuteurColumn.values();
        AuteurColumn column = columns[columnIndex];
        return column;
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        return String.class;
    }

    @Override
    public String getColumnName(int column) {
        AuteurColumn columnObj = getColumn(column);
        String displayName = getColumnDisplayNames().get(columnObj);
        return displayName;
    }

}
