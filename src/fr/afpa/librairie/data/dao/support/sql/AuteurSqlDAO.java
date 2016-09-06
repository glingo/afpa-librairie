package fr.afpa.librairie.data.dao.support.sql;
// DAO = Data Access Object
// DTO = Data Transfert Object

import fr.afpa.librairie.data.DAOFactoryInterface;
import fr.afpa.librairie.data.bean.Auteur;
import fr.afpa.librairie.data.dao.AuteurDAO;
import fr.afpa.librairie.data.exception.DAOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AuteurSqlDAO extends AbstractSqlDAO<Auteur> implements AuteurDAO {

    private static final String SQL_INSERT = "INSERT INTO Auteur"
            + " (nom, prenom, date_naissance, date_deces)"
            + " VALUES (?, ?, ?, ?)";
    private static final String SQL_DELETE = "DELETE FROM Auteur WHERE idAuteur = ?";
    private static final String SQL_FIND_ALL = "SELECT idAuteur, nom, date_naissance, date_deces FROM Auteur ";
    private static final String SQL_FIND_BY_DATENAISSANCE = "SELECT idAuteur, nom, prenom, date_naissance, date_deces FROM Auteur WHERE date_naissance = ?";
    private static final String SQL_FIND_BY_DATEDECES = "SELECT idAuteur, nom, prenom, date_naissance, date_deces FROM Auteur WHERE date_deces = ?";
    private static final String SQL_FIND_BY_ID = "SELECT idAuteur, nom, prenom, date_naissance, date_deces FROM Auteur WHERE idAuteur = ?";
    private static final String SQL_FIND_BY_NAME = "SELECT idAuteur, nom, prenom, date_naissance, date_deces FROM Auteur WHERE nom = ? ";
    public AuteurSqlDAO(DAOFactoryInterface factory) {
        super(factory);
    }

    @Override
    public void save(Auteur instance) throws DAOException {
        SqlDAOFactory factory = getFactory();
        Connection connexion = null;
        PreparedStatement preparedStatement = null;
        ResultSet valeursAutoGenerees = null;

        try {

            connexion = factory.getConnection();

            preparedStatement = getPreparedStatement(connexion, SQL_INSERT, true,
                    instance.getNom(), instance.getPrenom(),
                    instance.getDateNaissance(), instance.getDateDeces());

            int statut = preparedStatement.executeUpdate();
            /* Analyse du statut retourné par la requête d'insertion */
            if (statut == 0) {
                throw new DAOException("Échec de la création de l'utilisateur, aucune ligne ajoutée dans la table.");
            }

            valeursAutoGenerees = preparedStatement.getGeneratedKeys();
            if (valeursAutoGenerees.next()) {
                instance.setId(valeursAutoGenerees.getLong(1));
            } else {
                throw new DAOException("Échec de la création de l'auteur en base, aucun ID auto-généré retourné.");
            }
        } catch (SQLException e) {
            throw new DAOException(e);
        } finally {
            close(valeursAutoGenerees, preparedStatement, connexion);
        }
    }

    @Override
    public void delete(Auteur instance) {
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
                throw new DAOException("Échec de la suppression de l'auteur, aucune ligne supprimée dans la table.");
            }
        } catch (SQLException e) {
            throw new DAOException(e);
        } finally {
            close(valeursAutoGenerees, preparedStatement, connexion);
        }

    }

    @Override
    public List<Auteur> findAll() throws DAOException {
        SqlDAOFactory factory = getFactory();
        Connection connexion = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<Auteur> auteurs = new ArrayList<>();

        try {
            connexion = factory.getConnection();
            preparedStatement = getPreparedStatement(connexion, SQL_FIND_ALL, false);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                auteurs.add(map(resultSet));
            }
        } catch (SQLException e) {
            throw new DAOException(e);
        } finally {
            close(resultSet, preparedStatement, connexion);
        }

        return auteurs;

    }

    @Override
    public Auteur findByExemple(Auteur instance) throws DAOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public Auteur findByDateNaissance(Date dateNaissance) throws DAOException {
        SqlDAOFactory factory = getFactory();
        Connection connexion = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Auteur auteur = null;
        
        try {
            /* Récupération d'une connexion depuis la Factory */
            connexion = factory.getConnection();
            preparedStatement = getPreparedStatement(connexion, SQL_FIND_BY_DATENAISSANCE, false, dateNaissance);
            resultSet = preparedStatement.executeQuery();
            /* Parcours de la ligne de données de l'éventuel ResulSet retourné */
            if (resultSet.next()) {
                auteur = map(resultSet);
            }
        } catch (SQLException e) {
            throw new DAOException(e);
        } finally {
            close(resultSet, preparedStatement, connexion);
        }

        return auteur;
        
    }
    
    @Override
    public Auteur findByDateDeces(Date dateDeces) throws DAOException {
        SqlDAOFactory factory = getFactory();
        Connection connexion = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Auteur auteur = null;

        try {
            /* Récupération d'une connexion depuis la Factory */
            connexion = factory.getConnection();
            preparedStatement = getPreparedStatement(connexion, SQL_FIND_BY_DATEDECES, false, dateDeces);
            resultSet = preparedStatement.executeQuery();
            /* Parcours de la ligne de données de l'éventuel ResulSet retourné */
            if (resultSet.next()) {
                auteur = map(resultSet);
            }
        } catch (SQLException e) {
            throw new DAOException(e);
        } finally {
            close(resultSet, preparedStatement, connexion);
        }

        return auteur;

    }
    
    @Override
    public Auteur findByName(String nom) throws DAOException{
        SqlDAOFactory factory = getFactory();
        Connection connexion = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Auteur auteur = null;

        try {
            /* Récupération d'une connexion depuis la Factory */
            connexion = factory.getConnection();
            preparedStatement = getPreparedStatement(connexion, SQL_FIND_BY_NAME, false, nom);
            resultSet = preparedStatement.executeQuery();
            /* Parcours de la ligne de données de l'éventuel ResulSet retourné */
            if (resultSet.next()) {
                auteur = map(resultSet);
            }
        } catch (SQLException e) {
            throw new DAOException(e);
        } finally {
            close(resultSet, preparedStatement, connexion);
        }

        return auteur;
    }
     /*
     * Simple méthode utilitaire permettant de faire la correspondance (le
     * mapping) entre une ligne issue de la table des utilisateurs (un
     * ResultSet) et un bean Utilisateur.
     */
    
    @Override
    protected Auteur map(ResultSet resultSet) throws SQLException {
        SqlDAOFactory factory = getFactory();
        Auteur auteur = new Auteur();
        
        auteur.setId(resultSet.getLong("idAuteur"));
        auteur.setNom(resultSet.getString("nom"));
        auteur.setPrenom(resultSet.getString("prenom"));
        auteur.setDateNaissance(resultSet.getDate("date_naissance"));
        auteur.setDateDeces(resultSet.getDate("date_deces"));
       
        
        return auteur;
    }


    @Override
    public Auteur findById(Long id) throws DAOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


}