
package fr.afpa.librairie.view.admin;

import fr.afpa.librairie.controller.EditionController;
import fr.afpa.librairie.data.bean.Edition;
import fr.afpa.librairie.model.list.ListAdapterListModel;
import fr.afpa.librairie.model.list.ListModelSelection;
import fr.afpa.librairie.model.table.EditionTableModel;
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

public class EditionAdminPanel extends JPanel{
    
    //appel du controller = permet au controller d'écouter la vue. 
    private final EditionController controller;
    
    
    //composant du panel ?? 
    private final ListAdapterListModel<Edition> editionListModel = new ListAdapterListModel<>();
    private final EditionTableModel editionTableModel = new EditionTableModel();
    //appel à la classe EditionTableModel. Chemin = librairie/ model/table/ EditionTableModel
    private final JTable editionTable = new JTable(editionTableModel);
    private final ListSelectionModel selectionModel = new DefaultListSelectionModel();
    private final JList<Edition> editionList = new JList<>(editionListModel);
    private final ListModelSelection<Edition> listModelSelection = new ListModelSelection<>();
    
    
    //contructeur 
    public EditionAdminPanel(EditionController controller) {
        this.controller = controller;
        init();
    }
    
    //methode init : pour etablir ce que comportera le EditionAdminPanel ? 
    private void init(){
        //design : consigne de mis en place pour le footer et le scroll pane.
        setLayout(new BorderLayout());
        
        editionTable.setSelectionModel(selectionModel);
        editionTable.setSelectionModel(editionList.getSelectionModel());
        
        JScrollPane scrollPane = new JScrollPane();

        scrollPane.setViewportView(editionTable);
        
        add(scrollPane, BorderLayout.CENTER);
        add(getFooter(), BorderLayout.SOUTH);
        add(getForm(), BorderLayout.NORTH);
        
        repaint();
        setVisible(true);
    }
    
    public void setEditionList(ListAdapterListModel<Edition> editionListModel) {
        editionList.setModel(editionListModel);
        editionTableModel.setListModel(editionListModel);
        listModelSelection.setListModels(editionListModel, selectionModel);
    }
    
    public Component getForm(){
        JPanel form = new JPanel();
        
        JLabel titre = new JLabel("EDITIONS");
        
        form.add(titre);
        
        return form;
    }
    
    //methode pour dire ce que va comporter le footer/ 
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
