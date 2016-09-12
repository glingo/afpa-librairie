
package fr.afpa.librairie.data.dao.support.sql;

import fr.afpa.librairie.data.AbstractDAOFactory;
import fr.afpa.librairie.data.DAOFactoryInterface;
import fr.afpa.librairie.data.bean.Edition;
import fr.afpa.librairie.data.bean.Langue;
import fr.afpa.librairie.data.bean.Ouvrage;
import fr.afpa.librairie.data.bean.StatutEdition;
import fr.afpa.librairie.data.bean.Taxe;
import fr.afpa.librairie.data.dao.EditionDAO;
import fr.afpa.librairie.data.dao.StatutEditionDAO;
import fr.afpa.librairie.data.exception.DAOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EditionSqlDAO extends AbstractSqlDAO<Edition> implements EditionDAO{
    //requete SQL
    private static final String SQL_INSERT = "INSERT INTO Edition (isbn, idOuvrage, idLangue, idStatutEdition, datePubli, prixHt, couverture, titre, stock) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
    
    private static final String SQL_DELETE = "UPDATE Edition "
            + " SET idStatutEdition = ?"
            + " WHERE isbn = ?";

    
    private static final String SQL_FIND_ALL = "SELECT isbn, idOuvrage, idLangue, idStatutEdition, datePubli, prixHt, couverture, titre, stock FROM Edition";
    
    private static final String SQL_FIND_BY_ISBN = "SELECT isbn, idOuvrage, idLangue, idStatutEdition, datePubli, prixHt, couverture, titre, stock FROM Edition WHERE isbn = ?";
    
    private static final String SQL_FIND_BY_DATEPUBLI = "SELECT isbn, idOuvrage, idLangue, idStatutEdition, datePubli, prixHt, couverture, titre, stock FROM Edition WHERE datePubli = ?";
    
    private static final String SQL_FIND_BY_TITRE = "SELECT isbn, idOuvrage, idLangue, idStatutEdition, datePubli, prixHt, couverture, titre, stock FROM Edition WHERE titre = ?";
    
    private static final String SQL_FIND_BY_STOCK = "SELECT isbn, idOuvrage, idLangue, idStatutEdition, datePubli, prixHt, couverture, titre, stock FROM Edition WHERE stock = ?";
    
//    private static final String SQL_FIND_BY_PROMO = "SELECT"
//            + " ed.isbn, ed.datePubli, ed.prixHt, ed.couverture, ed.titre, ed.stock "
//            + " FROM Edition AS ed"
//            + " JOIN Beneficit AS b ON b.isbn = ed.isbn "
//            + " WHERE b.idPromo = ?";

    //constructeur
    public EditionSqlDAO(AbstractDAOFactory factory) {
        super(factory);
    }
    
    @Override
    //requete save : pour créer une nouvelle edition. 
    public void save(Edition instance)throws DAOException{
        
        SqlDAOFactory factory = getFactory();
        Connection connexion = null;
        PreparedStatement preparedStatement = null;
        ResultSet valeursAutoGenerees = null;
        
        //recuperation des informations saisis par l'utilisateur pour les stoque dans la DB
        //ATTENTION Edition demande une requete save simple. parfois on doit recuperer les infos contenus dans 
        //d'autres objets. Exemple : utilisateur : pour valider la création on a besoin des infos contenus dans les 
        //objets  des classes Role et StatutUtilisateur.
        
        try {
            
            
            if(instance.getStatut() == null) {
                StatutEdition statut = getFactory().getStatutEditionDAO().findByCode("OK");
                instance.setStatut(statut);
            }
            

            if(instance.getStatut().getCode() == null) {
                StatutEdition statut = getFactory().getStatutEditionDAO().findByCode(instance.getStatut().getCode());
                instance.setStatut(statut);
            }
            
            if(instance.getOuvrage() == null) {

                Ouvrage ouvrage = getFactory().getOuvrageDAO().findByTitre("OK");
                instance.setOuvrage(ouvrage);
            }
            
            if(instance.getOuvrage().getTitre() == null) {
                Ouvrage ouvrage = getFactory().getOuvrageDAO().findByTitre(instance.getOuvrage().getTitre());
                instance.setOuvrage(ouvrage);
            }
            
            if(instance.getLangue() == null) {

                Langue langue = getFactory().getLangueDAO().findByCode("OK");
                instance.setLangue(langue);
            }
            
            if(instance.getLangue().getLibelle() == null) {
                Langue langue = getFactory().getLangueDAO().findByCode(instance.getLangue().getCode());
                instance.setLangue(langue);
            }
            
//            if(instance.getTaxe().getValeur() == null){
//                Taxe taxe = getFactory().getTaxeDAO().findByLibelle("");
//                instance.setTaxe(taxe);
//                
//            }
//            
//            if(instance.getTaxe().getValeur() == null){
//                Taxe taxe = getFactory().getTaxeDAO().findByLibelle(instance.getTaxe().getLibelle());
//                instance.setTaxe(taxe);
//            }
            
            
            //recuperation de la connexion depuis la factory
            connexion = factory.getConnection();
            //requete prepare avec des conditions particulières.
            preparedStatement = getPreparedStatement(connexion, SQL_INSERT, true,
                    instance.getIsbn(), instance.getDatePublication(),
                    instance.getPrixHt(), instance.getCouverture(),
                    instance.getCouverture(), instance.getTitre(),
                    instance.getStock(),instance.getStatut() == null ? null : instance.getStatut().getId(),
                    instance.getOuvrage() == null ? null : instance.getOuvrage().getId(),
                    instance.getLangue() == null ? null : instance.getLangue().getId());

            int statut = preparedStatement.executeUpdate();
            /* Analyse du statut retourné par la requête d'insertion */
            //nbr de ligne 
            if (statut == 0) {
                throw new DAOException("Échec de la création de l'édition, aucune ligne ajoutée dans la table.");
            }

            valeursAutoGenerees = preparedStatement.getGeneratedKeys();
            if (valeursAutoGenerees.next()) {
                instance.setIsbn(valeursAutoGenerees.getString(1));
            } else {
                throw new DAOException("Échec de la création de l'édition en base, aucun ID auto-généré retourné.");
            }
        } catch (SQLException e) {
            throw new DAOException(e);
        } finally {
            close(valeursAutoGenerees, preparedStatement, connexion);
        }
        
    }
    
    @Override
    public void delete(Edition instance)throws DAOException{
        SqlDAOFactory factory = getFactory();
        Connection connexion = null;
        PreparedStatement pstmt = null;
        ResultSet valeursAutoGenerees = null;

        try {
           
            connexion = factory.getConnection();

            StatutEdition statut = factory.getStatutEditionDAO().findByCode(StatutEditionDAO.CODE_NON_DISPONIBLE);
            
            pstmt = getPreparedStatement(connexion, SQL_DELETE, true, 
                    statut.getId(), instance.getIsbn());
            
            /* Analyse du statut retourné par la requête d'insertion */
            if (pstmt.executeUpdate() == 0) {
                throw new DAOException("Échec de la mise à jour de l'édition, aucune ligne modifiée dans la table.");
            }
            
        } catch (SQLException e) {
            throw new DAOException(e);
        } finally {
            close(valeursAutoGenerees, pstmt, connexion);
        }
    }
    
    @Override
    public List<Edition> findAll() throws DAOException {

        SqlDAOFactory factory = getFactory();
        Connection connexion = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<Edition> editions = new ArrayList<>();

        try {
            connexion = factory.getConnection();
            preparedStatement = getPreparedStatement(connexion, SQL_FIND_ALL, false);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                //parcours l'arayList editions.
                editions.add(map(resultSet));
            }
        } catch (SQLException e) {
            throw new DAOException(e);
        } finally {
            close(resultSet, preparedStatement, connexion);
        }

        return editions;
    }
    
    
    @Override
    public Edition findByIsbn(String isbn) throws DAOException {
        SqlDAOFactory factory = getFactory();
        Connection connexion = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Edition edition = null;
        
        try {

            connexion = factory.getConnection();
            preparedStatement = getPreparedStatement(connexion, SQL_FIND_BY_ISBN, false, isbn);
            resultSet = preparedStatement.executeQuery();
            /* Parcours de la ligne de données de l'éventuel ResulSet retourné */
            if (resultSet.next()) {
                edition = map(resultSet);
            }
        } catch (SQLException e) {
            throw new DAOException(e);
        } finally {
            close(resultSet, preparedStatement, connexion);
        }

        return edition;
        
    }
    
    @Override
    public Edition findByDatePubli(Date datePubli) throws DAOException {
        SqlDAOFactory factory = getFactory();
        Connection connexion = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Edition edition = null;
        
        try {

            connexion = factory.getConnection();
            preparedStatement = getPreparedStatement(connexion, SQL_FIND_BY_DATEPUBLI, false, datePubli);
            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                edition = map(resultSet);
            }
        } catch (SQLException e) {
            throw new DAOException(e);
        } finally {
            close(resultSet, preparedStatement, connexion);
        }

        return edition;
    }
    
    @Override
    public Edition findByTitre(String titre) throws DAOException {
        SqlDAOFactory factory = getFactory();
        Connection connexion = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Edition edition = null;
        
        try {

            connexion = factory.getConnection();
            preparedStatement = getPreparedStatement(connexion, SQL_FIND_BY_TITRE, false, titre);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                edition = map(resultSet);
            }
        } catch (SQLException e) {
            throw new DAOException(e);
        } finally {
            close(resultSet, preparedStatement, connexion);
        }

        return edition;
    }
    
    @Override
    public Edition findByStock(int stock) throws DAOException {
        SqlDAOFactory factory = getFactory();
        Connection connexion = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Edition edition = null;
        
        try {
            /* Récupération d'une connexion depuis la Factory */
            connexion = factory.getConnection();
            preparedStatement = getPreparedStatement(connexion, SQL_FIND_BY_STOCK, false, stock);
            resultSet = preparedStatement.executeQuery();
            /* Parcours de la ligne de données de l'éventuel ResulSet retourné */
            if (resultSet.next()) {
                edition = map(resultSet);
            }
        } catch (SQLException e) {
            throw new DAOException(e);
        } finally {
            close(resultSet, preparedStatement, connexion);
        }

        return edition;
    }
    
    @Override
    protected Edition map(ResultSet resultSet) throws SQLException {
//        SqlDAOFactory factory = getFactory();
        Edition edition = new Edition();
        
        edition.setIsbn(resultSet.getString("isbn"));
        
        Ouvrage ouvrage = factory.getOuvrageDAO().findById(resultSet.getLong("idOuvrage"));
        edition.setOuvrage(ouvrage);
        
        Langue langue = factory.getLangueDAO().findById(resultSet.getLong("idLangue"));
        edition.setLangue(langue);
                
        StatutEdition statut = factory.getStatutEditionDAO().findById(resultSet.getLong("idStatutEdition"));
        edition.setStatut(statut);
        
        edition.setDatePublication(resultSet.getDate("datePubli"));
        
        edition.setPrixHt(resultSet.getFloat("prixHt"));
        
        edition.setCouverture(resultSet.getString("couverture"));
        
        edition.setTitre(resultSet.getString("titre"));
        
        edition.setStock(resultSet.getInt("stock"));
        
        List<Taxe> taxes = factory.getTaxeDao().findByEdition(edition.getIsbn());
        edition.setTaxes(taxes);
        
        

        return edition;
    }

    @Override
    public Edition findByExemple(Edition instance) throws DAOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Edition findById(Long id) throws DAOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

//    @Override
//    public List<Edition> findByPromo(Long idPromo) throws DAOException {
//        SqlDAOFactory factory = getFactory();
//        Connection connexion = null;
//        PreparedStatement pstmt = null;
//        ResultSet rset = null;
//        List<Edition> editions = new ArrayList<>();
//
//        try {
//            connexion = factory.getConnection();
//            pstmt = getPreparedStatement(connexion, SQL_FIND_BY_PROMO, false, idPromo);
//            rset = pstmt.executeQuery();
//            
//
//            
//            while (rset.next()) {
//                editions.add(map(rset));
//            }
//            
//            if (rset.next()) {
//                editions = new ArrayList<>();
//                editions.add(map(rset));
//            }
//        } catch (SQLException e) {
//            throw new DAOException(e);
//        } finally {
//            close(rset, pstmt, connexion);
//        }
//
//        return editions;
//    }
 
}
