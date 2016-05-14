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
public class Bilancio {
    
    int saldoid;
    int uscite;
    int entrata;
    
    public int Ricarica(int a, String id)
    {
        if(/*se id è non nullo*/ id != null /*seconda condizione, id con login riuscito*/)
        {
            saldoid=+a;
            return saldoid;
        } 
        else //se l'utente non ha effettuato il login o id è nullo, non esegue la ricarica del saldo
            return saldoid;
    }
    
}
