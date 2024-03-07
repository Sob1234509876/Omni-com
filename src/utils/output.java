package src.utils;

import java.util.Date;

public class output {

    public static void log(Object message) {
        System.out.printf("[%s/ANNOUNCE] %s\n", new Date().toString(), message.toString());
    }

    public static void log(Object message, String type) {
        System.out.printf("[%s/%s] %s\n", new Date().toString(), type, message);
    }

    public static void log(Object message, String type, Date time) {
        System.out.printf("[%s/%s] %s\n", time, type, message);
    }

    public static void clear() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

}
