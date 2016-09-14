package fr.afpa.librairie.data.dao.support.sql;

import fr.afpa.librairie.data.AbstractDAOFactory;
import fr.afpa.librairie.data.bean.Tag;
import fr.afpa.librairie.data.dao.TagDAO;
import fr.afpa.librairie.data.exception.DAOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TagSqlDAO extends AbstractSqlDAO<Tag> implements TagDAO {

    private static final String SQL_INSERT = "INSERT INTO Tag"
            + " (libelle)"
            + " VALUES (?)";
    
    private static final String SQL_UPDATE = "UPDATE Tag"
            + " SET libelle = ?"
            + " WHERE idTag = ?";
    
    private static final String SQL_DELETE = "DELETE FROM Tag WHERE idTag = ?";
    
    private static final String SQL_FIND_ALL = "SELECT idTag, libelle FROM Tag ";
    
    private static final String SQL_FIND_BY_ID = "SELECT"
            + " idTag, libelle"
            + " FROM Tag"
            + " WHERE idTag = ?";
    
    private static final String SQL_FIND_BY_LIBELLE = "SELECT"
            + " idTag, libelle"
            + " FROM Tag"
            + " WHERE libelle = ?";
    
     private static final String SQL_FIND_BY_OUVRAGE = "SELECT"
             + " t.idTag, t.libelle"
             + " FROM Tag AS t"
             + " JOIN Referencement AS r on r.idTag = t.idTag"
             + " WHERE r.idOuvrage = ?";

    public TagSqlDAO(AbstractDAOFactory factory) {
        super(factory);
    }
    
    

    @Override
    public void create(Tag instance) throws DAOException {
        SqlDAOFactory factory = getFactory();
        Connection connexion = null;
        PreparedStatement preparedStatement = null;
        ResultSet valeursAutoGenerees = null;

        try {

            connexion = factory.getConnection();

            preparedStatement = getPreparedStatement(connexion, SQL_INSERT, true,
                    instance.getLibelle());

            int statut = preparedStatement.executeUpdate();
            /* Analyse du statut retourné par la requête d'insertion */
            if (statut == 0) {
                throw new DAOException("Échec de la création du Tag, aucune ligne ajoutée dans la table.");
            }

            valeursAutoGenerees = preparedStatement.getGeneratedKeys();
            if (valeursAutoGenerees.next()) {
                instance.setId(valeursAutoGenerees.getLong(1));
            } else {
                throw new DAOException("Échec de la création du Tag en base, aucun ID auto-généré retourné.");
            }
        } catch (SQLException e) {
            throw new DAOException(e);
        } finally {
            close(valeursAutoGenerees, preparedStatement, connexion);
        }
    }

    @Override
    public void update(Tag instance) throws DAOException {
        SqlDAOFactory factory = getFactory();
        Connection connexion = null;
        PreparedStatement preparedStatement = null;
        ResultSet valeursAutoGenerees = null;

        try {

            connexion = factory.getConnection();

            preparedStatement = getPreparedStatement(connexion, SQL_UPDATE, true,
                    instance.getLibelle(), instance.getId());

            int statut = preparedStatement.executeUpdate();
            /* Analyse du statut retourné par la requête d'insertion */
            if (statut == 0) {
                throw new DAOException("Échec de la création du Tag, aucune ligne ajoutée dans la table.");
            }

        } catch (SQLException e) {
            throw new DAOException(e);
        } finally {
            close(valeursAutoGenerees, preparedStatement, connexion);
        }
    
    }

    @Override
    public void save(Tag instance) throws DAOException {
        
    }

    @Override
    public void delete(Tag instance) {
        SqlDAOFactory factory = getFactory();
        Connection connexion = getFactory();
        PreparedStatement preparedStatement = null;
        ResultSet valeursAutoGenerees = null;

        try {
            connexion = factory.getConnection();
            preparedStatement = getPreparedStatement(connexion, SQL_DELETE, true, instance.getId());
            int statut = preparedStatement.executeUpdate();
            if (statut == 0) {
                throw new DAOException("Échec de la suppression de l'auteur, aucune ligne supprimée dans la table.");
            }
        } catch (SQLException e) {
            throw new DAOException(e);
        } finally {
            close(valeursAutoGenerees, preparedStatement, connexion);
        }

    }
    
    @Override
    public List<Tag> findAll() throws DAOException {
        SqlDAOFactory factory = getFactory();
        Connection connexion = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<Tag> tags = new ArrayList<>();

        try {
            connexion = factory.getConnection();
            preparedStatement = getPreparedStatement(connexion, SQL_FIND_ALL, false);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                tags.add(map(resultSet));
            }
        } catch (SQLException e) {
            throw new DAOException(e);
        } finally {
            close(resultSet, preparedStatement, connexion);
        }

        return tags;

    }

    @Override
    protected Tag map(ResultSet resultSet) throws SQLException {
        Tag tag = new Tag();
        
        tag.setId(resultSet.getLong("idTag"));
        tag.setLibelle(resultSet.getString("Libelle"));
        
        return tag;
       
    }
    
    @Override
    public Tag findById(Long id) throws DAOException {
        SqlDAOFactory factory = getFactory();
        Connection connexion = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Tag tag = null;

        try {
            connexion = factory.getConnection();
            preparedStatement = getPreparedStatement(connexion, SQL_FIND_BY_ID, 
                    false, id);
            resultSet = preparedStatement.executeQuery();

            tag = map(resultSet);
            
        } catch (SQLException e) {
            throw new DAOException(e);
        } finally {
            close(resultSet, preparedStatement, connexion);
        }

        return tag;
    }

    @Override
    public Tag findByLibelle(String libelle) { 
        SqlDAOFactory factory = getFactory();
        Connection connexion = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Tag tag = null;

        try {
            connexion = factory.getConnection();
            preparedStatement = getPreparedStatement(connexion, SQL_FIND_BY_LIBELLE, 
                    false, libelle);
            resultSet = preparedStatement.executeQuery();

            tag = map(resultSet);
            
        } catch (SQLException e) {
            throw new DAOException(e);
        } finally {
            close(resultSet, preparedStatement, connexion);
        }

        return tag;
    }

    @Override
    public List<Tag> findByOuvrage(Long idOuvrage) throws DAOException {
        SqlDAOFactory factory = getFactory();
        Connection connexion = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<Tag> tags = new ArrayList<>();

        try {
            connexion = factory.getConnection();
            preparedStatement = getPreparedStatement(connexion, SQL_FIND_BY_OUVRAGE, false, idOuvrage);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                tags.add(map(resultSet));
            }
        } catch (SQLException e) {
            throw new DAOException(e);
        } finally {
            close(resultSet, preparedStatement, connexion);
        }

        return tags;
    }
}
