/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Amm_M3;

import java.util.ArrayList;

/**
 *
 * @author Macinino
 */
public class Bilancio {
    
    private double valoreRicaricato;
    private double uscita;
    private double entrata;
    private double saldo;
    
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

    public double getValoreRicaricato() {
        return valoreRicaricato;
    }

    public void setValoreRicaricato(double valoreRicaricato) {
        this.valoreRicaricato = valoreRicaricato;
    }

    public double getUscita() {
        return uscita;
    }

    public void setUscita(double uscita) {
        this.uscita = uscita;
    }

    public double getEntrata() {
        return entrata;
    }

    public void setEntrata(double entrata) {
        this.entrata = entrata;
    }

    public Bilancio(double valoreRicaricato, double uscita, double entrata, double saldo) {
        this.valoreRicaricato = valoreRicaricato;
        this.uscita = uscita;
        this.entrata = entrata;
    }
    
    public double aggiornaconto(Ordine fattura, double saldoUser, String username)
    {
       Bilancio supporto=fattura.getTotale();
       if(PersonaFactory.isVenditore(username))
       {
           saldoUser=saldoUser-supporto.saldo;
        }
       else
       {
           saldoUser=saldoUser+supporto.saldo;
       }
        return saldoUser;
    }
}
