package fr.afpa.librairie.controller;

import fr.afpa.librairie.data.bean.Rubrique;
import fr.afpa.librairie.data.exception.DAOException;
import fr.afpa.librairie.view.MainFrame;
import java.awt.event.ActionEvent;
import java.util.List;
import javax.swing.JOptionPane;

public class HomeController extends Controller {

    @Override
    public void actionPerformed(ActionEvent e) {
        if(frame == null) {
            load();
        }
    }
    
    public void load(){
        this.frame = new MainFrame();
        
        try {
            List<Rubrique> rubriques = this.getDaoFactory().getRubriqueDAO().findAll();
            this.frame.getLeftMenuPanel().setRubriqueList(rubriques);
        } catch(DAOException ex) {
            this.frame.dispose();
            JOptionPane.showMessageDialog(this.frame, "Impossible de joindre la base de données !");
            throw new RuntimeException("Impossible de joindre la base de données !");
        }
        
        this.frame.setVisible(true);
    }
    
    
}
