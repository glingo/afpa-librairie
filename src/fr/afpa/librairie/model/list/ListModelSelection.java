/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.afpa.librairie.model.list;

import java.util.Observable;
import javax.swing.DefaultListSelectionModel;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 *
 * @author cdi305
 */
public class ListModelSelection<E> extends Observable {

    public ListAdapterListModel<E> listAdapterListModel = new ListAdapterListModel<>();

    private ListSelectionModel listSelectionModel = new DefaultListSelectionModel();

    private ListSelectionAdapter listSelectionAdapter = new ListSelectionAdapter();

    public ListModelSelection() {
        listSelectionModel.addListSelectionListener(listSelectionAdapter);
    }

    public void setListModels(ListAdapterListModel<E> listAdapterListModel,
            ListSelectionModel listSelectionModel) {
        this.listAdapterListModel = listAdapterListModel;
        if (this.listSelectionModel != null) {
            this.listSelectionModel
                    .removeListSelectionListener(listSelectionAdapter);
        }
        this.listSelectionModel = listSelectionModel;
        if (listSelectionModel != null) {
            listSelectionModel.addListSelectionListener(listSelectionAdapter);
        }
    }

    public E getSelection() {
        int minSelectionIndex = listSelectionModel.getMinSelectionIndex();
        E elementAt = null;
        if (minSelectionIndex > -1) {
            elementAt = listAdapterListModel.getElementAt(minSelectionIndex);
        }
        return elementAt;
    }

    private class ListSelectionAdapter implements ListSelectionListener {

        @Override
        public void valueChanged(ListSelectionEvent e) {
            setChanged();
            notifyObservers();
        }

    }

    public void setSelection(E selection) {
        int indexOf = listAdapterListModel.indexOf(selection);
        listSelectionModel.setSelectionInterval(indexOf, indexOf);
    }
}
