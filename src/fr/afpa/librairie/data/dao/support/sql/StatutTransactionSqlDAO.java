package fr.afpa.librairie.data.dao.support.sql;

import fr.afpa.librairie.data.AbstractDAOFactory;
import fr.afpa.librairie.data.bean.StatutTransaction;
import fr.afpa.librairie.data.dao.StatutTransactionDAO;
import fr.afpa.librairie.data.exception.DAOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

// DAO = Data Access Object
// DTO = Data Transfert Object

public class StatutTransactionSqlDAO extends AbstractSqlDAO<StatutTransaction> implements StatutTransactionDAO {

    private static final String SQL_INSERT = "INSERT INTO StatutTransaction (libelle, code) VALUES (?, ?)";
    private static final String SQL_DELETE = "DELETE FROM StatutTransaction WHERE id = ?";
    
    private static final String SQL_UPDATE = "UPDATE StatutTransaction"
            + " SET libelle = ?,"
            + " code = ?"
            + " WHERE idStatuTransaction = ?";
    
    private static final String SQL_FIND_ALL = "SELECT"
            + " idStatutTransaction, libelle, code"
            + " FROM StatutTransaction";
    
    private static final String SQL_FIND_BY_ID = "SELECT"
            + " idStatutTransaction, libelle, code"
            + " FROM StatutTransaction"
            + " WHERE idStatutTransaction = ?";
    
    private static final String SQL_FIND_BY_CODE = "SELECT"
            + " idStatutTransaction, libelle, code"
            + " FROM StatutTransaction"
            + " WHERE code = ?";
    
    private static final String SQL_FIND_BY_LIBELLE = "SELECT"
            + " idStatutTransaction, libelle, code"
            + " FROM StatutTransaction"
            + " WHERE libelle = ?";

    
    private static final String SQL_FIND_BY_UTILISATEUR = "SELECT"
            +" stu.idStatutTransaction, stu.libelle, stu.code"
            +" FROM StatutTransaction AS stu"
            +" JOIN Transaction AS ut ON ut.idStatutTransaction = stu.idStatutTransaction"
            +" WHERE ut.idTransaction =?";
    

    public StatutTransactionSqlDAO(AbstractDAOFactory factory) {
        super(factory);
    }

    @Override
    public void update(StatutTransaction instance) throws DAOException {
        SqlDAOFactory factory = getFactory();
        Connection connexion = null;
        PreparedStatement preparedStatement = null;
        ResultSet valeursAutoGenerees = null;

        try {
            /* Récupération d'une connexion depuis la Factory */
            connexion = factory.getConnection();
            
            preparedStatement = getPreparedStatement(
                    connexion, SQL_UPDATE, false, 
                    instance.getLibelle(), instance.getCode(), instance.getId());
            
            int statut = preparedStatement.executeUpdate();
            /* Analyse du statut retourné par la requête d'insertion */
            if (statut == 0) {
                throw new DAOException("Échec de la création du statut de l'utilisateur, aucune ligne ajoutée dans la table.");
            }
            /* Récupération de l'id auto-généré par la requête d'insertion */
            valeursAutoGenerees = preparedStatement.getGeneratedKeys();
            if (valeursAutoGenerees.next()) {
                /* Puis initialisation de la propriété id du bean Transaction avec sa valeur */
                instance.setId(valeursAutoGenerees.getLong(1));
            } else {
                throw new DAOException("Échec de la création du statut de l'utilisateur en base, aucun ID auto-généré retourné.");
            }
        } catch (SQLException e) {
            throw new DAOException(e);
        } finally {
            close(valeursAutoGenerees, preparedStatement, connexion);
        }
    }

    @Override
    public void create(StatutTransaction instance) throws DAOException {
        SqlDAOFactory factory = getFactory();
        Connection connexion = null;
        PreparedStatement preparedStatement = null;
        ResultSet valeursAutoGenerees = null;

        try {
            /* Récupération d'une connexion depuis la Factory */
            connexion = factory.getConnection();
            
            preparedStatement = getPreparedStatement(
                    connexion, SQL_INSERT, true, 
                    instance.getLibelle(), instance.getCode());
            
            int statut = preparedStatement.executeUpdate();
            /* Analyse du statut retourné par la requête d'insertion */
            if (statut == 0) {
                throw new DAOException("Échec de la création du statut de la transaction, aucune ligne ajoutée dans la table.");
            }
            /* Récupération de l'id auto-généré par la requête d'insertion */
            valeursAutoGenerees = preparedStatement.getGeneratedKeys();
            if (valeursAutoGenerees.next()) {
                /* Puis initialisation de la propriété id du bean Transaction avec sa valeur */
                instance.setId(valeursAutoGenerees.getLong(1));
            } else {
                throw new DAOException("Échec de la création du statut de la transaction en base, aucun ID auto-généré retourné.");
            }
        } catch (SQLException e) {
            throw new DAOException(e);
        } finally {
            close(valeursAutoGenerees, preparedStatement, connexion);
        }
    }

    @Override
    public void save(StatutTransaction instance) throws DAOException {
        if(instance.getId() != null) {
            update(instance);
        } else {
            create(instance);
        }
    }

    @Override
    public void delete(StatutTransaction instance) {
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
                throw new DAOException("Échec de la suppression de la transaction, aucune ligne supprimée dans la table.");
            }
        } catch (SQLException e) {
            throw new DAOException(e);
        } finally {
            close(valeursAutoGenerees, preparedStatement, connexion);
        }

    }
    
    @Override
    public List<StatutTransaction> findAll() throws DAOException {
        SqlDAOFactory factory = getFactory();
        Connection connexion = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<StatutTransaction> statuts = new ArrayList<>();

        try {
            connexion = factory.getConnection();
            preparedStatement = getPreparedStatement(connexion, SQL_FIND_ALL, false);
            resultSet = preparedStatement.executeQuery();
            
//            resultSet.beforeFirst();
            
            while (resultSet.next()) {
                statuts.add(map(resultSet));
            }
        } catch (SQLException e) {
            throw new DAOException(e);
        } finally {
            close(resultSet, preparedStatement, connexion);
        }

        return statuts;

    }
    
    @Override
    public StatutTransaction findById(Long id) throws DAOException {
        SqlDAOFactory factory = getFactory();
        Connection connexion = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        StatutTransaction statut = null;
        
        try {
            /* Récupération d'une connexion depuis la Factory */
            connexion = factory.getConnection();
            preparedStatement = getPreparedStatement(connexion, SQL_FIND_BY_ID, false, id);
            resultSet = preparedStatement.executeQuery();
            /* Parcours de la ligne de données de l'éventuel ResulSet retourné */
            if (resultSet.next()) {
                statut = map(resultSet);
            }
        } catch (SQLException e) {
            throw new DAOException(e);
        } finally {
            close(resultSet, preparedStatement, connexion);
        }

        return statut;
        
    }
    
    @Override
    public List<StatutTransaction> findByTransaction(Long idTransaction) throws DAOException {
        SqlDAOFactory factory = getFactory();
        Connection connexion = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<StatutTransaction> statutTransactions = new ArrayList<>();

        try {
            connexion = factory.getConnection();
            preparedStatement = getPreparedStatement(connexion, SQL_FIND_BY_UTILISATEUR, false, idTransaction);
            resultSet = preparedStatement.executeQuery();
            
//            resultSet.beforeFirst();
            
            while (resultSet.next()) {
                statutTransactions.add(map(resultSet));
            }
            
            if (resultSet.next()) {
                statutTransactions= new ArrayList<>();
                statutTransactions.add(map(resultSet));
            }
        } catch (SQLException e) {
            throw new DAOException(e);
        } finally {
            close(resultSet, preparedStatement, connexion);
        }

        return statutTransactions;

    }


    @Override
    public StatutTransaction findByCode(String code) throws DAOException {
        SqlDAOFactory factory = getFactory();
        Connection connexion = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        StatutTransaction statut = null;

        try {
            /* Récupération d'une connexion depuis la Factory */
            connexion = factory.getConnection();
            preparedStatement = getPreparedStatement(connexion, SQL_FIND_BY_CODE, false, code);
            resultSet = preparedStatement.executeQuery();
            /* Parcours de la ligne de données de l'éventuel ResulSet retourné */
            if (resultSet.next()) {
                statut = map(resultSet);
            }
        } catch (SQLException e) {
            throw new DAOException(e);
        } finally {
            close(resultSet, preparedStatement, connexion);
        }

        return statut;

    }

    /*
     * Simple méthode utilitaire permettant de faire la correspondance (le
     * mapping) entre une ligne issue de la table des utilisateurs (un
     * ResultSet) et un bean Transaction.
     */
    @Override
    protected StatutTransaction map(ResultSet resultSet) throws SQLException {
        StatutTransaction statut = new StatutTransaction();
        
        statut.setId(resultSet.getLong("idStatutTransaction"));
        statut.setLibelle(resultSet.getString("libelle"));
        statut.setCode(resultSet.getString("code"));
               
        return statut;
    }



}
