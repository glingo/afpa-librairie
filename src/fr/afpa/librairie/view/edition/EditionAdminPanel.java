package fr.afpa.librairie.view.edition;

import fr.afpa.librairie.controller.EditionController;
import fr.afpa.librairie.data.bean.Edition;
import fr.afpa.librairie.model.table.EditionTableModel;
import fr.afpa.librairie.view.panel.AdminPanel;
import fr.afpa.librairie.view.panel.ListPanel;
import fr.afpa.librairie.view.panel.TitlePanel;
import fr.afpa.librairie.view.panel.footer.ActivableFooterAdminPanel;
import fr.afpa.librairie.view.panel.footer.FooterAdminPanel;
import java.awt.Component;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;

public class EditionAdminPanel extends AdminPanel<Edition> {

    private final static String TITLE = "Administration des editions.";

    public EditionAdminPanel(ActionListener controller) {
        super(new TitlePanel(TITLE), 
            new ListPanel<>(new EditionTableModel()), 
            new ActivableFooterAdminPanel(controller));
    }
  
}
