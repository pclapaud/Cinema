package fr.laerce.cinema;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class Session extends HttpServlet {
    List<Utilisateur> todos;
    Boolean connecté = false;
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String nom = request.getParameter("nom");
        String mdp = request.getParameter("mdp");
        PrintWriter out = response.getWriter();
        HttpSession session = request.getSession();
        out.println("votre nom : "+todos.get(0).nom);
        for (Utilisateur u:todos
        ) {
            if(nom.equals(u.nom) && mdp.equals(u.mdp)){
                connecté=true;
                session.setAttribute("connecté",connecté);
                session.setAttribute("utilisateur",u);
            }
        }
        out.println("votre statut : "+connecté);
        response.sendRedirect("/session");



    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        HttpSession session = request.getSession();
        Utilisateur u = (Utilisateur) session.getAttribute("utilisateur");
        out.print("<body>");

        if (session.getAttribute("connecté").equals(true)){
            out.println("vous etes connecté : "+u.nom);
        }
        out.print("<br>votre historique:");
        out.println("<ul>");
        for (String nom:u.historique
             ) {
            out.println("<li>"+nom);
        }
        out.println("</ul>");
        out.println("<a href='/index.jsp'>retour</a>");
        out.print("</body>");
    }



    public void init() throws ServletException {
        this.todos = new ArrayList<Utilisateur>();
        todos.add(new Utilisateur("bob","123"));
        todos.add(new Utilisateur("fart","123"));
    }
}
