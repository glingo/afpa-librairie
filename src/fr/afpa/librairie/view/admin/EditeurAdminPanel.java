
package fr.afpa.librairie.view.admin;

import fr.afpa.librairie.controller.EditeurController;
import fr.afpa.librairie.data.bean.Editeur;
import fr.afpa.librairie.model.list.ListAdapterListModel;
import fr.afpa.librairie.model.list.ListModelSelection;
import fr.afpa.librairie.model.table.EditeurTableModel;
import java.awt.BorderLayout;
import java.awt.Component;
import javax.swing.DefaultListSelectionModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;

public class EditeurAdminPanel extends JPanel {
    
    private EditeurController controller;
    
    private final ListAdapterListModel<Editeur> editeurListModel = new ListAdapterListModel<>();
    private final EditeurTableModel editeurTableModel = new EditeurTableModel();
    private final JTable editeurTable = new JTable(editeurTableModel);
    private final ListSelectionModel selectionModel = new DefaultListSelectionModel();
    private final JList<Editeur> editeurList = new JList<>(editeurListModel);
    private final ListModelSelection<Editeur> listModelSelection = new ListModelSelection<>();

    public EditeurAdminPanel(EditeurController controller) {
        this.controller = controller;
        init();
    }
    
     private void init(){
        setLayout(new BorderLayout());
        
        editeurTable.setSelectionModel(selectionModel);
        editeurTable.setSelectionModel(editeurList.getSelectionModel());
        
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setViewportView(editeurTable);
        
        add(scrollPane, BorderLayout.CENTER);
        add(getFooter(), BorderLayout.SOUTH);
        add(getTitle(), BorderLayout.NORTH);
        
        repaint();
        setVisible(true);
    }
     
    public void setAuteurList(ListAdapterListModel<Editeur> editeurListModel) {
        editeurList.setModel(editeurListModel);
        editeurTableModel.setListModel(editeurListModel);
        listModelSelection.setListModels(editeurListModel, selectionModel);
    }
    
    public JList<Editeur> getEditeurList(){
        return this.editeurList;
    }
    
    private Component getTitle(){
        JPanel title = new JPanel();
        
        JLabel titre = new JLabel("EDITEURS");
        
        title.add(titre);
        
        return title;
    }
    private Component getFooter() {
        JPanel footer = new JPanel();
        
        JButton createButton = new JButton("Creer");
        JButton deleteButton = new JButton("Supprimer");
        JButton viewButton = new JButton("Voir");
        JButton updateButton = new JButton("Mettre à jour");
        
        createButton.setActionCommand("create");
        createButton.addActionListener(controller);
        
        deleteButton.setActionCommand("delete");
        deleteButton.addActionListener(controller);
        
        footer.add(createButton);
        footer.add(deleteButton);
        footer.add(viewButton);
        footer.add(updateButton);
        footer.repaint();
        return footer;
    }
}
