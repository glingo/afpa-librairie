package fr.afpa.librairie.data.dao.support.sql;

import fr.afpa.librairie.data.AbstractDAOFactory;
import fr.afpa.librairie.data.bean.StatutEntreprise;
import fr.afpa.librairie.data.dao.StatutEntrepriseDAO;
import fr.afpa.librairie.data.exception.DAOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

// DAO = Data Access Object
// DTO = Data Transfert Object

public class StatutEntrepriseSqlDAO extends AbstractSqlDAO<StatutEntreprise> implements StatutEntrepriseDAO {

    private static final String SQL_INSERT = "INSERT INTO StatutEntreprise (libelle, code) VALUES (?, ?)";
    private static final String SQL_DELETE = "DELETE FROM StatutEntreprise WHERE id = ?";
    
    private static final String SQL_UPDATE = "UPDATE StatutEntreprise"
            + " SET libelle = ?,"
            + " code = ?"
            + " WHERE idStatutEntreprise = ?";
    
    private static final String SQL_FIND_ALL = "SELECT"
            + " idStatutEntreprise, libelle, code"
            + " FROM StatutEntreprise";
    
    private static final String SQL_FIND_BY_ID = "SELECT"
            + " idStatutEntreprise, libelle, code"
            + " FROM StatutEntreprise"
            + " WHERE idStatutEntreprise = ?";
    
    private static final String SQL_FIND_BY_CODE = "SELECT"
            + " idStatutEntreprise, libelle, code"
            + " FROM StatutEntreprise"
            + " WHERE code = ?";
    
    private static final String SQL_FIND_BY_LIBELLE = "SELECT"
            + " idStatutEntreprise, libelle, code"
            + " FROM StatutEntreprise"
            + " WHERE libelle = ?";

    
    private static final String SQL_FIND_BY_UTILISATEUR = "SELECT"
            +" stu.idStatutEntreprise, stu.libelle, stu.code"
            +" FROM StatutEntreprise AS stu"
            +" JOIN Entreprise AS ut ON ut.idStatutEntreprise = stu.idStatutEntreprise"
            +" WHERE ut.idEntreprise =?";
    

    public StatutEntrepriseSqlDAO(AbstractDAOFactory factory) {
        super(factory);
    }

    @Override
    public void create(StatutEntreprise instance) throws DAOException {
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
                /* Puis initialisation de la propriété id du bean Entreprise avec sa valeur */
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
    public void update(StatutEntreprise instance) throws DAOException {
        SqlDAOFactory factory = getFactory();
        Connection connexion = null;
        PreparedStatement preparedStatement = null;
        ResultSet valeursAutoGenerees = null;

        try {
            /* Récupération d'une connexion depuis la Factory */
            connexion = factory.getConnection();
            
            preparedStatement = getPreparedStatement(
                    connexion, SQL_UPDATE, false, 
                    instance.getLibelle(), 
                    instance.getCode(),
                    instance.getId());
            
            int statut = preparedStatement.executeUpdate();
            /* Analyse du statut retourné par la requête d'insertion */
            if (statut == 0) {
                throw new DAOException("Échec de la création du statut de l'entreprise, aucune ligne ajoutée dans la table.");
            }
        } catch (SQLException e) {
            throw new DAOException(e);
        } finally {
            close(valeursAutoGenerees, preparedStatement, connexion);
        }
    }

    @Override
    public void save(StatutEntreprise instance) throws DAOException {
        if(instance.getId() != null) {
            update(instance);
        } else {
            create(instance);
        }
    }

    @Override
    public void delete(StatutEntreprise instance) {
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
    public List<StatutEntreprise> findAll() throws DAOException {
        SqlDAOFactory factory = getFactory();
        Connection connexion = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<StatutEntreprise> statuts = new ArrayList<>();

        try {
            connexion = factory.getConnection();
            preparedStatement = getPreparedStatement(connexion, SQL_FIND_ALL, false);
            resultSet = preparedStatement.executeQuery();
            
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
    public StatutEntreprise findById(Long id) throws DAOException {
        SqlDAOFactory factory = getFactory();
        Connection connexion = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        StatutEntreprise statut = null;
        
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
    public List<StatutEntreprise> findByEntreprise(Long idEntreprise) throws DAOException {
        SqlDAOFactory factory = getFactory();
        Connection connexion = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<StatutEntreprise> statutEntreprises = new ArrayList<>();

        try {
            connexion = factory.getConnection();
            preparedStatement = getPreparedStatement(connexion, SQL_FIND_BY_UTILISATEUR, false, idEntreprise);
            resultSet = preparedStatement.executeQuery();
            
            while (resultSet.next()) {
                statutEntreprises.add(map(resultSet));
            }
        } catch (SQLException e) {
            throw new DAOException(e);
        } finally {
            close(resultSet, preparedStatement, connexion);
        }

        return statutEntreprises;

    }


    @Override
    public StatutEntreprise findByCode(String code) throws DAOException {
        SqlDAOFactory factory = getFactory();
        Connection connexion = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        StatutEntreprise statut = null;

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
     * mapping) entre une ligne issue de la table des entreprises (un
     * ResultSet) et un bean Entreprise.
     */
    @Override
    protected StatutEntreprise map(ResultSet resultSet) throws SQLException {
        StatutEntreprise statut = new StatutEntreprise();
        
        statut.setId(resultSet.getLong("idStatutEntreprise"));
        statut.setLibelle(resultSet.getString("libelle"));
        statut.setCode(resultSet.getString("code"));
               
        return statut;
    }

}
