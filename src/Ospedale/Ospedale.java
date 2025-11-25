public interface Ospedale extends Iterable<Reparto>{ //Sara la nostra struttura dati
  void aggiungiReparto(Reparto r);
  boolean rimuoviReparto(Reparto r);
  default Reparto getReparto(int index){
    if(index < 0) throw new IllegalArgumentException("Il valore index non puo essere negativo");
    int a;
    for(rep : this){
      if(a == index){
        return rep
      }
    }
    throw new NoSuchElementException("Indice non valido");
  }
  double calcolaRatioMediciPazienti();
  boolean verificaStandard();
  //Bisogna risolvere qui i metodi perche si 
}