package servlets;

import beans.BeanArticle;
import beans.BeanPanier;
import dao.SelectArticle;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

@WebServlet(name = "ServletAccueil", urlPatterns = {"/accueil"})
public class ServletAccueil extends HttpServlet {
   
    private static final String ATTRIBUT_COMMANDE = "commande";
    private static final String ATTRIBUT_CLIENT = "client";
    private static final String ATTRIBUT_DEVANTURE = "devanture";
    
    private String vueAccueil;
    private String vueCompteurPanier;
    private String vueDetailsPanier;
    private String vueLogIn;
    
    private Cookie getCookie(Cookie[] cookies, String name) {
      if (cookies != null) {
          for (Cookie c : cookies) {
              if (c.getName().equals(name)) {
                  return c;
              }
          }
      }
      return null;
    }
   
    
    
    public ServletAccueil(){
        vueAccueil  = "/WEB-INF/views/accueil.jsp";
        vueCompteurPanier = "/WEB-INF/views/compteurPanier.jsp";
        vueDetailsPanier = "/WEB-INF/views/panier.jsp";
        vueLogIn = "/WEB-INF/views/logIn.jsp";
    }
    
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     * @throws java.sql.SQLException
     */
    
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        
        String url = vueAccueil;
        
            /*Démarrage session*/
            HttpSession session = request.getSession();
           
            /*request.getParameter("div")*/
            String div = request.getParameter("div");
            
            /*request.getParameter("vue")*/
            String vue = request.getParameter("vue");

            /*request.getParameter("actionPaiement")*/
            String actionPaiement = request.getParameter("actionPaiement");
            
            /*request.getParameter("auto")*/
            String rechercheAuto = request.getParameter("auto");
            
            /*Affichage de 5 livres en devanture*/
            SelectArticle selectArticle = new SelectArticle();
            Map<String, BeanArticle> contenuDevanture = selectArticle.afficherDevanture();
            request.setAttribute(ATTRIBUT_DEVANTURE, contenuDevanture.values());         
            
            if ("panier".equals(div)) {
               BeanPanier panier = (BeanPanier) session.getAttribute("panier");
                if( panier == null) {
                    panier = new BeanPanier();
                    session.setAttribute("panier", panier);
                }

                if( request.getParameter("add")!= null){
                     panier.inc(request.getParameter("add"));
                }

                if( request.getParameter("inc")!= null){
                     panier.inc(request.getParameter("inc"));
                }

                if( request.getParameter("dec")!= null){
                     panier.dec(request.getParameter("dec"));
                }

                if( request.getParameter("del")!= null){
                     panier.del(request.getParameter("del"));
                }

                if( request.getParameter("clear")!= null){
                     panier.clear();
                }
        }
        
        /*Appel de la même page avec des paramètres GET supplémentaires =>
            rafraichissement de page automatique*/ 
        if("compteurPanier".equals(div)){
            url = vueCompteurPanier;   
            BeanPanier panier = (BeanPanier) session.getAttribute("panier");
            if (panier == null){
                panier = new BeanPanier();
                session.setAttribute("compteurPanier", panier);
            }
            request.setAttribute("isEmpty", panier.isEmpty());
            request.setAttribute("compteurPanier", panier.list().size());
        }
        
        if("detailsPanier".equals(vue)){
            url = vueDetailsPanier;   
            BeanPanier panier = (BeanPanier) session.getAttribute("panier");
            if (panier == null){
                panier = new BeanPanier();
                request.setAttribute("detailsPanier", panier);
            }
            request.setAttribute("isEmpty", panier.isEmpty());
            request.setAttribute("detailsPanier", panier.list());
        }
        
        
        if("OK".equals(actionPaiement)){
            url = vueLogIn; 
        }
        request.getRequestDispatcher(url).include(request, response);
        
        if("ON".equals(rechercheAuto)){
            System.out.println("TESTOK");
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
            Logger.getLogger(ServletAccueil.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(ServletAccueil.class.getName()).log(Level.SEVERE, null, ex);
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
