
package fr.afpa.librairie.view.admin;

import fr.afpa.librairie.controller.RubriqueController;
import fr.afpa.librairie.data.bean.Rubrique;
import fr.afpa.librairie.model.list.ListAdapterListModel;
import fr.afpa.librairie.model.list.ListModelSelection;
import fr.afpa.librairie.model.table.RubriqueTableModel;
import java.awt.BorderLayout;
import java.awt.Component;
import javax.swing.DefaultListSelectionModel;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;

public class RubriqueAdminPanel extends JPanel{
    
    private final RubriqueController controller;
    
    private final ListAdapterListModel<Rubrique> rubriqueListModel = new ListAdapterListModel<>();
    private final RubriqueTableModel rubriqueTableModel = new RubriqueTableModel();
    private final JTable rubriqueTable = new JTable(rubriqueTableModel);
    private final ListSelectionModel selectionModel = new DefaultListSelectionModel();
    private final JList<Rubrique> rubriqueList = new JList<>(rubriqueListModel);
    private final ListModelSelection<Rubrique> listModelSelection = new ListModelSelection<>();
    
    public RubriqueAdminPanel(RubriqueController controller) {
        this.controller = controller;
        init();
    }
    
    private void init(){
        setLayout(new BorderLayout());
        
        rubriqueTable.setSelectionModel(selectionModel);
        rubriqueTable.setSelectionModel(rubriqueList.getSelectionModel());
        
        JScrollPane scrollPane = new JScrollPane();
//        scrollPane.setBounds(10, 11, this.frame, 130);
        scrollPane.setViewportView(rubriqueTable);
        
        add(scrollPane, BorderLayout.CENTER);
        add(getFooter(), BorderLayout.SOUTH);
        
        repaint();
        setVisible(true); // Move it to here
    }
    
    
    public void setUtilisateurList(ListAdapterListModel<Rubrique> rubriqueListModel) {
        rubriqueList.setModel(rubriqueListModel);
        rubriqueTableModel.setListModel(rubriqueListModel);
        listModelSelection.setListModels(rubriqueListModel, selectionModel);
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
