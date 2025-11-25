public class OspedaleImpl implements Ospedale{
  
  public final class Nodo{
    private Reparto r;
    Nodo(Reparto r){
      this.r = r;
    }
  }
  
  public OspedaleImpl(){}
  
  @Override
  public boolean rimuoviReparto(Reparto r){
    
  }
  
  @Override
  public void aggiungiReparto(Reparto r){
    
  }
  
  @Override
  public Iterator<Reparto> Iterator(){
    return new Iterable<Reparto>{
      private Nodo corhead;
      private Nodo pre = null;
      boolean hasNext(){
        return cor.next == null;
      }
      
      Reparto next(){
        if(!hasNext()){
          throw new NoSuchElementException();
        }
        private Reparto temp = cur;
        cur = cur.next();
        return temp;
      }
  }
}