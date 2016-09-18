package fr.afpa.librairie.data.dao.support.sql;

import fr.afpa.librairie.data.AbstractDAOFactory;
import fr.afpa.librairie.data.DAOFactoryInterface;
import fr.afpa.librairie.data.bean.Auteur;
import fr.afpa.librairie.data.bean.Genre;
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
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class OuvrageSqlDAO extends AbstractSqlDAO<Ouvrage> implements OuvrageDAO {

    private static final String SQL_INSERT = "INSERT INTO Ouvrage"
            + " (titre, sous_titre, resume, idAuteur)"
            + " VALUES (?, ?, ?, ?)";

    private static final String SQL_DELETE = "DELETE FROM Ouvrage"
            + " WHERE idOuvrage = ?";
    
   
    private static final String SQL_UPDATE = "UPDATE Ouvrage"
            + " SET titre = ?,"
            + " sous_titre = ?,"
            + " resume = ?,"
            + " idAuteur = ?"
            + " WHERE idOuvrage = ?";

    private static final String SQL_FIND_ALL = "SELECT"
            + " idOuvrage, idAuteur, titre, sous_titre, resume"
            + " FROM Ouvrage ";

    private static final String SQL_FIND_BY_TITRE = "SELECT"
            + " idOuvrage, idAuteur, titre, sous_titre, resume"
            + " FROM Ouvrage"
            + " WHERE titre = ?";

    private static final String SQL_FIND_BY_ID = "SELECT"
            + " idOuvrage, idAuteur, titre, sous_titre, resume"
            + " FROM Ouvrage"
            + " WHERE idOuvrage = ?";

    private static final String SQL_FIND_BY_SOUSTITRE = "SELECT"
            + " idOuvrage, idAuteur, titre, sous_titre, resume"
            + " FROM Ouvrage"
            + " WHERE sousTitre = ?";

    private static final String SQL_FIND_BY_EDITION = "SELECT"
            + " o.idOuvrage, o.idAuteur, o.titre, o.sous_titre, o.resume"
            + " FROM Ouvrage AS o"
            + " JOIN Edition AS ed ON ed.idStatutEdition = ste.idStatutEdition"
            + " WHERE ed.isbn =?";

    private static final String SQL_FIND_BY_RUBRIQUE = "SELECT"
            + " o.idOuvrage, o.idAuteur, o.titre, o.sous_titre, o.resume"
            + " FROM Ouvrage AS o"
            + " JOIN MiseEnRubrique AS mer ON mer.idOuvrage = o.idOuvrage"
            + " WHERE mer.idRubrique =?";
    
    private static final String SQL_VIEW_RUBRIQUE = "SELECT"
            + " o.titre, r.libelle"
            + " FROM Ouvrage AS o"
            + " JOIN MiseEnRubrique AS m"
            + " ON m.idOuvrage = o.idOuvrage"
            + " JOIN Rubrique AS r"
            + " ON r.idRubrique = m.idRubrique"
            + " WHERE m.idRubrique = 1";

    public OuvrageSqlDAO(AbstractDAOFactory factory) {
        super(factory);
    }
    
    private void detachTags(Long id) throws DAOException {
        SqlDAOFactory factory = getFactory();
        Connection connexion = null;
        PreparedStatement preparedStatement = null;
        try {
            /* Récupération d'une connexion depuis la Factory */
            connexion = factory.getConnection();

            preparedStatement = getPreparedStatement(connexion, 
                    "DELETE FROM Referencement WHERE idOuvrage = ?", false, id);

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new DAOException(e);
        } finally {
            close(preparedStatement, connexion);
        }
    }
    
    private void attachTags(Long id, List<Tag> tags) throws DAOException {
        SqlDAOFactory factory = getFactory();
        Connection connexion = null;
        PreparedStatement preparedStatement = null;

        try {
            detachTags(id);
            for (Tag tag : tags) {
                /* Récupération d'une connexion depuis la Factory */
                connexion = factory.getConnection();

                preparedStatement = getPreparedStatement(connexion, 
                        "INSERT INTO Referencement (idTag, idOuvrage)"
                      + " VALUES (?, ?)", false,
                      tag.getId(), id);

                preparedStatement.executeUpdate();
            }
            
        } catch (SQLException e) {
            throw new DAOException(e);
        } finally {
            close(preparedStatement, connexion);
        }
    }
    
    private void detachCoAuteurs(Long id) throws DAOException {
        SqlDAOFactory factory = getFactory();
        Connection connexion = null;
        PreparedStatement preparedStatement = null;
        try {
            /* Récupération d'une connexion depuis la Factory */
            connexion = factory.getConnection();

            preparedStatement = getPreparedStatement(connexion, 
                    "DELETE FROM CoAuteur WHERE idOuvrage = ?", false, id);

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new DAOException(e);
        } finally {
            close(preparedStatement, connexion);
        }
    }
    
    private void attachCoAuteurs(Long id, List<Auteur> auteurs) throws DAOException {
        SqlDAOFactory factory = getFactory();
        Connection connexion = null;
        PreparedStatement preparedStatement = null;

        try {
            detachCoAuteurs(id);
            for (Auteur auteur : auteurs) {
                /* Récupération d'une connexion depuis la Factory */
                connexion = factory.getConnection();

                preparedStatement = getPreparedStatement(connexion, 
                        "INSERT INTO CoAuteur (idAuteur, idOuvrage)"
                      + " VALUES (?, ?)", false,
                      auteur.getId(), id);

                preparedStatement.executeUpdate();
            }
            
        } catch (SQLException e) {
            throw new DAOException(e);
        } finally {
            close(preparedStatement, connexion);
        }
    }
    
    private void detachRubriques(Long id) throws DAOException {
        SqlDAOFactory factory = getFactory();
        Connection connexion = null;
        PreparedStatement preparedStatement = null;
        try {
            /* Récupération d'une connexion depuis la Factory */
            connexion = factory.getConnection();

            preparedStatement = getPreparedStatement(connexion, 
                    "DELETE FROM MiseEnRubrique WHERE idOuvrage = ?", false, id);

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new DAOException(e);
        } finally {
            close(preparedStatement, connexion);
        }
    }
    
    private void attachRubriques(Long id, List<Rubrique> rubriques) throws DAOException {
        SqlDAOFactory factory = getFactory();
        Connection connexion = null;
        PreparedStatement preparedStatement = null;

        try {
            detachRubriques(id);
            for (Rubrique rubrique : rubriques) {
                /* Récupération d'une connexion depuis la Factory */
                connexion = factory.getConnection();

                preparedStatement = getPreparedStatement(connexion, 
                        "INSERT INTO MiseEnRubrique (idRubrique, idOuvrage)"
                      + " VALUES (?, ?)", false,
                      rubrique.getId(), id);

                preparedStatement.executeUpdate();
            }
            
        } catch (SQLException e) {
            throw new DAOException(e);
        } finally {
            close(preparedStatement, connexion);
        }
    }
    
    private void detachThemes(Long id) throws DAOException {
        SqlDAOFactory factory = getFactory();
        Connection connexion = null;
        PreparedStatement preparedStatement = null;

        try {
            /* Récupération d'une connexion depuis la Factory */
            connexion = factory.getConnection();

            preparedStatement = getPreparedStatement(connexion, 
                    "DELETE FROM Thematique WHERE idOuvrage = ?", false, id);

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new DAOException(e);
        } finally {
            close(preparedStatement, connexion);
        }
    }
    
    private void attachThemes(Long id, List<Theme> themes) throws DAOException {
        SqlDAOFactory factory = getFactory();
        Connection connexion = null;
        PreparedStatement preparedStatement = null;

        try {
            detachThemes(id);
            for (Theme theme : themes) {
                /* Récupération d'une connexion depuis la Factory */
                connexion = factory.getConnection();

                preparedStatement = getPreparedStatement(connexion, 
                        "INSERT INTO Thematique (idTheme, idOuvrage)"
                      + " VALUES (?, ?)", false,
                      theme.getId(), id);

                preparedStatement.executeUpdate();
            }
            
        } catch (SQLException e) {
            throw new DAOException(e);
        } finally {
            close(preparedStatement, connexion);
        }
    }
    
    private void attachGenres(Long id, List<Genre> genres) throws DAOException {
        SqlDAOFactory factory = getFactory();
        Connection connexion = null;
        PreparedStatement preparedStatement = null;

        try {
            detachGenres(id);
            for (Genre genre : genres) {
                /* Récupération d'une connexion depuis la Factory */
                connexion = factory.getConnection();

                preparedStatement = getPreparedStatement(connexion, 
                        "INSERT INTO IndexGenre (idGenre, idOuvrage)"
                      + " VALUES (?, ?)", false,
                      genre.getId(), id);

                preparedStatement.executeUpdate();
            }
            
        } catch (SQLException e) {
            throw new DAOException(e);
        } finally {
            close(preparedStatement, connexion);
        }
    }
    
    private void detachGenres(Long id) throws DAOException {
        SqlDAOFactory factory = getFactory();
        Connection connexion = null;
        PreparedStatement preparedStatement = null;

        try {
            /* Récupération d'une connexion depuis la Factory */
            connexion = factory.getConnection();

            preparedStatement = getPreparedStatement(connexion, 
                    "DELETE FROM IndexGenre WHERE idOuvrage = ?", false, id);

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new DAOException(e);
        } finally {
            close(preparedStatement, connexion);
        }
    }
    
    @Override
    public void viewRubrique(Ouvrage instance) throws DAOException{
        SqlDAOFactory factory = getFactory();
        Connection connexion = null;
        
        
        try {
            Statement stmt = connexion.createStatement();
            String query = SQL_VIEW_RUBRIQUE;
            
            ResultSet rs = stmt.executeQuery(query);
            
            
            rs.close();
            stmt.close();
            
        } catch (SQLException e) {
            throw new DAOException(e);
        }finally {
            close(connexion);
        }
       
        
    }

    @Override
    public void create(Ouvrage instance) throws DAOException {
        SqlDAOFactory factory = getFactory();
        Connection connexion = null;
        PreparedStatement preparedStatement = null;
        ResultSet valeursAutoGenerees = null;

        try {

            if (instance.getAuteur() == null) {
                throw new DAOException("Un ouvrage doit avoir un auteur");
            }
            
            // nous sauvegardons l'auteur si il n'est pas référencé dans la base de données.
            if (instance.getAuteur().getId() == null) {
                getFactory().getAuteurDAO().save(instance.getAuteur());
            }

            /* Récupération d'une connexion depuis la Factory */
            connexion = factory.getConnection();

            preparedStatement = getPreparedStatement(connexion, SQL_INSERT, true,
                    instance.getTitre(), 
                    instance.getSousTitre(), 
                    instance.getResume(),
                    instance.getAuteur().getId());

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
    public void update(Ouvrage instance) throws DAOException {
        SqlDAOFactory factory = getFactory();
        Connection connexion = null;
        PreparedStatement preparedStatement = null;

        try {

            /* Récupération d'une connexion depuis la Factory */
            connexion = factory.getConnection();

            preparedStatement = getPreparedStatement(connexion, SQL_UPDATE, false,
                    instance.getTitre(), 
                    instance.getSousTitre(), 
                    instance.getResume(),
                    instance.getAuteur().getId(), 
                    instance.getId());

            int statut = preparedStatement.executeUpdate();
            /* Analyse du statut retourné par la requête d'insertion */
            if (statut == 0) {
                throw new DAOException("Échec de la création de l'ouvrage, aucune ligne ajoutée dans la table.");
            }
            
        } catch (SQLException e) {
            throw new DAOException(e);
        } finally {
            close(preparedStatement, connexion);
        }
    }

    @Override
    public void save(Ouvrage instance) throws DAOException {
        
        if(instance.getTags() != null) {
            instance.getTags().forEach(getFactory().getTagDAO()::save);
        }
        
        if(instance.getId() != null) {
            update(instance);
        } else {
            create(instance);
        }
        
        attachGenres(instance.getId(), instance.getGenres());
        attachThemes(instance.getId(), instance.getThemes());
        attachRubriques(instance.getId(), instance.getRubriques());
        attachCoAuteurs(instance.getId(), instance.getCoAuteurs());
        attachTags(instance.getId(), instance.getTags());
        
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
        SqlDAOFactory factory = getFactory();
        Connection connexion = null;
        PreparedStatement preparedStatement = null;
        ResultSet valeursAutoGenerees = null;

        try {
            /* Récupération d'une connexion depuis la Factory */
            connexion = factory.getConnection();
            preparedStatement = getPreparedStatement(connexion, SQL_DELETE, true, instance.getId());
            int statut = preparedStatement.executeUpdate();
            /* Analyse du statut retourné par la requête d'insertion */
            if (statut == 0) {
                throw new DAOException("Échec de la suppression de l'ouvrage, aucune ligne supprimée dans la table.");
            }
        } catch (SQLException e) {
            throw new DAOException(e);
        } finally {
            close(valeursAutoGenerees, preparedStatement, connexion);
        }
    }

    @Override
    public Ouvrage findByTitre(String titre) throws DAOException {
        SqlDAOFactory factory = getFactory();
        Connection connexion = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Ouvrage ouvrage = null;

        try {
            /* Récupération d'une connexion depuis la Factory */
            connexion = factory.getConnection();
            preparedStatement = getPreparedStatement(connexion, SQL_FIND_BY_TITRE, false, titre);
            resultSet = preparedStatement.executeQuery();
            /* Parcours de la ligne de données de l'éventuel ResulSet retourné */
            if (resultSet.next()) {
                ouvrage = map(resultSet);
            }
        } catch (SQLException e) {
            throw new DAOException(e);
        } finally {
            close(resultSet, preparedStatement, connexion);
        }

        return ouvrage;

    }

    @Override
    public Ouvrage findBySousTitre(String sousTitre) {
        SqlDAOFactory factory = getFactory();
        Connection connexion = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Ouvrage ouvrage = null;

        try {
            /* Récupération d'une connexion depuis la Factory */
            connexion = factory.getConnection();
            preparedStatement = getPreparedStatement(connexion, SQL_FIND_BY_SOUSTITRE, false, sousTitre);
            resultSet = preparedStatement.executeQuery();
            /* Parcours de la ligne de données de l'éventuel ResulSet retourné */
            if (resultSet.next()) {
                ouvrage = map(resultSet);
            }
        } catch (SQLException e) {
            throw new DAOException(e);
        } finally {
            close(resultSet, preparedStatement, connexion);
        }

        return ouvrage;

    }

    public List<Ouvrage> findByEdition(String isbn) throws DAOException {
        SqlDAOFactory factory = getFactory();
        Connection connexion = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<Ouvrage> ouvrages = new ArrayList<>();

        try {
            connexion = factory.getConnection();
            preparedStatement = getPreparedStatement(connexion, SQL_FIND_BY_EDITION, false, isbn);
            resultSet = preparedStatement.executeQuery();

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
    protected Ouvrage map(ResultSet result) throws SQLException {
        DAOFactoryInterface factory = getFactory();

        Ouvrage ouvrage = new Ouvrage();

        Long idOuvrage = result.getLong("idOuvrage");

        ouvrage.setId(idOuvrage);
        ouvrage.setTitre(result.getString("titre"));
        ouvrage.setSousTitre(result.getString("sous_titre"));
        ouvrage.setResume(result.getString("resume"));

        // on recupere l'auteur depuis la base de données.
        // Auteur auteur = factory.getAuteurDAO().findById(result.getLong("idAuteur"));
        // puis on l'assigne à l'ouvrage.
        //ouvrage.setAuteur(auteur);
        // on recupère les genres attachés à l'ouvrage pour lui assigner
        List<Genre> genres = factory.getGenreDAO().findByOuvrage(idOuvrage);
        ouvrage.setGenres(genres);

        List<Rubrique> rubriques = factory.getRubriqueDAO().findByOuvrage(idOuvrage);
        ouvrage.setRubriques(rubriques);

        List<Tag> tags = factory.getTagDAO().findByOuvrage(idOuvrage);
        ouvrage.setTags(tags);

        List<Theme> themes = factory.getThemeDAO().findByOuvrage(idOuvrage);
        ouvrage.setThemes(themes);
        
        Auteur auteur = factory.getAuteurDAO().findById(result.getLong("idAuteur"));
        ouvrage.setAuteur(auteur);
        
        List<Auteur> coAuteurs = factory.getAuteurDAO().findCoAuteursByOuvrage(idOuvrage);
        ouvrage.setCoAuteurs(coAuteurs);
        
        return ouvrage;
    }

    @Override
    /* public List<Ouvrage> findByAuteur(String nom) throws DAOException {
     SqlDAOFactory factory = getFactory();
     Connection connexion = null;
     PreparedStatement preparedStatement = null;
     ResultSet resultSet = null;
     List<Ouvrage> ouvrages = new ArrayList<>();

     try {
     connexion = factory.getConnection();
     preparedStatement = getPreparedStatement(connexion, SQL_FIND_BY_AUTEUR, false, nom);
     resultSet = preparedStatement.executeQuery();

     //            resultSet.beforeFirst();
     while (resultSet.next()) {
     ouvrages.add(map(resultSet));
     }

     if (resultSet.next()) {
     ouvrages = new ArrayList<>();
     ouvrages.add(map(resultSet));
     }
     } catch (SQLException e) {
     throw new DAOException(e);
     } finally {
     close(resultSet, preparedStatement, connexion);
     }

     return ouvrages;

     }*/

    public Ouvrage findById(Long id) throws DAOException {
        SqlDAOFactory factory = getFactory();
        Connection connexion = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Ouvrage ouvrage = null;

        try {
            /* Récupération d'une connexion depuis la Factory */
            connexion = factory.getConnection();
            preparedStatement = getPreparedStatement(connexion, SQL_FIND_BY_ID, false, id);
            resultSet = preparedStatement.executeQuery();
            /* Parcours de la ligne de données de l'éventuel ResulSet retourné */
            if (resultSet.next()) {
                ouvrage = map(resultSet);
            }
        } catch (SQLException e) {
            throw new DAOException(e);
        } finally {
            close(resultSet, preparedStatement, connexion);
        }

        return ouvrage;

    }

    @Override
    public List<Ouvrage> findByRubrique(Long id) {
        SqlDAOFactory factory = getFactory();
        Connection connexion = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<Ouvrage> ouvrages = new ArrayList<>();

        try {
            connexion = factory.getConnection();
            preparedStatement = getPreparedStatement(connexion, SQL_FIND_BY_RUBRIQUE, false, id);
            resultSet = preparedStatement.executeQuery();

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



}
