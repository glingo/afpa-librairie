
package fr.afpa.librairie.model.table;

import fr.afpa.librairie.data.bean.Ouvrage;
import fr.afpa.librairie.data.bean.Rubrique;
import fr.afpa.librairie.model.table.column.RubriqueColumn;
import java.util.HashMap;
import java.util.Map;
import javax.swing.ListModel;

public class RubriqueTableModel extends TableModel<Rubrique> {
    
    private Map<RubriqueColumn, String> columnDisplayNames;

    public Map<RubriqueColumn, String> getColumnDisplayNames() {
        if (this.columnDisplayNames == null) {
            this.columnDisplayNames = new HashMap<>();
            this.columnDisplayNames.put(RubriqueColumn.LIBELLE, "Libelle");
            this.columnDisplayNames.put(RubriqueColumn.DATEDEBUT, "Date de début");
            this.columnDisplayNames.put(RubriqueColumn.DATEFIN, "Date de fin");
            this.columnDisplayNames.put(RubriqueColumn.COMMENTAIRE, "Commentaire");
            this.columnDisplayNames.put(RubriqueColumn.OUVRAGE, "Ouvrage");
        }
        return this.columnDisplayNames;
    }

    public RubriqueTableModel() {}

    @Override
    public int getColumnCount() {
        return RubriqueColumn.values().length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Object columnValue = null;

        ListModel<Rubrique> listModel = getListModelHolder().getModel();
        Rubrique rubrique = listModel.getElementAt(rowIndex);
        RubriqueColumn column = getColumn(columnIndex);

        switch (column) {
            case LIBELLE:
                columnValue = rubrique.getLibelle();
                break;
            case DATEDEBUT:
                columnValue = rubrique.getDateDebut();
                break;
            case DATEFIN:
                columnValue = rubrique.getDateFin();
                break;
            case COMMENTAIRE:
                columnValue = rubrique.getCommentaire();
                break;
            case OUVRAGE:
                columnValue = getOuvrageObject(rubrique);
                break;
            default:
//                columnValue = getAddressObject(person, column);
                break;
        }

        return columnValue;
    }
    

    private RubriqueColumn getColumn(int columnIndex) {
        RubriqueColumn[] columns = RubriqueColumn.values();
        RubriqueColumn column = columns[columnIndex];
        return column;
    }

    @Override
    public String getColumnName(int column) {
        RubriqueColumn columnObj = getColumn(column);
        String displayName = getColumnDisplayNames().get(columnObj);
        return displayName;
    }
    
    private String getOuvrageObject(Rubrique rubrique){
        StringBuilder sb = new StringBuilder();
        System.out.println("hello");
        int len = rubrique.getOuvrage().size();
        System.out.println("hello2");
        for(int i = 0; i < len; i++){
            Ouvrage ouvrage = rubrique.getOuvrage().get(i);
            sb.append(ouvrage.getTitre());

            if(i < len-1){
                sb.append(", ");
            }
        }
        
        return sb.toString();
    }
    
}
