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
public class Venditore{
    
    int id=000000;
    String nome;
    protected String password;
    protected String mail;
    
    public Venditore (int id, String nome, String password, String mail)
    {
        this.nome=nome;
        this.password=password;
        this.mail=mail;
        id++;
    }
		
}
