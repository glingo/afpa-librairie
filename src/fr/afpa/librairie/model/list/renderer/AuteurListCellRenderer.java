
package fr.afpa.librairie.model.list.renderer;

import fr.afpa.librairie.data.bean.Auteur;
import java.awt.Component;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;


public class AuteurListCellRenderer extends JLabel implements ListCellRenderer<Auteur> {
    /**
     *
     */
    private static final long serialVersionUID = -1614367901813214864L;
    //identifiant unique. cf : deserialize, serialize.
    
    @Override
    public Component getListCellRendererComponent(JList<? extends Auteur> list, Auteur value, int index, boolean isSelected, boolean cellHasFocus) {
        String toString = toString(value);
        setText(toString);
        return this;
    }

    private String toString(Auteur person) {
        if (person == null) {
            return "";
        }
        StringBuilder personToStringBuilder = new StringBuilder();

        personToStringBuilder.append(person.getNom());
        personToStringBuilder.append(", ");
        personToStringBuilder.append(person.getPrenom());
        

        return personToStringBuilder.toString();
    }
}
