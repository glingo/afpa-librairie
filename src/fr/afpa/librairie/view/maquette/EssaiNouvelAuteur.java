package fr.afpa.librairie.view.maquette;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class EssaiNouvelAuteur  {

    public static void main(String[] args) {
        //fenetre + panel
        JFrame fenetre = new JFrame();

        JPanel p = new JPanel();

        p.setBackground(Color.darkGray);
        p.setOpaque(true);

        fenetre.setContentPane(p);

        fenetre.setLayout(null);

        fenetre.setTitle("Nouvel Auteur");
        fenetre.setMinimumSize(new Dimension(320, 290));//configure une dimension minimum
        p.setSize(fenetre.getWidth(), fenetre.getHeight());

        fenetre.setLocationRelativeTo(null);
        fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //Label Titre
        JLabel monTitre = new JLabel();
        monTitre.setBounds((int) (fenetre.getWidth() * .21), 10, 175, 25);
        //monTitre.setBounds(fenetre.getWidth()/8, fenetre.getHeight()/8, 175, 25);

        monTitre.setText("Nouvel Auteur");

        Font fontTitre = new Font("Courier", Font.BOLD, 24);
        monTitre.setForeground(Color.lightGray);

        monTitre.setFont(fontTitre);
        p.add(monTitre);

        //Label Nom
        JLabel labelNom = new JLabel();
        labelNom.setBounds(10, 60, 150, 20);
        labelNom.setText("Nom");
        labelNom.setFont(new Font("Courier", Font.BOLD, 12));
        labelNom.setForeground(Color.lightGray);

        p.add(labelNom);

        //TextField Nom
        JTextField textNom = new JTextField();
        textNom.setBounds(150, 60, (int) (fenetre.getWidth() -150), 20);
        textNom.setFont(new Font("Courier", Font.BOLD, 12));
        textNom.setBackground(Color.gray);
        textNom.setOpaque(true);

        p.add(textNom);

        //////////////////////////////////////
        //Label Prenom
        JLabel labelPrenom = new JLabel();
        labelPrenom.setBounds(10, 85, 150, 20);
        labelPrenom.setText("Prénom");
        labelPrenom.setFont(new Font("Courier", Font.BOLD, 12));
        labelPrenom.setForeground(Color.lightGray);

        p.add(labelPrenom);

        //TextField Prenom
        JTextField textPrenom = new JTextField();
        textPrenom.setBounds(150, 85, (int) (fenetre.getWidth() * .47), 20);
        textPrenom.setFont(new Font("Courier", Font.BOLD, 12));
        textPrenom.setBackground(Color.gray);
        textPrenom.setOpaque(true);

        p.add(textPrenom);

        //////////////////////////////////////
        //Label Date de Naissance
        JLabel labelNaissance = new JLabel();
        labelNaissance.setBounds(10, 110, 150, 20);
        labelNaissance.setText("Date de naissance");
        labelNaissance.setFont(new Font("Courier", Font.BOLD, 12));
        labelNaissance.setForeground(Color.lightGray);

        p.add(labelNaissance);

        //TextField Date de Naissance
        JTextField textNaissance = new JTextField();
        textNaissance.setBounds(150, 110, (int) (fenetre.getWidth() * .47), 20);
        textNaissance.setFont(new Font("Courier", Font.BOLD, 12));
        textNaissance.setBackground(Color.gray);
        textNaissance.setOpaque(true);

        p.add(textNaissance);

        //////////////////////////////////////
        //Label Date de Deces
        JLabel labelDeces = new JLabel();
        labelDeces.setBounds(10, 135, 150, 20);
        labelDeces.setText("Date de décès");
        labelDeces.setFont(new Font("Courier", Font.BOLD, 12));
        labelDeces.setForeground(Color.lightGray);

        p.add(labelDeces);

        //TextField Date de Deces
        JTextField textDeces = new JTextField();
        textDeces.setBounds(150, 135, (int) (fenetre.getWidth() * .47), 20);
        textDeces.setFont(new Font("Courier", Font.BOLD, 12));
        textDeces.setBackground(Color.gray);
        textDeces.setOpaque(true);

        p.add(textDeces);

        //////////////////////////////////////
        JButton saveButton = new JButton();
        saveButton.setBounds(10, 200, 110, 20);
        saveButton.setText("Sauvegarder");
        saveButton.setFont(new Font("Courier", Font.BOLD, 12));
        saveButton.setForeground(Color.darkGray);

        p.add(saveButton);

        //////////////////////////////////////
        JButton cancelButton = new JButton();
        cancelButton.setBounds(190, 200, 110, 20);
        cancelButton.setText("Annuler");
        cancelButton.setFont(new Font("Courier", Font.BOLD, 12));
        cancelButton.setForeground(Color.darkGray);

        p.add(cancelButton);

        fenetre.addComponentListener(new ComponentAdapter() {
            public void componentResized(ComponentEvent e) {
                monTitre.setBounds((int) (fenetre.getWidth() * .21), 10, 175, 25);
                textNom.setBounds(150, 60, (int) (fenetre.getWidth() -170), 20);
                textPrenom.setBounds(150, 85, (int) (fenetre.getWidth() * .47), 20);
                textNaissance.setBounds(150, 110, (int) (fenetre.getWidth() * .47), 20);
                textDeces.setBounds(150, 135, (int) (fenetre.getWidth() * .47), 20);
            }
        });
        fenetre.setVisible(true);
    }
}