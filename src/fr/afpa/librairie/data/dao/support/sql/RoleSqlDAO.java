package fr.afpa.librairie.data.dao.support.sql;

import fr.afpa.librairie.data.DAOFactoryInterface;
import fr.afpa.librairie.data.bean.Role;
import fr.afpa.librairie.data.bean.StatutUtilisateur;
import fr.afpa.librairie.data.exception.DAOException;
import fr.afpa.librairie.data.dao.RoleDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

// DAO = Data Access Object
// DTO = Data Transfert Object

public class RoleSqlDAO extends AbstractSqlDAO<Role> implements RoleDAO {

    private static final String SQL_INSERT = "INSERT INTO Role"
            + " (libelle, code) VALUES"
            + " (?, ?)";
    
    private static final String SQL_DELETE = "DELETE FROM Role WHERE idRole = ?";
    
    private static final String SQL_FIND_ALL = "SELECT"
            + " idRole, libelle, code"
            + " FROM Role";
    
    private static final String SQL_FIND_BY_ID = "SELECT"
            + " idRole, libelle, code"
            + " FROM Role"
            + " WHERE idRole = ?";
    
    private static final String SQL_FIND_BY_LIBELLE = "SELECT"
            + " idRole, libelle, code "
            + "FROM Role "
            + "WHERE libelle = ?";
    
    private static final String SQL_FIND_BY_CODE = "SELECT"
            + " idRole, libelle, code"
            + " FROM Role"
            + " WHERE code = ?";
    
    private static final String SQL_FIND_BY_UTILISATEUR = "SELECT"
            + " ro.idRole, ro.libelle, ro.code"
            + " FROM Role AS ro"
            + " JOIN Remplit AS r ON r.idRole = ro.idRole"
            + " WHERE r.idUtilisateur = ?";

    
    public RoleSqlDAO(DAOFactoryInterface factory) {
        super(factory);
    }

    @Override
    public void save(Role role) throws DAOException {
        SqlDAOFactory factory = getFactory();
        Connection connexion = null;
        PreparedStatement preparedStatement = null;
        ResultSet valeursAutoGenerees = null;

        try {
            
            /* Récupération d'une connexion depuis la Factory */
            connexion = factory.getConnection();
            
            preparedStatement = getPreparedStatement(
                    connexion, SQL_INSERT, true, 
                    role.getLibelle(), role.getCode());
            
            int statut = preparedStatement.executeUpdate();
            /* Analyse du statut retourné par la requête d'insertion */
            if (statut == 0) {
                throw new DAOException("Échec de la création de l'utilisateur, aucune ligne ajoutée dans la table.");
            }
            
            /* Récupération de l'id auto-généré par la requête d'insertion */
            valeursAutoGenerees = preparedStatement.getGeneratedKeys();
            
            
            if (!valeursAutoGenerees.next()) {
                throw new DAOException("Échec de la création de l'utilisateur en base, aucun ID auto-généré retourné.");
            }
                
            /* Puis initialisation de la propriété id du bean Role avec sa valeur */
            role.setId(valeursAutoGenerees.getLong(1));
            
        } catch (SQLException e) {
            throw new DAOException(e);
        } finally {
            close(valeursAutoGenerees, preparedStatement, connexion);
        }
    }

    @Override
    public void delete(Role role) {
        SqlDAOFactory factory = getFactory();
        Connection connexion = null;
        PreparedStatement preparedStatement = null;
        ResultSet valeursAutoGenerees = null;

        try {
            /* Récupération d'une connexion depuis la Factory */
            connexion = factory.getConnection();
            preparedStatement = getPreparedStatement(connexion, SQL_DELETE, true, role.getId());
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
    public List<Role> findAll() throws DAOException {
        SqlDAOFactory factory = getFactory();
        Connection connexion = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<Role> roles = new ArrayList<>();

        try {
            connexion = factory.getConnection();
            preparedStatement = getPreparedStatement(connexion, SQL_FIND_ALL, false);
            resultSet = preparedStatement.executeQuery();
            
//            resultSet.beforeFirst();
            
            while (resultSet.next()) {
                roles.add(map(resultSet));
            }
            
            if (resultSet.next()) {
                roles = new ArrayList<>();
                roles.add(map(resultSet));
            }
        } catch (SQLException e) {
            throw new DAOException(e);
        } finally {
            close(resultSet, preparedStatement, connexion);
        }

        return roles;

    }

    @Override
    public Role findByExemple(Role instance) throws DAOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public Role findById(Long id) throws DAOException {
        SqlDAOFactory factory = getFactory();
        Connection connexion = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Role role = null;
        
        try {
            /* Récupération d'une connexion depuis la Factory */
            connexion = factory.getConnection();
            preparedStatement = getPreparedStatement(connexion, SQL_FIND_BY_ID, false, id);
            resultSet = preparedStatement.executeQuery();
            /* Parcours de la ligne de données de l'éventuel ResulSet retourné */
            if (resultSet.next()) {
                role = map(resultSet);
            }
        } catch (SQLException e) {
            throw new DAOException(e);
        } finally {
            close(resultSet, preparedStatement, connexion);
        }

        return role;
        
    }

    public Role findByLibelle(String libelle) throws DAOException {
        SqlDAOFactory factory = getFactory();
        Connection connexion = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Role role = null;

        try {
            /* Récupération d'une connexion depuis la Factory */
            connexion = factory.getConnection();
            preparedStatement = getPreparedStatement(connexion, SQL_FIND_BY_LIBELLE, false, libelle);
            resultSet = preparedStatement.executeQuery();
            /* Parcours de la ligne de données de l'éventuel ResulSet retourné */
            if (resultSet.next()) {
                role = map(resultSet);
            }
        } catch (SQLException e) {
            throw new DAOException(e);
        } finally {
            close(resultSet, preparedStatement, connexion);
        }

        return role;

    }
    
    public List<Role> findByUtilisateur(Long idUtilisateur) throws DAOException {
        SqlDAOFactory factory = getFactory();
        Connection connexion = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<Role> roles = new ArrayList<>();

        try {
            connexion = factory.getConnection();
            preparedStatement = getPreparedStatement(connexion, SQL_FIND_BY_UTILISATEUR, false, idUtilisateur);
            resultSet = preparedStatement.executeQuery();
            
//            resultSet.beforeFirst();
            
            while (resultSet.next()) {
                roles.add(map(resultSet));
            }
            
            if (resultSet.next()) {
                roles = new ArrayList<>();
                roles.add(map(resultSet));
            }
        } catch (SQLException e) {
            throw new DAOException(e);
        } finally {
            close(resultSet, preparedStatement, connexion);
        }

        return roles;

    }

    @Override
    public Role findByCode(String code) {
        SqlDAOFactory factory = getFactory();
        Connection connexion = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Role role = null;

        try {
            /* Récupération d'une connexion depuis la Factory */
            connexion = factory.getConnection();
            preparedStatement = getPreparedStatement(connexion, SQL_FIND_BY_CODE, false, code);
            resultSet = preparedStatement.executeQuery();
            /* Parcours de la ligne de données de l'éventuel ResulSet retourné */
            if (resultSet.next()) {
                role = map(resultSet);
            }
        } catch (SQLException e) {
            throw new DAOException(e);
        } finally {
            close(resultSet, preparedStatement, connexion);
        }

        return role;
    }

    @Override
    protected Role map(ResultSet resultSet) throws SQLException {
        Role role = new Role();
        
        role.setId(resultSet.getLong("idRole"));
        role.setLibelle(resultSet.getString("libelle"));
        role.setCode(resultSet.getString("code"));
        
        return role;
    }

}
