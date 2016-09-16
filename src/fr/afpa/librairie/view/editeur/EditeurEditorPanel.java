package fr.afpa.librairie.view.editeur;

import fr.afpa.librairie.controller.CRUDController;
import fr.afpa.librairie.data.bean.Adresse;
import fr.afpa.librairie.data.bean.Editeur;
import fr.afpa.librairie.model.list.ListAdapterListModel;
import fr.afpa.librairie.model.list.renderer.AdresseListCellRenderer;
import fr.afpa.librairie.model.verifier.StrictInputVerifier;
import fr.afpa.librairie.view.panel.EditorPanel;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;

public class EditeurEditorPanel extends EditorPanel<Editeur> {
    
    private DefaultComboBoxModel<Adresse> adresseComboModel;
    
    private JLabel libelleLabel;
    private JLabel adresseLabel;
    
    private JTextField libelle;
    private JComboBox<Adresse> adresse;
    private JButton newAdresse;
    
    public EditeurEditorPanel(ActionListener controller) {
        super(new Editeur(), controller);
    }
    
    public EditeurEditorPanel(Editeur bean, ActionListener controller) {
        super(bean, controller);
    }

    @Override
    protected void initBody(JPanel body) {
        
        libelle = new JTextField();
        adresse = new JComboBox<>();
        newAdresse = new JButton("+");
        newAdresse.setActionCommand(CRUDController.CREATE_MODAL_ACTION);
        
        adresse.setRenderer(new AdresseListCellRenderer());
        
        libelleLabel = new JLabel("Libelle :");
        adresseLabel = new JLabel("Adresse :");
        
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
                                    .addComponent(libelleLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(adresseLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(13, 13, 13)
                                .addGroup(bodyPanelLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                    .addComponent(libelle, GroupLayout.Alignment.LEADING)
                                    .addComponent(adresse, GroupLayout.Alignment.CENTER))
                                .addGroup(bodyPanelLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                    .addComponent(newAdresse, GroupLayout.Alignment.TRAILING))))
                        .addGap(6, 6, 6))))
        );

        bodyPanelLayout.setVerticalGroup(
            bodyPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(bodyPanelLayout.createSequentialGroup()
                .addGroup(bodyPanelLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                    .addComponent(libelleLabel)
                    .addComponent(libelle, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addGroup(bodyPanelLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                    .addComponent(adresseLabel)
                    .addComponent(adresse, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(newAdresse))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED))
        );
    }
    
    public void setAdresses(ListAdapterListModel<Adresse> list){
        adresseComboModel = new DefaultComboBoxModel(list.getList().toArray());
        adresseComboModel.insertElementAt(null, 0);
        adresseComboModel.setSelectedItem(null);
        adresse.setModel(adresseComboModel);
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
        adresse.setSelectedItem(editeur.getAdresse());
    }

    @Override
    public Editeur constructBean() {
        Editeur editeur = getBean();
        
        editeur.setLibelle(libelle.getText());
        editeur.setAdresse((Adresse) adresse.getSelectedItem());
        
        return editeur;
    }

    @Override
    public void reset() {
        libelle.setText("");
        adresse.setSelectedItem(null);
    }

    public JButton getNewAdresse() {
        return newAdresse;
    }
    
}
