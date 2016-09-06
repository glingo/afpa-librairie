package fr.afpa.librairie.data.dao;

import fr.afpa.librairie.data.bean.Role;
import fr.afpa.librairie.data.exception.DAOException;
import java.util.List;

public interface RoleDAO extends DAOInterface<Role> {

    Role findByCode(String code);
    
    List<Role> findByUtilisateur(Long idUtilisateur) throws DAOException;
}
