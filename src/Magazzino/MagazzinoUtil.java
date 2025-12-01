package Magazzino;
import java.IO.*;

public class MagazzinoUtil{
  private MagazzinoUtil(){}
  
  public void salvaMagazzino(String path , Magazzino magazzino){
    try(BufferedWriter bw = new BufferedWriter(new FileWwriter(path))){
      
    }catch(IOException e){
      e.printStackTrace();
    }
  }
}