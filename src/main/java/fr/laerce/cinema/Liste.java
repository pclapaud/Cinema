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

public class Liste extends HttpServlet {


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        PrintWriter out = response.getWriter();
        FilmsDonnees fd = new FilmsDonnees();
        ArrayList<Film> mesfilm = new ArrayList<>();


        for (Film film:fd.lesFilms) {
            if (film.titre.toLowerCase().contains(name.toLowerCase())){
            mesfilm.add(film);
            }
        }
        request.setAttribute ("mesfilm", mesfilm);
        String jspview = "liste.jsp";
        getServletConfig().getServletContext()
                .getRequestDispatcher("/WEB-INF/jsp/"+jspview).forward(request, response);




    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        PrintWriter out = response.getWriter();
        FilmsDonnees fd = new FilmsDonnees();
        ArrayList<Film> mesfilm = new ArrayList<>();
        Collections.sort(fd.lesFilms, (o1, o2) -> o1.titre.compareToIgnoreCase(o2.titre));
        if(name.equals("NC")){
            Collections.sort(fd.lesFilms, (o1, o2) -> o1.noteString().compareToIgnoreCase(o2.noteString()));
        }

        if(name.equals("ND")){
            Collections.sort(fd.lesFilms, (o1, o2) -> o2.noteString().compareToIgnoreCase(o1.noteString()));
        }
        if(name.equals("NOMD")){
            Collections.sort(fd.lesFilms, (o1, o2) -> o2.titre.compareToIgnoreCase(o1.titre));

        }

        for (Film film:fd.lesFilms) {
            mesfilm.add(film);
        }
        request.setAttribute ("mesfilm", mesfilm);
        String jspview = "liste.jsp";
        getServletConfig().getServletContext()
                .getRequestDispatcher("/WEB-INF/jsp/"+jspview).forward(request, response);

    }
}
