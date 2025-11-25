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
    return med/pz;
  }
  boolean verificaStandard();
  //Bisogna risolvere qui i metodi perche si 
}