/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.afpa.librairie.data.dao.support.sql;

import fr.afpa.librairie.data.AbstractDAOFactory;
import fr.afpa.librairie.data.bean.Taxe;
import fr.afpa.librairie.data.dao.TaxeDAO;
import fr.afpa.librairie.data.exception.DAOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Marÿn
 */
public class TaxeSqlDAO extends AbstractSqlDAO<Taxe> implements TaxeDAO{
    
    private static final String SQL_INSERT = "INSERT INTO Taxe"
            + " (libelle, valeur) VALUES"
            + " (?, ?)";
    
    private static final String SQL_UPDATE = "UPDATE Taxe"
            + " SET libelle = ?"
            + " valeur = ?"
            + " WHERE idTaxe = ?";
    
    private static final String SQL_DELETE = "DELETE FROM Taxe WHERE idTaxe = ?";
    
    private static final String SQL_FIND_ALL = "SELECT"
            + " idTaxe, libelle, valeur"
            + " FROM Taxe";
    
    private static final String SQL_FIND_BY_ID = "SELECT"
            + " idTaxe, libelle, valeur"
            + " FROM Taxe"
            + " WHERE idTaxe = ?";
    
    private static final String SQL_FIND_BY_LIBELLE = "SELECT"
            + " idTaxe, libelle, valeur "
            + "FROM Taxe "
            + "WHERE libelle = ?";
    
    private static final String SQL_FIND_BY_VALEUR = "SELECT"
            + " idTaxe, libelle, valeur"
            + " FROM Taxe"
            + " WHERE Taxe = ?";
    
    private static final String SQL_FIND_BY_EDITION = "SELECT"
            +" t.idTaxe, t.libelle, t.valeur"
            +" FROM Taxe AS t"
            +" JOIN ApplicationTaxe AS at ON at.idTaxe = t.idTaxe"
            +" WHERE at.idEdition = ?";
    
    
    public TaxeSqlDAO(AbstractDAOFactory factory) {
        super(factory);
    }
    
    @Override
    protected Taxe map(ResultSet resultSet) throws SQLException {
        SqlDAOFactory factory = getFactory();
        Taxe taxe = new Taxe();

        taxe.setId(resultSet.getLong("idTaxe"));
        taxe.setLibelle(resultSet.getString("libelle"));
        taxe.setValeur(resultSet.getFloat("valeur"));

        return taxe;
    }
    
    

    @Override
    public void create(Taxe instance) throws DAOException {
        SqlDAOFactory factory = getFactory();
        Connection connexion = null;
        PreparedStatement preparedStatement = null;
        ResultSet valeursAutoGenerees = null;

        try {

            connexion = factory.getConnection();

            preparedStatement = getPreparedStatement(connexion, SQL_INSERT, true,
                    instance.getLibelle(), instance.getValeur());

            int statut = preparedStatement.executeUpdate();

            if (statut == 0) {
                throw new DAOException("Échec de la création de la taxe, aucune ligne ajoutée dans la table.");
            }

            valeursAutoGenerees = preparedStatement.getGeneratedKeys();
            if (valeursAutoGenerees.next()) {
                instance.setId(valeursAutoGenerees.getLong(1));
            } else {
                throw new DAOException("Échec de la création dde la taxe en base, aucun ID auto-généré retourné.");
            }
        } catch (SQLException e) {
            throw new DAOException(e);
        } finally {
            close(valeursAutoGenerees, preparedStatement, connexion);
        }
    }

    @Override
    public void update(Taxe instance) throws DAOException {
        SqlDAOFactory factory = getFactory();
        Connection connexion = null;
        PreparedStatement preparedStatement = null;
        ResultSet valeursAutoGenerees = null;

        try {

            connexion = factory.getConnection();

            preparedStatement = getPreparedStatement(connexion, SQL_UPDATE, true,
                    instance.getLibelle(), instance.getValeur(), instance.getId());

            int statut = preparedStatement.executeUpdate();

            if (statut == 0) {
                throw new DAOException("Échec de la création de la taxe, aucune ligne ajoutée dans la table.");
            }

        } catch (SQLException e) {
            throw new DAOException(e);
        } finally {
            close(valeursAutoGenerees, preparedStatement, connexion);
        } 
    }

    @Override
    public void save(Taxe instance) throws DAOException {
        
    }

    @Override
    public void delete(Taxe instance) throws DAOException {
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
                throw new DAOException("Échec de la suppression de la taxe, aucune ligne supprimée dans la table.");
            }
        } catch (SQLException e) {
            throw new DAOException(e);
        } finally {
            close(valeursAutoGenerees, preparedStatement, connexion);
        }

    }
    
    @Override
    public List<Taxe> findAll() throws DAOException {
       SqlDAOFactory factory = getFactory();
        Connection connexion = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<Taxe> taxes = new ArrayList<>();

        try {
            connexion = factory.getConnection();
            preparedStatement = getPreparedStatement(connexion, SQL_FIND_ALL, false);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                taxes.add(map(resultSet));
            }
        } catch (SQLException e) {
            throw new DAOException(e);
        } finally {
            close(resultSet, preparedStatement, connexion);
        }

        return taxes;
    }

    @Override
    public Taxe findById(Long id) throws DAOException {
        SqlDAOFactory factory = getFactory();
        Connection connexion = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Taxe taxe = null;

        try {

            connexion = factory.getConnection();
            preparedStatement = getPreparedStatement(connexion, SQL_FIND_BY_ID, 
                    false, id);
            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                taxe = map(resultSet);
            }
        } catch (SQLException e) {
            throw new DAOException(e);
        } finally {
            close(resultSet, preparedStatement, connexion);
        }

        return taxe;
    }

    @Override
    public Taxe findByLibelle(String libelle) {
        SqlDAOFactory factory = getFactory();
        Connection connexion = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Taxe taxe = null;

        try {

            connexion = factory.getConnection();
            preparedStatement = getPreparedStatement(connexion, SQL_FIND_BY_LIBELLE, false, libelle);
            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                taxe = map(resultSet);
            }
        } catch (SQLException e) {
            throw new DAOException(e);
        } finally {
            close(resultSet, preparedStatement, connexion);
        }

        return taxe;
    }

    @Override
    public Taxe findByValeur(Float valeur) {
        SqlDAOFactory factory = getFactory();
        Connection connexion = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Taxe taxe = null;

        try {
            /* Récupération d'une connexion depuis la Factory */
            connexion = factory.getConnection();
            preparedStatement = getPreparedStatement(connexion, SQL_FIND_BY_VALEUR, false, valeur);
            resultSet = preparedStatement.executeQuery();
            /* Parcours de la ligne de données de l'éventuel ResulSet retourné */
            if (resultSet.next()) {
                taxe = map(resultSet);
            }
        } catch (SQLException e) {
            throw new DAOException(e);
        } finally {
            close(resultSet, preparedStatement, connexion);
        }

        return taxe;
    }

    @Override
    public List<Taxe> findByEdition(Long id) throws DAOException {
        SqlDAOFactory factory = getFactory();
        Connection connexion = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<Taxe> taxes = new ArrayList<>();

        try {
            connexion = factory.getConnection();
            preparedStatement = getPreparedStatement(connexion, SQL_FIND_BY_EDITION, false,
                    id);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                taxes.add(map(resultSet));
            }

        } catch (SQLException e) {
            throw new DAOException(e);
        } finally {
            close(resultSet, preparedStatement, connexion);
        }

        return taxes;

    }


    
}
