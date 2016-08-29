
import fr.afpa.librairie.model.Utilisateur;
import fr.afpa.librairie.persistance.DAOFactory;
import fr.afpa.librairie.persistance.dao.UtilisateurDAO;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author cdi305
 */
public class TestUtilisateurDAO {
    
    public static void main(String[] args) {
        Utilisateur utilisateur = new Utilisateur();
        utilisateur.setNom("Robert");
        utilisateur.setPrenom("Redford");
        utilisateur.setEmail("robert.redford@gmail.com");
        UtilisateurDAO dao = DAOFactory.getInstance().getUtilisateurDAO();
        dao.creer(utilisateur);
    }
}
