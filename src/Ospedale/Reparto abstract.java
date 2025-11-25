public abstract class RepartoAbstract{
  @Override
  public String toString(){
    return ""+ codiceReparto()+ " " + nomeReparto() + " " + capacitaPazienti() + " " + medici() + " " + superficie() + " " + criticità(); 
  }
}