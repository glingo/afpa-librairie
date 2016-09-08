
package fr.afpa.librairie.data.dao.support.sql;

import fr.afpa.librairie.data.DAOFactoryInterface;
import fr.afpa.librairie.data.bean.Editeur;
import fr.afpa.librairie.data.dao.EditeurDAO;
import fr.afpa.librairie.data.exception.DAOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EditeurSqlDAO extends AbstractSqlDAO<Editeur> implements EditeurDAO {
    
    
    private static final String SQL_INSERT = "INSERT INTO Editeur (libelle) VALUES (?)";
    private static final String SQL_DELETE = "DELETE FROM Editeur WHERE idEditeur = ?";
    private static final String SQL_FIND_ALL = "SELECT idEditeur, libelle FROM Editeur";
    private static final String SQL_FIND_BY_LIBELLE = "SELECT idEditeur, libelle FROM Editeur WHERE libelle = ?";
            
    
    public EditeurSqlDAO(DAOFactoryInterface factory) {
        super(factory);
    }
    
    
    @Override
    public void save(Editeur instance) throws DAOException{
        SqlDAOFactory factory = getFactory();
        Connection connexion = null;
        PreparedStatement pstmt = null;
        ResultSet valeursAutoGenerees = null;

        try {

            connexion = factory.getConnection();

            pstmt = getPreparedStatement(connexion, SQL_INSERT, true,
                    instance.getLibelle());

            int statut = pstmt.executeUpdate();
            /* Analyse du statut retourné par la requête d'insertion */
            if (statut == 0) {
                throw new DAOException("Échec de la création de l'éditeur, aucune ligne ajoutée dans la table.");
            }

            valeursAutoGenerees = pstmt.getGeneratedKeys();
            if (valeursAutoGenerees.next()) {
                instance.setId(valeursAutoGenerees.getLong(1));
            } else {
                throw new DAOException("Échec de la création de l'éditeur en base, aucun ID auto-généré retourné.");
            }
        } catch (SQLException e) {
            throw new DAOException(e);
        } finally {
            close(valeursAutoGenerees, pstmt, connexion);
        }
        
    }
    
    @Override
    public void delete(Editeur instance) throws DAOException {
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
                throw new DAOException("Échec de la suppression de l'éditeur, aucune ligne supprimée dans la table.");
            }
        } catch (SQLException e) {
            throw new DAOException(e);
        } finally {
            close(valeursAutoGenerees, pstmt, connexion);
        }
    }
   
    @Override
    protected Editeur map(ResultSet rset) throws SQLException {
        Editeur editeur = new Editeur();
        
        editeur.setId(rset.getLong("idEditeur"));
        editeur.setLibelle(rset.getString("Libelle"));
        
        return editeur;
    }

    @Override
    public List<Editeur> findAll() throws DAOException {
        SqlDAOFactory factory = getFactory();
        Connection connexion = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<Editeur> editeurs = new ArrayList<>();

        try {
            connexion = factory.getConnection();
            preparedStatement = getPreparedStatement(connexion, SQL_FIND_ALL, false);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                editeurs.add(map(resultSet));
            }
        } catch (SQLException e) {
            throw new DAOException(e);
        } finally {
            close(resultSet, preparedStatement, connexion);
        }

        return editeurs;

    }


    @Override
    public Editeur findByExemple(Editeur instance) throws DAOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Editeur findById(Long id) throws DAOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Editeur findByLibelle(String libelle) {
        SqlDAOFactory factory = getFactory();
        Connection connexion = null;
        PreparedStatement pstmt = null;
        ResultSet rset = null;
        Editeur editeur = null;
        
        try{
            connexion = factory.getConnection();
            pstmt = getPreparedStatement(connexion, SQL_FIND_BY_LIBELLE, false, libelle);
            rset = pstmt.executeQuery();
            
            if (rset.next()){
                editeur = map(rset);
            }
            
        }catch (SQLException e){
            throw new DAOException(e);
        } finally {
            close(rset, pstmt, connexion);
        }
        
        return editeur;
    }
    
}
