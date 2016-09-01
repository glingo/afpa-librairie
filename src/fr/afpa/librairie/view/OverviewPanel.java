package fr.afpa.librairie.view;

import fr.afpa.librairie.data.bean.Utilisateur;
import fr.afpa.librairie.model.list.ListAdapterListModel;
import fr.afpa.librairie.model.list.ListModelSelection;
import fr.afpa.librairie.model.list.UtilisateurListCellRenderer;
import fr.afpa.librairie.model.table.UtilisateurTableModel;
import javax.swing.DefaultListSelectionModel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListCellRenderer;
import javax.swing.ListSelectionModel;

public class OverviewPanel extends JPanel {

    private UtilisateurTableModel utilisateurTableModel = new UtilisateurTableModel();
    private ListAdapterListModel<Utilisateur> utilisateurListModel = new ListAdapterListModel<>();

    private JTable utilisateurTable = new JTable(utilisateurTableModel);
    private JList<Utilisateur> utilisateurList = new JList<>(utilisateurListModel);
    private ListSelectionModel selectionModel = new DefaultListSelectionModel();
    private ListModelSelection<Utilisateur> listModelSelection = new ListModelSelection<>();

    public OverviewPanel() {
        setLayout(null);
//        selectionModel.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
//        treeSelectionListModelSelectionAdapter
//                .setListModelSelection(listModelSelection);
        utilisateurList.setSelectionModel(selectionModel);
        utilisateurTable.setSelectionModel(selectionModel);
//        personComboBoxModel.setListSelectionModel(selectionModel);
//        personTree.setSelectionModel(treeSelectionListModelSelectionAdapter);

        ListCellRenderer<Utilisateur> personRenderer = new UtilisateurListCellRenderer();
        utilisateurList.setCellRenderer(personRenderer);
        utilisateurList.setEnabled(true);
//        personsComboBox.setRenderer(personRenderer);
//        personTree.setCellRenderer(new PersonTreeCellRenderer());
//        personTree.setRootVisible(false);
        utilisateurTable.setSelectionModel(utilisateurList.getSelectionModel());

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(10, 11, 580, 130);
        add(scrollPane);

        scrollPane.setViewportView(utilisateurTable);

//        personsComboBox.setBounds(10, 153, 580, 30);
//        add(personsComboBox);

        JScrollPane scrollPane_1 = new JScrollPane();
        scrollPane_1.setBounds(10, 194, 580, 105);
        add(scrollPane_1);

        scrollPane_1.setViewportView(utilisateurList);

        JScrollPane scrollPane_2 = new JScrollPane();
        scrollPane_2.setBounds(10, 310, 580, 205);
        add(scrollPane_2);

//        scrollPane_2.setColumnHeaderView(personTree);
    }
    
    public void setUtilisateurList(ListAdapterListModel<Utilisateur> utilisateurListModel) {
        utilisateurList.setModel(utilisateurListModel);
        utilisateurTableModel.setListModel(utilisateurListModel);
//        personTreeModel.setListModel(utilisateurListModel);
//        personComboBoxModel.setListModel(utilisateurListModel);
        listModelSelection.setListModels(utilisateurListModel, selectionModel);
    }
}
