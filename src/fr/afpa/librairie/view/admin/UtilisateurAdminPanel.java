/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.afpa.librairie.view.admin;

import fr.afpa.librairie.controller.UtilisateurController;
import fr.afpa.librairie.data.bean.Utilisateur;
import fr.afpa.librairie.model.list.ListAdapterListModel;
import fr.afpa.librairie.model.list.ListModelSelection;
import fr.afpa.librairie.model.table.UtilisateurTableModel;
import java.awt.BorderLayout;
import java.awt.Component;
import javax.swing.DefaultListSelectionModel;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;

/**
 *
 * @author caill
 */
public class UtilisateurAdminPanel extends JPanel {
    
    private UtilisateurController controller;
    
    private final ListAdapterListModel<Utilisateur> utilisateurListModel = new ListAdapterListModel<>();
    private final UtilisateurTableModel utilisateurTableModel = new UtilisateurTableModel();
    private final JTable utilisateurTable = new JTable(utilisateurTableModel);
    private final ListSelectionModel selectionModel = new DefaultListSelectionModel();
    private final JList<Utilisateur> utilisateurList = new JList<>(utilisateurListModel);
    private final ListModelSelection<Utilisateur> listModelSelection = new ListModelSelection<>();
    
    public UtilisateurAdminPanel(UtilisateurController controller) {
        this.controller = controller;
        init();
    }
    
    private void init(){
        setLayout(new BorderLayout());
        
        utilisateurTable.setSelectionModel(selectionModel);
        utilisateurTable.setSelectionModel(utilisateurList.getSelectionModel());
        
        JScrollPane scrollPane = new JScrollPane();
//        scrollPane.setBounds(10, 11, this.frame, 130);
        scrollPane.setViewportView(utilisateurTable);
        
        add(scrollPane, BorderLayout.CENTER);
        add(getFooter(), BorderLayout.SOUTH);
        
        repaint();
        setVisible(true); // Move it to here
    }
    
    
    public void setUtilisateurList(ListAdapterListModel<Utilisateur> utilisateurListModel) {
        utilisateurList.setModel(utilisateurListModel);
        utilisateurTableModel.setListModel(utilisateurListModel);
        listModelSelection.setListModels(utilisateurListModel, selectionModel);
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
