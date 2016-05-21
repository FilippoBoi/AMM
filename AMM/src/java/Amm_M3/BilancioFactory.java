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
public class BilancioFactory {
    
     public double Ricarica(double valoreRicaricato, double saldoAcquirente)
    {
        if(valoreRicaricato>0)
        {
            saldoAcquirente=saldoAcquirente+valoreRicaricato;
            return saldoAcquirente;
        } 
        else //se l'utente non ha effettuato il login o id è nullo, non esegue la ricarica del saldo
            return saldoAcquirente;
    }
     
        public double aggiornaconto(Ordine fattura, double saldoUser, String username)
    {
        double supporto=Ordine.getTotale();

       if(PersonaFactory.isVenditore(username))
       {
           saldoUser=saldoUser+supporto;
       }
       else
       {
           saldoUser=saldoUser-supporto;
       }
        return saldoUser;
        
        
    }
}
