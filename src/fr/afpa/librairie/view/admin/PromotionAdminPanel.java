
package fr.afpa.librairie.view.admin;

import fr.afpa.librairie.controller.CommandeController;
import fr.afpa.librairie.controller.PromotionController;
import fr.afpa.librairie.data.bean.Commande;
import fr.afpa.librairie.data.bean.Promotion;
import fr.afpa.librairie.model.list.ListAdapterListModel;
import fr.afpa.librairie.model.list.ListModelSelection;
import fr.afpa.librairie.model.table.CommandeTableModel;
import fr.afpa.librairie.model.table.PromotionTableModel;
import java.awt.BorderLayout;
import java.awt.Component;
import javax.swing.DefaultListSelectionModel;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;

public class PromotionAdminPanel extends JPanel {
    
    private PromotionController controller;
    
    private final ListAdapterListModel<Promotion> promoListModel = new ListAdapterListModel<>();
    private final PromotionTableModel promoTableModel = new PromotionTableModel();
    private final JTable commandeTable = new JTable(promoTableModel);
    private final ListSelectionModel selectionModel = new DefaultListSelectionModel();
    private final JList<Promotion> promoList = new JList<>(promoListModel);
    private final ListModelSelection<Promotion> listModelSelection = new ListModelSelection<>();

    public PromotionAdminPanel(PromotionController controller) {
        this.controller = controller;
        init();
    }
    
     private void init(){
        setLayout(new BorderLayout());
        
        commandeTable.setSelectionModel(selectionModel);
        commandeTable.setSelectionModel(promoList.getSelectionModel());
        
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setViewportView(commandeTable);
        
        add(scrollPane, BorderLayout.CENTER);
        add(getFooter(), BorderLayout.SOUTH);
        
        repaint();
        setVisible(true);
    }
     
    public void setCommandeList(ListAdapterListModel<Promotion> promoListModel) {
        promoList.setModel(promoListModel);
        promoTableModel.setListModel(promoListModel);
        listModelSelection.setListModels(promoListModel, selectionModel);
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
