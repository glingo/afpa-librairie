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
            this.columnDisplayNames.put(EditionColumn.AUTEUR, "Auteur");
            this.columnDisplayNames.put(EditionColumn.DATEPUBLI, "Date de publication");
            this.columnDisplayNames.put(EditionColumn.LANGUE, "Langue");
            this.columnDisplayNames.put(EditionColumn.GENRE, "Genre");
            this.columnDisplayNames.put(EditionColumn.THEME, "Theme");
            this.columnDisplayNames.put(EditionColumn.RUBRIQUE, "Rubrique");
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
            case AUTEUR:
                columnValue = getAuteurObject(edition);
                break;
            case DATEPUBLI:
                columnValue = edition.getDatePublication();
                break;
            case LANGUE:
                columnValue = getLangueObject(edition);
                break;
            case GENRE:
                columnValue = getGenreObject(edition);
                break;
            case THEME:
                columnValue = getThemeObject(edition);
                break;
            case RUBRIQUE:
                columnValue = getRubriqueObject(edition);
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

    private String getAuteurObject(Edition edition) {

        if(edition.getOuvrage().getCoAuteurs() == null) {
            return "";
        }
        
        StringBuilder sb = new StringBuilder();
        int len = edition.getOuvrage().getCoAuteurs().size();
        for (int i = 0; i < len; i++) {
            Auteur auteur = edition.getOuvrage().getCoAuteurs().get(i);
            sb.append(auteur.getNom());

            if (i > len - 1) {
                sb.append(",");
            }
        }
        return sb.toString();
    }

    private String getLangueObject(Edition edition) {
        return edition.getLangue().getLibelle();
    }

    private String getGenreObject(Edition edition) {
        StringBuilder sb = new StringBuilder();

        int len = edition.getOuvrage().getGenres().size();
        for (int i = 0; i < len; i++) {
            Genre genre = edition.getOuvrage().getGenres().get(i);
            sb.append(genre.getLibelle());

            if (i < len - 1) {
                sb.append(", ");
            }
        }

        return sb.toString();
    }
    
//manquant le 09/09 lors de l'implementation maison, creait une erreur : rajouté par Eric 
    private String getThemeObject(Edition edition) {
        StringBuilder sb = new StringBuilder();

        int len = edition.getOuvrage().getThemes().size();
        for (int i = 0; i < len; i++) {
            Theme theme = edition.getOuvrage().getThemes().get(i);
            sb.append(theme.getLibelle());

            if (i < len - 1) {
                sb.append(", ");
            }
        }

        return sb.toString();
    }
//manquant le 09/09 lors de l'implementation maison, creait une erreur : rajouté par Eric 
    private String getRubriqueObject(Edition edition) {
        StringBuilder sb = new StringBuilder();

        int len = edition.getOuvrage().getRubriques().size();
        for (int i = 0; i < len; i++) {
            Rubrique rubrique = edition.getOuvrage().getRubriques().get(i);
            sb.append(rubrique.getLibelle());

            if (i < len - 1) {
                sb.append(", ");
            }
        }

        return sb.toString();
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
