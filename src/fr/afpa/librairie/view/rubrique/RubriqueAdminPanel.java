
package fr.afpa.librairie.view.rubrique;

import fr.afpa.librairie.data.bean.Rubrique;
import fr.afpa.librairie.model.table.RubriqueTableModel;
import fr.afpa.librairie.view.panel.AdminPanel;
import fr.afpa.librairie.view.panel.ListPanel;
import fr.afpa.librairie.view.panel.TitlePanel;
import fr.afpa.librairie.view.panel.footer.FooterAdminPanel;
import java.awt.event.ActionListener;

public class RubriqueAdminPanel extends AdminPanel<Rubrique>{
    
    private final static String TITLE = "Administration des rubriques.";

    public RubriqueAdminPanel(ActionListener controller) {
        super(new TitlePanel(TITLE), 
            new ListPanel<>(new RubriqueTableModel()), 
            new FooterAdminPanel(controller));
    }
}
