package fr.afpa.librairie.data;

import fr.afpa.librairie.data.exception.DAOConfigurationException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class DAOUtils {
    
    private static final List<String> DRIVER_LOADED = new ArrayList<>();
    
    public static void loadDriver(String driver) {
        
        if(DAOUtils.DRIVER_LOADED.contains(driver)) {
            System.out.format("Tentative de chargement du driver %s, avortée.\n", driver);
            return;
        }
        
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            String msg = String.format("Le driver est %s introuvable dans le classpath.", driver);
            throw new DAOConfigurationException(msg, e);
        }
    }
    
    public static Properties loadProperties(Properties properties, String path){
//        Properties properties = new Properties();
        
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        InputStream fichierProperties = classLoader.getResourceAsStream(path);

        if (fichierProperties == null) {
            String msg = String.format("Le fichier properties %s est introuvable.", path);
            throw new DAOConfigurationException(msg);
        }

        try {
            properties.load(fichierProperties);
        } catch (IOException e) {
            String msg = String.format("Impossible de charger le fichier properties %s.", path);
            throw new DAOConfigurationException(msg, e);
        }
        
        return properties;
    }

}
