
package fr.afpa.librairie.data.dao.support.sql;

import fr.afpa.librairie.data.DAOFactoryInterface;
import fr.afpa.librairie.data.bean.Commande;
import fr.afpa.librairie.data.bean.StatutCommande;
import fr.afpa.librairie.data.bean.Utilisateur;
import fr.afpa.librairie.data.dao.CommandeDAO;
import fr.afpa.librairie.data.dao.StatutCommandeDAO;
import fr.afpa.librairie.data.exception.DAOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CommandeSqlDAO extends AbstractSqlDAO<Commande> implements CommandeDAO{
    
    private static final String SQL_INSERT = "INSERT INTO Commande"
            + " (numero, dateCommande)"
            + " VALUES = (?, ?)";
    
    private static final String SQL_DELETE = " UPDATE Commande" 
         + " SET idStatutCommande = ?"
         + " WHERE idUtilisateur = ?";
            
    
 private static final String SQL_FIND_ALL = "SELECT"
         + " c.idCommande, idUtilisateur, sc.idStatutCommande, numero, dateCommande"
         + " FROM Commande AS c"
         + " JOIN historiqueStatutCommande AS hsc ON c.idCommande = hsc.idCommande" 
         + " JOIN statutCommande AS sc ON hsc.idStatutCommande = sc.idStatutCommande";
    
    private static final String SQL_FIND_BY_ID = "SELECT"
            + " idCommande, numero, dateCommande"
            + " FROM Commande"
            + " WHERE idCommande = ?";
    
    private static final String SQL_FIND_BY_NUMERO = "SELECT"
            + " idCommande, numero, dateCommande"
            + " FROM Commande"
            + " WHERE numero = ?";
    
    private static final String SQL_FIND_BY_DATE =  "SELECT"
            + " idCommande, numero, dateCommande"
            + " FROM Commande"
            + " WHERE dateCommande = ?";
    
    private static final String SQL_FIND_BY_UTILISATEUR = "SELECT"
            + " idCommande, numero, dateCommande"
            + " FROM Commande"
            + " WHERE idUtilisateur = ?";
    
    
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
            
            if(instance.getOrderStat() == null) {
                StatutCommande orderStat = getFactory().getStatutCommandeDAO().findByCode("OK");
                instance.setOrderStat(orderStat);
            }

            if(instance.getOrderStat().getCode() == null) {
                StatutCommande orderStat = getFactory().getStatutCommandeDAO().findByCode(instance.getOrderStat().getCode());
                instance.setOrderStat(orderStat);
            }
            // l'utilisateur ne devrait jamais etre null arrivé a cet endroit.
//             if(instance.getUser() == null) {
//                // on recupère le statut par default
//                // le code devrait etre une constante.
//                Utilisateur user = getFactory().getUtilisateurDAO().findByNom("OK");
//                instance.setUser(user);
//            }
            
            // si l'utilisateur n'est pas encore enregistré.
            if(instance.getUser().getId() == null) {
                getFactory().getUtilisateurDAO().save(instance.getUser());
            }

            connexion = factory.getConnection();

            preparedStatement = getPreparedStatement(connexion, SQL_INSERT, true,
                    instance.getNumero(), instance.getDateCommande(),
                    instance.getUser() == null ? null : instance.getUser().getNom(),
                    instance.getOrderStat() == null ? null : instance.getOrderStat().getId());

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
            
            StatutCommande orderStat = factory.getStatutCommandeDAO().findByCode(StatutCommandeDAO.CODE_PAIEMENT_REFUSE);
            preparedStatement = getPreparedStatement(connexion, SQL_DELETE, true,
                    orderStat.getId(), instance.getId());

 
            if (preparedStatement.executeUpdate() == 0) {
                throw new DAOException("Échec de la desactivation de l'utilisateur, aucune ligne supprimée dans la table.");
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
        commande.setNumero(resultSet.getString("numero"));
        commande.setDateCommande(resultSet.getDate("dateCommande"));
        
                
        Utilisateur user = factory.getUtilisateurDAO().findById(resultSet.getLong("idUtilisateur"));
        commande.setUser(user);

        StatutCommande orderStat = factory.getStatutCommandeDAO().findById(resultSet.getLong("idStatutCommande"));
        commande.setOrderStat(orderStat);
        

        
//        List<Adresse> dernieresFacturations = factory.getAdresseDAO().findByUtilisateur(utilisateur.getId());
//        List<Adresse> dernieresLivraisons = factory.getAdresseDAO().findByUtilisateur(utilisateur.getId());
        
        
        
        return commande;
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
        
        SqlDAOFactory factory = getFactory();
        Connection connexion = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Commande commande = null;
        
        try {
            /* Récupération d'une connexion depuis la Factory */
            connexion = factory.getConnection();
            preparedStatement = getPreparedStatement(connexion, SQL_FIND_BY_ID,
                    false, id);
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
    public Commande findByUtilisateur(Long idUtilisateur) {
        SqlDAOFactory factory = getFactory();
        Connection connexion = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Commande commande = null;
        
        try {
            /* Récupération d'une connexion depuis la Factory */
            connexion = factory.getConnection();
            preparedStatement = getPreparedStatement(connexion, SQL_FIND_BY_UTILISATEUR, false, idUtilisateur);
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
    public List<Commande> findAll() throws DAOException {
        SqlDAOFactory factory = getFactory();
        Connection connexion = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<Commande> commandes = new ArrayList<>();

        try {
            connexion = factory.getConnection();
            preparedStatement = getPreparedStatement(connexion, SQL_FIND_ALL, false);
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
}
