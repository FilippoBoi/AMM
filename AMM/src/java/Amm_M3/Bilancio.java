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
    
    private double uscita;
    private double entrata;
    private double saldo;

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
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

    public Bilancio(double uscita, double entrata, double saldo) {

        this.uscita = uscita;
        this.entrata = entrata;
        this.saldo = saldo;
    }
    
}
