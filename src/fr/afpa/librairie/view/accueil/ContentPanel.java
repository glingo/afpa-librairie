package fr.afpa.librairie.view.accueil;

import fr.afpa.librairie.data.bean.Edition;
import fr.afpa.librairie.model.list.ListAdapterListModel;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;

public class ContentPanel extends JPanel {
    
    private JList results;
    private JButton rechercheButton;
    private JScrollPane scrollPane;
    private JTextField rechercheField;
    
    
    public ContentPanel() {
        init();
    }
    
    private void init(){
        
        //init rechercheField
        this.rechercheField = new JTextField();
        this.rechercheField.setText("Votre recherche");
        // add a controller to hold action ( maybe auto completion )!
        
        // init rechercheButton
        this.rechercheButton = new JButton();
        this.rechercheButton.setText("Rechercher");
        // add controller !
        
        
        //init scrollPane
        this.scrollPane = new JScrollPane();
        scrollPane.setViewportView(this.results);
        
        // init layout (need scrollPane)
        GroupLayout contentPanelLayout = new GroupLayout(this);
        setLayout(contentPanelLayout);
        
        contentPanelLayout.setHorizontalGroup(
            contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(contentPanelLayout.createSequentialGroup()
                .addGap(76, 76, 76)
                .addComponent(rechercheField, GroupLayout.PREFERRED_SIZE, 136, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(rechercheButton)
                .addContainerGap(34, Short.MAX_VALUE))
            .addGroup(GroupLayout.Alignment.TRAILING, contentPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(scrollPane)
                .addContainerGap())
        );
        
        contentPanelLayout.setVerticalGroup(
            contentPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(contentPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(contentPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(rechercheField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(rechercheButton))
                .addGap(18, 18, 18)
                .addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 237, Short.MAX_VALUE)
                .addContainerGap())
        );
        
    }
    
    public void setResultList(ListAdapterListModel<Edition> listModel) {
        this.results.setModel(listModel);
    }
}
