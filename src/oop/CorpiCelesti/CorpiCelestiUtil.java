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

    public static String generaCodice(int n){
        StringBuilder sb = new StringBuilder();
        Random r = new Random();
        for(int i=0 ; i<n ; i++) {
            boolean exit = false;
            char s = 'a';
            /*
            while (!exit) {
                s = (char)(r.nextInt(256));
                if (Character.isLetter(s)) {
                    exit = true;
                }
            }
            */
            sb.append(s);
        }
        return sb.toString();
    }

    public static SistemaStellare generaSistemaStellare(){
        Random r = new Random();
        Indirizzo ind = new Indirizzo(CorpiCelestiUtil.generaCodice(8));
        SistemaStellare st = new SistemaStellare(ind);
        int n = r.nextInt(100);
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
        double raggio = r.nextDouble()*1e+7;
        double molt = r.nextInt();
        double distanza = r.nextDouble()*molt;
        double massa = r.nextDouble()+1e+15;
        if(raggio < 0) raggio = -raggio;
        if(distanza < 0) distanza = -distanza;
        if(massa < 0) massa = -massa;
        return new Stella(codice,  new Raggio(raggio) , new Distanza(distanza) , new Massa(massa) , Tipo.NANAGIALLA);
    }
}
