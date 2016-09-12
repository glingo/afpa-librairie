
package fr.afpa.librairie.view.admin;

import fr.afpa.librairie.controller.CommandeController;
import fr.afpa.librairie.data.bean.Commande;
import fr.afpa.librairie.model.list.ListAdapterListModel;
import fr.afpa.librairie.model.list.ListModelSelection;
import fr.afpa.librairie.model.table.CommandeTableModel;
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

public class CommandeAdminPanel extends JPanel {
    
     private CommandeController controller;
    
    private final ListAdapterListModel<Commande> commandeListModel = new ListAdapterListModel<>();
    private final CommandeTableModel commandeTableModel = new CommandeTableModel();
    private final JTable commandeTable = new JTable(commandeTableModel);
    private final ListSelectionModel selectionModel = new DefaultListSelectionModel();
    private final JList<Commande> commandeList = new JList<>(commandeListModel);
    private final ListModelSelection<Commande> listModelSelection = new ListModelSelection<>();

    public CommandeAdminPanel(CommandeController controller) {
        this.controller = controller;
        init();
    }
    
     private void init(){
        setLayout(new BorderLayout());
        
        commandeTable.setSelectionModel(selectionModel);
        commandeTable.setSelectionModel(commandeList.getSelectionModel());
        
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setViewportView(commandeTable);
        
        add(scrollPane, BorderLayout.CENTER);
        add(getFooter(), BorderLayout.SOUTH);
        add(getForm(), BorderLayout.NORTH);
        
        repaint();
        setVisible(true);
    }
     
    public void setCommandeList(ListAdapterListModel<Commande> commandeListModel) {
        commandeList.setModel(commandeListModel);
        commandeTableModel.setListModel(commandeListModel);
        listModelSelection.setListModels(commandeListModel, selectionModel);
    }
    
    private Component getForm(){
        
        JPanel form = new JPanel();
        
        JLabel titre = new JLabel("COMMANDES");
        
        form.add(titre);
        
        return form;
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
