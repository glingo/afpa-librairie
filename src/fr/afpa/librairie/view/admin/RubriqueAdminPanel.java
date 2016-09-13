
package fr.afpa.librairie.view.admin;

import fr.afpa.librairie.controller.Controller;
import fr.afpa.librairie.data.bean.Rubrique;
import fr.afpa.librairie.model.table.TableModel;
import fr.afpa.librairie.view.panel.AdminPanel;

public class RubriqueAdminPanel extends AdminPanel<Rubrique>{

    public RubriqueAdminPanel(TableModel<Rubrique> tableModel, Controller controller) {
        super(tableModel, controller);
    }

    @Override
    protected String getTitleText() {
        return "Rubrique administration";
    }
}
