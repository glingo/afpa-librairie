package fr.afpa.librairie.persistance.dao;

import fr.afpa.librairie.model.Utilisateur;
import fr.afpa.librairie.persistance.AbstractDAO;
import fr.afpa.librairie.persistance.DAOFactory;
import fr.afpa.librairie.persistance.exception.DAOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UtilisateurDAO extends AbstractDAO<Utilisateur> {

    private static final String SQL_INSERT = "INSERT INTO Utilisateur (email, mot_de_passe, nom, date_inscription) VALUES (?, ?, ?, GETDATE())";
    private static final String SQL_DELETE = "DELETE FROM Utilisateur WHERE id=?";
    private static final String SQL_SELECT_PAR_EMAIL = "SELECT id, email, nom, mot_de_passe, date_inscription FROM Utilisateur WHERE email = ?";

    public UtilisateurDAO(DAOFactory factory) {
        super(factory);
    }

    @Override
    public void creer(Utilisateur instance) throws DAOException {
        Connection connexion = null;
        PreparedStatement preparedStatement = null;
        ResultSet valeursAutoGenerees = null;

        try {
            /* Récupération d'une connexion depuis la Factory */
            connexion = getFactory().getConnection();
            preparedStatement = initialisationRequetePreparee(connexion, SQL_INSERT, true, instance.getEmail(), instance.getMotDePasse(), instance.getNom());
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
            fermeturesSilencieuses(valeursAutoGenerees, preparedStatement, connexion);
        }
    }

    @Override
    public void supprimer(Utilisateur instance) {
        Connection connexion = null;
        PreparedStatement preparedStatement = null;
        ResultSet valeursAutoGenerees = null;

        try {
            /* Récupération d'une connexion depuis la Factory */
            connexion = getFactory().getConnection();
            preparedStatement = initialisationRequetePreparee(connexion, SQL_DELETE, true, instance.getId());
            int statut = preparedStatement.executeUpdate();
//            /* Analyse du statut retourné par la requête d'insertion */
//            if (statut == 0) {
//                throw new DAOException("Échec de la création de l'utilisateur, aucune ligne ajoutée dans la table.");
//            }
//            /* Récupération de l'id auto-généré par la requête d'insertion */
//            valeursAutoGenerees = preparedStatement.getGeneratedKeys();
//            if (valeursAutoGenerees.next()) {
//                /* Puis initialisation de la propriété id du bean Utilisateur avec sa valeur */
//                instance.setId(valeursAutoGenerees.getLong(1));
//            } else {
//                throw new DAOException("Échec de la création de l'utilisateur en base, aucun ID auto-généré retourné.");
//            }
        } catch (SQLException e) {
            throw new DAOException(e);
        } finally {
            fermeturesSilencieuses(valeursAutoGenerees, preparedStatement, connexion);
        }

    }

    @Override
    public void trouver(Utilisateur instance) throws DAOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Utilisateur findByEmail(String email) throws DAOException {
        Connection connexion = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Utilisateur utilisateur = null;

        try {
            /* Récupération d'une connexion depuis la Factory */
            connexion = getFactory().getConnection();
            preparedStatement = initialisationRequetePreparee(connexion, SQL_SELECT_PAR_EMAIL, false, email);
            resultSet = preparedStatement.executeQuery();
            /* Parcours de la ligne de données de l'éventuel ResulSet retourné */
            if (resultSet.next()) {
                utilisateur = map(resultSet);
            }
        } catch (SQLException e) {
            throw new DAOException(e);
        } finally {
            fermeturesSilencieuses(resultSet, preparedStatement, connexion);
        }

        return utilisateur;

    }

    /*
     * Simple méthode utilitaire permettant de faire la correspondance (le
     * mapping) entre une ligne issue de la table des utilisateurs (un
     * ResultSet) et un bean Utilisateur.
     */
    private static Utilisateur map(ResultSet resultSet) throws SQLException {
        Utilisateur utilisateur = new Utilisateur();
        utilisateur.setId(resultSet.getLong("id"));
        utilisateur.setEmail(resultSet.getString("email"));
        utilisateur.setMotDePasse(resultSet.getString("mot_de_passe"));
        utilisateur.setNom(resultSet.getString("nom"));
        utilisateur.setDateInscription(resultSet.getDate("date_inscription"));
        return utilisateur;
    }

}
