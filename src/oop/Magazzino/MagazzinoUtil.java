package oop.Magazzino;
import java.io.*;

public class MagazzinoUtil{
  private MagazzinoUtil(){}
  
  public void salvaMagazzino(String path , Magazzino magazzino){
    try(BufferedWriter bw = new BufferedWriter(new FileWriter(path))){
      
    }catch(IOException e){
      e.printStackTrace();
    }
  }
}