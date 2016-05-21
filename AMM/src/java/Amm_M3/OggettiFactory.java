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
public class OggettiFactory {
    
    /*restituisce tutti gli oggetti appartenenti ad una data categoria.
    public ArrayList<OggettiInVendita> getOggettiCategoria(String category)
    {
        ArrayList<OggettiInVendita> oggettiFiltrati = new ArrayList<>();
        
        oggettiFiltrati=Ordine.getListaOggettiVenduti();
        
        return oggettiFiltrati;         
    }
    */
    
    public ArrayList<OggettoInVendita> aggiuntaOggetto(OggettoInVendita nuovo)
    {
        ArrayList<OggettoInVendita> elencoOggetti = new ArrayList<>();
        
        //elencoOggetti=OggettoInVendita.getTuttiGliOggetti();
        
        elencoOggetti.add(nuovo);
        return elencoOggetti;
    }
    
    public boolean confermaAggiunta(OggettoInVendita aggiunto, ArrayList<OggettoInVendita> elenco)
    {
        return elenco.contains(aggiunto); //cookies per l'aggiunta dell'oggetto
    }
}
