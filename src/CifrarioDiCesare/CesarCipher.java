package CifrarioDiCesare;
import java.IO.*;

public class CesarCipher{
  private CesarCipher(){};
  public static cifra(String path , int key){
    try(BufferedReader br = new  BufferedReader(new FileReader(path)), BufferedWriter bw = new BufferedWriter(new FileWriter(path))){
      Boolean continua = true;
      while(continua){
        char[] line = br.readLine();
      }
    }catch(IOException e){
      e.printStackTrace();
    }
    
  }
}