package fr.afpa.librairie.data;

import fr.afpa.librairie.data.dao.AdresseDAO;
import fr.afpa.librairie.data.dao.AuteurDAO;
import fr.afpa.librairie.data.dao.EditeurDAO;
import fr.afpa.librairie.data.dao.EditionDAO;
import fr.afpa.librairie.data.dao.GenreDAO;
import fr.afpa.librairie.data.dao.LangueDAO;
import fr.afpa.librairie.data.dao.PromotionDAO;
import fr.afpa.librairie.data.dao.RoleDAO;
import fr.afpa.librairie.data.dao.RubriqueDAO;
import fr.afpa.librairie.data.dao.StatutCommandeDAO;
import fr.afpa.librairie.data.dao.StatutUtilisateurDAO;
import fr.afpa.librairie.data.dao.TagDAO;
import fr.afpa.librairie.data.dao.ThemeDAO;
import fr.afpa.librairie.data.dao.UtilisateurDAO;
import fr.afpa.librairie.data.dao.support.list.ListDAOFactory;
import fr.afpa.librairie.data.dao.support.sql.SqlDAOFactory;
import fr.afpa.librairie.data.dao.support.xml.XmlDAOFactory;
import java.util.Properties;

public abstract class AbstractDAOFactory implements DAOFactoryInterface {
    
    private static final String PROPERTIES_PATH = "fr/afpa/librairie/resources/dao.properties";
    
    private Properties properties;
    
    @Override
    public abstract UtilisateurDAO getUtilisateurDAO();
    
    @Override
    public abstract RoleDAO getRoleDAO();
    
    @Override
    public abstract StatutUtilisateurDAO getStatutUtilisateurDAO();
   
    @Override
    public abstract AuteurDAO getAuteurDAO();
    
    @Override
    public abstract ThemeDAO getThemeDAO();
    
    @Override
    public abstract RubriqueDAO getRubriqueDAO();
    
    @Override
    public abstract TagDAO getTagDAO();
    
    @Override
    public abstract GenreDAO getGenreDAO();
    
    @Override
    public abstract EditeurDAO getEditeurDAO();
    
    @Override
    public abstract PromotionDAO getPromotionDAO();
    
    @Override
    public abstract EditionDAO getEditionDAO();
    
    @Override
    public abstract AdresseDAO getAdresseDAO();
    
    
    @Override
    public abstract LangueDAO getLangueDAO();
    
    public abstract StatutCommandeDAO getStatutCommandeDAO();
    
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
