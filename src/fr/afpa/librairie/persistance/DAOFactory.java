package fr.afpa.librairie.persistance;

import fr.afpa.librairie.persistance.dao.UtilisateurDAO;
import fr.afpa.librairie.persistance.exception.DAOConfigurationException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DAOFactory {
    
    private static final String FICHIER_PROPERTIES       = "/fr/afpa/librairie/resources/dao.properties";
    private static final String PROPERTY_URL             = "url";
    private static final String PROPERTY_DRIVER          = "driver";
    private static final String PROPERTY_NOM_UTILISATEUR = "nomutilisateur";
    private static final String PROPERTY_MOT_DE_PASSE    = "motdepasse";

    private final String        url;
    private final String        username;
    private final String        password;
    
    private DAOFactory( String url, String username, String password ) {
        this.url = url;
        this.username = username;
        this.password = password;
    }
    
    /*
     * Méthode chargée de récupérer les informations de connexion à la base de
     * données, charger le driver JDBC et retourner une instance de la Factory
     */
    public static DAOFactory getInstance() throws DAOConfigurationException {
        Properties properties = new Properties();
        String url;
        String driver;
        String nomUtilisateur;
        String motDePasse;

        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        InputStream fichierProperties = classLoader.getResourceAsStream(FICHIER_PROPERTIES);

        if (fichierProperties == null) {
            String msg = String.format("Le fichier properties %s est introuvable.", FICHIER_PROPERTIES);
            throw new DAOConfigurationException(msg);
        }

        try {
            properties.load(fichierProperties);
            url = properties.getProperty(PROPERTY_URL);
            driver = properties.getProperty(PROPERTY_DRIVER);
            nomUtilisateur = properties.getProperty(PROPERTY_NOM_UTILISATEUR);
            motDePasse = properties.getProperty(PROPERTY_MOT_DE_PASSE);
        } catch (IOException e) {
            String msg = String.format("Impossible de charger le fichier properties %s.", FICHIER_PROPERTIES);
            throw new DAOConfigurationException(msg, e);
        }

        try {
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            String msg = "Le driver est introuvable dans le classpath.";
            throw new DAOConfigurationException(msg, e );
        }

        DAOFactory instance = new DAOFactory(url, nomUtilisateur, motDePasse);
        
        return instance;
    }

    /* Méthode chargée de fournir une connexion à la base de données */
    protected Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, username, password);
    }
    
    public UtilisateurDAO getUtilisateurDAO(){
        return new UtilisateurDAO(this);
    }
}
