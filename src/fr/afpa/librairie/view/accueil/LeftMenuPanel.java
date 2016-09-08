/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.afpa.librairie.view.accueil;

import fr.afpa.librairie.data.bean.Rubrique;
import fr.afpa.librairie.model.list.ListAdapterListModel;
import javax.swing.GroupLayout;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

/**
 *
 * @author cdi305
 */
public class LeftMenuPanel extends JPanel {
    
    private JList rubriques;

    public LeftMenuPanel() {
        this.rubriques = new JList();
        init();
    }
    
    private void init(){
        //init scrollPane
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setViewportView(this.rubriques);
        
        // init layout (need scrollPane)
        GroupLayout leftMenuPanelLayout = new GroupLayout(this);
        setLayout(leftMenuPanelLayout);
        
        GroupLayout.ParallelGroup group = leftMenuPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING);
        group.addComponent(scrollPane, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE);
        leftMenuPanelLayout.setVerticalGroup(group);
        
        leftMenuPanelLayout.setHorizontalGroup(
            leftMenuPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 74, Short.MAX_VALUE)
        );
    }
    
    public void setRubriqueList(ListAdapterListModel<Rubrique> listModel) {
        this.rubriques.setModel(listModel);
    }
    
}
