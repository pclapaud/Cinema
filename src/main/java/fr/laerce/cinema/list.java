package fr.laerce.cinema;


import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@WebServlet(name = "list")
public class list extends HttpServlet {


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {




    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Récupération du nom de l'affiche dans le système de fichiers

        PrintWriter out = response.getWriter();
        FilmsDonnees fd = new FilmsDonnees();
//        List<Film> lesFilmsLocal = new ArrayList<>();
//        int compteur = 0;
//        for (Film film:fd.lesFilms)
//            for (Film filmL:lesFilmsLocal
//                 ) {
//                if (film.titre.compareTo(filmL.titre)<0){
//                    lesFilmsLocal.add(fd.lesFilms.get(compteur));
//
//            }
//            else {
//                    lesFilmsLocal.add(fd.lesFilms.get(compteur-1));
//                }
//            compteur++;
//        }
//        out.print("<ul>");
//        for (Film film:lesFilmsLocal) {
//            out.print("<li><a href='/affiche?id="+film.id+"'>"+film.titre+"</a></li>");
//        }
        out.print("<body>");
        out.print("<ul>");
        for (Film film:fd.lesFilms) {
            out.print("<li><a href='/affiche?id="+film.id+"'>"+film.titre+"</a></li>");
        }
        out.print("</ul>");
        out.print("</body>");

    }
}
