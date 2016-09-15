package fr.afpa.librairie.data.dao.support.sql;

import fr.afpa.librairie.data.AbstractDAOFactory;
import fr.afpa.librairie.data.bean.StatutAdresse;
import fr.afpa.librairie.data.dao.StatutAdresseDAO;
import fr.afpa.librairie.data.exception.DAOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

// DAO = Data Access Object
// DTO = Data Transfert Object

public class StatutAdresseSqlDAO extends AbstractSqlDAO<StatutAdresse> implements StatutAdresseDAO {

    private static final String SQL_INSERT = "INSERT INTO StatutAdresse (libelle, code) VALUES (?, ?)";
    private static final String SQL_DELETE = "DELETE FROM StatutAdresse WHERE id = ?";
    
    private static final String SQL_UPDATE = "UPDATE StatutAdresse"
            + " SET libelle = ?,"
            + " code = ?"
            + " WHERE idStatuAdresse = ?";
    
    private static final String SQL_FIND_ALL = "SELECT"
            + " idStatutAdresse, libelle, code"
            + " FROM StatutAdresse";
    
    private static final String SQL_FIND_BY_ID = "SELECT"
            + " idStatutAdresse, libelle, code"
            + " FROM StatutAdresse"
            + " WHERE idStatutAdresse = ?";
    
    private static final String SQL_FIND_BY_CODE = "SELECT"
            + " idStatutAdresse, libelle, code"
            + " FROM StatutAdresse"
            + " WHERE code = ?";
    
    private static final String SQL_FIND_BY_LIBELLE = "SELECT"
            + " idStatutAdresse, libelle, code"
            + " FROM StatutAdresse"
            + " WHERE libelle = ?";

    
    private static final String SQL_FIND_BY_UTILISATEUR = "SELECT"
            +" stu.idStatutAdresse, stu.libelle, stu.code"
            +" FROM StatutAdresse AS stu"
            +" JOIN Adresse AS ut ON ut.idStatutAdresse = stu.idStatutAdresse"
            +" WHERE ut.idAdresse =?";
    

    public StatutAdresseSqlDAO(AbstractDAOFactory factory) {
        super(factory);
    }

    @Override
    public void update(StatutAdresse instance) throws DAOException {
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
                /* Puis initialisation de la propriété id du bean Adresse avec sa valeur */
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
    public void create(StatutAdresse instance) throws DAOException {
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
                throw new DAOException("Échec de la création du statut de l'utilisateur, aucune ligne ajoutée dans la table.");
            }
            /* Récupération de l'id auto-généré par la requête d'insertion */
            valeursAutoGenerees = preparedStatement.getGeneratedKeys();
            if (valeursAutoGenerees.next()) {
                /* Puis initialisation de la propriété id du bean Adresse avec sa valeur */
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
    public void save(StatutAdresse instance) throws DAOException {
        if(instance.getId() != null) {
            update(instance);
        } else {
            create(instance);
        }
    }

    @Override
    public void delete(StatutAdresse instance) {
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
                throw new DAOException("Échec de la suppression de l'utilisateur, aucune ligne supprimée dans la table.");
            }
        } catch (SQLException e) {
            throw new DAOException(e);
        } finally {
            close(valeursAutoGenerees, preparedStatement, connexion);
        }

    }
    
    @Override
    public List<StatutAdresse> findAll() throws DAOException {
        SqlDAOFactory factory = getFactory();
        Connection connexion = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<StatutAdresse> statuts = new ArrayList<>();

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
    public StatutAdresse findById(Long id) throws DAOException {
        SqlDAOFactory factory = getFactory();
        Connection connexion = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        StatutAdresse statut = null;
        
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
    public List<StatutAdresse> findByAdresse(Long idAdresse) throws DAOException {
        SqlDAOFactory factory = getFactory();
        Connection connexion = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<StatutAdresse> statutAdresses = new ArrayList<>();

        try {
            connexion = factory.getConnection();
            preparedStatement = getPreparedStatement(connexion, SQL_FIND_BY_UTILISATEUR, false, idAdresse);
            resultSet = preparedStatement.executeQuery();
            
//            resultSet.beforeFirst();
            
            while (resultSet.next()) {
                statutAdresses.add(map(resultSet));
            }
            
            if (resultSet.next()) {
                statutAdresses= new ArrayList<>();
                statutAdresses.add(map(resultSet));
            }
        } catch (SQLException e) {
            throw new DAOException(e);
        } finally {
            close(resultSet, preparedStatement, connexion);
        }

        return statutAdresses;

    }


    @Override
    public StatutAdresse findByCode(String code) throws DAOException {
        SqlDAOFactory factory = getFactory();
        Connection connexion = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        StatutAdresse statut = null;

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
     * ResultSet) et un bean Adresse.
     */
    @Override
    protected StatutAdresse map(ResultSet resultSet) throws SQLException {
        StatutAdresse statut = new StatutAdresse();
        
        statut.setId(resultSet.getLong("idStatutAdresse"));
        statut.setLibelle(resultSet.getString("libelle"));
        statut.setCode(resultSet.getString("code"));
               
        return statut;
    }



}
