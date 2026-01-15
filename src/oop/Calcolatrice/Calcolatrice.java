package oop.Calcolatrice;

import javax.swing.*;
import java.awt.*;
import java.util.Scanner;

public class Calcolatrice{
    public static int x = 500;
    public static int y = 500;
    public static int y1 = y/12;
    private static boolean op , point = true;
    private static JButton nul0, nul1;
    private static JButton b0, b1, b2, b3, b4, b5, b6, b7, b8, b9;
    private static JButton bmul, bsub, bsum, bclear, bmod, beq, bdiv, bpoint;
    private static JTextArea schermo;
    private static JPanel pp , panel , screen;
    private Calcolatrice(){}
    private static void generaGUI(){
        JFrame frame = new JFrame("Calcolatrice");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(x,y);
        frame.setResizable(false);
        pp = new JPanel(new BorderLayout()); pp.setSize(x,y);
        panel = new JPanel(new GridLayout(5 , 4)); panel.setPreferredSize(new Dimension(x,y - y1 - 35));
        screen = new JPanel(); screen.setPreferredSize(new Dimension(x,y1));
        nul0 =  new JButton(" ");
        nul1 =  new JButton(" ");
        b0 = new JButton("0");
        b1 = new JButton("1");
        b2 = new JButton("2");
        b3 = new JButton("3");
        b4 = new JButton("4");
        b5 = new JButton("5");
        b6 = new JButton("6");
        b7 = new JButton("7");
        b8 = new JButton("8");
        b9 = new JButton("9");
        bmul = new JButton("x");
        bsub = new JButton("-");
        bsum = new JButton("+");
        bclear = new JButton("C");
        bmod = new JButton(" ");
        beq = new JButton("=");
        bdiv = new JButton("/");
        bpoint = new JButton(".");
        int x1 = x - (int)(x*0.02);
        schermo = new JTextArea(); schermo.setEditable(false); schermo.setPreferredSize(new Dimension(x1,y1));

        screen.add(schermo);

        panel.add(bclear); panel.add(bmod); panel.add(nul0); panel.add(nul1);

        panel.add(b7); panel.add(b8); panel.add(b9); panel.add(bsum);
        panel.add(b4); panel.add(b5); panel.add(b6); panel.add(bsub);
        panel.add(b1); panel.add(b2); panel.add(b3); panel.add(bmul);
        panel.add(bpoint); panel.add(b0); panel.add(beq); panel.add(bdiv);

        pp.add(screen , BorderLayout.NORTH);
        pp.add(panel , BorderLayout.SOUTH);
        frame.add(pp);
        frame.setVisible(true);
    }

    public static void avvio(){
        generaGUI();
        bpoint.addActionListener(e -> {if(point){schermo.append("."); point = false;}});//Elimino gli spazi tra i numeri
        b0.addActionListener(e -> {schermo.append("0"); op = true;});
        b1.addActionListener(e -> {schermo.append("1"); op = true;});
        b2.addActionListener(e -> {schermo.append("2"); op = true;});
        b3.addActionListener(e -> {schermo.append("3"); op = true;});
        b4.addActionListener(e -> {schermo.append("4"); op = true;});
        b5.addActionListener(e -> {schermo.append("5"); op = true;});
        b6.addActionListener(e -> {schermo.append("6"); op = true;});
        b7.addActionListener(e -> {schermo.append("7"); op = true;});
        b8.addActionListener(e -> {schermo.append("8"); op = true;});
        b9.addActionListener(e -> {schermo.append("9"); op = true;});
        bmul.addActionListener(e -> {if(op){schermo.append(" x "); op = false; point = true;}});
        bsub.addActionListener(e -> {if(op){schermo.append(" - "); op = false; point = true;}});
        bsum.addActionListener(e -> {if(op){schermo.append(" + "); op = false; point = true;}});
        bdiv.addActionListener(e -> {if(op){schermo.append(" / "); op = false;  point = true;}});
        beq.addActionListener(e -> schermo.setText(Double.toString(doOperations(schermo.getText()))));
        bmod.addActionListener(e -> schermo.append(" "));
        bclear.addActionListener(e -> {schermo.setText(" "); op = true; point = true;});

    }

    private static double doOperations(String s){
        op = false; point = false;
        double ris = 0.0;
        s = s.trim();
        Scanner sc = new Scanner(s);
        sc.useLocale(java.util.Locale.US);
        if(sc.hasNextDouble()) ris =  sc.nextDouble();
        while(sc.hasNext()){
            String operazione = sc.next();
            double a = 0.0;
            if(sc.hasNextDouble()) a  = sc.nextDouble();
            ris = switch(operazione){
                case "x" -> ris * a;
                case "-" -> ris - a;
                case "+" -> ris + a;
                case "/" -> ris / a;
                default -> ris;
            };
        }
        return ris;
    }
}
