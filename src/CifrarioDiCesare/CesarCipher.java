package CifrarioDiCesare;
import java.IO.*;

public class CesarCipher{
  private CesarCipher(){};
  public static cifra(String path , int key){
    try(BufferedReader br = new  BufferedReader(new FileReader(path)), BufferedWriter bw = new BufferedWriter(new FileWriter(path))){
      StringBuilder sb = new StringBuilder();
      Boolean continua = true;
      while(continua){
        String line = br.readLine();
        if(line == null){
          continua = false;
          break;
        }
        char[] cl = line.toCharset();
        
      }
    }catch(IOException e){
      e.printStackTrace();
    }
    
  }
}