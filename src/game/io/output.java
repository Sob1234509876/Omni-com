package game.io;

import game.main.*;
import game.io.err.*;

import java.util.Date;

/**
 * A little io system that is used for making cleaner code. Note : the
 * {@code clear()} method is used for cleaning the output of {@code System.out}.
 */
public class output {

    public static String ANSIFormat() {
        return "\033[0m";
    }

    public static String ANSIFormat(int a) {
        return String.format("\033[%dm", a);
    }

    public static String ANSIFormat(int a, int b) {
        return String.format("\033[%d;%dm", a, b);
    }

    public static String ANSIFormat(int a, int b, int c) {
        return String.format("\033[%d;%d;%dm", a, b, c);
    }

    public static void log() {
        log("");
    }

    public static void log(Object message) {
        log(message, Levels.NORMAL);
    }

    public static void log(Object message, Levels LEVEL) {
        log(message, "ANNOUNCE", LEVEL);
    }

    public static void log(Object message, String type, Levels LEVEL) {

        if (message instanceof Throwable || LEVEL.equals(Levels.FATAL)) {
            Throwable t = (Throwable)(message);
            t.printStackTrace();
            System.exit(1);
        }

        switch (LEVEL) {
            case NORMAL:
                System.out.print(ANSIFormat());
                break;

            case WARNING:
                System.out.print(ANSIFormat(33));
                break;

            case ERROR:
                System.out.print(ANSIFormat(31));
                break;

            case FATAL:
                System.out.print(ANSIFormat(30, 41));
                break;
        }

        System.out.printf("[%s/%s][%s] %s\n", new Date().toString(), type, Thread.currentThread().getName(), message);
        System.err.printf("[%s/%s][%s] %s\n", new Date().toString(), type, Thread.currentThread().getName(), message);

        System.out.print(ANSIFormat());

    }

    public static void clear() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public static void write() {
        Main.OutTextArea.setText(null);
    }

    public static void write(Object x) {
        Main.OutTextArea.setText(x.toString());
    }

}
