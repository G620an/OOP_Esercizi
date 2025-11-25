public class RepartoConcreto extends RepartoAbstract{
  CodiceReparto codice;
  NomeReparto nome;
  CapacitaPazienti capacitaPazienti;
  int medici;
  Superficie superficie;
  Criticità criticità;
  
  public RepartoConcreto(CodiceReparto codice , NomeReparto nome, capacitaPazienti capacitaPazienti , int medici, Superficie superficie , Criticità criticità){
    super();
    this.codice = codice;
    this.nome = nome;
    this.capacitaPazienti = capacitaPazienti;
    this.medici = medici;
    this.superficie = superficie;
    this.criticità = criticità;
  }
  
  
}