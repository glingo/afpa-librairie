package fr.afpa.librairie.model.table;

import fr.afpa.librairie.data.bean.Adresse;
import fr.afpa.librairie.data.bean.Role;
import fr.afpa.librairie.data.bean.StatutUtilisateur;
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
            this.columnDisplayNames.put(UtilisateurColumn.TELEPHONE, "Numéros de téléphone");
            this.columnDisplayNames.put(UtilisateurColumn.ROLE, "Role");
            this.columnDisplayNames.put(UtilisateurColumn.STATUT_UTILISATEUR, "Statut utilisateur");
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
                sb.append(",");
            }
        }
        //parcours de la liste role. 
        //role = stock le role de l'utilisateur = i
        //ajoute le libelle du role. 
        //met une virgule sauf à la fin : permet de serare par une virgule si il y a deux roles.La virgule n'apparait pas à la fin. 
        
//        user.getRoles().forEach((Role role) -> {
//            sb.append(role.getLibelle()).append(",");
//        });
        
        return sb.toString();
        
    }
    
    private String getStatutUtilisateurObject(Utilisateur utilisateur){
        StringBuilder sb = new StringBuilder();
        
        int len = utilisateur.getStatutUtilisateurs().size();
        
        for(int i = 0; i < len; i++){
            StatutUtilisateur statutUtilisateur = utilisateur.getStatutUtilisateurs().get(i);
            sb.append(statutUtilisateur.getLibelle());
            
            if(i>len - 1){
                sb.append(",");
            }
        }
   
        return sb.toString();
    }
    
    private UtilisateurColumn getColumn(int columnIndex) {
        UtilisateurColumn[] columns = UtilisateurColumn.values();
        UtilisateurColumn column = columns[columnIndex];
        return column;
    }


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
