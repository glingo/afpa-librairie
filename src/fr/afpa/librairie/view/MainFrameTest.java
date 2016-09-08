package fr.afpa.librairie.view;

import fr.afpa.librairie.controller.AuteurController;
import fr.afpa.librairie.controller.CommandeController;
import fr.afpa.librairie.controller.EditeurController;
import fr.afpa.librairie.controller.EditionController;
import fr.afpa.librairie.controller.OuvrageController;
import fr.afpa.librairie.controller.PromotionController;
import fr.afpa.librairie.controller.RubriqueController;
import fr.afpa.librairie.controller.UtilisateurController;
import fr.afpa.librairie.view.accueil.AccueilPanel;
import fr.afpa.librairie.view.admin.DashBoardPanel;
import java.awt.AlphaComposite;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.SplashScreen;
import javax.swing.BoxLayout;
import javax.swing.GroupLayout;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.LayoutStyle;
import javax.swing.WindowConstants;

public class MainFrameTest extends JFrame {

    static {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MaquetteMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MaquetteMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MaquetteMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MaquetteMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
    }
                     
//    private LeftMenuPanel leftMenuSwingForm1;
//    private AccueilPanel accueilSwingForm2;
    private LeftMenuPanel leftMenu;
    private HeaderPanel header;
    private JPanel jPanel1;
    private BodyPanel body;
    
    private Component currentContent;
    
    private final Dimension dim = new Dimension(650, 450);
        
    /**
     * Creates new form MainFrame
     */
    public MainFrameTest() {
        
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("le hibou qui lit");
        setName("accueilFrame"); // NOI18N
        setMinimumSize(dim);
        setPreferredSize(dim);
        setSize(dim);
        
        initComponents();
    }
                    
    private void initComponents() {
        
        JMenuBar jMenuBar = new JMenuBar();
        setJMenuBar(jMenuBar);
        
        initMenu(jMenuBar);
        
        pack();
    }// </editor-fold>    
    
    
    public void setContent(Component component) {
//        this.body.setContent(component);
//        repaint();
        Container contentPane = getContentPane();
        
        if (currentContent != null) {
            contentPane.remove(currentContent);
        }
        
        contentPane.add(component);
        currentContent = component;
//        pack();
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
        
//        JMenuItem utilisateurAdmin = new JMenuItem("Utilisateurs");
//        utilisateurAdmin.addActionListener(new UtilisateurController(this));
//        adminMenu.add(utilisateurAdmin);
//        
//        
//        JMenuItem auteurAdmin = new JMenuItem("Auteurs");
//        auteurAdmin.addActionListener(new AuteurController(this));
//        adminMenu.add(auteurAdmin);
//        
//        JMenuItem ouvrageAdmin = new JMenuItem("Ouvrages");
//        ouvrageAdmin.addActionListener(new OuvrageController(this));
//        adminMenu.add(ouvrageAdmin);
//        
//        JMenuItem rubriqueAdmin = new JMenuItem("Rubriques");
//        rubriqueAdmin.addActionListener(new RubriqueController(this));
//        adminMenu.add(rubriqueAdmin);
//        
//        JMenuItem commandeAdmin = new JMenuItem("Commandes");
//        commandeAdmin.addActionListener(new CommandeController(this));
//        adminMenu.add(commandeAdmin);
//        
//        JMenuItem editeurAdmin = new JMenuItem("Editeurs");
//        editeurAdmin.addActionListener(new EditeurController(this));
//        adminMenu.add(editeurAdmin);
//        
//        JMenuItem promotionAdmin = new JMenuItem("Promotions");
//        promotionAdmin.addActionListener(new PromotionController(this));
//        adminMenu.add(promotionAdmin);
//        
//        JMenuItem editionAdmin = new JMenuItem("Editions");
//        editionAdmin.addActionListener(new EditionController(this));
//        adminMenu.add(editionAdmin);
        
        jMenuBar.add(adminMenu);
    }
    
    private void initSplashScreen(){
        
        final SplashScreen splash = SplashScreen.getSplashScreen();

        if (splash == null) {
            System.out.println("SplashScreen.getSplashScreen() returned null");
            return;
        }

        Graphics2D g = splash.createGraphics();
        if (g == null) {
            System.out.println("g is null");
            return;
        }

        for(int i=0; i<50; i++) {
            renderSplashFrame(g, i);
            splash.update();
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
