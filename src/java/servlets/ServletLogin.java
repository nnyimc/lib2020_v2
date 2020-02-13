package servlets;

import beans.Utilisateur;
import dao.Connector;
import dao.RegNewUser;
import dao.SelectClient;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "ServletLogin", urlPatterns = {"/servletLogin"})
public class ServletLogin extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        String url = "/WEB-INF/views/logIn.jsp";

        String msg = "";

        HttpSession sessionLog = request.getSession();

        if ("login".equals(request.getParameter("section"))) {//if logIn
            if (request.getParameter("button") != null) {
                String bUser = request.getParameter("username");//recuperer login 
                String bPass = request.getParameter("password");//recupere password
                SelectClient selectClient = new SelectClient();
                if (selectClient.getClient(bUser, bPass) != null) {
                    
                    sessionLog.setAttribute("userLogin",bUser);
                    sessionLog.setAttribute("userPass",bPass);
                    
                    Cookie ck=new Cookie("cookieLog",bUser);
                    ck.setMaxAge(60*60*24);
                    response.addCookie(ck);
                    
                    
                    url = "/WEB-INF/views/bienvenue.jsp";
                    request.setAttribute("msg", bUser);
                } else {
                    url = "/WEB-INF/views/logIn.jsp";
                    request.setAttribute("msg", "Login/Mot de passe inconnu. Ré-essayer!");
                }
            }
        }//if login 
        if ("register".equals(request.getParameter("section"))) {//if registrer
            url = "/WEB-INF/views/register.jsp";
        }
        if (request.getParameter("reg") != null) {
            String rNom = request.getParameter("nom");
            String rPrenom = request.getParameter("prenom");
            String rEmail = request.getParameter("email2");
            String rUser = request.getParameter("username2");//recuperer login 
            String rPass = request.getParameter("password2");
            String rAdrL = request.getParameter("adresseL");
            int adrLiv = Integer.parseInt(rAdrL);
            String rAdrF = request.getParameter("adresseF");
            int adrFac = Integer.parseInt(rAdrF);
            String rSta = request.getParameter("statut");
            int Stat = Integer.parseInt(rSta);

            RegNewUser nUser = new RegNewUser();
            if (nUser.regNewUser(rNom, rPrenom, rEmail, rUser, rPass, adrLiv, adrFac, Stat)) {
                sessionLog.setAttribute("userLogin", rUser);
                sessionLog.setAttribute("userPass", rPass);
                url = "/WEB-INF/views/bienvenue.jsp";
                request.setAttribute("msg", rUser);
            }
            else
            {
            url = "/WEB-INF/views/register.jsp";
            }
        } 
        request.getRequestDispatcher(url).forward(request, response);
    }//main

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(ServletLogin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(ServletLogin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}//class 
