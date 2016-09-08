
package fr.afpa.librairie.model.table;

import fr.afpa.librairie.data.bean.Adresse;
import fr.afpa.librairie.model.list.ListModelChangeListener;
import fr.afpa.librairie.model.list.ListModelHolder;
import fr.afpa.librairie.model.table.column.AdresseColumn;
import java.util.HashMap;
import java.util.Map;
import javax.swing.ListModel;
import javax.swing.table.AbstractTableModel;

public class AdresseTableModel extends AbstractTableModel{
    
    private final ListModelHolder<Adresse> adresseListModelHolder = new ListModelHolder<>();
    private final ListModelChangeListener listModelChangeListener = new ListModelChangeListener(this);

    private Map<AdresseColumn, String> columnDisplayNames;

    public Map<AdresseColumn, String> getColumnDisplayNames() {
        if (this.columnDisplayNames == null) {
            this.columnDisplayNames = new HashMap<>();
            this.columnDisplayNames.put(AdresseColumn.NUMERO, "Nom");
            this.columnDisplayNames.put(AdresseColumn.VOIE, "Prenom");
            this.columnDisplayNames.put(AdresseColumn.CODEPOSTAL, "Date de naissance");
            this.columnDisplayNames.put(AdresseColumn.VILLE, "Ville");
            this.columnDisplayNames.put(AdresseColumn.COMPLEMENT, "Complement");
        }
        return this.columnDisplayNames;
    }

    public AdresseTableModel() {
        adresseListModelHolder.addListDataListeners(listModelChangeListener);
    }

    public final void setListModel(ListModel<Adresse> listModel) {
        adresseListModelHolder.setModel(listModel);
    }

    @Override
    public int getRowCount() {
        ListModel<Adresse> listModel = adresseListModelHolder.getModel();
        return listModel.getSize();
    }

    @Override
    public int getColumnCount() {
        return AdresseColumn.values().length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Object columnValue = null;

        ListModel<Adresse> listModel = adresseListModelHolder.getModel();
        Adresse adresse = listModel.getElementAt(rowIndex);
        AdresseColumn column = getColumn(columnIndex);

        switch (column) {
            case NUMERO:
                columnValue = adresse.getNumero();
                break;
            case VOIE:
                columnValue = adresse.getVoie();
                break;
            case CODEPOSTAL:
                columnValue = adresse.getCp();
                break;
            case VILLE:
                columnValue = adresse.getVille();
                break;
            case COMPLEMENT:
                columnValue = adresse.getComplement();
                break;
            default:

                break;
        }

        return columnValue;
    }

    private AdresseColumn getColumn(int columnIndex) {
        AdresseColumn[] columns = AdresseColumn.values();
        AdresseColumn column = columns[columnIndex];
        return column;
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        return String.class;
    }

    @Override
    public String getColumnName(int column) {
        AdresseColumn columnObj = getColumn(column);
        String displayName = getColumnDisplayNames().get(columnObj);
        return displayName;
    }
}
