/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package amm_java_files;

import amm_java_files.Factories.OggettiFactory;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Filippo Boi
 */

@WebServlet(name = "FilterServlet", urlPatterns = {"/filter.json"})
public class FilterServlet extends HttpServlet {

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
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        HttpSession session = request.getSession(false);
        
        if(session == null){
           request.setAttribute("utente", "Cliente");

           request.getRequestDispatcher("accessoNegato.jsp").forward(request, response);
        }
        
            if(((Persona)session.getAttribute("utente") instanceof Cliente) || session.getAttribute("utente") == null){
            request.setAttribute("utente", "Cliente");
            request.getRequestDispatcher("accessoNegato.jsp").forward(request, response);
        }
        
        String command = request.getParameter("cmd");
        if (command != null) 
        {
              if (command.equals("search") && request.getParameter("q")!=null ) 
            {
                  ArrayList<Oggetti> listaOggetti = OggettiFactory.getInstance().getOggettiSellListByPattern(request.getParameter("q"));
                    request.setAttribute("listaOggetti", listaOggetti);
                
                  response.setContentType("application/json");
                response.setHeader("Expires", "Sat, 6 May 1995 12:00:00 GMT");
                response.setHeader("Cache-Control", "no-store, no-cache, "
                        + "must-revalidate");
                  request.getRequestDispatcher("listaObjJson.jsp").
                        forward(request, response);
            }
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
        processRequest(request, response);
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
        processRequest(request, response);
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
