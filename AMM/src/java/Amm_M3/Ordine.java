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
public class Ordine {

    private Acquirente acquirente;
    private ArrayList<OggettoInVendita> listaOggettiVenduti;
    private double totale;
    private Venditore venditore;

    public Venditore getVenditore() {
        return venditore;
    }

    public void setVenditore(Venditore venditore) {
        this.venditore = venditore;
    }

    public Acquirente getAcquirente() {
        return acquirente;
    }

    public void setAcquirente(Acquirente acquirente) {
        this.acquirente = acquirente;
    }

    public ArrayList<OggettoInVendita> getListaOggettiVenduti() {
        return listaOggettiVenduti;
    }

    public void setListaOggettiVenduti(ArrayList<OggettoInVendita> listaOggettiVenduti) {
        this.listaOggettiVenduti = listaOggettiVenduti;
    }

    public double getTotale() {
        return totale;
    }

    public void setTotale(double totale) {
        this.totale = totale;
    }

    public Ordine(Acquirente acquirente, ArrayList<OggettoInVendita> listaOggettiVenduti, double totale) {
        this.acquirente = acquirente;
        this.listaOggettiVenduti = listaOggettiVenduti;
        this.totale = totale;
    }
    
}
