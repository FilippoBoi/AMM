/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ammJava.model.Servlets;

import ammJava.model.Cliente;
import ammJava.model.Factory.OggettiFactory;
import ammJava.model.Oggetti;
import ammJava.model.Persona;
import java.io.IOException;
import java.io.PrintWriter;
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
@WebServlet(name = "Venditore", urlPatterns = {"/Venditore.htlm"})
public class Venditore extends HttpServlet {

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
           request.setAttribute("utente", "Venditore");
           //response.setStatus(403);
           request.getRequestDispatcher("accessoNegato.jsp").forward(request, response);
        }
        // Se l'utente è un cliente non può accedere a questa pagina
        if(((Persona)session.getAttribute("utente") instanceof Cliente) || session.getAttribute("utente") == null){
            request.setAttribute("utente", "Venditore");
            request.getRequestDispatcher("accessoNegato.jsp").forward(request, response);
        }
        
       

        if(request.getParameter("aggiungi") != null){
      
                    
                Oggetti nuovoOgg = new Oggetti();
                int quantita = 0;
                double prezzo = 0.0;
                
                boolean controllo = true;
                   
       
                if(!(request.getParameter("nomeoggetto").equals("")) && request.getParameter("nomeoggetto")!= null){
                    nuovoOgg.setNomeOggetto(request.getParameter("nomeOggetto")); 
                }else
                    controllo = false;
                    
                if(!(request.getParameter("descrizione").equals("")) && request.getParameter("descrizione") != null){
                    nuovoOgg.setDescrizione(request.getParameter("descrizione"));
                }else
                    controllo = false;
                   
                if(!(request.getParameter("imageUrl").equals("")) && request.getParameter("imageUrl") != null){
                    nuovoOgg.setindirizzoImg(request.getParameter("imageUrl"));
                }else
                    controllo = false;
                   
                try{
                    quantita = Integer.parseInt(request.getParameter("quantita"));
                }catch(RuntimeException e){
                    controllo = false;
                }
                   
                try{
                    prezzo = Double.parseDouble(request.getParameter("prezzo"));
                }catch(RuntimeException e){
                    controllo = false;
                }
                   
                if(quantita > 0 )
                    nuovoOgg.setQuantita(quantita);
                else
                    controllo = false;
                   
                if(prezzo > 0 )
                    nuovoOgg.setPrezzoUnita(prezzo); 
                else
                    controllo = false;
                   
                // Se controllo è ancora true i campi sono stati tutti validati e posso inserire l'oggetto
                if(controllo == true){
                    nuovoOgg.setidVenditore(((Persona)session.getAttribute("utente")).getId());
                    if(OggettiFactory.getInstance().InserisciOggetto(nuovoOgg)) 
                            {
                        request.setAttribute("oggetto", nuovoOgg);
                        request.setAttribute("conferma", true);
                    }
                    else{ 
                        request.setAttribute("errore", true);
                        request.setAttribute("messaggioErrore", "L'oggetto non è stato inserito correttamente, riprova!");
                        int id = ((Persona)session.getAttribute("utente")).getId();
                        ArrayList<Oggetti> listaOggetti = OggettiFactory.getInstance().getObjSellByVenditore(id); 
                        request.setAttribute("listaOggetti", listaOggetti);
                        if(listaOggetti != null)
                            request.setAttribute("listaSize", listaOggetti.size());
                        else
                            request.setAttribute("listaSize", 0); 
                        request.getRequestDispatcher("venditore.jsp").forward(request, response);
                        }
                } // In caso contario mostrerò un messaggio per avvertire l'utente dell'errore
                else{
                    request.setAttribute("errore", true);
                    request.setAttribute("messaggioErrore", "L'oggetto non è stato inserito correttamente, riprova!");
                    int id = ((Persona)session.getAttribute("utente")).getId();
                    ArrayList<Oggetti> listaOggetti = OggettiFactory.getInstance().getObjSellByVenditore(id);
                    request.setAttribute("listaOggetti", listaOggetti);
                    if(listaOggetti != null)
                        request.setAttribute("listaSize", listaOggetti.size());
                    else
                        request.setAttribute("listaSize", 0); 
                    request.getRequestDispatcher("venditore.jsp").forward(request, response);
                }
                   
                request.setAttribute("utente", "venditore");
                request.getRequestDispatcher("riepilogo.jsp").forward(request, response);
        }
           
        /* Se la condizione è vera significa che l'utente ha inviato i dati relativi alla modifica di un 
           oggetto in vendita. Quindi devo gestirli in modo appropriato. */
        if(request.getParameter("modifica") != null){
                int idOggetto = 0;
               
                /* Devo verificare per prima cosa che il venditore abbia selezionato un oggetto valido e non la 
                   voce "nuovo", se la selezione è erratta lo avviso con un messaggio di errore */
                try{
                    idOggetto = Integer.parseInt(request.getParameter("idOggetto"));
                }catch(RuntimeException e){
                    request.setAttribute("errore", true);
                    request.setAttribute("messaggioErrore", "Errore nella selezione dell'oggetto da modificare. Scegli un oggetto valido.");
                    int id = ((Persona)session.getAttribute("utente")).getId();
                    ArrayList<Oggetti> listaOggetti = OggettiFactory.getInstance().getObjSellByVenditore(id);
                    request.setAttribute("listaOggetti", listaOggetti);
                    if(listaOggetti != null)
                        request.setAttribute("listaSize", listaOggetti.size());
                    else
                        request.setAttribute("listaSize", 0); 
                    request.getRequestDispatcher("venditore.jsp").forward(request, response);
                }
                    
                // Recupero il veicolo selezionato dal suo id
                Oggetti oggetto = OggettiFactory.getInstance().getObjSellByID(idOggetto);
                /* Conto quanti campi sono stati compilati per la modifica */
                int numeroCampi = 0; 
                // Variabile usata per controllare i campi inviati dal venditore
                boolean controllo = true;   
                    
                /* Modifico solo i campi compilati dal venditore, se validi, altrimenti i vecchi rimangono invariati */
                if(!(request.getParameter("nomeoggetto").equals("")) && request.getParameter("nomeoggetto")!= null){
                    oggetto.setNomeOggetto(request.getParameter("nomeoggetto"));
                    numeroCampi++;
                }
                    
                if(!(request.getParameter("descrizione").equals("")) && request.getParameter("descrizione") != null){
                    oggetto.setDescrizione(request.getParameter("descrizione"));
                    numeroCampi++;
                }
                  
                if(!(request.getParameter("urlimmagine").equals("")) && request.getParameter("urlimmagine") != null){
                    oggetto.setindirizzoImg(request.getParameter("urlimmagine"));
                    numeroCampi++;
                }
                  
                if(!(request.getParameter("quantita").equals("")) && request.getParameter("quantita") != null){
                    try{
                        int quantita = Integer.parseInt(request.getParameter("quantita"));
                        if(quantita > 0 ){
                            oggetto.setQuantita(quantita);
                            numeroCampi++;
                        }
                        else 
                            controllo = false;
                    }catch(RuntimeException e){
                        controllo = false;
                    }
                }
                    
                if(!(request.getParameter("prezzo").equals("")) && request.getParameter("prezzo") != null){
                    try{
                        double prezzo = Double.parseDouble(request.getParameter("prezzo"));
                        if(prezzo > 0 ){
                            oggetto.setPrezzoUnita(prezzo);
                            numeroCampi++;
                        }
                        else
                            controllo = false;
                        if(controllo ==false)throw new NullPointerException();
                    }catch(RuntimeException e){
                        controllo = false;
                    }
                }
                    
                /* Se non ha compilato nemmeno un campo non lo rimando nemmeno al riepilogo e l'avviso del fatto
                   che non è stata eseguita nessuna modifica */
                if(numeroCampi == 0){
                    int id = ((Persona)session.getAttribute("utente")).getId();
                    ArrayList<Oggetti> listaOggetti = OggettiFactory.getInstance().getObjSellByVenditore(id); 
                    request.setAttribute("listaOggetti", listaOggetti);
                    request.setAttribute("modifica", false);
                    if(listaOggetti != null)
                        request.setAttribute("listaSize", listaOggetti.size());
                    else
                        request.setAttribute("listaSize", 0); 
                    request.getRequestDispatcher("venditore.jsp").forward(request, response);
                }
                    
                // Se controllo è ancora true i campi sono stati tutti validati e posso modificare l'oggetto
                if(controllo == true){
                    oggetto.setidVenditore(((Persona)session.getAttribute("utente")).getId());
                    if(OggettiFactory.getInstance().alterOggetto(oggetto)){
                        request.setAttribute("oggetto", oggetto);
                        request.setAttribute("modifica", true);
                    }
                    else{ 
                        request.setAttribute("modifica", false);
                    } 
                } // In caso contario mostrerò un messaggio per avvertire l'utente dell'errore
                else{
                    request.setAttribute("errore", true);
                    request.setAttribute("messaggioErrore", "L'oggetto non è stato modificato correttamente, riprova!");
                    int id = ((Persona)session.getAttribute("utente")).getId();
                    ArrayList<Oggetti> listaOggetti = OggettiFactory.getInstance().getObjSellByVenditore(id);
                    request.setAttribute("listaOggetti", listaOggetti);
                    if(listaOggetti != null)
                        request.setAttribute("listaSize", listaOggetti.size());
                    else
                        request.setAttribute("listaSize", 0); 
                    request.getRequestDispatcher("venditore.jsp").forward(request, response);
                }
                   
                request.setAttribute("utente", "venditore");
                request.getRequestDispatcher("riepilogo.jsp").forward(request, response);
        }
            
        /* Se la condizione è vera significa che l'utente ha selezionato un oggetto da eliminare */
        if(request.getParameter("elimina") != null){
                int idOggetto = 0;

                try{
                     idOggetto = Integer.parseInt(request.getParameter("idoggetto"));
                }catch(RuntimeException e){
                    request.setAttribute("errore", true);
                    request.setAttribute("messaggioErrore", "Errore nella selezione dell'oggetto da eliminare. Scegli un oggetto valido.");
                    int id = ((Persona)session.getAttribute("utente")).getId();
                    ArrayList<Oggetti> listaOggetti = OggettiFactory.getInstance().getObjSellByVenditore(id);
                    request.setAttribute("listaOggetti", listaOggetti);
                    if(listaOggetti != null)
                        request.setAttribute("listaSize", listaOggetti.size());
                    else
                        request.setAttribute("listaSize", 0); 
                    request.getRequestDispatcher("venditore.jsp").forward(request, response);
                }
                
                if(OggettiFactory.getInstance().eliminaOggetto(idOggetto)){
                    request.setAttribute("elimina", true);
                }else{
                    request.setAttribute("errore", true);
                    request.setAttribute("messaggioErrore", "Errore nell'eliminazione dell'oggetto.");
                }
                
                request.setAttribute("utente", "venditore");
                int id = ((Persona)session.getAttribute("utente")).getId();
                ArrayList<Oggetti> listaOggetti = OggettiFactory.getInstance().getObjSellByVenditore(id);
                request.setAttribute("listaOggetti", listaOggetti);
                if(listaOggetti != null)
                    request.setAttribute("listaSize", listaOggetti.size());
                else
                    request.setAttribute("listaSize", 0); 
                request.getRequestDispatcher("venditore.jsp").forward(request, response);
        }
              

            int id = ((Persona)session.getAttribute("utente")).getId();
            ArrayList<Oggetti> listaOggetti = OggettiFactory.getInstance().getObjSellByVenditore(id);
            request.setAttribute("listaOggetti", listaOggetti);
            if(listaOggetti != null)
                request.setAttribute("listaSize", listaOggetti.size());
            else
                request.setAttribute("listaSize", 0); 
            request.getRequestDispatcher("venditore.jsp").forward(request, response);
        
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
