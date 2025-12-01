package Magazzino;
import java.IO.*;

public class MagazzinoUtilSerializable{
  private MagazzinoUtilSerializable(){}
  
  public void salvaMagazzino(String path, Magazzino magazzino){
    try(BufferedReader bw = new BuferedReader(new FileReader(path)) ){
      for(Materiale m : magazzino){
        bw.write(m);
        bw.newLine();
      }
    }catch(IOException e){
      e.printStackTrace();
    }
  }
  
  public Magazzino caricaMagazzino(String path){
    try(BufferedReader br = new BufferedReader(new FileReader(path))){
      Magazzino m = new Magazzino();
    }catch(IOException e){
      e.printStackTrace();
    }
  }
} 