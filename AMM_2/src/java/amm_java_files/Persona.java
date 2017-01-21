/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package amm_java_files;

/**
 *
 * @author Macinino
 */
public class Persona {
    
    private int id;
    private String nome;
    private String password;
    private String mail;
    private String cognome;
    private String username;
    private String indirizzo;
    private int idConto;

    
    
    public Persona (){}
            
    public Persona(int id, String nome, String password, String mail, String cognome, String username, String indirizzo, int idConto)
    {
        this.id =id;
        this.nome = nome;
        this.cognome = cognome;
        this.username= username;
        this.password = password;
        this.idConto = idConto;
        this.mail= mail;
        this.indirizzo = indirizzo;
    }
    

    //getters e setters per ogni variabile. i getter restituiscono il valore, i set lo impostano
public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getIndirizzo() {
        return indirizzo;
    }

    public void setIndirizzo(String indirizzo) {
        this.indirizzo = indirizzo;
    }

    public int getIdConto() {
        return idConto;
    }

    public void setIdConto(int idConto) {
        this.idConto = idConto;
    }

    
}
