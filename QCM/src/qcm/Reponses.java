/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qcm;

/**
 *
 * @author rayanmehdi1
 */
public class Reponses {
    private int idQCM, idQuestion, idReponse;
    private String intituleRep;
    private boolean bonneRep;

    public Reponses(int idQCM, int idQuestion, int idReponse, String intituleRep, boolean bonneRep) {
        this.idQCM = idQCM;
        this.idQuestion = idQuestion;
        this.idReponse = idReponse;
        this.intituleRep = intituleRep;
        this.bonneRep = bonneRep;
    }
    
    
    
}
