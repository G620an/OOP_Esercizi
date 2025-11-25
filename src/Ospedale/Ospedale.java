package Ospedale;

import java.util.NoSuchElementException;

public interface Ospedale extends Iterable<Reparto>{ //Sara la nostra struttura dati
  void aggiungiReparto(Reparto r);
  boolean rimuoviReparto(Reparto r);
  
  default Reparto getReparto(int index){
    if(index < 0) throw new IllegalArgumentException("Il valore index non puo essere negativo");
    int a = 0;
    for(Reparto rep : this){
      if(a == index){
        return rep;
      }
      a++;
    }
    throw new NoSuchElementException("Indice non valido"); //Decido di sfruttare le eccezioni per gestire le incorrettezze della index
  }

  default double calcolaRatioMediciPazienti(){
    int med = 0;
    int pz = 0;
    for(Reparto rep : this){
      pz += rep.capacitaPazienti().cap();
      med =+ rep.medici();
    }
    return (double) med/(double)pz;
  }

  default boolean verificaStandard(){
    boolean terapiaIntensiva = false;
    boolean verCriticita = true;
    double supTot = 0.0;
    double ratio = this.calcolaRatioMediciPazienti();
    if(ratio < 0.15) return false;
    for(Reparto rep : this){
      supTot += rep.superficie().area();
      if(rep instanceof TerapiaIntensiva) terapiaIntensiva = true;
      if(rep.criticità() == Criticità.ALTO || rep.criticità() == Criticità.ALTISSIMO){
        if(rep.medici() < 3) return false;
      }
    }
    if(supTot < 5000.0) return false;
    return terapiaIntensiva;
  }

  //Bisogna risolvere qui i metodi
}