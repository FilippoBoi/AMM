/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Amm_M3;

/**
 *
 * @author Macinino
 */
public class Persona {
    
    private String nome;
    private String password;
    private String mail;
    private String username;
    private Bilancio saldo;
    private String indirizzo;

    public String getIndirizzo() {
        return indirizzo;
    }

    public void setIndirizzo(String indirizzo) {
        this.indirizzo = indirizzo;
    }

    public Bilancio getSaldo() {
        return saldo;
    }

    public void setSaldo(Bilancio saldo) {
        this.saldo = saldo;
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

    public Persona(String nome, String password, String mail, String username) {
        this.nome = nome;
        this.password = password;
        this.mail = mail;
        this.username = username;
        saldo= new Bilancio(0.00, 0.00, 0.00, 0.00);
    }
 
    
}
