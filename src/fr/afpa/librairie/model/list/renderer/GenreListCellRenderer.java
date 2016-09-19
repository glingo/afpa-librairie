
package fr.afpa.librairie.model.list.renderer;

import fr.afpa.librairie.data.bean.Genre;
import java.awt.Component;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;

public class GenreListCellRenderer extends JLabel implements ListCellRenderer<Genre> {
    protected DefaultListCellRenderer defaultRenderer = new DefaultListCellRenderer();


    @Override
    public Component getListCellRendererComponent(JList<? extends Genre> list, Genre value, int index, boolean isSelected, boolean cellHasFocus) {
        JLabel renderer = (JLabel) defaultRenderer.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
        renderer.setText(toString(value));
        return renderer;
    }
    
    private String toString(Genre genre) {
        if (genre == null) {
            return "";
        }
        
        StringBuilder sb = new StringBuilder();
        sb.append(genre.getLibelle() != null ? genre.getLibelle() + " " : "");

        return sb.toString();
    }
}
