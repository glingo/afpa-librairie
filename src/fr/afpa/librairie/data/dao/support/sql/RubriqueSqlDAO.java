package fr.afpa.librairie.data.dao.support.sql;

import fr.afpa.librairie.data.DAOFactoryInterface;
import fr.afpa.librairie.data.bean.Rubrique;
import fr.afpa.librairie.data.dao.RubriqueDAO;
import fr.afpa.librairie.data.exception.DAOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class RubriqueSqlDAO extends AbstractSqlDAO<Rubrique> implements RubriqueDAO {

    private static final String SQL_INSERT = "INSERT INTO Rubrique"
            + " (libelle, )"
            + " VALUES (?, ?, ?, ?)";
    private static final String SQL_DELETE = "DELETE FROM Auteur WHERE idAuteur = ?";
    private static final String SQL_FIND_ALL = "SELECT idAuteur, nom, prenom, date_naissance, date_deces FROM Auteur ";
    private static final String SQL_FIND_BY_DATENAISSANCE = "SELECT idAuteur, nom, prenom, date_naissance, date_deces FROM Auteur WHERE date_naissance = ?";
    private static final String SQL_FIND_BY_DATEDECES = "SELECT idAuteur, nom, prenom, date_naissance, date_deces FROM Auteur WHERE date_deces = ?";
    private static final String SQL_FIND_BY_ID = "SELECT idAuteur, nom, prenom, date_naissance, date_deces FROM Auteur WHERE idAuteur = ?";
    private static final String SQL_FIND_BY_NAME = "SELECT idAuteur, nom, prenom, date_naissance, date_deces FROM Auteur WHERE nom = ? ";

    public RubriqueSqlDAO(DAOFactoryInterface factory) {
        super(factory);
    }

    @Override
    protected Rubrique map(ResultSet result) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Rubrique> findAll() throws DAOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void save(Rubrique instance) throws DAOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(Rubrique instance) throws DAOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Rubrique findByExemple(Rubrique instance) throws DAOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Rubrique findById(Long id) throws DAOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Rubrique findByLibelle(String libelle) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
