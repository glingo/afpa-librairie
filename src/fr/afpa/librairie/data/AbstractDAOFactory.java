package fr.afpa.librairie.data;

import fr.afpa.librairie.data.dao.DAOInterface;
import fr.afpa.librairie.data.dao.support.list.ListDAOFactory;
import fr.afpa.librairie.data.dao.support.sql.SqlDAOFactory;
import fr.afpa.librairie.data.dao.support.xml.XmlDAOFactory;
import java.util.Properties;

public abstract class AbstractDAOFactory implements DAOFactoryInterface {
    
    private static final String PROPERTIES_PATH = "fr/afpa/librairie/resources/dao.properties";
    
    private Properties properties;
    
    @Override
    public abstract <T extends DAOInterface> T getUtilisateurDAO();
    @Override
    public abstract <T extends DAOInterface> T getRoleDAO();
    @Override
    public abstract <T extends DAOInterface> T getStatutUtilisateurDAO();

    public static DAOFactoryInterface getFactory(FactoryType type){
        
        if(type.equals(FactoryType.DAO_FACTORY)){
            return new SqlDAOFactory();
        }

        if(type.equals(FactoryType.XML_DAO_FACTORY)) {
            return new XmlDAOFactory();
        }
        
        if(type.equals(FactoryType.LIST_DAO_FACTORY)) {
            return new ListDAOFactory();
        }

        return null;
    }
    
    protected Properties getProperties(){
        if(this.properties == null) {
            this.properties = DAOUtils.loadProperties(new Properties(), PROPERTIES_PATH);
        }
        
        return this.properties;
    }
    
//    private void loadProperties(){
//        this.properties = new Properties();
//        
//        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
//        InputStream is = classLoader.getResourceAsStream(PROPERTIES_PATH);
//
//        if (is == null) {
//            String msg = String.format("Le fichier properties %s est introuvable.", PROPERTIES_PATH);
//            throw new DAOConfigurationException(msg);
//        }
//        
//        try {
//            this.properties.load(is);
//        } catch (IOException e) {
//            String msg = String.format("Impossible de charger le fichier properties %s.", PROPERTIES_PATH);
//            throw new DAOConfigurationException(msg, e);
//        } finally {
//            try {
//                is.close();
//            } catch (IOException ex) {
//                String msg = String.format("Impossible de clore le stream sur %s.", PROPERTIES_PATH);
//                throw new DAOConfigurationException(msg, ex);
//            }
//        }
//    }
    
}
