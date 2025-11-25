public interface Ospedale extends Iterable<Reparto>{ //Sara la nostra struttura dati
  void aggiungiReparto(Reparto r);
  boolean rimuoviReparto(Reparto r);
  default Reparto getReparto(int index){
    if(index < 0) throw new IllegalArgumentException("Il valore index non puo essere negativo");
    int a;
    for(Reparto rep : this){
      if(a == index){
        return rep
      }
    }
    throw new NoSuchElementException("Indice non valido");
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
    boolean verCriticita = false;
    double supTot = 0.0;
    double ratio = this.calcolaRatioMediciPazienti();
    if(ratio < 0.15) return false;
    for(Reparto rep : this){
      supTot += rep.superficie().area();
      
    }
  }
  //Bisogna risolvere qui i metodi perche si 
}