package fr.afpa.librairie.view.ouvrage;

import fr.afpa.librairie.data.bean.Ouvrage;
import fr.afpa.librairie.data.bean.Utilisateur;
import fr.afpa.librairie.model.verifier.StrictInputVerifier;
import fr.afpa.librairie.view.field.JDateField;
import fr.afpa.librairie.view.panel.EditorPanel;
import java.awt.event.ActionListener;
import javax.swing.GroupLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;

/**
 *
 * @author cdi305
 */
public class OuvrageEditorPanel extends EditorPanel<Ouvrage> {
    
    private JLabel titreLabel;
    private JLabel sousTitreLabel;
    private JLabel resumeLabel;
    
    
    private JTextField titre;
    private JTextField sousTitre;
    private JTextArea resume;
    private JScrollPane scrollPane;
    
    
    public OuvrageEditorPanel(ActionListener controller) {
        super(new Ouvrage(), controller);
    }
    
    public OuvrageEditorPanel(Ouvrage bean, ActionListener controller) {
        super(bean, controller);
    }

    @Override
    protected void initBody(JPanel body) {
        
        scrollPane = new JScrollPane();
         
        titreLabel = new JLabel("Titre :");
        sousTitreLabel = new JLabel("Sous-titre :");
        resumeLabel = new JLabel("Resume :");
        
        scrollPane.setViewportView(resume);
        
        titre = new JTextField();
        sousTitre = new JTextField();
        resume = new JTextArea();
        
        
        titre.setInputVerifier(new StrictInputVerifier());
        
        GroupLayout bodyPanelLayout = new GroupLayout(body);
        body.setLayout(bodyPanelLayout);
        
        bodyPanelLayout.setHorizontalGroup(
            bodyPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(bodyPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(bodyPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(bodyPanelLayout.createSequentialGroup()
                        .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(GroupLayout.Alignment.TRAILING, bodyPanelLayout.createSequentialGroup()
                        .addGroup(bodyPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addGroup(bodyPanelLayout.createSequentialGroup()
                                .addGroup(bodyPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                    .addGroup(bodyPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                        .addComponent(titreLabel, GroupLayout.DEFAULT_SIZE, 89, Short.MAX_VALUE)
                                        .addComponent(sousTitreLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    
                                    .addComponent(resumeLabel))
                                .addGroup(bodyPanelLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                    .addComponent(titre, GroupLayout.Alignment.LEADING)
                                    .addComponent(sousTitre, GroupLayout.Alignment.LEADING)
                                    .addComponent(resume, GroupLayout.Alignment.LEADING)
                                    .addComponent(scrollPane))))
                        .addGap(6, 6, 6))))
        );
        
        bodyPanelLayout.setVerticalGroup(
            bodyPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(bodyPanelLayout.createSequentialGroup()
                .addGap(3, 3, 3)
                .addGroup(bodyPanelLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                    .addComponent(titreLabel)
                    .addComponent(titre, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(bodyPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(sousTitre, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(sousTitreLabel))
                .addGroup(bodyPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(resume, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(resumeLabel))
                .addGroup(bodyPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(bodyPanelLayout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addGroup(bodyPanelLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(resumeLabel)))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED))
        );
        
    }

    @Override
    protected String getTitleText() {
        
        Ouvrage ouvrage = getBean();
        
        return ouvrage.getId() != null 
                ? "Ouvrage " + ouvrage.getTitre()
                : "Nouvel Ouvrage";
    }

    @Override
    public void bindValues() {
        Ouvrage ouvrage = getBean();
        
        
        titre.setText(ouvrage.getTitre());
        sousTitre.setText(ouvrage.getSousTitre());
        resume.setText(ouvrage.getResume());
        
        
    }

    @Override
    public Ouvrage constructBean() {
        
        Ouvrage ouvrage = getBean();
        
        ouvrage.setTitre(titre.getText());
        ouvrage.setSousTitre(sousTitre.getText());
        ouvrage.setResume(resume.getText());
   
        return ouvrage;
    }

    @Override
    public void reset() {
        
        titre.setText("");
        sousTitre.setText("");
        resume.setText("");
        
    }
    
    
}
