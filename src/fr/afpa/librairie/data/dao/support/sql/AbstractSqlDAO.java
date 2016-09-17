package fr.afpa.librairie.data.dao.support.sql;

import fr.afpa.librairie.data.AbstractDAOFactory;
import fr.afpa.librairie.data.DAOFactoryInterface;
import fr.afpa.librairie.data.dao.AbstractDAO;
import fr.afpa.librairie.data.dao.DAOInterface;
import fr.afpa.librairie.data.dao.RoleDAO;
import fr.afpa.librairie.data.exception.DAOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public abstract class AbstractSqlDAO<T> extends AbstractDAO<T> {

    public AbstractSqlDAO(DAOFactoryInterface factory) {
        super(factory);
    }

    protected abstract T map(ResultSet result) throws SQLException;
    
    
    @Override
    public abstract void create(T instance) throws DAOException;
    @Override
    public abstract void update(T instance) throws DAOException;

    
    /*
     * Initialise la requête préparée basée sur la connexion passée en argument,
     * avec la requête SQL et les objets donnés.
     */
    public PreparedStatement getPreparedStatement(Connection connexion, String sql, boolean returnGeneratedKeys, Object... objets) throws SQLException {
        PreparedStatement preparedStatement = connexion.prepareStatement(sql, returnGeneratedKeys ? Statement.RETURN_GENERATED_KEYS : Statement.NO_GENERATED_KEYS);
        if(objets != null) {
            for (int i = 0; i < objets.length; i++) {
                preparedStatement.setObject(i + 1, objets[i]);
            }
        }
        return preparedStatement;
    }
    
    /* Fermeture silencieuse du resultset */
    public void close(ResultSet resultSet) {
        if (resultSet != null) {
            try {
                resultSet.close();
            } catch (SQLException e) {
                System.out.println("Échec de la fermeture du ResultSet : " + e.getMessage());
            }
        }
    }

    /* Fermeture silencieuse du statement */
    public void close(Statement statement) {
        if (statement != null) {
            try {
                statement.close();
            } catch (SQLException e) {
                System.out.println("Échec de la fermeture du Statement : " + e.getMessage());
            }
        }
    }

    /* Fermeture silencieuse de la connexion */
    public void close(Connection connexion) {
        if (connexion != null) {
            try {
                connexion.close();
            } catch (SQLException e) {
                System.out.println("Échec de la fermeture de la connexion : " + e.getMessage());
            }
        }
    }

    /* Fermetures silencieuses du statement et de la connexion */
    public void close(Statement statement, Connection connexion) {
        close(statement);
        close(connexion);
    }

    /* Fermetures silencieuses du resultset, du statement et de la connexion */
    public void close(ResultSet resultSet, Statement statement, Connection connexion) {
        close(resultSet);
        close(statement);
        close(connexion);
    }

}
