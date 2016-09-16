
package fr.afpa.librairie.model.list.renderer;

import fr.afpa.librairie.data.bean.Taxe;
import java.awt.Component;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;

public class TaxeListCellRenderer extends JLabel implements ListCellRenderer<Taxe>{
    
    
     protected DefaultListCellRenderer defaultRenderer = new DefaultListCellRenderer();
   
    @Override
    public Component getListCellRendererComponent(JList<? extends Taxe> list, Taxe value, int index, boolean isSelected, boolean cellHasFocus) {
        JLabel renderer = (JLabel) defaultRenderer.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
        renderer.setText(toString(value));
        return renderer;
    }
    
    private String toString(Taxe taxe) {
        if (taxe == null) {
            return "";
        }
        
        StringBuilder sb = new StringBuilder();
        sb.append(taxe.getLibelle() != null ? taxe.getLibelle() + " " : "")
          .append(taxe.getLibelle());

        
        return sb.toString();
    }
}
