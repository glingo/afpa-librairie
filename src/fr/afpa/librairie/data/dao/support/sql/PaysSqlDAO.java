package fr.afpa.librairie.data.dao.support.sql;

import fr.afpa.librairie.data.AbstractDAOFactory;
import fr.afpa.librairie.data.bean.Pays;
import fr.afpa.librairie.data.dao.PaysDAO;
import fr.afpa.librairie.data.exception.DAOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PaysSqlDAO extends AbstractSqlDAO<Pays> implements PaysDAO {

    private static final String SQL_INSERT = "INSERT INTO Pays"
            + " (libelle, code)"
            + " VALUES (?, ?)";
    
    private static final String SQL_UPDATE = "UPDATE Pays"
            + " SET libelle = ?,"
            + " code = ?"
            + " WHERE idPays = ?";
    
    private static final String SQL_DELETE = "DELETE FROM Pays WHERE idPays = ?";
    
    private static final String SQL_FIND_ALL = "SELECT idPays, libelle, code FROM Pays ";
    
    private static final String SQL_FIND_BY_ID = "SELECT"
            + " idPays, libelle, code"
            + " FROM Pays"
            + " WHERE idPays = ?";
    
    private static final String SQL_FIND_BY_LIBELLE = "SELECT"
            + " idPays, libelle, code"
            + " FROM Pays"
            + " WHERE libelle = ?";
    
    private static final String SQL_FIND_BY_CODE = "SELECT"
            + " idPays, libelle, code"
            + " FROM Pays"
            + " WHERE code = ?";
    
    public PaysSqlDAO(AbstractDAOFactory factory) {
        super(factory);
    }

    @Override
    public void create(Pays instance) throws DAOException {
        SqlDAOFactory factory = getFactory();
        Connection connexion = null;
        PreparedStatement preparedStatement = null;
        ResultSet valeursAutoGenerees = null;

        try {

            connexion = factory.getConnection();

            preparedStatement = getPreparedStatement(connexion, SQL_INSERT, true,
                    instance.getLibelle(), instance.getCode());

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
    public void update(Pays instance) throws DAOException {
        SqlDAOFactory factory = getFactory();
        Connection connexion = null;
        PreparedStatement preparedStatement = null;
        ResultSet valeursAutoGenerees = null;

        try {

            connexion = factory.getConnection();

            preparedStatement = getPreparedStatement(connexion, SQL_UPDATE, false,
                    instance.getLibelle(), instance.getCode(), instance.getId());

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
    public void save(Pays instance) throws DAOException {
        if(instance.getId() != null) {
            update(instance);
        } else {
            create(instance);
        }
    }

    @Override
    public void delete(Pays instance) {
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
    public List<Pays> findAll() throws DAOException {
        SqlDAOFactory factory = getFactory();
        Connection connexion = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<Pays> pays = new ArrayList<>();

        try {
            connexion = factory.getConnection();
            preparedStatement = getPreparedStatement(connexion, SQL_FIND_ALL, false);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                pays.add(map(resultSet));
            }
        } catch (SQLException e) {
            throw new DAOException(e);
        } finally {
            close(resultSet, preparedStatement, connexion);
        }

        return pays;

    }

    @Override
    protected Pays map(ResultSet resultSet) throws SQLException {
        Pays tag = new Pays();
        
        tag.setId(resultSet.getLong("idPays"));
        tag.setLibelle(resultSet.getString("libelle"));
        tag.setCode(resultSet.getString("code"));
        
        return tag;
       
    }
    
    @Override
    public Pays findById(Long id) throws DAOException {
        SqlDAOFactory factory = getFactory();
        Connection connexion = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Pays pays = null;

        System.out.println("find pays by id : " + id);
        try {
            connexion = factory.getConnection();
            preparedStatement = getPreparedStatement(connexion, SQL_FIND_BY_ID, 
                    false, id);
            resultSet = preparedStatement.executeQuery();

            if(resultSet.next()) {
                pays = map(resultSet);
            }
            
        } catch (SQLException e) {
            throw new DAOException(e);
        } finally {
            close(resultSet, preparedStatement, connexion);
        }

        return pays;
    }

    @Override
    public Pays findByLibelle(String libelle) { 
        SqlDAOFactory factory = getFactory();
        Connection connexion = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Pays pays = null;

        try {
            connexion = factory.getConnection();
            preparedStatement = getPreparedStatement(connexion, SQL_FIND_BY_LIBELLE, 
                    false, libelle);
            resultSet = preparedStatement.executeQuery();

            pays = map(resultSet);
            
        } catch (SQLException e) {
            throw new DAOException(e);
        } finally {
            close(resultSet, preparedStatement, connexion);
        }

        return pays;
    }

    @Override
    public Pays findByCode(String code) throws DAOException {
        SqlDAOFactory factory = getFactory();
        Connection connexion = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Pays pays = null;

        try {
            /* Récupération d'une connexion depuis la Factory */
            connexion = factory.getConnection();
            preparedStatement = getPreparedStatement(connexion, SQL_FIND_BY_CODE, false, code);
            resultSet = preparedStatement.executeQuery();
            /* Parcours de la ligne de données de l'éventuel ResulSet retourné */
            if (resultSet.next()) {
                pays = map(resultSet);
            }
        } catch (SQLException e) {
            throw new DAOException(e);
        } finally {
            close(resultSet, preparedStatement, connexion);
        }

        return pays;
    }

}
