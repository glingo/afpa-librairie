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
            +" ste.idStatutAdresse, ste.libelle, ste.code"
            +" FROM StatutAdresse AS ste"
            +" JOIN Adresse AS ut ON ut.idStatutAdresse = ste.idStatutAdresse"
            +" WHERE ut.idAdresse =?";
    

    public StatutAdresseSqlDAO(AbstractDAOFactory factory) {
        super(factory);
    }
    

    @Override
    public void save(StatutAdresse instance) throws DAOException {
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
                throw new DAOException("Échec de la création du statut de l'entreprise, aucune ligne ajoutée dans la table.");
            }
            /* Récupération de l'id auto-généré par la requête d'insertion */
            valeursAutoGenerees = preparedStatement.getGeneratedKeys();
            if (valeursAutoGenerees.next()) {
                /* Puis initialisation de la propriété id du bean Adresse avec sa valeur */
                instance.setId(valeursAutoGenerees.getLong(1));
            } else {
                throw new DAOException("Échec de la création du statut de l'entreprise en base, aucun ID auto-généré retourné.");
            }
        } catch (SQLException e) {
            throw new DAOException(e);
        } finally {
            close(valeursAutoGenerees, preparedStatement, connexion);
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
                throw new DAOException("Échec de la suppression de l'entreprise, aucune ligne supprimée dans la table.");
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
    public StatutAdresse findByExemple(StatutAdresse instance) throws DAOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
