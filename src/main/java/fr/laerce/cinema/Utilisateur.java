package fr.laerce.cinema;

import java.util.ArrayList;

public class Utilisateur {
    String nom;
    String mdp;
    ArrayList<String> historique = new ArrayList<String>();
    public Utilisateur(String nom, String mdp){
        this.nom = nom;
        this.mdp = mdp;
}
}
