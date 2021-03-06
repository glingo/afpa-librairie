
package fr.afpa.librairie.model.table;

import fr.afpa.librairie.data.bean.Commande;
import fr.afpa.librairie.model.table.column.CommandeColumn;
import java.util.HashMap;
import java.util.Map;
import javax.swing.ListModel;

public class CommandeTableModel extends TableModel<Commande> {
    
    private Map<CommandeColumn, String> columnDisplayNames;

    public Map<CommandeColumn, String> getColumnDisplayNames() {
        if(this.columnDisplayNames == null) {
            this.columnDisplayNames = new HashMap<>();
            this.columnDisplayNames.put(CommandeColumn.ADRESSE_LIVRAISON, "Adresse de livraison");
            this.columnDisplayNames.put(CommandeColumn.ADRESSE_FACTURATION, "Adresse de facturation");
            this.columnDisplayNames.put(CommandeColumn.UTILISATEUR, "Client de la commande");
            this.columnDisplayNames.put(CommandeColumn.NUMERO, "Numéro de la commande");
            this.columnDisplayNames.put(CommandeColumn.DATE_COMMANDE, "Date de la commande");
            this.columnDisplayNames.put(CommandeColumn.STATUT_COMMANDE, "Statut de la commande");
            
        }
        return this.columnDisplayNames;
    }
    
    @Override
    public int getColumnCount() {
        return CommandeColumn.values().length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Object columnValue = null;

        ListModel<Commande> listModel = getListModelHolder().getModel();
        Commande commande = listModel.getElementAt(rowIndex);
        CommandeColumn column = getColumn(columnIndex);

        switch (column) {
//            case ADRESSE_LIVRAISON:
//                columnValue = getAdresseLivraisonObject(commande);
//                break;
//            case ADRESSE_FACTURATION:
//                columnValue = getAdresseFacturationObject(commande);
//                break;
            case UTILISATEUR:
                columnValue = getUtilisateurObject(commande);
                break;
            case NUMERO:
                columnValue = commande.getNumero();
                break;
            case DATE_COMMANDE:
                columnValue = commande.getDateCommande();
                break;
            case STATUT_COMMANDE:
                columnValue = getStatutCommandeObject(commande);
                break;
                  
            default:
//                columnValue = getAddressObject(person, column);
                break;
        }

        return columnValue;
    }
    
    private String getStatutCommandeObject(Commande commande){
        return commande.getOrderStat().getLibelle();
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
