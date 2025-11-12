package Biblioteca;

import java.util.Locale;

public class Autore {
    private String nome;
    private String cognome;
    private Nazionalità nazio;
    public Autore(String nome, String cognome, Nazionalità nazio){
        if(nome == null || cognome == null || nazio == null){
            throw new IllegalArgumentException("!Attenzione campo null!");
        }
        this.nome = nome.toLowerCase();
        this.cognome = cognome.toLowerCase();
        this.nazio = nazio;
    }
}
