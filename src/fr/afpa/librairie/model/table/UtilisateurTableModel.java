package fr.afpa.librairie.model.table;

import fr.afpa.librairie.data.bean.Role;
import fr.afpa.librairie.data.bean.Utilisateur;
import fr.afpa.librairie.model.table.column.UtilisateurColumn;
import java.util.HashMap;
import java.util.Map;

import javax.swing.ListModel;

public class UtilisateurTableModel extends TableModel<Utilisateur> {

    private Map<UtilisateurColumn, String> columnDisplayNames;

    public Map<UtilisateurColumn, String> getColumnDisplayNames() {
        if(this.columnDisplayNames == null) {
            this.columnDisplayNames = new HashMap<>();
            this.columnDisplayNames.put(UtilisateurColumn.NOM, "Nom");
            this.columnDisplayNames.put(UtilisateurColumn.PRENOM, "Prenom");
            this.columnDisplayNames.put(UtilisateurColumn.MAIL, "E-mail");
            this.columnDisplayNames.put(UtilisateurColumn.DATE_NAISSANCE, "Date de naissance");
            this.columnDisplayNames.put(UtilisateurColumn.TELEPHONE, "Numéros de téléphone");
            this.columnDisplayNames.put(UtilisateurColumn.ROLE, "Role");
            this.columnDisplayNames.put(UtilisateurColumn.STATUT_UTILISATEUR, "Statut utilisateur");
        }
        return this.columnDisplayNames;
    }

    @Override
    public int getColumnCount() {
        return UtilisateurColumn.values().length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Object columnValue = null;

        ListModel<Utilisateur> listModel = getListModelHolder().getModel();
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
            case ROLE:
                columnValue = getRoleObject(utilisateur);
                break;
            case STATUT_UTILISATEUR:
                columnValue = getStatutUtilisateurObject(utilisateur);
                break;
            
            default:
//                columnValue = getAddressObject(person, column);
                break;
        }

        return columnValue;
    }



    private String getRoleObject(Utilisateur user){
        StringBuilder sb = new StringBuilder();
        //objet string mutable
        
        int len = user.getRoles().size();
        //len = taille de la liste de role/
        
        for (int i = 0; i < len; i++) {
            Role role = user.getRoles().get(i);
            sb.append(role.getLibelle());
            if(i < len - 1) {
                sb.append(", ");
            }
        }

        return sb.toString();
        
    }
    
    private String getStatutUtilisateurObject(Utilisateur utilisateur){
        // le statut ne peut etre null !
        return utilisateur.getStatut().getLibelle();
    }
    
    private UtilisateurColumn getColumn(int columnIndex) {
        UtilisateurColumn[] columns = UtilisateurColumn.values();
        UtilisateurColumn column = columns[columnIndex];
        return column;
    }

    @Override
    public String getColumnName(int column) {
        UtilisateurColumn columnObj = getColumn(column);
        String displayName = getColumnDisplayNames().get(columnObj);
        return displayName;
    }
}
