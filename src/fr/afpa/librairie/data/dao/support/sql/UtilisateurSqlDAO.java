package fr.afpa.librairie.data.dao.support.sql;

import fr.afpa.librairie.data.AbstractDAOFactory;
import fr.afpa.librairie.data.bean.Utilisateur;
import fr.afpa.librairie.data.bean.Role;
import fr.afpa.librairie.data.bean.StatutUtilisateur;
import fr.afpa.librairie.data.dao.StatutUtilisateurDAO;
import fr.afpa.librairie.data.dao.UtilisateurDAO;
import fr.afpa.librairie.data.exception.DAOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

// DAO = Data Access Object
// DTO = Data Transfert Object

  public class UtilisateurSqlDAO extends AbstractSqlDAO<Utilisateur> implements UtilisateurDAO {

    private static final String SQL_INSERT = "INSERT INTO Utilisateur"
            + " (nom, prenom, mail, telephone, mot_de_passe, date_naissance, idStatutUtilisateur)"
            + " VALUES (?, ?, ?, ?, ?, ?, ?)";
    
//    private static final String SQL_DELETE = "DELETE FROM Utilisateur WHERE idUtilisateur = ?";
    private static final String SQL_DELETE = "UPDATE Utilisateur"
            + " SET idStatutUtilisateur = ?"
            + " WHERE idUtilisateur = ?";
    
    private static final String SQL_ACTIVATE = "UPDATE Utilisateur"
            + " SET idStatutUtilisateur = ?"
            + " WHERE idUtilisateur = ?";
    
    private static final String SQL_UPDATE = "UPDATE Utilisateur"
            + " SET nom = ?,"
            + " prenom = ?,"
            + " mail = ?,"
            + " telephone = ?,"
            + " date_naissance = ?,"
            + " mot_de_passe = ?,"
            + " idStatutUtilisateur = ?"
            + " WHERE idUtilisateur = ?";
    
    private static final String SQL_FIND_ALL = "SELECT"
            + " idUtilisateur, nom, prenom, mail, telephone, mot_de_passe, date_naissance, idStatutUtilisateur"
            + " FROM Utilisateur ";
    
    private static final String SQL_FIND_BY_EMAIL = "SELECT"
            + " idUtilisateur, nom, prenom, mail, telephone, mot_de_passe, date_naissance, idStatutUtilisateur"
            + " FROM Utilisateur"
            + " WHERE mail = ?";
    
    private static final String SQL_FIND_BY_ID = "SELECT"
            + " idUtilisateur, nom, prenom, mail, telephone, mot_de_passe, date_naissance, idStatutUtilisateur"
            + " FROM Utilisateur"
            + " WHERE idUtilisateur = ?";

    public UtilisateurSqlDAO(AbstractDAOFactory factory) {
        super(factory);
    }
    
    @Override
    public void update(Utilisateur instance){
        SqlDAOFactory factory = getFactory();
        Connection connexion = null;
        PreparedStatement preparedStatement = null;
        ResultSet valeursAutoGenerees = null;
        
        try {

            connexion = factory.getConnection();
            
            preparedStatement = getPreparedStatement(connexion, SQL_UPDATE, true, 
                instance.getNom(), instance.getPrenom(), 
                instance.getEmail(), instance.getTelephone(),
                instance.getDateNaissance(), instance.getMotDePasse(),
                instance.getStatut().getId(), instance.getId());
            
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
    
    @Override
    public void create(Utilisateur instance){
        SqlDAOFactory factory = getFactory();
        Connection connexion = null;
        PreparedStatement preparedStatement = null;
        ResultSet valeursAutoGenerees = null;
        
        try {
            
            if(instance.getStatut() == null) {
                // on recupère le statut par default
                // le code devrait etre une constante.
                StatutUtilisateur statut = getFactory().getStatutUtilisateurDAO().findByCode("OK");
                instance.setStatut(statut);
            }
            
            // le statut est forcement different de null.
            if(instance.getStatut().getId() == null) {
                StatutUtilisateur statut = getFactory().getStatutUtilisateurDAO().findByCode(instance.getStatut().getCode());
                instance.setStatut(statut);
            }
            
            
            if(instance.getRoles() == null) {
                // on recupère le Role par default
                // le code devrait etre une constante.
                Role role = getFactory().getRoleDAO().findByCode("CLI");
                instance.addRole(role);
            }
            
            // On verifie que tout les roles sont enregistré
            instance.getRoles().forEach((Role role) -> {
                if(role != null && role.getId() == null) {
                    role = getFactory().getRoleDAO().findByCode(role.getCode());
                }
            });

            
//            comment cause : adresse changé en dernierslivraisons et derniersfacturations.
            
//            if(instance.getAdresses() == null){
//                Adresse adresse = getFactory().getAdresseDAO().findByVille("CLI");
//                instance.addAdresse(adresse);
//            }       
//            
//            instance.getAdresses().forEach((Adresse adresse) -> {
//                if(adresse != null && adresse.getCp() == null) {
//                    adresse = getFactory().getAdresseDAO().findByCp(adresse.getCp());
//                }
//            });
            
            connexion = factory.getConnection();
            
            preparedStatement = getPreparedStatement(connexion, SQL_INSERT, true, 
                    instance.getNom(), instance.getPrenom(), 
                    instance.getEmail(), instance.getTelephone(),
                    instance.getMotDePasse(), instance.getDateNaissance(), 
                    instance.getStatut().getId());
            
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
    public void save(Utilisateur instance) throws DAOException {
        
        if(instance.getId() != null) {
            update(instance);
        } else {
            create(instance);
        }
            
    }

    @Override
    public void delete(Utilisateur instance) {
        SqlDAOFactory factory = getFactory();
        Connection connexion = null;
        PreparedStatement preparedStatement = null;
        ResultSet valeursAutoGenerees = null;

        try {
            /* Récupération d'une connexion depuis la Factory */
            connexion = factory.getConnection();
            
            // on ne supprime pas reelement l'utlisateur, nous allons juste mettre son statut a desactivé.
            
            StatutUtilisateur statut = factory.getStatutUtilisateurDAO().findByCode(StatutUtilisateurDAO.CODE_DESACTIVE);
            
            preparedStatement = getPreparedStatement(connexion, SQL_DELETE, true, 
                    statut.getId(), instance.getId());
            
            /* Analyse du statut retourné par la requête d'insertion */
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
    public void activate(Utilisateur instance){
        SqlDAOFactory factory = getFactory();
        Connection connexion = null;
        PreparedStatement pstmt = null;
        ResultSet valeursAutoGenerees = null;
        
        try{
            connexion = factory.getConnection();
            
            StatutUtilisateur statut = factory.getStatutUtilisateurDAO().findByCode(StatutUtilisateurDAO.CODE_ACTIVE);
            pstmt = getPreparedStatement(connexion, SQL_ACTIVATE, true,
                    statut.getId(), instance.getId());
            
            if(pstmt.executeUpdate() == 0){
                throw new DAOException("Échec de l'activation de l'utilisateur, aucune ligne supprimée dans la table.");
            }
            
        }catch (SQLException e) {
            throw new DAOException(e);
        } finally {
            close(valeursAutoGenerees, pstmt, connexion);
        }
    }
    
    @Override
    public List<Utilisateur> findAll() throws DAOException {
        SqlDAOFactory factory = getFactory();
        Connection connexion = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<Utilisateur> utilisateurs = new ArrayList<>();

        try {
            connexion = factory.getConnection();
            preparedStatement = getPreparedStatement(connexion, SQL_FIND_ALL, false);
            resultSet = preparedStatement.executeQuery();
            
//            resultSet.beforeFirst();
            
            while (resultSet.next()) {
                utilisateurs.add(map(resultSet));
            }
        } catch (SQLException e) {
            throw new DAOException(e);
        } finally {
            close(resultSet, preparedStatement, connexion);
        }

        return utilisateurs;

    }

    @Override
    public Utilisateur findById(Long id) throws DAOException {
        SqlDAOFactory factory = getFactory();
        Connection connexion = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Utilisateur utilisateur = null;
        
        try {
            /* Récupération d'une connexion depuis la Factory */
            connexion = factory.getConnection();
            preparedStatement = getPreparedStatement(connexion, SQL_FIND_BY_ID, false, id);
            resultSet = preparedStatement.executeQuery();
            /* Parcours de la ligne de données de l'éventuel ResulSet retourné */
            if (resultSet.next()) {
                utilisateur = map(resultSet);
            }
        } catch (SQLException e) {
            throw new DAOException(e);
        } finally {
            close(resultSet, preparedStatement, connexion);
        }

        return utilisateur;
        
    }

    @Override
    public Utilisateur findByMail(String email) throws DAOException {
        SqlDAOFactory factory = getFactory();
        Connection connexion = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Utilisateur utilisateur = null;

        try {
            /* Récupération d'une connexion depuis la Factory */
            connexion = factory.getConnection();
            preparedStatement = getPreparedStatement(connexion, SQL_FIND_BY_EMAIL, false, email);
            resultSet = preparedStatement.executeQuery();
            /* Parcours de la ligne de données de l'éventuel ResulSet retourné */
            if (resultSet.next()) {
                utilisateur = map(resultSet);
            }
        } catch (SQLException e) {
            throw new DAOException(e);
        } finally {
            close(resultSet, preparedStatement, connexion);
        }

        return utilisateur;

    }

    /*
     * Simple méthode utilitaire permettant de faire la correspondance (le
     * mapping) entre une ligne issue de la table des utilisateurs (un
     * ResultSet) et un bean Utilisateur.
     */
    @Override
    protected Utilisateur map(ResultSet resultSet) throws SQLException {
        SqlDAOFactory factory = getFactory();
        Utilisateur utilisateur = new Utilisateur();
        
        utilisateur.setId(resultSet.getLong("idUtilisateur"));
        utilisateur.setNom(resultSet.getString("nom"));
        utilisateur.setPrenom(resultSet.getString("prenom"));
        utilisateur.setTelephone(resultSet.getString("telephone"));
        utilisateur.setEmail(resultSet.getString("mail"));
        utilisateur.setMotDePasse(resultSet.getString("mot_de_passe"));
        utilisateur.setDateNaissance(resultSet.getDate("date_naissance"));
        
        StatutUtilisateur statut = factory.getStatutUtilisateurDAO().findById(resultSet.getLong("idStatutUtilisateur"));
        List<Role> roles = factory.getRoleDAO().findByUtilisateur(utilisateur.getId());

//        List<Adresse> dernieresFacturations = factory.getAdresseDAO().findByUtilisateur(utilisateur.getId());
//        List<Adresse> dernieresLivraisons = factory.getAdresseDAO().findByUtilisateur(utilisateur.getId());
        
        
        utilisateur.setStatut(statut);
        utilisateur.setRoles(roles);
        
        return utilisateur;
    }

    @Override
    public List<Utilisateur> findByNom(String nom) {
        
        
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Utilisateur findByCommande(Long idCommande) throws DAOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }



}
