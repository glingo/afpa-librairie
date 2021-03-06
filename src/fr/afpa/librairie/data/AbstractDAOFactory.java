package fr.afpa.librairie.data;

import fr.afpa.librairie.data.dao.AdresseDAO;
import fr.afpa.librairie.data.dao.AuteurDAO;
import fr.afpa.librairie.data.dao.EditeurDAO;
import fr.afpa.librairie.data.dao.EditionDAO;
import fr.afpa.librairie.data.dao.GenreDAO;
import fr.afpa.librairie.data.dao.LangueDAO;
import fr.afpa.librairie.data.dao.PaysDAO;
import fr.afpa.librairie.data.dao.PromotionDAO;
import fr.afpa.librairie.data.dao.RoleDAO;
import fr.afpa.librairie.data.dao.RubriqueDAO;
import fr.afpa.librairie.data.dao.StatutAdresseDAO;
import fr.afpa.librairie.data.dao.StatutCommandeDAO;
import fr.afpa.librairie.data.dao.StatutEditionDAO;
import fr.afpa.librairie.data.dao.StatutEntrepriseDAO;
import fr.afpa.librairie.data.dao.StatutTransactionDAO;
import fr.afpa.librairie.data.dao.StatutUtilisateurDAO;
import fr.afpa.librairie.data.dao.TagDAO;
import fr.afpa.librairie.data.dao.TaxeDAO;
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
    public abstract PaysDAO getPaysDAO();

    @Override
    public abstract RoleDAO getRoleDAO();

    @Override
    public abstract StatutUtilisateurDAO getStatutUtilisateurDAO();

    @Override
    public abstract StatutEntrepriseDAO getStatutEntrepriseDAO();

    @Override
    public abstract StatutAdresseDAO getStatutAdresseDAO();

    @Override
    public abstract StatutTransactionDAO getStatutTransactionDAO();

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

    @Override
    public abstract StatutEditionDAO getStatutEditionDAO();

    @Override
    public abstract StatutCommandeDAO getStatutCommandeDAO();

    public abstract TaxeDAO getTaxeDAO();

    public static DAOFactoryInterface getFactory(FactoryType type) {

        if (type.equals(FactoryType.DAO_FACTORY)) {
            return new SqlDAOFactory();
        }

        if (type.equals(FactoryType.XML_DAO_FACTORY)) {
            return new XmlDAOFactory();
        }

        if (type.equals(FactoryType.LIST_DAO_FACTORY)) {
            return new ListDAOFactory();
        }

        return null;
    }

    protected Properties getProperties() {
        if (this.properties == null) {
            this.properties = DAOUtils.loadProperties(new Properties(), PROPERTIES_PATH);
        }

        return this.properties;
    }

}
