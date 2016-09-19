package fr.afpa.librairie.model.list.renderer;

import fr.afpa.librairie.data.bean.Rubrique;
import java.awt.Component;
import javax.swing.DefaultListCellRenderer;

import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;

public class RubriqueListCellRenderer extends JLabel implements ListCellRenderer<Rubrique> {

    protected DefaultListCellRenderer defaultRenderer = new DefaultListCellRenderer();
    
    @Override
    public Component getListCellRendererComponent(JList<? extends Rubrique> list, Rubrique value, int index, boolean isSelected, boolean cellHasFocus) {
        JLabel renderer = (JLabel) defaultRenderer.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
        renderer.setText(toString(value));
        return renderer;
    }

    private String toString(Rubrique rubrique) {
        if (rubrique == null) {
            return "";
        }
        return rubrique.getLibelle();
    }

}
