
package fr.afpa.librairie.model.list.renderer;

import fr.afpa.librairie.data.bean.Langue;
import java.awt.Component;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;

public class LangueListCellRenderer extends JLabel implements ListCellRenderer<Langue> {
    
    protected DefaultListCellRenderer defaultRenderer = new DefaultListCellRenderer();
   
    @Override
    public Component getListCellRendererComponent(JList<? extends Langue> list, Langue value, int index, boolean isSelected, boolean cellHasFocus) {
        JLabel renderer = (JLabel) defaultRenderer.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
        renderer.setText(toString(value));
        return renderer;
    }
    
    private String toString(Langue langue) {
        if (langue == null) {
            return "";
        }
        
        StringBuilder sb = new StringBuilder();
        sb.append(langue.getLibelle() != null ? langue.getLibelle() + " " : "")
          .append(langue.getCode());

        return sb.toString();
    }
}
