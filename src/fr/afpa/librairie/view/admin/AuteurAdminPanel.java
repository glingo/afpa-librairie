
package fr.afpa.librairie.view.admin;

import fr.afpa.librairie.controller.AuteurController;
import fr.afpa.librairie.data.bean.Auteur;
import fr.afpa.librairie.model.list.ListAdapterListModel;
import fr.afpa.librairie.model.list.ListModelSelection;
import fr.afpa.librairie.model.table.AuteurTableModel;
import java.awt.BorderLayout;
import java.awt.Component;
import javax.swing.DefaultListSelectionModel;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;

public class AuteurAdminPanel extends JPanel {
    private AuteurController controller;
    
    private final ListAdapterListModel<Auteur> auteurListModel = new ListAdapterListModel<>();
    private final AuteurTableModel auteurTableModel = new AuteurTableModel();
    private final JTable auteurTable = new JTable(auteurTableModel);
    private final ListSelectionModel selectionModel = new DefaultListSelectionModel();
    private final JList<Auteur> auteurList = new JList<>(auteurListModel);
    private final ListModelSelection<Auteur> listModelSelection = new ListModelSelection<>();

    public AuteurAdminPanel(AuteurController controller) {
        this.controller = controller;
        init();
    }
    
     private void init(){
        setLayout(new BorderLayout());
        
        auteurTable.setSelectionModel(selectionModel);
        auteurTable.setSelectionModel(auteurList.getSelectionModel());
        
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setViewportView(auteurTable);
        
        add(scrollPane, BorderLayout.CENTER);
        add(getFooter(), BorderLayout.SOUTH);
        
        repaint();
        setVisible(true);
    }
     
    public void setAuteurList(ListAdapterListModel<Auteur> auteurListModel) {
        auteurList.setModel(auteurListModel);
        auteurTableModel.setListModel(auteurListModel);
        listModelSelection.setListModels(auteurListModel, selectionModel);
    }
    
    private Component getFooter() {
        JPanel footer = new JPanel();
        
        JButton createButton = new JButton("Creer");
        JButton deleteButton = new JButton("Supprimer");
        JButton viewButton = new JButton("Voir");
        JButton updateButton = new JButton("Mettre à jour");
        
        createButton.setActionCommand("create");
        createButton.addActionListener(controller);
        
        footer.add(createButton);
        footer.add(deleteButton);
        footer.add(viewButton);
        footer.add(updateButton);
        footer.repaint();
        return footer;
    }
}
