/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package AMM_M3;

public class OggettiInVendita
{
    //dichiarazione delle categorie e delle variabili
    private String[] categoria = new String[] {"Libro", "Merchandise/oggettistica", "Film e Serie tv", "Giochi e Videogiochi", "periferiche"} ;
    
    private double prezzo;
    private int disponibilita; //numero di oggetti in vendita
    private String descrizioneBreve;
    //ogni categoria dovrà avere un suo id specifico
    private Venditore venditore;
    
    //Costruttore OggettiInVendita
    public OggettiInVendita(String tipo, int disponibilita, double prezzo, String descrizione)
    {
        this.prezzo=prezzo;
        this.descrizioneBreve=descrizione;
        this.disponibilita=disponibilita;
        
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
    
    
}