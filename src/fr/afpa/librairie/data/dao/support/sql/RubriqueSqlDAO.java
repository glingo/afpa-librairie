package fr.afpa.librairie.data.dao.support.sql;

import fr.afpa.librairie.data.DAOFactoryInterface;
import fr.afpa.librairie.data.bean.Rubrique;
import fr.afpa.librairie.data.dao.RubriqueDAO;
import fr.afpa.librairie.data.exception.DAOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RubriqueSqlDAO extends AbstractSqlDAO<Rubrique> implements RubriqueDAO {

    private static final String SQL_INSERT = "INSERT INTO Rubrique"
            + " (libelle, date_debut, date_fin, commentaire)"
            + " VALUES (?, ?, ?, ?)";
    
    private static final String SQL_UPDATE = "UPDATE Rubrique SET"
            + " libelle = ?,"
            + " date_debut = ?,"
            + " date_fin = ?,"
            + " commentaire = ?"
            + " WHERE idRubrique = ?";
    
    private static final String SQL_DELETE = "DELETE FROM Rubrique WHERE idRubrique = ?";
    
    private static final String SQL_FIND_ALL = "SELECT"
            + " idRubrique, libelle, date_debut, date_fin, commentaire"
            + " FROM Rubrique";
    
    private static final String SQL_FIND_BY_DATEDEBUT = "SELECT"
            + " idRubrique, libelle, date_debut, date_fin, commentaire"
            + " FROM Rubrique"
            + " WHERE date_debut = ?";
    
    private static final String SQL_FIND_BY_LIBELLE = "SELECT"
            + " idRubrique, libelle, date_debut, date_fin, commentaire"
            + " FROM Rubrique"
            + " WHERE libelle = ?";
    
    private static final String SQL_FIND_BY_ID = "SELECT"
            + " idRubrique, libelle, date_debut, date_fin, commentaire"
            + " FROM Rubrique"
            + " WHERE idRubrique = ?";
    
    private static final String SQL_FIND_BY_OUVRAGE = "SELECT"
            + " r.idRubrique, r.libelle, r.date_debut, r.date_fin, r.commentaire"
            + " FROM Rubrique AS r"
            + " JOIN MiseEnRubrique AS mer on r.idRubrique = mer.idRubrique"
            + " WHERE mer.idOuvrage = ?";
    
    
    
    public RubriqueSqlDAO(DAOFactoryInterface factory) {
        super(factory);
    }

    @Override
    protected Rubrique map(ResultSet resultSet) throws SQLException {

        Rubrique rubrique = new Rubrique();

        rubrique.setId(resultSet.getLong("idRubrique"));
        rubrique.setLibelle(resultSet.getString("libelle"));
        rubrique.setDateDebut(resultSet.getDate("date_debut"));
        rubrique.setDateFin(resultSet.getDate("date_fin"));
        rubrique.setCommentaire(resultSet.getString("commentaire"));

        return rubrique;
    }
    
    public void update(Rubrique instance){
        SqlDAOFactory factory = getFactory();
        Connection connexion = null;
        PreparedStatement preparedStatement = null;
        ResultSet valeursAutoGenerees = null;
        
        try {

            connexion = factory.getConnection();
            
            preparedStatement = getPreparedStatement(connexion, SQL_UPDATE, true,
                    instance.getLibelle(), instance.getDateDebut(),
                    instance.getDateFin(), instance.getCommentaire(),
                    instance.getId());
            
            int statut = preparedStatement.executeUpdate();
            
            /* Analyse du statut retourné par la requête d'insertion */
            if (statut == 0) {
                throw new DAOException("Échec de la création de la rubrique, aucune ligne ajoutée dans la table.");
            }
            
        } catch (SQLException e) {
            throw new DAOException(e);
        } finally {
            close(valeursAutoGenerees, preparedStatement, connexion);
        }
        
    }
    
    public void create(Rubrique instance){
        SqlDAOFactory factory = getFactory();
        Connection connexion = null;
        PreparedStatement preparedStatement = null;
        ResultSet valeursAutoGenerees = null;
        
        try {

            connexion = factory.getConnection();
            
            preparedStatement = getPreparedStatement(connexion, SQL_INSERT, true,
                    instance.getLibelle(), instance.getDateDebut(),
                    instance.getDateFin(), instance.getCommentaire());
            
            int statut = preparedStatement.executeUpdate();
            
            /* Analyse du statut retourné par la requête d'insertion */
            if (statut == 0) {
                throw new DAOException("Échec de la création de la rubrique, aucune ligne ajoutée dans la table.");
            }
            
            valeursAutoGenerees = preparedStatement.getGeneratedKeys();

            if (valeursAutoGenerees.next()) {
                instance.setId(valeursAutoGenerees.getLong(1));
            } else {
                throw new DAOException("Échec de la création de la rubrique en base, aucun ID auto-généré retourné.");
            }

        } catch (SQLException e) {
            throw new DAOException(e);
        } finally {
            close(valeursAutoGenerees, preparedStatement, connexion);
        }
        
    }

    @Override
    public void save(Rubrique instance) throws DAOException {
        if(instance.getId() != null) {
            update(instance);
        } else {
            create(instance);
        }
    }
    
    
    @Override
    public void delete(Rubrique instance){
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
                throw new DAOException("Échec de la suppression de la rubrique, aucune ligne supprimée dans la table.");
            }
        } catch (SQLException e) {
            throw new DAOException(e);
        } finally {
            close(valeursAutoGenerees, preparedStatement, connexion);
        }
        
    }
    
    
    @Override
    public List<Rubrique> findAll() throws DAOException {
        SqlDAOFactory factory = getFactory();
        Connection connexion = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<Rubrique> rubriques = new ArrayList<>();

        try {
            connexion = factory.getConnection();
            preparedStatement = getPreparedStatement(connexion, SQL_FIND_ALL, false);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                rubriques.add(map(resultSet));
            }
        } catch (SQLException e) {
            throw new DAOException(e);
        } finally {
            close(resultSet, preparedStatement, connexion);
        }

        return rubriques;

    }  
    
    
 
    @Override
    public Rubrique findByExemple(Rubrique instance) throws DAOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Rubrique findById(Long id) throws DAOException {
       SqlDAOFactory factory = getFactory();
       Connection connexion = null;
       PreparedStatement preparedStatement = null; 
       ResultSet resultSet = null; 
       Rubrique rubrique = null; 
       
       try{
          connexion = factory.getConnection();
          preparedStatement = getPreparedStatement(connexion, SQL_FIND_BY_ID, false, id);
          resultSet = preparedStatement.executeQuery();
            /* Parcours de la ligne de données de l'éventuel ResulSet retourné */
            if (resultSet.next()) {
                rubrique = map(resultSet);
            }
        } catch (SQLException e) {
            throw new DAOException(e);
        } finally {
            close(resultSet, preparedStatement, connexion);
        }

        return rubrique;
       
    }
    
    

    @Override
    public Rubrique findByLibelle(String libelle) {
        SqlDAOFactory factory = getFactory();
        Connection connexion = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Rubrique rubrique = null;
        
        try {
            /* Récupération d'une connexion depuis la Factory */
            connexion = factory.getConnection();
            preparedStatement = getPreparedStatement(connexion, SQL_FIND_BY_LIBELLE, false, libelle);
            resultSet = preparedStatement.executeQuery();
            /* Parcours de la ligne de données de l'éventuel ResulSet retourné */
            if (resultSet.next()) {
                rubrique = map(resultSet);
            }
        } catch (SQLException e) {
            throw new DAOException(e);
        } finally {
            close(resultSet, preparedStatement, connexion);
        }

        return rubrique; 
    
    }

    @Override
    public Rubrique findByDateDebut(Date dateDebut) throws DAOException {
        SqlDAOFactory factory = getFactory();
        Connection connexion = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Rubrique rubrique = null;
        
        try {
            /* Récupération d'une connexion depuis la Factory */
            connexion = factory.getConnection();
            preparedStatement = getPreparedStatement(connexion, SQL_FIND_BY_DATEDEBUT, false, dateDebut);
            resultSet = preparedStatement.executeQuery();
            /* Parcours de la ligne de données de l'éventuel ResulSet retourné */
            if (resultSet.next()) {
                rubrique = map(resultSet);
            }
        } catch (SQLException e) {
            throw new DAOException(e);
        } finally {
            close(resultSet, preparedStatement, connexion);
        }

        return rubrique;
        
    }

    @Override
    public List<Rubrique> findByOuvrage(Long idOuvrage) throws DAOException {
        SqlDAOFactory factory = getFactory();
        Connection connexion = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<Rubrique> rubriques = new ArrayList<>();

        try {
            connexion = factory.getConnection();
            preparedStatement = getPreparedStatement(connexion, SQL_FIND_BY_OUVRAGE, false, idOuvrage);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                rubriques.add(map(resultSet));
            }
        } catch (SQLException e) {
            throw new DAOException(e);
        } finally {
            close(resultSet, preparedStatement, connexion);
        }

        return rubriques;
    }
    

}
