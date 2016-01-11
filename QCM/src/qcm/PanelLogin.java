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
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author p1402081
 */
public class PanelLogin extends JPanel{
    private final JPanel pano1;
    private final JPanel bandeau_bas;
    private final JPanel panelCard;
    
    public PanelLogin(JPanel panelCard) {
        this.panelCard=panelCard;
        this.setPreferredSize(new Dimension(1400,600));
        this.setMinimumSize(new Dimension(1400,600));
        Bouton valider;
        Font f= new Font("Century bold", 0, 50);
        
        final JTextField log_textFiled=new JTextField();
        log_textFiled.setPreferredSize(new Dimension(400,70));
        log_textFiled.setMinimumSize(new Dimension(400,70));
        
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
        
        mdp_textFiled.setMinimumSize(new Dimension(400,70));
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
        pano1.setMinimumSize(new Dimension(1400,600));
        pano1.setBackground(Color.white);
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
                     update();
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
        bandeau_bas.setMinimumSize(new Dimension(1400,200));
        bandeau_bas.setBackground(Color.darkGray);
        this.setLayout(new BorderLayout());
        this.add(pano1,BorderLayout.CENTER);
        this.add(bandeau_bas,BorderLayout.SOUTH);
    }
    
    public void update(){
        panelCard.add(new PanelCreationQCM(panelCard),"QCM");
        CardLayout cl = (CardLayout)(panelCard.getLayout());
        cl.show( panelCard, "QCM");
    }
}
