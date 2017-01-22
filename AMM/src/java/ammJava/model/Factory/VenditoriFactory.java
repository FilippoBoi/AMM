/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ammJava.model.Factory;

/**
 *
 * @author Filippo Boi
 */
import ammJava.model.Venditore;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;


public class VenditoriFactory {
    /* Attributi */
    private static VenditoriFactory singleton;
    String connectionString; 
    
    /** set  e get della la stringa per la connessione al database
     * @param s
     */
    public void setConnectionString(String s){
	this.connectionString = s;
    }
    
    public String getConnectionString(){
            return this.connectionString;
    } 
    
    public static VenditoriFactory getInstance() {
        if (singleton == null) {
            singleton = new VenditoriFactory();
        }
        return singleton;
    }

    private VenditoriFactory() {

    }

     /** Restituisce la lista di tutti i venditori
     */
    public ArrayList<Venditore> getListaVenditori() {
        ArrayList<Venditore> listaVenditori = new ArrayList<>();
        
            try(Connection conn = DriverManager.getConnection(connectionString, "filippoboi", "paperino");
            Statement stmt = conn.createStatement()) {
                 String sql = "SELECT * FROM Venditore";
           
            ResultSet set = stmt.executeQuery(sql);
            while (set.next()) {
                int id = set.getInt("id");
                String nome = set.getString("nome");
                String cognome = set.getString("cognome");
                String username = set.getString("username");
                String password = set.getString("password");
                String mail = set.getString("mail");
                String indirizzo = set.getString("indirizzo");
                int idConto = set.getInt("idConto");
                Venditore seller = new Venditore(id, nome, username, password, mail, cognome, indirizzo, idConto);
                
                listaVenditori.add(seller);
            }
        } catch (SQLException ex) {
             Logger.getLogger(VenditoriFactory.class.getName()).
            log(Level.SEVERE, null, ex);
        }
        
        return listaVenditori;
    }
    
    /** Restiuisce l'utente avente l’identificatore passato per parametro
     * @param id
     *  @return  restiuisce l'utente avente l’identificatore passato per parametro 
     */
    public Venditore getVenditoreById(int id){
          String query = "select * from Venditore where id = ?";
        
            try(Connection conn = DriverManager.getConnection(connectionString, "filippoboi", "paperino");
            PreparedStatement stmt = conn.prepareStatement(query)){
            // Si associano valori e posizioni di placeholder
            stmt.setInt(1, id);
            
            ResultSet set = stmt.executeQuery();
            
            if(set.next()) {
                Venditore seller = new Venditore();
                seller.setId(set.getInt("id"));
                seller.setNome(set.getString("nome"));
                seller.setCognome(set.getString("cognome"));
                seller.setUsername(set.getString("username"));
                seller.setPassword(set.getString("password"));
                seller.setIdConto(set.getInt("id_conto"));
                
                return seller; 
            }
        } catch(SQLException ex) {
            Logger.getLogger(VenditoriFactory.class.getName()).
            log(Level.SEVERE, null, ex);  
        }
       
        return null;
    }    
    
    /** Restiuisce l'utente avente nome utente e password passati per parametro
     * @param username
     * @param password
     *  @return  restiuisce l'utente avente nome utente e password passati per parametro
     */
    public Venditore findVenditore(String username, String password){
        Venditore seller = null;
        // Definisco la query per trovare un venditore dati username e password
        String query = "select * from Venditore where password = ? and username = ?";
        
        try(Connection conn = DriverManager.getConnection(connectionString, "filippoboi", "paperino");
            PreparedStatement stmt = conn.prepareStatement(query)){
            
            stmt.setString(1, password);
            stmt.setString(2, username);
            
            ResultSet set = stmt.executeQuery();
            
            if(set.next()) {
                seller = new Venditore();
                seller.setId(set.getInt("id"));
                seller.setNome(set.getString("nome"));
                seller.setCognome(set.getString("cognome"));
                seller.setUsername(set.getString("username"));
                seller.setPassword(set.getString("password"));
                seller.setIdConto(set.getInt("id_conto"));
            }
        } catch(SQLException ex){
            Logger.getLogger(VenditoriFactory.class.getName()).
            log(Level.SEVERE, null, ex);
        }
       
        return seller;
    }  
}
