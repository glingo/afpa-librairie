package fr.afpa.librairie.view;

import fr.afpa.librairie.controller.AdresseController;
import fr.afpa.librairie.controller.AuteurController;
import fr.afpa.librairie.controller.CRUDController;
import fr.afpa.librairie.controller.CommandeController;
import fr.afpa.librairie.controller.EditeurController;
import fr.afpa.librairie.controller.EditionController;
import fr.afpa.librairie.controller.OuvrageController;
import fr.afpa.librairie.controller.PaysController;
import fr.afpa.librairie.controller.PromotionController;
import fr.afpa.librairie.controller.RubriqueController;
import fr.afpa.librairie.controller.UtilisateurController;
import fr.afpa.librairie.view.accueil.AccueilPanel;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.SplashScreen;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.GroupLayout;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.LayoutStyle;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.WindowConstants;

/**
 *
 * @author cdi305
 */
public class MainFrame extends javax.swing.JFrame {

    private static final Logger LOG = Logger.getLogger(MainFrame.class.getName());
    private static final String NAME = "main";
    private static final String TITLE = "Le hibou qui lit";
    private final String[] LOADING_MSG = {"Remplissage des océans", "bar", "baz"};

    /* Set the Nimbus look and feel */
    static {
        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
            // just log it and stay in default lookandfeel.
            LOG.log(Level.SEVERE, null, ex);
        }
    }
    
    private final UtilisateurController utilisateurController = new UtilisateurController(this);
    private final RubriqueController rubriqueController = new RubriqueController(this);
    private final AuteurController auteurController = new AuteurController(this);
    private final OuvrageController ouvrageController = new OuvrageController(this);
    private final CommandeController commandeController = new CommandeController(this);
    private final EditeurController editeurController = new EditeurController(this);
    private final PromotionController promotionController = new PromotionController(this);
    private final EditionController editionController = new EditionController(this);
    private final AdresseController adresseController = new AdresseController(this);
    private final PaysController paysController = new PaysController(this);

    private HeaderPanel headerPanel;
//    private LeftMenuPanel leftMenuPanel;
    private Component currentContent;

    private GroupLayout layout;

    public MainFrame() {
        initComponents();

        Dimension size = new Dimension(800, 650);

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle(TITLE);
        setName(NAME);
        setMinimumSize(size);
        setSize(size);
        setLocationRelativeTo(null);
        
        // noob test don't mind
        // System.out.println(System.getProperty("user.dir"));
        
        try{ 
            setIconImage(ImageIO.read(new File("./src/fr/afpa/librairie/resources/images/hiboukilicon.trans.png")));
        } catch (IOException e){
            // on evite le printStackTrace ...
            // e.printStackTrace();
            LOG.log(Level.WARNING, null, e);
        }
    }

    private void initComponents() {
        initSplashScreen();

        JMenuBar jMenuBar = new JMenuBar();
        setJMenuBar(jMenuBar);

        initMenu(jMenuBar);

        headerPanel = new HeaderPanel();
//        leftMenuPanel = new LeftMenuPanel();
        currentContent = new AccueilPanel();

        initLayout();
        
//        leftMenuPanel.getRubriques().addListSelectionListener(rubriqueController);

        pack();
    }

    public void setContent(Component component) {
        if (currentContent != null) {
            layout.replace(currentContent, component);
        }
        currentContent = component;
        repaint();
    }

    public Component getContent() {
        return this.currentContent;
    }

    private void initLayout() {

        layout = new GroupLayout(getContentPane());

        getContentPane().setLayout(layout);

        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addContainerGap()
//                        .addComponent(leftMenuPanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
//                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(currentContent, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addComponent(headerPanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                        .addComponent(headerPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addComponent(currentContent, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
//                                .addComponent(leftMenuPanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        )
                        .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
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
        utilisateurAdmin.addActionListener(utilisateurController);
        utilisateurAdmin.setActionCommand(CRUDController.ADMIN_ACTION);
        adminMenu.add(utilisateurAdmin);

        JMenuItem auteurAdmin = new JMenuItem("Auteurs");
        auteurAdmin.addActionListener(auteurController);
        auteurAdmin.setActionCommand(CRUDController.ADMIN_ACTION);
        adminMenu.add(auteurAdmin);

        JMenuItem ouvrageAdmin = new JMenuItem("Ouvrages");
        ouvrageAdmin.addActionListener(ouvrageController);
        ouvrageAdmin.setActionCommand(CRUDController.ADMIN_ACTION);
        adminMenu.add(ouvrageAdmin);

        JMenuItem rubriqueAdmin = new JMenuItem("Rubriques");
        rubriqueAdmin.addActionListener(rubriqueController);
        rubriqueAdmin.setActionCommand(CRUDController.ADMIN_ACTION);
        adminMenu.add(rubriqueAdmin);

        JMenuItem commandeAdmin = new JMenuItem("Commandes");
        commandeAdmin.addActionListener(commandeController);
        commandeAdmin.setActionCommand(CRUDController.ADMIN_ACTION);
        adminMenu.add(commandeAdmin);

        JMenuItem editeurAdmin = new JMenuItem("Editeurs");
        editeurAdmin.addActionListener(editeurController);
        editeurAdmin.setActionCommand(CRUDController.ADMIN_ACTION);
        adminMenu.add(editeurAdmin);

        JMenuItem promotionAdmin = new JMenuItem("Promotions");
        promotionAdmin.addActionListener(promotionController);
        promotionAdmin.setActionCommand(CRUDController.ADMIN_ACTION);
        adminMenu.add(promotionAdmin);

        JMenuItem editionAdmin = new JMenuItem("Editions");
        editionAdmin.addActionListener(editionController);
        editionAdmin.setActionCommand(CRUDController.ADMIN_ACTION);
        adminMenu.add(editionAdmin);
        
        JMenuItem adresseAdmin = new JMenuItem("Adresses");
        adresseAdmin.addActionListener(adresseController);
        adresseAdmin.setActionCommand(CRUDController.ADMIN_ACTION);
        adminMenu.add(adresseAdmin);
        
        JMenuItem paysAdmin = new JMenuItem("Pays");
        paysAdmin.addActionListener(paysController);
        paysAdmin.setActionCommand(CRUDController.ADMIN_ACTION);
        adminMenu.add(paysAdmin);
        
        jMenuBar.add(adminMenu);
    }

    private void initSplashScreen() {

        final SplashScreen splash = SplashScreen.getSplashScreen();

        if (splash == null) {
            LOG.log(Level.INFO, "SplashScreen.getSplashScreen() returned null");
            return;
        }

        Graphics2D g = splash.createGraphics();

        if (g == null) {
            LOG.log(Level.INFO, "Graphics2D is null");
            return;
        }

        for (int i = 0; i < 50; i++) {
            renderSplashFrame(g, i);
            splash.update();
        }

        splash.close();
    }

    void renderSplashFrame(Graphics2D g, int frame) {
//        g.setPaintMode();
//        g.setColor(Color.BLACK);
        g.drawString(LOADING_MSG[(frame / 5) % 3] + " ...", 500, 400);
    }

//    public LeftMenuPanel getLeftMenuPanel() {
//        return leftMenuPanel;
//    }

    public HeaderPanel getHeaderPanel() {
        return headerPanel;
    }

    public UtilisateurController getUtilisateurController() {
        return utilisateurController;
    }

    public AdresseController getAdresseController() {
        return adresseController;
    }

    public PaysController getPaysController() {
        return paysController;
    }
    
    public OuvrageController getOuvrageController(){
        return ouvrageController;
    }
    
    
}
