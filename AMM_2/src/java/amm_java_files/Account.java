/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package amm_java_files;

import amm_java_files.Factories.AccountsFactory;
import amm_java_files.Factories.OggettiFactory;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Filippo Boi
 */
public class Account {
 
    private int id; 
    double saldo;

    public Account()      
    {
        this.id=0;
        this.saldo=0.0;
    }    
    
    public Account(int id, double saldo)
    {
        this.id=id;
        this.saldo=saldo;
    }

            
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

      public boolean versa(double versamento) {
        boolean alter = false;
       
        try {
            Connection conn = DriverManager.getConnection(AccountsFactory.getInstance().getConnectionString(), "filippoBoi", "paperino");
            String sql = "UPDATE Account SET saldo = ?  WHERE id = ? ";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setDouble(1, saldo+versamento);
            stmt.setInt(2, id);
            int rows = stmt.executeUpdate();
            if(rows == 1) {
                alter = true;
            }
            stmt.close();
            conn.close();
        }catch (SQLException ex) {
            
            Logger.getLogger(OggettiFactory.class.getName()).
            log(Level.SEVERE, null, ex);
        } 
        
        return alter;       
    }
    
    
    public boolean preleva(double prelievo) {
        
        if(this.saldo >= prelievo){
            boolean alter = false;
       
            try {
                Connection conn = DriverManager.getConnection(AccountsFactory.getInstance().getConnectionString(), "filippoBoi", "paperino");
                 String sql = " UPDATE Account SET saldo = ?  WHERE id = ? ";
                PreparedStatement stmt = conn.prepareStatement(sql);
                stmt.setDouble(1, saldo-prelievo);
                stmt.setInt(2, id);
                int rows = stmt.executeUpdate();
                if(rows == 1) {
                    alter = true;
                }
                stmt.close();
                conn.close();
            } catch (SQLException ex) {
                
            } 
        
            return alter;    
        }else
            return false;
    }

}
