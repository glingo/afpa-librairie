package fr.afpa.librairie.model.table;

import fr.afpa.librairie.data.bean.Auteur;
import fr.afpa.librairie.data.bean.Genre;
import fr.afpa.librairie.data.bean.Langue;
import fr.afpa.librairie.data.bean.Ouvrage;
import fr.afpa.librairie.data.bean.Rubrique;
import fr.afpa.librairie.data.bean.Tag;
import fr.afpa.librairie.data.bean.Theme;
import fr.afpa.librairie.model.list.ListModelChangeListener;
import fr.afpa.librairie.model.list.ListModelHolder;
import fr.afpa.librairie.model.table.column.OuvrageColumn;
import java.util.HashMap;
import java.util.Map;
import javax.swing.ListModel;
import javax.swing.table.AbstractTableModel;

public class OuvrageTableModel extends AbstractTableModel {

    private final ListModelHolder<Ouvrage> ouvrageListModelHolder = new ListModelHolder<>();
    private final ListModelChangeListener listModelChangeListener = new ListModelChangeListener(this);

    private Map<OuvrageColumn, String> columnDisplayNames;

    public Map<OuvrageColumn, String> getColumnDisplayNames() {
        if (this.columnDisplayNames == null) {
            this.columnDisplayNames = new HashMap<>();
            this.columnDisplayNames.put(OuvrageColumn.TITRE, "Titre");
            this.columnDisplayNames.put(OuvrageColumn.SOUSTITRE, "Sous-titre");
            this.columnDisplayNames.put(OuvrageColumn.AUTEUR, "Auteur");
            this.columnDisplayNames.put(OuvrageColumn.GENRE, "Genre");
            this.columnDisplayNames.put(OuvrageColumn.THEME, "Theme");
            this.columnDisplayNames.put(OuvrageColumn.RESUME, "Resume");
            this.columnDisplayNames.put(OuvrageColumn.RUBRIQUE, "Rubrique");
            this.columnDisplayNames.put(OuvrageColumn.TAG, "Tag");

        }
        return this.columnDisplayNames;
    }

    public OuvrageTableModel() {
        ouvrageListModelHolder.addListDataListeners(listModelChangeListener);
    }

    public final void setListModel(ListModel<Ouvrage> listModel) {
        ouvrageListModelHolder.setModel(listModel);
    }

    @Override
    public int getRowCount() {
        ListModel<Ouvrage> listModel = ouvrageListModelHolder.getModel();
        return listModel.getSize();
    }

    @Override
    public int getColumnCount() {
        return OuvrageColumn.values().length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Object columnValue = null;

        ListModel<Ouvrage> listModel = ouvrageListModelHolder.getModel();
        Ouvrage ouvrage = listModel.getElementAt(rowIndex);
        OuvrageColumn column = getColumn(columnIndex);

        switch (column) {
            case TITRE:
                columnValue = ouvrage.getTitre();
                break;
            case SOUSTITRE:
                columnValue = ouvrage.getSousTitre();
                break;
            case AUTEUR:
                columnValue = getAuteurObject(ouvrage);
                break;
            case GENRE:
                columnValue = getGenreObject(ouvrage);
                break;
            case THEME:
                columnValue = getThemeObject(ouvrage);
                break;
            case RESUME:
                columnValue = ouvrage.getResume();
                break;
            case RUBRIQUE:
                columnValue = getRubriqueObject(ouvrage);
                break;
            case TAG:
                columnValue = getTagObject(ouvrage);
                break;
            default:

                break;
        }

        return columnValue;
    }
  
    private String getRubriqueObject(Ouvrage ouvrage){
        StringBuilder sb = new StringBuilder();
        
        int len = ouvrage.getRubriques().size();
        
        for(int i = 0; i < len; i++){
            Rubrique rubrique = ouvrage.getRubriques().get(i);
            sb.append(rubrique.getLibelle());
            
            if(i < len-1){
                sb.append(",");
            }
        }
        
        return sb.toString();
    }
    
    private String getTagObject(Ouvrage ouvrage){
        StringBuilder sb = new StringBuilder();
        
        int len = ouvrage.getTags().size();
        for(int i = 0; i<len; i++){
            Tag tag = ouvrage.getTags().get(i);
            sb.append(tag.getLibelle());
            
            if(i>len-1){
                sb.append(",");
            }
        }
        
        return sb.toString();
    }
    private String getAuteurObject(Ouvrage ouvrage){
        StringBuilder sb = new StringBuilder();
        
        int len = ouvrage.getCoAuteurs().size();
        for(int i = 0; i<len ; i++){
            Auteur auteur = ouvrage.getCoAuteurs().get(i);
            sb.append(auteur.getNom());
            
            if(i>len - 1){
                sb.append(",");
            }
        }
        return sb.toString();
    }
    
    private String getGenreObject(Ouvrage ouvrage){
        StringBuilder sb = new StringBuilder();
        
        int len = ouvrage.getGenres().size();
        for(int i = 0; i<len; i++){
            Genre genre = ouvrage.getGenres().get(i);
            sb.append(genre.getLibelle());
            
            if(i>len - 1){
                sb.append(",");
            }
        }
        
        return sb.toString();
    }
    
    private String getThemeObject(Ouvrage ouvrage){
        StringBuilder sb = new StringBuilder();
        
        int len = ouvrage.getThemes().size();
        for(int i = 0; i<len ; i++){
            Theme theme = ouvrage.getThemes().get(i);
            sb.append(theme.getLibelle());
            
            if(i>len - 1){
                sb.append(",");
            }
        }
        
        return sb.toString();
    }
    
//    private String getLangueObject(Ouvrage ouvrage){
//        StringBuilder sb = new StringBuilder();
//        
//        
//        int len = ouvrage.getLangues().size();
//        for(int i = 0; i<len ; i++){
//            Langue langue = ouvrage.getLangues().get(i);
//            sb.append(langue.getLibelle());
//            
//            if(i> len - 1){
//                sb.append(",");
//            }
//        }
//        
//        
//        return sb.toString();
//    }
    
    private String getLangueObject(Ouvrage ouvrage){
        
        if(ouvrage.getLangues() == null) {
            return "";
        }
        
        StringBuilder sb = new StringBuilder();
        
        int len = ouvrage.getLangues().size();
        for(int i = 0; i<len ; i++){
            Langue langue = ouvrage.getLangues().get(i);
            sb.append(langue.getLibelle());
            
            if(i> len - 1){
                sb.append(",");
            }
        }
        
        
        return sb.toString();
    }
    


    private OuvrageColumn getColumn(int columnIndex) {
        OuvrageColumn[] columns = OuvrageColumn.values();
        OuvrageColumn column = columns[columnIndex];
        return column;
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        return String.class;
    }

    @Override
    public String getColumnName(int column) {
        OuvrageColumn columnObj = getColumn(column);
        String displayName = getColumnDisplayNames().get(columnObj);
        return displayName;
    }

}
