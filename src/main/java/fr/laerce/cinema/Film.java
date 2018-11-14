package fr.laerce.cinema;


public class Film{
    public Film(int id,String titre, String afficheNom, double note){
        this.id = id;
        this.titre = titre;
        this.afficheNom = afficheNom;
        this.note = note;
    }
    int id;
    String titre;
    String afficheNom;
    double note;
    public String noteString(){
        return String.valueOf(this.note);
    }

    public int getId() {
        return id;
    }

    public String getTitre() {
        return titre;
    }

    public String getAfficheNom() {
        return afficheNom;
    }

    public double getNote() {
        return note;
    }
}