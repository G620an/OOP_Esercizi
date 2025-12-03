package oop.CifrarioDiCesare;
import java.io.*;

public class CesarCipher{
  private CesarCipher(){};
  public static void cifra(String path , int key){
    try(BufferedReader br = new BufferedReader(new FileReader(path)); BufferedWriter bw = new BufferedWriter(new FileWriter(path))){
      StringBuilder sb = new StringBuilder();
      Boolean continua = true;
      while(continua){
        char[] line = br.readLine().toCharArray();
        if(line == null){
          continua = false;
          break;
        }
        for(int i=0 ; i<line.length ; i++){
          line[i] = (char)(line[i]+key);
        }
        sb.append(line);
      }
      bw.write(sb.toString());
      bw.flush();
    }catch(IOException e){
      e.printStackTrace();
    }
  }
  
  public static void decifra(String path,  int key){
    cifra(path , -key);
  }
}