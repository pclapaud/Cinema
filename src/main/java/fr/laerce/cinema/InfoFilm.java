package fr.laerce.cinema;


import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class InfoFilm extends HttpServlet {


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer id = Integer.parseInt(request.getPathInfo().substring(1));
        PrintWriter out = response.getWriter();
        FilmsDonnees fd = new FilmsDonnees();
        Film film = fd.getById(id);
        request.setAttribute ("film", film);
        request.setAttribute ("connecté",false);

        //Historique
        HttpSession session = request.getSession();
        if(session.getAttribute("connecté")!=null){
            if ((Boolean)session.getAttribute("connecté")==true){
                Utilisateur u = (Utilisateur) session.getAttribute("utilisateur");
                u.historique.add(film.titre);
                request.setAttribute ("connecté",true);
            }

        }
        String jspview = "InfoFilm.jsp";
        getServletConfig().getServletContext()
                .getRequestDispatcher("/WEB-INF/jsp/"+jspview).forward(request, response);


    }
}
