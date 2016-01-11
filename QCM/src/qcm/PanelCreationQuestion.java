/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qcm;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JPanel;

/**
 *
 * @author p1402081
 */
public class PanelCreationQuestion extends JPanel{

//    public PanelCreationQuestion() {
//        JPanel pano_QR=new JPanel();
//        JPanel list_panel=new JPanel();
//        list_panel.setLayout(new BorderLayout());
//        JList list_question = new JList();
//        JButton supprimer_bout=new JButton("Supprimer");
//        JLabel titre=new JLabel("Creer une question");
//        ArrayList<JLabel> reponses_label=new ArrayList<>();
//        ArrayList<JTextField> reponses_text=new ArrayList<>();
//        ArrayList<JCheckBox> checksBoxs=new ArrayList<>();
//        ArrayList<JLabel> vrai_labels=new ArrayList<>();
//        for(int i=0;i<4;i++){
//            reponses_text.add(new JTextField());
//            reponses_label.add(new JLabel("Response"+(i+1)));
//            checksBoxs.add(new JCheckBox());
//            vrai_labels.add(new JLabel());
//        }
//        JLabel question_label=new JLabel("Question");
//        JTextArea question_text=new JTextArea();
//        question_text.setLineWrap(true);
//        
//        Bouton suivant_bout= new Bouton("Ajouter une question");
//        suivant_bout.setPreferredSize(new Dimension(200,80));
//        Bouton valider=new Bouton("valdier le QCM");
//        valider.setOpaque(false);
//        valider.setForeground(new Color(250,90,0));
//        valider.setPreferredSize(new Dimension(300,100));
//        
//        //repartition des composants
//        
//        //pour le panel list
//        list_panel.add(supprimer_bout,BorderLayout.SOUTH);
//        list_panel.add(list_question,BorderLayout.NORTH);
//        supprimer_bout.addActionListener(new ActionListener() {
//             @Override public void actionPerformed(ActionEvent e){
//                // on change au pano de depart
//             }
//         });
//        //pour les questions/reponses
//        pano_QR.setLayout(new GridBagLayout());
//        GridBagConstraints cont = new GridBagConstraints();
//        cont.gridx=0;
//        cont.gridy=0;
//        pano_QR.add(titre,cont);
//        cont.gridy=1;
//        pano_QR.add(question_label,cont);
//        cont.gridx=1;
//        pano_QR.add(question_text,cont);
//        cont.gridx=0;
//        for(int i=0;i<4;i++){
//            pano_QR.add(reponses_label.get(i),cont);
//            cont.gridy++;
//        }
//        cont.gridx=1;
//        cont.gridy=1;
//        for(int i=0;i<4;i++){
//            pano_QR.add(reponses_text.get(i),cont);
//            cont.gridy++;
//        }
//        cont.gridx=2;
//        cont.gridy=1;
//        for(int i=0;i<4;i++){
//            pano_QR.add(checksBoxs.get(i),cont);
//            cont.gridy++;
//        }
//        
//        cont.gridx=3;
//        cont.gridy=1;
//        for(int i=0;i<4;i++){
//            pano_QR.add(vrai_labels.get(i),cont);
//            cont.gridy++;
//        }
//        //pour le bandeau
//        suivant_bout.addActionListener(new ActionListener() {
//             @Override public void actionPerformed(ActionEvent e){
//                // on change de pano
//                pano1.removeAll();
//                bandeau_bas.removeAll();
//                professeurCreationQuestion();
//             }
//         });
//        bandeau_bas.setLayout(new BorderLayout());
//        bandeau_bas.add(suivant_bout,BorderLayout.CENTER);
//        bandeau_bas.add(valider,BorderLayout.EAST);
//        bandeau_bas.updateUI();
//        
//        //general
//        pano1.setLayout(new BorderLayout());
//        pano1.add(pano_QR,BorderLayout.CENTER);
//        pano1.add(list_panel,BorderLayout.WEST);
//        pano1.updateUI();
//    }
    
}
