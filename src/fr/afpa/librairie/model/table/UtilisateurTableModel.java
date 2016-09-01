package fr.afpa.librairie.model.table;

import fr.afpa.librairie.data.bean.Utilisateur;
import fr.afpa.librairie.model.list.ListModelHolder;
import java.util.HashMap;
import java.util.Map;

import javax.swing.ListModel;
import javax.swing.event.ListDataEvent;
import javax.swing.event.ListDataListener;
import javax.swing.table.AbstractTableModel;

public class UtilisateurTableModel extends AbstractTableModel {

    private static final long serialVersionUID = 1547542546403627396L;
    
    private class ListModelChangeListener implements ListDataListener {

        @Override
        public void intervalAdded(ListDataEvent e) {
            fireTableDataChanged();
        }

        @Override
        public void intervalRemoved(ListDataEvent e) {
            fireTableDataChanged();
        }

        @Override
        public void contentsChanged(ListDataEvent e) {
            fireTableDataChanged();
        }

    }

    
//    private Long id;
//    private String nom;
//    private String prenom;
//    private String motDePasse;
//    private String email;
//    private Date dateInscription;
    private enum Column {
        NOM, PRENOM, EMAIL, DATE_INSCRIPTION
    }

    private final ListModelHolder<Utilisateur> utilisateurListModelHolder = new ListModelHolder<>();
    private final ListModelChangeListener listModelChangeListener = new ListModelChangeListener();

    private final Map<Column, String> columnDisplayNames = new HashMap<>();

    public UtilisateurTableModel() {
        
        columnDisplayNames.put(Column.NOM, "Nom");
        columnDisplayNames.put(Column.PRENOM, "Prenom");
        columnDisplayNames.put(Column.EMAIL, "E-mail");
        columnDisplayNames.put(Column.DATE_INSCRIPTION, "Date d'inscription");

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
        return Column.values().length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Object columnValue = null;

        ListModel<Utilisateur> listModel = utilisateurListModelHolder.getModel();
        Utilisateur utilisateur = listModel.getElementAt(rowIndex);
        Column column = getColumn(columnIndex);

        switch (column) {
            case NOM:
                columnValue = utilisateur.getNom();
                break;
            case PRENOM:
                columnValue = utilisateur.getPrenom();
                break;
            default:
//                columnValue = getAddressObject(person, column);
                break;
        }

        return columnValue;
    }

    private Column getColumn(int columnIndex) {
        Column[] columns = Column.values();
        Column column = columns[columnIndex];
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
        Column columnObj = getColumn(column);
        String displayName = columnDisplayNames.get(columnObj);
        return displayName;
    }
}
