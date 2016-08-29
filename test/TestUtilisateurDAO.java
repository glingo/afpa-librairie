import fr.afpa.librairie.model.Utilisateur;
import fr.afpa.librairie.persistance.DAOFactory;
import fr.afpa.librairie.persistance.dao.UtilisateurDAO;

public class TestUtilisateurDAO {
    
    /*** ezarkzejrzkejrzerljkezr*/
    public static void main(String[] args) {
        Utilisateur utilisateur = new Utilisateur();
        utilisateur.setNom("Robert");
        utilisateur.setPrenom("Redford");
        utilisateur.setEmail("robert.redford@gmail.com");
        utilisateur.setMotDePasse("testmdp");
        UtilisateurDAO dao = DAOFactory.getInstance().getUtilisateurDAO();
        dao.creer(utilisateur);
        
        Utilisateur user = dao.findByEmail("robert.redford@gmail.com");
        System.out.println(user.getPrenom());
    }
}
