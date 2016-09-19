package fr.afpa.librairie.view.promotion;

import fr.afpa.librairie.controller.CRUDController;
import fr.afpa.librairie.data.bean.Promotion;
import fr.afpa.librairie.view.field.JDateField;
import fr.afpa.librairie.view.field.JPercentField;
import fr.afpa.librairie.view.panel.EditorPanel;
import java.sql.Date;
import javax.swing.GroupLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;

public class PromotionEditorPanel extends EditorPanel<Promotion> {
    
    private JDateField debut;
    private JDateField fin;
    private JPercentField reduction;
    private JTextField image;
    private JTextArea description;
    private JTextArea commentaire;
    
    private JLabel debutLabel;
    private JLabel finLabel;
    private JLabel reductionLabel;
    private JLabel imageLabel;
    private JLabel descriptionLabel;
    private JLabel commentaireLabel;
    
    public PromotionEditorPanel(CRUDController<Promotion> controller) {
        super(controller);
    }

    @Override
    protected void initBody(JPanel body) {
        debut = new JDateField(true);
        fin = new JDateField(false);
        reduction = new JPercentField(true);
        image = new JTextField();
        description = new JTextArea();
        commentaire = new JTextArea();
        
        image.setEditable(false);
        
        debutLabel          = new JLabel("Date de début :");
        finLabel            = new JLabel("Date de fin :");
        reductionLabel      = new JLabel("Reduction :");
        imageLabel          = new JLabel("Illustration :");
        descriptionLabel    = new JLabel("Description : ");
        commentaireLabel    = new JLabel("Commentaire :");
        
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
                                    .addComponent(debutLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(finLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(reductionLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(imageLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(descriptionLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(commentaireLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(13, 13, 13)
                                .addGroup(bodyPanelLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                    .addComponent(debut, GroupLayout.Alignment.LEADING)
                                    .addComponent(fin, GroupLayout.Alignment.LEADING)
                                    .addComponent(reduction, GroupLayout.Alignment.LEADING)
                                    .addComponent(image, GroupLayout.Alignment.LEADING)
                                    .addComponent(description, GroupLayout.Alignment.LEADING)
                                    .addComponent(commentaire, GroupLayout.Alignment.LEADING))))
                        .addGap(6, 6, 6))))
        );

        bodyPanelLayout.setVerticalGroup(
            bodyPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(bodyPanelLayout.createSequentialGroup()
                .addGroup(bodyPanelLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                    .addComponent(debutLabel)
                    .addComponent(debut, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(bodyPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(finLabel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(fin))
                .addGroup(bodyPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(reductionLabel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(reduction))
                .addGroup(bodyPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(imageLabel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(image))
                .addGroup(bodyPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(descriptionLabel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(description))
                .addGroup(bodyPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(commentaireLabel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(commentaire))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED))
        );
    }

    @Override
    protected String getTitleText() {
        Promotion promotion = getBean();
        
        return promotion.getId() != null 
                ? "Promotion"
                : "Nouvelle promotion";
        
    }

    @Override
    public void bindValues() {
        Promotion promotion = getBean();
        
        debut.setValue(promotion.getDateDebut());
        fin.setValue(promotion.getDateFin());
        reduction.setValue(promotion.getReduction());
        image.setText(promotion.getImage());
        description.setText(promotion.getDescription());
        commentaire.setText(promotion.getCommentaire());
    }

    @Override
    public Promotion constructBean() {
        Promotion promotion = getBean();
        
        promotion.setCommentaire(commentaire.getText());
        promotion.setDescription(description.getText());
        promotion.setImage(image.getText());
        
        promotion.setReduction(reduction.getValue());
        
        if(debut.getValue() != null) {
            Date dDebut = new Date(debut.getValue().getTime());
            promotion.setDateDebut(dDebut);
        }
        
        if(fin.getValue() != null) {
            Date dFin = new Date(fin.getValue().getTime());
            promotion.setDateFin(dFin);
        }
        
        return promotion;
    }

    @Override
    public void reset() {
        debut.setValue(null);
        fin.setValue(null);
        reduction.setValue(null);
        image.setText("");
        description.setText("");
        commentaire.setText("");
    }

}
