/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ammJava.model.Factory;
import ammJava.model.Account;
import ammJava.model.Cliente;
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
 * @author Macinino
 */



public class ClienteFactory {
    /* Attributi */
    private static ClienteFactory singleton;
    String connectionString; 
    
    /** Metodo set della la stringa utilizzata per la connessione al database
     * @param s
     */
    public void setConnectionString(String s){
	this.connectionString = s;
    }
    

    public String getConnectionString(){
            return this.connectionString;
    }  
    
    public static ClienteFactory getInstance() {
        if (singleton == null) {
            singleton = new ClienteFactory();
        }
        return singleton;
    }

    private ClienteFactory() {

    }

    /** Restituisce la lista di tutti i clienti
     *  @return lista dei clienti
     */
    public ArrayList<Cliente> getListaClienti() {
        ArrayList<Cliente> listaClienti = new ArrayList<>();
        

        try(Connection conn = DriverManager.getConnection(connectionString, "filippoboi", "paperino");
            Statement stmt = conn.createStatement()) {
            
            String sql = "SELECT * FROM Acquirente";
            
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
                Cliente buyer = new Cliente(id, nome,password, mail, cognome, username,indirizzo, idConto);
                
                listaClienti.add(buyer);
            }
        } catch (SQLException ex) {
    
            Logger.getLogger(ClienteFactory.class.getName()).
            log(Level.SEVERE, null, ex);
        }
        
        return listaClienti;
    }
    
    /** Restiuisce l'utente
     * @param id
     *  @return  
     */
    public Cliente getAcquirenteById(int id){
        Cliente buyer = null;
        
        String query = "SELECT * FROM Acquirente WHERE id = ?";
     
        
        try(Connection conn = DriverManager.getConnection(connectionString, "filippoboi", "paperino");
            PreparedStatement stmt = conn.prepareStatement(query)){
            // Si associano valori e posizioni di placeholder
            stmt.setInt(1, id);
            
            ResultSet set = stmt.executeQuery();
            
            if(set.next()) {
                buyer = new Cliente();
                buyer.setId(set.getInt("id"));
                buyer.setNome(set.getString("nome"));
                buyer.setCognome(set.getString("cognome"));
                buyer.setUsername(set.getString("username"));
                buyer.setPassword(set.getString("password"));
                buyer.setIdConto(set.getInt("id_conto"));
            }
        } catch(SQLException ex){
            Logger.getLogger(ClienteFactory.class.getName()).
            log(Level.SEVERE, null, ex);
        }
        
        return buyer;
    }  
    
    /** Restiuisce l'utente corrispondente ai dati inseriti
     * @param username
     * @param password
     *  @return  
     */
    public Cliente findAcquirente(String username, String password){
        Cliente buyer = null;
      
        String query = "select * from Acquirente where password = ? and username = ?";
        

        try(Connection conn = DriverManager.getConnection(connectionString, "filippoboi", "paperino");
            PreparedStatement stmt = conn.prepareStatement(query)){
        
            stmt.setString(1, password);
            stmt.setString(2, username);
            
            ResultSet set = stmt.executeQuery();
            
            if(set.next()){
                buyer = new Cliente();
                buyer.setId(set.getInt("id"));
                buyer.setNome(set.getString("nome"));
                buyer.setCognome(set.getString("cognome"));
                buyer.setUsername(set.getString("username"));
                buyer.setPassword(set.getString("password"));
                buyer.setIdConto(set.getInt("id_conto"));
            }
        } catch(SQLException e) {
            Logger.getLogger(ClienteFactory.class.getName()).
            log(Level.SEVERE, null, e);
        }
        
        return buyer;
    }  
    
    /** Questo metodo gestiscee la compravendita di un oggetto tramite una transazione. 
     *  @param  idCar id dell'oggetto che il cliente desidera comprare
     *  @param  idAccountAcquirente id del cliente
     *  @param  idAccountVenditore id del venditore
     *  @return  restiuisce true se la transazione è andata a buon fine, altrimenti restituisce false
     * @throws java.sql.SQLException
     */
    public boolean transazione(int idCar, int idAccountAcquirente, int idAccountVenditore) throws SQLException{
        boolean flag = false;
        
        Connection conn = null;
        PreparedStatement deleteCar = null;
        PreparedStatement withdrawAcquirenteAccount = null;
        PreparedStatement depositVenditoreAccount = null;
        
        Oggetti obj = OggettiFactory.getInstance().getObjSellByID(idCar);
        
        int quantita = obj.getQuantita();
        double prezzo = obj.getPrezzoUnita();
       
        Account accountAcquirente = AccountsFactory.getInstance().getAccountById(idAccountAcquirente);
        Account accountVenditore = AccountsFactory.getInstance().getAccountById(idAccountVenditore);
        double balanceAcquirente = accountAcquirente.getSaldo();
        double balanceVenditore = accountVenditore.getSaldo();
        
        if(balanceAcquirente-prezzo < 0)  return flag;
        
        // Comandi sql da effetuare
        String query1 = null;
       
        if(quantita == 1)
            query1 = " DELETE FROM Oggetti WHERE id = ? ";
        else
            query1 = " UPDATE Oggetti SET quantita = ?  WHERE id = ? "; 
        
        String query2 = " UPDATE Account SET saldo = ?  WHERE id = ? ";
        String query3 = " UPDATE Account SET saldo = ?  WHERE id = ? ";
        
        try{ 
            conn = DriverManager.getConnection(connectionString, "filippoboi", "paperino");

            conn.setAutoCommit(false);
            
            deleteCar = conn.prepareStatement(query1);
            withdrawAcquirenteAccount = conn.prepareStatement(query2);
            depositVenditoreAccount = conn.prepareStatement(query3);
            
                 if(quantita == 1)
                deleteCar.setInt(1, idCar);
            else{
                deleteCar.setInt(1, quantita-1);
                deleteCar.setInt(2, idCar);
            }
            withdrawAcquirenteAccount.setDouble(1, balanceAcquirente-prezzo);
            withdrawAcquirenteAccount.setInt(2, idAccountAcquirente);
            depositVenditoreAccount.setDouble(1, balanceVenditore+prezzo);
            depositVenditoreAccount.setInt(2, idAccountVenditore);
            
            int c1 = deleteCar.executeUpdate();
            int c2 = withdrawAcquirenteAccount.executeUpdate();
            int c3 = depositVenditoreAccount.executeUpdate();
            
          
            if(c1 != 1 || c2 != 1 || c2 != 1){ 
               conn.rollback();
            }else{
               conn.commit();
                flag = true;
            }
        }catch(SQLException ex){
            if(conn != null){

                try{
                    conn.rollback();
                }catch(SQLException e){
        
                    Logger.getLogger(ClienteFactory.class.getName()).
                    log(Level.SEVERE, null, e);
                }
                flag = false;
            }
        } 
        finally{
            if(deleteCar != null) deleteCar.close();
            if(withdrawAcquirenteAccount != null) withdrawAcquirenteAccount.close();
            if(depositVenditoreAccount != null) depositVenditoreAccount.close();
            if(conn != null){
                conn.setAutoCommit(true); 
                conn.close();
            }
        }
        
        // Verrà restituito true solo nel caso in cui tutto sia andato a buon fine 
        return flag;
    }
}
