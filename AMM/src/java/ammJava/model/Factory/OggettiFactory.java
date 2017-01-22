/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ammJava.model.Factory;

import ammJava.model.Oggetti;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Filippo Boi
 */
public class OggettiFactory {

    private static OggettiFactory singleton;
    String connectionString;

    public String getConnectionString() {
        return connectionString;
    }

    public void setConnectionString(String connectionString) {
        this.connectionString = connectionString;
    }

    public OggettiFactory() {
    }

    public static OggettiFactory getInstance() {
        if(singleton==null){singleton=new OggettiFactory();}
        return singleton;
    }
    
    public ArrayList<Oggetti> getListaOggetti()
    {
        ArrayList<Oggetti> listaOggetti = new ArrayList<>();
        try(Connection conn = DriverManager.getConnection(connectionString,"filippoboi","paperino");
            Statement stmt = conn.createStatement()) {
            // Definisco la query per ottenere l'elenco di tutti gli oggetti in vendita
            String sql = "SELECT * FROM Oggetti";
            
            ResultSet set = stmt.executeQuery(sql);
            while (set.next()) {
                int id = set.getInt("id");
                int idVenditore= set.getInt("idVenditore");
                String nomeOggetto = set.getString("nomeOggetto");
                String indirizzoImg = set.getString("indirizzoImg");
                String descrizione = set.getString("descrizione");
                String categoria = set.getString("categoria");
                double prezzoUnita = set.getDouble("prezzoUnita");
                int quantita = set.getInt("quantita");
                Oggetti oggetto = new Oggetti(id, idVenditore, nomeOggetto, descrizione, categoria, quantita, prezzoUnita, indirizzoImg);
                        
                listaOggetti.add(oggetto);
            }
        } catch (SQLException ex) {
            Logger.getLogger(OggettiFactory.class.getName()).
            log(Level.SEVERE, null, ex);
        }
        
        return listaOggetti;
    }  
        public Oggetti getObjSellByID(int id)
        {
            Oggetti oggetto = null;
            String sql ="SELECT * FROM Oggetti WHERE ID =?";
            try(Connection conn = DriverManager.getConnection(connectionString, "filippoboi", "paperino");
            PreparedStatement stmt = conn.prepareStatement(sql)) {
            // Si associano valori e posizioni di placeholder
            stmt.setInt(1, id);
           
            ResultSet set = stmt.executeQuery();
        
            if (set.next()) {
                int idVenditore= set.getInt("idVenditore");
                String nomeOggetto = set.getString("nomeOggetto");
                String indirizzoImg = set.getString("indirizzoImg");
                String descrizione = set.getString("descrizione");
                String categoria = set.getString("categoria");
                double prezzoUnita = set.getDouble("prezzoUnita");
                int quantita = set.getInt("quantita");
                oggetto = new Oggetti(id, idVenditore, nomeOggetto, descrizione, categoria, quantita, prezzoUnita, indirizzoImg);
                        
            }
        } catch (SQLException ex) {
            Logger.getLogger(OggettiFactory.class.getName()).
            log(Level.SEVERE, null, ex);
        }
        
        return oggetto;
        }
    
    public ArrayList<Oggetti> getObjSellByVenditore(int idVenditore){
        ArrayList<Oggetti> listaOggetti = new ArrayList<>();
        
        /*  controllo se esiste l'id*/
        if(VenditoriFactory.getInstance().getVenditoreById(idVenditore) != null){
            String sql = "SELECT * FROM CarSale WHERE idVenditore = ?";
            

        try(Connection conn = DriverManager.getConnection(connectionString, "filippoboi", "paperino");
                PreparedStatement stmt = conn.prepareStatement(sql)) {
                stmt.setInt(1, idVenditore);
               
                ResultSet set = stmt.executeQuery();
          while (set.next()) {
                int id = set.getInt("id");
                String nomeOggetto = set.getString("nomeOggetto");
                String indirizzoImg = set.getString("indirizzoImg");
                String descrizione = set.getString("descrizione");
                String categoria = set.getString("categoria");
                double prezzoUnita = set.getDouble("prezzoUnita");
                int quantita = set.getInt("quantita");
                Oggetti oggetto = new Oggetti(id, idVenditore, nomeOggetto, descrizione, categoria, quantita, prezzoUnita, indirizzoImg);
                        
                listaOggetti.add(oggetto);
            }
        } catch (SQLException ex) {
            Logger.getLogger(OggettiFactory.class.getName()).
            log(Level.SEVERE, null, ex);
        }
    }else
        return null;
    return listaOggetti;
    }
    
    public boolean eliminaOggetto(int idOggetto){
        boolean eliminato = false;
        String sql = "DELETE FROM Oggetti WHERE id = ?";
       
        try(Connection conn = DriverManager.getConnection(connectionString, "filippoboi", "paperino");
            PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, idOggetto);
            
            int rows = stmt.executeUpdate();
            if(rows == 1) 
                eliminato = true;
        } catch (SQLException ex) {
            Logger.getLogger(OggettiFactory.class.getName()).
            log(Level.SEVERE, null, ex);
        }
        return eliminato;
    }
    
        public boolean InserisciOggetto(Oggetti oggetto){
        boolean insert = false;
        String query = "INSERT INTO Oggetti "
                        + "(id, idVenditore, nomeOggetto, descrizione, categoria, quantita, prezzoUnita, indirizzoImg) VALUES "
                        + "(default, ?, ?, ?, ?, ?, ?, ?)";
        
        try(Connection conn = DriverManager.getConnection(connectionString, "filippoBoi", "paperino");
            PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, oggetto.getIdVenditore());
            stmt.setString(2, oggetto.getNomeOggetto());
            stmt.setString(3, oggetto.getDescrizione());
            stmt.setString(4,oggetto.getCategoria());
            stmt.setInt(5, oggetto.getQuantita());
            stmt.setDouble(6, oggetto.getPrezzoUnita());
            stmt.setString(7, oggetto.getindirizzoImg());
            stmt.setString(0, query);
            int rows = stmt.executeUpdate();
            if(rows == 1)
                insert = true; 
        }catch(SQLException ex){
            Logger.getLogger(OggettiFactory.class.getName()).
            log(Level.SEVERE, null, ex);  
        }
        return insert;
    }

    public boolean alterOggetto(Oggetti oggetto){
        boolean modificato = false;
        String sql = " UPDATE Oggetto "
                    + "SET idVenditore =?, nomeOggetto=?, descrizione=?, categoria=?, quantita=?, prezzoUnita=?, indirizzoImg=?"
                    + "WHERE id = ? ";
        
        try(Connection conn = DriverManager.getConnection(connectionString, "filippoboi", "paperino");
            PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, oggetto.getIdVenditore());
            stmt.setString(2, oggetto.getNomeOggetto());
            stmt.setString(3, oggetto.getDescrizione());
            stmt.setString(4,oggetto.getCategoria());
            stmt.setInt(5, oggetto.getQuantita());
            stmt.setDouble(6, oggetto.getPrezzoUnita());
            stmt.setString(7, oggetto.getindirizzoImg());
            stmt.setInt(8, oggetto.getId());
            int righe = stmt.executeUpdate();

            if(righe == 1) 
                modificato = true;
        } catch (SQLException ex) {
            Logger.getLogger(OggettiFactory.class.getName()).
            log(Level.SEVERE, null, ex);
        } 
        
        return modificato;
    }
    
    public ArrayList<Oggetti> getOggettiSellListByPattern(String pattern) {
        ArrayList<Oggetti> listaOggetti = new ArrayList<>();
        String sql = "SELECT *" +
                     "FROM Oggetti " + 
                     "WHERE nomeOggetto LIKE ? OR descrizione LIKE ?";         
        
        try(Connection conn = DriverManager.getConnection(connectionString, "filippoboi", "paperino");
            PreparedStatement stmt = conn.prepareStatement(sql)) {
            // Assegna dat.000i
            pattern = "%"+pattern+"%";
            stmt.setString(1, pattern);
            stmt.setString(2, pattern);
            ResultSet set = stmt.executeQuery();
            while (set.next()) {
                int id = set.getInt("id");
                int idVenditore= set.getInt("idVenditore");
                String nomeOggetto = set.getString("nomeOggetto");
                String indirizzoImg = set.getString("indirizzoImg");
                String descrizione = set.getString("descrizione");
                String categoria = set.getString("categoria");
                double prezzoUnita = set.getDouble("prezzoUnita");
                int quantita = set.getInt("quantita");
                Oggetti oggetto = new Oggetti(id, idVenditore, nomeOggetto, descrizione, categoria, quantita, prezzoUnita, indirizzoImg);
                        
                listaOggetti.add(oggetto);
            }
        } catch (SQLException ex) {
            Logger.getLogger(OggettiFactory.class.getName()).
            log(Level.SEVERE, null, ex);
        }
        
        return listaOggetti;
    }  
       
}