
package fr.afpa.librairie.data.dao.support.sql;

import fr.afpa.librairie.data.DAOFactoryInterface;
import fr.afpa.librairie.data.bean.Edition;
import fr.afpa.librairie.data.bean.Promotion;
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
            + " (dateDebut, dateFin, reduction, image, description, commentaire) VALUES"
            + " (?, ?, ?, ?, ?, ?)";
    
    private static final String SQL_UPDATE = "UPDATE Promotion"
            + " SET dateDebut = ?,"
            + " dateFin = ?,"
            + " reduction = ?,"
            + " image = ?,"
            + " description = ?,"
            + " commentaire = ?"
            + " WHERE idPromo = ?";
    
    private static final String SQL_DELETE = "DELETE FROM Promotion"
            + " WHERE idPromo = ?";
    
    private static final String SQL_FIND_ALL = "SELECT"
            + " idPromo, dateDebut, dateFin, reduction, image, description, commentaire"
            + " FROM Promotion";
    
    private static final String SQL_FIND_BY_ID = "SELECT"
            + " idPromo, dateDebut, dateFin, reduction, image, description, commentaire"
            + " FROM Promotion"
            + " WHERE idPromo = ?";
    
    public PromotionSqlDAO(DAOFactoryInterface factory) {
        super(factory);
    }

    @Override
    public void create(Promotion instance) throws DAOException {
        SqlDAOFactory factory = getFactory();
        Connection connexion = null; 
        PreparedStatement pstmt = null;
        ResultSet valeursAutoGenerees = null;

        try {
            
            /* Récupération d'une connexion depuis la Factory */
            connexion = factory.getConnection();
            
            pstmt = getPreparedStatement(connexion, SQL_INSERT, true, 
                    instance.getDateDebut(), instance.getDateFin(), 
                    instance.getReduction(), instance.getDescription(),
                    instance.getImage(), instance.getCommentaire());
            
            int statut = pstmt.executeUpdate();
            /* Analyse du statut retourné par la requête d'insertion */
            if (statut == 0) {
                throw new DAOException("Échec de la création de la promotion, aucune ligne ajoutée dans la table.");
            }
            /* Récupération de l'id auto-généré par la requête d'insertion */
            valeursAutoGenerees = pstmt.getGeneratedKeys();
            if (valeursAutoGenerees.next()) {
                /* Puis initialisation de la propriété id du bean Utilisateur avec sa valeur */
                instance.setId(valeursAutoGenerees.getLong(1));
            } else {
                throw new DAOException("Échec de la création de la promotion en base, aucun ID auto-généré retourné.");
            }
        } catch (SQLException e) {
            throw new DAOException(e);
        } finally {
            close(valeursAutoGenerees, pstmt, connexion);
        }
    }

    @Override
    public void update(Promotion instance) throws DAOException {
       SqlDAOFactory factory = getFactory();
        Connection connexion = null; 
        PreparedStatement pstmt = null;
        ResultSet valeursAutoGenerees = null;

        try {
            
            /* Récupération d'une connexion depuis la Factory */
            connexion = factory.getConnection();
            
            pstmt = getPreparedStatement(connexion, SQL_UPDATE, true, 
                    instance.getDateDebut(), instance.getDateFin(), 
                    instance.getReduction(), instance.getDescription(),
                    instance.getImage(), instance.getCommentaire(),
                    instance.getId());
            
            int statut = pstmt.executeUpdate();
            /* Analyse du statut retourné par la requête d'insertion */
            if (statut == 0) {
                throw new DAOException("Échec de la création de la promotion, aucune ligne ajoutée dans la table.");
            }
        } catch (SQLException e) {
            throw new DAOException(e);
        } finally {
            close(valeursAutoGenerees, pstmt, connexion);
        }
    }
    
    @Override
    public void save(Promotion instance) throws DAOException {
        if(instance.getId() != null) {
            update(instance);
        } else {
            create(instance);
        }
    }

    
    @Override
    public void delete(Promotion instance) {
        SqlDAOFactory factory = getFactory();
        Connection connexion = null;
        PreparedStatement pstmt = null;
        ResultSet valeursAutoGenerees = null;

        try {
            /* Récupération d'une connexion depuis la Factory */
            connexion = factory.getConnection();
            pstmt = getPreparedStatement(connexion, SQL_DELETE, true, instance.getId());
            int statut = pstmt.executeUpdate();
            /* Analyse du statut retourné par la requête d'insertion */
            if (statut == 0) {
                throw new DAOException("Échec de la suppression de la promotion, aucune ligne supprimée dans la table.");
            }
        } catch (SQLException e) {
            throw new DAOException(e);
        } finally {
            close(valeursAutoGenerees, pstmt, connexion);
        }
        

    }
    
    
    
    @Override
    protected Promotion map(ResultSet resultSet) throws SQLException {
        
        Promotion promo = new Promotion(); 
        
        promo.setId(resultSet.getLong("idPromo"));
        promo.setCommentaire(resultSet.getString("commentaire"));
        promo.setDateDebut(resultSet.getDate("dateDebut"));
        promo.setDateFin(resultSet.getDate("dateFin"));
        promo.setDescription(resultSet.getString("description"));
        promo.setImage(resultSet.getString("image"));
        promo.setReduction(resultSet.getFloat("reduction"));

        
        return promo;
    }

    @Override
    public List<Promotion> findAll() throws DAOException {
        SqlDAOFactory factory = getFactory();
        Connection connexion = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<Promotion> promotions = new ArrayList<>();

        try {
            connexion = factory.getConnection();
            preparedStatement = getPreparedStatement(connexion, SQL_FIND_ALL, false);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                promotions.add(map(resultSet));
            }
        } catch (SQLException e) {
            throw new DAOException(e);
        } finally {
            close(resultSet, preparedStatement, connexion);
        }

        return promotions;

    }
    
    @Override
    public Promotion findById(Long id) throws DAOException {
        SqlDAOFactory factory = getFactory();
        Connection connexion = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Promotion promotion = null;
        
        try {
            /* Récupération d'une connexion depuis la Factory */
            connexion = factory.getConnection();
            preparedStatement = getPreparedStatement(connexion, SQL_FIND_BY_ID, false, id);
            resultSet = preparedStatement.executeQuery();
            /* Parcours de la ligne de données de l'éventuel ResulSet retourné */
            if (resultSet.next()) {
                promotion = map(resultSet);
            }
        } catch (SQLException e) {
            throw new DAOException(e);
        } finally {
            close(resultSet, preparedStatement, connexion);
        }

        return promotion;
    }

    @Override
    public Promotion findByDateDebut(Date dateDebut) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Promotion findByReduction(Float reduction) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


}
