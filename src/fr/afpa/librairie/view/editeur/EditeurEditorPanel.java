package fr.afpa.librairie.view.editeur;

import fr.afpa.librairie.data.bean.Editeur;
import fr.afpa.librairie.model.verifier.StrictInputVerifier;
import fr.afpa.librairie.view.panel.EditorPanel;
import java.awt.event.ActionListener;
import javax.swing.GroupLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;

public class EditeurEditorPanel extends EditorPanel<Editeur> {
    
    private JLabel libelleLabel;
    
    private JTextField libelle;
    
    public EditeurEditorPanel(ActionListener controller) {
        super(new Editeur(), controller);
    }
    
    public EditeurEditorPanel(Editeur bean, ActionListener controller) {
        super(bean, controller);
    }

    @Override
    protected void initBody(JPanel body) {
        
        libelle = new JTextField();
        
        libelleLabel = new JLabel("Libelle :");
        
        libelle.setInputVerifier(new StrictInputVerifier());
        
        GroupLayout bodyPanelLayout = new GroupLayout(body);
        body.setLayout(bodyPanelLayout);

        bodyPanelLayout.setHorizontalGroup(
            bodyPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(bodyPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(bodyPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(GroupLayout.Alignment.TRAILING, bodyPanelLayout.createSequentialGroup()
                        .addGroup(bodyPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addGroup(bodyPanelLayout.createSequentialGroup()
                                .addGroup(bodyPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                    .addComponent(libelleLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(13, 13, 13)
                                .addGroup(bodyPanelLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                    .addComponent(libelle, GroupLayout.Alignment.LEADING))))
                        .addGap(6, 6, 6))))
        );

        bodyPanelLayout.setVerticalGroup(
            bodyPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(bodyPanelLayout.createSequentialGroup()
                .addGroup(bodyPanelLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                    .addComponent(libelleLabel)
                    .addComponent(libelle, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED))
        );
    }

    @Override
    protected String getTitleText() {
        
        Editeur editeur = getBean();
        
        return editeur.getId() != null 
                ? "Editeur " + editeur.getLibelle()
                : "Nouvel Editeur";
    }

    @Override
    public void bindValues() {
        Editeur editeur = getBean();
        
        libelle.setText(editeur.getLibelle());
        
    }

    @Override
    public Editeur constructBean() {
        Editeur editeur = getBean();
        
        editeur.setLibelle(libelle.getText());
        
        return editeur;
    }

    @Override
    public void reset() {
        libelle.setText("");
    }
    
    
}
