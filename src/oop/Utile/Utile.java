package oop.Utile;
import java.io.*;
import java.util.*;

public class Utile{
    private Utile(){}

    private static int bufferSize = 8192;

    public static void generaRandom(OutputStream out, long n)throws IOException{
       Random r = new Random();
       DataOutputStream dos = new DataOutputStream(out);
        for(int i=0 ; i<n ; i++){
            dos.writeInt(r.nextInt());
        }
        dos.flush();
        dos.close();
    }

    public static void naturalMergeSort(File f){
        File f1 = null;
        File f2 = null;
        String temp1 = "temp1.dat";
        String temp2 = "temp2.dat";
        while(!crescente(f)){
            f1 = new File(temp1);
            f2 = new File(temp2);
            try(DataOutputStream dos1 = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(f1), bufferSize)); DataOutputStream dos2 = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(f2), bufferSize)); DataInputStream dis = new DataInputStream(new BufferedInputStream(new FileInputStream(f), bufferSize));){
                boolean primo = true;
                Scanner sc = new Scanner(dis);
                int pre = Integer.MIN_VALUE;
                int cor = 0;
                while(sc.hasNext()){
                    cor = dis.readInt();
                    if(pre <= cor){
                        if(primo){
                            dos1.writeInt(cor);
                        }else{
                            dos2.writeInt(cor);
                        }
                    }else{
                        primo = !primo;
                        if(primo){
                            dos1.writeInt(cor);
                        }else{
                            dos2.writeInt(cor);
                        }
                    }
                    pre = cor;
                }
                dos1.flush();
                dos2.flush();
                ricostruisci(f, f1, f2);
            }catch (IOException e){
                e.printStackTrace();
                System.out.println("natural merge sort error");
            }
        }
        try{
            f1.delete();
            f2.delete();
        }catch(NullPointerException npe){
            System.out.println("File già ordinato in modo crescente");
        }
    }

    public static boolean crescente(File f){
        try(DataInputStream dis = new DataInputStream(new BufferedInputStream(new FileInputStream(f), bufferSize));){
            Scanner sc = new Scanner(dis);
            int pre = Integer.MIN_VALUE;
            int cor = 0;
            while(sc.hasNext()){
                cor = dis.readInt();
                if(pre > cor){
                    return false;
                }
                pre = cor;
            }
        }catch(IOException e){
            return false;
        }
        return true;
    }

    public static void ricostruisci(File f, File f1, File f2){
        try(DataInputStream dis1 = new DataInputStream(new BufferedInputStream(new FileInputStream(f1), bufferSize)); DataInputStream dis2 = new DataInputStream(new BufferedInputStream(new FileInputStream(f2), bufferSize)); DataOutputStream dos = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(f), bufferSize))){
            int uno = 0;
            int due = 0;
            Scanner sc1 = new Scanner(dis1);
            Scanner sc2 = new Scanner(dis2);
            while(sc1.hasNext() && sc2.hasNext()){
                if(uno <= due){
                    uno = dis1.readInt();
                    dos.writeInt(uno);
                }else{
                    due = dis2.readInt();
                    dos.writeInt(due);
                }
            }
            if(sc1.hasNext()){
                int cor = 0;
                while(sc1.hasNext()){
                    cor = dis1.readInt();
                    dos.writeInt(cor);
                }
            }else if(sc2.hasNext()){
                int cor = 0;
                while(sc2.hasNext()){
                    cor = dis2.readInt();
                    dos.writeInt(cor);
                }
            }
            dos.flush();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public static void printFile(FileInputStream f){
        try(DataInputStream dis = new DataInputStream(f)){
            int cor = 0;
            Scanner sc = new Scanner(dis);
            while(sc.hasNext()){
                cor = dis.readInt();
                System.out.println(cor);
            }
        }catch(IOException e){
            e.printStackTrace();
        }
    }
     

}