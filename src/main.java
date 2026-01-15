import oop.Calcolatrice.Calcolatrice;
import oop.Cestino.C;
import oop.File.PersonaUtil;
import oop.Utile.Utile;
import oop.Range.*;
import oop.Punto.*;
import oop.CorpiCelesti.*;
import oop.Mazzo.*;
import oop.Collezioni.*;
import oop.File.Persona;




public static void main(String[] args){
  /*
  if(args.length != 3){
    throw new IllegalArgumentException("Numero di argomenti diverso da tre");
  }
  String path = args[0];
  String metodo = args[1];
  int key = Integer.parseInt(args[2]);
  metodo += metodo.toLowerCase();

  if(metodo.equals("cifra")){
    CesarCipher.cifra(path , key);
  }else if(metodo.equals("decifra")){
    CesarCipher.decifra(path , 1);
  }else{
    throw new IllegalArgumentException("Parametro di cifratura errato");
  }
   */
/*
  long n = 5; //sono 4 MB di roba perchè gli int sono a 4 byte
  String path = "prova.dat";
  File file = new File(path);
  try{
      Utile.generaRandom(new BufferedOutputStream(new FileOutputStream(path), 8192), n);
      Utile.printFile(new FileInputStream(file), file.length());
      Utile.naturalMergeSort(file);
      System.out.println("-------------------------------------------");
      Utile.printFile(new FileInputStream(file), file.length());
  }catch(IOException e){
      e.printStackTrace();
  }
*/
/*
    Galassia g = CorpiCelestiUtil.generaGalassia("Via Lattea" , 10);
    System.out.println(g.toString());
 */

   /*
Mazzo m = new Mazzo();
System.out.println(m);

*/

    /*
ListaConcatenata<String> nomi = new  ListaConcatenata<>();
nomi.aggiungiInCoda("Ciao");
nomi.aggiungiInCoda("Miao");
nomi.aggiungiInCoda("Piao");
nomi.aggiungiInCoda("Tao");
int i = 0;
IteratoreLista<String> it = nomi.listIterator();
while(it.hasNext()){
    System.out.println(it.next());
    if(i == 1 && it.hasPrevious()){
        //System.out.println(it.previous());
        it.remove();
    }
    i++;
}

System.out.println("-----------");
System.out.println(nomi);
     */
    /*
    String file = "persone.txt";
    File f = new File(file);
    f.delete();
    f = new File(file);
    Persona p0 = new Persona("aaa" , "aaa" , 1 , 3.0);
    Persona p1 = new Persona("bbb" , "bbb" , 2 , 6.0);
    Persona p2 = new Persona("ccc" , "ccc" , 3 , 9.0);
    Persona p3 = new Persona("ddd" , "ddd" , 4 , 12.0);
    try {
        PersonaUtil.scriviPersona(f, p0);
        PersonaUtil.scriviPersona(f, p1);
        PersonaUtil.scriviPersona(f, p2);
        PersonaUtil.scriviPersona(f, p3);
        List<Persona> pe = PersonaUtil.leggiPersone(f);
        System.out.println(pe);
    }catch(IOException e){
        e.printStackTrace();
    }
    */
    /*
    ArrayList<Integer> l = new ArrayList<>();
    for(int i = 843; i < 943; i++){
        l.add(i%31);
    }
    System.out.println(l);
    List<Integer> l1 = l.stream().sorted((a , b)->Integer.compare(a ,b)).filter((a)->a % 2 == 0).map(Integer :: reverse).toList();
    System.out.println(l1);
    */
    //Calcolatrice.avvio();
    ListaConcatenata<String> s = new ListaConcatenata<>();
    s.aggiungiInCoda("Ciao");
    s.aggiungiInCoda("Rio");
    s.aggiungiInCoda("Mio");
    s.aggiungiInCoda("Pio");
    ListIterator<String> it = s.listIterator();
    int i = 0;
    while(it.hasNext()){
        System.out.println("i="+ i + " " + it.next());
        if(i == 2){
            //System.out.println("Sono pre: " + it.previous());
            it.remove();
        }
        i++;
    }
    System.out.println("---------------------------------------");
    for(String l : s){
        System.out.println(l);
    }
    System.out.println("---------------------------------------");
    it.remove();
    System.out.println("---------------------------------------");
    for(String l : s){
        System.out.println(l);
    }
 }