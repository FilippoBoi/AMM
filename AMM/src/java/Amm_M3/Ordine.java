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
    private ArrayList<OggettiInVendita> listaOggettiVenduti;
    private Bilancio totale;

    public Acquirente getAcquirente() {
        return acquirente;
    }

    public void setAcquirente(Acquirente acquirente) {
        this.acquirente = acquirente;
    }

    public ArrayList<OggettiInVendita> getListaOggettiVenduti() {
        return listaOggettiVenduti;
    }

    public void setListaOggettiVenduti(ArrayList<OggettiInVendita> listaOggettiVenduti) {
        this.listaOggettiVenduti = listaOggettiVenduti;
    }

    public Bilancio getTotale() {
        return totale;
    }

    public void setTotale(Bilancio totale) {
        this.totale = totale;
    }

    public Ordine(Acquirente acquirente, ArrayList<OggettiInVendita> listaOggettiVenduti, Bilancio totale) {
        this.acquirente = acquirente;
        this.listaOggettiVenduti = listaOggettiVenduti;
        this.totale = totale;
    }
    
}
