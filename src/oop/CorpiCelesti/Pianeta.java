package oop.CorpiCelesti;

public class Pianeta extends CorpoCelesteAbstract{
    private Massa massa;
    private Distanza distanza;
    private Codice codice;
    private Raggio raggio;
    private String nickname;

    public Pianeta(Codice codice , Massa massa, Distanza distanza, Raggio raggio){
        if(codice == null || massa == null || distanza == null || raggio == null){
            throw new IllegalArgumentException("Uno dei campi è null");
        }
        this.codice = codice;
        this.massa = massa;
        this.distanza = distanza;
        this.raggio = raggio;
    }

    public Pianeta(Codice codice , Massa massa, Distanza distanza, Raggio raggio, String nickname) {
        this(codice, massa, distanza, raggio);
        if(nickname == null){
            throw new IllegalArgumentException("Nickname nullo!! 'meglio non metterlo se esiste'");
        }
        this.nickname = nickname;
    }

    @Override
    public Massa getMassa() {
        return massa;
    }

    @Override
    public Distanza getDistanzaDallaTerra() {
        return distanza;
    }

    @Override
    public Codice getCodice() {
        return codice;
    }

    @Override
    public Raggio getRaggio() {
        return raggio;
    }

    public String getNickname() {
        if(nickname == null){
            return "None";
        }else{
            return nickname;
        }
    }

    @Override
    public String toString(){
        return " Codice: " + this.getCodice().prefix() + "-" + this.getCodice().suffix() + "-" + this.getCodice().number() + ", Massa[kg]: " + getMassa() + ", Distanza[al]: " + getDistanzaDallaTerra() + ", Raggio[km]: " + getRaggio() + ", Nickname: " + getNickname();
    }





}
