package fr.afpa.librairie.view.panel;

import fr.afpa.librairie.model.list.ListAdapterListModel;
import java.awt.BorderLayout;
import javax.swing.JList;
import javax.swing.JPanel;

public abstract class AdminPanel<T> extends JPanel {
    
    private final TitlePanel title;
    private final ListPanel<T> listPanel;
    private final FooterPanel footer;

    public AdminPanel(TitlePanel title, ListPanel<T> listPanel, FooterPanel footer) {
        super();
        this.title = title;
        this.listPanel = listPanel;
        this.footer = footer;
        
        initComponents();
    }
    
    private void initComponents(){
        setLayout(new BorderLayout());
        
        add(this.title, BorderLayout.NORTH);
        add(this.listPanel, BorderLayout.CENTER);
        add(this.footer, BorderLayout.SOUTH);
    }
    
    public JList<T> getList(){
        return this.listPanel.getList();
    }

    public void setList(ListAdapterListModel<T> listModel) {
        this.listPanel.setList(listModel);
    }
}
