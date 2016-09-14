package fr.afpa.librairie.data.dao.support.list;

import fr.afpa.librairie.data.AbstractDAOFactory;
import fr.afpa.librairie.data.bean.StatutEntreprise;
import fr.afpa.librairie.data.dao.StatutEntrepriseDAO;
import fr.afpa.librairie.data.exception.DAOException;
import java.util.List;

public class StatutEntrepriseListDAO extends AbstractListDAO<StatutEntreprise> implements StatutEntrepriseDAO {

    public StatutEntrepriseListDAO(AbstractDAOFactory factory) {
        super(factory);
    }

    @Override
    public StatutEntreprise findById(Long id) throws DAOException {
        return getTable().stream().filter((StatutEntreprise statut) -> {
            return statut.getId().equals(id);
        }).findFirst().orElse(null);
    }

    @Override
    public StatutEntreprise findByCode(String code) {
        return getTable().stream().filter((StatutEntreprise statut) -> {
            return statut.getCode().equals(code);
        }).findFirst().orElse(null);
    }

    @Override
    public List<StatutEntreprise> findByEntreprise(Long idEntreprise) throws DAOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void create(StatutEntreprise instance) throws DAOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(StatutEntreprise instance) throws DAOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
