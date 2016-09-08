
package fr.afpa.librairie.data.dao.support.sql;

import fr.afpa.librairie.data.DAOFactoryInterface;
import fr.afpa.librairie.data.bean.Commande;
import fr.afpa.librairie.data.bean.Promotion;
import fr.afpa.librairie.data.dao.CommandeDAO;
import fr.afpa.librairie.data.dao.PromotionDAO;
import fr.afpa.librairie.data.exception.DAOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PromotionSqlDAO extends AbstractSqlDAO<Promotion> implements PromotionDAO {
    
    private static final String SQL_INSERT = "INSERT INTO Promotion"
            + " (numero, dateCommande) VALUES"
            + " (?, ?)";
    
    private static final String SQL_DELETE = "DELETE FROM Promotion"
            + " WHERE idCommande = ?";
    
    private static final String SQL_FIND_BY_ALL = "SELECT"
            + " idPromotion, numero, dateCommande"
            + " FROM Commande";
    
    private static final String SQL_FIND_BY_NUMERO = "SELECT"
            + " idPromotion, numero, dateCommande"
            + " FROM Commande"
            + " WHERE numero = ?";
    
    private static final String SQL_FIND_BY_DATE =  "SELECT"
            + " idPromotion, numero, dateCommande"
            + " FROM Commande"
            + " WHERE dateCommande = ?";
    
    
    public PromotionSqlDAO(DAOFactoryInterface factory) {
        super(factory);
    }
     
     
    @Override
    public void save(Promotion instance) throws DAOException {
        SqlDAOFactory factory = getFactory();
        Connection connexion = null;
        PreparedStatement preparedStatement = null;
        ResultSet valeursAutoGenerees = null;

        try {

            connexion = factory.getConnection();

//            preparedStatement = getPreparedStatement(connexion, SQL_INSERT, true,
//                    instance.getNumero(), instance.getDateCommande());

//            int statut = preparedStatement.executeUpdate();
//            /* Analyse du statut retourné par la requête d'insertion */
//            if (statut == 0) {
//                throw new DAOException("Échec de la création de la commande, aucune ligne ajoutée dans la table.");
//            }

//            valeursAutoGenerees = preparedStatement.getGeneratedKeys();
//            if (valeursAutoGenerees.next()) {
//                instance.setId(valeursAutoGenerees.getLong(1));
//            } else {
//                throw new DAOException("Échec de la création de la commande en base, aucun ID auto-généré retourné.");
//            }
        } catch (SQLException e) {
            throw new DAOException(e);
        } finally {
            close(valeursAutoGenerees, preparedStatement, connexion);
        }
    }

    
    @Override
    public void delete(Promotion instance) {
        SqlDAOFactory factory = getFactory();
        Connection connexion = null;
        PreparedStatement preparedStatement = null;
        ResultSet valeursAutoGenerees = null;

//        try {
            /* Récupération d'une connexion depuis la Factory */
//            connexion = factory.getConnection();
//            preparedStatement = getPreparedStatement(connexion, SQL_DELETE, true, instance.getId());
//            int statut = preparedStatement.executeUpdate();
//            /* Analyse du statut retourné par la requête d'insertion */
//            if (statut == 0) {
//                throw new DAOException("Échec de la suppression de la commande, aucune ligne supprimée dans la table.");
//            }
//        } catch (SQLException e) {
//            throw new DAOException(e);
//        } finally {
//            close(valeursAutoGenerees, preparedStatement, connexion);
//        }

    }
    
    
    
    @Override
    protected Promotion map(ResultSet resultSet) throws SQLException {
        
        Promotion promo = new Promotion(); 
        
//        promo.setId(resultSet.getLong("idCommande"));
//        promo.setNumero(resultSet.getString("Numéros"));
//        promo.setDateCommande(resultSet.getDate("Date de commande"));
        
        return promo;
    }

    @Override
    public List<Promotion> findAll() throws DAOException {
        SqlDAOFactory factory = getFactory();
        Connection connexion = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<Promotion> promotions = new ArrayList<>();

//        try {
//            connexion = factory.getConnection();
//            preparedStatement = getPreparedStatement(connexion, SQL_FIND_BY_ALL, false);
//            resultSet = preparedStatement.executeQuery();
//
//            while (resultSet.next()) {
//                commandes.add(map(resultSet));
//            }
//        } catch (SQLException e) {
//            throw new DAOException(e);
//        } finally {
//            close(resultSet, preparedStatement, connexion);
//        }

        return promotions;

    }
    
    @Override
    public Promotion findByExemple(Promotion instance) throws DAOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Promotion findById(Long id) throws DAOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
