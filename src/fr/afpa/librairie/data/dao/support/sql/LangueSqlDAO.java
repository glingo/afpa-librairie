package fr.afpa.librairie.data.dao.support.sql;

import fr.afpa.librairie.data.AbstractDAOFactory;
import fr.afpa.librairie.data.bean.Langue;
import fr.afpa.librairie.data.dao.LangueDAO;
import fr.afpa.librairie.data.dao.support.sql.AbstractSqlDAO;
import fr.afpa.librairie.data.dao.support.sql.SqlDAOFactory;
import fr.afpa.librairie.data.exception.DAOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LangueSqlDAO extends AbstractSqlDAO<Langue> implements LangueDAO {

    private static final String SQL_INSERT = "INSERT INTO Langue"
            + " (libelle, code)"
            + " VALUES (?, ?)";

    private static final String SQL_DELETE = "DELETE FROM Langue WHERE idLangue = ?";

    private static final String SQL_FIND_ALL = "SELECT"
            + " idLangue, libelle, code"
            + " FROM Langue";

    private static final String SQL_FIND_BY_LIBELLE = "SELECT"
            + " idLangue, libelle, code"
            + " FROM Langue"
            + " WHERE libelle = ?";

    private static final String SQL_FIND_BY_CODE = "SELECT"
            + " idLangue, libelle, code"
            + " FROM Langue"
            + " WHERE code = ?";
    private static final String SQL_FIND_BY_ID = "SELECT"
            + " idLangue, libelle, code"
            + " FROM Langue"
            + " WHERE idLangue = ?";

    private static final String SQL_FIND_BY_EDITION = "SELECT"
            + " ste.idStatutEdition, ste.libelle, ste.code"
            + " FROM StatutEdition AS ste"
            + " JOIN Edition AS ed ON ed.idStatutEdition = ste.idStatutEdition"
            + " WHERE ed.isbn =?";

    public LangueSqlDAO(AbstractDAOFactory factory) {
        super(factory);
    }

    @Override
    public void save(Langue instance) throws DAOException {
        SqlDAOFactory factory = getFactory();
        Connection connexion = null;
        PreparedStatement preparedStatement = null;
        ResultSet valeursAutoGenerees = null;

        try {

            connexion = factory.getConnection();

            preparedStatement = getPreparedStatement(connexion, SQL_INSERT, true,
                    instance.getLibelle());

            int statut = preparedStatement.executeUpdate();

            if (statut == 0) {
                throw new DAOException("Échec de la création de la langue, aucune ligne ajoutée dans la table.");
            }

            valeursAutoGenerees = preparedStatement.getGeneratedKeys();
            if (valeursAutoGenerees.next()) {
                instance.setId(valeursAutoGenerees.getLong(1));
            } else {
                throw new DAOException("Échec de la création dde la langue en base, aucun ID auto-généré retourné.");
            }
        } catch (SQLException e) {
            throw new DAOException(e);
        } finally {
            close(valeursAutoGenerees, preparedStatement, connexion);
        }
    }

    @Override
    public void delete(Langue instance) {
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
                throw new DAOException("Échec de la suppression de la langue, aucune ligne supprimée dans la table.");
            }
        } catch (SQLException e) {
            throw new DAOException(e);
        } finally {
            close(valeursAutoGenerees, preparedStatement, connexion);
        }

    }

    @Override
    public List<Langue> findAll() throws DAOException {
        SqlDAOFactory factory = getFactory();
        Connection connexion = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<Langue> langues = new ArrayList<>();

        try {
            connexion = factory.getConnection();
            preparedStatement = getPreparedStatement(connexion, SQL_FIND_ALL, false);
            resultSet = preparedStatement.executeQuery();

//            resultSet.beforeFirst();
            while (resultSet.next()) {
                langues.add(map(resultSet));
            }
        } catch (SQLException e) {
            throw new DAOException(e);
        } finally {
            close(resultSet, preparedStatement, connexion);
        }

        return langues;

    }

    public List<Langue> findByEdition(String isbn) throws DAOException {
        SqlDAOFactory factory = getFactory();
        Connection connexion = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<Langue> langues = new ArrayList<>();

        try {
            connexion = factory.getConnection();
            preparedStatement = getPreparedStatement(connexion, SQL_FIND_BY_EDITION, false, isbn);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                langues.add(map(resultSet));
            }

            if (resultSet.next()) {
                langues = new ArrayList<>();
                langues.add(map(resultSet));
            }
        } catch (SQLException e) {
            throw new DAOException(e);
        } finally {
            close(resultSet, preparedStatement, connexion);
        }

        return langues;

    }


    /*
     * Simple méthode utilitaire permettant de faire la correspondance (le
     * mapping) entre une ligne issue de la table des utilisateurs (un
     * ResultSet) et un bean Utilisateur.
     */
    @Override
    protected Langue map(ResultSet resultSet) throws SQLException {
        SqlDAOFactory factory = getFactory();
        Langue langue = new Langue();

        langue.setId(resultSet.getLong("idLangue"));
        langue.setLibelle(resultSet.getString("libelle"));
        langue.setCode(resultSet.getString("code"));

        return langue;
    }

    @Override
    public Langue findByLibelle(String libelle) {
        SqlDAOFactory factory = getFactory();
        Connection connexion = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Langue langue = null;

        try {

            connexion = factory.getConnection();
            preparedStatement = getPreparedStatement(connexion, SQL_FIND_BY_LIBELLE, false, libelle);
            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                langue = map(resultSet);
            }
        } catch (SQLException e) {
            throw new DAOException(e);
        } finally {
            close(resultSet, preparedStatement, connexion);
        }

        return langue;
    }

    @Override
    public Langue findByCode(String code) {
        SqlDAOFactory factory = getFactory();
        Connection connexion = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Langue langue = null;

        try {
            /* Récupération d'une connexion depuis la Factory */
            connexion = factory.getConnection();
            preparedStatement = getPreparedStatement(connexion, SQL_FIND_BY_CODE, false, code);
            resultSet = preparedStatement.executeQuery();
            /* Parcours de la ligne de données de l'éventuel ResulSet retourné */
            if (resultSet.next()) {
                langue = map(resultSet);
            }
        } catch (SQLException e) {
            throw new DAOException(e);
        } finally {
            close(resultSet, preparedStatement, connexion);
        }

        return langue;
    }

    @Override
    public Langue findById(Long id) throws DAOException {
        SqlDAOFactory factory = getFactory();
        Connection connexion = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Langue langue = null;

        try {
            /* Récupération d'une connexion depuis la Factory */
            connexion = factory.getConnection();
            preparedStatement = getPreparedStatement(connexion, SQL_FIND_BY_ID, false, id);
            resultSet = preparedStatement.executeQuery();
            /* Parcours de la ligne de données de l'éventuel ResulSet retourné */
            if (resultSet.next()) {
                langue = map(resultSet);
            }
        } catch (SQLException e) {
            throw new DAOException(e);
        } finally {
            close(resultSet, preparedStatement, connexion);
        }

        return langue;
    }

    @Override
    public Langue findByExemple(Langue instance) throws DAOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
