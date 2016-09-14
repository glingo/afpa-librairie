package fr.afpa.librairie.view.utilisateur;

import fr.afpa.librairie.data.bean.Utilisateur;
import fr.afpa.librairie.model.table.UtilisateurTableModel;
import fr.afpa.librairie.view.panel.AdminPanel;
import fr.afpa.librairie.view.panel.ListPanel;
import fr.afpa.librairie.view.panel.TitlePanel;
import fr.afpa.librairie.view.panel.footer.ActivableFooterAdminPanel;
import java.awt.event.ActionListener;

public class UtilisateurAdminPanel extends AdminPanel<Utilisateur> {
    
    private static final String TITLE = "Administration des utilisateurs.";

    public UtilisateurAdminPanel(ActionListener controller) {
        super(new TitlePanel(TITLE), 
            new ListPanel<>(new UtilisateurTableModel()), 
            new ActivableFooterAdminPanel(controller));
    }

}
