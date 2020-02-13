package servlets;

import beans.BeanArticle;
import forms.RechercheFormulaire;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "ServletSuggestion", urlPatterns = {"/suggestion"})
public class ServletSuggestion extends HttpServlet {

    private static final String VUE_SUGGESTION = "/WEB-INF/includes/suggestion.jsp";
    private static final String ATTRIBUT_RESULTAT_RECHERCHE_AUTO = "resultatAuto";
    private static final String ATTRIBUT_MESSAGE_AUTO = "messageAuto";

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");

        
        String type = request.getParameter("typeRechercheAuto");
        String recherche = request.getParameter("rechercheAuto");
        
        RechercheFormulaire rechercheForm = new RechercheFormulaire();

        if (type == null) {
            type = "";
        }

        if (recherche == null) {
            recherche = "";
        }

        
        try {
            ArrayList<String> resultatRecherche = rechercheForm.afficherSuggestion(type, recherche);
            request.setAttribute(ATTRIBUT_RESULTAT_RECHERCHE_AUTO, resultatRecherche);
            this.getServletContext().getRequestDispatcher(VUE_SUGGESTION).forward(request, response);
            System.out.println(resultatRecherche);
            System.out.println(VUE_SUGGESTION);
        } catch (ServletException sE) {
            System.out.println(sE.getMessage());
        }
    }

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
            Logger.getLogger(ServletSuggestion.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(ServletSuggestion.class.getName()).log(Level.SEVERE, null, ex);
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

}
