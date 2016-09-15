package fr.afpa.librairie.data.dao.support.list;

import fr.afpa.librairie.data.AbstractDAOFactory;
import fr.afpa.librairie.data.bean.StatutAdresse;
import fr.afpa.librairie.data.bean.StatutAdresse;
import fr.afpa.librairie.data.dao.StatutAdresseDAO;
import fr.afpa.librairie.data.dao.StatutAdresseDAO;
import fr.afpa.librairie.data.exception.DAOException;
import java.util.List;

public class StatutAdresseListDAO extends AbstractListDAO<StatutAdresse> implements StatutAdresseDAO {

    public StatutAdresseListDAO(AbstractDAOFactory factory) {
        super(factory);
    }

    @Override
    public StatutAdresse findById(Long id) throws DAOException {
        return getTable().stream().filter((StatutAdresse statut) -> {
            return statut.getId().equals(id);
        }).findFirst().orElse(null);
    }

    @Override
    public StatutAdresse findByCode(String code) {
        return getTable().stream().filter((StatutAdresse statut) -> {
            return statut.getCode().equals(code);
        }).findFirst().orElse(null);
    }

    @Override
    public List<StatutAdresse> findByAdresse(Long idAdresse) throws DAOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void create(StatutAdresse instance) throws DAOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(StatutAdresse instance) throws DAOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
