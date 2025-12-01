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
    try(BufferedInputStream bsi = new BufferedInputStream(new FileInputStream(path))){
      Magazzino magazzino = new Magazzino();
      boolean continua = true;
      while(continua){
        Materiale m = bsi.readObject();
        if(m == null){
          continua = false;
          break;
        }
        magazzino.append(m);
      }
      return magazzino;
    }catch(IOException e){
      e.printStackTrace();
    }
  }
} 