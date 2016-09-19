package fr.afpa.librairie.view.pays;

import fr.afpa.librairie.data.bean.Pays;
import fr.afpa.librairie.model.table.PaysTableModel;
import fr.afpa.librairie.view.panel.AdminPanel;
import fr.afpa.librairie.view.panel.ListPanel;
import fr.afpa.librairie.view.panel.TitlePanel;
import fr.afpa.librairie.view.panel.footer.FooterAdminPanel;
import java.awt.event.ActionListener;

public class PaysAdminPanel extends AdminPanel<Pays> {
    
    private static final String TITLE = "Administration des pays.";

    public PaysAdminPanel(ActionListener controller) {
        super(new TitlePanel(TITLE), 
            new ListPanel<>(new PaysTableModel()), 
            new FooterAdminPanel(controller));
    }
}
