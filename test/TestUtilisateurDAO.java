import fr.afpa.librairie.data.AbstractDAOFactory;
import fr.afpa.librairie.data.DAOFactoryInterface;
import fr.afpa.librairie.data.bean.Utilisateur;
import fr.afpa.librairie.data.FactoryType;
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
        
        DAOFactoryInterface factory = AbstractDAOFactory.getFactory(FactoryType.DAO_FACTORY);
        UtilisateurDAO dao = factory.getUtilisateurDAO();
        
        Role admin = new Role();
        admin.setCode("ADM");
        admin.setLibelle("Administrateur");
        
        Role user = new Role();
        user.setCode("USR");
        user.setLibelle("Utilisateur");
        
        StatutUtilisateur statut = new StatutUtilisateur();
        statut.setCode("NEW");
        statut.setLibelle("Nouveau");
        
        // on declare un utilisateur parlant
//        Utilisateur robert = new Utilisateur();
//        robert.setNom("Robert");
//        robert.setPrenom("Redford");
//        robert.setEmail("robert.redford@gmail.com");
//        robert.setMotDePasse("testmdp");
//        robert.setDateNaissance(new Date(0));
//        robert.addRole(user);
//        robert.addRole(admin);
//        robert.setStatut(statut);

//        dao.save(robert);
        
        for (int i = 0; i < 10; i++) {
            Utilisateur utilisateur = new Utilisateur();
            
            utilisateur.setNom("Nom_" + i);
            utilisateur.setPrenom("Prenom_" + i);
            utilisateur.setEmail("mail.utilisateur." + i + "@gmail.com");
            utilisateur.setMotDePasse("mot_de_passe_" + i);
    //new java.util.Date()
    //Date.valueOf("yyyy-[m]m-[d]d")
            utilisateur.setDateNaissance(new Date(0));

            utilisateur.addRole(user);
            utilisateur.addRole(admin);
            utilisateur.setStatut(statut);
        
            dao.save(utilisateur);
        }
        
//        robert = dao.findByMail("robert.redford@gmail.com");
//        System.out.println(robert.getPrenom());
        
//        dao.delete(robert);
//        System.out.println(robert.getPrenom());
        
//        robert = dao.findByMail("robert.redford@gmail.com");
//        System.out.format("L'utilisateur %s %s été supprimé.\n", "robert.redford@gmail.com", robert == null ? "a bien" : "n'a pas");
        
    }
}
