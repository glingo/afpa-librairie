
package fr.afpa.librairie.model.table;

import fr.afpa.librairie.data.bean.Promotion;
import fr.afpa.librairie.model.list.ListModelChangeListener;
import fr.afpa.librairie.model.list.ListModelHolder;
import fr.afpa.librairie.model.table.column.CommandeColumn;
import fr.afpa.librairie.model.table.column.PromotionColumn;
import java.util.HashMap;
import java.util.Map;
import javax.swing.ListModel;
import javax.swing.table.AbstractTableModel;

public class PromotionTableModel extends AbstractTableModel{
    
    private final ListModelHolder<Promotion> promoListModelHolder = new ListModelHolder<>();
    private final ListModelChangeListener listModelChangeListener = new ListModelChangeListener(this);

    private Map<PromotionColumn, String> columnDisplayNames;

    public Map<PromotionColumn, String> getColumnDisplayNames() {
        if(this.columnDisplayNames == null) {
            this.columnDisplayNames = new HashMap<>();
            this.columnDisplayNames.put(PromotionColumn.DATE_DEBUT, "Date de debut");
            this.columnDisplayNames.put(PromotionColumn.DATE_FIN, "Date de fin");
            this.columnDisplayNames.put(PromotionColumn.DESCRIPTION, "Description");
            this.columnDisplayNames.put(PromotionColumn.REDUCTION, "Reduction");
        }
        return this.columnDisplayNames;
    }

    public PromotionTableModel() {
        promoListModelHolder.addListDataListeners(listModelChangeListener);
    }

    public final void setListModel(ListModel<Promotion> listModel) {
        promoListModelHolder.setModel(listModel);
    }

    @Override
    public int getRowCount() {
        ListModel<Promotion> listModel = promoListModelHolder.getModel();
        return listModel.getSize();
    }

    @Override
    public int getColumnCount() {
        return CommandeColumn.values().length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Object columnValue = null;

        ListModel<Promotion> listModel = promoListModelHolder.getModel();
        Promotion promo = listModel.getElementAt(rowIndex);
        PromotionColumn column = getColumn(columnIndex);

        switch (column) {
            case DATE_DEBUT:
                columnValue = promo.getDateDebut();
                break;
            case DATE_FIN:
                columnValue = promo.getDateFin();
                break;
            case REDUCTION:
                columnValue = promo.getReduction();
                break;
            case DESCRIPTION:
                columnValue = promo.getDescription();
                break;

            default:
//                columnValue = getAddressObject(person, column);
                break;
        }

        return columnValue;
    }

    private PromotionColumn getColumn(int columnIndex) {
        PromotionColumn[] columns = PromotionColumn.values();
        PromotionColumn column = columns[columnIndex];
        return column;
    }


    @Override
    public Class<?> getColumnClass(int columnIndex) {
        return String.class;
    }

    @Override
    public String getColumnName(int column) {
        PromotionColumn columnObj = getColumn(column);
        String displayName = getColumnDisplayNames().get(columnObj);
        return displayName;
    }
}
