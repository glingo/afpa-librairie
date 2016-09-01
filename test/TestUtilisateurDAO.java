import fr.afpa.librairie.data.bean.Utilisateur;
import fr.afpa.librairie.data.DAOFactory;
import fr.afpa.librairie.data.bean.Role;
import fr.afpa.librairie.data.bean.StatutUtilisateur;
import fr.afpa.librairie.data.dao.UtilisateurDAO;
import java.sql.Date;

public class TestUtilisateurDAO {
    
    /*** 
     * ezarkzejrzkejrzerljkezr
     * @param args 
     */
    public static void main(String[] args) {
        
        Role admin = new Role();
        admin.setCode("ADM");
        admin.setLibelle("Administrateur");
        
        Role user = new Role();
        user.setCode("USR");
        user.setLibelle("Utilisateur");
        
        StatutUtilisateur statut = new StatutUtilisateur();
        statut.setCode("NEW");
        statut.setLibelle("Nouveau");
        
        Utilisateur utilisateur = new Utilisateur();
        
        utilisateur.setNom("Robert");
        utilisateur.setPrenom("Redford");
        utilisateur.setEmail("robert.redford@gmail.com");
        utilisateur.setMotDePasse("testmdp");
        
        utilisateur.setDateNaissance(new Date(1989, 02, 23));
        
        utilisateur.addRole(user);
        utilisateur.addRole(admin);
        utilisateur.setStatut(statut);
        
        UtilisateurDAO dao = DAOFactory.getInstance().getUtilisateurDAO();
        dao.save(utilisateur);
        
        Utilisateur robert = dao.findByEmail("robert.redford@gmail.com");
        System.out.println(robert.getPrenom());
        
        dao.delete(robert);
        System.out.println(robert.getPrenom());
        
        robert = dao.findByEmail("robert.redford@gmail.com");
        System.out.println(robert.getPrenom());
        
    }
}
