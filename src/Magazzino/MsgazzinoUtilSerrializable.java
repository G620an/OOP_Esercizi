package Magazzino;
import java.IO.*;

public class MagazzinoUtilSerializable{
  private MagazzinoUtilSerializable(){}
  
  public void salvaMagazzino(String path, Magazzino magazzino){
    try(BufferedOutputStream bs = new BufferedOutputStream(new FileOutputStream(path)) ){
      for(Materiale m : magazzino){
        bs.writeObject(m);
      }
    }catch(IOException e){
      e.printStackTrace();
    }
  }
  
  public Magazzino caricaMagazzino(String path){
    try(BufferedReader br = new BufferedReader(new FileReader(path))){
      Magazzino m = new Magazzino();
      boolean continua = true;
      while(continua){
        
      }
    }catch(IOException e){
      e.printStackTrace();
    }
  }
} 