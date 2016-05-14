/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Amm_M3;

/**
 *
 * @author Macinino
 */
public class Venditore extends Persona{
    
    String usernameV;
    private double saldoVenditore=0.00;
    
    public Venditore (int id, String nome, String password, String mail, 
            double saldoVenditore)
    {
        super(nome, password, mail, nome);
        
        this.saldoVenditore=saldoVenditore;
        
    }

    public String getUsernameV() {
        return usernameV;
    }

    public void setUsernameV(String usernameV) {
        this.usernameV = usernameV;
    }

    public double getSaldoVenditore() {
        return saldoVenditore;
    }

    public void setSaldoVenditore(double saldoVenditore) {
        this.saldoVenditore = saldoVenditore;
    }
    
}
