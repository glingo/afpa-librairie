package fr.afpa.librairie.model.list;

import java.util.List;
import javax.swing.DefaultListModel;

public class ListAdapterListModel<E> extends DefaultListModel<E> {
    
    public void addAll(List<E> elements) {
        elements.stream().forEach(this::addElement);
    }

    public void setList(List<E> elements) {
        removeAllElements();
        addAll(elements);
    }
    
}
