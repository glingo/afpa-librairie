
package fr.afpa.librairie.model.list.renderer;

import fr.afpa.librairie.data.bean.Auteur;
import java.awt.Component;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;


public class AuteurListCellRenderer extends JLabel implements ListCellRenderer<Auteur> {
   
    protected DefaultListCellRenderer defaultRenderer = new DefaultListCellRenderer();
    
    @Override
    public Component getListCellRendererComponent(JList<? extends Auteur> list, Auteur value, int index, boolean isSelected, boolean cellHasFocus) {
        JLabel renderer = (JLabel) defaultRenderer.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
        renderer.setText(toString(value));
        return renderer;
    }

    private String toString(Auteur auteur) {
        if (auteur == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();

        sb.append(auteur.getNom())
          .append(auteur.getPrenom() != null ? ", " + auteur.getPrenom() : "");

        return sb.toString();
    }
}
