
package fr.afpa.librairie.model.list.renderer;

import fr.afpa.librairie.data.bean.Theme;
import java.awt.Component;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;

public class ThemeListCellRenderer extends JLabel implements ListCellRenderer<Theme>{
    
    protected DefaultListCellRenderer defaultRenderer = new DefaultListCellRenderer();
   
    @Override
    public Component getListCellRendererComponent(JList<? extends Theme> list, Theme value, int index, boolean isSelected, boolean cellHasFocus) {
        JLabel renderer = (JLabel) defaultRenderer.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
        renderer.setText(toString(value));
        return renderer;
    }
    
    private String toString(Theme theme) {
        if (theme == null) {
            return "";
        }
        
        StringBuilder sb = new StringBuilder();
        sb.append(theme.getLibelle() != null ? theme.getLibelle() + " " : "");


        return sb.toString();
    }
}
