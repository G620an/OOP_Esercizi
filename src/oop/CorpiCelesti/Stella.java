package oop.CorpiCelesti;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;

public class Stella extends CorpoCelesteAbstract implements Iterable<Pianeta>{
    private Distanza distanza;
    private Raggio raggio;
    private Codice codice;
    private Massa massa;
    private String nickname;
    private Tipo tipo;
    private ArrayList<Pianeta> pianeti;

    public Stella(Codice codice, Raggio raggio, Distanza distanza, Massa massa, Tipo tipo){
        if(codice == null || raggio == null || distanza == null || massa == null || tipo == null){
            throw new IllegalArgumentException("Uno dei campi è null");
        }
        this.codice = codice;
        this.raggio = raggio;
        this.distanza = distanza;
        this.massa = massa;
        this.tipo = tipo;
        pianeti = new ArrayList<>();
    }

    public Stella(Codice codice, Raggio raggio, Distanza distanza,  Massa massa, Tipo tipo, String nickname){
        this(codice, raggio, distanza, massa, tipo);
        if(nickname == null){
            throw new IllegalArgumentException("Nickname nullo");
        }
        this.nickname = nickname;
        pianeti = new ArrayList<>();
    }

    @Override
    public Codice getCodice() {
        return codice;
    }

    @Override
    public Raggio getRaggio() {
        return raggio;
    }

    @Override
    public Massa getMassa(){
        return massa;
    }

    @Override
    public Distanza getDistanzaDallaTerra(){
        return distanza;
    }

    public Tipo getTipo(){
        return tipo;
    }

    @Override
    public String getNickname() {
        if(nickname == null){
            return "None";
        }else{
            return nickname;
        }
    }

    public void addPianeta(Massa massa, Distanza distanza, Raggio raggio){
        String numero = Integer.toString(pianeti.size() + 1);
        String code = this.getCodice().prefix() + "-" + this.getCodice().suffix() + "-" + numero;
        Codice codice = new Codice(code);
        pianeti.add(new Pianeta(codice, massa, distanza, raggio));
    }//Il pianeta può essere aggiunto solo dai suoi parametri e non come oggetto già definito, questo perchè deve esserci
    //una corrispondenza tra codice stella e codice pianeti attorno alla stella

    public boolean removePianeta(Pianeta p){
        return pianeti.remove(p);
    }

    public boolean removePianeta(Codice codice){
        for(Pianeta p : this){
            if(p.getCodice().equals(codice)){
                pianeti.remove(p);
                return true;
            }
        }
        return false;
    }

    public ArrayList<Pianeta> getPianeti() {
        return pianeti;
    }

    public Iterator<Pianeta> iterator(){
        return pianeti.iterator();
    }

}
