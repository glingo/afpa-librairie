package fr.afpa.librairie.view;

import fr.afpa.librairie.data.bean.Utilisateur;
import fr.afpa.librairie.model.list.ListAdapterListModel;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;

public final class MainFrame extends JFrame {
    
    private Component currentContent;
    private final OverviewPanel overviewPanel = new OverviewPanel();
    private final ListAdapterListModel<Utilisateur> personListModel = new ListAdapterListModel<>();

    public MainFrame() {
        Container contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout());

        overviewPanel.setUtilisateurList(personListModel);
        setContent(overviewPanel);
        
        JMenuBar jMenuBar = new JMenuBar();
        setJMenuBar(jMenuBar);
        
        initMenu(jMenuBar);

        setSize(605, 660);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Le hibou qui lit");
        setLocationRelativeTo(null);
    }

    public void setContent(Component component) {
        Container contentPane = getContentPane();
        if (currentContent != null) {
            contentPane.remove(currentContent);
        }
        contentPane.add(component, BorderLayout.CENTER);
        currentContent = component;
        contentPane.doLayout();
        repaint();
    }

    private void initMenu(JMenuBar jMenuBar) {
        initFileMenu(jMenuBar);
    }

    private void initFileMenu(JMenuBar jMenuBar) {
        JMenu fileMenu = new JMenu("Files");
        jMenuBar.add(fileMenu);
    }

}
