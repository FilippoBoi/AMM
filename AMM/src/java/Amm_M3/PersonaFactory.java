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
public class PersonaFactory {
    
    public static boolean isVenditore(String username)
    {
        if(username.equals("Venditore") || username.equals("TestAdmin"))
        {
            return true;
        }
        else
            return false;
    }
    
    public static boolean exists( String username)
    {
        if(username.equals("TestUser") || username.equals("Cliente") || isVenditore(username))
        {
            return true;
        }
        else
            return false;
    }
    public static boolean itsPassword(String username, String password)
    {
        //codice provvisorio in attesa di database
        if(username.equals("TestUser")&& password.equals("provapassword"))
        {
            return true;
        }
        
        else if(username.equals("Cliente") && password.equals("000000"))
        {
            return true;
        }
        
        else if (username.equals("TestAdmin") && password.equals("nopassword"))
        {
            return true;
        }
        
        else if (username.equals("Venditore") && password.equals("passwordVendo"))
        {
            return true;
        }
        
        else 
        {
            return false;
        }
    }
    

}
