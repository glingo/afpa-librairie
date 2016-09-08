package fr.afpa.librairie.data.dao.support.sql;

import fr.afpa.librairie.data.AbstractDAOFactory;
import fr.afpa.librairie.data.DAOUtils;
import fr.afpa.librairie.data.dao.AuteurDAO;
import fr.afpa.librairie.data.dao.EditeurDAO;
import fr.afpa.librairie.data.dao.GenreDAO;
import fr.afpa.librairie.data.dao.OuvrageDAO;
import fr.afpa.librairie.data.dao.PromotionDAO;
import fr.afpa.librairie.data.dao.RoleDAO;
import fr.afpa.librairie.data.dao.RubriqueDAO;
import fr.afpa.librairie.data.dao.StatutUtilisateurDAO;
import fr.afpa.librairie.data.dao.TagDAO;
import fr.afpa.librairie.data.dao.ThemeDAO;
import fr.afpa.librairie.data.dao.UtilisateurDAO;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class SqlDAOFactory extends AbstractDAOFactory {
    
//    private static final String FICHIER_PROPERTIES       = "fr/afpa/librairie/resources/dao.properties";
    private static final String PROPERTY_URL             = "url";
    private static final String PROPERTY_DRIVER          = "driver";
    private static final String PROPERTY_NOM_UTILISATEUR = "nomutilisateur";
    private static final String PROPERTY_MOT_DE_PASSE    = "motdepasse";
    
//    private final String        url;
//    private final String        username;
//    private final String        password;
    
    public SqlDAOFactory() {
        super();
        
//        this.url = properties.getProperty(PROPERTY_URL);
//        this.username = properties.getProperty(PROPERTY_NOM_UTILISATEUR);
//        this.password = properties.getProperty(PROPERTY_MOT_DE_PASSE);
        
    }
    
    /*
     * Methode chargee de recuperer les informations de connexion a la base de
     * donnees, charger le driver JDBC et retourner une instance de la Factory
     */
//    public static DAOFactory getInstance() throws DAOConfigurationException {
//       
//        DAOFactory instance = new DAOFactory(url, nomUtilisateur, motDePasse);
//        
//        return instance;
//    }
    
//    public void loadDriver(String driver){
//         try {
//            Class.forName(driver);
//        } catch (ClassNotFoundException e) {
//            String msg = "Le driver est introuvable dans le classpath.";
//            throw new DAOConfigurationException(msg, e);
//        }
//    }
//    
//    public void loadProperties(){
//        Properties properties = new Properties();
//        String driver;
//        
//        String url;
//        String nomUtilisateur;
//        String motDePasse;
//
//        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
//        InputStream fichierProperties = classLoader.getResourceAsStream(FICHIER_PROPERTIES);
//
//        if (fichierProperties == null) {
//            String msg = String.format("Le fichier properties %s est introuvable.", FICHIER_PROPERTIES);
//            throw new DAOConfigurationException(msg);
//        }
//
//        try {
//            properties.load(fichierProperties);
//            url = properties.getProperty(PROPERTY_URL);
//            driver = properties.getProperty(PROPERTY_DRIVER);
//            nomUtilisateur = properties.getProperty(PROPERTY_NOM_UTILISATEUR);
//            motDePasse = properties.getProperty(PROPERTY_MOT_DE_PASSE);
//        } catch (IOException e) {
//            String msg = String.format("Impossible de charger le fichier properties %s.", FICHIER_PROPERTIES);
//            throw new DAOConfigurationException(msg, e);
//        }
//        
//        loadDriver(driver);
//        
//    }

    /* Methode chargee de fournir une connexion a la base de donnees */
    public Connection getConnection() throws SQLException {
        
        Properties properties = getProperties();
        String url = properties.getProperty(PROPERTY_URL);
        String username = properties.getProperty(PROPERTY_NOM_UTILISATEUR);
        String password = properties.getProperty(PROPERTY_MOT_DE_PASSE);
        
        DAOUtils.loadDriver(getProperties().getProperty(PROPERTY_DRIVER));
        
        return DriverManager.getConnection(url, username, password);
    }
    
    @Override
    public UtilisateurDAO getUtilisateurDAO(){
        return new UtilisateurSqlDAO(this);
    }
    
    @Override
    public StatutUtilisateurDAO getStatutUtilisateurDAO(){
        return new StatutUtilisateurSqlDAO(this);
    }
    
    @Override
    public RoleDAO getRoleDAO(){
        return new RoleSqlDAO(this);
    }
    
    @Override
    public AuteurDAO getAuteurDAO(){
        return new AuteurSqlDAO(this);
    }
    
    @Override
    public ThemeDAO getThemeDAO(){
        return new ThemeSqlDAO(this);
    }
    
    @Override
    public RubriqueDAO getRubriqueDAO(){
        return new RubriqueSqlDAO(this);
    }
    
    @Override
    public GenreDAO getGenreDAO(){
        return new GenreSqlDAO(this);
    }
    
    @Override
    public TagDAO getTagDAO(){
        return new TagSqlDAO(this);
    }
    
    @Override
    public CommandeSqlDAO getCommandeDAO(){
        return new CommandeSqlDAO(this);
    }

    @Override
    public OuvrageDAO getOuvrageDAO() {
        return new OuvrageSqlDAO(this);
    }
    
    @Override
    public EditeurDAO getEditeurDAO(){
        return new EditeurSqlDAO(this);
    }

    @Override
    public PromotionDAO getPromotionDAO() {
        return new PromotionSqlDAO(this);
    }
}
