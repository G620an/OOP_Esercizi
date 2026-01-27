package oop.Utile;
import java.io.*;
import java.util.*;

public class Utile{
    private Utile(){}

    private static int bufferSize = 8192*10;

    public static void setBufferSize(int bufferSize){
        Utile.bufferSize = bufferSize;
    }


    public static void generaRandom(OutputStream out, long n)throws IOException{
       Random r = new Random();
       DataOutputStream dos = new DataOutputStream(out);
        for(int i=0 ; i<n ; i++){
            dos.writeInt(r.nextInt());
        }
        dos.flush();
        dos.close();
    }

    public static void naturalMergeSort(File f)throws IOException{
        File f1 = null;
        File f2 = null;
        String temp1 = "temp1.dat";
        String temp2 = "temp2.dat";
        while(!crescente(f)){
            f1 = new File(temp1);
            f2 = new File(temp2);
            try(DataOutputStream dos1 = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(f1), bufferSize)); DataOutputStream dos2 = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(f2), bufferSize)); DataInputStream dis = new DataInputStream(new BufferedInputStream(new FileInputStream(f), bufferSize));){
                boolean primo = true;
                long c = f.length();
                int pre = Integer.MIN_VALUE;
                int cor = 0;
                while(c > 3){
                    cor = dis.readInt();
                    c -= 4;
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
            int pre = Integer.MIN_VALUE;
            int cor = 0;
            long c = f.length(); //Contatore per tenere traccia di quanti byte sono stati letti
            while(c > 3){
                cor = dis.readInt();
                c -= 4;
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
            int uno = dis1.readInt();
            int due = dis2.readInt();
            long c1 = f1.length() - 4;
            long c2 = f2.length() - 4;
            while(c1 > 3 && c2 > 3){
                if(uno <= due){
                    dos.writeInt(uno);
                    uno = dis1.readInt();
                    c1 -= 4;
                }else{
                    dos.writeInt(due);
                    due = dis2.readInt();
                    c2 -= 4;
                }
            }
            if(uno <= due){
                dos.writeInt(uno);
                dos.writeInt(due); //Recupero uno e due
            }else{
                dos.writeInt(due); //Recupero due e uno
                dos.writeInt(uno);
            }
            if(c1 > 3){
                while(c1 > 3){
                    c1 -= 4;
                    dos.writeInt(dis1.readInt());
                }
            }else if(c2 > 3){
                while(c2 > 3){
                    c2 -= 4;
                    dos.writeInt(dis2.readInt());
                }
            }
            dos.flush();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public static void printFile(File f){
        try(DataInputStream dis = new DataInputStream(new BufferedInputStream(new FileInputStream(f),  bufferSize));){
            long c = f.length();
            int cor = 0;
            while(c > 3){
                cor = dis.readInt();
                c -= 4;
                System.out.println(cor);
            }
        }catch(IOException e){
            e.printStackTrace();
        }
    }
     

}