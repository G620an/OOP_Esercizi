package CifrarioDiCesare;
import java.IO.*;

public class CesarCipher{
  private CesarCipher(){};
  public static void cifra(String path , int key){
    try(BufferedReader br = new  BufferedReader(new FileReader(path)), BufferedWriter bw = new BufferedWriter(new FileWriter(path))){
      StringBuilder sb = new StringBuilder();
      Boolean continua = true;
      while(continua){
        char[] line = br.readLine().toCharArray();
        if(line == null){
          continua = false;
          break;
        }
        for(int i=0 ; i<line.length ; i++){
          line[i] =+ key;
        }
        sb.append(line);
      }
      bw.createNewFile();
      bw.write(sb.toString());
    }catch(IOException e){
      e.printStackTrace();
    }
  }
  
  public static void decifra(String path; int key){
    int menoKey = (-1)*key;
    this.cifra(path , menoKey);
  }
}