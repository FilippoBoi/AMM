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
public class OrdiniFactory {
    
    public void acquisto(Ordine daAcquistare, Bilancio acquirente)
    {
        double totale= Ordine.getTotale();
        double saldoAcquirente= Persona.getSaldo();
        if( saldoAcquirente<totale)
        {
            //messaggio di errore
        }
        else
        {
            saldoAcquirente-=totale;
            //messaggio di avvenuto acquisto
        }
        
    }
}
