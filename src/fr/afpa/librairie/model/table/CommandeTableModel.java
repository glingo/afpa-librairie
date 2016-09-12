
package fr.afpa.librairie.model.table;

import fr.afpa.librairie.data.bean.Commande;
import fr.afpa.librairie.model.list.ListModelChangeListener;
import fr.afpa.librairie.model.list.ListModelHolder;
import fr.afpa.librairie.model.table.column.CommandeColumn;
import java.util.HashMap;
import java.util.Map;
import javax.swing.ListModel;
import javax.swing.table.AbstractTableModel;

public class CommandeTableModel extends AbstractTableModel{
    
    private final ListModelHolder<Commande> commandeListModelHolder = new ListModelHolder<>();
    private final ListModelChangeListener listModelChangeListener = new ListModelChangeListener(this);

    private Map<CommandeColumn, String> columnDisplayNames;

    public Map<CommandeColumn, String> getColumnDisplayNames() {
        if(this.columnDisplayNames == null) {
            this.columnDisplayNames = new HashMap<>();
            this.columnDisplayNames.put(CommandeColumn.UTILISATEUR, "Client commande");
            this.columnDisplayNames.put(CommandeColumn.NUMERO, "Numéro");
            this.columnDisplayNames.put(CommandeColumn.DATE_COMMANDE, "Date de commande");
            this.columnDisplayNames.put(CommandeColumn.ADRESSE_LIVRAISON, "Adresse de livraison");
            this.columnDisplayNames.put(CommandeColumn.ADRESSE_FACTURATION, "Adresse de facturation");
            
        }
        return this.columnDisplayNames;
    }

    public CommandeTableModel() {
        commandeListModelHolder.addListDataListeners(listModelChangeListener);
    }

    public final void setListModel(ListModel<Commande> listModel) {
        commandeListModelHolder.setModel(listModel);
    }

    @Override
    public int getRowCount() {
        ListModel<Commande> listModel = commandeListModelHolder.getModel();
        return listModel.getSize();
    }

    @Override
    public int getColumnCount() {
        return CommandeColumn.values().length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Object columnValue = null;

        ListModel<Commande> listModel = commandeListModelHolder.getModel();
        Commande commande = listModel.getElementAt(rowIndex);
        CommandeColumn column = getColumn(columnIndex);

        switch (column) {
            case UTILISATEUR:
                columnValue = getUtilisateurObject(commande);
                break;
            case NUMERO:
                columnValue = commande.getNumero();
                break;
            case DATE_COMMANDE:
                columnValue = commande.getDateCommande();
                break;
//            case ADRESSE_LIVRAISON:
//                columnValue = getAdresseLivraisonObject(commande);
//                break;
//            case ADRESSE_FACTURATION:
//                columnValue = getAdresseFacturationObject(commande);
//                break;
            default:
//                columnValue = getAddressObject(person, column);
                break;
        }

        return columnValue;
    }
    
    
    
    private String getUtilisateurObject(Commande commande){
        return commande.getUser().getNom();
    }
    
//    private String getAdresseLivraisonObject(Commande commande){
//        
//    }
//    
//    private String getAdresseFacturationObject(Commande commande){
//        
//    }
    
    
    private CommandeColumn getColumn(int columnIndex) {
        CommandeColumn[] columns = CommandeColumn.values();
        CommandeColumn column = columns[columnIndex];
        return column;
    }


    @Override
    public Class<?> getColumnClass(int columnIndex) {
        return String.class;
    }

    @Override
    public String getColumnName(int column) {
        CommandeColumn columnObj = getColumn(column);
        String displayName = getColumnDisplayNames().get(columnObj);
        return displayName;
    }
}
