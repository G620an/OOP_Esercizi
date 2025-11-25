public class RepartoConcreto extends RepartoAbstract{
  private CodiceReparto codice;
  private NomeReparto nome;
  private CapacitaPazienti capacitaPazienti;
  private int medici;
  private Superficie superficie;
  private Criticità criticità;
  
  public RepartoConcreto(CodiceReparto codice , NomeReparto nome, capacitaPazienti capacitaPazienti , int medici, Superficie superficie , Criticità criticità){
    super(); //Chiamata esplicita al costruttore della classe genitore , anche se non ha un costruttore esplicito la abstract
    this.codice = codice;
    this.nome = nome;
    this.capacitaPazienti = capacitaPazienti;
    if(medici <= 0 || medici > 50}{
      throw new IllegalArgumentException("Valore dei medici invalido");
    }
    this.superficie = superficie;
    this.criticità = criticità;
  }
  
  @Override
  public CodiceReparto codiceReparto(){
    return codiceReparto;
  }
  
  @Override
  public NomeReparto NomeReparto(){
    return nome;
  }
  
  @Override
  public capacitaPazienti capacitaPazienti(){
    return capacitaPazienti<
  }
  
  @Override
  public int medici(){
    return medici;
  }
  
  @Override
  public Criticità criticità(){
    return criticità;
  }
  
  
}