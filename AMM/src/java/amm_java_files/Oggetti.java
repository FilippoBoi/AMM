/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package amm_java_files;

/**
 *
 * @author Filippo Boi
 */
public class Oggetti {

    private int id;
    private int idVenditore;
    private String nomeOggetto;
    private String descrizione;
    private String categoria;
    private int quantita;
    private double prezzoUnita;
    private String indirizzoImg;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdVenditore() {
        return idVenditore;
    }

    public void setidVenditore(int idSeller) {
        this.idVenditore = idSeller;
    }

    public String getNomeOggetto() {
        return nomeOggetto;
    }

    public void setNomeOggetto(String nomeOggetto) {
        this.nomeOggetto = nomeOggetto;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public int getQuantita() {
        return quantita;
    }

    public void setQuantita(int quantita) {
        this.quantita = quantita;
    }

    public double getPrezzoUnita() {
        return prezzoUnita;
    }

    public void setPrezzoUnita(double prezzoUnita) {
        this.prezzoUnita = prezzoUnita;
    }

    public String getindirizzoImg() {
        return indirizzoImg;
    }

    public void setindirizzoImg(String indirizzoImg) {
        this.indirizzoImg = indirizzoImg;
    }

    public Oggetti() {
    }    

    public Oggetti(int id, int idSeller, String nomeOggetto, String descrizione, String categoria, int quantita, double prezzoUnita, String indirizzoImg) {
        this.id = id;
        this.idVenditore = idSeller;
        this.nomeOggetto = nomeOggetto;
        this.descrizione = descrizione;
        this.categoria = categoria;
        this.quantita = quantita;
        this.prezzoUnita = prezzoUnita;
        this.indirizzoImg = indirizzoImg;
    }
    
    
}
