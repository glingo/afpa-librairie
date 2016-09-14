package fr.afpa.librairie.data.dao.support.sql;

import fr.afpa.librairie.data.AbstractDAOFactory;
import fr.afpa.librairie.data.bean.StatutEdition;
import fr.afpa.librairie.data.dao.StatutEditionDAO;
import fr.afpa.librairie.data.exception.DAOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StatutEditionSqlDAO extends AbstractSqlDAO<StatutEdition> implements StatutEditionDAO {

    private static final String SQL_INSERT = "INSERT INTO StatutEdition (libelle, code) VALUES (?, ?)";
    private static final String SQL_DELETE = "DELETE FROM StatutEdition WHERE id = ?";
    
    private static final String SQL_UPDATE = "UPDATE StatutEdition"
            + " SET libelle = ?,"
            + " code = ?"
            + " WHERE idStatutEdition = ?";

    private static final String SQL_FIND_ALL = "SELECT"
            + " idStatutEdition, libelle, code"
            + " FROM StatutEdition";

    private static final String SQL_FIND_BY_ID = "SELECT"
            + " idStatutEdition, libelle, code"
            + " FROM StatutEdition"
            + " WHERE idStatutEdition = ?";

    private static final String SQL_FIND_BY_CODE = "SELECT"
            + " idStatutEdition, libelle, code"
            + " FROM StatutEdition"
            + " WHERE code = ?";

    private static final String SQL_FIND_BY_LIBELLE = "SELECT"
            + " idStatutEdition, libelle, code"
            + " FROM StatutEdition"
            + " WHERE libelle = ?";

    private static final String SQL_FIND_BY_EDITION = "SELECT"
            + " ste.idStatutEdition, ste.libelle, ste.code"
            + " FROM StatutEdition AS ste"
            + " JOIN Edition AS ed ON ed.idStatutEdition = ste.idStatutEdition"
            + " WHERE ed.isbn =?";

    public StatutEditionSqlDAO(AbstractDAOFactory factory) {
        super(factory);

    }

    @Override
    public void create(StatutEdition instance) throws DAOException {
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
                throw new DAOException("Échec de la création du statut de l'edition, aucune ligne ajoutée dans la table.");
            }
            /* Récupération de l'id auto-généré par la requête d'insertion */
            valeursAutoGenerees = preparedStatement.getGeneratedKeys();
            if (valeursAutoGenerees.next()) {
                /* Puis initialisation de la propriété id du bean Utilisateur avec sa valeur */
                instance.setId(valeursAutoGenerees.getLong(1));
            } else {
                throw new DAOException("Échec de la création du statut de l'edition en base, aucun ID auto-généré retourné.");
            }
        } catch (SQLException e) {
            throw new DAOException(e);
        } finally {
            close(valeursAutoGenerees, preparedStatement, connexion);
        }
    }

    @Override
    public void update(StatutEdition instance) throws DAOException {
        SqlDAOFactory factory = getFactory();
        Connection connexion = null;
        PreparedStatement preparedStatement = null;
        ResultSet valeursAutoGenerees = null;

        try {
            /* Récupération d'une connexion depuis la Factory */
            connexion = factory.getConnection();

            preparedStatement = getPreparedStatement(
                    connexion, SQL_UPDATE, true,
                    instance.getLibelle(), instance.getCode(), instance.getId());

            int statut = preparedStatement.executeUpdate();
            /* Analyse du statut retourné par la requête d'insertion */
            if (statut == 0) {
                throw new DAOException("Échec de la création du statut de l'edition, aucune ligne ajoutée dans la table.");
            }
        } catch (SQLException e) {
            throw new DAOException(e);
        } finally {
            close(valeursAutoGenerees, preparedStatement, connexion);
        }
    }

    @Override
    public void save(StatutEdition instance) throws DAOException {
        if(instance.getId() != null) {
            update(instance);
        } else {
            create(instance);
        }
    }

    @Override
    public void delete(StatutEdition instance) {
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
                throw new DAOException("Échec de la suppression de l'edition, aucune ligne supprimée dans la table.");
            }
        } catch (SQLException e) {
            throw new DAOException(e);
        } finally {
            close(valeursAutoGenerees, preparedStatement, connexion);
        }

    }

    @Override
    public List<StatutEdition> findAll() throws DAOException {
        SqlDAOFactory factory = getFactory();
        Connection connexion = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<StatutEdition> statuts = new ArrayList<>();

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
    public StatutEdition findById(Long id) throws DAOException {
        SqlDAOFactory factory = getFactory();
        Connection connexion = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        StatutEdition statut = null;

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
    public List<StatutEdition> findByEdition(String isbn) throws DAOException {
        SqlDAOFactory factory = getFactory();
        Connection connexion = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<StatutEdition> statutEditions = new ArrayList<>();

        try {
            connexion = factory.getConnection();
            preparedStatement = getPreparedStatement(connexion, SQL_FIND_BY_EDITION, false, isbn);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                statutEditions.add(map(resultSet));
            }

            if (resultSet.next()) {
                statutEditions = new ArrayList<>();
                statutEditions.add(map(resultSet));
            }
        } catch (SQLException e) {
            throw new DAOException(e);
        } finally {
            close(resultSet, preparedStatement, connexion);
        }

        return statutEditions;

    }

    @Override
    public StatutEdition findByCode(String code) throws DAOException {
        SqlDAOFactory factory = getFactory();
        Connection connexion = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        StatutEdition statut = null;

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

    @Override
    protected StatutEdition map(ResultSet resultSet) throws SQLException {
        StatutEdition statut = new StatutEdition();

        statut.setId(resultSet.getLong("idStatutEdition"));
        statut.setLibelle(resultSet.getString("libelle"));
        statut.setCode(resultSet.getString("code"));

        return statut;
    }

}
