
package fr.afpa.librairie.data.dao.support.sql;

import fr.afpa.librairie.data.AbstractDAOFactory;
import fr.afpa.librairie.data.bean.Ouvrage;
import fr.afpa.librairie.data.dao.OuvrageDAO;
import fr.afpa.librairie.data.exception.DAOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class OuvrageSqlDAO extends AbstractSqlDAO<Ouvrage> implements OuvrageDAO {
    
    private static final String SQL_INSERT = "INSERT INTO Ouvrage"
            + " (titre, sousTitre, resume, auteur)"
            + " VALUES (?, ?, ?, ?)";
    private static final String SQL_DELETE = "DELETE FROM Utilisateur WHERE idUtilisateur = ?";
    private static final String SQL_FIND_ALL = "SELECT idUtilisateur, nom, prenom, mail, telephone, mot_de_passe, date_naissance, idStatutUtilisateur FROM Utilisateur ";
    private static final String SQL_FIND_BY_EMAIL = "SELECT idUtilisateur, nom, prenom, mail, telephone, mot_de_passe, date_naissance, idStatutUtilisateur FROM Utilisateur WHERE mail = ?";
    private static final String SQL_FIND_BY_ID = "SELECT idUtilisateur, nom, prenom, mail, telephone, mot_de_passe, date_naissance, idStatutUtilisateur FROM Utilisateur WHERE idUtilisateur = ?";

    public OuvrageSqlDAO(AbstractDAOFactory factory) {
        super(factory);
    }
    
    
    
    @Override
    protected Ouvrage map(ResultSet result) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Ouvrage> findAll() throws DAOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void save(Ouvrage instance) throws DAOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(Ouvrage instance) throws DAOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Ouvrage findByExemple(Ouvrage instance) throws DAOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Ouvrage findById(Long id) throws DAOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Ouvrage findByTitre(String titre) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Ouvrage findBySousTitre(String sousTitre) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
