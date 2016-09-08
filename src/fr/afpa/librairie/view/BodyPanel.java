package fr.afpa.librairie.view;

import fr.afpa.librairie.view.accueil.AccueilPanel;
import java.awt.Component;
import java.awt.Container;
import javax.swing.GroupLayout;
import javax.swing.JPanel;
import javax.swing.LayoutStyle;

public class BodyPanel extends JPanel {
//    
//    private LeftMenuPanel leftMenu;
//    private Component currentContent;

    public BodyPanel() {
        init();
    }
    
    
    
    private void init(){
        
//        leftMenu = new LeftMenuPanel();
//        header = new HeaderPanel();
        
//        if(currentContent == null) {
//            currentContent = new AccueilPanel();
//        }
//        
//        GroupLayout layout = new GroupLayout(this);
//        setLayout(layout);
//        
//        layout.setHorizontalGroup(
//            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
//            .addGroup(layout.createSequentialGroup()
//                .addGap(4, 4, 4)
//                .addComponent(leftMenu, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
//                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
//                .addComponent(currentContent, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
//            .addComponent(header, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
//        );
//        
//        
//        layout.setVerticalGroup(
//            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
//            .addGroup(layout.createSequentialGroup()
//                .addComponent(header, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
//                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
//                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
//                    .addComponent(leftMenu, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
//                    .addGroup(layout.createSequentialGroup()
//                        .addComponent(currentContent, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
//                        .addGap(0, 0, Short.MAX_VALUE)))
//                .addContainerGap())
//        );
    }
    
//    public void setContent(Component component) {
//        getLayout().removeLayoutComponent(component);
//        currentContent = component;
//        repaint();
//    }
//    
//    
//    public Component getContent() {
//        return this.currentContent;
//    }
    
//    public HeaderPanel getHeader() {
//        return this.header;
//    }
    
//    public LeftMenuPanel getLeftMenu() {
//        return this.leftMenu;
//    }
}
