package oop.CorpiCelesti;

import java.io.Serializable;
import java.util.regex.*;

public class Codice implements Serializable, Comparable<Codice>{
    private static final String regex = "([A-Za-z]{8})-([A-Za-z]{5})-?([0-9])*";
    private static Pattern pattern = Pattern.compile(regex); //Fortunatamente java non fa match globali automatici
    private String codice;
    private String prefix;
    private String suffix;
    private String number;
    public Codice(String codice){
        if(codice == null){
            throw new IllegalArgumentException("Codice non può essere null");
        }
        codice = codice.trim();
        Matcher match = pattern.matcher(codice);
        if(!match.matches())throw new IllegalArgumentException("Codice non valido");
        int c = match.groupCount();
        prefix = match.group(1);
        suffix = match.group(2);
        this.codice = prefix + "-" + suffix;
        if(match.groupCount() == 3){
            number = match.group(3);
            this.codice = codice + "-" + number;
        }
    }

    //prefix è il sistema stellare ; suffix è la stella ; number è il numero progressivo dal più vicino al lontano dei pianeti
    //quindi una stella ha solo codice prefix + suffix e number rimane vuoto

    public String getCodice(){
        return codice;
    }

    public String prefix(){
        return prefix;
    }

    public String suffix(){
        return suffix;
    }

    public String number() {
        if(number == null){
            return "";
        }else{
            return number;
        }
    }

    @Override
    public String toString(){
        return getCodice();
    }

    @Override
    public int compareTo(Codice o) {
        return this.getCodice().compareTo(o.getCodice());
    }

}
