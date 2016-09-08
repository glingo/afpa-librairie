
package fr.afpa.librairie.data.dao.support.sql;

import fr.afpa.librairie.data.DAOFactoryInterface;
import fr.afpa.librairie.data.bean.Theme;
import fr.afpa.librairie.data.dao.ThemeDAO;
import fr.afpa.librairie.data.exception.DAOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ThemeSqlDAO extends AbstractSqlDAO<Theme> implements ThemeDAO {
    
    private static final String SQL_INSERT = "INSERT INTO Theme (libelle) VALUES (?)";
    private static final String SQL_DELETE = "DELETE FROM Theme WHERE idTheme = ?";
    private static final String SQL_FIND_ALL = "SELECT idTheme, libelle FROM Theme";
    
    
    private static final String SQL_FIND_BY_OUVRAGE = "SELECT"
            + " t.idTheme, t.libelle"
            + " FROM Theme AS t"
            + " JOIN Thematique AS th on t.idTheme = th.idTheme"
            + " WHERE th.idOuvrage = ?";
    
    
    public ThemeSqlDAO(DAOFactoryInterface factory) {
        super(factory);
    }
    
    
    
    @Override
    protected Theme map(ResultSet resultSet) throws SQLException {
        Theme theme = new Theme();
        
        theme.setId(resultSet.getLong("idTheme"));
        theme.setLibelle(resultSet.getString("Libelle"));
        
        return theme;
    }
    

    @Override
    public List<Theme> findAll() throws DAOException {
        SqlDAOFactory factory = getFactory();
        Connection connexion = null;
        PreparedStatement preparedStatement = null; 
        ResultSet resultSet = null ;
        List<Theme> themes = new ArrayList<>();
        
        try {
            connexion = factory.getConnection();
            preparedStatement = getPreparedStatement(connexion, SQL_FIND_ALL, false);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                themes.add(map(resultSet));
            }
        } catch (SQLException e) {
            throw new DAOException(e);
        } finally {
            close(resultSet, preparedStatement, connexion);
        }
 
        return themes;
    }

    @Override
    public void save(Theme instance) throws DAOException {
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
                throw new DAOException("Échec de la création du theme, aucune ligne ajoutée dans la table.");
            }

            valeursAutoGenerees = preparedStatement.getGeneratedKeys();
            if (valeursAutoGenerees.next()) {
                instance.setId(valeursAutoGenerees.getLong(1));
            } else {
                throw new DAOException("Échec de la création du theme en base, aucun ID auto-généré retourné.");
            }
        } catch (SQLException e) {
            throw new DAOException(e);
        } finally {
            close(valeursAutoGenerees, preparedStatement, connexion);
        }
    
    }

    @Override
    public void delete(Theme instance) throws DAOException {
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
                throw new DAOException("Échec de la suppression du theme, aucune ligne supprimée dans la table.");
            }
        } catch (SQLException e) {
            throw new DAOException(e);
        } finally {
            close(valeursAutoGenerees, preparedStatement, connexion);
        }

    }

    @Override
    public Theme findByExemple(Theme instance) throws DAOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Theme findById(Long id) throws DAOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Theme findByLibelle(String libelle) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Theme> findByOuvrage(Long idOuvrage) throws DAOException {
        SqlDAOFactory factory = getFactory();
        Connection connexion = null;
        PreparedStatement preparedStatement = null; 
        ResultSet resultSet = null ;
        List<Theme> themes = new ArrayList<>();
        
        try {
            connexion = factory.getConnection();
            preparedStatement = getPreparedStatement(connexion, SQL_FIND_BY_OUVRAGE, false, idOuvrage);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                themes.add(map(resultSet));
            }
        } catch (SQLException e) {
            throw new DAOException(e);
        } finally {
            close(resultSet, preparedStatement, connexion);
        }
 
        return themes;
    }
    
}
