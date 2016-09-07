
package fr.afpa.librairie.data.dao.support.sql;

import fr.afpa.librairie.data.DAOFactoryInterface;
import fr.afpa.librairie.data.bean.Commande;
import fr.afpa.librairie.data.dao.CommandeDAO;
import fr.afpa.librairie.data.exception.DAOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CommandeSqlDAO extends AbstractSqlDAO<Commande> implements CommandeDAO{
    
    
    private static final String SQL_INSERT = "INSERT INTO Commande (numero, dateCommande) VALUES = (?,?)";
    private static final String SQL_DELETE = "DELETE FROM Commande WHERE idCommande = ?";
    private static final String SQL_FIND_BY_ALL = "SELECT idCommande, numero, dateCommande FROM Commande";
    private static final String SQL_FIND_BY_NUMERO = "SELECT idCommande, numero, dateCommande FROM Commande WHERE numero = ?";
    private static final String SQL_FIND_BY_DATE =  "SELECT idCommande, numero, dateCommande FROM Commande WHERE dateCommande = ?";
    
    
    
     public CommandeSqlDAO(DAOFactoryInterface factory) {
        super(factory);
    }
     
     
    @Override
    public void save(Commande instance) throws DAOException {
        SqlDAOFactory factory = getFactory();
        Connection connexion = null;
        PreparedStatement preparedStatement = null;
        ResultSet valeursAutoGenerees = null;

        try {

            connexion = factory.getConnection();

            preparedStatement = getPreparedStatement(connexion, SQL_INSERT, true,
                    instance.getNumero(), instance.getDateCommande());

            int statut = preparedStatement.executeUpdate();
            /* Analyse du statut retourné par la requête d'insertion */
            if (statut == 0) {
                throw new DAOException("Échec de la création de la commande, aucune ligne ajoutée dans la table.");
            }

            valeursAutoGenerees = preparedStatement.getGeneratedKeys();
            if (valeursAutoGenerees.next()) {
                instance.setId(valeursAutoGenerees.getLong(1));
            } else {
                throw new DAOException("Échec de la création de la commande en base, aucun ID auto-généré retourné.");
            }
        } catch (SQLException e) {
            throw new DAOException(e);
        } finally {
            close(valeursAutoGenerees, preparedStatement, connexion);
        }
    }

    
    @Override
    public void delete(Commande instance) {
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
                throw new DAOException("Échec de la suppression de la commande, aucune ligne supprimée dans la table.");
            }
        } catch (SQLException e) {
            throw new DAOException(e);
        } finally {
            close(valeursAutoGenerees, preparedStatement, connexion);
        }

    }
    
    
    
    @Override
    protected Commande map(ResultSet resultSet) throws SQLException {
        
        Commande commande = new Commande(); 
        
        commande.setId(resultSet.getLong("idCommande"));
        commande.setNumero(resultSet.getString("Numéros"));
        commande.setDateCommande(resultSet.getDate("Date de commande"));
        
        return commande;
    }

    @Override
    public List<Commande> findAll() throws DAOException {
        SqlDAOFactory factory = getFactory();
        Connection connexion = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<Commande> commandes = new ArrayList<>();

        try {
            connexion = factory.getConnection();
            preparedStatement = getPreparedStatement(connexion, SQL_FIND_BY_ALL, false);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                commandes.add(map(resultSet));
            }
        } catch (SQLException e) {
            throw new DAOException(e);
        } finally {
            close(resultSet, preparedStatement, connexion);
        }

        return commandes;

    }
    
    @Override
    public Commande findByNumero(String numero) throws DAOException{
        SqlDAOFactory factory = getFactory();
        Connection connexion = null;
        PreparedStatement pstmt = null;
        ResultSet rset = null;
        Commande commande = null;
        
        try{
            connexion = factory.getConnection();
            pstmt = getPreparedStatement(connexion, SQL_FIND_BY_NUMERO, false, numero);
            rset = pstmt.executeQuery();
            
            if (rset.next()){
                commande = map(rset);
            }
            
        }catch (SQLException e){
            throw new DAOException(e);
        } finally {
            close(rset, pstmt, connexion);
        }
        
        return commande;
    }
    
    
    @Override
    public Commande findByDate(Date dateCommande) throws DAOException {
        SqlDAOFactory factory = getFactory();
        Connection connexion = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Commande commande = null;
        
        try {
            /* Récupération d'une connexion depuis la Factory */
            connexion = factory.getConnection();
            preparedStatement = getPreparedStatement(connexion, SQL_FIND_BY_DATE, false, dateCommande);
            resultSet = preparedStatement.executeQuery();
            /* Parcours de la ligne de données de l'éventuel ResulSet retourné */
            if (resultSet.next()) {
                commande = map(resultSet);
            }
        } catch (SQLException e) {
            throw new DAOException(e);
        } finally {
            close(resultSet, preparedStatement, connexion);
        }

        return commande;
        
    }

    @Override
    public Commande findByExemple(Commande instance) throws DAOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Commande findById(Long id) throws DAOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

   
}
