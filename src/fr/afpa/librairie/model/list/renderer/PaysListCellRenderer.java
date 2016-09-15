
package fr.afpa.librairie.model.list.renderer;

import fr.afpa.librairie.data.bean.Adresse;
import fr.afpa.librairie.data.bean.Pays;
import java.awt.Component;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;


public class PaysListCellRenderer extends JLabel implements ListCellRenderer<Pays> {
    
    protected DefaultListCellRenderer defaultRenderer = new DefaultListCellRenderer();
   
    @Override
    public Component getListCellRendererComponent(JList<? extends Pays> list, Pays value, int index, boolean isSelected, boolean cellHasFocus) {
        JLabel renderer = (JLabel) defaultRenderer.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
        renderer.setText(toString(value));
        return renderer;
    }
    
    private String toString(Pays pays) {
        if (pays == null) {
            return "";
        }
        
        StringBuilder sb = new StringBuilder();
        
        sb.append(pays.getCode())
          .append(", ")        
          .append(pays.getLibelle());
        
        return sb.toString();
    }
}
