/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qcm;

import Utilitaires.Bouton;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author p1402081
 */
public class PanelCreationQuestion extends JPanel{
    private final JPanel pano_QR;
    private final JPanel bandeau_bas;
    private final JPanel panelCard;
    private final int nbQuestion;
    
    public PanelCreationQuestion(final JPanel panelCard,int compteur) {
        nbQuestion=compteur;
        this.panelCard=panelCard;
        pano_QR=new JPanel();
        JPanel list_panel=new JPanel();
        list_panel.setPreferredSize(new Dimension(250,400));
        list_panel.setLayout(new BorderLayout());
        JList list_question = new JList();
        Bouton supprimer_bout=new Bouton("Supprimer");
        supprimer_bout.setFont(new Font("Arial",0,20));
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
        Bouton valider=new Bouton("valider le QCM");
        
        //repartition des composants
        
        //pour le panel list
        list_panel.add(supprimer_bout,BorderLayout.SOUTH);
        list_panel.add(list_question,BorderLayout.NORTH);
        supprimer_bout.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            
            }
         });
        //pour les questions/reponses
        pano_QR.setBackground(Color.white);
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
                 update();
             }
         });
        valider.addActionListener(new ActionListener() {
             @Override public void actionPerformed(ActionEvent e){
                  CardLayout cl = (CardLayout)(panelCard.getLayout());
                  cl.show( panelCard, "QCM");
             }
         });
        bandeau_bas=new JPanel();
        bandeau_bas.setLayout(new GridBagLayout());
        cont.gridx=0;
        cont.gridy=0;
        bandeau_bas.add(suivant_bout,cont);
        cont.gridy=0;
        cont.gridx=1;
        bandeau_bas.setBackground(Color.darkGray);
        bandeau_bas.setPreferredSize(new Dimension(1400,200));
        bandeau_bas.setMinimumSize(new Dimension(1400,200));
        bandeau_bas.add(valider,cont);
        
        //general
        this.setLayout(new BorderLayout());
        this.add(list_panel,BorderLayout.WEST);
        this.add(pano_QR,BorderLayout.CENTER);
        this.add(bandeau_bas,BorderLayout.SOUTH);
    }
    
    
    private void update(){  
        panelCard.add(new PanelCreationQuestion(panelCard,nbQuestion+1),"Question"+nbQuestion+1);
        CardLayout cl = (CardLayout)(panelCard.getLayout());
        cl.show( panelCard, "Question"+nbQuestion);
    }
    
}
