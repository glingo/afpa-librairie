package fr.afpa.librairie.view;

import fr.afpa.librairie.controller.AuteurController;
import fr.afpa.librairie.controller.CommandeController;
import fr.afpa.librairie.controller.PromotionController;
import fr.afpa.librairie.controller.EditeurController;
import fr.afpa.librairie.controller.OuvrageController;
import fr.afpa.librairie.controller.RubriqueController;
import fr.afpa.librairie.controller.UtilisateurController;
import fr.afpa.librairie.view.admin.DashBoardPanel;
import java.awt.AlphaComposite;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.SplashScreen;
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
        
        initSplashScreen();
        
        Container contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout(1, 0));
        setContent(new DashBoardPanel());
        
        JMenuBar jMenuBar = new JMenuBar();
        setJMenuBar(jMenuBar);
        
        initMenu(jMenuBar);
        
        Dimension dimension = new Dimension(650, 450);
        setPreferredSize(dimension);
//        setResizable(false);
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Le hibou qui lit");
        setLocationRelativeTo(null);
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
        
        
        JMenuItem auteurAdmin = new JMenuItem("Auteurs");
        auteurAdmin.addActionListener(new AuteurController(this));
        adminMenu.add(auteurAdmin);
        
        JMenuItem ouvrageAdmin = new JMenuItem("Ouvrages");
        ouvrageAdmin.addActionListener(new OuvrageController(this));
        adminMenu.add(ouvrageAdmin);
        
        JMenuItem rubriqueAdmin = new JMenuItem("Rubriques");
        rubriqueAdmin.addActionListener(new RubriqueController(this));
        adminMenu.add(rubriqueAdmin);
        
        JMenuItem commandeAdmin = new JMenuItem("Commandes");
        commandeAdmin.addActionListener(new CommandeController(this));
        adminMenu.add(commandeAdmin);
        
        JMenuItem editeurAdmin = new JMenuItem("Editeurs");
        editeurAdmin.addActionListener(new EditeurController(this));
        adminMenu.add(editeurAdmin);
        
        JMenuItem promotionAdmin = new JMenuItem("Promotions");
        promotionAdmin.addActionListener(new PromotionController(this));
        adminMenu.add(promotionAdmin);
        
        jMenuBar.add(adminMenu);
    }
    
    private void initSplashScreen(){
        
        final SplashScreen splash = SplashScreen.getSplashScreen();
//        
        if (splash == null) {
            System.out.println("SplashScreen.getSplashScreen() returned null");
            return;
        }
//        
        Graphics2D g = splash.createGraphics();
        if (g == null) {
            System.out.println("g is null");
            return;
        }
//        
        for(int i=0; i<50; i++) {
            renderSplashFrame(g, i);
            splash.update();
            try {
                Thread.sleep(90);
            }
            catch(InterruptedException e) {
            }
        }
        splash.close();
        
    }
    
    void renderSplashFrame(Graphics2D g, int frame) {
        final String[] comps = {"foo", "bar", "baz"};
        g.setComposite(AlphaComposite.Clear);
        g.fillRect(120,140,200,40);
        g.setPaintMode();
        g.setColor(Color.BLACK);
        g.drawString("Loading "+comps[(frame/5)%3]+"...", 120, 150);
    }

}
