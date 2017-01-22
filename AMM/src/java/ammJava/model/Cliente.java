/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ammJava.model;



/**
 *
 * @author Filippo Boi
 */
public class Cliente extends Persona {

    public Cliente(int id, String nome, String password, String mail, String cognome, String username, String indirizzo, int idConto){
        super(id, nome,password, mail, cognome, username,indirizzo, idConto);
    }

    public Cliente() {
    }


}