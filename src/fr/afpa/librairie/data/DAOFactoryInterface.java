package fr.afpa.librairie.data;

import fr.afpa.librairie.data.dao.AdresseDAO;
import fr.afpa.librairie.data.dao.AuteurDAO;
import fr.afpa.librairie.data.dao.CommandeDAO;
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

public interface DAOFactoryInterface {

    public UtilisateurDAO getUtilisateurDAO();
    
    public abstract PaysDAO getPaysDAO();

    public RoleDAO getRoleDAO();

    public StatutUtilisateurDAO getStatutUtilisateurDAO();

    public StatutEntrepriseDAO getStatutEntrepriseDAO();

    public StatutAdresseDAO getStatutAdresseDAO();

    public StatutTransactionDAO getStatutTransactionDAO();

    public AuteurDAO getAuteurDAO();

    public GenreDAO getGenreDAO();

    public ThemeDAO getThemeDAO();

    public RubriqueDAO getRubriqueDAO();

    public TagDAO getTagDAO();

    public OuvrageDAO getOuvrageDAO();

    public CommandeDAO getCommandeDAO();

    public EditeurDAO getEditeurDAO();

    public PromotionDAO getPromotionDAO();

    public EditionDAO getEditionDAO();

    public AdresseDAO getAdresseDAO();

    public LangueDAO getLangueDAO();

    public StatutCommandeDAO getStatutCommandeDAO();

    public StatutEditionDAO getStatutEditionDAO();

    public TaxeDAO getTaxeDao();
}
