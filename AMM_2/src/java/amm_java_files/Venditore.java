/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package amm_java_files;
import amm_java_files.Factories.OggettiFactory;
import java.util.ArrayList;

/**
 *
 * @author Filippo Boi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

public class Venditore extends Persona{
   
    

    public Venditore(int id, String nome, String password, String mail, String cognome, String username, String indirizzo, int idConto){
        super(id, nome, username, password, mail, cognome, indirizzo, idConto);
    }

    public Venditore() {
    
    }
    
    /* Metodi */

    /** Restituisce la lista di oggetti messi in vendita dal venditore
     */
    public ArrayList<Oggetti> getOggettiInVendita() {
        return OggettiFactory.getInstance().getObjSellByVenditore(getId());
             
    }
    
}

