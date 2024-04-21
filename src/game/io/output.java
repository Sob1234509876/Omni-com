package game.io;

import game.main.Main;

import java.util.Date;

/**
 * A little io system that is used for making cleaner code. Note : the
 * {@code clear()} method is used for cleaning the output of {@code System.out}.
 */

public class output {

    public static final int NORMAL = 0;
    public static final int WARNING = 1;
    public static final int ERROR = 2;
    public static final int FATAL = 3;

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
        log(message, NORMAL);
    }

    public static void log(Object message, int LEVEL) {
        log(message, "ANNOUNCE", LEVEL);
    }

    public static void log(Object message, String type, int LEVEL) {

        switch (LEVEL) {
            case NORMAL:
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
