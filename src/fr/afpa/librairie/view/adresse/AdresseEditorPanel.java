package fr.afpa.librairie.view.adresse;

import fr.afpa.librairie.data.bean.Adresse;
import fr.afpa.librairie.data.bean.Pays;
import fr.afpa.librairie.model.list.renderer.PaysListCellRenderer;
import fr.afpa.librairie.model.verifier.StrictInputVerifier;
import fr.afpa.librairie.view.panel.EditorPanel;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;

public class AdresseEditorPanel extends EditorPanel<Adresse> {
    
    private DefaultComboBoxModel<Pays> paysComboModel;
    
    private JLabel numeroLabel;
    private JLabel voieLabel;
    private JLabel cpLabel;
    private JLabel villeLabel;
    private JLabel complementLabel;
    private JLabel paysLabel;
    
    private JTextField numero;
    private JTextField voie;
    private JTextField cp;
    private JTextField ville;
    private JTextArea  complement;
    private JComboBox<Pays> pays;
    
    // ajouter statutadresse
    
    public AdresseEditorPanel(ActionListener controller) {
        super(new Adresse(), controller);
    }
    
    public AdresseEditorPanel(Adresse bean, ActionListener controller) {
        super(bean, controller);
    }

    @Override
    protected void initBody(JPanel body) {
        
        numero      = new JTextField();
        voie        = new JTextField();
        cp          = new JTextField();
        ville       = new JTextField();
        complement  = new JTextArea();
        pays        = new JComboBox<>();
        
        pays.setRenderer(new PaysListCellRenderer());
        
        numeroLabel     = new JLabel("Numero :");
        voieLabel       = new JLabel("Voie :");
        cpLabel         = new JLabel("Code postal :");
        villeLabel      = new JLabel("Ville :");
        complementLabel = new JLabel("Complément :");
        paysLabel       = new JLabel("Pays :");
        
        voie.setInputVerifier(new StrictInputVerifier());
        cp.setInputVerifier(new StrictInputVerifier());
        ville.setInputVerifier(new StrictInputVerifier());
        
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
                                    .addComponent(numeroLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(voieLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(cpLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(villeLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(complementLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(paysLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(13, 13, 13)
                                .addGroup(bodyPanelLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                    .addComponent(numero, GroupLayout.Alignment.LEADING)
                                    .addComponent(voie, GroupLayout.Alignment.LEADING)
                                    .addComponent(cp, GroupLayout.Alignment.LEADING)
                                    .addComponent(ville, GroupLayout.Alignment.LEADING)
                                    .addComponent(complement, GroupLayout.Alignment.LEADING)
                                    .addComponent(pays, GroupLayout.Alignment.LEADING))))
                        .addGap(6, 6, 6))))
        );

        bodyPanelLayout.setVerticalGroup(
            bodyPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(bodyPanelLayout.createSequentialGroup()
                .addGroup(bodyPanelLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                    .addComponent(numeroLabel)
                    .addComponent(numero, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(bodyPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(voie, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(voieLabel))
                .addGroup(bodyPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(cp, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(cpLabel))
                .addGroup(bodyPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(ville, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(villeLabel))
                .addGroup(bodyPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(complement, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(complementLabel))
                .addGroup(bodyPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(pays, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(paysLabel))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED))
        );
    }

    @Override
    protected String getTitleText() {
        
        Adresse adresse = getBean();
        
        return adresse.getId() != null 
                ? "Adresse n°" + adresse.getId()
                : "Nouvelle Adresse";
    }

    @Override
    public void bindValues() {
        Adresse adresse = getBean();
        
        numero.setText(adresse.getNumero());
        voie.setText(adresse.getVoie());
        cp.setText(adresse.getCp());
        ville.setText(adresse.getVille());
        complement.setText(adresse.getComplement());
        pays.setSelectedItem(adresse.getPays());
    }

    @Override
    public Adresse constructBean() {
        Adresse adresse = getBean();
        
        adresse.setNumero(numero.getText().trim());
        adresse.setVoie(voie.getText().trim());
        adresse.setCp(cp.getText().trim());
        adresse.setVille(ville.getText().trim());
        adresse.setComplement(complement.getText().trim());
        adresse.setPays((Pays) pays.getSelectedItem());
        
        return adresse;
    }

    @Override
    public void reset() {
        numero.setText("");
        voie.setText("");
        cp.setText("");
        ville.setText("");
        complement.setText("");
        pays.setSelectedItem(null);
    }
    
    public void setPays(List<Pays> list){
        paysComboModel = new DefaultComboBoxModel(list.toArray());
        pays.setModel(paysComboModel);
    }
    
}
