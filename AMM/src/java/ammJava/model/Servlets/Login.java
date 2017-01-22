/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ammJava.model.Servlets;

import ammJava.model.Cliente;
import ammJava.model.Factory.AccountsFactory;
import ammJava.model.Factory.ClienteFactory;
import ammJava.model.Factory.OggettiFactory;
import ammJava.model.Factory.VenditoriFactory;
import ammJava.model.Oggetti;
import ammJava.model.Persona;
import ammJava.model.Venditore;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Macinino
 */
@WebServlet(name = "Login", urlPatterns = {"/Login.htlm"})
public class Login extends HttpServlet {

      /* Costanti necessarie per generare la stringa di connessione */
    private static final String JDBC_DRIVER = "org.apache.derby.jdbc.EmbeddedDriver";
    private static final String DB_CLEAN_PATH = "../../web/WEB-INF/db/ammdb";
    private static final String DB_BUILD_PATH = "WEB-INF/db/ammdb";
    

    @Override 
    public void init(){
        /* Generazione della stringa usata per connettersi al database (path) */
        String dbConnection = "jdbc:derby:" + this.getServletContext().getRealPath("/") + DB_BUILD_PATH;
        try {
            Class.forName(JDBC_DRIVER);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        OggettiFactory.getInstance().setConnectionString(dbConnection);
        VenditoriFactory.getInstance().setConnectionString(dbConnection);
        ClienteFactory.getInstance().setConnectionString(dbConnection);
        AccountsFactory.getInstance().setConnectionString(dbConnection);
    }
    
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
        
        // Creo la sessione
        HttpSession session = request.getSession(true);
        
   
        if(session.getAttribute("utente") == null){

            if(request.getParameter("submit") != null){
                
                String username = request.getParameter("username");
                String password = request.getParameter("pswd");   
                
                // Verifico che siano diverse da null
                if (username != null && password != null ){
                  
                    Cliente buyer = ClienteFactory.getInstance().findAcquirente(username, password);
                    if(buyer != null){
                        session.setAttribute("utente", buyer);
                  
                        ArrayList<Oggetti> listaOggetti = OggettiFactory.getInstance().getListaOggetti();
                        int size = listaOggetti.size();
                        request.setAttribute("listaOggetti", listaOggetti);
                        request.setAttribute("size", size);
                        request.getRequestDispatcher("cliente.jsp").forward(request, response);
                    }
                    
              
                    Venditore venditore = VenditoriFactory.getInstance().findVenditore(username, password);
                    if(venditore != null){
              
                        ArrayList<Oggetti> listaOggetti = OggettiFactory.getInstance().getObjSellByVenditore(venditore.getId());
                        session.setAttribute("utente", venditore);
                        request.setAttribute("listaOggetti", listaOggetti);
                        
                        /* Se la lista è null significa che l'utente non ha oggetti in vendita, lo memorizzo così non gli
                           mostro le funzionalità di modifica e eliminazione nella jsp*/
                        if(listaOggetti != null)
                            request.setAttribute("listaSize", listaOggetti.size());
                        else
                            request.setAttribute("listaSize", 0);  
                        request.getRequestDispatcher("venditore.jsp").forward(request, response);
                    }
                    
                 
                    request.setAttribute("errore", true);
                    request.getRequestDispatcher("login.jsp").forward(request, response);   
                    
                }
            
                else{
                    request.setAttribute("errore", true);
                    request.getRequestDispatcher("login.jsp").forward(request, response);   
                }
            }
            // Richiamo la jsp per il login
            request.getRequestDispatcher("Login.jsp").forward(request, response);    
        }
 
        else{
                if((Persona)session.getAttribute("utente") instanceof Venditore){
                    int id = ((Persona)session.getAttribute("utente")).getId();
                    ArrayList<Oggetti> listaOggetti = OggettiFactory.getInstance().getObjSellByVenditore(id);
                    request.setAttribute("listaOggetti", listaOggetti);
                    if(listaOggetti != null)
                            request.setAttribute("listaSize", listaOggetti.size());
                        else
                            request.setAttribute("listaSize", 0); 
                    request.getRequestDispatcher("venditore.jsp").forward(request, response);
                }
     
                else{
                    ArrayList<Oggetti> listaOggetti = OggettiFactory.getInstance().getListaOggetti();
                    int size = listaOggetti.size();
                    request.setAttribute("listaOggetti", listaOggetti);
                    request.setAttribute("size", size);
                    request.getRequestDispatcher("cliente.jsp").forward(request, response);
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
