package fr.afpa.librairie.model.table;

import fr.afpa.librairie.data.bean.Utilisateur;
import fr.afpa.librairie.model.list.ListModelChangeListener;
import fr.afpa.librairie.model.list.ListModelHolder;
import fr.afpa.librairie.model.table.column.UtilisateurColumn;
import java.util.HashMap;
import java.util.Map;

import javax.swing.ListModel;
import javax.swing.table.AbstractTableModel;

public class UtilisateurTableModel extends AbstractTableModel {

    private static final long serialVersionUID = 1547542546403627396L;
    
    private final ListModelHolder<Utilisateur> utilisateurListModelHolder = new ListModelHolder<>();
    private final ListModelChangeListener listModelChangeListener = new ListModelChangeListener(this);

    private Map<UtilisateurColumn, String> columnDisplayNames;

    public Map<UtilisateurColumn, String> getColumnDisplayNames() {
        if(this.columnDisplayNames == null) {
            this.columnDisplayNames = new HashMap<>();
            this.columnDisplayNames.put(UtilisateurColumn.NOM, "Nom");
            this.columnDisplayNames.put(UtilisateurColumn.PRENOM, "Prenom");
            this.columnDisplayNames.put(UtilisateurColumn.MAIL, "E-mail");
            this.columnDisplayNames.put(UtilisateurColumn.DATE_NAISSANCE, "Date de naissance");
        }
        return this.columnDisplayNames;
    }

    public UtilisateurTableModel() {
        utilisateurListModelHolder.addListDataListeners(listModelChangeListener);
    }

    public final void setListModel(ListModel<Utilisateur> listModel) {
        utilisateurListModelHolder.setModel(listModel);
    }

    @Override
    public int getRowCount() {
        ListModel<Utilisateur> listModel = utilisateurListModelHolder.getModel();
        return listModel.getSize();
    }

    @Override
    public int getColumnCount() {
        return UtilisateurColumn.values().length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Object columnValue = null;

        ListModel<Utilisateur> listModel = utilisateurListModelHolder.getModel();
        Utilisateur utilisateur = listModel.getElementAt(rowIndex);
        UtilisateurColumn column = getColumn(columnIndex);

        switch (column) {
            case NOM:
                columnValue = utilisateur.getNom();
                break;
            case PRENOM:
                columnValue = utilisateur.getPrenom();
                break;
            case MAIL:
                columnValue = utilisateur.getEmail();
                break;
            case DATE_NAISSANCE:
                columnValue = utilisateur.getDateNaissance();
                break;
            default:
//                columnValue = getAddressObject(person, column);
                break;
        }

        return columnValue;
    }

    private UtilisateurColumn getColumn(int columnIndex) {
        UtilisateurColumn[] columns = UtilisateurColumn.values();
        UtilisateurColumn column = columns[columnIndex];
        return column;
    }
//
//    private Object getAddressObject(Person person, Column column) {
//        Object columnValue = null;
//        Address address = person.getAddress();
//        if (address != null) {
//            switch (column) {
//                case STREET:
//                    columnValue = address.getStreet();
//                    break;
//                case STREET_NR:
//                    columnValue = address.getStreetNr();
//                    break;
//                case CITY:
//                    columnValue = address.getCity();
//                    break;
//                case ZIP_CODE:
//                    columnValue = address.getZipCode();
//                    break;
//                default:
//                    break;
//            }
//        }
//        return columnValue;
//    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        return String.class;
    }

    @Override
    public String getColumnName(int column) {
        UtilisateurColumn columnObj = getColumn(column);
        String displayName = getColumnDisplayNames().get(columnObj);
        return displayName;
    }
}
