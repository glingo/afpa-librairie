package fr.afpa.librairie.controller;

import fr.afpa.librairie.data.bean.Rubrique;
import fr.afpa.librairie.view.MainFrame;
import java.awt.event.ActionEvent;
import java.util.List;

public class HomeController extends Controller {

    @Override
    public void actionPerformed(ActionEvent e) {
        if(frame == null) {
            this.frame = new MainFrame();
            this.frame.setVisible(true);
            load();
        }
    }
    
    private void load(){
        List<Rubrique> rubriques = this.getDaoFactory().getRubriqueDAO().findAll();
        this.frame.getLeftMenuPanel().setRubriqueList(rubriques);
    }
    
    
}
