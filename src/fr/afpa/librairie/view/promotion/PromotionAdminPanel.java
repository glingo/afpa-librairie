
package fr.afpa.librairie.view.promotion;

import fr.afpa.librairie.data.bean.Promotion;
import fr.afpa.librairie.model.table.PromotionTableModel;
import fr.afpa.librairie.view.panel.AdminPanel;
import fr.afpa.librairie.view.panel.ListPanel;
import fr.afpa.librairie.view.panel.TitlePanel;
import fr.afpa.librairie.view.panel.footer.FooterAdminPanel;
import java.awt.event.ActionListener;

public class PromotionAdminPanel extends AdminPanel<Promotion> {

    private final static String TITLE = "Administration des promotions.";

    public PromotionAdminPanel(ActionListener controller) {
        super(new TitlePanel(TITLE), 
            new ListPanel<>(new PromotionTableModel()), 
            new FooterAdminPanel(controller));
    }
    
}
