
package fr.afpa.librairie.model.list.renderer;

import fr.afpa.librairie.data.bean.Adresse;
import java.awt.Component;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;


public class AdresseListCellRenderer extends JLabel implements ListCellRenderer<Adresse> {
    
    protected DefaultListCellRenderer defaultRenderer = new DefaultListCellRenderer();
   
    @Override
    public Component getListCellRendererComponent(JList<? extends Adresse> list, Adresse value, int index, boolean isSelected, boolean cellHasFocus) {
        JLabel renderer = (JLabel) defaultRenderer.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
        renderer.setText(toString(value));
        return renderer;
    }
    
    private String toString(Adresse adresse) {
        if (adresse == null) {
            return "";
        }
        
        StringBuilder sb = new StringBuilder();
        sb.append(adresse.getNumero() != null ? adresse.getNumero() + " " : "")
          .append(adresse.getVoie())
          .append(", ")        
          .append(adresse.getCp())
          .append(" ")
          .append(adresse.getVille());
        
        return sb.toString();
    }
}
