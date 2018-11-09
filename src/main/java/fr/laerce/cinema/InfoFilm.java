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
        Integer id = Integer.parseInt( request.getParameter("id"));
        PrintWriter out = response.getWriter();
        FilmsDonnees fd = new FilmsDonnees();
        out.print("<body>");
        //Historique
        HttpSession session = request.getSession();
        if(session.getAttribute("connecté")!=null){
            Boolean connecté = (Boolean)session.getAttribute("connecté");
            if (connecté==true){
                Utilisateur u = (Utilisateur) session.getAttribute("utilisateur");
                out.print("<a href='/session'>ma session</a>");

                u.historique.add(fd.getById(id).titre);

            }

        }






        out.print("<ul>");
        out.print("<li>Titre : "+fd.getById(id).titre+"</li>");
        out.print("<li><img height=\"300\" width=\"300\" src=/affiche?id="+fd.getById(id).id+"></li>");
        out.print("<li> Note :"+fd.getById(id).note+"</li>");
        out.print("</ul>");
        out.print("</body>");

    }
}
