
package fr.afpa.librairie.data.dao.support.sql;

import fr.afpa.librairie.data.DAOFactoryInterface;
import fr.afpa.librairie.data.bean.Genre;
import fr.afpa.librairie.data.dao.GenreDAO;
import fr.afpa.librairie.data.exception.DAOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GenreSqlDAO extends AbstractSqlDAO<Genre> implements GenreDAO {
    
    public static final String SQL_INSERT = "INSERT INTO Genre"
            + " (libelle)"
            + " VALUES (?)";
    
    public static final String SQL_UPDATE = "UPDATE Genre"
            + " SET libelle = ?"
            + " WHERE idGenre = ?";
    
    public static final String SQL_DELETE = "DELETE FROM Genre WHERE idGenre = ?";
    
    public static final String SQL_FIND_ALL = "SELECT"
            + " idGenre, libelle"
            + " FROM Genre ";  
    
    public static final String SQL_FIND_BY_ID = "SELECT"
            + " g.idGenre, g.libelle"
            + " FROM Genre as g"
            + " WHERE g.idOuvrage = ?";  
    
    public static final String SQL_FIND_BY_LIBELLE = "SELECT"
            + " g.idGenre, g.libelle"
            + " FROM Genre as g"
            + " WHERE g.libelle = ?";  
    
    public static final String SQL_FIND_BY_OUVRAGE = "SELECT"
            + " g.idGenre, g.libelle"
            + " FROM Genre as g"
            + " JOIN IndexGenre AS i on i.idGenre = g.idGenre"
            + " WHERE i.idOuvrage = ?";    
    
    
    public GenreSqlDAO(DAOFactoryInterface factory) {
        super(factory);
    }
    
    

    @Override
    public void create(Genre instance) throws DAOException {
        SqlDAOFactory factory = getFactory();
        Connection connexion = null;
        PreparedStatement preparedStatement = null;
        ResultSet valeursAutoGenerees = null;

        try {

            connexion = factory.getConnection();

            preparedStatement = getPreparedStatement(connexion, SQL_INSERT, true,
                    instance.getLibelle());

            int statut = preparedStatement.executeUpdate();

            if (statut == 0) {
                throw new DAOException("Échec de la création du genre, aucune ligne ajoutée dans la table.");
            }

            valeursAutoGenerees = preparedStatement.getGeneratedKeys();
            if (valeursAutoGenerees.next()) {
                instance.setId(valeursAutoGenerees.getLong(1));
            } else {
                throw new DAOException("Échec de la création du genre en base, aucun ID auto-généré retourné.");
            }
        } catch (SQLException e) {
            throw new DAOException(e);
        } finally {
            close(valeursAutoGenerees, preparedStatement, connexion);
        }
    
    }

    @Override
    public void update(Genre instance) throws DAOException {
        
        SqlDAOFactory factory = getFactory();
        Connection connexion = null;
        PreparedStatement preparedStatement = null;
        ResultSet valeursAutoGenerees = null;

        try {

            connexion = factory.getConnection();

            preparedStatement = getPreparedStatement(connexion, SQL_UPDATE, true,
                    instance.getLibelle(), instance.getId());

            int statut = preparedStatement.executeUpdate();

            if (statut == 0) {
                throw new DAOException("Échec de la création du genre, aucune ligne ajoutée dans la table.");
            }
        } catch (SQLException e) {
            throw new DAOException(e);
        } finally {
            close(valeursAutoGenerees, preparedStatement, connexion);
        }
    }

    @Override
    public void save(Genre instance) throws DAOException {
        if(instance.getId() != null) {
            update(instance);
        } else {
            create(instance);
        }
    }

    @Override
    public void delete(Genre instance) throws DAOException {
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
                throw new DAOException("Échec de la suppression du genre, aucune ligne supprimée dans la table.");
            }
        } catch (SQLException e) {
            throw new DAOException(e);
        } finally {
            close(valeursAutoGenerees, preparedStatement, connexion);
        }

    
    }

    @Override
    public List<Genre> findAll() throws DAOException {
        SqlDAOFactory factory = getFactory();
        Connection connexion = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<Genre> genres = new ArrayList<>();

        try {
            connexion = factory.getConnection();
            preparedStatement = getPreparedStatement(connexion, SQL_FIND_ALL, false);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                genres.add(map(resultSet));
            }
        } catch (SQLException e) {
            throw new DAOException(e);
        } finally {
            close(resultSet, preparedStatement, connexion);
        }

        return genres;
    }

    @Override
    protected Genre map(ResultSet resultSet) throws SQLException {
       Genre genre = new Genre();
       
       genre.setId(resultSet.getLong("idGenre"));
       genre.setLibelle(resultSet.getString("Libelle"));
       
       
       return genre;
    }

    @Override
    public Genre findById(Long id) throws DAOException {
        SqlDAOFactory factory = getFactory();
        Connection connexion = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Genre genre = null;

        try {
            connexion = factory.getConnection();
            preparedStatement = getPreparedStatement(connexion, SQL_FIND_BY_ID,
                    false, id);
            resultSet = preparedStatement.executeQuery();

            genre = map(resultSet);
            
        } catch (SQLException e) {
            throw new DAOException(e);
        } finally {
            close(resultSet, preparedStatement, connexion);
        }

        return genre; 
    }

    @Override
    public Genre findByLibelle(String libelle) {
        SqlDAOFactory factory = getFactory();
        Connection connexion = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Genre genre = null;

        try {
            connexion = factory.getConnection();
            
            preparedStatement = getPreparedStatement(connexion, SQL_FIND_BY_LIBELLE,
                    false, libelle);
            resultSet = preparedStatement.executeQuery();

            genre = map(resultSet);
            
        } catch (SQLException e) {
            throw new DAOException(e);
        } finally {
            close(resultSet, preparedStatement, connexion);
        }

        return genre; 
    }

    @Override
    public List<Genre> findByOuvrage(Long idOuvrage) throws DAOException {
        SqlDAOFactory factory = getFactory();
        Connection connexion = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<Genre> genres = new ArrayList<>();

        try {
            connexion = factory.getConnection();
            preparedStatement = getPreparedStatement(connexion, SQL_FIND_BY_OUVRAGE, false, idOuvrage);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                genres.add(map(resultSet));
            }
            
        } catch (SQLException e) {
            throw new DAOException(e);
        } finally {
            close(resultSet, preparedStatement, connexion);
        }

        return genres;
    }

    
}
