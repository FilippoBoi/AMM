/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ammJava.model.Factory;

import ammJava.model.Account;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Filippo Boi
 */public class AccountsFactory {
    /* Attributi */
    private static AccountsFactory singleton;
    String connectionString; 
    
    public void setConnectionString(String s){
	this.connectionString = s;
    }
    
    public String getConnectionString(){
            return this.connectionString;
    } 
    
    public static AccountsFactory getInstance() {
        if (singleton == null) {
            singleton = new AccountsFactory();
        }
        return singleton;
    }

    private AccountsFactory() {

    }

    public ArrayList<Account> getContiList() {
        ArrayList<Account> listaConti = new ArrayList<>();
        
        try(Connection conn = DriverManager.getConnection(connectionString, "filippoBoi", "paperino");
            java.sql.Statement stmt = conn.createStatement()) {
            String sql = "SELECT * FROM Account";
            ResultSet set = stmt.executeQuery(sql);
            while (set.next()) {
                int idConto = set.getInt("id");
                double saldo = set.getDouble("saldo");
                Account account = new Account(idConto, saldo);
                
                listaConti.add(account);
            }
        } catch (SQLException ex) {
            Logger.getLogger(AccountsFactory.class.getName()).
            log(Level.SEVERE, null, ex);
        }
        
        return listaConti;
    } 
    
    public Account getAccountById(int id){
        Account account = null;
        String sql = "SELECT * FROM Account WHERE id = ?";
        
        try(Connection conn = DriverManager.getConnection(connectionString, "filippoBoi", "paperino");
            PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet set = stmt.executeQuery();
            if(set.next()) {
                int idConto = set.getInt("id");
                double saldo = set.getDouble("saldo");
                account = new Account(idConto, saldo);
            }
        } catch (SQLException ex) {
            Logger.getLogger(AccountsFactory.class.getName()).
            log(Level.SEVERE, null, ex);
        }
        return account;
    }       
}