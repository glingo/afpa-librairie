package fr.afpa.librairie.view;

import fr.afpa.librairie.controller.UtilisateurController;
import fr.afpa.librairie.view.admin.DashBoardPanel;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public final class MainFrame extends JFrame {
    
    private Component currentContent;

    public MainFrame() {
        init();
    }
    
    private void init(){
        Container contentPane = getContentPane();
        
        contentPane.setLayout(new BorderLayout(1, 0));

        setContent(new DashBoardPanel());
        
        JMenuBar jMenuBar = new JMenuBar();
        setJMenuBar(jMenuBar);
        
        initMenu(jMenuBar);
        Dimension dimension = new Dimension(650, 450);
        setPreferredSize(dimension);
//        setResizable(false);
        
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        setLocation((dim.width - getWidth())/2, (dim.height - getHeight())/2);
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Le hibou qui lit");
//        setLocationRelativeTo(null);
        pack();
    }

    public void setContent(Component component) {
        Container contentPane = getContentPane();
        
        if (currentContent != null) {
            contentPane.remove(currentContent);
        }
        
        contentPane.add(component, BorderLayout.CENTER);
        currentContent = component;
        pack();
        repaint();
    }
    
    public Component getContent() {
        return this.currentContent;
    }

    private void initMenu(JMenuBar jMenuBar) {
        initFileMenu(jMenuBar);
        initAdministrationMenu(jMenuBar);
    }

    private void initFileMenu(JMenuBar jMenuBar) {
        JMenu fileMenu = new JMenu("Files");
        jMenuBar.add(fileMenu);
    }
    
    private void initAdministrationMenu(JMenuBar jMenuBar) {
        JMenu adminMenu = new JMenu("Administration");
        
        JMenuItem utilisateurAdmin = new JMenuItem("Utilisateurs");
        utilisateurAdmin.addActionListener(new UtilisateurController(this));
        adminMenu.add(utilisateurAdmin);
        
        // meme chose pour auteur etc ...
//        JMenuItem auteursAdmin = new JMenuItem("Auteurs");
//        auteursAdmin.addActionListener(new AuteurController(this));
//        adminMenu.add(auteursAdmin);
        
        jMenuBar.add(adminMenu);
    }

}
