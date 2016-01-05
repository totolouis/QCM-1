/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qcm;

import Utilitaires.Bouton;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import javax.swing.BorderFactory;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author p1402081
 */
public class Fenetre_QCM extends JFrame{
    JPanel pano1;
    JPanel bandeau_bas;
    
    public Fenetre_QCM(){
        init();
        this.setTitle("QCM");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.pack();
    }
    public void init(){
        
        Bouton valider;
        Font f= new Font("Century bold", 0, 50);
        
        final JTextField log_textFiled=new JTextField();
        log_textFiled.setPreferredSize(new Dimension(400,70));
        log_textFiled.addFocusListener(new FocusListener() {

            @Override
            public void focusGained(FocusEvent fe) {
                log_textFiled.setBorder(BorderFactory.createLineBorder(new Color(230,150,0)));
            }

            @Override
            public void focusLost(FocusEvent fe) {
                log_textFiled.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
            }
        });
        
        
        log_textFiled.setFont(f);
        final JPasswordField mdp_textFiled=new JPasswordField();
        mdp_textFiled.addFocusListener(new FocusListener() {

            @Override
            public void focusGained(FocusEvent fe) {
                mdp_textFiled.setBorder(BorderFactory.createLineBorder(new Color(230,150,0)));
            }

            @Override
            public void focusLost(FocusEvent fe) {
                mdp_textFiled.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
            }
        });
        mdp_textFiled.setPreferredSize(new Dimension(400,70));
        mdp_textFiled.setFont(f);
        JLabel log_label=new JLabel("Utilisateur");
        
        log_label.setFont(new Font("Century", 0, 50));
        JLabel mdp_label=new JLabel("Mot de passe");
        mdp_label.setFont(new Font("Century", 0, 50));
        pano1=new JPanel();
        pano1.setPreferredSize(new Dimension(1400,600));
        bandeau_bas=new JPanel();
        GridBagConstraints cont = new GridBagConstraints();
        pano1.setLayout(new GridBagLayout());
        //bouton
        
        valider= new Bouton("VALIDER");
        valider.addActionListener(new ActionListener() {
             @Override public void actionPerformed(ActionEvent e){
                 //si les 2 champs sont remplient
                 if(String.valueOf(mdp_textFiled.getPassword()).length()>0 && !log_textFiled.getText().isEmpty()){
                     //alors on change de pano
                     pano1.removeAll();
                     bandeau_bas.removeAll();
                     professeurCreationQCM();
                 }else{
                     System.out.println("mot de passe ou login non rempli");
                 }
             }
         });
        
        pano1.add(log_label,cont);
        cont.gridy=1;
        cont.insets = new Insets(0,0,40,0);
        pano1.add(log_textFiled,cont);
        cont.insets = new Insets(0,0,0,0);
        cont.gridy=2;
        pano1.add(mdp_label,cont);
        cont.gridy=3;
        pano1.add(mdp_textFiled,cont);
        bandeau_bas.setLayout(new GridBagLayout());
        
        cont.gridy=0;
        cont.gridx=0;
        bandeau_bas.add(valider,cont);
        bandeau_bas.setPreferredSize(new Dimension(1400,200));
        bandeau_bas.setBackground(Color.darkGray);
        
        
        this.getContentPane().add(bandeau_bas,BorderLayout.SOUTH);
        this.getContentPane().add(pano1,BorderLayout.CENTER); 
    }
     
    public void professeurCreationQCM(){
        //interface du professeur
        JLabel titre=new JLabel("Creer une question");
        Bouton suivant_bout= new Bouton("SUIVANT");
        JLabel matiere_lab=new JLabel("Matière");
        JLabel titre_lab=new JLabel("Titre");
        JComboBox<String> matiere_list = new JComboBox<>();
        matiere_list.setBorder(null);
        matiere_list.setForeground(new Color(250,90,0));
        
        JTextArea titre_text=new JTextArea();
        titre_text.setLineWrap(true);
        titre_text.setFont(new Font("Century bold", 0, 20));
        JScrollPane list=new JScrollPane(titre_text);
        list.setPreferredSize(new Dimension(400,70));
        GridBagConstraints cont = new GridBagConstraints();
        
        matiere_lab.setFont(new Font("Century", 0, 50));
        titre_lab.setFont(new Font("Century", 0, 50));
        matiere_list.setFont(new Font("Arial", 0, 40));
        matiere_list.setBackground(Color.DARK_GRAY);
        
        matiere_list.addItem("Mathematiques");
        matiere_list.addItem("Anglais");
        matiere_list.addItem("Francais");
        matiere_list.addItem("C++");
        matiere_list.addItem("Sport");
        matiere_list.setPreferredSize(new Dimension(400,50));
        
        titre.setFont(new Font("Century bold", 0, 60));
        titre.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY));
        
        cont.gridy=0;
        cont.insets=new Insets(0, 0, 100, 0);
        pano1.add(titre,cont);
        cont.insets=new Insets(0, 0, 0, 0);
        cont.gridy=1;
        pano1.add(matiere_lab,cont);
        cont.gridy=2;
        pano1.add(matiere_list,cont);
        cont.gridy=3;
        pano1.add(titre_lab,cont);
        cont.gridy=4;
        pano1.add(list,cont);
        bandeau_bas.add(suivant_bout);
        bandeau_bas.updateUI();
        pano1.updateUI();
    }
    
    public void etudiant(){
        
    }
}

