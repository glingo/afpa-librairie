package fr.afpa.librairie.view.pays;

import fr.afpa.librairie.data.bean.Pays;
import fr.afpa.librairie.view.panel.EditorPanel;
import java.awt.event.ActionListener;
import javax.swing.GroupLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;

public class PaysEditorPanel extends EditorPanel<Pays> {
    
    private JLabel libelleLabel;
    private JLabel codeLabel;
    
    private JTextField libelle;
    private JTextField code;
    
    public PaysEditorPanel(ActionListener controller) {
        super(new Pays(), controller);
    }

    public PaysEditorPanel(Pays bean, ActionListener controller) {
        super(bean, controller);
    }

    @Override
    public Pays getBean() {
        Pays pays = super.getBean();
        
        if(pays == null){
            pays = new Pays();
            setBean(pays);
        }
        
        return pays;
    }
    
    @Override
    protected String getTitleText() {
        Pays pays = super.getBean();
        
        return pays.getId() != null 
                ? "Pays " + pays.getLibelle() 
                : "Nouveau Pays";
    }
    
    @Override
    protected void initBody(JPanel body) {
        
        libelleLabel = new JLabel("Libelle :");
        codeLabel    = new JLabel("Code :");
        
        libelle      = new JTextField();
        code         = new JTextField();

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
                                    .addGroup(bodyPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                        .addComponent(libelleLabel, GroupLayout.DEFAULT_SIZE, 89, Short.MAX_VALUE)
                                        .addComponent(codeLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                .addGroup(bodyPanelLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                    .addComponent(libelle, GroupLayout.Alignment.LEADING)
                                    .addComponent(code, GroupLayout.Alignment.LEADING))))
                        .addGap(6, 6, 6))))
        );
        
        bodyPanelLayout.setVerticalGroup(
            bodyPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(bodyPanelLayout.createSequentialGroup()
                .addGroup(bodyPanelLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                    .addComponent(libelleLabel)
                    .addComponent(libelle, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(bodyPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(codeLabel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(code))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED))
        );
        
    }   
    
    @Override
    public void bindValues() {
        Pays pays = getBean();
        libelle.setText(pays.getLibelle());
        code.setText(pays.getCode());
    }

    @Override
    public void reset() {
        libelle.setText("");
        code.setText("");
    }

    @Override
    public Pays constructBean() {
        Pays pays = getBean();
        
        pays.setLibelle(libelle.getText().trim());
        
        pays.setCode(code.getText().trim());
        
        return pays;
    }

}
