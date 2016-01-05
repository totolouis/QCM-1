/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utilitaires;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;

/**
 *
 * @author User
 */
public class Bouton extends JButton{
    public Bouton(String s){
        super(s);
        Font f= new Font("Century bold", 0, 50);
        setFont(f);
        setBorderPainted(false);
        setFocusPainted(false);
        setBackground(new Color(250,90,0));
    }
}
