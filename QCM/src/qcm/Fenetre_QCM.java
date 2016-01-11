/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qcm;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JPanel;


/**
 *
 * @author p1402081
 */
public class Fenetre_QCM extends JFrame{
    JPanel panoCard;
    
    public Fenetre_QCM(){
        init();
        this.setTitle("QCM");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.pack();
    }
    public void init(){
        this.setBackground(Color.yellow);
        CardLayout c1=new CardLayout();
        panoCard=new JPanel();
        panoCard.setPreferredSize(new Dimension(1400,600));
        panoCard.setMinimumSize(new Dimension(1400,600));
        panoCard.setLayout(c1);
        panoCard.add(new PanelLogin(panoCard),"Login");
        this.setContentPane(panoCard);
    }
}

