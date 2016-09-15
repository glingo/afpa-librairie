package fr.afpa.librairie.view.adresse;

import fr.afpa.librairie.data.bean.Adresse;
import fr.afpa.librairie.model.table.AdresseTableModel;
import fr.afpa.librairie.view.panel.AdminPanel;
import fr.afpa.librairie.view.panel.ListPanel;
import fr.afpa.librairie.view.panel.TitlePanel;
import fr.afpa.librairie.view.panel.footer.FooterAdminPanel;
import java.awt.event.ActionListener;

public class AdresseAdminPanel extends AdminPanel<Adresse> {
    
    private static final String TITLE = "Administration des adresses";

    public AdresseAdminPanel(ActionListener controller) {
        super(new TitlePanel(TITLE), 
            new ListPanel<>(new AdresseTableModel()), 
            new FooterAdminPanel(controller));
    }
}
