package fr.afpa.librairie.data.dao;

import fr.afpa.librairie.data.DAOFactory;
import fr.afpa.librairie.data.bean.StatutUtilisateur;
import fr.afpa.librairie.data.exception.DAOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

// DAO = Data Access Object
// DTO = Data Transfert Object

public class StatutUtilisateurDAO extends AbstractDAO<StatutUtilisateur> {

    private static final String SQL_INSERT = "INSERT INTO StatutUtilisateur (libelle, code) VALUES (?, ?)";
    private static final String SQL_DELETE = "DELETE FROM StatutUtilisateur WHERE id = ?";
    
    private static final String SQL_FIND_BY_ID = "SELECT idStatutUtilisateur, libelle, code FROM StatutUtilisateur WHERE idStatutUtilisateur = ?";
    private static final String SQL_FIND_BY_CODE = "SELECT idStatutUtilisateur, libelle, code FROM StatutUtilisateur WHERE code = ?";
    private static final String SQL_FIND_BY_LIBELLE = "SELECT idStatutUtilisateur, libelle, code FROM StatutUtilisateur WHERE libelle = ?";

    public StatutUtilisateurDAO(DAOFactory factory) {
        super(factory);
    }

    @Override
    public void save(StatutUtilisateur instance) throws DAOException {
        Connection connexion = null;
        PreparedStatement preparedStatement = null;
        ResultSet valeursAutoGenerees = null;

        try {
            /* Récupération d'une connexion depuis la Factory */
            connexion = getFactory().getConnection();
            
            preparedStatement = getPreparedStatement(
                    connexion, SQL_INSERT, true, 
                    instance.getLibelle(), instance.getCode());
            
            int statut = preparedStatement.executeUpdate();
            /* Analyse du statut retourné par la requête d'insertion */
            if (statut == 0) {
                throw new DAOException("Échec de la création de l'utilisateur, aucune ligne ajoutée dans la table.");
            }
            /* Récupération de l'id auto-généré par la requête d'insertion */
            valeursAutoGenerees = preparedStatement.getGeneratedKeys();
            if (valeursAutoGenerees.next()) {
                /* Puis initialisation de la propriété id du bean Utilisateur avec sa valeur */
                instance.setId(valeursAutoGenerees.getLong(1));
            } else {
                throw new DAOException("Échec de la création de l'utilisateur en base, aucun ID auto-généré retourné.");
            }
        } catch (SQLException e) {
            throw new DAOException(e);
        } finally {
            close(valeursAutoGenerees, preparedStatement, connexion);
        }
    }

    @Override
    public void delete(StatutUtilisateur instance) {
        Connection connexion = null;
        PreparedStatement preparedStatement = null;
        ResultSet valeursAutoGenerees = null;

        try {
            /* Récupération d'une connexion depuis la Factory */
            connexion = getFactory().getConnection();
            preparedStatement = getPreparedStatement(connexion, SQL_DELETE, true, instance.getId());
            int statut = preparedStatement.executeUpdate();
            /* Analyse du statut retourné par la requête d'insertion */
            if (statut == 0) {
                throw new DAOException("Échec de la suppression de l'utilisateur, aucune ligne supprimée dans la table.");
            }
        } catch (SQLException e) {
            throw new DAOException(e);
        } finally {
            close(valeursAutoGenerees, preparedStatement, connexion);
        }

    }

    @Override
    public StatutUtilisateur findByExemple(StatutUtilisateur instance) throws DAOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public StatutUtilisateur findById(Long id) throws DAOException {
        Connection connexion = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        StatutUtilisateur statut = null;
        
        try {
            /* Récupération d'une connexion depuis la Factory */
            connexion = getFactory().getConnection();
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

    public StatutUtilisateur findByCode(String code) throws DAOException {
        Connection connexion = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        StatutUtilisateur statut = null;

        try {
            /* Récupération d'une connexion depuis la Factory */
            connexion = getFactory().getConnection();
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

    /*
     * Simple méthode utilitaire permettant de faire la correspondance (le
     * mapping) entre une ligne issue de la table des utilisateurs (un
     * ResultSet) et un bean Utilisateur.
     */
    @Override
    protected StatutUtilisateur map(ResultSet resultSet) throws SQLException {
        StatutUtilisateur statut = new StatutUtilisateur();
        
        statut.setId(resultSet.getLong("idStatutUtilisateur"));
        statut.setLibelle(resultSet.getString("libelle"));
        statut.setCode(resultSet.getString("code"));
               
        return statut;
    }

}
