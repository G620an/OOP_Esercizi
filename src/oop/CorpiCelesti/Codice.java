package oop.CorpiCelesti;

public record Codice(String prefix , String suffix, String number){
    public Codice{
        if(prefix == null || suffix == null){
            throw new IllegalArgumentException("Prefix e Suffix non possono essere null");
        }
    }

    //prefix è il sistema stellare ; suffix è la stella ; number è il numero progressivo dal più vicino al lontano dei pianeti
    //quindi una stella ha solo codice prefix + suffix e number rimane vuoto

    public String getCodice(){
        return prefix + "-" +  suffix + "-" + number;
    }

    @Override
    public String toString(){
        return getCodice();
    }
}
