/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ammJava.model.Servlets;

import ammJava.model.Cliente;
import ammJava.model.Factory.ClienteFactory;
import ammJava.model.Factory.OggettiFactory;
import ammJava.model.Factory.VenditoriFactory;
import ammJava.model.Oggetti;
import ammJava.model.Persona;
import ammJava.model.Venditore;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
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
@WebServlet(name = "Cliente", urlPatterns = {"/Cliente"})
public class Acquirente extends HttpServlet {

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
            throws ServletException, IOException 
    {
        response.setContentType("text/html;charset=UTF-8");
        
        HttpSession session = request.getSession(false);
        ArrayList<Oggetti> listaOggetti = null;
        
        if(session == null)
        { 
            request.setAttribute("utente","Cliente");
            request.getRequestDispatcher("accessoNegato.jsp").forward(request, response);
        }
         
        if( ((Persona)session.getAttribute("utente") instanceof Venditore )|| session.getAttribute("utente")==null)
        {
            request.setAttribute("utente","Cliente");
            request.getRequestDispatcher("accessoNegato.jsp").forward(request, response);
        }
        else
        {
            if(request.getParameter("conferma")!=null)
            {
                Cliente compratore = (Cliente)session.getAttribute("utente");
                int id=-1;
                
                try
                {
                    id =Integer.parseInt(request.getParameter("idVenditore"));
                }catch(RuntimeException e )
                {
                    request.setAttribute("pagamento", false);
                    request.setAttribute("errore", true); 
                    listaOggetti = OggettiFactory.getInstance().getListaOggetti();
                    request.setAttribute("listaOggetti", listaOggetti);
                    request.getRequestDispatcher("cliente.jsp").forward(request, response);
                }
                
                Oggetti oggettoSelezionato = OggettiFactory.getInstance().getObjSellByID(id);
                
                if (oggettoSelezionato == null)
                {
                    request.setAttribute("pagamento", false);
                    request.setAttribute("errore", true); 
                    listaOggetti = OggettiFactory.getInstance().getListaOggetti();
                    request.setAttribute("listaOggetti", listaOggetti);
                    request.getRequestDispatcher("cliente.jsp").forward(request, response);
                }
                
                int idVenditore = oggettoSelezionato.getIdVenditore();
                Venditore venditore = (Venditore)VenditoriFactory.getInstance().getVenditoreById(idVenditore);
                request.setAttribute("utente", "Cliente");
                request.setAttribute("oggetto",oggettoSelezionato);
                
                int idCliente = compratore.getIdConto();
                int idvenditore = venditore.getIdConto();
                double prezzo = oggettoSelezionato.getPrezzoUnita();
                
                try
                {
                    if(ClienteFactory.getInstance().transazione(id, idCliente, idvenditore))
                    {
                        request.setAttribute("pagamento", true);
                    }
                    else
                    {
                        request.setAttribute("pagamento", false);
                    }
                }
                catch(SQLException e)
                {
                request.setAttribute("error", true);
                request.setAttribute("pagamento", false);
                }
                
                request.setAttribute("conferma",true);
                listaOggetti= OggettiFactory.getInstance().getListaOggetti();
                request.setAttribute("listaOggetti", listaOggetti);
                request.getRequestDispatcher("cliente.jsp").forward(request, response);
            }
            if(request.getParameter("idOggetto")!=null)
            {
                int idOggettoSelez = -1;
                
                try 
                {
                    idOggettoSelez= Integer.parseInt(request.getParameter("idOggetto"));
                }catch(RuntimeException e)
                {
                    request.setAttribute("errore", true);
                    listaOggetti = OggettiFactory.getInstance().getListaOggetti();
                    request.setAttribute("listaOggetti", listaOggetti);
                    request.getRequestDispatcher("cliente.jsp").forward(request, response);
                }
                
                Oggetti oggettoSelezionato = OggettiFactory.getInstance().getObjSellByID(idOggettoSelez);
                
                if(oggettoSelezionato!=null)
                {
                    request.setAttribute("utente","cliente");
                     session.setAttribute("oggettoSelezionato", oggettoSelezionato);
                    request.setAttribute("oggetto", session.getAttribute("oggettoSelezionato"));
                    request.getRequestDispatcher("riepilogo.jsp").forward(request, response);
                }
                else{
                    listaOggetti = OggettiFactory.getInstance().getListaOggetti(); 
                    request.setAttribute("listaOggetti", listaOggetti);
                    request.getRequestDispatcher("cliente.jsp").forward(request, response);
                }
            }
            
            listaOggetti= OggettiFactory.getInstance().getListaOggetti();
            int size= listaOggetti.size();
            request.setAttribute("listaOggetti", listaOggetti);
            request.setAttribute("size", size);
            request.getRequestDispatcher("cliente").forward(request, response);
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
