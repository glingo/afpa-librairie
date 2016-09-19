package fr.afpa.librairie.view.ouvrage;

import fr.afpa.librairie.controller.CRUDController;
import fr.afpa.librairie.data.bean.Auteur;
import fr.afpa.librairie.data.bean.Genre;
import fr.afpa.librairie.data.bean.Ouvrage;
import fr.afpa.librairie.data.bean.Rubrique;
import fr.afpa.librairie.data.bean.Tag;
import fr.afpa.librairie.data.bean.Theme;
import fr.afpa.librairie.model.list.ListAdapterListModel;
import fr.afpa.librairie.model.list.renderer.AuteurListCellRenderer;
import fr.afpa.librairie.model.list.renderer.GenreListCellRenderer;
import fr.afpa.librairie.model.list.renderer.RubriqueListCellRenderer;
import fr.afpa.librairie.model.list.renderer.ThemeListCellRenderer;
import fr.afpa.librairie.model.verifier.StrictInputVerifier;
import fr.afpa.librairie.view.panel.EditorPanel;
import java.awt.Dimension;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;
import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.ListSelectionModel;

public class OuvrageEditorPanel extends EditorPanel<Ouvrage> {
    
    // many to one
    private DefaultComboBoxModel<Auteur> auteurComboModel;
    
    // many to many
    private ListAdapterListModel<Auteur> coAuteurModel;
    private ListAdapterListModel<Genre> genreModel;
    private ListAdapterListModel<Theme> themeModel;
    private ListAdapterListModel<Rubrique> rubriqueModel;
    
    private JLabel titreLB;
    private JLabel sousTitreLB;
    private JLabel auteurLB;
    private JLabel genreLB;
    private JLabel themeLB;
    private JLabel resumeLB;
    private JLabel rubriqueLB;
    private JLabel tagLB;
    private JLabel coAuteursLB;
    
    private JTextField titre;
    private JTextField sousTitre;
    private JTextArea resume;
    private JTextField tag;
    
    private JComboBox<Auteur> auteur;
    
    private JList<Genre> genres;
    private JList<Theme> themes;
    private JList<Rubrique> rubriques;
    private JList<Auteur> coAuteurs;
    
    private JScrollPane resumeSP;
    private JScrollPane themesSP;
    private JScrollPane genresSP;
    private JScrollPane rubriquesSP;
    private JScrollPane coAuteursSP;
    
    public OuvrageEditorPanel(CRUDController<Ouvrage> controller) {
        super(controller);
    }
    
    @Override
    protected void initBody(JPanel body) {
        
        resumeSP    = new JScrollPane();
        themesSP    = new JScrollPane();
        genresSP    = new JScrollPane();
        rubriquesSP = new JScrollPane();
        coAuteursSP = new JScrollPane();
 
        titre       = new JTextField();
        sousTitre   = new JTextField();
        tag         = new JTextField();
        resume      = new JTextArea(10, 10);
        
        resume.setLineWrap(true);
        
        resumeSP.setViewportView(resume);
        
        auteur = new JComboBox<>();
        
        genres    = new JList<>();
        themes    = new JList<>();
        rubriques = new JList<>();
        coAuteurs = new JList<>();
        
        int cellHeight = 20;
        genres.setFixedCellHeight(cellHeight);
        themes.setFixedCellHeight(cellHeight);
        rubriques.setFixedCellHeight(cellHeight);
        coAuteurs.setFixedCellHeight(cellHeight);
        
        genres.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        themes.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        rubriques.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        coAuteurs.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        
        Dimension spDimension = new Dimension(250, 80);
        themesSP.setViewportView(themes);
        genresSP.setViewportView(genres);
        rubriquesSP.setViewportView(rubriques);
        coAuteursSP.setViewportView(coAuteurs);
        
        coAuteursSP.setPreferredSize(spDimension);
        rubriquesSP.setPreferredSize(spDimension);
        genresSP.setPreferredSize(spDimension);
        themesSP.setPreferredSize(spDimension);
        
        auteur.setRenderer(new AuteurListCellRenderer());
        
        rubriques.setCellRenderer(new RubriqueListCellRenderer());
        coAuteurs.setCellRenderer(new AuteurListCellRenderer());
        genres.setCellRenderer(new GenreListCellRenderer());
        themes.setCellRenderer(new ThemeListCellRenderer());
        
        titreLB     = new JLabel("Titre :");
        sousTitreLB = new JLabel("Sous-Titre :");
        auteurLB    = new JLabel("Auteur :");
        genreLB     = new JLabel("Genre :");
        themeLB     = new JLabel("Theme :");
        resumeLB    = new JLabel("Resume :");
        rubriqueLB  = new JLabel("Rubrique :");
        tagLB       = new JLabel("Tag :");
        coAuteursLB = new JLabel("Co-auteurs :");

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
                                    .addComponent(auteurLB, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(coAuteursLB, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(themeLB, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(tagLB, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                )
                                
                                .addGap(13, 13, 13)
                                    
                                .addGroup(bodyPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                    .addComponent(titre, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(auteur, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(coAuteursSP, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(themesSP, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(tag, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                )
                                    
                                .addGap(13, 13, 13)
                                    
                                .addGroup(bodyPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                    .addComponent(sousTitreLB, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(resumeLB, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(rubriqueLB, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(genreLB, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                )
                                    
                                .addGap(13, 13, 13)
                                    
                                .addGroup(bodyPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                    .addComponent(sousTitre, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(resumeSP, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(rubriquesSP, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(genresSP, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                )
                            )
                        ).addGap(6, 6, 6))))
        );

        bodyPanelLayout.setVerticalGroup(
            bodyPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(bodyPanelLayout.createSequentialGroup()
                .addGroup(bodyPanelLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                    .addComponent(titre, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(titreLB)
                )
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                
                .addGroup(bodyPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(auteur, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(auteurLB)
                )
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(bodyPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(coAuteursSP, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(coAuteursLB)
                )
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    
                .addGroup(bodyPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(themesSP, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(themeLB)
                )
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    
                .addGroup(bodyPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(tag, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(tagLB)
                )
            ).addGroup(bodyPanelLayout.createSequentialGroup()
                .addGroup(bodyPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(sousTitre, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(sousTitreLB)
                )
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(bodyPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(resumeSP, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(resumeLB)
                )
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(bodyPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(rubriquesSP, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(rubriqueLB)
                )
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(bodyPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(genresSP, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(genreLB)
                )
            )
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
        
        
        
        if(ouvrage.getAuteur() != null) {
            this.auteur.setSelectedItem(ouvrage.getAuteur());
        }
        
        if(ouvrage.getRubriques() != null){
            this.rubriques.setSelectedValue(rubriques, true);
        }
        
        if(ouvrage.getThemes() != null){
            this.themes.setSelectedValue(themes, true);
        }
        
        if(ouvrage.getCoAuteurs() != null){
            this.coAuteurs.setSelectedValue(coAuteurs, true);
        }
        
        if(ouvrage.getGenres() != null){
            this.genres.setSelectedValue(genres, true);
        }
        
//        int i = 0;
//        int[] ri = new int[ouvrage.getRubriques().size()];
//        for (Rubrique rubrique : ouvrage.getRubriques()) {
//            ri[i] = this.rubriqueModel.indexOf(rubrique);
//        }
//        this.rubriques.setSelectedIndices(ri);
        
//        int i = 0;
//        int[] ti = new int[ouvrage.getThemes().size()];
//        for (Theme theme : ouvrage.getThemes()) {
//            ti[i] = this.themeModel.indexOf(theme);
//        }
//        this.themes.setSelectedIndices(ti);
//        
//        i = 0;
//        int[] ci = new int[ouvrage.getCoAuteurs().size()];
//        for (Auteur coAuteur : ouvrage.getCoAuteurs()) {
//            ci[i] = this.coAuteurModel.indexOf(coAuteur);
//        }
//        this.coAuteurs.setSelectedIndices(ci);
//        
//        i = 0;
//        int[] gi = new int[ouvrage.getGenres().size()];
//        for (Genre genre : ouvrage.getGenres()) {
//            gi[i] = this.genreModel.indexOf(genre);
//        }
//        this.genres.setSelectedIndices(gi);
        
        if(ouvrage.getTags() != null) {
            ouvrage.getTags().forEach((Tag usedTag)-> {
                this.tag.setText(this.tag.getText() + " " + usedTag.getLibelle());
            });
        }
        
    }

    @Override
    public Ouvrage constructBean() {
        
        Ouvrage ouvrage = getBean();
        
        ouvrage.setTitre(titre.getText());
        ouvrage.setSousTitre(sousTitre.getText());
        ouvrage.setResume(resume.getText());
        ouvrage.setGenres(genres.getSelectedValuesList());
        ouvrage.setRubriques(rubriques.getSelectedValuesList());
        ouvrage.setThemes(themes.getSelectedValuesList());
        ouvrage.setCoAuteurs(coAuteurs.getSelectedValuesList());
        ouvrage.setAuteur((Auteur) auteur.getSelectedItem());
   
        List<Tag> lTags = new ArrayList<>();
        for (String tagValue : tag.getText().split(" ")) {
            if(!"".equals(tagValue)) {
                lTags.add(new Tag(tagValue));
            }
        }
        ouvrage.setTags(lTags);
        
        return ouvrage;
    }

    @Override
    public void reset() {
        
        this.titre.setText("");
        this.sousTitre.setText("");
        this.resume.setText("");
        this.tag.setText("");
        
        this.auteur.setSelectedItem(null);
        this.rubriques.setSelectedValue(null, true);
        this.genres.setSelectedValue(null, true);
        this.themes.setSelectedValue(null, true);
        this.coAuteurs.setSelectedValue(null, true);
        
    }

    public void setAuteurModel(List<Auteur> list){
        this.auteurComboModel = new DefaultComboBoxModel(list.toArray());
        this.auteurComboModel.setSelectedItem(null);
        this.auteur.setModel(this.auteurComboModel);
    }

    public void setCoAuteurModel(List<Auteur> auteurs) {
        this.coAuteurModel = new ListAdapterListModel();
        this.coAuteurModel.addAll(auteurs);
        this.coAuteurs.setModel(this.coAuteurModel);
    }
    
    public void setGenresModel(List<Genre> genres) {
        this.genreModel = new ListAdapterListModel();
        this.genreModel.addAll(genres);
        this.genres.setModel(this.genreModel);
    }
    
    public void setThemesModel(List<Theme> themes) {
        this.themeModel = new ListAdapterListModel();
        this.themeModel.addAll(themes);
        this.themes.setModel(this.themeModel);
    }
    
    public void setRubriquesModel(List<Rubrique> rubriques) {
        this.rubriqueModel = new ListAdapterListModel();
        this.rubriqueModel.addAll(rubriques);
        this.rubriques.setModel(this.rubriqueModel);
    }
    
}
