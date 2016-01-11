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
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
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
        JLabel titre=new JLabel("Creer un QCM");
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
        suivant_bout.addActionListener(new ActionListener() {
             @Override public void actionPerformed(ActionEvent e){
                // on change de pano
                pano1.removeAll();
                bandeau_bas.removeAll();
                professeurCreationQuestion();
             }
         });
    }
    
    public void professeurCreationQuestion(){
        //initialisation des composants
        JPanel pano_QR=new JPanel();
        JPanel list_panel=new JPanel();
        list_panel.setLayout(new BorderLayout());
        JList list_question = new JList();
        JButton supprimer_bout=new JButton("Supprimer");
        JLabel titre=new JLabel("Creer une question");
        ArrayList<JLabel> reponses_label=new ArrayList<>();
        ArrayList<JTextField> reponses_text=new ArrayList<>();
        ArrayList<JCheckBox> checksBoxs=new ArrayList<>();
        ArrayList<JLabel> vrai_labels=new ArrayList<>();
        for(int i=0;i<4;i++){
            reponses_text.add(new JTextField());
            reponses_label.add(new JLabel("Response"+(i+1)));
            checksBoxs.add(new JCheckBox());
            vrai_labels.add(new JLabel());
        }
        JLabel question_label=new JLabel("Question");
        JTextArea question_text=new JTextArea();
        question_text.setLineWrap(true);
        
        Bouton suivant_bout= new Bouton("Ajouter une question");
        suivant_bout.setPreferredSize(new Dimension(200,80));
        Bouton valider=new Bouton("valdier le QCM");
        valider.setOpaque(false);
        valider.setForeground(new Color(250,90,0));
        valider.setPreferredSize(new Dimension(300,100));
        
        //repartition des composants
        
        //pour le panel list
        list_panel.add(supprimer_bout,BorderLayout.SOUTH);
        list_panel.add(list_question,BorderLayout.NORTH);
        supprimer_bout.addActionListener(new ActionListener() {
             @Override public void actionPerformed(ActionEvent e){
                // on change au pano de depart
             }
         });
        //pour les questions/reponses
        pano_QR.setLayout(new GridBagLayout());
        GridBagConstraints cont = new GridBagConstraints();
        cont.gridx=0;
        cont.gridy=0;
        pano_QR.add(titre,cont);
        cont.gridy=1;
        pano_QR.add(question_label,cont);
        cont.gridx=1;
        pano_QR.add(question_text,cont);
        cont.gridx=0;
        for(int i=0;i<4;i++){
            pano_QR.add(reponses_label.get(i),cont);
            cont.gridy++;
        }
        cont.gridx=1;
        cont.gridy=1;
        for(int i=0;i<4;i++){
            pano_QR.add(reponses_text.get(i),cont);
            cont.gridy++;
        }
        cont.gridx=2;
        cont.gridy=1;
        for(int i=0;i<4;i++){
            pano_QR.add(checksBoxs.get(i),cont);
            cont.gridy++;
        }
        
        cont.gridx=3;
        cont.gridy=1;
        for(int i=0;i<4;i++){
            pano_QR.add(vrai_labels.get(i),cont);
            cont.gridy++;
        }
        //pour le bandeau
        suivant_bout.addActionListener(new ActionListener() {
             @Override public void actionPerformed(ActionEvent e){
                // on change de pano
                pano1.removeAll();
                bandeau_bas.removeAll();
                professeurCreationQuestion();
             }
         });
        bandeau_bas.setLayout(new BorderLayout());
        bandeau_bas.add(suivant_bout,BorderLayout.CENTER);
        bandeau_bas.add(valider,BorderLayout.EAST);
        bandeau_bas.updateUI();
        
        //general
        pano1.setLayout(new BorderLayout());
        pano1.add(pano_QR,BorderLayout.CENTER);
        pano1.add(list_panel,BorderLayout.WEST);
        pano1.updateUI();
    }
    
    public void etudiant(){
        JLabel lab = new JLabel("Choisir une matière :");
        Bouton suivant_bout= new Bouton("SUIVANT");
        Bouton math = new Bouton ("Mathématiques");
        Bouton francais = new Bouton ("Français");
        Bouton anglais = new Bouton ("Anglais");
        Bouton sport = new Bouton ("Sport");
        Bouton prog = new Bouton ("Programmation");
        
        lab.setFont(new Font("Century bold", 0, 60));
        lab.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY));
        
        GridBagConstraints cont = new GridBagConstraints();
        
        cont.gridy=0;
        cont.gridx=0;
        pano1.add(lab, cont);
        cont.gridy=1;
        pano1.add(math, cont);
        cont.gridx=1;
        pano1.add(francais, cont);
        cont.gridx=2;
        pano1.add(anglais, cont);
        cont.gridx=3;
        pano1.add(sport, cont);
        cont.gridy=2;
        cont.gridx=0;
        pano1.add(prog, cont);
        bandeau_bas.updateUI();
        pano1.updateUI();
        
        math.addActionListener(new ActionListener() {
            @Override public void actionPerformed(ActionEvent e){
                
            }
        });
    }
}

