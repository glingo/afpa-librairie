
package fr.afpa.librairie.data.dao.support.sql;

import fr.afpa.librairie.data.DAOFactoryInterface;
import fr.afpa.librairie.data.bean.Adresse;
import fr.afpa.librairie.data.bean.Pays;
import fr.afpa.librairie.data.bean.StatutAdresse;
import fr.afpa.librairie.data.dao.AdresseDAO;
import fr.afpa.librairie.data.exception.DAOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AdresseSqlDAO extends AbstractSqlDAO<Adresse> implements AdresseDAO {
    
    private static final String SQL_INSERT = "INSERT INTO Adresse"
            + " (numero, voie, codePostal, ville, complement, idStatutAdresse, idPays)"
            + " VALUES (?, ?, ?, ?, ?, ?, ?)";
    
    private static final String SQL_UPDATE = "UPDATE Adresse"
            + " SET numero = ?,"
            + " voie = ?,"
            + " codePostal = ?,"
            + " ville = ?,"
            + " complement = ?,"
            + " idStatutAdresse = ?,"
            + " idPays = ?"
            + " WHERE idAdresse = ?";
    
    private static final String SQL_DELETE = "DELETE FROM Adresse WHERE idAdresse = ?";
    
    private static final String SQL_FIND_ALL = "SELECT"
            + " idAdresse, numero, voie, codePostal, ville, complement, idStatutAdresse, idPays"
            + " FROM Adresse ";
    
    private static final String SQL_FIND_BY_CODEPOSTAL = "SELECT"
            + " idAdresse, numero, voie, codePostal, ville, complement, idStatutAdresse, idPays"
            + " FROM Adresse"
            + " WHERE codePostal = ?";
    
   
    private static final String SQL_FIND_BY_ID = "SELECT"
            + " idAdresse, numero, voie, codePostal, ville, complement, idStatutAdresse, idPays"
            + " FROM Adresse"
            + " WHERE idAdresse = ?";
   
    private static final String SQL_FIND_BY_VILLE = "SELECT"
            + " idAdresse, numero, voie, codePostal, ville, complement, idStatutAdresse, idPays"
            + " FROM Adresse"
            + " WHERE ville = ?";
 
    public AdresseSqlDAO(DAOFactoryInterface factory) {
        super(factory);
    }

    @Override
    public void create(Adresse instance) throws DAOException {
        SqlDAOFactory factory = getFactory();
        Connection connexion = null;
        PreparedStatement preparedStatement = null;
        ResultSet valeursAutoGenerees = null;

        try {
            
            // si l'adresse n'a pas de statut on l'initalise a active par defaut
            if(instance.getStatut() == null) {
                StatutAdresse statut = factory.getStatutAdresseDAO().findByCode(StatutAdresseSqlDAO.CODE_ACTIVE);
                instance.setStatut(statut);
            }

            connexion = factory.getConnection();
//numero, voie, codePostal, ville, complement, idStatutAdresse
            preparedStatement = getPreparedStatement(connexion, SQL_INSERT, true,
                    instance.getNumero(), 
                    instance.getVoie(),
                    instance.getCp(), 
                    instance.getVille(), 
                    instance.getComplement(),
                    instance.getStatut().getId(),
                    instance.getPays().getId());

            int statut = preparedStatement.executeUpdate();
            /* Analyse du statut retourné par la requête d'insertion */
            if (statut == 0) {
                throw new DAOException("Échec de la création de l'adresse, aucune ligne ajoutée dans la table.");
            }

            valeursAutoGenerees = preparedStatement.getGeneratedKeys();
            if (valeursAutoGenerees.next()) {
                instance.setId(valeursAutoGenerees.getLong(1));
            } else {
                throw new DAOException("Échec de la création de l'adresse en base, aucun ID auto-généré retourné.");
            }
        } catch (SQLException e) {
            throw new DAOException(e);
        } finally {
            close(valeursAutoGenerees, preparedStatement, connexion);
        }
    }

    @Override
    public void update(Adresse instance) throws DAOException {
        SqlDAOFactory factory = getFactory();
        Connection connexion = null;
        PreparedStatement preparedStatement = null;
        ResultSet valeursAutoGenerees = null;

        try {

            connexion = factory.getConnection();

            preparedStatement = getPreparedStatement(connexion, SQL_UPDATE, true,
                    instance.getNumero(), 
                    instance.getVoie(),
                    instance.getCp(), 
                    instance.getVille(), 
                    instance.getComplement(),
                    instance.getStatut().getId(),
                    instance.getPays().getId(),
                    instance.getId());

            int statut = preparedStatement.executeUpdate();
            /* Analyse du statut retourné par la requête d'insertion */
            if (statut == 0) {
                throw new DAOException("Échec de la création de l'adresse, aucune ligne ajoutée dans la table.");
            }
        } catch (SQLException e) {
            throw new DAOException(e);
        } finally {
            close(valeursAutoGenerees, preparedStatement, connexion);
        }
    }

    @Override
    public void save(Adresse instance) throws DAOException {
        if(instance.getId() != null) {
            update(instance);
        } else {
            create(instance);
        }
    }

    @Override
    public void delete(Adresse instance) {
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
                throw new DAOException("Échec de la suppression de l'adresse, aucune ligne supprimée dans la table.");
            }
        } catch (SQLException e) {
            throw new DAOException(e);
        } finally {
            close(valeursAutoGenerees, preparedStatement, connexion);
        }

    }

    @Override
    public List<Adresse> findAll() throws DAOException {
        SqlDAOFactory factory = getFactory();
        Connection connexion = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<Adresse> adresses = new ArrayList<>();

        try {
            connexion = factory.getConnection();
            preparedStatement = getPreparedStatement(connexion, SQL_FIND_ALL, false);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                adresses.add(map(resultSet));
            }
        } catch (SQLException e) {
            throw new DAOException(e);
        } finally {
            close(resultSet, preparedStatement, connexion);
        }

        return adresses;

    }

   

    @Override
    protected Adresse map(ResultSet resultSet) throws SQLException {
        SqlDAOFactory factory = getFactory();
        Adresse adresse = new Adresse();

        adresse.setId(resultSet.getLong("idAdresse"));
        adresse.setNumero(resultSet.getString("numero"));
        adresse.setVoie(resultSet.getString("voie"));
        adresse.setCp(resultSet.getString("codePostal"));
        adresse.setVille(resultSet.getString("ville"));
        adresse.setComplement(resultSet.getString("complement"));
        
        StatutAdresse statut = factory.getStatutAdresseDAO().findById(resultSet.getLong("idStatutAdresse"));
        adresse.setStatut(statut);
        
        Pays pays = factory.getPaysDAO().findById(resultSet.getLong("idPays"));
        adresse.setPays(pays);
        // ajouter le pays !

        return adresse;
    }

    @Override
    public Adresse findById(Long id) throws DAOException {
        SqlDAOFactory factory = getFactory();
        Connection connexion = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Adresse adresse = null;

        try {
            /* Récupération d'une connexion depuis la Factory */
            connexion = factory.getConnection();
            preparedStatement = getPreparedStatement(connexion, SQL_FIND_BY_ID, false, id);
            resultSet = preparedStatement.executeQuery();
            /* Parcours de la ligne de données de l'éventuel ResulSet retourné */
            if (resultSet.next()) {
                adresse = map(resultSet);
            }
        } catch (SQLException e) {
            throw new DAOException(e);
        } finally {
            close(resultSet, preparedStatement, connexion);
        }

        return adresse;

    }
    
    @Override
    public Adresse findByVille(String ville) throws DAOException {
        SqlDAOFactory factory = getFactory();
        Connection connexion = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Adresse adresse = null;

        try {
            /* Récupération d'une connexion depuis la Factory */
            connexion = factory.getConnection();
            preparedStatement = getPreparedStatement(connexion, SQL_FIND_BY_VILLE, false, ville);
            resultSet = preparedStatement.executeQuery();
            /* Parcours de la ligne de données de l'éventuel ResulSet retourné */
            if (resultSet.next()) {
                adresse = map(resultSet);
            }
        } catch (SQLException e) {
            throw new DAOException(e);
        } finally {
            close(resultSet, preparedStatement, connexion);
        }

        return adresse;

    }
    
    @Override
    public Adresse findByCp(String cp) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
