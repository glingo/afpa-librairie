package fr.afpa.librairie.model.list;

import fr.afpa.librairie.data.bean.Utilisateur;
import java.awt.Component;

import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;

public class UtilisateurListCellRenderer extends JLabel implements ListCellRenderer<Utilisateur> {

    /**
     *
     */
    private static final long serialVersionUID = -1614367901813214864L;

    @Override
    public Component getListCellRendererComponent(JList<? extends Utilisateur> list, Utilisateur value, int index, boolean isSelected, boolean cellHasFocus) {
        String toString = toString(value);
        setText(toString);
        return this;
    }

    private String toString(Utilisateur person) {
        if (person == null) {
            return "";
        }
        StringBuilder personToStringBuilder = new StringBuilder();

        personToStringBuilder.append(person.getNom());
        personToStringBuilder.append(", ");
        personToStringBuilder.append(person.getPrenom());
//        Address address = person.getAddress();
//        if (address != null) {
//            personToStringBuilder.append(", ");
//            personToStringBuilder.append(address.getStreet());
//            personToStringBuilder.append(", ");
//            personToStringBuilder.append(address.getStreetNr());
//            personToStringBuilder.append(", ");
//            personToStringBuilder.append(address.getZipCode());
//            personToStringBuilder.append(", ");
//            personToStringBuilder.append(address.getCity());
//        }
        return personToStringBuilder.toString();
    }

}
