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
public class Eleves extends Utilisateur {
    public Eleves(int id, String nom, String prenom, String mdp) {
        this.Id_Utilisateur=id;
        this.nom=nom;
        this.prenom=prenom;
        this.mdp=mdp;
    }
    
}
