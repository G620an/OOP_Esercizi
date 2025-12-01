package Magazzino;
import java.IO.*;

public class MagazzinoUtilSerializable{
  private MagazzinoUtilSerializable(){}
  
  public void salvaMagazzino(String path, Magazzino magazzino){
    try(BufferedReader bw = new BuferedReader(new FileReader(path))){
      
    }catch(IOException e){
      e.printStackTrace();
    }
  }
} 