package oop.File;

import java.io.*;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class PersonaUtil {
    private PersonaUtil() {}
    public static void scriviPersona(File f , Persona p) throws IOException {
        try(PrintWriter pw = new PrintWriter(new FileWriter(f , true))){ //Occorre usare FileWriter per specificare di appendere e non sovrascrivere
            StringBuilder sb = new StringBuilder();
            sb.append(p.getNome());
            sb.append(",").append(p.getCognome());
            sb.append(",").append(p.getEta());
            sb.append(",").append(p.getPeso());
            pw.println(sb);
        }
        return;
    }

    public static List<Persona> leggiPersone(File f) throws IOException {
        LinkedList<Persona> l = new LinkedList<Persona>();
        try(Scanner sc = new Scanner(new BufferedInputStream(new FileInputStream(f)))){
            while(sc.hasNextLine()){
                try(Scanner s = new Scanner(sc.nextLine())){
                    s.useLocale(java.util.Locale.US); //Lo scanner senza non funzione perchè ragiona con double italiani 1,0 1,3 mentre i double vengono scritti come 1.0 1.3
                    s.useDelimiter(",");      //così con useLocale(java.util.US) forziamo la lettura USA
                    String nome = s.next();
                    String cognome = s.next();
                    int eta = s.nextInt();
                    double peso = s.nextDouble();
                    Persona p = new Persona(nome, cognome, eta, peso);
                    l.add(p);
                }
            }
        }
        return l;
    }
}
