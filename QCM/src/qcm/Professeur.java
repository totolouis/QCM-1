/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qcm;

import Utilitaires.Utilisateur;

/**
 *
 * @author rayanmehdi1
 */
public class Professeur extends Utilisateur {
    private String matiere;

    public Professeur(int id, String nom, String prenom, String mdp, String matiere) {
        this.Id_Utilisateur=id;
        this.nom=nom;
        this.prenom=prenom;
        this.mdp=mdp;
        this.matiere = matiere;
    }

    

    
    
}
