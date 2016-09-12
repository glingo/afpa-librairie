package fr.afpa.librairie.model.list;

import fr.afpa.librairie.data.bean.Rubrique;
import java.awt.Component;

import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;

public class RubriqueListCellRenderer extends JLabel implements ListCellRenderer<Rubrique> {

    public RubriqueListCellRenderer() {
//        setOpaque(true);
        setHorizontalAlignment(CENTER);
        setVerticalAlignment(CENTER);
    }
    
    @Override
    public Component getListCellRendererComponent(JList<? extends Rubrique> list, Rubrique value, int index, boolean isSelected, boolean cellHasFocus) {

//        if (isSelected) {
//            System.out.println("selected " + index);
//            setBackground(list.getSelectionBackground());
//            setForeground(list.getSelectionForeground());
//        } else {
//            setBackground(list.getBackground());
//            setForeground(list.getForeground());
//        }
        
        setText(toString(value));
        
        return this;
    }

    private String toString(Rubrique rubrique) {
        if (rubrique == null) {
            return "";
        }
        
        StringBuilder personToStringBuilder = new StringBuilder();

        personToStringBuilder.append(rubrique.getLibelle());
        
        return personToStringBuilder.toString();
    }

}
