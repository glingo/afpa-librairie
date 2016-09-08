package fr.afpa.librairie.data.dao.support.sql;

import fr.afpa.librairie.data.AbstractDAOFactory;
import fr.afpa.librairie.data.DAOFactoryInterface;
import fr.afpa.librairie.data.bean.Auteur;
import fr.afpa.librairie.data.bean.Genre;
import fr.afpa.librairie.data.bean.Langue;
import fr.afpa.librairie.data.bean.Ouvrage;
import fr.afpa.librairie.data.bean.Rubrique;
import fr.afpa.librairie.data.bean.Tag;
import fr.afpa.librairie.data.bean.Theme;
import fr.afpa.librairie.data.dao.OuvrageDAO;
import fr.afpa.librairie.data.exception.DAOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OuvrageSqlDAO extends AbstractSqlDAO<Ouvrage> implements OuvrageDAO {
    
    private static final String SQL_INSERT = "INSERT INTO Ouvrage"
            + " (titre, sous_titre, resume, idAuteur)"
            + " VALUES (?, ?, ?, ?)";
    
    private static final String SQL_DELETE = "DELETE FROM Ouvrage WHERE idOuvrage = ?";
    
    private static final String SQL_FIND_ALL = "SELECT"
            + " idOuvrage, titre, sous_titre, resume, idAuteur"
            + " FROM Ouvrage ";
    
    private static final String SQL_FIND_BY_TITRE = "SELECT"
            + " idOuvrage, titre, sousTitre, resume, idAuteur"
            + " FROM Ouvrage"
            + " WHERE titre = ?";
    
    private static final String SQL_FIND_BY_SOUSTITRE = "SELECT"
            + " idOuvrage, titre, sousTitre, resume, idAuteur"
            + " FROM Ouvrage"
            + " WHERE sousTitre = ?";
    
    private static final String SQL_FIND_BY_IDAUTEUR = "SELECT"
            + " idOuvrage, titre, sousTitre, resume, idAuteur"
            + " FROM Ouvrage"
            + " WHERE idAuteur = ?";

    public OuvrageSqlDAO(AbstractDAOFactory factory) {
        super(factory);
    }

    @Override
    public void save(Ouvrage instance) throws DAOException {
        SqlDAOFactory factory = getFactory();
        Connection connexion = null;
        PreparedStatement preparedStatement = null;
        ResultSet valeursAutoGenerees = null;

        try {

            if (instance.getAuteur() == null) {
                Auteur auteur = getFactory().getAuteurDAO().findByName("OK");
                instance.setAuteur(auteur);
            }

            if (instance.getAuteur().getId() == null) {
                Auteur auteur = getFactory().getAuteurDAO().findByName(instance.getAuteur().getNom());
                instance.setAuteur(auteur);
            }
            // Je ne comprend pas d'ou vient d'erreur. 

            if (instance.getThemes() == null) {

                Theme theme = getFactory().getThemeDAO().findByLibelle("CLI");
                instance.addTheme(theme);
            }

            instance.getThemes().forEach((Theme theme) -> {
                if (theme != null && theme.getId() == null) {
                    theme = getFactory().getThemeDAO().findByLibelle(theme.getLibelle());
                }
            });

            if (instance.getGenres() == null) {

                Genre genre = getFactory().getGenreDAO().findByLibelle("CLI");
                instance.addGenre(genre);
            }

            instance.getGenres().forEach((Genre genre) -> {
                if (genre != null && genre.getId() == null) {
                    genre = getFactory().getGenreDAO().findByLibelle(genre.getLibelle());
                }
            });
            
            if (instance.getLangues() == null){
                Langue langue = getFactory().getLangueDAO().findByLibelle("CLI");
                instance.addLangue(langue);
            }
            
            instance.getLangues().forEach((Langue langue) -> {
                if(langue != null && langue.getId() == null){
                    langue = getFactory().getLangueDAO().findByLibelle(langue.getLibelle());
                }
            });
            if (instance.getRubriques() == null) {

                Rubrique rubrique = getFactory().getRubriqueDAO().findByLibelle("CLI");
                instance.addRubrique(rubrique);
            }

            instance.getRubriques().forEach((Rubrique rubrique) -> {
                if (rubrique != null && rubrique.getId() == null) {
                    rubrique = getFactory().getRubriqueDAO().findByLibelle(rubrique.getLibelle());
                }
            });

            if (instance.getTags() == null) {

                Tag tag = getFactory().getTagDAO().findByLibelle("CLI");
                instance.addTag(tag);
            }

            /*if(instance.getTags().getId() == null) {
             Tag tag = getFactory().getTagDAO().findByLibelle(instance.getTags().getId());
             instance.setTags((List<Tag>) tag);
             }*/
            instance.getTags().forEach((Tag tag) -> {
                if (tag != null && tag.getId() == null) {
                    tag = getFactory().getTagDAO().findByLibelle(tag.getLibelle());
                }
            });

        //***************************************REPRENDRE ICI****************************************

            /* Récupération d'une connexion depuis la Factory */
            connexion = factory.getConnection();

            preparedStatement = getPreparedStatement(connexion, SQL_INSERT, true,
                    instance.getTitre(), instance.getSousTitre(),
                    instance.getResume(),
                    instance.getAuteur() == null ? null : instance.getAuteur().getId());

            int statut = preparedStatement.executeUpdate();
            /* Analyse du statut retourné par la requête d'insertion */
            if (statut == 0) {
                throw new DAOException("Échec de la création de l'ouvrage, aucune ligne ajoutée dans la table.");
            }
            /* Récupération de l'id auto-généré par la requête d'insertion */
            valeursAutoGenerees = preparedStatement.getGeneratedKeys();
            if (valeursAutoGenerees.next()) {
                /* Puis initialisation de la propriété id du bean Utilisateur avec sa valeur */
                instance.setId(valeursAutoGenerees.getLong(1));
            } else {
                throw new DAOException("Échec de la création de l'ouvrage en base, aucun ID auto-généré retourné.");
            }
        } catch (SQLException e) {
            throw new DAOException(e);
        } finally {
            close(valeursAutoGenerees, preparedStatement, connexion);
        }
    }

    @Override
    public List<Ouvrage> findAll() throws DAOException {
        SqlDAOFactory factory = getFactory();
        Connection connexion = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<Ouvrage> ouvrages = new ArrayList<>();

        try {
            connexion = factory.getConnection();
            preparedStatement = getPreparedStatement(connexion, SQL_FIND_ALL, false);
            resultSet = preparedStatement.executeQuery();
            
//            resultSet.beforeFirst();
            
            while (resultSet.next()) {
                ouvrages.add(map(resultSet));
            }
        } catch (SQLException e) {
            throw new DAOException(e);
        } finally {
            close(resultSet, preparedStatement, connexion);
        }

        return ouvrages;

    }

    @Override

    public void delete(Ouvrage instance) throws DAOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Ouvrage findByExemple(Ouvrage instance) throws DAOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Ouvrage findById(Long id) throws DAOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Ouvrage findByTitre(String titre) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Ouvrage findBySousTitre(String sousTitre) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    protected Ouvrage map(ResultSet result) throws SQLException {
        DAOFactoryInterface factory = getFactory();
        
        Ouvrage ouvrage = new Ouvrage();
        
        Long idOuvrage = result.getLong("idOuvrage");
        
        ouvrage.setId(idOuvrage);
        ouvrage.setTitre(result.getString("titre"));
        ouvrage.setSousTitre(result.getString("sous_titre"));
        ouvrage.setResume(result.getString("resume"));
        
        // on recupere l'auteur depuis la base de données.
        Auteur auteur = factory.getAuteurDAO().findById(result.getLong("idAuteur"));
        // puis on l'assigne à l'ouvrage.
        ouvrage.setAuteur(auteur);
        
        // on recupère les genres attachés à l'ouvrage pour lui assigner
        List<Genre> genres = factory.getGenreDAO().findByOuvrage(idOuvrage);
        ouvrage.setGenres(genres);
        
        List<Rubrique> rubriques = factory.getRubriqueDAO().findByOuvrage(idOuvrage);
        ouvrage.setRubriques(rubriques);
        
        List<Tag> tags = factory.getTagDAO().findByOuvrage(idOuvrage);
        ouvrage.setTags(tags);
        
        List<Theme> themes = factory.getThemeDAO().findByOuvrage(idOuvrage);
        ouvrage.setThemes(themes);
        
        List<Auteur> coAuteurs = factory.getAuteurDAO().findCoAuteursByOuvrage(idOuvrage);
        ouvrage.setCoAuteurs(coAuteurs);
        
        // set la langue
        
        return ouvrage;
    }

}
