
package fr.afpa.librairie.model.table;

import fr.afpa.librairie.data.bean.Adresse;
import fr.afpa.librairie.data.bean.Auteur;
import fr.afpa.librairie.data.bean.Editeur;
import fr.afpa.librairie.model.table.column.EditeurColumn;
import java.util.HashMap;
import java.util.Map;
import javax.swing.ListModel;

public class EditeurTableModel extends TableModel<Editeur> {
    
    private Map<EditeurColumn, String> columnDisplayNames;

    public Map<EditeurColumn, String> getColumnDisplayNames() {
        if (this.columnDisplayNames == null) {
            this.columnDisplayNames = new HashMap<>();
            this.columnDisplayNames.put(EditeurColumn.LIBELLE, "Libelle");
            this.columnDisplayNames.put(EditeurColumn.ADRESSE, "Adresse");

        }
        return this.columnDisplayNames;
    }

    @Override
    public int getColumnCount() {
        return EditeurColumn.values().length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Object columnValue = null;

        ListModel<Editeur> listModel = getListModelHolder().getModel();
        Editeur editeur = listModel.getElementAt(rowIndex);
        EditeurColumn column = getColumn(columnIndex);

        switch (column) {
            case LIBELLE:
                columnValue = editeur.getLibelle();
                break;
                
            case ADRESSE:
                columnValue = getAddressObject(editeur);
                break;
           
            default:
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

    private Object getAddressObject(Editeur editeur) {
        StringBuilder sb = new StringBuilder();
        Adresse adresse = editeur.getAdresse();
        sb.append(adresse.getNumero() != null ? adresse.getNumero() + " " : "")
          .append(adresse.getVoie())
          .append(", ")        
          .append(adresse.getCp())
          .append(" ")
          .append(adresse.getVille());
        
        return sb.toString();
    }
}
