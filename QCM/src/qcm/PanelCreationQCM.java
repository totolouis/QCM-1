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
import javax.swing.BorderFactory;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import sun.font.CreatedFontTracker;

/**
 *
 * @author p1402081
 */
public class PanelCreationQCM extends JPanel{   
    private final JPanel Principale;
    private final JPanel bandeau_bas;
    private final JPanel panelCard;
    public PanelCreationQCM(JPanel panelCard) {
        this.panelCard=panelCard;
        Principale=new JPanel();
        Principale.setLayout(new GridBagLayout());
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
        JPanel panoNorth = new JPanel();
        panoNorth.setBackground(Color.white);
        panoNorth.add(titre);
        Principale.setBackground(Color.white);
        cont.gridy=0;
        Principale.add(matiere_lab,cont);
        
        cont.gridy=1;
        Principale.add(matiere_list,cont);
        
        cont.gridy=2;
        Principale.add(titre_lab,cont);
        
        cont.gridy=3;        
        Principale.add(list,cont);
        
        bandeau_bas=new JPanel();
        cont.gridy=2;
        bandeau_bas.setBackground(Color.darkGray);
        bandeau_bas.setLayout(new GridBagLayout());
        bandeau_bas.setPreferredSize(new Dimension(1400,200));
        bandeau_bas.add(suivant_bout,cont);
        cont.gridy=5;
        cont.gridwidth=2;
        this.setLayout(new BorderLayout());
        this.add(panoNorth,BorderLayout.NORTH);
        this.add(Principale,BorderLayout.CENTER);
        this.add(bandeau_bas,BorderLayout.SOUTH);
        suivant_bout.addActionListener(new ActionListener() {
             @Override public void actionPerformed(ActionEvent e){
                // on change de pano
                 update();
             }
         });
    }
    private void update(){  
        panelCard.add(new PanelCreationQuestion(panelCard,0),"Question");
        CardLayout cl = (CardLayout)(panelCard.getLayout());
        cl.show( panelCard, "Question");
    }
}
