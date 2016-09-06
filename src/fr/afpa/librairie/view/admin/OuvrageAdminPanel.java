
package fr.afpa.librairie.view.admin;

import fr.afpa.librairie.controller.OuvrageController;
import fr.afpa.librairie.data.bean.Ouvrage;
import fr.afpa.librairie.model.list.ListAdapterListModel;
import fr.afpa.librairie.model.list.ListModelSelection;
import fr.afpa.librairie.model.table.OuvrageTableModel;
import java.awt.BorderLayout;
import java.awt.Component;
import javax.swing.DefaultListSelectionModel;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;

public class OuvrageAdminPanel extends JPanel {
    
    private OuvrageController controller;
    
    private final ListAdapterListModel<Ouvrage> ouvrageListModel = new ListAdapterListModel<>();
    private final OuvrageTableModel ouvrageTableModel = new OuvrageTableModel();
    //créet Ouvrage table model
    private final JTable ouvrageTable = new JTable(ouvrageTableModel);
    private final ListSelectionModel selectionModel = new DefaultListSelectionModel();
    private final JList<Ouvrage> ouvrageList = new JList<>(ouvrageListModel);
    private final ListModelSelection<Ouvrage> listModelSelection = new ListModelSelection<>();
    
    public OuvrageAdminPanel(OuvrageController controller) {
        this.controller = controller;
        init();
    }
    
    private void init(){
        setLayout(new BorderLayout());
        
        ouvrageTable.setSelectionModel(selectionModel);
        ouvrageTable.setSelectionModel(ouvrageList.getSelectionModel());
        
        JScrollPane scrollPane = new JScrollPane();
//        scrollPane.setBounds(10, 11, this.frame, 130);
        scrollPane.setViewportView(ouvrageTable);
        
        add(scrollPane, BorderLayout.CENTER);
        add(getFooter(), BorderLayout.SOUTH);
        
        repaint();
        setVisible(true); // Move it to here
    }
    
    
    public void setOuvrageList(ListAdapterListModel<Ouvrage> ouvrageListModel) {
        ouvrageList.setModel(ouvrageListModel);
        ouvrageTableModel.setListModel(ouvrageListModel);
        listModelSelection.setListModels(ouvrageListModel, selectionModel);
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
