package Codes.Utils;

import java.util.Date;

public class Output {
    
    public static void log(String message){
        System.out.printf("[%s/ANNOUNCE] %s\n", new Date().toString(), message);
    }
    
    public static void log(String message, String type){
        System.out.printf("[%s/%s] %s\n", new Date().toString(), type, message);
    }

    public static void log(String message, String type, Date time){
        System.out.printf("[%s/%s] %s\n", time, type, message);
    }

    public static void clear(){
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

}
