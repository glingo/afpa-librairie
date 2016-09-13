package fr.afpa.librairie.model.list.renderer;

import fr.afpa.librairie.data.bean.Ouvrage;
import fr.afpa.librairie.data.bean.Rubrique;
import java.awt.Component;

import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;

public class OuvrageListCellRenderer extends JLabel implements ListCellRenderer<Ouvrage> {

    public OuvrageListCellRenderer() {
//        setOpaque(true);
        setHorizontalAlignment(CENTER);
        setVerticalAlignment(CENTER);
    }
    
    @Override
    public Component getListCellRendererComponent(JList<? extends Ouvrage> list, Ouvrage value, int index, boolean isSelected, boolean cellHasFocus) {

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

    private String toString(Ouvrage ouvrage) {
        if (ouvrage == null) {
            return "";
        }
        
        StringBuilder sb = new StringBuilder();

        sb.append(ouvrage.getTitre());
        
        return sb.toString();
    }

}
