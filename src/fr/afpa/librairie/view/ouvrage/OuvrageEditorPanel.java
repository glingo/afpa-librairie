package fr.afpa.librairie.view.ouvrage;

import fr.afpa.librairie.controller.CRUDController;
import fr.afpa.librairie.data.bean.Auteur;
import fr.afpa.librairie.data.bean.Genre;
import fr.afpa.librairie.data.bean.Ouvrage;
import fr.afpa.librairie.data.bean.Rubrique;
import fr.afpa.librairie.data.bean.Theme;
import fr.afpa.librairie.model.list.renderer.AuteurListCellRenderer;
import fr.afpa.librairie.model.list.renderer.GenreListCellRenderer;
import fr.afpa.librairie.model.list.renderer.RubriqueListCellRenderer;
import fr.afpa.librairie.model.list.renderer.ThemeListCellRenderer;
import fr.afpa.librairie.model.verifier.StrictInputVerifier;
import fr.afpa.librairie.view.panel.EditorPanel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;

/**
 *
 * @author cdi305
 */
public class OuvrageEditorPanel extends EditorPanel<Ouvrage> {
    
    private DefaultComboBoxModel<Auteur> adresseComboModel;
    private DefaultComboBoxModel<Genre> genreComboModel;
    private DefaultComboBoxModel<Theme> themeComboModel;
    private DefaultComboBoxModel<Rubrique> rubriqueComboModel;
    
    private JLabel titreLB;
    private JLabel sousTitreLB;
    private JLabel auteurLB;
    private JLabel genreLB;
    private JLabel themeLB;
    private JLabel resumeLB;
    private JLabel rubriqueLB;
    private JLabel tagLB;
    
    private JTextField titre;
    private JTextField sousTitre;
    private JComboBox<Auteur> auteur;
    private JComboBox<Genre> genre;
    private JComboBox<Theme> theme;
    private JTextArea resume;
    private JComboBox<Rubrique> rubrique;
    private JTextField tag;
    private JScrollPane scrollPane;
    
    
    public OuvrageEditorPanel(CRUDController<Ouvrage> controller) {
        super(controller);
    }
    
    @Override
    protected void initBody(JPanel body) {
        
        scrollPane = new JScrollPane();
 
        
        titre = new JTextField();
        sousTitre = new JTextField();
        auteur = new JComboBox<>();
        auteur.setRenderer(new AuteurListCellRenderer());
        genre = new JComboBox<>();
        genre.setRenderer(new GenreListCellRenderer());
        theme = new JComboBox<>();
        theme.setRenderer(new ThemeListCellRenderer());
        resume = new JTextArea();
        scrollPane.setViewportView(resume);
        rubrique = new JComboBox<>();
        rubrique.setRenderer(new RubriqueListCellRenderer());
        tag = new JTextField();
        
        
        titreLB = new JLabel("Titre :");
        sousTitreLB = new JLabel("Sous-Titre :");
        auteurLB = new JLabel("Auteur :");
        genreLB = new JLabel("Genre :");
        themeLB = new JLabel("Theme :");
        resumeLB = new JLabel("Resume :");
        rubriqueLB = new JLabel("Rubrique :");
        tagLB = new JLabel("Tag :");
        

        titre.setInputVerifier(new StrictInputVerifier());
        
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
                                    .addComponent(titreLB, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(sousTitreLB, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(auteurLB, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(genreLB, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(themeLB, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(resumeLB, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(rubriqueLB, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(tagLB, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(13, 13, 13)
                                .addGroup(bodyPanelLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                    .addComponent(titre, GroupLayout.Alignment.LEADING)
                                    .addComponent(sousTitre, GroupLayout.Alignment.LEADING)
                                    .addComponent(auteur, GroupLayout.Alignment.LEADING)
                                    .addComponent(genre, GroupLayout.Alignment.LEADING)
                                    .addComponent(theme, GroupLayout.Alignment.LEADING)
                                    .addComponent(resume, GroupLayout.Alignment.LEADING)
                                    .addComponent(rubrique, GroupLayout.Alignment.LEADING)
                                    .addComponent(tag, GroupLayout.Alignment.LEADING))))
                        .addGap(6, 6, 6))))
        );

        bodyPanelLayout.setVerticalGroup(
            bodyPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(bodyPanelLayout.createSequentialGroup()
                .addGroup(bodyPanelLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                    .addComponent(titreLB)
                    .addComponent(titre, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(bodyPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(sousTitre, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(sousTitreLB))
                .addGroup(bodyPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(auteur, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(auteurLB))
                .addGroup(bodyPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(genre, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(genreLB))
                .addGroup(bodyPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(theme, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(themeLB))
                .addGroup(bodyPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(resume, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(resumeLB))
                .addGroup(bodyPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(rubrique, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(rubriqueLB))
                .addGroup(bodyPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(tag, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(tagLB))
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
        auteur.setSelectedItem(null);
        genre.setSelectedItem(null);
        theme.setSelectedItem(null);
        resume.setText("");
        rubrique.setSelectedItem(null);
        tag.setText("");
        
    }
    
    
}
