/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package AMM_M3;

public class OggettiInVendita
{
    //dichiarazione delle categorie e delle variabili
    String[] categoria = new String[5] ;
    
    double prezzo;
    int quantità;
    String descrizioneBreve;
    //ogni categoria dovrà avere un suo id specifico
    
    
    //Costruttore OggettiInVendita
    public OggettiInVendita(String tipo, int quantità, double prezzo, String descrizione)
    {
        this.quantità=quantità;
        this.prezzo=prezzo;
        this.descrizioneBreve=descrizione;
        
    categoria[0] = "Libri";
    categoria[1] = "Merchandise/oggettistica";
    categoria[2] = "Film e Serie tv";
    categoria[3] = "Giochi e Videogiochi";
    categoria[4] = "periferiche";
    }
}