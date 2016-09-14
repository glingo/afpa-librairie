package fr.afpa.librairie.model.table;

import fr.afpa.librairie.data.bean.Adresse;
import fr.afpa.librairie.model.table.column.AdresseColumn;
import java.util.HashMap;
import java.util.Map;
import javax.swing.ListModel;

public class AdresseTableModel extends TableModel<Adresse> {
    
    private Map<AdresseColumn, String> columnDisplayNames;

    public Map<AdresseColumn, String> getColumnDisplayNames() {
        if (this.columnDisplayNames == null) {
            this.columnDisplayNames = new HashMap<>();
            this.columnDisplayNames.put(AdresseColumn.NUMERO, "Numero");
            this.columnDisplayNames.put(AdresseColumn.VOIE, "Voie");
            this.columnDisplayNames.put(AdresseColumn.CODEPOSTAL, "Code postal");
            this.columnDisplayNames.put(AdresseColumn.VILLE, "Ville");
            this.columnDisplayNames.put(AdresseColumn.COMPLEMENT, "Complement");
        }
        return this.columnDisplayNames;
    }

    @Override
    public int getColumnCount() {
        return AdresseColumn.values().length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Object columnValue = null;

        ListModel<Adresse> listModel = getListModelHolder().getModel();
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
