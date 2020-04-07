package servlets;

import beans.BeanArticle;
import forms.RechercheFormulaire;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(value = "ServletRecherche", urlPatterns = {"/recherche"})
public class ServletRecherche extends HttpServlet {

    private static final String VUE_RECHERCHE = "/WEB-INF/views/recherche.jsp";
    private static final String ATTRIBUT_RESULTAT_RECHERCHE = "resultatRecherche";
    private static final String ATTRIBUT_MESSAGE = "message";



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

        RechercheFormulaire rechercheForm = new RechercheFormulaire();

        request.setAttribute("type", request.getParameter("type"));
        request.setAttribute("recherche", request.getParameter("recherche"));

        String type = request.getParameter("type");
        String recherche = request.getParameter("recherche");

        if (type == null) {
            type = "";
        }

        if (recherche == null) {
            recherche = "";
        }

        Map<String, BeanArticle> resultatRecherche = rechercheForm.afficherResultat(type, recherche);
        request.setAttribute(ATTRIBUT_RESULTAT_RECHERCHE, resultatRecherche.values());
        request.setAttribute(ATTRIBUT_MESSAGE, rechercheForm.getMessage());

        try {
            this.getServletContext().getRequestDispatcher(VUE_RECHERCHE).forward(request, response);
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
            Logger.getLogger(ServletRecherche.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(ServletRecherche.class.getName()).log(Level.SEVERE, null, ex);
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
