package fr.afpa.librairie.data.dao.support.sql;

import fr.afpa.librairie.data.AbstractDAOFactory;
import fr.afpa.librairie.data.bean.StatutCommande;
import fr.afpa.librairie.data.dao.StatutCommandeDAO;
import fr.afpa.librairie.data.exception.DAOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StatutCommandeSqlDAO extends AbstractSqlDAO<StatutCommande> implements StatutCommandeDAO {

    private static final String SQL_INSERT = "INSERT INTO StatutCommande (libelle, code) VALUES (?, ?)";
    private static final String SQL_DELETE = "DELETE FROM StatutCommande WHERE id = ?";

    private static final String SQL_FIND_ALL = "SELECT"
            + " idStatutCommande, libelle, code"
            + " FROM StatutCommande";

    private static final String SQL_FIND_BY_ID = "SELECT"
            + " idStatutCommande, libelle, code"
            + " FROM StatutCommande"
            + " WHERE idStatutCommande = ?";

    private static final String SQL_FIND_BY_CODE = "SELECT"
            + " idStatutCommande, libelle, code"
            + " FROM StatutCommande"
            + " WHERE code = ?";

    private static final String SQL_FIND_BY_LIBELLE = "SELECT"
            + " idStatutCommande, libelle, code"
            + " FROM StatutCommande"
            + " WHERE libelle = ?";
    
    private static final String SQL_FIND_BY_COMMANDE = "SELECT"
            + " stack.idStatutCommande, stac.libelle, stac.code"
            + " FROM StatutCommande AS stac"
            + " JOIN HistoriqueStatutCommande AS hsc ON hsc.idStatutCommande = stac.idStatutCommande"
            + " WHERE hsc.idCommande = ?";

//    
//    private static final String SQL_FIND_BY_UTILISATEUR = "SELECT"
//            +" stu.idStatutUtilisateur, stu.libelle, stu.code"
//            +" FROM StatutUtilisateur AS stu"
//            +" JOIN Utilisateur AS ut ON ut.idStatutUtilisateur = stu.idStatutUtilisateur"
//            +" WHERE ut.idUtilisateur =?";
//    
    public StatutCommandeSqlDAO(AbstractDAOFactory factory) {
        super(factory);
    }
    
    public List<StatutCommande> findByCommande(String isbn) throws DAOException {
        SqlDAOFactory factory = getFactory();
        Connection connexion = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<StatutCommande> orderStats = new ArrayList<>();

        try {
            connexion = factory.getConnection();
            preparedStatement = getPreparedStatement(connexion, SQL_FIND_BY_COMMANDE, false, isbn);
            resultSet = preparedStatement.executeQuery();
            
//            resultSet.beforeFirst();
            
            while (resultSet.next()) {
                orderStats.add(map(resultSet));
            }
            
            if (resultSet.next()) {
                orderStats = new ArrayList<>();
                orderStats.add(map(resultSet));
            }
        } catch (SQLException e) {
            throw new DAOException(e);
        } finally {
            close(resultSet, preparedStatement, connexion);
        }

        return orderStats;

    }

    @Override
    protected StatutCommande map(ResultSet resultSet) throws SQLException {
        StatutCommande orderStat = new StatutCommande();

        orderStat.setId(resultSet.getLong("idStatutCommande"));
        orderStat.setLibelle(resultSet.getString("libelle"));
        orderStat.setCode(resultSet.getString("code"));
        
        

        return orderStat;

    }

    @Override
    public List<StatutCommande> findAll() throws DAOException {
        SqlDAOFactory factory = getFactory();
        Connection connexion = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<StatutCommande> ordersStatus = new ArrayList<>();

        try {
            connexion = factory.getConnection();
            preparedStatement = getPreparedStatement(connexion, SQL_FIND_ALL, false);
            resultSet = preparedStatement.executeQuery();

//            resultSet.beforeFirst();
            while (resultSet.next()) {
                ordersStatus.add(map(resultSet));
            }
        } catch (SQLException e) {
            throw new DAOException(e);
        } finally {
            close(resultSet, preparedStatement, connexion);
        }

        return ordersStatus;
    }

    @Override
    public void save(StatutCommande instance) throws DAOException {
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
                throw new DAOException("Échec de la création du statut de la commande, aucune ligne ajoutée dans la table.");
            }
            /* Récupération de l'id auto-généré par la requête d'insertion */
            valeursAutoGenerees = preparedStatement.getGeneratedKeys();
            if (valeursAutoGenerees.next()) {
                /* Puis initialisation de la propriété id du bean Utilisateur avec sa valeur */
                instance.setId(valeursAutoGenerees.getLong(1));
            } else {
                throw new DAOException("Échec de la création du statut de la commande en base, aucun ID auto-généré retourné.");
            }
        } catch (SQLException e) {
            throw new DAOException(e);
        } finally {
            close(valeursAutoGenerees, preparedStatement, connexion);
        }
    }

    @Override
    public void delete(StatutCommande instance) throws DAOException {
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
                throw new DAOException("Échec de la suppression du statut de la commande, aucune ligne supprimée dans la table.");
            }
        } catch (SQLException e) {
            throw new DAOException(e);
        } finally {
            close(valeursAutoGenerees, preparedStatement, connexion);
        }
    }

    @Override
    public StatutCommande findByExemple(StatutCommande instance) throws DAOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public StatutCommande findById(Long id) throws DAOException {
        SqlDAOFactory factory = getFactory();
        Connection connexion = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        StatutCommande orderStatus = null;

        try {
            /* Récupération d'une connexion depuis la Factory */
            connexion = factory.getConnection();
            preparedStatement = getPreparedStatement(connexion, SQL_FIND_BY_ID, false, id);
            resultSet = preparedStatement.executeQuery();
            /* Parcours de la ligne de données de l'éventuel ResulSet retourné */
            if (resultSet.next()) {
                orderStatus = map(resultSet);
            }
        } catch (SQLException e) {
            throw new DAOException(e);
        } finally {
            close(resultSet, preparedStatement, connexion);
        }

        return orderStatus;
    }

    @Override
    public StatutCommande findByLibelle(String libelle) {
        SqlDAOFactory factory = getFactory();
        Connection connexion = null;
        PreparedStatement pstmt = null;
        ResultSet rset = null;
        StatutCommande orderStatus = null;

        try {
            connexion = factory.getConnection();
            pstmt = getPreparedStatement(connexion, SQL_FIND_BY_LIBELLE, false, libelle);
            rset = pstmt.executeQuery();

            if (rset.next()) {
                orderStatus = map(rset);
            }

        } catch (SQLException e) {
            throw new DAOException(e);
        } finally {
            close(rset, pstmt, connexion);
        }

        return orderStatus;
    }




    @Override
        public StatutCommande findByCode(String code) {
        SqlDAOFactory factory = getFactory();
        Connection connexion = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        StatutCommande orderStatus = null;

        try {
            /* Récupération d'une connexion depuis la Factory */
            connexion = factory.getConnection();
            preparedStatement = getPreparedStatement(connexion, SQL_FIND_BY_CODE, false, code);
            resultSet = preparedStatement.executeQuery();
            /* Parcours de la ligne de données de l'éventuel ResulSet retourné */
            if (resultSet.next()) {
                orderStatus = map(resultSet);
            }
        } catch (SQLException e) {
            throw new DAOException(e);
        } finally {
            close(resultSet, preparedStatement, connexion);
        }

        return orderStatus;
    }
    
}
