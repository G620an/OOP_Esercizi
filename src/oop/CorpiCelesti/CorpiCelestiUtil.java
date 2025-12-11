package oop.CorpiCelesti;

import java.util.Random;

import java.lang.Math.*;

public class CorpiCelestiUtil {
    private CorpiCelestiUtil(){}

    public static Galassia generaGalassia(String nome , int n){
        Galassia g = new Galassia(nome);
        for(int i = 0; i < n; i++){
            g.addSistemaStellare(CorpiCelestiUtil.generaSistemaStellare());
        }
        return g;
    }

    public static Tipo generaTipo(){
        Random r = new Random();
        int n = r.nextInt(8);
        switch(n){
            case 0:{
                return Tipo.SUPERGIGANTEROSSA;
            }
            case 1:{
                return Tipo.GIGANTEBLUE;
            }
            case 2:{
                return Tipo.NANAROSSA;
            }
            case 3:{
                return Tipo.STELLADINEUTRONI;
            }
            case 4:{
                return Tipo.PULSAR;
            }
            case 5:{
                return Tipo.GIGANTEROSSA;
            }
            case 6:{
                return Tipo.NANAGIALLA;
            }
            case 7:{
                return Tipo.NANABIANCA;
            }
            case 8:{
                return Tipo.NANABRUNA;
            }
        }
        return null;
    }

    public static String generaCodice(int n){
        StringBuilder sb = new StringBuilder();
        Random r = new Random();
        for(int i=0 ; i<n ; i++) {
            boolean exit = false;
            char s = ' ';
            while (!exit) {
                s = (char)(r.nextInt(26) + 'a');
                if (Character.isLetter(s)){
                    exit = true;
                }
            }
            int k = r.nextInt(10);
            if(k%2 == 0){
                sb.append(Character.toUpperCase(s));
            }else{
                sb.append(s);
            }
        }
        return sb.toString();
    }

    public static SistemaStellare generaSistemaStellare(){
        Random r = new Random();
        Indirizzo ind = new Indirizzo(CorpiCelestiUtil.generaCodice(8));
        SistemaStellare st = new SistemaStellare(ind);
        int n = r.nextInt(50);
        for(int i = 0; i < n; i++){
            Stella s = CorpiCelestiUtil.generaStella();
            CorpiCelestiUtil.generaPianeta(s);
            st.addStella(s);
        }
        return st;
    }

    public static void generaPianeta(Stella stella){
        Random r = new Random();
        int n = r.nextInt(13);
        for(int i = 0; i < n; i++){
            Massa m = new Massa(r.nextDouble()*1e8);
            Raggio raggio = new Raggio(r.nextDouble()*1e4);
            stella.addPianeta(m, raggio);
        }
    }

    public static Stella generaStella(){
        Random r = new Random();
        String c = CorpiCelestiUtil.generaCodice(8) + "-";
        c = c + CorpiCelestiUtil.generaCodice(5);
        Codice codice = new Codice(c);
        double raggio = r.nextDouble()*1e+7*r.nextDouble();
        double molt = r.nextInt(100000);
        double distanza = r.nextDouble()*molt*r.nextDouble();
        double massa = r.nextDouble()+1e+15*r.nextDouble();
        if(raggio < 0) raggio = -raggio;
        if(distanza < 0) distanza = -distanza;
        if(massa < 0) massa = -massa;
        return new Stella(codice,  new Raggio(raggio) , new Distanza(distanza) , new Massa(massa) , CorpiCelestiUtil.generaTipo());
    }
}
