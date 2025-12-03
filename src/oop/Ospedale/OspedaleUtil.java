package oop.Ospedale;

import java.io.*;
import java.util.*;

public class OspedaleUtil {
    private OspedaleUtil(){}

    public static void stampaReportOspedaliero(List<? extends Ospedale> ospedale , PrintWriter pw){
        System.out.println(ospedale.toString());
    }
}
