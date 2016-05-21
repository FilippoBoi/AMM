/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Amm_M3;

import java.util.ArrayList;

public class OggettoInVendita
{
    //dichiarazione delle categorie e delle variabili
    private String[] categoria = new String[] {"Libro", "Merchandise/oggettistica", "Film e Serie tv", "Giochi e Videogiochi", "periferiche"} ;
    
    private double prezzo;
    private int disponibilita; //numero di oggetti in vendita
    private String descrizioneBreve;
    
    //ogni articolo dovrà avere un suo id specifico
    private Venditore venditore;
    private int idArticolo;
    
    private ArrayList<OggettoInVendita> tuttiGliOggetti= new ArrayList<>();
    
    //Costruttore OggettoInVendita
    public OggettoInVendita(String tipo, int disponibilita, double prezzo, String descrizione, int idArticolo)
    {
        this.prezzo=prezzo;
        this.descrizioneBreve=descrizione;
        this.disponibilita=disponibilita;
        this.idArticolo=idArticolo;
    }

    public String[] getCategoria() {
        return categoria;
    }

    public void setCategoria(String[] categoria) {
        this.categoria = categoria;
    }

    public double getPrezzo() {
        return prezzo;
    }

    public void setPrezzo(double prezzo) {
        this.prezzo = prezzo;
    }

    public int getDisponibilita() {
        return disponibilita;
    }

    public void setDisponibilita(int disponibilita) {
        this.disponibilita = disponibilita;
    }

    public String getDescrizioneBreve() {
        return descrizioneBreve;
    }

    public void setDescrizioneBreve(String descrizioneBreve) {
        this.descrizioneBreve = descrizioneBreve;
    }

    public Venditore getVenditore() {
        return venditore;
    }

    public void setVenditore(Venditore venditore) {
        this.venditore = venditore;
    }

    public int getIdArticolo() {
        return idArticolo;
    }

    public void setIdArticolo(int idArticolo) {
        this.idArticolo = idArticolo;
    }
    
    //restituisce tutti gli oggetti appartenenti ad una data categoria.
    /*
    public ArrayList<OggettiInVendita> getOggettiCategoria(String category)
    {
        int i=0;
        ArrayList<OggettiInVendita> oggettiCategoria= new ArrayList<>();
        for(i=0;Ordine.ListaOggetti.size()>i;i++)
        {
            //cerca nell'arraylist i valori con uguale categoria
            if(Ordine.ListaOggetti.get(i).categoria[i].equals(category))
            {
                oggettiCategoria.add(Ordine.ListaOggetti.get(i));
            }               
        }
        return oggettiCategoria;
    }*/

    public ArrayList<OggettoInVendita> getTuttiGliOggetti() {
        return tuttiGliOggetti;
    }

    public void setTuttiGliOggetti(ArrayList<OggettoInVendita> tuttiGliOggetti) {
        this.tuttiGliOggetti = tuttiGliOggetti;
    }
}