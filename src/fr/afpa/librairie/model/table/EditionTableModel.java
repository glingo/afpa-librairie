
package fr.afpa.librairie.model.table;

import fr.afpa.librairie.data.bean.Edition;
import fr.afpa.librairie.model.list.ListModelChangeListener;
import fr.afpa.librairie.model.list.ListModelHolder;
import fr.afpa.librairie.model.table.column.EditionColumn;
import java.util.HashMap;
import java.util.Map;
import javax.swing.ListModel;
import javax.swing.table.AbstractTableModel;

public class EditionTableModel extends AbstractTableModel {
    // forme que doit prendre le stockage des instances d'édition.Modèle de la liste.  

    private final ListModelHolder<Edition> editionListModelHolder = new ListModelHolder<>();
    //appel de la classe ListModelHolder. chemin Librairie/model/list/
    private final ListModelChangeListener listModelChangeListener = new ListModelChangeListener(this);
    //idem que pour le modele de liste précedent.
    
    private Map<EditionColumn, String> columnDisplayNames;
    

    public Map<EditionColumn, String> getColumnDisplayNames() {
        //appel de la classe EditionColumn : on recupere le nom des colonnes propres à la listeEdition. 
        if(this.columnDisplayNames == null) {
            this.columnDisplayNames = new HashMap<>();
            this.columnDisplayNames.put(EditionColumn.ISBN, "Isbn");
            this.columnDisplayNames.put(EditionColumn.DATEPUBLI, "Date de publication");
            this.columnDisplayNames.put(EditionColumn.PRIXHT, "PrixHT");
            this.columnDisplayNames.put(EditionColumn.COUVERTURE, "Image de couverture");
            this.columnDisplayNames.put(EditionColumn.TITRE, "Titre");
            this.columnDisplayNames.put(EditionColumn.STOCK, "Stock");
        }
        return this.columnDisplayNames;
    }
    
    //constructeur
    public EditionTableModel() {
        editionListModelHolder.addListDataListeners(listModelChangeListener);
    }
    
    //setter et getter de EditionTableModel
    
     public final void setListModel(ListModel<Edition> listModel) {
        editionListModelHolder.setModel(listModel);
    }

    @Override
    public int getRowCount() {
        //retourne la taille (nre de ligne) de la liste d'Edition
        ListModel<Edition> listModel = editionListModelHolder.getModel();
        return listModel.getSize();
    }

    @Override
    public int getColumnCount() {
        //retourne le nombre de colonne de la liste
        return EditionColumn.values().length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Object columnValue = null;

        ListModel<Edition> listModel = editionListModelHolder.getModel();
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
            case PRIXHT:
                columnValue = edition.getPrixHt();
                break;
            case COUVERTURE:
                columnValue = edition.getCouverture();
                break;
            case TITRE :
                columnValue = edition.getTitre();
                break;
            case STOCK:
                columnValue = edition.getStock();
                break;
            default:

                break;
        }

        return columnValue;
        //retourne la valeur de la colonne selectionnée. 
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
