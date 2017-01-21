/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package amm_java_files;

/**
 *
 * @author Filippo Boi
 */

import amm_java_files.Factories.ClienteFactory;
import amm_java_files.Factories.VenditoriFactory;
import amm_java_files.Factories.OggettiFactory;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;
import javax.servlet.http.HttpSession;

/**
 *
 * @author selima
 */
/* Servet che risponde alla url cliente.html */
@WebServlet(name = "ClienteServlet", urlPatterns = {"/cliente.html"})
public class ClienteServlet extends HttpServlet {

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
         ArrayList<Oggetti> listaOggetti = null;
        
        // Se la sessione non esiste mostro la jsp di accesso negato
        if(session == null){
           request.setAttribute("utente", "Cliente");
           //response.setStatus(403);
           request.getRequestDispatcher("accessoNegato.jsp").forward(request, response);
        }
        
        if(((Persona)session.getAttribute("utente") instanceof Venditore) || session.getAttribute("utente") == null){
            request.setAttribute("utente", "Cliente");
            request.getRequestDispatcher("accessoNegato.jsp").forward(request, response);
        }
        else{
            
            if( request.getParameter("conferma") != null)
            { 
                    Cliente compratore = (Cliente)session.getAttribute("utente");
                    int id = -1;

                    try{
                      id = Integer.parseInt(request.getParameter("idSel"));
                    }catch(RuntimeException e){
                      request.setAttribute("pagamento", false);
                      request.setAttribute("errore", true); 
                      listaOggetti = OggettiFactory.getInstance().getListaOggetti();
                      request.setAttribute("listaOggetti", listaOggetti);
                      request.getRequestDispatcher("cliente.jsp").forward(request, response);
                    }
                    
                    Oggetti autoSelezionata = OggettiFactory.getInstance().getObjSellByID(id); 
                    
                    if(autoSelezionata == null){
                      request.setAttribute("pagamento", false);
                      request.setAttribute("errore", true); 
                      listaOggetti = OggettiFactory.getInstance().getListaOggetti();
                      request.setAttribute("listaOggetti", listaOggetti);
                      request.getRequestDispatcher("cliente.jsp").forward(request, response);
                    }
                    
                    int idVenditore = autoSelezionata.getIdVenditore();
                    Venditore seller = (Venditore)VenditoriFactory.getInstance().getVenditoreById(idVenditore);

                    request.setAttribute("utente", "cliente");
                    request.setAttribute("oggetto", autoSelezionata);
                    
                    int idAccountBuyer = compratore.getIdConto();
                    int idAccountVenditore = seller.getIdConto();
                    double prezzo = autoSelezionata.getPrezzoUnita();
                    try{
                        if(ClienteFactory.getInstance().transazione(id, idAccountBuyer, idAccountVenditore))
                            request.setAttribute("pagamento", true);
                        else
                            request.setAttribute("pagamento", false);
                    }catch(SQLException e){
                        request.setAttribute("errore", true); 
                        request.setAttribute("pagamento", false);
                    }
                    /* Questo attributo mi serve nella jsp cliente per stampare o meno i messaggi relativi all'esito
                       della transazione */
                    request.setAttribute("conferma", true); 
                    listaOggetti = OggettiFactory.getInstance().getListaOggetti(); 
                    request.setAttribute("listaOggetti", listaOggetti);
                    request.getRequestDispatcher("cliente.jsp").forward(request, response);
            }
            /* Se questa condizione è vera siamo nella fase di selezione del veicolo da acqiustare, è la fase precedente 
               a una eventuale conferma. L'utente ha selezionato un oggetto dalla tabella fornendoci il suo id come parametro*/
            if(request.getParameter("idAuto") != null)
            {
                int idAutoSelezionata = -1;
                
                /* Verifico che l'id sia effettivamente un intero per poter chiamare il metodo parseInt con successo,
                   se così non fosse l'utente malintenzionato viene rispedito alla tabella */
                try{
                  idAutoSelezionata = Integer.parseInt(request.getParameter("idAuto"));
                }catch(RuntimeException e){ 
                  request.setAttribute("errore", true);
                  listaOggetti = OggettiFactory.getInstance().getListaOggetti(); 
                  request.setAttribute("listaOggetti", listaOggetti);
                  request.getRequestDispatcher("cliente.jsp").forward(request, response);
                }
                
                // Risalgo all'oggetto selezionato tramite il suo id
                Oggetti autoSelezionata = OggettiFactory.getInstance().getObjSellByID(idAutoSelezionata);
                
                /* Verifico che l'id passato corrisponda a un oggetto reale. In caso affermativo il cliente viene rimandato
                   a una pagina dove compare il riepilogo dell'oggetto selezionato, dove, se desidera potrà confermare l'acquisto.
                   Altrimenti l'utente viene rimandato alla tabella.
                */
                if(autoSelezionata!=null){
                    // Imposto gli attributi necessari per la jsp del riepilogo
                    request.setAttribute("utente", "cliente");
                    session.setAttribute("autoSelezionata", autoSelezionata);
                    request.setAttribute("oggetto", session.getAttribute("autoSelezionata"));
                    request.getRequestDispatcher("riepilogo.jsp").forward(request, response);
                }
                else{
                    listaOggetti = OggettiFactory.getInstance().getListaOggetti();
                    request.setAttribute("listaOggetti", listaOggetti);
                    request.getRequestDispatcher("cliente.jsp").forward(request, response);
                }
            }
            
            /* In condizioni "normali" passo semplicemente la lista degli oggetti in vendita alla jsp che si occupa di 
               visualizzarli in una tabella */
            listaOggetti = OggettiFactory.getInstance().getListaOggetti(); 
            int size = listaOggetti.size();
            request.setAttribute("listaOggetti", listaOggetti);
            request.setAttribute("size", size);
            request.getRequestDispatcher("cliente.jsp").forward(request, response);
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
