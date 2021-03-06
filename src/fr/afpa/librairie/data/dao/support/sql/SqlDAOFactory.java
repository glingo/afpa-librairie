package fr.afpa.librairie.data.dao.support.sql;

import fr.afpa.librairie.data.AbstractDAOFactory;
import fr.afpa.librairie.data.DAOUtils;
import fr.afpa.librairie.data.dao.AdresseDAO;
import fr.afpa.librairie.data.dao.AuteurDAO;
import fr.afpa.librairie.data.dao.EditeurDAO;
import fr.afpa.librairie.data.dao.EditionDAO;
import fr.afpa.librairie.data.dao.GenreDAO;
import fr.afpa.librairie.data.dao.LangueDAO;
import fr.afpa.librairie.data.dao.OuvrageDAO;
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
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class SqlDAOFactory extends AbstractDAOFactory {
    
    private static final String PROPERTY_URL             = "url";
    private static final String PROPERTY_DRIVER          = "driver";
    private static final String PROPERTY_NOM_UTILISATEUR = "nomutilisateur";
    private static final String PROPERTY_MOT_DE_PASSE    = "motdepasse";
    
    public SqlDAOFactory() {
        super();
    }
    
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
    public StatutEntrepriseDAO getStatutEntrepriseDAO(){
        return new StatutEntrepriseSqlDAO(this);
    }
    
    @Override
    public StatutAdresseDAO getStatutAdresseDAO(){
        return new StatutAdresseSqlDAO(this);
    }

    @Override
    public StatutTransactionDAO getStatutTransactionDAO(){
        return new StatutTransactionSqlDAO(this);
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
    
    @Override
    public EditionDAO getEditionDAO(){
        return new EditionSqlDAO(this);
    }
    
    @Override
    public AdresseDAO getAdresseDAO(){
        return new AdresseSqlDAO(this);
    }
    
    @Override
    public LangueDAO getLangueDAO(){
        return new LangueSqlDAO(this);
    }

    @Override
    public StatutCommandeDAO getStatutCommandeDAO() {
        return new StatutCommandeSqlDAO(this);
    }
    
    @Override
    public StatutEditionDAO getStatutEditionDAO(){
        return new StatutEditionSqlDAO(this);
    }
    
    @Override
    public TaxeDAO getTaxeDao() {
        return new TaxeSqlDAO(this);
    }

    @Override
    public TaxeDAO getTaxeDAO() {
       return new TaxeSqlDAO(this);
    }

    @Override
    public PaysDAO getPaysDAO() {
        return new PaysSqlDAO(this);
    }

}
