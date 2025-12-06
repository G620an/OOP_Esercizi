package oop.Magazzino;
import java.io.*;

public class MagazzinoUtilSerializable{
  private MagazzinoUtilSerializable(){}

  public void salvaMagazzino(String path, Magazzino magazzino)throws IOException{
    try(ObjectOutputStream ous  = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(path)))){
      for(Materiale m : magazzino){
        ous.writeObject(m);
      }
    }catch(IOException e){
      e.printStackTrace();
    }
  }
  
  public Magazzino caricaMagazzino(String path){
      Magazzino magazzino = new Magazzino();
    try(ObjectInputStream ois = new ObjectInputStream(new BufferedInputStream(new FileInputStream(path)))){
      while(true){
        Materiale m = (Materiale)ois.readObject();
        if(m == null){
          break;
        }
        magazzino.add(m);
      }
    }catch(ClassNotFoundException | IOException e){ //Specifichiamo due eccezioni
      e.printStackTrace();
    }
    return magazzino;
  }


} 