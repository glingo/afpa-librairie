package fr.afpa.librairie.view;

import fr.afpa.librairie.data.bean.Auteur;
import fr.afpa.librairie.data.bean.Rubrique;
import fr.afpa.librairie.model.list.ListAdapterListModel;
import fr.afpa.librairie.model.list.ListModelSelection;
import fr.afpa.librairie.model.list.renderer.RubriqueListCellRenderer;
import java.awt.Dimension;
import java.util.List;
import javax.swing.DefaultListSelectionModel;
import javax.swing.GroupLayout;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;

public class LeftMenuPanel extends JPanel {

    private final ListAdapterListModel<Rubrique> listModel = new ListAdapterListModel<>();
    private final ListSelectionModel selectionModel = new DefaultListSelectionModel();
    private final ListModelSelection<Rubrique> listModelSelection = new ListModelSelection<>();
//    private final ListCellRenderer cellRenderer = new RubriqueListCellRenderer();
    
    private JList rubriques;
    private JScrollPane scrollPane;   
    
    public LeftMenuPanel() {
        initComponents();
    }
    
    public void setRubriqueList(List<Rubrique> list) {
        listModel.setList(list);
        rubriques.setModel(listModel);
        listModelSelection.setListModels(listModel, selectionModel);
    }
                     
    private void initComponents() {

        scrollPane = new JScrollPane();
        rubriques = new JList();

        setMinimumSize(new Dimension(200, 380));
        setPreferredSize(new Dimension(200, 380));
//        rubriques.setCellRenderer(cellRenderer);

//        rubriques.setMaximumSize(null);
//        rubriques.setMinimumSize(new Dimension(100, 100));
//        rubriques.setPreferredSize(new Dimension(100, 100));
        scrollPane.setViewportView(rubriques);
        
        GroupLayout layout = new GroupLayout(this);
        this.setLayout(layout);
        
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(scrollPane, GroupLayout.Alignment.TRAILING)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(scrollPane, GroupLayout.Alignment.TRAILING)
        );
    }        

    public JList getRubriques() {
        return rubriques;
    }
    
}
