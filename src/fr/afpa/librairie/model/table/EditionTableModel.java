package fr.afpa.librairie.model.table;

import fr.afpa.librairie.data.bean.Auteur;
import fr.afpa.librairie.data.bean.Edition;
import fr.afpa.librairie.data.bean.Genre;
import fr.afpa.librairie.data.bean.Theme;
import fr.afpa.librairie.data.bean.Rubrique;
import fr.afpa.librairie.model.table.column.EditionColumn;
import java.util.HashMap;
import java.util.Map;
import javax.swing.ListModel;

public class EditionTableModel extends TableModel<Edition> {

    private Map<EditionColumn, String> columnDisplayNames;

    public Map<EditionColumn, String> getColumnDisplayNames() {
        //appel de la classe EditionColumn : on recupere le nom des colonnes propres à la listeEdition. 
        if (this.columnDisplayNames == null) {
            this.columnDisplayNames = new HashMap<>();
            this.columnDisplayNames.put(EditionColumn.ISBN, "Isbn");
            this.columnDisplayNames.put(EditionColumn.DATEPUBLI, "Date de publication");
            this.columnDisplayNames.put(EditionColumn.LANGUE, "Langue");
            this.columnDisplayNames.put(EditionColumn.PRIXHT, "PrixHT");
            this.columnDisplayNames.put(EditionColumn.COUVERTURE, "Image de couverture");
            this.columnDisplayNames.put(EditionColumn.TITRE, "Titre");
            this.columnDisplayNames.put(EditionColumn.STOCK, "Stock");
            this.columnDisplayNames.put(EditionColumn.STATUT_EDITION, "Statut edition");
        }
        return this.columnDisplayNames;
    }

    @Override
    public int getColumnCount() {
        //retourne le nombre de colonne de la liste
        return EditionColumn.values().length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Object columnValue = null;

        ListModel<Edition> listModel = getListModelHolder().getModel();
        Edition edition = listModel.getElementAt(rowIndex);
        EditionColumn column = getColumn(columnIndex);
        //recuperation des données de la liste Edition en fonction de la colonne choisie. 
        switch (column) {
            case ISBN:
                columnValue = edition.getIsbn();
                break;
            case DATEPUBLI:
                columnValue = edition.getDatePublication();
                break;
            case LANGUE:
                columnValue = getLangueObject(edition);
                break;
            case PRIXHT:
                columnValue = edition.getPrixHt();
                break;
            case COUVERTURE:
                columnValue = edition.getCouverture();
                break;
            case TITRE:
                columnValue = edition.getTitre();
                break;
            case STOCK:
                columnValue = edition.getStock();
                break;
            case STATUT_EDITION:
                columnValue = getStatutEditionObject(edition);
                break;
            default:

                break;
        }

        return columnValue;
        //retourne la valeur de la colonne selectionnée. 
    }
    
    private String getStatutEditionObject(Edition edition){
        return edition.getStatut().getLibelle();
    }

   

    private String getLangueObject(Edition edition) {
        return edition.getLangue().getLibelle();
    }


    private EditionColumn getColumn(int columnIndex) {
        EditionColumn[] columns = EditionColumn.values();
        EditionColumn column = columns[columnIndex];
        return column;
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        return String.class;
    }

    @Override
    public String getColumnName(int column) {
        EditionColumn columnObj = getColumn(column);
        String displayName = getColumnDisplayNames().get(columnObj);
        return displayName;
    }

}
