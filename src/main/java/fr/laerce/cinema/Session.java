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
        for (Utilisateur u:todos
        ) {
            if(nom.equals(u.nom) && mdp.equals(u.mdp)){
                connecté=true;
                session.setAttribute("connecté",connecté);
                session.setAttribute("utilisateur",u);
            }
        }

        response.sendRedirect("/session");



    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        HttpSession session = request.getSession();
        Utilisateur u = (Utilisateur) session.getAttribute("utilisateur");
        if (connecté){
            request.setAttribute("historique", u.historique);
            String jspview = "session.jsp";
            getServletConfig().getServletContext()
                    .getRequestDispatcher("/WEB-INF/jsp/" + jspview).forward(request, response);
        }


    }
    public void init() throws ServletException {
        this.todos = new ArrayList<Utilisateur>();
        todos.add(new Utilisateur("bob","123"));
        todos.add(new Utilisateur("fart","123"));
    }
}
