/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.afpa.librairie.controller;

import static fr.afpa.librairie.controller.UtilisateurController.ACTIVATE_ACTION;
import static fr.afpa.librairie.controller.UtilisateurController.DESACTIVATE_ACTION;
import fr.afpa.librairie.data.bean.Utilisateur;
import fr.afpa.librairie.view.MainFrame;
import java.awt.event.ActionEvent;

/**
 *
 * @author cdi305
 */
public abstract class ActivableCRUDController<T> extends CRUDController<T> {
    
    public static final String ACTIVATE_ACTION = "activate";
    public static final String DESACTIVATE_ACTION = "desactivate";

    public ActivableCRUDController(MainFrame frame) {
        super(frame);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {

            case DESACTIVATE_ACTION:
                deactivateAction(getAdminPanel().getList().getSelectedValue());
                break;

            case ACTIVATE_ACTION:
                activateAction(getAdminPanel().getList().getSelectedValue());
                break;
        }

        super.actionPerformed(e);
    }

    public abstract void deactivateAction(T value);

    public abstract void activateAction(T value);
    
}
