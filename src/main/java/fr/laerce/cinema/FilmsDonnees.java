package fr.laerce.cinema;

import java.util.Arrays;
import java.util.List;

/**
 * Created by fred on 03/02/2016.
 */
public class FilmsDonnees {
    List<Film> lesFilms;

    public FilmsDonnees(){
        lesFilms = Arrays.asList(
                new Film(1,"Le juge et l'assassin","lejugeetlassassin.jpg",3.8),
                new Film(2,"La guerre des étoiles","starwars.jpg",4.4),
                new Film(3,"Pretty woman","prettywoman.jpg",3.5),
                new Film(4,"Légendes d'automne","legendesdautomne.jpg",3.9),
                new Film(5,"E.T. l'extra-terrestre","et.jpg",4.2),
                new Film(6,"BEN-HUR","ben-hur.jpg",4),
                new Film(7,"La jurée","lajuree.jpg",3.1)
        );
    }

    public List<Film> films(){
        return lesFilms;
    }

    public Film getById(int id){
        Film film = null;
        for (Film f: lesFilms
        ) {
            if(f.id == id){
                film = f;
            }
        }
        return film;
    }



}
